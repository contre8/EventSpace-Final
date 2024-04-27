/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.eventspace.json;

import java.io.Serializable;
import javax.inject.Named;

/**
 *
 * @author adria
 */
@Named
public class Tarjeta implements Serializable{

    private String numero;
    private boolean autorizada;

    // Constructor vacío
    public Tarjeta() {
    }

    // Constructor con todos los atributos
    public Tarjeta(String numero, boolean autorizada) {
        this.numero = numero;
        this.autorizada = autorizada;
    }

    // Métodos getters y setters
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public boolean isAutorizada() {
        return autorizada;
    }

    public void setAutorizada(boolean autorizada) {
        this.autorizada = autorizada;
    }

    // Método toString para representar la Tarjeta como una cadena
    @Override
    public String toString() {
        return "Tarjeta{"
                + "numero='" + numero + '\''
                + ", autorizada=" + autorizada
                + '}';
    }
}
