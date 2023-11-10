package br.ka.service;

import br.ka.model.Nutricao;
import br.ka.repository.NutricaoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class NutricaoService{
    @Inject
    NutricaoRepository repository;

    public List<Nutricao> findAll() {
        return repository.listAll();
    }

    public Nutricao findById(Long id) {
        return repository
                .findById(id);
    }
    @Transactional
    public Nutricao create(Nutricao entity) {
        Nutricao t = entity;
        repository.persist(t);
        return entity;
    }

    @Transactional
    public Nutricao update(Nutricao entity) {
        return repository.getEntityManager().merge(entity);
    }

    @Transactional
    public void deleteById(Long id) {
        repository.findById(id).setAtivo(false);
    }
}
