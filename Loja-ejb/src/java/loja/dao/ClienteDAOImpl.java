/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja.dao;

import bean.exceptions.DupValOnIndexException;
import bean.singleton.EntityManagerSingleton;
import org.hibernate.exception.ConstraintViolationException;
import entity.bean.Cliente;
import entity.bean.Login;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    private static EntityManager em;

    @Override
    public List<Cliente> listar() {
        try {
            em = EntityManagerSingleton.getInstance().getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        //valida se o usuário já esta cadastrado na base
        Query query = em.createNamedQuery("Cliente.findAll");
        List<Cliente> listaCliente = query.getResultList();
        return listaCliente;
    }

    public Cliente listarPorCpf(String numcpf) {
        try {
            em = EntityManagerSingleton.getInstance().getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        //valida se o usuário já esta cadastrado na base
        Query query = em.createNamedQuery("Cliente.findByCpf");
        Cliente cliente = (Cliente) query.setParameter("numcpf", numcpf).getSingleResult();
        return cliente;
    }

    public Cliente listarPorLogin(Login login) {
        try {
            em = EntityManagerSingleton.getInstance().getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        Login consultaLogin;
        Cliente consultaCliente;

        //valida se o usuário já esta cadastrado na base
        Query query = em.createNamedQuery("Login.findByNamLogin");

        query = query.setParameter("namLogin", login.getNamLogin());
        consultaLogin = (Login) query.setParameter("desPassword", login.getDesPassword()).getSingleResult();
        
        
        query = em.createNamedQuery("Cliente.findByIdCliente");
        consultaCliente = (Cliente) query.setParameter("idCliente", consultaLogin.getCliente().getIdCliente()).getSingleResult();

        consultaCliente.setLogin(consultaLogin);
        consultaLogin.setCliente(consultaCliente);

        return consultaCliente;
    }

    @Override
    public void inserir(Cliente e) throws DupValOnIndexException {
        try {
            em = EntityManagerSingleton.getInstance().getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            em.getTransaction().begin();
            em.persist(e);
            em.getTransaction().commit();

        } catch (Exception ex) {
            if (ex instanceof SQLException) {
                throw new DupValOnIndexException();
            } else {
                em.getTransaction().rollback();
                Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                throw ex;
            }
        }
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
