package br.ka.service;

import br.ka.model.Usuario;
import br.ka.repository.UsuarioRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UsuarioService extends  BaseService<Usuario, Long, UsuarioRepository> {
}
