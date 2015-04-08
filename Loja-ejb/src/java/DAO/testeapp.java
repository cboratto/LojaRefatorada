/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author caioboratto
 */
public class testeapp {

    private static final String PERSISTENCE_UNIT_NAME = "Loja-ejbPU";
    private static EntityManagerFactory factory;

    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        // Read the existing entries and write to console
        //Query q = em.createQuery("SELECT u FROM Cliente u");
        Query q = em.createNamedQuery("Cliente.findAll");
        List<Cliente> clienteList = q.getResultList();
        for (Cliente cliente : clienteList) {
            System.out.println(cliente.getDesEmail());
        }
        System.out.println("Size: " + clienteList.size());

        // Create new user
//        em.getTransaction().begin();
//        User user = new User();
//        user.setName("Tom Johnson");
//        user.setLogin("tomj");
//        user.setPassword("pass");
//        em.persist(user);
//        em.getTransaction().commit();

        em.close();
    }
}
