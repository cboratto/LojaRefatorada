/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author caioboratto
 */
@Entity
@Table(name = "pagamento", catalog = "loja", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pagamento.findAll", query = "SELECT p FROM Pagamento p"),
    @NamedQuery(name = "Pagamento.findByIdPagamento", query = "SELECT p FROM Pagamento p WHERE p.idPagamento = :idPagamento"),
    @NamedQuery(name = "Pagamento.findByIndStatusPagamento", query = "SELECT p FROM Pagamento p WHERE p.indStatusPagamento = :indStatusPagamento"),
    @NamedQuery(name = "Pagamento.findByDatCriacao", query = "SELECT p FROM Pagamento p WHERE p.datCriacao = :datCriacao"),
    @NamedQuery(name = "Pagamento.findByDatUpdate", query = "SELECT p FROM Pagamento p WHERE p.datUpdate = :datUpdate")})
public class Pagamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_pagamento")
    private Integer idPagamento;
    @Size(max = 1)
    @Column(name = "ind_status_pagamento")
    private String indStatusPagamento;
    @Column(name = "dat_criacao")
    @Temporal(TemporalType.DATE)
    private Date datCriacao;
    @Column(name = "dat_update")
    @Temporal(TemporalType.DATE)
    private Date datUpdate;
    @JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido")
    @ManyToOne
    private Pedido idPedido;
    @OneToMany(mappedBy = "idPagamento")
    private List<PagamentoBoleto> pagamentoBoletoList;
    @OneToMany(mappedBy = "idPagamento")
    private List<PagamentoPagseguro> pagamentoPagseguroList;

    public Pagamento() {
    }

    public Pagamento(Integer idPagamento) {
        this.idPagamento = idPagamento;
    }

    public Integer getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(Integer idPagamento) {
        this.idPagamento = idPagamento;
    }

    public String getIndStatusPagamento() {
        return indStatusPagamento;
    }

    public void setIndStatusPagamento(String indStatusPagamento) {
        this.indStatusPagamento = indStatusPagamento;
    }

    public Date getDatCriacao() {
        return datCriacao;
    }

    public void setDatCriacao(Date datCriacao) {
        this.datCriacao = datCriacao;
    }

    public Date getDatUpdate() {
        return datUpdate;
    }

    public void setDatUpdate(Date datUpdate) {
        this.datUpdate = datUpdate;
    }

    public Pedido getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Pedido idPedido) {
        this.idPedido = idPedido;
    }

    @XmlTransient
    public List<PagamentoBoleto> getPagamentoBoletoList() {
        return pagamentoBoletoList;
    }

    public void setPagamentoBoletoList(List<PagamentoBoleto> pagamentoBoletoList) {
        this.pagamentoBoletoList = pagamentoBoletoList;
    }

    @XmlTransient
    public List<PagamentoPagseguro> getPagamentoPagseguroList() {
        return pagamentoPagseguroList;
    }

    public void setPagamentoPagseguroList(List<PagamentoPagseguro> pagamentoPagseguroList) {
        this.pagamentoPagseguroList = pagamentoPagseguroList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPagamento != null ? idPagamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pagamento)) {
            return false;
        }
        Pagamento other = (Pagamento) object;
        if ((this.idPagamento == null && other.idPagamento != null) || (this.idPagamento != null && !this.idPagamento.equals(other.idPagamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAO.Pagamento[ idPagamento=" + idPagamento + " ]";
    }
    
}
