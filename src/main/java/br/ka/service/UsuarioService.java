package br.ka.service;

import br.ka.dto.AuthUsuarioDTO;
import br.ka.dto.UsuarioDTO;
import br.ka.model.Perfil;
import br.ka.model.Usuario;
import br.ka.repository.UsuarioRepository;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class UsuarioService extends  BaseService<Usuario, Long, UsuarioRepository> {
    @Inject
    HashService hashService;

    @Inject
    UsuarioRepository repository;
    @Inject
    HashService hash;

    public Usuario byLoginAndSenha(AuthUsuarioDTO authDTO){
        String hash = hashService.getHashSenha(authDTO.senha());
        Usuario usuario = repository.findByEmailAndSenha(authDTO.email(), hash);

        return usuario;
    }

    @Transactional
    public Response insert(UsuarioDTO usuarioDTO) {
        try {
            Log.info("Requisição Usuario.insert()");
            Usuario usuario = UsuarioDTO.criaUsuario(usuarioDTO);
            if (usuarioDTO.getClass() == null) {
                throw new Exception("Usuario nulo");
            }
            usuario.getPerfis().add(Perfil.USER);
            usuario.setSenha(hash.getHashSenha(usuario.getSenha()));
            repository.persist(usuario);
            return Response.ok(usuario).build();

        } catch (Exception e) {
            Log.error("Erro ao rodar Requisição Usuario.insert()" + e.getMessage());
            return Response.notModified().build();
        }

    }
}
