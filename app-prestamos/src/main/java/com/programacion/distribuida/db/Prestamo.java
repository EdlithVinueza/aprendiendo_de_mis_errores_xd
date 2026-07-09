package com.programacion.distribuida.db;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Entity
@Table(name = "prestamos")
@Getter
@Setter
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name ="monto_total")
    private BigDecimal montoTotal;

    @Column (name = "tasa_interes")
    private BigDecimal tasaInteres;

    @Column(name = "cliente_id")
    private Integer clienteId;
}
