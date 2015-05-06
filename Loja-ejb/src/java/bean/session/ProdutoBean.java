/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.session;

import bean.exceptions.DupValOnIndexException;
import entity.bean.Produto;
import java.util.List;
import javax.ejb.Stateless;
import loja.dao.ProdutoDAOImpl;

/**
 *
 * @author caioboratto
 */
@Stateless(mappedName = "ProdutoBean")
public class ProdutoBean implements ProdutoBeanRemote {

    ProdutoDAOImpl produtoDao = new ProdutoDAOImpl();

    @Override
    public Object getObject() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setObjet(Produto e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Produto> getObjectList() {
        return (List<Produto>) produtoDao.listar();
    }

    @Override
    public void save(Produto e) throws DupValOnIndexException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Produto getProdutoSelecionado(Integer id) {
        return produtoDao.listarProdutoById(id);
    }

}
