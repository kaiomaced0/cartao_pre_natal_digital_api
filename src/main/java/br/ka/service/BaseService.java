package br.ka.service;

import br.ka.repository.BaseRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

import java.util.List;
import java.util.Optional;

public abstract class BaseService<T, ID, R extends BaseRepository<T, ID>> {

    @Inject
    R repository;

    public List<T> findAll() {
        return repository.listAll();
    }

    public T findById(ID id) {
        return repository
                .findById(id);
    }
    @Transactional
    public T create(T entity) {
        T t = entity;
        repository.persist(t);
        return entity;
    }

    @Transactional
    public T update(T entity) {
        return repository.getEntityManager().merge(entity);
    }

    @Transactional
    public void deleteById(ID id) {
        repository.deleteById(id);
    }
}
