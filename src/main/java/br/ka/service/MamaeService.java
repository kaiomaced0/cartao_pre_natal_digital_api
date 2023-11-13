package br.ka.service;

import br.ka.dto.AuthUsuarioDTO;
import br.ka.dto.MudarSenhaDTO;
import br.ka.dto.UsuarioDTO;
import br.ka.model.Gestacao;
import br.ka.model.Mamae;
import br.ka.model.Perfil;
import br.ka.model.Usuario;
import br.ka.repository.GestacaoRepository;
import br.ka.repository.MamaeRepository;
import br.ka.repository.UsuarioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ApplicationScoped
public class MamaeService{

    @Inject
    GestacaoRepository gestacaoRepository;

    @Inject
    MamaeRepository repository;
    @Inject
    HashService hash;

    @Inject
    UsuarioRepository usuarioRepository;

    @Inject
    UsuarioLogadoService usuarioLogadoService;


    @Transactional
    public Response insert(UsuarioDTO usuarioDTO){

        Mamae mamae = new Mamae();
        mamae.setNome(usuarioDTO.nome());
        mamae.setCpf(usuarioDTO.cpf());
        mamae.setEmail(usuarioDTO.email());
        mamae.setSenha(hash.getHashSenha(usuarioDTO.senha()));
        Set<Perfil> a = new HashSet<Perfil>();
        a.add(Perfil.USER);
        mamae.setPerfis(a);
        repository.persist(mamae);
        mamae.setEmGestacao(true);
        Gestacao gestacao = new Gestacao();
        gestacaoRepository.persist(gestacao);
        mamae.setGestacao(gestacao);

        return Response.status(Response.Status.OK).build();

    }

    @Transactional
    public Response mudarSenha(MudarSenhaDTO mudarSenhaDTO){
        Usuario u = new Usuario();
        u = usuarioRepository.findByCpfAndSenha(mudarSenhaDTO.login(), hash.getHashSenha(mudarSenhaDTO.senhaAntiga()));
        if(u == null){
            u = usuarioRepository.findByEmailAndSenha(mudarSenhaDTO.login(), hash.getHashSenha(mudarSenhaDTO.senhaAntiga()));
            if(u == null){
                return Response.status(Response.Status.NO_CONTENT).build();
            }
        }
        u.setSenha(hash.getHashSenha(mudarSenhaDTO.novaSenha()));
        return Response.status(Response.Status.OK).build();
    }

    @Transactional
    public Response setConvenio(String convenio){
        Usuario u = usuarioRepository.findByCpf(usuarioLogadoService.getPerfilUsuarioLogado().cpf());
        repository.findById(u.getId()).setConvenio(convenio);
        return Response.status(Response.Status.OK).build();
    }


    public List<Mamae> findAll() {
        return repository.listAll();
    }

    public Mamae findById(Long id) {
        return repository
                .findById(id);
    }

    @Transactional
    public Mamae update(Mamae entity) {
        return repository.getEntityManager().merge(entity);
    }

    @Transactional
    public void deleteById(Long id) {
        repository.findById(id).setAtivo(false);
    }
}
