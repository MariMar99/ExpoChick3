/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.backend.persistence.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Familia Toro
 */
@Entity
@Table(name = "pallets")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pallet.findAll", query = "SELECT p FROM Pallet p")
    , @NamedQuery(name = "Pallet.findByIdPallet", query = "SELECT p FROM Pallet p WHERE p.idPallet = :idPallet")
    , @NamedQuery(name = "Pallet.findByPalletStandar", query = "SELECT p FROM Pallet p WHERE p.palletStandar = :palletStandar")})
public class Pallet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPallet")
    private Integer idPallet;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "palletStandar")
    private String palletStandar;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPallet")
    private Collection<Detallepedido> detallepedidoCollection;

    public Pallet() {
    }

    public Pallet(Integer idPallet) {
        this.idPallet = idPallet;
    }

    public Pallet(Integer idPallet, String palletStandar) {
        this.idPallet = idPallet;
        this.palletStandar = palletStandar;
    }

    public Integer getIdPallet() {
        return idPallet;
    }

    public void setIdPallet(Integer idPallet) {
        this.idPallet = idPallet;
    }

    public String getPalletStandar() {
        return palletStandar;
    }

    public void setPalletStandar(String palletStandar) {
        this.palletStandar = palletStandar;
    }

    @XmlTransient
    public Collection<Detallepedido> getDetallepedidoCollection() {
        return detallepedidoCollection;
    }

    public void setDetallepedidoCollection(Collection<Detallepedido> detallepedidoCollection) {
        this.detallepedidoCollection = detallepedidoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPallet != null ? idPallet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pallet)) {
            return false;
        }
        Pallet other = (Pallet) object;
        if ((this.idPallet == null && other.idPallet != null) || (this.idPallet != null && !this.idPallet.equals(other.idPallet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.expochick.backend.persistence.entity.Pallet[ idPallet=" + idPallet + " ]";
    }
    
}
