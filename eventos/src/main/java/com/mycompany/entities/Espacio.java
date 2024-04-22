/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "espacio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Espacio.findAll", query = "SELECT e FROM Espacio e"),
    @NamedQuery(name = "Espacio.findById", query = "SELECT e FROM Espacio e WHERE e.id = :id"),
    @NamedQuery(name = "Espacio.findByNombreespacio", query = "SELECT e FROM Espacio e WHERE e.nombreespacio = :nombreespacio"),
    @NamedQuery(name = "Espacio.findByCiudad", query = "SELECT e FROM Espacio e WHERE e.ciudad = :ciudad"),
    @NamedQuery(name = "Espacio.findByDireccion", query = "SELECT e FROM Espacio e WHERE e.direccion = :direccion"),
    @NamedQuery(name = "Espacio.findByNumsalones", query = "SELECT e FROM Espacio e WHERE e.numsalones = :numsalones"),
    @NamedQuery(name = "Espacio.findByPrecio", query = "SELECT e FROM Espacio e WHERE e.precio = :precio"),
    @NamedQuery(name = "Espacio.findByHorarioini", query = "SELECT e FROM Espacio e WHERE e.horarioini = :horarioini"),
    @NamedQuery(name = "Espacio.findByHorariofin", query = "SELECT e FROM Espacio e WHERE e.horariofin = :horariofin")})
public class Espacio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "nombreespacio")
    private String nombreespacio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "ciudad")
    private String ciudad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numsalones")
    private int numsalones;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private BigDecimal precio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "horarioini")
    private String horarioini;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "horariofin")
    private String horariofin;
    @JoinColumn(name = "propietario", referencedColumnName = "email")
    @ManyToOne(optional = false)
    private Propietario propietario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "espacio1")
    private Collection<ReservarEspacio> reservarEspacioCollection;

    public Espacio() {
    }

    public Espacio(Integer id) {
        this.id = id;
    }

    public Espacio(Integer id, String nombreespacio, String ciudad, String direccion, int numsalones, BigDecimal precio, String horarioini, String horariofin) {
        this.id = id;
        this.nombreespacio = nombreespacio;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.numsalones = numsalones;
        this.precio = precio;
        this.horarioini = horarioini;
        this.horariofin = horariofin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreespacio() {
        return nombreespacio;
    }

    public void setNombreespacio(String nombreespacio) {
        this.nombreespacio = nombreespacio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNumsalones() {
        return numsalones;
    }

    public void setNumsalones(int numsalones) {
        this.numsalones = numsalones;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getHorarioini() {
        return horarioini;
    }

    public void setHorarioini(String horarioini) {
        this.horarioini = horarioini;
    }

    public String getHorariofin() {
        return horariofin;
    }

    public void setHorariofin(String horariofin) {
        this.horariofin = horariofin;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Espacio)) {
            return false;
        }
        Espacio other = (Espacio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entities.Espacio[ id=" + id + " ]";
    }
    
}
