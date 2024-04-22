/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.login;

import com.mycompany.entities.Administrador;
import com.mycompany.entities.Cliente;
import com.mycompany.entities.Propietario;
import com.mycompany.rest.AdministradorFacadeREST;
import com.mycompany.rest.ClienteFacadeREST;
import com.mycompany.rest.PropietarioFacadeREST;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author adria
 */
@Named
@SessionScoped
public class Login implements Serializable {

    @EJB
    private AdministradorFacadeREST adminFacade;
    
    @EJB
    private PropietarioFacadeREST propFacade;
    
    @EJB
    private ClienteFacadeREST cliFacade;

    private String username;
    private String password;

    public String login() {
        FacesContext context = FacesContext.getCurrentInstance();
        
        // Verificar si el usuario es administrador
        Administrador admin = adminFacade.find(username);
        System.out.println(adminFacade.find(username));
        if (admin != null) {
            // Iniciar sesión como administrador
            return "http://localhost:8080/eventos/faces/index.xhtml?faces-redirect=true";
        }
        
        // Verificar si el usuario es propietario
        Propietario prop = propFacade.find(username);
        if (prop != null && prop.getPassword().equals(password)) {
            // Iniciar sesión como propietario
            return "http://localhost:8080/eventos/faces/index.xhtml?faces-redirect=true";
        }
        
        // Verificar si el usuario es cliente
        Cliente cli = cliFacade.find(username);
        if (cli != null && cli.getPassword().equals(password)) {
            // Iniciar sesión como cliente
            return "http://localhost:8080/eventos/faces/index.xhtml?faces-redirect=true";
        }

        // Si no se encuentra ningún usuario con las credenciales proporcionadas
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Credenciales inválidas"));
        return null;
    }

    public AdministradorFacadeREST getAdminFacade() {
        return adminFacade;
    }

    public void setAdminFacade(AdministradorFacadeREST adminFacade) {
        this.adminFacade = adminFacade;
    }

    public PropietarioFacadeREST getPropFacade() {
        return propFacade;
    }

    public void setPropFacade(PropietarioFacadeREST propFacade) {
        this.propFacade = propFacade;
    }

    public ClienteFacadeREST getCliFacade() {
        return cliFacade;
    }

    public void setCliFacade(ClienteFacadeREST cliFacade) {
        this.cliFacade = cliFacade;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
}
