package com.integrity.cajachica.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "Rendicion_Gastos") // Especifica el nombre de la tabla en la base de datos
public class RendicionGastos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Incremento automático
    private int rendicion_id;

    @Column(nullable = false, length = 20) // Longitud máxima para el número de comprobante
    private String num_comprobante;

    @Column(length = 255) // Longitud máxima para la descripción del gasto
    private String descripcion_gasto;

    @Column(nullable = false, precision = 10, scale = 2) // Para valores decimales
    private BigDecimal monto;

    @Column(nullable = false)
    private Date fecha_registro; // Fecha de registro

    @ManyToOne // Relación muchos a uno con Caja_Chica
    @JoinColumn(name = "caja_id", nullable = false) // Columna de unión y no puede ser nula
    private CajaChica caja; // Objeto CajaChica asociado

    @ManyToOne // Relación muchos a uno con Tipo_Comprobante
    @JoinColumn(name = "tipo_comprobante_id", nullable = false) // Columna de unión y no puede ser nula
    private TipoComprobante tipoComprobante; // Objeto TipoComprobante asociado

    @ManyToOne // Relación muchos a uno con Categoria_Gasto
    @JoinColumn(name = "categoria_id", nullable = false) // Columna de unión y no puede ser nula
    private CategoriaGasto categoria; // Objeto CategoriaGasto asociado

    // Getters y setters
    public int getRendicion_id() {
        return rendicion_id;
    }

    public void setRendicion_id(int rendicion_id) {
        this.rendicion_id = rendicion_id;
    }

    public String getNum_comprobante() {
        return num_comprobante;
    }

    public void setNum_comprobante(String num_comprobante) {
        this.num_comprobante = num_comprobante;
    }

    public String getDescripcion_gasto() {
        return descripcion_gasto;
    }

    public void setDescripcion_gasto(String descripcion_gasto) {
        this.descripcion_gasto = descripcion_gasto;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

   // Método para obtener la caja asociada a la rendición de gastos
   public CajaChica getCaja() {
       return caja;
   }

   // Método para establecer la caja asociada a la rendición de gastos
   public void setCaja(CajaChica caja) {
       this.caja = caja;
   }

   // Método para obtener el tipo de comprobante asociado a la rendición de gastos
   public TipoComprobante getTipoComprobante() {
       return tipoComprobante;
   }

   // Método para establecer el tipo de comprobante asociado a la rendición de gastos
   public void setTipoComprobante(TipoComprobante tipoComprobante) {
       this.tipoComprobante = tipoComprobante;
   }

   // Método para obtener la categoría asociada a la rendición de gastos
   public CategoriaGasto getCategoria() {
       return categoria;
   }

   // Método para establecer la categoría asociada a la rendición de gastos
   public void setCategoria(CategoriaGasto categoria) {
       this.categoria = categoria;
   }
}