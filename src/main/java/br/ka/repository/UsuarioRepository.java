package br.ka.repository;

import br.ka.model.Usuario;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class UsuarioRepository extends BaseRepository<Usuario, Long> {

    public List<Usuario> findByNome(String nome){
        if (nome == null)
            return null;
        return find("UPPER(nome) LIKE ?1 ", "%"+nome.toUpperCase()+"%").list();
    }

    public Usuario findByEmailAndSenha(String email, String senha){
        if (email == null || senha == null)
            return null;

        return find("email = ?1 AND senha = ?2 ", email, senha).firstResult();
    }

    public Usuario findByCpf(String cpf){
        if (cpf == null)
            return null;

        return find("cpf = ?1", cpf).firstResult();
    }
}
