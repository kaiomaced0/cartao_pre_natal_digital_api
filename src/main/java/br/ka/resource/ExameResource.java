package br.ka.resource;

import br.ka.dto.ExameDTO;
import br.ka.dto.ExameResponseDTO;
import br.ka.model.Exame;
import br.ka.service.ExameService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.stream.Collectors;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/exame")
public class ExameResource {
    @Inject
    private ExameService service;


    @GET
    public List<ExameResponseDTO> getAll(){
        return service.findAll().stream().map(ExameResponseDTO::new).collect(Collectors.toList());
    }
    @GET
    @Path("/{id}")
    public ExameResponseDTO getById(@PathParam("id") Long id) {
        return new ExameResponseDTO(service.findById(id));
    }

    @POST
    public Response create(ExameDTO entity) {
        return service.insert(entity);
    }

//    @PUT
//    @Path("/{id}")
//    public Exame update(@PathParam("id") Long id, Exame entity) {
//        return service.update(entity);
//    }

    @PATCH
    @Path("/delete/{id}")
    public void delete(@PathParam("id") Long id) {
        service.findById(id).setAtivo(false);
    }
}
