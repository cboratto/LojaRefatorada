/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja.dao;

import entity.bean.Pedido;

/**
 *
 * @author caioboratto
 */
public interface PedidoDAO extends DAOInterface<Pedido> {

    public Integer inserirRetorna(Pedido p);
}
