/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.session;

import bean.exceptions.DupValOnIndexException;
import entity.bean.Login;
import javax.ejb.Remote;

/**
 *
 * @author caioboratto
 */
@Remote
public interface LoginBeanRemote extends InterfaceBeanRemote<Login> {

}
