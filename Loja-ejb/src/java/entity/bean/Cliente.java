/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cbsantos
 */
@Entity
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByIdCliente", query = "SELECT c FROM Cliente c WHERE c.idCliente = :idCliente"),
    @NamedQuery(name = "Cliente.findByNomCliente", query = "SELECT c FROM Cliente c WHERE c.nomCliente = :nomCliente"),
    @NamedQuery(name = "Cliente.findByDesEmail", query = "SELECT c FROM Cliente c WHERE c.desEmail = :desEmail"),
    @NamedQuery(name = "Cliente.findByDesEndereco", query = "SELECT c FROM Cliente c WHERE c.desEndereco = :desEndereco"),
    @NamedQuery(name = "Cliente.findByNumEndereco", query = "SELECT c FROM Cliente c WHERE c.numEndereco = :numEndereco"),
    @NamedQuery(name = "Cliente.findByDesComplemento", query = "SELECT c FROM Cliente c WHERE c.desComplemento = :desComplemento"),
    @NamedQuery(name = "Cliente.findByDatCriacao", query = "SELECT c FROM Cliente c WHERE c.datCriacao = :datCriacao")})
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_cliente")
    private Integer idCliente;
    @Size(max = 256)
    @Column(name = "nom_cliente")
    private String nomCliente;
    @Size(max = 256)
    @Column(name = "des_email")
    private String desEmail;
    @Size(max = 256)
    @Column(name = "des_endereco")
    private String desEndereco;
    @Column(name = "num_endereco")
    private Integer numEndereco;
    @Size(max = 256)
    @Column(name = "des_complemento")
    private String desComplemento;
    @Column(name = "dat_criacao")
    @Temporal(TemporalType.DATE)
    private Date datCriacao;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "cliente")
    private Login login;

    public Cliente() {
    }

    public Cliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomCliente() {
        return nomCliente;
    }

    public void setNomCliente(String nomCliente) {
        this.nomCliente = nomCliente;
    }

    public String getDesEmail() {
        return desEmail;
    }

    public void setDesEmail(String desEmail) {
        this.desEmail = desEmail;
    }

    public String getDesEndereco() {
        return desEndereco;
    }

    public void setDesEndereco(String desEndereco) {
        this.desEndereco = desEndereco;
    }

    public Integer getNumEndereco() {
        return numEndereco;
    }

    public void setNumEndereco(Integer numEndereco) {
        this.numEndereco = numEndereco;
    }

    public String getDesComplemento() {
        return desComplemento;
    }

    public void setDesComplemento(String desComplemento) {
        this.desComplemento = desComplemento;
    }

    public Date getDatCriacao() {
        return datCriacao;
    }

    public void setDatCriacao(Date datCriacao) {
        this.datCriacao = datCriacao;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.bean.Cliente[ idCliente=" + idCliente + " ]";
    }
    
}
