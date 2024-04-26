/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.eventspace.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
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
@Table(name = "espacio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Espacio.findAll", query = "SELECT e FROM Espacio e"),
    @NamedQuery(name = "Espacio.findById", query = "SELECT e FROM Espacio e WHERE e.id = :id"),
    @NamedQuery(name = "Espacio.findByNombre", query = "SELECT e FROM Espacio e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Espacio.findByCiudad", query = "SELECT e FROM Espacio e WHERE e.ciudad = :ciudad"),
    @NamedQuery(name = "Espacio.findByDireccion", query = "SELECT e FROM Espacio e WHERE e.direccion = :direccion"),
    @NamedQuery(name = "Espacio.findBySalones", query = "SELECT e FROM Espacio e WHERE e.salones = :salones"),
    @NamedQuery(name = "Espacio.findByPrecio", query = "SELECT e FROM Espacio e WHERE e.precio = :precio"),
    @NamedQuery(name = "Espacio.findByFecha", query = "SELECT e FROM Espacio e WHERE e.fecha = :fecha"),
    @NamedQuery(name = "Espacio.findByHorarioini", query = "SELECT e FROM Espacio e WHERE e.horarioini = :horarioini"),
    @NamedQuery(name = "Espacio.findByHorariofin", query = "SELECT e FROM Espacio e WHERE e.horariofin = :horariofin")})
public class Espacio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 128)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 128)
    @Column(name = "ciudad")
    private String ciudad;
    @Size(max = 256)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "salones")
    private int salones;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio")
    private BigDecimal precio;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 5)
    @Column(name = "horarioini")
    private String horarioini;
    @Size(max = 5)
    @Column(name = "horariofin")
    private String horariofin;
    @JoinColumn(name = "propietario", referencedColumnName = "email")
    @ManyToOne
    private Users propietario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "espacio1")
    private Collection<ReservarEspacio> reservarEspacioCollection;

    public Espacio() {
    }

    public Espacio(Integer id) {
        this.id = id;
    }

    public Espacio(Integer id, int salones) {
        this.id = id;
        this.salones = salones;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public int getSalones() {
        return salones;
    }

    public void setSalones(int salones) {
        this.salones = salones;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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

    public Users getPropietario() {
        return propietario;
    }

    public void setPropietario(Users propietario) {
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
        return "com.mycompany.eventspace.entities.Espacio[ id=" + id + " ]";
    }
    
}
