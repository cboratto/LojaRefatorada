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
@Table(name = "pagamento_boleto", catalog = "loja", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PagamentoBoleto.findAll", query = "SELECT p FROM PagamentoBoleto p"),
    @NamedQuery(name = "PagamentoBoleto.findByIdPagamentoBoleto", query = "SELECT p FROM PagamentoBoleto p WHERE p.idPagamentoBoleto = :idPagamentoBoleto"),
    @NamedQuery(name = "PagamentoBoleto.findByCodBarras", query = "SELECT p FROM PagamentoBoleto p WHERE p.codBarras = :codBarras"),
    @NamedQuery(name = "PagamentoBoleto.findByCodBanco", query = "SELECT p FROM PagamentoBoleto p WHERE p.codBanco = :codBanco"),
    @NamedQuery(name = "PagamentoBoleto.findByValPagoBoleto", query = "SELECT p FROM PagamentoBoleto p WHERE p.valPagoBoleto = :valPagoBoleto"),
    @NamedQuery(name = "PagamentoBoleto.findByDatVencimento", query = "SELECT p FROM PagamentoBoleto p WHERE p.datVencimento = :datVencimento"),
    @NamedQuery(name = "PagamentoBoleto.findByDatCriacao", query = "SELECT p FROM PagamentoBoleto p WHERE p.datCriacao = :datCriacao"),
    @NamedQuery(name = "PagamentoBoleto.findByDatUpdate", query = "SELECT p FROM PagamentoBoleto p WHERE p.datUpdate = :datUpdate")})
public class PagamentoBoleto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_pagamento_boleto")
    private Integer idPagamentoBoleto;
    @Size(max = 128)
    @Column(name = "cod_barras")
    private String codBarras;
    @Size(max = 3)
    @Column(name = "cod_banco")
    private String codBanco;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "val_pago_boleto")
    private Double valPagoBoleto;
    @Column(name = "dat_vencimento")
    @Temporal(TemporalType.DATE)
    private Date datVencimento;
    @Column(name = "dat_criacao")
    @Temporal(TemporalType.DATE)
    private Date datCriacao;
    @Column(name = "dat_update")
    @Temporal(TemporalType.DATE)
    private Date datUpdate;
    @JoinColumn(name = "id_pagamento", referencedColumnName = "id_pagamento")
    @ManyToOne
    private Pagamento idPagamento;

    public PagamentoBoleto() {
    }

    public PagamentoBoleto(Integer idPagamentoBoleto) {
        this.idPagamentoBoleto = idPagamentoBoleto;
    }

    public Integer getIdPagamentoBoleto() {
        return idPagamentoBoleto;
    }

    public void setIdPagamentoBoleto(Integer idPagamentoBoleto) {
        this.idPagamentoBoleto = idPagamentoBoleto;
    }

    public String getCodBarras() {
        return codBarras;
    }

    public void setCodBarras(String codBarras) {
        this.codBarras = codBarras;
    }

    public String getCodBanco() {
        return codBanco;
    }

    public void setCodBanco(String codBanco) {
        this.codBanco = codBanco;
    }

    public Double getValPagoBoleto() {
        return valPagoBoleto;
    }

    public void setValPagoBoleto(Double valPagoBoleto) {
        this.valPagoBoleto = valPagoBoleto;
    }

    public Date getDatVencimento() {
        return datVencimento;
    }

    public void setDatVencimento(Date datVencimento) {
        this.datVencimento = datVencimento;
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
        hash += (idPagamentoBoleto != null ? idPagamentoBoleto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PagamentoBoleto)) {
            return false;
        }
        PagamentoBoleto other = (PagamentoBoleto) object;
        if ((this.idPagamentoBoleto == null && other.idPagamentoBoleto != null) || (this.idPagamentoBoleto != null && !this.idPagamentoBoleto.equals(other.idPagamentoBoleto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAO.PagamentoBoleto[ idPagamentoBoleto=" + idPagamentoBoleto + " ]";
    }
    
}
