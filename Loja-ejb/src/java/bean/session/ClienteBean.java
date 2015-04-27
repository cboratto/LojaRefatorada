/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.session;

import entity.bean.Cliente;
import java.util.List;
import javax.ejb.Stateless;
import loja.dao.ClienteDAO;
import loja.dao.ClienteDAOImpl;

/**
 *
 * @author caioboratto
 */

@Stateless(mappedName = "ClienteBean")
public class ClienteBean implements ClienteBeanRemote{

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    Cliente cliente;
    ClienteDAO clienteDao = new ClienteDAOImpl();

    @Override
    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public List<Cliente> getClienteList(String namedQuery) {
        return clienteDao.listar(namedQuery);
        
    }

}
