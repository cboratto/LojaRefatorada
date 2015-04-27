/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja.controller.app;

import DAO.Cliente;
import loja.controller.frontcontroller.AbstractApplicationController;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import loja.jpa.base.LojaEntityManager;

/**
 *
 * @author caioboratto
 */
public class CadastrarController extends AbstractApplicationController {

    @Override
    public void execute() {

        EntityManager em;
        LojaEntityManager e = new LojaEntityManager();
        em = e.getLojaEntityManager();
        //EntityManagerFactory factory = Persistence.createEntityManagerFactory("Loja - ejbPU");
        //em = factory.createEntityManager();

        Cliente cliente = new Cliente();
        cliente.setIdCliente(99);
        cliente.setNomCliente((getRequest().getParameter("nome")));

        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();

        //this.setReturnPage("/lista_hoteis.jsp");
        //this.getRequest().setAttribute("lista_hoteis", hoteis);
    }

}
