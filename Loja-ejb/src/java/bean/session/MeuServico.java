/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.session;

import bean.singleton.ConsultaProdutoBean;
import bean.singleton.ListaProduto;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author caioboratto
 */
@Path("servico")
@Stateless
public class MeuServico {

    @EJB
    ConsultaProdutoBean meuBean;

    @GET
    @Produces("application/xml")
    public ListaProduto processGet() {
        System.out.println("Encontrou MEUBEAN");
        return meuBean.getListaProduto();
        //return new ListaProduto();
    }

}
