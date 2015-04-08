/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;

/**
 *
 * @author caioboratto
 */
public interface DaoGenerico<E> {

    public void inserir(E e);

    public void alterar(E e);

    public void remover(E e);

    public List<E> listar();

}
