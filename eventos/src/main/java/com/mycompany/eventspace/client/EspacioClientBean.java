/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.eventspace.client;

import com.mycompany.eventspace.entities.Espacio;
import com.mycompany.eventspace.jaas.LoginView;
import com.mycompany.eventspace.json.EspacioReader;
import com.mycompany.eventspace.json.EspacioWriter;
import java.util.Collections;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author adria
 */
@Named
@RequestScoped
public class EspacioClientBean {

    Client client;
    WebTarget target;

    @PostConstruct
    public void init() {
        client = ClientBuilder.newClient();
        target
                = client.target("http://localhost:8080/eventSpace/webresources/com.mycompany.eventspace.entities.espacio");
    }

    @PreDestroy
    public void destroy() {
        client.close();
    }

    public Espacio[] getEspacios() {
        return target
                .request()
                .get(Espacio[].class);
    }

    @PersistenceContext
    EntityManager em;

    @Inject
    EspacioBackingBean bean;
    
    @Inject
    LoginView bean2;

    public List getEspaciosPropietario3() {
        try {
            return em.createQuery("SELECT e FROM Espacio e WHERE e.propietario.email = :email", com.mycompany.eventspace.entities.Espacio.class)
                    .setParameter("email", bean2.getEmail())
                    .getResultList();
        } catch (NoResultException e) {
            return Collections.emptyList(); // Devuelve una lista vacía si no se encuentran resultados
        }
    }
    
    public List<Espacio> getEspaciosPropietario() {
        try {
            return em.createQuery("SELECT e FROM Espacio e WHERE e.propietario = :email", Espacio.class)
                    .setParameter("email", bean2.getEmail())
                    .getResultList();
        } catch (NoResultException e) {
            return Collections.emptyList(); // Devuelve una lista vacía si no se encuentran resultados
        }
    }

    public Espacio getEspacio() {
        Espacio e = target
                .register(EspacioReader.class)
                .path("{espId}")
                .resolveTemplate("espId", bean.getEspId())
                .request(MediaType.APPLICATION_JSON)
                .get(Espacio.class);
        return e;
    }

    public void deleteEspacio() {
        target.path("{espId}")
                .resolveTemplate("espId", bean.getEspId())
                .request()
                .delete();
    }

    public void addEspacio() {
        Espacio m = new Espacio();
        m.setCiudad(bean.getCiudad());
        m.setDireccion(bean.getDireccion());
        m.setNombre(bean.getNombre());
        m.setHorarioini(bean.getHoraIni());
        m.setHorariofin(bean.getHoraFin());
        m.setPrecio(bean.getPrecio());
        m.setSalones(bean.getSalones());
        target.register(EspacioWriter.class)
                .request()
                .post(Entity.entity(m, MediaType.APPLICATION_JSON));
    }
}
