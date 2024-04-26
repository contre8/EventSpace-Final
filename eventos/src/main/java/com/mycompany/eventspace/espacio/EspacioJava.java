/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.eventspace.espacio;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author adria
 */

@Named
@SessionScoped
public class EspacioJava implements Serializable{
    
    @PersistenceContext
    EntityManager em;
    
    
    public List getEspaciosPropietario3() {
        try {
            return em.createQuery("SELECT e FROM Espacio e WHERE e.propietario.email = :email", com.mycompany.eventspace.entities.Espacio.class)
                    .setParameter("email", "propietario3@example.com")
                    .getResultList();
        } catch (NoResultException e) {
            return Collections.emptyList(); // Devuelve una lista vacía si no se encuentran resultados
        }
    }
}
