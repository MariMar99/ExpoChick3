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
@Table(name = "empresastransportes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresatransporte.findAll", query = "SELECT e FROM Empresatransporte e")
    , @NamedQuery(name = "Empresatransporte.findByIdEmpresaTransporte", query = "SELECT e FROM Empresatransporte e WHERE e.idEmpresaTransporte = :idEmpresaTransporte")
    , @NamedQuery(name = "Empresatransporte.findByNombreEmpresa", query = "SELECT e FROM Empresatransporte e WHERE e.nombreEmpresa = :nombreEmpresa")
    , @NamedQuery(name = "Empresatransporte.findByTelefono", query = "SELECT e FROM Empresatransporte e WHERE e.telefono = :telefono")})
public class Empresatransporte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEmpresaTransporte")
    private Integer idEmpresaTransporte;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nombreEmpresa")
    private String nombreEmpresa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "telefono")
    private int telefono;
    @JoinColumn(name = "idCiudad", referencedColumnName = "idCiudad")
    @ManyToOne(optional = false)
    private Ciudad idCiudad;
    @JoinColumn(name = "idTipoTransporte", referencedColumnName = "idTipoTransporte")
    @ManyToOne(optional = false)
    private Tipotransporte idTipoTransporte;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpresaTransporte")
    private Collection<Transporte> transporteCollection;

    public Empresatransporte() {
    }

    public Empresatransporte(Integer idEmpresaTransporte) {
        this.idEmpresaTransporte = idEmpresaTransporte;
    }

    public Empresatransporte(Integer idEmpresaTransporte, String nombreEmpresa, int telefono) {
        this.idEmpresaTransporte = idEmpresaTransporte;
        this.nombreEmpresa = nombreEmpresa;
        this.telefono = telefono;
    }

    public Integer getIdEmpresaTransporte() {
        return idEmpresaTransporte;
    }

    public void setIdEmpresaTransporte(Integer idEmpresaTransporte) {
        this.idEmpresaTransporte = idEmpresaTransporte;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Ciudad getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Ciudad idCiudad) {
        this.idCiudad = idCiudad;
    }

    public Tipotransporte getIdTipoTransporte() {
        return idTipoTransporte;
    }

    public void setIdTipoTransporte(Tipotransporte idTipoTransporte) {
        this.idTipoTransporte = idTipoTransporte;
    }

    @XmlTransient
    public Collection<Transporte> getTransporteCollection() {
        return transporteCollection;
    }

    public void setTransporteCollection(Collection<Transporte> transporteCollection) {
        this.transporteCollection = transporteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpresaTransporte != null ? idEmpresaTransporte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresatransporte)) {
            return false;
        }
        Empresatransporte other = (Empresatransporte) object;
        if ((this.idEmpresaTransporte == null && other.idEmpresaTransporte != null) || (this.idEmpresaTransporte != null && !this.idEmpresaTransporte.equals(other.idEmpresaTransporte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.expochick.backend.persistence.entity.Empresatransporte[ idEmpresaTransporte=" + idEmpresaTransporte + " ]";
    }
    
}
