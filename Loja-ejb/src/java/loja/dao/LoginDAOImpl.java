/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja.dao;

import bean.singleton.EntityManagerSingleton;
import entity.bean.Login;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;

/**
 *
 * @author caioboratto
 */
public class LoginDAOImpl implements LoginDAO {

    EntityManager em;

    @Override
    public List<Login> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inserir(Login e) {
        try {
            em = EntityManagerSingleton.getInstance().getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginDAOImpl.class.getName()).log(Level.SEVERE, null, ex);            
        }

        try {
            em.getTransaction().begin();
            em.persist(e);
            em.getTransaction().commit();

        } catch (Exception ex) {
            em.getTransaction().rollback();
            Logger.getLogger(LoginDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        em.close();
    }

    @Override
    public void alterar(Login e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(Login e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
