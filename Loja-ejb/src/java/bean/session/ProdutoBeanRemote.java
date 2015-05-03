/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.session;

import entity.bean.Produto;
import javax.ejb.Remote;

/**
 *
 * @author caioboratto
 */
@Remote
public interface ProdutoBeanRemote extends InterfaceBeanRemote<Produto> {
    
}
