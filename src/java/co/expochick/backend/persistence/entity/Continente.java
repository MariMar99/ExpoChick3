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
@Table(name = "continentes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Continente.findAll", query = "SELECT c FROM Continente c")
    , @NamedQuery(name = "Continente.findByIdContinente", query = "SELECT c FROM Continente c WHERE c.idContinente = :idContinente")
    , @NamedQuery(name = "Continente.findByNombreContinente", query = "SELECT c FROM Continente c WHERE c.nombreContinente = :nombreContinente")})
public class Continente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idContinente")
    private Integer idContinente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombreContinente")
    private String nombreContinente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idContinente")
    private Collection<Pais> paisCollection;

    public Continente() {
    }

    public Continente(Integer idContinente) {
        this.idContinente = idContinente;
    }

    public Continente(Integer idContinente, String nombreContinente) {
        this.idContinente = idContinente;
        this.nombreContinente = nombreContinente;
    }

    public Integer getIdContinente() {
        return idContinente;
    }

    public void setIdContinente(Integer idContinente) {
        this.idContinente = idContinente;
    }

    public String getNombreContinente() {
        return nombreContinente;
    }

    public void setNombreContinente(String nombreContinente) {
        this.nombreContinente = nombreContinente;
    }

    @XmlTransient
    public Collection<Pais> getPaisCollection() {
        return paisCollection;
    }

    public void setPaisCollection(Collection<Pais> paisCollection) {
        this.paisCollection = paisCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idContinente != null ? idContinente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Continente)) {
            return false;
        }
        Continente other = (Continente) object;
        if ((this.idContinente == null && other.idContinente != null) || (this.idContinente != null && !this.idContinente.equals(other.idContinente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.expochick.backend.persistence.entity.Continente[ idContinente=" + idContinente + " ]";
    }
    
}
