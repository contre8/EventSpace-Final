/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cli;

import com.mycompany.entities.Cliente;
import com.mycompany.entities.Propietario;
import com.mycompany.json.CliWriter;
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

/**
 *
 * @author adria
 */
@Named
@RequestScoped
public class CliClientBean {

    Client client;
    WebTarget target;

    @PostConstruct
    public void init() {
        client = ClientBuilder.newClient();
        target
                = client.target("http://localhost:8080/final/webresources/com.mycompany.entities.cliente");
    }

    @PreDestroy
    public void destroy() {
        client.close();
    }

    public Cliente[] getClientes() {
        return target
                .request()
                .get(Cliente[].class);
    }

    @Inject
    CliBackingBean bean;

    public Cliente getCliente() {
        Cliente c = target
                .path("{email}")
                .resolveTemplate("email", bean.getEmail())
                .request()
                .get(Cliente.class);
        return c;
    }

    public void deleteCli() {
        target.path("{email}")
                .resolveTemplate("email", bean.getEmail())
                .request()
                .delete();
    }

    public void addCliente() {
        Cliente cliente = new Cliente();
        cliente.setNombre(bean.getNombre());
        cliente.setApellidos(bean.getApellido());
        cliente.setEmail(bean.getEmail());
        cliente.setPassword(bean.getPassword());
        cliente.setDni(bean.getDni());
        cliente.setFechanacimiento(bean.getFechanacimiento());
        cliente.setTelefono(bean.getTelefono());

        target.register(CliWriter.class)
                .request()
                .post(Entity.entity(cliente, MediaType.APPLICATION_JSON));
    }
}
