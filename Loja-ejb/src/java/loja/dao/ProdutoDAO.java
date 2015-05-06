/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja.dao;

import entity.bean.Produto;

/**
 *
 * @author caioboratto
 */
public interface ProdutoDAO extends DAOInterface<Produto> {

    public Produto listarProdutoById(Integer id);
}
