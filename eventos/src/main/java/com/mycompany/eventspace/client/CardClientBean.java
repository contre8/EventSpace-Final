/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.eventspace.client;

import com.mycompany.eventspace.json.CardReader;
import com.mycompany.eventspace.json.Tarjeta;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author adria
 */
@Named
@RequestScoped
public class CardClientBean {

    Client client;
    WebTarget target;

    @PostConstruct
    public void init() {
        client = ClientBuilder.newClient();
        target
                = client.target("http://serpis.infor.uva.es:80/pf2024_rest_cards/");
    }

    @PreDestroy
    public void destroy() {
        client.close();
    }

    @Inject
    CardBackingBean bean;
    
    public Tarjeta getTarjeta() {
        Tarjeta e = target
                .register(CardReader.class)
                .resolveTemplate("autorizada", bean.isAutorizada())
                .request(MediaType.APPLICATION_JSON)
                .get(Tarjeta.class);
        return e;
    }
}
