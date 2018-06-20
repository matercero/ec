/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.matercero.ec.hibernate;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author mangel.tercero
 */
@Entity
@Table(name = "componente")
public class Componente implements Serializable {

    private static final long serialVersionUID = 1L;

    @OneToMany(mappedBy = "componente")
    private Set<SeguimientoComponente> seguimientoComponenteSet;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "coste")
    private Double coste;
    @Column(name = "date_created")
    @Temporal(TemporalType.DATE)
    private Date dateCreated;
    @Column(name = "enabled")
    private boolean enabled;
    @Column(name = "last_updated")
    @Temporal(TemporalType.DATE)
    private Date lastUpdated;
    @Column(name = "defecto")
    private boolean defecto;

    public Componente() {
    }

    public Componente(Long id) {
        this.id = id;
    }

    public Componente(Long id, Date dateCreated, boolean enabled, Date lastUpdated, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.dateCreated = dateCreated;
        this.enabled = enabled;
        this.lastUpdated = lastUpdated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getCoste() {
        return coste;
    }

    public void setCoste(Double coste) {
        this.coste = coste;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        if (!(object instanceof Componente)) {
            return false;
        }
        Componente other = (Componente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre;
    }

    /**
     * @return the defecto
     */
    public boolean isDefecto() {
        return defecto;
    }

    /**
     * @param defecto the defecto to set
     */
    public void setDefecto(boolean defecto) {
        this.defecto = defecto;
    }

    /**
     * @return the seguimientoComponenteSet
     */
    public Set<SeguimientoComponente> getSeguimientoComponenteSet() {
        return seguimientoComponenteSet;
    }

    /**
     * @param seguimientoComponenteSet the seguimientoComponenteSet to set
     */
    public void setSeguimientoComponenteSet(Set<SeguimientoComponente> seguimientoComponenteSet) {
        this.seguimientoComponenteSet = seguimientoComponenteSet;
    }

}
