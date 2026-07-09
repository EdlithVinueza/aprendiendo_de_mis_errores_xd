package com.programacion.distribuida.db;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "pagos")
@Getter
@Setter
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fecha_pago")
    private LocalDate fechaPago;

    @Column(name = "monto_pago")
    private BigDecimal montoPago;

    @Column(name = "prestamo_id")
    private Integer prestamoId;




}
