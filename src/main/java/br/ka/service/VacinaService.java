package br.ka.service;

import br.ka.dto.VacinaDTO;
import br.ka.model.Vacina;
import br.ka.repository.VacinaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;

import java.util.List;

@ApplicationScoped
public class VacinaService{
    public Response insert(VacinaDTO vacinaDTO){
        Vacina vacina = vacinaDTO.criaVacina(vacinaDTO);
        repository.persist(vacina);
        return Response.status(Response.Status.OK).build();
    }


    @Inject
    VacinaRepository repository;

    public List<Vacina> findAll() {
        return repository.listAll();
    }

    public Vacina findById(Long id) {
        return repository
                .findById(id);
    }
    @Transactional
    public Vacina create(Vacina entity) {
        Vacina t = entity;
        repository.persist(t);
        return entity;
    }

    @Transactional
    public Vacina update(Vacina entity) {
        return repository.getEntityManager().merge(entity);
    }

    @Transactional
    public void deleteById(Long id) {
        repository.findById(id).setAtivo(false);
    }
}
