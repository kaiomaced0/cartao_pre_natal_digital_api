package br.ka.service;

import br.ka.model.Medico;
import br.ka.repository.MedicoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class MedicoService{

    @Inject
    MedicoRepository repository;

    public List<Medico> findAll() {
        return repository.listAll();
    }

    public Medico findById(Long id) {
        return repository
                .findById(id);
    }
    @Transactional
    public Medico create(Medico entity) {
        Medico t = entity;
        repository.persist(t);
        return entity;
    }

    @Transactional
    public Medico update(Medico entity) {
        return repository.getEntityManager().merge(entity);
    }

    @Transactional
    public void deleteById(Long id) {
        repository.findById(id).setAtivo(false);
    }
}
