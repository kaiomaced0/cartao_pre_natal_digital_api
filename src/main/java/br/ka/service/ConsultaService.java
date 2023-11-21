package br.ka.service;

import br.ka.dto.ConsultaDTO;
import br.ka.dto.ConsultaResponseDTO;
import br.ka.model.Consulta;
import br.ka.model.TipoConsulta;
import br.ka.repository.ConsultaRepository;
import br.ka.repository.MamaeRepository;
import br.ka.repository.MedicoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class ConsultaService{

    @Inject
    ConsultaRepository repository;
    @Inject
    MedicoRepository medicoRepository;

    @Inject
    MamaeRepository mamaeRepository;

    public List<Consulta> findAll() {
        return repository.listAll();
    }

    public Consulta findById(Long id) {
        return repository
                .findById(id);
    }
    @Transactional
    public ConsultaResponseDTO create(Long id, ConsultaDTO entity) {
        Consulta t = new Consulta();
        t.setTipoConsulta(TipoConsulta.valueOf(entity.idTipoConsulta().intValue()));
        t.setMedico(medicoRepository.findById(entity.idMedico()));
        t.setObservacao(entity.observacao());
        t.setUsuario(mamaeRepository.findById(id));
        repository.persist(t);
        return new ConsultaResponseDTO(t);
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
