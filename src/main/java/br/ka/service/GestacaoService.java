package br.ka.service;

import br.ka.dto.GestacaoDTO;
import br.ka.dto.GestacaoResponseDTO;
import br.ka.model.Gestacao;
import br.ka.model.Mamae;
import br.ka.repository.GestacaoRepository;
import br.ka.repository.MamaeRepository;
import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@ApplicationScoped
public class GestacaoService{

    @Inject
    GestacaoRepository repository;
    @Inject
    MamaeRepository mamaeRepository;

    @Scheduled(every = "12h")
    @Transactional
    public void atualizaIdadeGestacional(){
        repository.findAll().stream().forEach(gestacao -> repository.findById(gestacao.getId()).setIdadeGestacional(ChronoUnit.WEEKS.between(gestacao.getDataInicio(), LocalDate.now()) + " semanas "));
    }

    public List<Gestacao> findAll() {
        return repository.listAll();
    }

    public Gestacao findById(Long id) {
        return repository
                .findById(id);
    }
    @Transactional
    public GestacaoResponseDTO create(GestacaoDTO entity) {
        Mamae m = mamaeRepository.findById(entity.idMamae());
        Gestacao t = new Gestacao();

        repository.persist(t);
        if(m.getEmGestacao() == false){
            m.setGestacao(t);
            m.setEmGestacao(true);
        }
        return new GestacaoResponseDTO(t);
    }

    @Transactional
    public Gestacao update(Gestacao entity) {
        return repository.getEntityManager().merge(entity);
    }

    @Transactional
    public void deleteById(Long id) {
        repository.findById(id).setAtivo(false);
    }
}
