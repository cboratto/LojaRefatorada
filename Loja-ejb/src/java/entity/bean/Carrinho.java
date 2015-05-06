/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cbsantos
 */
@Entity
@Table(name = "carrinho")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Carrinho.findAll", query = "SELECT c FROM Carrinho c"),
    @NamedQuery(name = "Carrinho.findByIdCarrinho", query = "SELECT c FROM Carrinho c WHERE c.idCarrinho = :idCarrinho"),
    @NamedQuery(name = "Carrinho.findByDatCriacao", query = "SELECT c FROM Carrinho c WHERE c.datCriacao = :datCriacao")})
public class Carrinho implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_carrinho")
    private Integer idCarrinho;
    @Column(name = "dat_criacao")
    @Temporal(TemporalType.DATE)
    private Date datCriacao;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne
    private Login idCliente;
    //eu adicionei validar se o erro nao esta aqui
    @OneToMany(mappedBy = "idCarrinho")
    private List<CarrinhoItem> carrinhoItemList;

    public Carrinho() {
    }

    public Carrinho(Integer idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

    public Integer getIdCarrinho() {
        return idCarrinho;
    }

    public void setIdCarrinho(Integer idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

    public Date getDatCriacao() {
        return datCriacao;
    }

    public void setDatCriacao(Date datCriacao) {
        this.datCriacao = datCriacao;
    }

    public Login getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Login idCliente) {
        this.idCliente = idCliente;
    }

    @XmlTransient
    public List<CarrinhoItem> getCarrinhoItemList() {
        return carrinhoItemList;
    }

    public void setCarrinhoList(List<CarrinhoItem> carrinhoItemList) {
        this.carrinhoItemList = carrinhoItemList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCarrinho != null ? idCarrinho.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carrinho)) {
            return false;
        }
        Carrinho other = (Carrinho) object;
        if ((this.idCarrinho == null && other.idCarrinho != null) || (this.idCarrinho != null && !this.idCarrinho.equals(other.idCarrinho))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.bean.Carrinho[ idCarrinho=" + idCarrinho + " ]";
    }

}
