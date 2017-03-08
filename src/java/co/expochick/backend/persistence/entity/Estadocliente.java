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
@Table(name = "estadosclientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estadocliente.findAll", query = "SELECT e FROM Estadocliente e")
    , @NamedQuery(name = "Estadocliente.findByIdEstadoCliente", query = "SELECT e FROM Estadocliente e WHERE e.idEstadoCliente = :idEstadoCliente")
    , @NamedQuery(name = "Estadocliente.findByNombreEstadoCliente", query = "SELECT e FROM Estadocliente e WHERE e.nombreEstadoCliente = :nombreEstadoCliente")})
public class Estadocliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEstadoCliente")
    private Integer idEstadoCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nombreEstadoCliente")
    private String nombreEstadoCliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadoCliente")
    private Collection<Cliente> clienteCollection;

    public Estadocliente() {
    }

    public Estadocliente(Integer idEstadoCliente) {
        this.idEstadoCliente = idEstadoCliente;
    }

    public Estadocliente(Integer idEstadoCliente, String nombreEstadoCliente) {
        this.idEstadoCliente = idEstadoCliente;
        this.nombreEstadoCliente = nombreEstadoCliente;
    }

    public Integer getIdEstadoCliente() {
        return idEstadoCliente;
    }

    public void setIdEstadoCliente(Integer idEstadoCliente) {
        this.idEstadoCliente = idEstadoCliente;
    }

    public String getNombreEstadoCliente() {
        return nombreEstadoCliente;
    }

    public void setNombreEstadoCliente(String nombreEstadoCliente) {
        this.nombreEstadoCliente = nombreEstadoCliente;
    }

    @XmlTransient
    public Collection<Cliente> getClienteCollection() {
        return clienteCollection;
    }

    public void setClienteCollection(Collection<Cliente> clienteCollection) {
        this.clienteCollection = clienteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoCliente != null ? idEstadoCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estadocliente)) {
            return false;
        }
        Estadocliente other = (Estadocliente) object;
        if ((this.idEstadoCliente == null && other.idEstadoCliente != null) || (this.idEstadoCliente != null && !this.idEstadoCliente.equals(other.idEstadoCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.expochick.backend.persistence.entity.Estadocliente[ idEstadoCliente=" + idEstadoCliente + " ]";
    }
    
}
