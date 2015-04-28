/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja.dao;

import entity.bean.Cliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author cbsantos
 */
@Stateless(mappedName = "ClienteDAOImpl")
public class ClienteDAOImpl implements ClienteDAO {

    private static final String PERSISTENCE_UNIT_NAME = "Loja-ejbPU";
    private static EntityManagerFactory factory;
    private static EntityManager em;

    @Override
    public List<Cliente> listar() {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        em = factory.createEntityManager();
        
//        em = Singleton.getInstance().getEntityManager();
        Query query = em.createNamedQuery("Cliente.findAll");
    
        List<Cliente> listaCliente = query.getResultList();
        return listaCliente;
    }

    @Override
    public void inserir(Cliente e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(Cliente e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(Cliente e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
