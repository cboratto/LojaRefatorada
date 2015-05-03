/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja.dao;

import bean.exceptions.DupValOnIndexException;
import bean.singleton.EntityManagerSingleton;
import entity.bean.Cliente;
import entity.bean.Login;
import entity.bean.Produto;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author caioboratto
 */
public class ProdutoDAOImpl implements ProdutoDAO {

    private static EntityManager em;

    @Override
    public List<Produto> listar() {
        try {
            em = EntityManagerSingleton.getInstance().getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<Produto> listaProdutos = new ArrayList<Produto>();

        Query query = em.createNamedQuery("Produto.findAll");
        listaProdutos = query.getResultList();

        return listaProdutos;
    }

    @Override
    public void inserir(Produto e) throws DupValOnIndexException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(Produto e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(Produto e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
