/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.session;

import bean.exceptions.DupValOnIndexException;
import java.util.List;

/**
 *
 * @author caioboratto
 */
public interface InterfaceBeanRemote<E> {

    public Object getObject();

    public void setObjet(E e);

    public List<E> getObjectList();

    public void save(E e) throws DupValOnIndexException;
}
