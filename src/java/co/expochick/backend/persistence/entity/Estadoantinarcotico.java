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
@Table(name = "estadosantinarcoticos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estadoantinarcotico.findAll", query = "SELECT e FROM Estadoantinarcotico e")
    , @NamedQuery(name = "Estadoantinarcotico.findByIdEstadoAntinarcoticos", query = "SELECT e FROM Estadoantinarcotico e WHERE e.idEstadoAntinarcoticos = :idEstadoAntinarcoticos")
    , @NamedQuery(name = "Estadoantinarcotico.findByNombreEstadoAntinarcoticos", query = "SELECT e FROM Estadoantinarcotico e WHERE e.nombreEstadoAntinarcoticos = :nombreEstadoAntinarcoticos")})
public class Estadoantinarcotico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEstadoAntinarcoticos")
    private Integer idEstadoAntinarcoticos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nombreEstadoAntinarcoticos")
    private String nombreEstadoAntinarcoticos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadoAnti")
    private Collection<Antinarcotico> antinarcoticoCollection;

    public Estadoantinarcotico() {
    }

    public Estadoantinarcotico(Integer idEstadoAntinarcoticos) {
        this.idEstadoAntinarcoticos = idEstadoAntinarcoticos;
    }

    public Estadoantinarcotico(Integer idEstadoAntinarcoticos, String nombreEstadoAntinarcoticos) {
        this.idEstadoAntinarcoticos = idEstadoAntinarcoticos;
        this.nombreEstadoAntinarcoticos = nombreEstadoAntinarcoticos;
    }

    public Integer getIdEstadoAntinarcoticos() {
        return idEstadoAntinarcoticos;
    }

    public void setIdEstadoAntinarcoticos(Integer idEstadoAntinarcoticos) {
        this.idEstadoAntinarcoticos = idEstadoAntinarcoticos;
    }

    public String getNombreEstadoAntinarcoticos() {
        return nombreEstadoAntinarcoticos;
    }

    public void setNombreEstadoAntinarcoticos(String nombreEstadoAntinarcoticos) {
        this.nombreEstadoAntinarcoticos = nombreEstadoAntinarcoticos;
    }

    @XmlTransient
    public Collection<Antinarcotico> getAntinarcoticoCollection() {
        return antinarcoticoCollection;
    }

    public void setAntinarcoticoCollection(Collection<Antinarcotico> antinarcoticoCollection) {
        this.antinarcoticoCollection = antinarcoticoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoAntinarcoticos != null ? idEstadoAntinarcoticos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estadoantinarcotico)) {
            return false;
        }
        Estadoantinarcotico other = (Estadoantinarcotico) object;
        if ((this.idEstadoAntinarcoticos == null && other.idEstadoAntinarcoticos != null) || (this.idEstadoAntinarcoticos != null && !this.idEstadoAntinarcoticos.equals(other.idEstadoAntinarcoticos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.expochick.backend.persistence.entity.Estadoantinarcotico[ idEstadoAntinarcoticos=" + idEstadoAntinarcoticos + " ]";
    }
    
}
