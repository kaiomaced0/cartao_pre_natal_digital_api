package br.ka.resource;

import br.ka.dto.ConsultaDTO;
import br.ka.dto.ConsultaResponseDTO;
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
    public List<ConsultaResponseDTO> getAll(){
        return service.findAll();
    }
    @GET
    @Path("/{id}")
    public ConsultaResponseDTO getById(@PathParam("id") Long id) {
        return service.findById(id);
    }

    @POST
    @Path("/{id}")
    public ConsultaResponseDTO create(@PathParam("id") Long id, ConsultaDTO entity) {
        return service.create(id, entity);
    }

    @PUT
    @Path("/{id}")
    public Consulta update(@PathParam("id") Long id, Consulta entity) {
        return service.update(entity);
    }

    @PATCH
    @Path("/delete/{id}")
    public void delete(@PathParam("id") Long id) {
        service.deleteById(id);
    }

}
