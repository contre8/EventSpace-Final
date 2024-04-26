/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.eventspace.reserva;

import com.mycompany.eventspace.entities.Espacio;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.flow.FlowScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author adria
 */
@Named
@FlowScoped("reserva")
public class Reserva implements Serializable {

    int espId;
    String ciudad;
    Date fecha;
    private String tarjeta = "";

    @PersistenceContext
    EntityManager em;

    public List<Espacio> getCiudades() {
        try {
            return em.createNamedQuery("Espacio.findByCiudad", Espacio.class)
                    .setParameter("ciudad", ciudad)
                    .getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    public Espacio getEspacio() {
        try {
            return em.createNamedQuery("Espacio.findById", Espacio.class)
                    .setParameter("id", espId)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public int getEspId() {
        return espId;
    }

    public void setEspId(int espId) {
        this.espId = espId;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }
    
    
}
