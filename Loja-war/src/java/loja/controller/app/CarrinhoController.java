/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja.controller.app;

import bean.session.CarrinhoBeanRemote;
import bean.session.ProdutoBeanRemote;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import loja.controller.frontcontroller.AbstractApplicationController;
import util.JNDIUtil;

/**
 *
 * @author caioboratto
 */
public class CarrinhoController extends AbstractApplicationController {

    @Override
    public void execute() {
        try {
            //busca bean
            Context context = JNDIUtil.getCORBAInitialContext();
            CarrinhoBeanRemote carrinhoBean = (CarrinhoBeanRemote) context.lookup("CarrinhoBean");

            //Produto adicionado redireciona para loja
            this.setReturnPage("/carrinho/carrinho.jsp");
        } catch (Exception ex) {
            Logger.getLogger(CadastrarController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
