/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja.dao;

import bean.exceptions.DupValOnIndexException;
import bean.singleton.EntityManagerSingleton;
import entity.bean.Carrinho;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;

/**
 *
 * @author caioboratto
 */
public class CarrinhoDAOImpl implements CarrinhoDAO {

    private static EntityManager em;

    @Override
    public List<Carrinho> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inserir(Carrinho e) throws DupValOnIndexException {
        try {
            em = EntityManagerSingleton.getInstance().getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CarrinhoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(CarrinhoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                throw ex;
            }
        }
    }

    @Override
    public void alterar(Carrinho e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(Carrinho e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
