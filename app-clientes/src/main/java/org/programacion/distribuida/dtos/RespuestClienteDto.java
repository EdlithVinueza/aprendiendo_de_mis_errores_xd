package org.programacion.distribuida.dtos;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class RespuestClienteDto {
    private String cedula;
    private String email;
    private BigDecimal montoTotalPrestamos;
    private List<PrestamoDto> prestamos;
}
