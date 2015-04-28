/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja.controller.app;

import bean.session.ClienteBeanRemote;
import entity.bean.Cliente;
import entity.bean.Login;
import loja.controller.frontcontroller.AbstractApplicationController;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import util.JNDIUtil;

/**
 *
 * @author caioboratto
 */
public class CadastrarController extends AbstractApplicationController {

    //@EJB(beanName = "bean.session.ClienteBean")
    //private ClienteBean cliente;
    @Override
    public void execute() {
        try {
            Context context = JNDIUtil.getCORBAInitialContext();
            ClienteBeanRemote cliente = (ClienteBeanRemote) context.lookup("ClienteBean");           
            
            Cliente novoCliente = new Cliente();
            Login   novoLogin = new Login();
            
            novoCliente.setNomCliente(this.getRequest().getParameter("nome"));            
            novoCliente.setDesEmail(this.getRequest().getParameter("email"));
            novoCliente.setDesEndereco(this.getRequest().getParameter("endereco"));
            novoCliente.setNumEndereco(Integer.parseInt((this.getRequest().getParameter("enderecoNumero"))));                                                                                                           
            
            //login
            novoLogin.setNamLogin(this.getRequest().getParameter("user"));
            novoLogin.setDesPassword(this.getRequest().getParameter("senha"));
            
            cliente.clienteInsert(novoCliente);

        } catch (Exception ex) {
            Logger.getLogger(CadastrarController.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Cliente cliente = new Cliente();
        //cliente.setIdCliente(99);
        //cliente.setNomCliente((getRequest().getParameter("nome")));
        this.setReturnPage("/lista_hoteis.jsp");
        //this.getRequest().setAttribute("lista_hoteis", hoteis);
    }

}
