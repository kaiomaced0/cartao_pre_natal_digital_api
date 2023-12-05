package br.ka.resource;

import br.ka.dto.GestacaoDTO;
import br.ka.dto.GestacaoResponseDTO;
import br.ka.dto.GestacaoUpdateDTO;
import br.ka.model.EntityClass;
import br.ka.model.Gestacao;
import br.ka.service.GestacaoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.stream.Collectors;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/gestacao")
public class GestacaoResource {
    @Inject
    private GestacaoService service;


    @GET
    public List<GestacaoResponseDTO> getAll(){
        return service.findAll().stream().filter(EntityClass::getAtivo).map(GestacaoResponseDTO:: new).collect(Collectors.toList());
    }
    @GET
    @Path("/{id}")
    public GestacaoResponseDTO getById(@PathParam("id") Long id) {
        return new GestacaoResponseDTO(service.findById(id));
    }

    @POST
    public GestacaoResponseDTO create(GestacaoDTO entity) {
        return service.create(entity);
    }

    @PUT
    @Path("/{id}")
    public GestacaoResponseDTO update(@PathParam("id") Long id, GestacaoUpdateDTO entity) {
        return service.update(id, entity);
    }

    @PATCH
    @Path("/delete/{id}")
    public void delete(@PathParam("id") Long id) {
        service.findById(id).setAtivo(false);
    }
}
