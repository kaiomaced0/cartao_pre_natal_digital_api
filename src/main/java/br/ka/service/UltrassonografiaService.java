package br.ka.service;

import br.ka.model.Ultrassonografia;
import br.ka.repository.UltrassonografiaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class UltrassonografiaService{

    @Inject
    UltrassonografiaRepository repository;

    public List<Ultrassonografia> findAll() {
        return repository.listAll();
    }

    public Ultrassonografia findById(Long id) {
        return repository
                .findById(id);
    }
    @Transactional
    public Ultrassonografia create(Ultrassonografia entity) {
        Ultrassonografia t = entity;
        repository.persist(t);
        return entity;
    }

    @Transactional
    public Ultrassonografia update(Ultrassonografia entity) {
        return repository.getEntityManager().merge(entity);
    }

    @Transactional
    public void deleteById(Long id) {
        repository.findById(id).setAtivo(false);
    }
}
