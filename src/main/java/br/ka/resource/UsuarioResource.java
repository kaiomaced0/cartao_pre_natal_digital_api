package br.ka.resource;

import br.ka.model.Usuario;
import br.ka.service.UsuarioService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/usuario")
public class UsuarioResource {
    @Inject
    private UsuarioService service;


    @GET
    public List<Usuario> getAll(){
        return service.findAll();
    }
    @GET
    @Path("/{id}")
    public Usuario getById(@PathParam("id") Long id) {
        return service.findById(id);
    }

    @POST
    public Usuario create(Usuario entity) {
        return service.create(entity);
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
