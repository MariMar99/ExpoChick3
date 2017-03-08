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
@Table(name = "tipostransportes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipotransporte.findAll", query = "SELECT t FROM Tipotransporte t")
    , @NamedQuery(name = "Tipotransporte.findByIdTipoTransporte", query = "SELECT t FROM Tipotransporte t WHERE t.idTipoTransporte = :idTipoTransporte")
    , @NamedQuery(name = "Tipotransporte.findByNombreTipoTransporte", query = "SELECT t FROM Tipotransporte t WHERE t.nombreTipoTransporte = :nombreTipoTransporte")})
public class Tipotransporte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTipoTransporte")
    private Integer idTipoTransporte;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "nombreTipoTransporte")
    private String nombreTipoTransporte;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoTransporte")
    private Collection<Empresatransporte> empresatransporteCollection;

    public Tipotransporte() {
    }

    public Tipotransporte(Integer idTipoTransporte) {
        this.idTipoTransporte = idTipoTransporte;
    }

    public Tipotransporte(Integer idTipoTransporte, String nombreTipoTransporte) {
        this.idTipoTransporte = idTipoTransporte;
        this.nombreTipoTransporte = nombreTipoTransporte;
    }

    public Integer getIdTipoTransporte() {
        return idTipoTransporte;
    }

    public void setIdTipoTransporte(Integer idTipoTransporte) {
        this.idTipoTransporte = idTipoTransporte;
    }

    public String getNombreTipoTransporte() {
        return nombreTipoTransporte;
    }

    public void setNombreTipoTransporte(String nombreTipoTransporte) {
        this.nombreTipoTransporte = nombreTipoTransporte;
    }

    @XmlTransient
    public Collection<Empresatransporte> getEmpresatransporteCollection() {
        return empresatransporteCollection;
    }

    public void setEmpresatransporteCollection(Collection<Empresatransporte> empresatransporteCollection) {
        this.empresatransporteCollection = empresatransporteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoTransporte != null ? idTipoTransporte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipotransporte)) {
            return false;
        }
        Tipotransporte other = (Tipotransporte) object;
        if ((this.idTipoTransporte == null && other.idTipoTransporte != null) || (this.idTipoTransporte != null && !this.idTipoTransporte.equals(other.idTipoTransporte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.expochick.backend.persistence.entity.Tipotransporte[ idTipoTransporte=" + idTipoTransporte + " ]";
    }
    
}
