package br.ka.repository;

import br.ka.model.Usuario;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UsuarioRepository extends BaseRepository<Usuario, Long> {
}
