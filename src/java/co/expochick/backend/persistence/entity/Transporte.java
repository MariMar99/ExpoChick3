/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.backend.persistence.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Familia Toro
 */
@Entity
@Table(name = "transportes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transporte.findAll", query = "SELECT t FROM Transporte t")
    , @NamedQuery(name = "Transporte.findByIdTransporte", query = "SELECT t FROM Transporte t WHERE t.idTransporte = :idTransporte")
    , @NamedQuery(name = "Transporte.findByFechaArribo", query = "SELECT t FROM Transporte t WHERE t.fechaArribo = :fechaArribo")
    , @NamedQuery(name = "Transporte.findByNombreUsuarioTransportador", query = "SELECT t FROM Transporte t WHERE t.nombreUsuarioTransportador = :nombreUsuarioTransportador")})
public class Transporte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTransporte")
    private Integer idTransporte;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaArribo")
    @Temporal(TemporalType.DATE)
    private Date fechaArribo;
    @Column(name = "nombreUsuarioTransportador")
    private Integer nombreUsuarioTransportador;
    @JoinColumn(name = "idEmpresaTransporte", referencedColumnName = "idEmpresaTransporte")
    @ManyToOne(optional = false)
    private Empresatransporte idEmpresaTransporte;
    @JoinColumn(name = "idPedido", referencedColumnName = "idPedido")
    @ManyToOne(optional = false)
    private Pedido idPedido;

    public Transporte() {
    }

    public Transporte(Integer idTransporte) {
        this.idTransporte = idTransporte;
    }

    public Transporte(Integer idTransporte, Date fechaArribo) {
        this.idTransporte = idTransporte;
        this.fechaArribo = fechaArribo;
    }

    public Integer getIdTransporte() {
        return idTransporte;
    }

    public void setIdTransporte(Integer idTransporte) {
        this.idTransporte = idTransporte;
    }

    public Date getFechaArribo() {
        return fechaArribo;
    }

    public void setFechaArribo(Date fechaArribo) {
        this.fechaArribo = fechaArribo;
    }

    public Integer getNombreUsuarioTransportador() {
        return nombreUsuarioTransportador;
    }

    public void setNombreUsuarioTransportador(Integer nombreUsuarioTransportador) {
        this.nombreUsuarioTransportador = nombreUsuarioTransportador;
    }

    public Empresatransporte getIdEmpresaTransporte() {
        return idEmpresaTransporte;
    }

    public void setIdEmpresaTransporte(Empresatransporte idEmpresaTransporte) {
        this.idEmpresaTransporte = idEmpresaTransporte;
    }

    public Pedido getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Pedido idPedido) {
        this.idPedido = idPedido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTransporte != null ? idTransporte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transporte)) {
            return false;
        }
        Transporte other = (Transporte) object;
        if ((this.idTransporte == null && other.idTransporte != null) || (this.idTransporte != null && !this.idTransporte.equals(other.idTransporte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.expochick.backend.persistence.entity.Transporte[ idTransporte=" + idTransporte + " ]";
    }
    
}
