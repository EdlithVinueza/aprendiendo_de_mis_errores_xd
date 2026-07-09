package com.programacion.distribuida.rest;

import com.programacion.distribuida.db.Prestamo;
import com.programacion.distribuida.service.PrestamService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/prestamos")
@Produces(MediaType.APPLICATION_JSON)
public class PrestamoRest {

    @Inject
    PrestamService prestamService;

    @GET
    @Path("/cliente/{idCliente}")
    public List<Prestamo> getPrestamosPorCliente(@PathParam("idCliente") Integer idCliente) {
        return prestamService.obtenerPrestamosPorCliente(idCliente);
    }
}
