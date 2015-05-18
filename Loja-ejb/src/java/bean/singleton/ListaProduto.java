/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.singleton;

import entity.bean.Produto;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author caioboratto
 */
@XmlRootElement
public class ListaProduto {

    List<Produto> lista;

    public ListaProduto() {

    }

    public List<Produto> getLista() {
        return lista;
    }

    public void setLista(List<Produto> lista) {
        this.lista = lista;
    }

}
