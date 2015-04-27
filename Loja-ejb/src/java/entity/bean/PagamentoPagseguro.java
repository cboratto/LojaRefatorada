/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author caioboratto
 */
@Entity
@Table(name = "pagamento_pagseguro", catalog = "loja", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PagamentoPagseguro.findAll", query = "SELECT p FROM PagamentoPagseguro p"),
    @NamedQuery(name = "PagamentoPagseguro.findByIdPagamentoPagseguro", query = "SELECT p FROM PagamentoPagseguro p WHERE p.idPagamentoPagseguro = :idPagamentoPagseguro"),
    @NamedQuery(name = "PagamentoPagseguro.findByCodResposta", query = "SELECT p FROM PagamentoPagseguro p WHERE p.codResposta = :codResposta"),
    @NamedQuery(name = "PagamentoPagseguro.findByCodStatus", query = "SELECT p FROM PagamentoPagseguro p WHERE p.codStatus = :codStatus"),
    @NamedQuery(name = "PagamentoPagseguro.findByValAprovado", query = "SELECT p FROM PagamentoPagseguro p WHERE p.valAprovado = :valAprovado"),
    @NamedQuery(name = "PagamentoPagseguro.findByDatCriacao", query = "SELECT p FROM PagamentoPagseguro p WHERE p.datCriacao = :datCriacao"),
    @NamedQuery(name = "PagamentoPagseguro.findByDatUpdate", query = "SELECT p FROM PagamentoPagseguro p WHERE p.datUpdate = :datUpdate")})
public class PagamentoPagseguro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_pagamento_pagseguro")
    private Integer idPagamentoPagseguro;
    @Size(max = 256)
    @Column(name = "cod_resposta")
    private String codResposta;
    @Size(max = 10)
    @Column(name = "cod_status")
    private String codStatus;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "val_aprovado")
    private Double valAprovado;
    @Column(name = "dat_criacao")
    @Temporal(TemporalType.DATE)
    private Date datCriacao;
    @Column(name = "dat_update")
    @Temporal(TemporalType.DATE)
    private Date datUpdate;
    @JoinColumn(name = "id_pagamento", referencedColumnName = "id_pagamento")
    @ManyToOne
    private Pagamento idPagamento;

    public PagamentoPagseguro() {
    }

    public PagamentoPagseguro(Integer idPagamentoPagseguro) {
        this.idPagamentoPagseguro = idPagamentoPagseguro;
    }

    public Integer getIdPagamentoPagseguro() {
        return idPagamentoPagseguro;
    }

    public void setIdPagamentoPagseguro(Integer idPagamentoPagseguro) {
        this.idPagamentoPagseguro = idPagamentoPagseguro;
    }

    public String getCodResposta() {
        return codResposta;
    }

    public void setCodResposta(String codResposta) {
        this.codResposta = codResposta;
    }

    public String getCodStatus() {
        return codStatus;
    }

    public void setCodStatus(String codStatus) {
        this.codStatus = codStatus;
    }

    public Double getValAprovado() {
        return valAprovado;
    }

    public void setValAprovado(Double valAprovado) {
        this.valAprovado = valAprovado;
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

    public Pagamento getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(Pagamento idPagamento) {
        this.idPagamento = idPagamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPagamentoPagseguro != null ? idPagamentoPagseguro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PagamentoPagseguro)) {
            return false;
        }
        PagamentoPagseguro other = (PagamentoPagseguro) object;
        if ((this.idPagamentoPagseguro == null && other.idPagamentoPagseguro != null) || (this.idPagamentoPagseguro != null && !this.idPagamentoPagseguro.equals(other.idPagamentoPagseguro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAO.PagamentoPagseguro[ idPagamentoPagseguro=" + idPagamentoPagseguro + " ]";
    }
    
}
