package org.programacion.distribuida.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.programacion.distribuida.dtos.RespuestClienteDto;
import org.programacion.distribuida.service.ClienteService;

@Path("/clientes")
@Produces(MediaType.APPLICATION_JSON)
public class ClientRest {
    @Inject
    ClienteService clienteService;

    @GET
    @Path("/{cedula}/prestamos")
    public Response obtenerResumenCliente(@PathParam("cedula") String cedula) {

        RespuestClienteDto resumen = clienteService.consultarPrstamoCLiente(cedula);

        if (resumen == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(resumen).build();
    }
}
