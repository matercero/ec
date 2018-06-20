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
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mangel.tercero
 */
@Entity
@Table(name = "seguimiento")
public class Seguimiento implements Serializable {
/**
 * @Table maps the entity with the table. If no @Table is defined, 
 * the default value is used: the class name of the entity.
 * @Id declares the identifier property of the entity.
 * @Column maps the entity's field with the table's column. 
 *  If @Column is omitted, the default value is used: the field name of the entity.
 * @ManyToOne defines a many-to-one relationship between 2 entities. 
 * @JoinColumn indicates the entity is the owner of the relationship: 
 *      the corresponding table has a column with a foreign key to the referenced table. 
 *  mappedBy indicates the entity is the inverse of the relationship.
 */
    
    @OneToMany(mappedBy = "seguimiento")
    private Set<SeguimientoComponente> seguimientoComponenteSet;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "color")
    private String color;    
    @Column(name = "date_created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;    
    @Column(name = "enabled")
    private boolean enabled;    
    @Column(name = "last_updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdated;
    @Column(name = "modelo")
    private String modelo;
    @Column(name = "observacion")
    private String observacion;


    public Seguimiento() {
    }

    public Seguimiento(Long id) {
        this.id = id;
    }

    public Seguimiento(Long id, Date dateCreated, boolean enabled, Date lastUpdated) {
        this.id = id;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
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
        if (!(object instanceof Seguimiento)) {
            return false;
        }
        Seguimiento other = (Seguimiento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return id + " - " + modelo;
    }

    @XmlTransient
    public Set<SeguimientoComponente> getSeguimientoComponenteSet() {
        return seguimientoComponenteSet;
    }

    public void setSeguimientoComponenteSet(Set<SeguimientoComponente> seguimientoComponenteSet) {
        this.seguimientoComponenteSet = seguimientoComponenteSet;
    }
  
    
    
}
