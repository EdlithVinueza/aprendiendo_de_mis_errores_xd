package org.programacion.distribuida.dtos;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PrestamoDto {
    private Integer id;
    private BigDecimal montoTotal;
    private BigDecimal tasaInteres;
}
