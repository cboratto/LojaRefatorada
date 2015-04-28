/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja.dao;

import java.util.List;

/**
 *
 * @author cbsantos
 */
public interface DAOInterface<E> {

    public List<E> listar();

    public void inserir(E e);

    public void alterar(E e);

    public void remover(E e);
}
