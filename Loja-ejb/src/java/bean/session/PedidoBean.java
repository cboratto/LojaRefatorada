/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.session;

import bean.exceptions.DupValOnIndexException;
import entity.bean.Pedido;
import loja.dao.PedidoDAOImpl;
import java.util.List;
import javax.ejb.Stateless;
import loja.dao.PedidoDAO;

@Stateless(mappedName = "PedidoBean")
public class PedidoBean implements PedidoBeanRemote {

    PedidoDAO pedidoDAO = new PedidoDAOImpl();

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

}
