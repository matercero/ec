/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.matercero.ec.services;

import es.matercero.ec.hibernate.Categoria;
import es.matercero.ec.hibernate.Componente;
import es.matercero.ec.hibernate.Pago;
import es.matercero.ec.hibernate.Proveedor;
import es.matercero.ec.hibernate.Seguimiento;
import java.util.List;

/**
 *
 * @author mangel.tercero
 */
public interface IMantenimientoService {

    /**
     * Categorias
     */
    void createCategoria(Categoria entity);

    void updateCategoria(Categoria entity);

    List<Categoria> queryAllCategorias();

    /**
     * Componente
     *
     * @return
     */
    List<Componente> queryAllComponentes();

    void createComponente(Componente entity);

    void updateComponente(Componente entity);

    /**
     * Pago
     *
     * @param entity Pago
     */
    List<Pago> queryAllPagos();

    void createPago(Pago entity);

    void updatePago(Pago entity);

    /**
     * seguimiento
     *
     * @param entity seguimiento
     */
    List<Seguimiento> queryAllSeguimientos();

    void createSeguimiento(Seguimiento entity);

    void updateSeguimiento(Seguimiento entity);

    List<Componente> queryAllComponentesPorDefecto();
}
