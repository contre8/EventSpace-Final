/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.eventspace.entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author adria
 */
@Entity
@Table(name = "reservar_espacio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReservarEspacio.findAll", query = "SELECT r FROM ReservarEspacio r"),
    @NamedQuery(name = "ReservarEspacio.findById", query = "SELECT r FROM ReservarEspacio r WHERE r.reservarEspacioPK.id = :id"),
    @NamedQuery(name = "ReservarEspacio.findByCliente", query = "SELECT r FROM ReservarEspacio r WHERE r.reservarEspacioPK.cliente = :cliente"),
    @NamedQuery(name = "ReservarEspacio.findByEspacio", query = "SELECT r FROM ReservarEspacio r WHERE r.reservarEspacioPK.espacio = :espacio")})
public class ReservarEspacio implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ReservarEspacioPK reservarEspacioPK;
    @JoinColumn(name = "espacio", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Espacio espacio1;
    @JoinColumn(name = "cliente", referencedColumnName = "email", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Users users;

    public ReservarEspacio() {
    }

    public ReservarEspacio(ReservarEspacioPK reservarEspacioPK) {
        this.reservarEspacioPK = reservarEspacioPK;
    }

    public ReservarEspacio(int id, String cliente, int espacio) {
        this.reservarEspacioPK = new ReservarEspacioPK(id, cliente, espacio);
    }

    public ReservarEspacioPK getReservarEspacioPK() {
        return reservarEspacioPK;
    }

    public void setReservarEspacioPK(ReservarEspacioPK reservarEspacioPK) {
        this.reservarEspacioPK = reservarEspacioPK;
    }

    public Espacio getEspacio1() {
        return espacio1;
    }

    public void setEspacio1(Espacio espacio1) {
        this.espacio1 = espacio1;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reservarEspacioPK != null ? reservarEspacioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReservarEspacio)) {
            return false;
        }
        ReservarEspacio other = (ReservarEspacio) object;
        if ((this.reservarEspacioPK == null && other.reservarEspacioPK != null) || (this.reservarEspacioPK != null && !this.reservarEspacioPK.equals(other.reservarEspacioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.eventspace.entities.ReservarEspacio[ reservarEspacioPK=" + reservarEspacioPK + " ]";
    }
    
}
