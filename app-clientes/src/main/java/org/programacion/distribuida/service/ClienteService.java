package org.programacion.distribuida.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.programacion.distribuida.clients.PrestamoRestCliente;
import org.programacion.distribuida.db.Cliente;
import org.programacion.distribuida.dtos.PrestamoDto;
import org.programacion.distribuida.dtos.RespuestClienteDto;
import org.programacion.distribuida.repo.ClienteRepository;

import java.math.BigDecimal;
import java.util.List;

@ApplicationScoped
public class ClienteService {
    @Inject
    ClienteRepository clienteRepository;

    @Inject
    @RestClient
    PrestamoRestCliente prestamoRestCliente; //nuevo cliente HTTP

    public RespuestClienteDto consultarPrstamoCLiente(String cedula) {
        Cliente cliente = clienteRepository.findByCedula(cedula);
        if (cliente == null) {
            return null;
        }
        List<PrestamoDto> prestamos = prestamoRestCliente.getPrestamosByClienteId(cliente.getId());

        BigDecimal montoTotal = BigDecimal.ZERO;

        if (prestamos != null) {
            for (PrestamoDto p : prestamos) {
                montoTotal = montoTotal.add(p.getMontoTotal());

            }
        }

        RespuestClienteDto respuesta = new RespuestClienteDto();
        respuesta.setCedula(cliente.getCedula());
        respuesta.setEmail(cliente.getEmail());
        respuesta.setPrestamos(prestamos);
        respuesta.setMontoTotalPrestamos(montoTotal);
        return respuesta;


    }
}
