/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.session;

import bean.exceptions.DupValOnIndexException;
import entity.bean.Login;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import loja.dao.ClienteDAOImpl;
import loja.dao.DAOInterface;
import loja.dao.LoginDAOImpl;

/**
 *
 * @author caioboratto
 */
@Stateless(mappedName = "LoginBean")
public class LoginBean implements LoginBeanRemote {

    DAOInterface loginDAO = new LoginDAOImpl();
    Login login;

    @Override
    public void save(Login l) {
        try {
            loginDAO.inserir(l);
        } catch (DupValOnIndexException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object getObject() {
        return login;
    }

    @Override
    public void setObjet(Login e) {
        login = e;
    }

    @Override
    public List<Login> getObjectList() {
        return loginDAO.listar();

    }
}
