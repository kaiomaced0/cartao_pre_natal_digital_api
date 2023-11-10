package br.ka.service;

import br.ka.dto.AcompanhamentoDTO;
import br.ka.model.Acompanhamento;
import br.ka.model.Mamae;
import br.ka.repository.AcompanhamentoRepository;
import br.ka.repository.MamaeRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;

import java.util.List;

@ApplicationScoped
public class AcompanhamentoService{

    @Inject
    AcompanhamentoRepository repository;

    @Inject
    MamaeRepository mamaeRepository;

    @Transactional
    public Response create(AcompanhamentoDTO a ) {

        Mamae m = mamaeRepository.findById(a.idMamae());
        Acompanhamento entity = AcompanhamentoDTO.geraAcompanhamento(a);
        entity.setIdadeGestacional(m.getGestacao().getIdadeGestacional());
        repository.persist(entity);
        m.getAcompanhamentos().add(entity);
        return Response.status(Response.Status.OK).build();
    }

    @Transactional
    public void del(Long id) {
        repository.findById(id).setAtivo(false);
    }

    public List<Acompanhamento> findAll() {
        return repository.listAll();
    }

    public Acompanhamento findById(Long id) {
        return repository
                .findById(id);
    }

    @Transactional
    public Acompanhamento update(Acompanhamento entity) {
        return repository.getEntityManager().merge(entity);
    }

}
