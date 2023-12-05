package br.ka.service;

import br.ka.dto.NutricaoDTO;
import br.ka.dto.NutricaoMamaeDTO;
import br.ka.dto.NutricaoResponseDTO;
import br.ka.model.Nutricao;
import br.ka.repository.MamaeRepository;
import br.ka.repository.NutricaoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class NutricaoService{
    @Inject
    NutricaoRepository repository;

    @Inject
    MamaeRepository mamaeRepository;

    public List<Nutricao> findAll() {
        return repository.listAll();
    }

    public Nutricao findById(Long id) {
        return repository
                .findById(id);
    }
    @Transactional
    public NutricaoResponseDTO createMamae(NutricaoMamaeDTO entity) {
        Nutricao t = new Nutricao();
        t.setTitulo(entity.titulo());
        t.setEspecifico(true);
        t.setMamae(mamaeRepository.findById(entity.idMamae()));
        t.setDescricao(entity.descricao());
        repository.persist(t);
        return new NutricaoResponseDTO(t);
    }

    @Transactional
    public NutricaoResponseDTO create(NutricaoDTO entity) {
        Nutricao t = new Nutricao();
        t.setTitulo(entity.titulo());
        t.setDescricao(entity.descricao());
        repository.persist(t);
        return new NutricaoResponseDTO(t);
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
