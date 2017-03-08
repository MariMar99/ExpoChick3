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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tiposempaques")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipoempaque.findAll", query = "SELECT t FROM Tipoempaque t")
    , @NamedQuery(name = "Tipoempaque.findByIdTipoEmpaque", query = "SELECT t FROM Tipoempaque t WHERE t.idTipoEmpaque = :idTipoEmpaque")
    , @NamedQuery(name = "Tipoempaque.findByMarcaCaja", query = "SELECT t FROM Tipoempaque t WHERE t.marcaCaja = :marcaCaja")})
public class Tipoempaque implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTipoEmpaque")
    private Integer idTipoEmpaque;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "marcaCaja")
    private String marcaCaja;
    @JoinColumn(name = "idMedidaCaja", referencedColumnName = "idMedidaCaja")
    @ManyToOne(optional = false)
    private Medidacaja idMedidaCaja;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoEmpaque")
    private Collection<Detallepedido> detallepedidoCollection;

    public Tipoempaque() {
    }

    public Tipoempaque(Integer idTipoEmpaque) {
        this.idTipoEmpaque = idTipoEmpaque;
    }

    public Tipoempaque(Integer idTipoEmpaque, String marcaCaja) {
        this.idTipoEmpaque = idTipoEmpaque;
        this.marcaCaja = marcaCaja;
    }

    public Integer getIdTipoEmpaque() {
        return idTipoEmpaque;
    }

    public void setIdTipoEmpaque(Integer idTipoEmpaque) {
        this.idTipoEmpaque = idTipoEmpaque;
    }

    public String getMarcaCaja() {
        return marcaCaja;
    }

    public void setMarcaCaja(String marcaCaja) {
        this.marcaCaja = marcaCaja;
    }

    public Medidacaja getIdMedidaCaja() {
        return idMedidaCaja;
    }

    public void setIdMedidaCaja(Medidacaja idMedidaCaja) {
        this.idMedidaCaja = idMedidaCaja;
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
        hash += (idTipoEmpaque != null ? idTipoEmpaque.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoempaque)) {
            return false;
        }
        Tipoempaque other = (Tipoempaque) object;
        if ((this.idTipoEmpaque == null && other.idTipoEmpaque != null) || (this.idTipoEmpaque != null && !this.idTipoEmpaque.equals(other.idTipoEmpaque))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.expochick.backend.persistence.entity.Tipoempaque[ idTipoEmpaque=" + idTipoEmpaque + " ]";
    }
    
}
