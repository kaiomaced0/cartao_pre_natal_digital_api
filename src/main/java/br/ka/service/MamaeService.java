package br.ka.service;

import br.ka.dto.*;
import br.ka.model.*;
import br.ka.repository.*;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.jwt.JsonWebToken;

import java.util.ArrayList;
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

    @Inject
    ObservacaoRepository observacaoRepository;

    @Inject
    NutricaoRepository nutricaoRepository;

    public Response getUsuarioLogado() {
        try {
            Mamae m = repository.findById(usuarioRepository.findByCpf(jsonWebToken.getSubject()).getId());
            MamaeResponseDTO mamaeResponseDTO = new MamaeResponseDTO(m);
            return Response.ok(mamaeResponseDTO).build();
        }catch (Exception e){
                return Response.status(Response.Status.NO_CONTENT).build();
        }
    }

    public Response getNutricao(){
        try {
            List<Nutricao> nutricoes = new ArrayList<>();
            Mamae m = repository.findById(usuarioRepository.findByCpf(jsonWebToken.getSubject()).getId());
            nutricoes = nutricaoRepository.findAll().stream().filter(nutricao -> !nutricao.getEspecifico() || nutricao.getEspecifico() && nutricao.getMamae().getId() == m.getId()).collect(Collectors.toList());
            return Response.ok(nutricoes.stream().map(NutricaoResponseDTO::new).collect(Collectors.toList())).build();
        }catch (Exception e){
            return Response.status(Response.Status.NO_CONTENT).build();
        }
    }

    public Response getConsultas() {
        try {

            return Response.ok(repository.findByIdModificado(usuarioRepository.findByCpf(jsonWebToken.getSubject()).getId().toString()).getConsultas().stream().map(ConsultaResponseDTO::new).collect(Collectors.toList())).build();
        }catch (Exception e){
            return Response.status(Response.Status.NO_CONTENT).build();
        }

    }

    public Response getExames() {
        try {

            return Response.ok(repository.findByIdModificado(usuarioRepository.findByCpf(jsonWebToken.getSubject()).getId().toString()).getExames().stream().map(ExameResponseDTO::new).collect(Collectors.toList())).build();
        }catch (Exception e){
            return Response.status(Response.Status.NO_CONTENT).build();
        }

    }

    public Response getUltrassonografias() {
        try {

            return Response.ok(repository.findByIdModificado(usuarioRepository.findByCpf(jsonWebToken.getSubject()).getId().toString()).getUltrassonografias().stream().map(UltrassonografiaResponseDTO::new).collect(Collectors.toList())).build();
        }catch (Exception e){
            return Response.status(Response.Status.NO_CONTENT).build();
        }

    }

    public Response getVacinas() {
        try {

            return Response.ok(repository.findByIdModificado(usuarioRepository.findByCpf(jsonWebToken.getSubject()).getId().toString()).getVacinas().stream().map(VacinaResponseDTO::new).collect(Collectors.toList())).build();
        }catch (Exception e){
            return Response.status(Response.Status.NO_CONTENT).build();
        }

    }

    public Response getMedico(){
        try {

            return Response.ok(new MedicoResponseDTO(repository.findByIdModificado(usuarioRepository.findByCpf(jsonWebToken.getSubject()).getId().toString()).getMedico())).build();
        }catch (Exception e){
            return Response.status(Response.Status.NO_CONTENT).build();
        }
    }
    @Transactional
    public Response insertVacina(VacinaDTO vacinaDTO){
        Mamae m = repository.findByIdModificado(usuarioRepository.findByCpf(jsonWebToken.getSubject()).getId().toString());
        return vacinaService.insert(m.getId(),vacinaDTO);
    }

    @Transactional
    public Response insert(MamaeDTO usuarioDTO){

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
        gestacao.setDataInicio(usuarioDTO.dataInicioGestacao());
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
        Usuario u = usuarioRepository.findByCpf(jsonWebToken.getSubject());
        repository.findById(u.getId()).setConvenio(convenio);
        return Response.status(Response.Status.OK).build();
    }

    @Transactional
    public Response mudarDadosMamae(MudarDadosMamaeDTO mudarDadosMamaeDTO){
        Usuario u = usuarioRepository.findByCpf(jsonWebToken.getSubject());
        repository.findById(u.getId()).getGestacao().setNomeBebe(mudarDadosMamaeDTO.nomeBebe());
        repository.findById(u.getId()).setContatoEmergencia(mudarDadosMamaeDTO.contatoEmergencia());
        return Response.status(Response.Status.OK).build();
    }

    @Transactional
    public Response setObservacao(MamaeObservacaoDTO nome){
        Usuario u = usuarioRepository.findByCpf(jsonWebToken.getSubject());
        Observacao o = new Observacao();
        o.setObservacao(nome.observacao());
        o.setAtendido(false);
        observacaoRepository.persist(o);
        u.getDuvidas().add(o);
        return Response.status(Response.Status.OK).build();
    }

    public List<ObservacaoResponseDTO> getObservacoes() {
        List<ObservacaoResponseDTO> observacoes = new ArrayList<>();
        observacoes = usuarioRepository.findByCpf(jsonWebToken.getSubject()).getDuvidas().stream().map(ObservacaoResponseDTO::new).collect(Collectors.toList());
        return observacoes;

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
