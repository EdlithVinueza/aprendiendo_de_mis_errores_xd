package org.programacion.distribuida.clients;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.programacion.distribuida.dtos.PrestamoDto;

import java.awt.*;
import java.util.List;

@RegisterRestClient(configKey = "prestamos-api")
@Path("/prestamos")
@Produces(MediaType.APPLICATION_JSON)

public interface PrestamoRestCliente {
    @GET
    @Path("/cliente/{clienteId}")
    List<PrestamoDto> getPrestamosByClienteId(@PathParam("clienteId") Integer clienteId);

}
