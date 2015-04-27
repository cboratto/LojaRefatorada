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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author caioboratto
 */
@Entity
@Table(name = "login", catalog = "loja", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Login.findAll", query = "SELECT l FROM Login l"),
    @NamedQuery(name = "Login.findByIdLogin", query = "SELECT l FROM Login l WHERE l.idLogin = :idLogin"),
    @NamedQuery(name = "Login.findByNamLogin", query = "SELECT l FROM Login l WHERE l.namLogin = :namLogin"),
    @NamedQuery(name = "Login.findByDesPassword", query = "SELECT l FROM Login l WHERE l.desPassword = :desPassword"),
    @NamedQuery(name = "Login.findByDatCreation", query = "SELECT l FROM Login l WHERE l.datCreation = :datCreation")})
public class Login implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_login")
    private Integer idLogin;
    @Size(max = 256)
    @Column(name = "nam_login")
    private String namLogin;
    @Size(max = 256)
    @Column(name = "des_password")
    private String desPassword;
    @Column(name = "dat_creation")
    @Temporal(TemporalType.DATE)
    private Date datCreation;
    @OneToMany(mappedBy = "idLogin")
    private List<Carrinho> carrinhoList;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne
    private Cliente idCliente;

    public Login() {
    }

    public Login(Integer idLogin) {
        this.idLogin = idLogin;
    }

    public Integer getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(Integer idLogin) {
        this.idLogin = idLogin;
    }

    public String getNamLogin() {
        return namLogin;
    }

    public void setNamLogin(String namLogin) {
        this.namLogin = namLogin;
    }

    public String getDesPassword() {
        return desPassword;
    }

    public void setDesPassword(String desPassword) {
        this.desPassword = desPassword;
    }

    public Date getDatCreation() {
        return datCreation;
    }

    public void setDatCreation(Date datCreation) {
        this.datCreation = datCreation;
    }

    @XmlTransient
    public List<Carrinho> getCarrinhoList() {
        return carrinhoList;
    }

    public void setCarrinhoList(List<Carrinho> carrinhoList) {
        this.carrinhoList = carrinhoList;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLogin != null ? idLogin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Login)) {
            return false;
        }
        Login other = (Login) object;
        if ((this.idLogin == null && other.idLogin != null) || (this.idLogin != null && !this.idLogin.equals(other.idLogin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAO.Login[ idLogin=" + idLogin + " ]";
    }
    
}
