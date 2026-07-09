package com.programacion.distribuida.repo;

import com.programacion.distribuida.db.Pago;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class PagoRepository implements PanacheRepositoryBase<Pago, Integer> {

    public List<Pago> findByPrestamoId(Integer idPrestamo){
        return find("idPrestamo",idPrestamo).list();
    }
}
