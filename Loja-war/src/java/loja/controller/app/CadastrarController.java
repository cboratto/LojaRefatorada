/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja.controller.app;

import bean.session.ClienteBean;
import bean.session.ClienteBeanRemote;
import loja.controller.frontcontroller.AbstractApplicationController;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import util.JNDIUtil;
import javax.ejb.EJB;

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
            
            cliente.getClienteList();

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
