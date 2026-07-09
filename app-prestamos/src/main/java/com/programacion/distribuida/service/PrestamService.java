package com.programacion.distribuida.service;

import com.programacion.distribuida.db.Prestamo;
import com.programacion.distribuida.repo.PrestamoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class PrestamService {
    @Inject
    PrestamoRepository prestamoRepository;
    public List<Prestamo> obtenerPrestamosPorCliente (Integer iCliente){
        return prestamoRepository.findByClienteId(iCliente);
    }
}
