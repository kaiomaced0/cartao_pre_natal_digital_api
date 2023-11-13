package br.ka.resource;

import br.ka.model.Consulta;
import br.ka.model.EntityClass;
import br.ka.service.ConsultaService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.stream.Collectors;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/consulta")
public class ConsultaResource {
    @Inject
    private ConsultaService service;

    @GET
    public List<Consulta> getAll(){
        return service.findAll().stream().filter(EntityClass::getAtivo).collect(Collectors.toList());
    }
    @GET
    @Path("/{id}")
    public Consulta getById(@PathParam("id") Long id) {
        return service.findById(id);
    }

    @POST
    public Consulta create(Consulta entity) {
        return service.create(entity);
    }

    @PUT
    @Path("/{id}")
    public Consulta update(@PathParam("id") Long id, Consulta entity) {
        return service.update(entity);
    }

    @PATCH
    @Path("/delete/{id}")
    public void delete(@PathParam("id") Long id) {
        service.findById(id).setAtivo(false);
    }

}
