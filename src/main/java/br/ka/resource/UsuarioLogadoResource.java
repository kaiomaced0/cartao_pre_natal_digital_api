package br.ka.resource;

import br.ka.dto.MamaeResponseDTO;
import br.ka.dto.UsuarioResponseDTO;
import br.ka.repository.MamaeRepository;
import br.ka.repository.UsuarioRepository;
import br.ka.service.UsuarioLogadoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.jwt.JsonWebToken;

@Path("/usuariologado")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioLogadoResource {
    @Inject
    UsuarioLogadoService usuarioLogadoService;

    @Inject
    UsuarioRepository repository;

    @Inject
    JsonWebToken jsonWebToken;

    @GET
    public Response getUsuarioLogado() {
        try {
            return Response.ok(new UsuarioResponseDTO(repository.findByCpf(jsonWebToken.getSubject()))).build();
        }catch (Exception e){
            return Response.status(Response.Status.NO_CONTENT).build();
        }

    }
}