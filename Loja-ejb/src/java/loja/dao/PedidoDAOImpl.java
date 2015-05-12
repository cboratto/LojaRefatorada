/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja.dao;

import bean.exceptions.DupValOnIndexException;
import bean.singleton.EntityManagerSingleton;
import entity.bean.Carrinho;
import entity.bean.Pedido;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;

/**
 *
 * @author caioboratto
 */
public class PedidoDAOImpl implements PedidoDAO {

    private static EntityManager em;

    @Override
    public List<Pedido> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inserir(Pedido e) throws DupValOnIndexException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(Pedido e
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(Pedido e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer inserirRetorna(Pedido p) {
        try {
            em = EntityManagerSingleton.getInstance().getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PedidoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        Carrinho carrinho = p.getIdCarrinho();
        try {
            em.getTransaction().begin();
            em.persist(carrinho);
            p.setIdCarrinho(carrinho);
            em.persist(p);
            em.getTransaction().commit();

        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(PedidoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            em.getTransaction().rollback();
            Logger.getLogger(PedidoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        return p.getIdPedido();
    }
}
