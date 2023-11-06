package br.ka.resource;

import br.ka.dto.AcompanhamentoDTO;
import br.ka.model.Acompanhamento;
import br.ka.model.EntityClass;
import br.ka.service.AcompanhamentoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.stream.Collectors;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/acompanhamento")
public class AcompanhamentoResource {
    @Inject
    AcompanhamentoService service;

    @GET
    public List<Acompanhamento> getAll(){
        return service.findAll().stream().filter(EntityClass::getAtivo).collect(Collectors.toList());
    }
    @GET
    @Path("/{id}")
    public Acompanhamento getById(@PathParam("id") Long id) {
        return service.findById(id);
    }

    @POST
    public Acompanhamento create(AcompanhamentoDTO entity) {
        return service.create(entity);
    }

    @PUT
    @Path("/{id}")
    public Acompanhamento update(@PathParam("id") Long id, Acompanhamento entity) {
        return service.update(entity);
    }

    @PATCH
    @Path("/delete/{id}")
    public void delete(@PathParam("id") Long id) {
        service.del(id);
    }
}
