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
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
    private boolean logged = false;
    private String rol;

    public boolean login() {
        FacesContext context = FacesContext.getCurrentInstance();
        
        // Verificar si el usuario es administrador
        Propietario prop = propFacade.find(username);
        Administrador admin = adminFacade.find(username);
        Cliente cli = cliFacade.find(username);
        if (admin != null && admin.getPassword().equals(encryptPassword(password))) {
            // Iniciar sesión como administrador
            logged=true;
            rol="admin";
            return true;
        }
        
        // Verificar si el usuario es propietario
        
        else if (prop != null && encryptPassword(password).equals(prop.getPassword())) {
            // Iniciar sesión como propietario
            logged=true;
            rol="prop";
            return true;
        }
        
        // Verificar si el usuario es cliente
        
        else if (cli != null && encryptPassword(password).equals(cli.getPassword())) {
            // Iniciar sesión como cliente
            logged=true;
            rol="cli";
            return true;
        }

        // Si no se encuentra ningún usuario con las credenciales proporcionadas
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Credenciales inválidas"));
        return false;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }
    
    public static String encryptPassword(String input) {
        try {
            // Obtener una instancia de MessageDigest para MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Convertir la entrada a bytes usando UTF-8
            byte[] inputBytes = input.getBytes(StandardCharsets.UTF_8);

            // Calcular el hash MD5
            byte[] hashBytes = md.digest(inputBytes);

            // Convertir el hash a una representación hexadecimal
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xFF & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
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
