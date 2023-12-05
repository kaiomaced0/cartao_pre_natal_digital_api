package br.ka.service;

import br.ka.dto.ExameDTO;
import br.ka.dto.ExameResponseDTO;
import br.ka.model.Exame;
import br.ka.model.Mamae;
import br.ka.repository.ExameRepository;
import br.ka.repository.MamaeRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;

import java.util.List;

@ApplicationScoped
public class ExameService{

    @Inject
    ExameRepository repository;

    @Inject
    MamaeRepository mamaeRepository;

    @Transactional
    public Response insert(ExameDTO exameDTO){
        Exame e = ExameDTO.criaExame(exameDTO);
        repository.persist(e);
        Mamae m = mamaeRepository.findById(exameDTO.idMamae());
        m.getExames().add(e);
        return Response.status(Response.Status.OK).entity(new ExameResponseDTO(e)).build();
    }

    public List<Exame> findAll() {
        return repository.listAll();
    }

    public Exame findById(Long id) {
        return repository
                .findById(id);
    }

    @Transactional
    public Exame update(Exame entity) {
        return repository.getEntityManager().merge(entity);
    }

    @Transactional
    public void deleteById(Long id) {
        repository.findById(id).setAtivo(false);
    }
}
