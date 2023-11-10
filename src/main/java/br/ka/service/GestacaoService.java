package br.ka.service;

import br.ka.model.Gestacao;
import br.ka.repository.GestacaoRepository;
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

    @Scheduled(every = "12h")
    @Transactional
    public void atualizaIdadeGestacional(){
        repository.findAll().stream().forEach(gestacao -> repository.findById(gestacao.getId()).setIdadeGestacional("Semana - " + ChronoUnit.WEEKS.between(gestacao.getDataInicio(), LocalDate.now()) + " "));
    }

    public List<Gestacao> findAll() {
        return repository.listAll();
    }

    public Gestacao findById(Long id) {
        return repository
                .findById(id);
    }
    @Transactional
    public Gestacao create(Gestacao entity) {
        Gestacao t = entity;
        repository.persist(t);
        return entity;
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
