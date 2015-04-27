/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja.jpa.base;

import entity.bean.Cliente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author caioboratto
 */
public class LojaEntityManager {

    private static final String PERSISTENCE_UNIT_NAME = "Loja-ejbPU";
    private static EntityManagerFactory factory;
    private static EntityManager em;

    public LojaEntityManager() {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        em = factory.createEntityManager();
    }
    public  EntityManager getLojaEntityManager (){
        return em;
    }
    

}
