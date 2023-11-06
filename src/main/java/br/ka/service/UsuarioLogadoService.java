package br.ka.service;

import br.ka.dto.UsuarioResponseDTO;
import br.ka.model.Usuario;
import br.ka.repository.UsuarioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.jwt.JsonWebToken;

@ApplicationScoped
public class UsuarioLogadoService {

    @Inject
    JsonWebToken jsonWebToken;

    @Inject
    UsuarioService usuarioService;

    @Inject
    UsuarioRepository usuarioRepository;

    @Inject
    HashService hash;

    public UsuarioResponseDTO getPerfilUsuarioLogado() {

        try{
            String cpf = jsonWebToken.getSubject();
            Usuario user = usuarioRepository.findByCpf(cpf);

            return new UsuarioResponseDTO(user);
        } catch (Exception e) {

            return null;
        }
    }

}



