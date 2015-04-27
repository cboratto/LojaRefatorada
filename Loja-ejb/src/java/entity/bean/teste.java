/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.bean;

import loja.dao.ClienteDAO;
import loja.dao.ClienteDAOImpl;

/**
 *
 * @author cbsantos
 */
public class teste {
    public static void main(String[] args) {
        ClienteDAO cliente = new ClienteDAOImpl();
        cliente.listar("Cliente.findAll");
    }
}
