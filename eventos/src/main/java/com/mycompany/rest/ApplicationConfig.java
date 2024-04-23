/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rest;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author adria
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.mycompany.json.PropReader.class);
        resources.add(com.mycompany.json.PropWriter.class);
        resources.add(com.mycompany.rest.AdministradorFacadeREST.class);
        resources.add(com.mycompany.rest.ClienteFacadeREST.class);
        resources.add(com.mycompany.rest.EspacioFacadeREST.class);
        resources.add(com.mycompany.rest.PropietarioFacadeREST.class);
        resources.add(com.mycompany.rest.ReservarEspacioFacadeREST.class);
    }
    
}
