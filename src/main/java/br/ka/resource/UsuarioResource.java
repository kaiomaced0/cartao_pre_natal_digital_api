package br.ka.resource;

import br.ka.dto.UsuarioDTO;
import br.ka.dto.UsuarioResponseDTO;
import br.ka.model.Usuario;
import br.ka.service.UsuarioService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.stream.Collectors;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/usuario")
public class UsuarioResource {
    @Inject
    private UsuarioService service;


    @GET
    public List<UsuarioResponseDTO> getAll(){
        return service.findAll().stream().map(UsuarioResponseDTO::new).collect(Collectors.toList());
    }
    @GET
    @Path("/{id}")
    public UsuarioResponseDTO getById(@PathParam("id") Long id) {
        return new UsuarioResponseDTO(service.findById(id));
    }

    @POST
    public Response create(UsuarioDTO entity) {
        return service.insert(entity);
    }

    @PUT
    @Path("/{id}")
    public Usuario update(@PathParam("id") Long id, Usuario entity) {
        return service.update(entity);
    }

    @PATCH
    @Path("/delete/{id}")
    public void delete(@PathParam("id") Long id) {
        service.findById(id).setAtivo(false);
    }
}
