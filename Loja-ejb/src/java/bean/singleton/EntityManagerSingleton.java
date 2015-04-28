/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.singleton;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author cbsantos
 */
public class EntityManagerSingleton {

    private static final String PERSISTENCE_UNIT_NAME = "Loja-ejbPU";
    private static EntityManagerFactory factory;    

    private static EntityManagerSingleton conexao;

    public static EntityManagerSingleton getInstance() {
        if (conexao == null) {
            conexao = new EntityManagerSingleton();
        }
        return conexao;
    }

    public EntityManager getConnection() throws ClassNotFoundException {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        return em;
    }
}
