/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.session;

import entity.bean.Pedido;
import javax.ejb.Remote;

/**
 *
 * @author caioboratto
 */
@Remote
public interface PedidoBeanRemote extends InterfaceBeanRemote<Pedido> {

}
