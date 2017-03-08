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
import javax.persistence.Lob;
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
@Table(name = "productos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")
    , @NamedQuery(name = "Producto.findByIdProducto", query = "SELECT p FROM Producto p WHERE p.idProducto = :idProducto")
    , @NamedQuery(name = "Producto.findByNombreProducto", query = "SELECT p FROM Producto p WHERE p.nombreProducto = :nombreProducto")
    , @NamedQuery(name = "Producto.findByDescripcion", query = "SELECT p FROM Producto p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "Producto.findByCategoria", query = "SELECT p FROM Producto p WHERE p.categoria = :categoria")
    , @NamedQuery(name = "Producto.findByCalibre", query = "SELECT p FROM Producto p WHERE p.calibre = :calibre")
    , @NamedQuery(name = "Producto.findByGradoMadurez", query = "SELECT p FROM Producto p WHERE p.gradoMadurez = :gradoMadurez")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProducto")
    private Integer idProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nombreProducto")
    private String nombreProducto;
    @Size(max = 255)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "categoria")
    private int categoria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "calibre")
    private int calibre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gradoMadurez")
    private int gradoMadurez;
    @Lob
    @Size(max = 65535)
    @Column(name = "foto")
    private String foto;
    @JoinColumn(name = "idEstadoProducto", referencedColumnName = "idEstadoProducto")
    @ManyToOne(optional = false)
    private Estadoproducto idEstadoProducto;
    @JoinColumn(name = "idPrecioCantidad", referencedColumnName = "idPrecioCantidad")
    @ManyToOne(optional = false)
    private Preciocantidade idPrecioCantidad;
    @JoinColumn(name = "idPresentacion", referencedColumnName = "idPresentacion")
    @ManyToOne(optional = false)
    private Presentacion idPresentacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProducto")
    private Collection<Trazabilidad> trazabilidadCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProducto")
    private Collection<Detallepedido> detallepedidoCollection;

    public Producto() {
    }

    public Producto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Producto(Integer idProducto, String nombreProducto, int categoria, int calibre, int gradoMadurez) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.categoria = categoria;
        this.calibre = calibre;
        this.gradoMadurez = gradoMadurez;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public int getCalibre() {
        return calibre;
    }

    public void setCalibre(int calibre) {
        this.calibre = calibre;
    }

    public int getGradoMadurez() {
        return gradoMadurez;
    }

    public void setGradoMadurez(int gradoMadurez) {
        this.gradoMadurez = gradoMadurez;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Estadoproducto getIdEstadoProducto() {
        return idEstadoProducto;
    }

    public void setIdEstadoProducto(Estadoproducto idEstadoProducto) {
        this.idEstadoProducto = idEstadoProducto;
    }

    public Preciocantidade getIdPrecioCantidad() {
        return idPrecioCantidad;
    }

    public void setIdPrecioCantidad(Preciocantidade idPrecioCantidad) {
        this.idPrecioCantidad = idPrecioCantidad;
    }

    public Presentacion getIdPresentacion() {
        return idPresentacion;
    }

    public void setIdPresentacion(Presentacion idPresentacion) {
        this.idPresentacion = idPresentacion;
    }

    @XmlTransient
    public Collection<Trazabilidad> getTrazabilidadCollection() {
        return trazabilidadCollection;
    }

    public void setTrazabilidadCollection(Collection<Trazabilidad> trazabilidadCollection) {
        this.trazabilidadCollection = trazabilidadCollection;
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
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.expochick.backend.persistence.entity.Producto[ idProducto=" + idProducto + " ]";
    }
    
}
