package br.ka.service;

import br.ka.dto.ConsultaDTO;
import br.ka.dto.ConsultaResponseDTO;
import br.ka.model.Consulta;
import br.ka.model.EntityClass;
import br.ka.model.Mamae;
import br.ka.model.TipoConsulta;
import br.ka.repository.ConsultaRepository;
import br.ka.repository.MamaeRepository;
import br.ka.repository.MedicoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.jwt.JsonWebToken;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ConsultaService{

    @Inject
    ConsultaRepository repository;
    @Inject
    MedicoRepository medicoRepository;

    @Inject
    MamaeRepository mamaeRepository;
    @Inject
    JsonWebToken jsonWebToken;

    public List<ConsultaResponseDTO> findAll() {
        return repository.listAll().stream().filter(EntityClass::getAtivo).map(ConsultaResponseDTO::new).collect(Collectors.toList());
    }

    public ConsultaResponseDTO findById(Long id) {
        Consulta c = repository
                .findById(id);
        if(c.getAtivo() == false){
            return null;
        }
        return new ConsultaResponseDTO(c);
    }
    @Transactional
    public ConsultaResponseDTO create(Long idMamae, ConsultaDTO entity) {
        Consulta t = new Consulta();
        t.setTipoConsulta(TipoConsulta.valueOf(entity.idTipoConsulta().intValue()));
        t.setMedico(medicoRepository.findById(entity.idMedico()));
        t.setObservacao(entity.observacao());
        Mamae m = mamaeRepository.findById(idMamae);
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
