/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.matercero.ec.hibernate;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author mangel.tercero
 */
@Entity
@Table(name = "seguimiento_componente")
public class SeguimientoComponente implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @JoinColumn(name = "id_componente")
    @ManyToOne
    private Componente componente;
   
    @Id
    @JoinColumn(name = "id_seguimiento")
    @ManyToOne
    private Seguimiento seguimiento;
   

    @Column(name = "cantidad")
    private int cantidad;    
    @Column(name = "fecha_entrega")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEntrega;    
    @Column(name = "fecha_pedido")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPedido;    
    @Column(name = "numero_factura")
    private String numeroFactura;    
    @Column(name = "observaciones")
    private String observaciones;

    public SeguimientoComponente() {
    }

  
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Componente getComponente() {
        return componente;
    }

    public void setComponente(Componente componente) {
        this.componente = componente;
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + (this.componente != null ? this.componente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SeguimientoComponente other = (SeguimientoComponente) obj;
        if (this.componente != other.componente && (this.componente == null || !this.componente.equals(other.componente))) {
            return false;
        }
      
        return true;
    }

    @Override
    public String toString() {
        return "SeguimientoComponente{" + "componente=" + componente.getNombre() + "}";
    }

    /**
     * @return the seguimiento
     */
    public Seguimiento getSeguimiento() {
        return seguimiento;
    }

    /**
     * @param seguimiento the seguimiento to set
     */
    public void setSeguimiento(Seguimiento seguimiento) {
        this.seguimiento = seguimiento;
    }
    

}
