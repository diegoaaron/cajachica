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
@Table(name = "Movimientos_Caja_Chica") // Especifica el nombre de la tabla en la base de datos
public class MovimientosCajaChica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Incremento automático
    private int movimiento_id;

    @Column(nullable = false)
    private boolean tipo_movimiento; // 0: Ingreso, 1: Egreso

    @Column(nullable = false, precision = 10, scale = 2) // Para valores decimales
    private BigDecimal monto_movimiento;

    @Column(nullable = false)
    private Date fecha_movimiento; // Fecha del movimiento

    @Column(nullable = false, precision = 10, scale = 2) // Para valores decimales
    private BigDecimal saldo_resultante; // Saldo después del movimiento

    @ManyToOne // Relación muchos a uno con Caja_Chica
    @JoinColumn(name = "caja_id", nullable = false) // Columna de unión y no puede ser nula
    private CajaChica caja; // Objeto CajaChica asociado

    // Getters y setters
    public int getMovimiento_id() {
        return movimiento_id;
    }

    public void setMovimiento_id(int movimiento_id) {
        this.movimiento_id = movimiento_id;
    }

    public boolean isTipo_movimiento() {
        return tipo_movimiento;
    }

    public void setTipo_movimiento(boolean tipo_movimiento) {
        this.tipo_movimiento = tipo_movimiento;
    }

    public BigDecimal getMonto_movimiento() {
        return monto_movimiento;
    }

    public void setMonto_movimiento(BigDecimal monto_movimiento) {
        this.monto_movimiento = monto_movimiento;
    }

    public Date getFecha_movimiento() {
        return fecha_movimiento;
    }

    public void setFecha_movimiento(Date fecha_movimiento) {
        this.fecha_movimiento = fecha_movimiento;
    }

    public BigDecimal getSaldo_resultante() {
        return saldo_resultante;
    }

    public void setSaldo_resultante(BigDecimal saldo_resultante) {
        this.saldo_resultante = saldo_resultante;
    }

   // Método para obtener la caja asociada al movimiento
   public CajaChica getCaja() {
       return caja;
   }

   // Método para establecer la caja asociada al movimiento
   public void setCaja(CajaChica caja) {
       this.caja = caja;
   }
}