/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.prop;

import com.mycompany.entities.Propietario;
import com.mycompany.json.PropWriter;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author adria
 */
@Named
@RequestScoped
public class PropClientBean {

    Client client;
    WebTarget target;

    @PostConstruct
    public void init() {
        client = ClientBuilder.newClient();
        target
                = client.target("http://localhost:8080/final/webresources/com.mycompany.entities.propietario");
    }

    @PreDestroy
    public void destroy() {
        client.close();
    }

    public Propietario[] getProps() {
        return target
                .request()
                .get(Propietario[].class);
    }

    @Inject
    PropBackingBean bean;

    public Propietario getProp() {
        Propietario p = target
                .path("{email}")
                .resolveTemplate("email", bean.getEmail())
                .request()
                .get(Propietario.class);
        return p;
    }

    public void deleteProp() {
        target.path("{email}")
                .resolveTemplate("email", bean.getEmail())
                .request()
                .delete();
    }

    public void addProp() {
        Propietario prop = new Propietario();
        prop.setNombreespacio(bean.getNombreEspacio());
        prop.setEmail(bean.getEmail());
        prop.setPassword(bean.getPassword());
        prop.setCif(bean.getCif());
        prop.setDomiciliosocial(bean.getDomicilioSocial());
        prop.setTelefono(bean.getTelefono());

        target.register(PropWriter.class)
                .request()
                .post(Entity.entity(prop, MediaType.APPLICATION_JSON));
    }

    public void autorizarProp() {
        Propietario prop = getProp();
        prop.setAutorizado(true);

        Response response = null;
        try {
            response = target
                    .path("{email}")
                    .resolveTemplate("email", prop.getEmail())
                    .request()
                    .put(Entity.entity(prop, MediaType.APPLICATION_JSON));

            if (response.getStatus() == Response.Status.OK.getStatusCode()) {
                // La actualización fue exitosa
                System.out.println("Propietario autorizado exitosamente.");
                // Aquí podrías mostrar un mensaje de éxito en la interfaz de usuario
            } else {
                // Hubo un error en la actualización
                System.err.println("Error al autorizar el propietario. Código de estado: " + response.getStatus());
                // Aquí podrías mostrar un mensaje de error en la interfaz de usuario
            }
        } catch (Exception e) {
            // Manejar cualquier excepción que pueda ocurrir
            e.printStackTrace();
            System.err.println("Error al autorizar el propietario: " + e.getMessage());
            // Aquí podrías mostrar un mensaje de error en la interfaz de usuario
        } finally {
            if (response != null) {
                response.close();
            }
        }
    }
}
