package br.ka.service;

import br.ka.model.Consulta;
import br.ka.repository.ConsultaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class ConsultaService{

    @Inject
    ConsultaRepository repository;

    public List<Consulta> findAll() {
        return repository.listAll();
    }

    public Consulta findById(Long id) {
        return repository
                .findById(id);
    }
    @Transactional
    public Consulta create(Consulta entity) {
        Consulta t = entity;
        repository.persist(t);
        return entity;
    }

    @Transactional
    public Consulta update(Consulta entity) {
        return repository.getEntityManager().merge(entity);
    }

    @Transactional
    public void deleteById(Long id) {
        repository.findById(id).setAtivo(false);
    }
}
