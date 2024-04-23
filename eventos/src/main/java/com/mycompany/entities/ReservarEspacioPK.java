/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author adria
 */
@Embeddable
public class ReservarEspacioPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "cliente")
    private String cliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "espacio")
    private int espacio;

    public ReservarEspacioPK() {
    }

    public ReservarEspacioPK(int id, String cliente, int espacio) {
        this.id = id;
        this.cliente = cliente;
        this.espacio = espacio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getEspacio() {
        return espacio;
    }

    public void setEspacio(int espacio) {
        this.espacio = espacio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (cliente != null ? cliente.hashCode() : 0);
        hash += (int) espacio;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReservarEspacioPK)) {
            return false;
        }
        ReservarEspacioPK other = (ReservarEspacioPK) object;
        if (this.id != other.id) {
            return false;
        }
        if ((this.cliente == null && other.cliente != null) || (this.cliente != null && !this.cliente.equals(other.cliente))) {
            return false;
        }
        if (this.espacio != other.espacio) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entities.ReservarEspacioPK[ id=" + id + ", cliente=" + cliente + ", espacio=" + espacio + " ]";
    }
    
}
