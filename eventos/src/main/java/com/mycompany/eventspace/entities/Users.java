/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.eventspace.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author adria
 */
@Entity
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findByNombre", query = "SELECT u FROM Users u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "Users.findByApellidos", query = "SELECT u FROM Users u WHERE u.apellidos = :apellidos"),
    @NamedQuery(name = "Users.findByEmail", query = "SELECT u FROM Users u WHERE u.email = :email"),
    @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password"),
    @NamedQuery(name = "Users.findByDni", query = "SELECT u FROM Users u WHERE u.dni = :dni"),
    @NamedQuery(name = "Users.findByNacimiento", query = "SELECT u FROM Users u WHERE u.nacimiento = :nacimiento"),
    @NamedQuery(name = "Users.findByTelefono", query = "SELECT u FROM Users u WHERE u.telefono = :telefono"),
    @NamedQuery(name = "Users.findByEspacio", query = "SELECT u FROM Users u WHERE u.espacio = :espacio"),
    @NamedQuery(name = "Users.findByDomicilio", query = "SELECT u FROM Users u WHERE u.domicilio = :domicilio"),
    @NamedQuery(name = "Users.findByAutorizado", query = "SELECT u FROM Users u WHERE u.autorizado = :autorizado")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 64)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 128)
    @Column(name = "apellidos")
    private String apellidos;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "email")
    private String email;
    @Size(max = 64)
    @Column(name = "password")
    private String password;
    @Size(max = 9)
    @Column(name = "dni")
    private String dni;
    @Column(name = "nacimiento")
    @Temporal(TemporalType.DATE)
    private Date nacimiento;
    @Column(name = "telefono")
    private Integer telefono;
    @Size(max = 256)
    @Column(name = "espacio")
    private String espacio;
    @Size(max = 256)
    @Column(name = "domicilio")
    private String domicilio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "autorizado")
    private boolean autorizado;
    @OneToMany(mappedBy = "propietario")
    private Collection<Espacio> espacioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users")
    private Collection<ReservarEspacio> reservarEspacioCollection;

    public Users() {
    }

    public Users(String email) {
        this.email = email;
    }

    public Users(String email, boolean autorizado) {
        this.email = email;
        this.autorizado = autorizado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getEspacio() {
        return espacio;
    }

    public void setEspacio(String espacio) {
        this.espacio = espacio;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
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

    @XmlTransient
    public Collection<ReservarEspacio> getReservarEspacioCollection() {
        return reservarEspacioCollection;
    }

    public void setReservarEspacioCollection(Collection<ReservarEspacio> reservarEspacioCollection) {
        this.reservarEspacioCollection = reservarEspacioCollection;
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
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.email == null && other.email != null) || (this.email != null && !this.email.equals(other.email))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.eventspace.entities.Users[ email=" + email + " ]";
    }
    
}
