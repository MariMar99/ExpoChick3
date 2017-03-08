/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.backend.persistence.entity;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Familia Toro
 */
@Entity
@Table(name = "trazabilidades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trazabilidad.findAll", query = "SELECT t FROM Trazabilidad t")
    , @NamedQuery(name = "Trazabilidad.findByIdTrazabilidad", query = "SELECT t FROM Trazabilidad t WHERE t.idTrazabilidad = :idTrazabilidad")
    , @NamedQuery(name = "Trazabilidad.findByNombreEmpresa", query = "SELECT t FROM Trazabilidad t WHERE t.nombreEmpresa = :nombreEmpresa")
    , @NamedQuery(name = "Trazabilidad.findByPredioProduccion", query = "SELECT t FROM Trazabilidad t WHERE t.predioProduccion = :predioProduccion")
    , @NamedQuery(name = "Trazabilidad.findByRegistroICA", query = "SELECT t FROM Trazabilidad t WHERE t.registroICA = :registroICA")})
public class Trazabilidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTrazabilidad")
    private Integer idTrazabilidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "nombreEmpresa")
    private String nombreEmpresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "predioProduccion")
    private String predioProduccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "registroICA")
    private int registroICA;
    @JoinColumn(name = "idCiudad", referencedColumnName = "idCiudad")
    @ManyToOne(optional = false)
    private Ciudad idCiudad;
    @JoinColumn(name = "idProducto", referencedColumnName = "idProducto")
    @ManyToOne(optional = false)
    private Producto idProducto;

    public Trazabilidad() {
    }

    public Trazabilidad(Integer idTrazabilidad) {
        this.idTrazabilidad = idTrazabilidad;
    }

    public Trazabilidad(Integer idTrazabilidad, String nombreEmpresa, String predioProduccion, int registroICA) {
        this.idTrazabilidad = idTrazabilidad;
        this.nombreEmpresa = nombreEmpresa;
        this.predioProduccion = predioProduccion;
        this.registroICA = registroICA;
    }

    public Integer getIdTrazabilidad() {
        return idTrazabilidad;
    }

    public void setIdTrazabilidad(Integer idTrazabilidad) {
        this.idTrazabilidad = idTrazabilidad;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getPredioProduccion() {
        return predioProduccion;
    }

    public void setPredioProduccion(String predioProduccion) {
        this.predioProduccion = predioProduccion;
    }

    public int getRegistroICA() {
        return registroICA;
    }

    public void setRegistroICA(int registroICA) {
        this.registroICA = registroICA;
    }

    public Ciudad getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Ciudad idCiudad) {
        this.idCiudad = idCiudad;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTrazabilidad != null ? idTrazabilidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trazabilidad)) {
            return false;
        }
        Trazabilidad other = (Trazabilidad) object;
        if ((this.idTrazabilidad == null && other.idTrazabilidad != null) || (this.idTrazabilidad != null && !this.idTrazabilidad.equals(other.idTrazabilidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.expochick.backend.persistence.entity.Trazabilidad[ idTrazabilidad=" + idTrazabilidad + " ]";
    }
    
}
