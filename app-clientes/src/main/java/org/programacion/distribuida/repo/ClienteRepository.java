package org.programacion.distribuida.repo;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import org.programacion.distribuida.db.Cliente;

@ApplicationScoped
public class ClienteRepository implements PanacheRepositoryBase<Cliente, Integer> {

    public Cliente findByCedula(String cedula) {
        return find("cedula", cedula).firstResult();
    }
}
