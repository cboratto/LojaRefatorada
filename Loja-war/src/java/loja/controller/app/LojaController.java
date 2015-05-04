/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja.controller.app;

import bean.session.ProdutoBeanRemote;
import entity.bean.Produto;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import loja.controller.frontcontroller.AbstractApplicationController;
import util.JNDIUtil;

/**
 *
 * @author caioboratto
 */
public class LojaController extends AbstractApplicationController {

    @Override
    public void execute() {
        try {
            Context context = JNDIUtil.getCORBAInitialContext();

            ProdutoBeanRemote produtoBean = (ProdutoBeanRemote) context.lookup("ProdutoBean");            

            //teste para subida de produtos                
            List<Produto> listaProdutos = produtoBean.getObjectList();
            this.getRequest().setAttribute("produtos", listaProdutos);
            this.setReturnPage("/loja/inicio.jsp");
            
        } catch (Exception ex) {
            Logger.getLogger(CadastrarController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
