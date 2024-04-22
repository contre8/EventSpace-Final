/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author adria
 */
@Entity
@Table(name = "propietario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Propietario.findAll", query = "SELECT p FROM Propietario p"),
    @NamedQuery(name = "Propietario.findByNombreespacio", query = "SELECT p FROM Propietario p WHERE p.nombreespacio = :nombreespacio"),
    @NamedQuery(name = "Propietario.findByEmail", query = "SELECT p FROM Propietario p WHERE p.email = :email"),
    @NamedQuery(name = "Propietario.findByPassword", query = "SELECT p FROM Propietario p WHERE p.password = :password"),
    @NamedQuery(name = "Propietario.findByCif", query = "SELECT p FROM Propietario p WHERE p.cif = :cif"),
    @NamedQuery(name = "Propietario.findByDomiciliosocial", query = "SELECT p FROM Propietario p WHERE p.domiciliosocial = :domiciliosocial"),
    @NamedQuery(name = "Propietario.findByTelefono", query = "SELECT p FROM Propietario p WHERE p.telefono = :telefono"),
    @NamedQuery(name = "Propietario.findByAutorizado", query = "SELECT p FROM Propietario p WHERE p.autorizado = :autorizado")})
public class Propietario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "nombreespacio")
    private String nombreespacio;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cif")
    private String cif;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "domiciliosocial")
    private String domiciliosocial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "telefono")
    private int telefono;
    @Basic(optional = false)
    @NotNull
    @Column(name = "autorizado")
    private boolean autorizado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "propietario")
    private Collection<Espacio> espacioCollection;

    public Propietario() {
    }

    public Propietario(String email) {
        this.email = email;
    }

    public Propietario(String email, String nombreespacio, String password, String cif, String domiciliosocial, int telefono, boolean autorizado) {
        this.email = email;
        this.nombreespacio = nombreespacio;
        this.password = password;
        this.cif = cif;
        this.domiciliosocial = domiciliosocial;
        this.telefono = telefono;
        this.autorizado = autorizado;
    }

    public String getNombreespacio() {
        return nombreespacio;
    }

    public void setNombreespacio(String nombreespacio) {
        this.nombreespacio = nombreespacio;
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
        this.password = password;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getDomiciliosocial() {
        return domiciliosocial;
    }

    public void setDomiciliosocial(String domiciliosocial) {
        this.domiciliosocial = domiciliosocial;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public boolean getAutorizado() {
        return autorizado;
    }

    public void setAutorizado(boolean autorizado) {
        this.autorizado = autorizado;
    }

    @XmlTransient
    public Collection<Espacio> getEspacioCollection() {
        return espacioCollection;
    }

    public void setEspacioCollection(Collection<Espacio> espacioCollection) {
        this.espacioCollection = espacioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (email != null ? email.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Propietario)) {
            return false;
        }
        Propietario other = (Propietario) object;
        if ((this.email == null && other.email != null) || (this.email != null && !this.email.equals(other.email))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entities.Propietario[ email=" + email + " ]";
    }
    
}
