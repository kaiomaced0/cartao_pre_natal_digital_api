package br.ka.service;

import br.ka.dto.*;
import br.ka.model.Gestacao;
import br.ka.model.Mamae;
import br.ka.model.Perfil;
import br.ka.model.Usuario;
import br.ka.repository.*;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.jwt.JsonWebToken;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
    VacinaService vacinaService;

    @Inject
    JsonWebToken jsonWebToken;

    public Response getUsuarioLogado() {
        try {
            return Response.ok(new MamaeResponseDTO(repository.findByIdModificado(jsonWebToken.getSubject()))).build();
        }catch (Exception e){
            return Response.status(Response.Status.NO_CONTENT).build();
        }

    }

    public Response getAcompanhamentos() {
        try {

            return Response.ok(repository.findByIdModificado(jsonWebToken.getSubject()).getAcompanhamentos().stream().map(AcompanhamentoResponseDTO::new).collect(Collectors.toList())).build();
        }catch (Exception e){
            return Response.status(Response.Status.NO_CONTENT).build();
        }

    }
    public Response getConsultas() {
        try {

            return Response.ok(repository.findByIdModificado(jsonWebToken.getSubject()).getConsultas().stream().map(ConsultaResponseDTO::new).collect(Collectors.toList())).build();
        }catch (Exception e){
            return Response.status(Response.Status.NO_CONTENT).build();
        }

    }

    public Response getExames() {
        try {

            return Response.ok(repository.findByIdModificado(jsonWebToken.getSubject()).getExames().stream().map(ExameResponseDTO::new).collect(Collectors.toList())).build();
        }catch (Exception e){
            return Response.status(Response.Status.NO_CONTENT).build();
        }

    }

    public Response getMedico(){
        try {

            return Response.ok(new MedicoResponseDTO(repository.findByIdModificado(jsonWebToken.getSubject()).getMedico())).build();
        }catch (Exception e){
            return Response.status(Response.Status.NO_CONTENT).build();
        }
    }
    @Transactional
    public Response insertVacina(VacinaDTO vacinaDTO){
        Mamae m = repository.findByIdModificado(jsonWebToken.getSubject());
        return vacinaService.insert(m.getId(),vacinaDTO);
    }

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
        Usuario u = usuarioRepository.findByIdModificado(jsonWebToken.getSubject());
        repository.findById(u.getId()).setConvenio(convenio);
        return Response.status(Response.Status.OK).build();
    }

    @Transactional
    public Response mudarDadosMamae(MudarDadosMamaeDTO mudarDadosMamaeDTO){
        Usuario u = usuarioRepository.findByIdModificado(jsonWebToken.getSubject());
        repository.findById(u.getId()).getGestacao().setNomeBebe(mudarDadosMamaeDTO.nomeBebe());
        repository.findById(u.getId()).setContatoEmergencia(mudarDadosMamaeDTO.contatoEmergencia());
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
