package br.ka.resource;

import br.ka.dto.MedicoDTO;
import br.ka.dto.MedicoResponseDTO;
import br.ka.model.EntityClass;
import br.ka.model.Medico;
import br.ka.service.MedicoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.stream.Collectors;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/medico")
public class MedicoResource {
    @Inject
    private MedicoService service;


    @GET
    public List<MedicoResponseDTO> getAll(){
        return service.findAll().stream().filter(EntityClass::getAtivo).map(MedicoResponseDTO::new).collect(Collectors.toList());
    }
    @GET
    @Path("/{id}")
    public MedicoResponseDTO getById(@PathParam("id") Long id) {
        return new MedicoResponseDTO(service.findById(id));
    }

    @POST
    public MedicoResponseDTO create(MedicoDTO entity) {
        return service.create(entity);
    }

    @PUT
    @Path("/{id}")
    public Medico update(@PathParam("id") Long id, Medico entity) {
        return service.update(entity);
    }

    @PATCH
    @Path("/delete/{id}")
    public void delete(@PathParam("id") Long id) {
        service.findById(id).setAtivo(false);
    }
}
