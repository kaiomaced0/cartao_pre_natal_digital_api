package br.ka.resource;

import br.ka.dto.NutricaoDTO;
import br.ka.dto.NutricaoMamaeDTO;
import br.ka.dto.NutricaoResponseDTO;
import br.ka.model.EntityClass;
import br.ka.model.Nutricao;
import br.ka.service.NutricaoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.stream.Collectors;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/nutricao")
public class NutricaoResource {
    @Inject
    private NutricaoService service;


    @GET
    public List<Nutricao> getAll(){
        return service.findAll().stream().filter(EntityClass::getAtivo).collect(Collectors.toList());
    }
    @GET
    @Path("/{id}")
    public Nutricao getById(@PathParam("id") Long id) {
        return service.findById(id);
    }

    @POST
    public NutricaoResponseDTO create(NutricaoDTO entity) {
        return service.create(entity);
    }

    @POST
    @Path("/mamae")
    public NutricaoResponseDTO create(NutricaoMamaeDTO entity) {
        return service.createMamae(entity);
    }


    @PUT
    @Path("/{id}")
    public Nutricao update(@PathParam("id") Long id, Nutricao entity) {
        return service.update(entity);
    }

    @PATCH
    @Path("/delete/{id}")
    public void delete(@PathParam("id") Long id) {
        service.findById(id).setAtivo(false);
    }
}
