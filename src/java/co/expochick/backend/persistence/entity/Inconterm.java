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
@Table(name = "inconterms")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inconterm.findAll", query = "SELECT i FROM Inconterm i")
    , @NamedQuery(name = "Inconterm.findByIdInconterm", query = "SELECT i FROM Inconterm i WHERE i.idInconterm = :idInconterm")
    , @NamedQuery(name = "Inconterm.findByInconterm", query = "SELECT i FROM Inconterm i WHERE i.inconterm = :inconterm")
    , @NamedQuery(name = "Inconterm.findByDescripcion", query = "SELECT i FROM Inconterm i WHERE i.descripcion = :descripcion")})
public class Inconterm implements Serializable, IEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idInconterm")
    private Integer idInconterm;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "INCONTERM")
    private String inconterm;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInconterm")
    private Collection<Pedido> pedidoCollection;

    public Inconterm() {
    }

    public Inconterm(Integer idInconterm) {
        this.idInconterm = idInconterm;
    }

    public Inconterm(Integer idInconterm, String inconterm, String descripcion) {
        this.idInconterm = idInconterm;
        this.inconterm = inconterm;
        this.descripcion = descripcion;
    }

    public Integer getIdInconterm() {
        return idInconterm;
    }

    public void setIdInconterm(Integer idInconterm) {
        this.idInconterm = idInconterm;
    }

    public String getInconterm() {
        return inconterm;
    }

    public void setInconterm(String inconterm) {
        this.inconterm = inconterm;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        hash += (idInconterm != null ? idInconterm.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inconterm)) {
            return false;
        }
        Inconterm other = (Inconterm) object;
        if ((this.idInconterm == null && other.idInconterm != null) || (this.idInconterm != null && !this.idInconterm.equals(other.idInconterm))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.expochick.backend.persistence.entity.Inconterm[ idInconterm=" + idInconterm + " ]";
    }

    @Override
    public String getId() {
        return idInconterm.toString();
    }
    
}
