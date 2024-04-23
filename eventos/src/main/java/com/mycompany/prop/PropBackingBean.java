/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.prop;

import com.mycompany.entities.Propietario;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author adria
 */
@Named
@SessionScoped
public class PropBackingBean implements Serializable {

    String nombreEspacio;
    String email;
    String password;
    String cif;
    String domicilioSocial;
    int telefono;

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

    public String getNombreEspacio() {
        return nombreEspacio;
    }

    public void setNombreEspacio(String nombreEspacio) {
        this.nombreEspacio = nombreEspacio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = encryptPassword(password);
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getDomicilioSocial() {
        return domicilioSocial;
    }

    public void setDomicilioSocial(String domicilioSocial) {
        this.domicilioSocial = domicilioSocial;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

}
