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
@Table(name = "estadospedidos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estadopedido.findAll", query = "SELECT e FROM Estadopedido e")
    , @NamedQuery(name = "Estadopedido.findByIdEstadoPedido", query = "SELECT e FROM Estadopedido e WHERE e.idEstadoPedido = :idEstadoPedido")
    , @NamedQuery(name = "Estadopedido.findByNombreEstadoPedido", query = "SELECT e FROM Estadopedido e WHERE e.nombreEstadoPedido = :nombreEstadoPedido")})
public class Estadopedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEstadoPedido")
    private Integer idEstadoPedido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nombreEstadoPedido")
    private String nombreEstadoPedido;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadoPedido")
    private Collection<Pedido> pedidoCollection;

    public Estadopedido() {
    }

    public Estadopedido(Integer idEstadoPedido) {
        this.idEstadoPedido = idEstadoPedido;
    }

    public Estadopedido(Integer idEstadoPedido, String nombreEstadoPedido) {
        this.idEstadoPedido = idEstadoPedido;
        this.nombreEstadoPedido = nombreEstadoPedido;
    }

    public Integer getIdEstadoPedido() {
        return idEstadoPedido;
    }

    public void setIdEstadoPedido(Integer idEstadoPedido) {
        this.idEstadoPedido = idEstadoPedido;
    }

    public String getNombreEstadoPedido() {
        return nombreEstadoPedido;
    }

    public void setNombreEstadoPedido(String nombreEstadoPedido) {
        this.nombreEstadoPedido = nombreEstadoPedido;
    }

    @XmlTransient
    public Collection<Pedido> getPedidoCollection() {
        return pedidoCollection;
    }

    public void setPedidoCollection(Collection<Pedido> pedidoCollection) {
        this.pedidoCollection = pedidoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoPedido != null ? idEstadoPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estadopedido)) {
            return false;
        }
        Estadopedido other = (Estadopedido) object;
        if ((this.idEstadoPedido == null && other.idEstadoPedido != null) || (this.idEstadoPedido != null && !this.idEstadoPedido.equals(other.idEstadoPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.expochick.backend.persistence.entity.Estadopedido[ idEstadoPedido=" + idEstadoPedido + " ]";
    }
    
}
