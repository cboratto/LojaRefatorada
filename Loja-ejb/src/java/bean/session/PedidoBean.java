/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.session;

import bean.exceptions.DupValOnIndexException;
import entity.bean.Pedido;
import java.io.UnsupportedEncodingException;
import loja.dao.PedidoDAOImpl;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import loja.dao.PedidoDAO;
import loja.util.mail.LojaMail;

@Stateless(mappedName = "PedidoBean")
public class PedidoBean implements PedidoBeanRemote {

    PedidoDAO pedidoDAO = new PedidoDAOImpl();
    LojaMail lojaMail;

    @Override
    public Object getObject() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setObjet(Pedido e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pedido> getObjectList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(Pedido e) throws DupValOnIndexException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer saveReturnPedido(Pedido p) {
        return pedidoDAO.inserirRetorna(p);

    }

    @Override
    public void enviarEmailParaComprador(Integer idPedido, String nomeCliente, String desEmail) {
        if (lojaMail == null) {
            lojaMail = new LojaMail();
        }

        try {
            lojaMail.sendLojaMail(idPedido, nomeCliente, desEmail);
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
            Logger.getLogger(PedidoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
