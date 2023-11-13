package br.ka.resource;

import br.ka.dto.MamaeResponseDTO;
import br.ka.dto.UsuarioResponseDTO;
import br.ka.repository.MamaeRepository;
import br.ka.service.UsuarioLogadoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/usuariologado")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioLogadoResource {
    @Inject
    UsuarioLogadoService usuarioLogadoService;

    @Inject
    MamaeRepository repository;

    @GET
    public UsuarioResponseDTO getUsuarioLogado() {
        return usuarioLogadoService.getPerfilUsuarioLogado();
    }

}