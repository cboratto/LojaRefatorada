/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.singleton;

import bean.session.ProdutoBean;
import entity.bean.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author caioboratto
 */
@Singleton
@Startup
public class ConsultaProdutoBean  {

    ListaProduto listaProdutos;

    @PostConstruct
    public void init() {
        listaProdutos = new ListaProduto();
        listaProdutos.setLista(new ProdutoBean().getObjectList());

    }

    public ListaProduto getListaProduto() {
        System.out.println("Pegou o produto");
        return listaProdutos;
    }

}
