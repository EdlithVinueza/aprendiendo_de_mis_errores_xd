package com.programacion.distribuida.repo;

import com.programacion.distribuida.db.Prestamo;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class PrestamoRepository implements PanacheRepositoryBase<Prestamo, Integer> {

    public List<Prestamo> findByClienteId(Integer clienteId) {

        return find("clienteId", clienteId).list();
    }
}
