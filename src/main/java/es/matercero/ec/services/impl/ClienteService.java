/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.matercero.ec.services.impl;

import es.matercero.ec.daos.IDao;
import es.matercero.ec.hibernate.Cliente;
import es.matercero.ec.services.IClienteService;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author mangel.tercero
 */
@Service("clienteService")
@Transactional
public class ClienteService implements IClienteService, Serializable {

    /**
     * * serialVersionUID
     */
    private static final long serialVersionUID = 1L;
    @Autowired
    private IDao<Cliente> clienteDao;

    public ClienteService() {
    }

    /**
     * @return the clienteDao
     */
    public IDao<Cliente> getClienteDao() {
        return clienteDao;
    }

    /**
     * @param clienteDao the clienteDao to set
     */
    public void setClienteDao(IDao<Cliente> clienteDao) {
        this.clienteDao = clienteDao;
    }

    @Override
    public List<Cliente> queryAllClientes() {
        DetachedCriteria dc = DetachedCriteria.forClass(Cliente.class, "cliente");
        dc.addOrder(Order.asc("nombre"));
        dc.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return getClienteDao().find(dc);
    }

    @Override
    public void createCliente(Cliente entity) {
      getClienteDao().save(entity);
    }

    @Override
    public void updateCliente(Cliente entity) {
        getClienteDao().update(entity);
    }
    
}
