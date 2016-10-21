
package com.co.hsg.innventa.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author hectsaga
 */
@Entity
@Table(name = "productos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productos.findAll", query = "SELECT p FROM Productos p WHERE p.eliminado=0 Order by p.nombre"),
    @NamedQuery(name = "Productos.findById", query = "SELECT p FROM Productos p WHERE p.id = :id"),
    @NamedQuery(name = "Productos.findByReferencia", query = "SELECT p FROM Productos p WHERE p.referencia = :referencia"),
    @NamedQuery(name = "Productos.findByCodigo", query = "SELECT p FROM Productos p WHERE p.codigo = :codigo"),
    @NamedQuery(name = "Productos.findByType", query = "SELECT p FROM Productos p WHERE p.tipoCodigo = :type AND p.eliminado=0 Order by p.nombre"),
    @NamedQuery(name = "Productos.findByNombre", query = "SELECT p FROM Productos p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Productos.delete", query = "UPDATE Productos p SET p.eliminado = 1 WHERE p.id =:id"),
})
public class Productos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 36)
    @Column(name = "id")
    private String id;
    @Size(max = 255)
    @Column(name = "referencia")
    private String referencia;
    @Size(max = 255)
    @Column(name = "codigo")
    private String codigo;
 
    @Column(name = "tipo_codigo")
    private String tipoCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_compra")
    private double precioCompra;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio_venta")
    private Double precioVenta;
    @Size(max = 36)
    @Column(name = "categoria_impuesto")
    private String categoriaImpuesto;
    @Size(max = 36)
    @Column(name = "atributo")
    private String atributo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stock")
    private double stock;
    @Size(max = 500)
    @Column(name = "observaciones")
    private String observaciones;

    @Column(name = "cantidad_unidades")
    private short cantUnidades;
      
    
    @JoinColumn(name = "categoria", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Categorias categoria;
    @JoinColumn(name = "unidad_medida", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UnidadesMedida unidadMedida;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 36)
    @Column(name = "creado_por")
    private String creadoPor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 36)
    @Column(name = "modificado_por")
    private String modificadoPor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "eliminado")
    private short eliminado;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProducto")
    private List<PedidosProducto> pedidosProductoList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "componente")
    private List<ProductosComponentes> productosParte;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productoPadre")
    private List<ProductosComponentes> productosHijos;

    public Productos() {
    }

    public Productos(String id) {
        this.id = id;
    }

    public Productos(String id, String nombre, double precioCompra,double stock, String creadoPor, String modificadoPor, short eliminado) {
        this.id = id;
        this.nombre = nombre;
        this.precioCompra = precioCompra;
        this.stock = stock;
        this.creadoPor = creadoPor;
        this.modificadoPor = modificadoPor;
        this.eliminado = eliminado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipoCodigo() {
        return tipoCodigo;
    }

    public void setTipoCodigo(String tipoCodigo) {
        this.tipoCodigo = tipoCodigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Categorias getCategoria() {
        return categoria;
    }

    public void setCategoria(Categorias categoria) {
        this.categoria = categoria;
    }

    public String getCategoriaImpuesto() {
        return categoriaImpuesto;
    }

    public void setCategoriaImpuesto(String categoriaImpuesto) {
        this.categoriaImpuesto = categoriaImpuesto;
    }

    public String getAtributo() {
        return atributo;
    }

    public void setAtributo(String atributo) {
        this.atributo = atributo;
    }

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }

    public String getCreadoPor() {
        return creadoPor;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public UnidadesMedida getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(UnidadesMedida unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public void setCreadoPor(String creadoPor) {
        this.creadoPor = creadoPor;
    }

     public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getModificadoPor() {
        return modificadoPor;
    }

    public void setModificadoPor(String modificadoPor) {
        this.modificadoPor = modificadoPor;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public short getEliminado() {
        return eliminado;
    }

    public void setEliminado(short eliminado) {
        this.eliminado = eliminado;
    }

    public short getCantUnidades() {
        return cantUnidades;
    }

    public void setCantUnidades(short cantUnidades) {
        this.cantUnidades = cantUnidades;
    }

    @XmlTransient
    public List<PedidosProducto> getPedidosProductoList() {
        return pedidosProductoList;
    }

    public void setPedidosProductoList(List<PedidosProducto> pedidosProductoList) {
        this.pedidosProductoList = pedidosProductoList;
    }
    
    @XmlTransient
    public List<ProductosComponentes> getProductosParte() {
        if(productosParte == null){
            productosParte = new ArrayList<>();
        }
        return productosParte;
    }

    public void setProductosParte(List<ProductosComponentes> productosParte) {
        this.productosParte = productosParte;
    }
    
    @XmlTransient
    public List<ProductosComponentes> getProductosHijos() {
        if(productosHijos == null){
            productosHijos = new ArrayList<>();
        }
        return productosHijos;
    }

    public void setProductosHijos(List<ProductosComponentes> productosHijos) {
        this.productosHijos = productosHijos;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productos)) {
            return false;
        }
        Productos other = (Productos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.hsg.innventa.beans.Productos[ id=" + id + " ]";
    }
    
}
