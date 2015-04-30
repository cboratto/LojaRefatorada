/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja.controller.app;

import bean.session.ClienteBeanRemote;
import bean.session.LoginBeanRemote;
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
        //pagina default de retorno
        this.setReturnPage("/lista_hoteis.jsp");

        try {
            Context context = JNDIUtil.getCORBAInitialContext();
            ClienteBeanRemote cliente = (ClienteBeanRemote) context.lookup("ClienteBean");
            //LoginBeanRemote loginbean = (LoginBeanRemote) context.lookup("LoginBean");
            Cliente novoCliente = new Cliente();
            Login novoLogin = new Login();

            novoCliente.setNomCliente(this.getRequest().getParameter("nome"));
            novoCliente.setDesEmail(this.getRequest().getParameter("email"));
            novoCliente.setDesEndereco(this.getRequest().getParameter("endereco"));
            novoCliente.setNumEndereco(Integer.parseInt((this.getRequest().getParameter("enderecoNumero"))));
            novoCliente.setDesComplemento(this.getRequest().getParameter("complemento"));

            //
            //login
            novoLogin.setNamLogin(this.getRequest().getParameter("user"));
            novoLogin.setDesPassword(this.getRequest().getParameter("senha"));

            //relaciona
            novoCliente.setLogin(novoLogin);
            novoLogin.setCliente(novoCliente);
            
            //insere no banco            
            try {
                cliente.save(novoCliente);
                //loginbean.save(novoLogin);
                
            } catch (Exception d) {
                this.setReturnPage("/cadastro_userdup.jsp");
            }

        } catch (Exception ex) {
            Logger.getLogger(CadastrarController.class.getName()).log(Level.SEVERE, null, ex);
        }

        //this.getRequest().setAttribute("lista_hoteis", hoteis);
    }

}
