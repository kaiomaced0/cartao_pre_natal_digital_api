package br.ka.service;

import br.ka.dto.AuthUsuarioDTO;
import br.ka.dto.UsuarioDTO;
import br.ka.model.Gestacao;
import br.ka.model.Mamae;
import br.ka.model.Usuario;
import br.ka.repository.GestacaoRepository;
import br.ka.repository.MamaeRepository;
import br.ka.repository.UsuarioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class MamaeService extends  BaseService<Mamae, Long, MamaeRepository> {

    @Inject
    UsuarioService usuarioService;

    @Inject
    GestacaoRepository gestacaoRepository;


    public Response insert(UsuarioDTO usuarioDTO){

        usuarioService.insert(usuarioDTO);
        Usuario usuario = usuarioService.byLoginAndSenha(new AuthUsuarioDTO(usuarioDTO.email(), usuarioDTO.senha()));
        Mamae mamae = (Mamae) usuario;
        mamae.setEmGestacao(true);

        Gestacao gestacao = new Gestacao();
        gestacaoRepository.persist(gestacao);
        mamae.setGestacao(gestacao);

        repository.persist(mamae);

        return Response.status(Response.Status.OK).build();

    }
}
