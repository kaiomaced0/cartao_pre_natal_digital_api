package br.ka.resource;

import br.ka.dto.VacinaDTO;
import br.ka.dto.VacinaResponseDTO;
import br.ka.model.EntityClass;
import br.ka.model.Vacina;
import br.ka.service.VacinaService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.stream.Collectors;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/vacina")
public class VacinaResource {
    @Inject
    private VacinaService service;


    @GET
    public List<VacinaResponseDTO> getAll(){
        return service.findAll();
    }
    @GET
    @Path("/{id}")
    public VacinaResponseDTO getById(@PathParam("id") Long id) {
        return service.findById(id);
    }

    @POST
    @Path("/{id}")
    public Response insert(@PathParam("id") Long id, VacinaDTO entity) {
        return service.insert(id, entity);
    }

    @PUT
    @Path("/{id}")
    public Vacina update(@PathParam("id") Long id, Vacina entity) {
        return service.update(entity);
    }

    @PATCH
    @Path("/delete/{id}")
    public void delete(@PathParam("id") Long id) {
        service.deleteById(id);
    }
}
