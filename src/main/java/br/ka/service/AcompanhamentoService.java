package br.ka.service;

import br.ka.dto.AcompanhamentoDTO;
import br.ka.dto.AcompanhamentoResponseDTO;
import br.ka.model.Acompanhamento;
import br.ka.model.EntityClass;
import br.ka.model.Mamae;
import br.ka.repository.AcompanhamentoRepository;
import br.ka.repository.MamaeRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.stream.Collectors;

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
        return Response.ok(new AcompanhamentoResponseDTO(entity)).build();
    }

    @Transactional
    public void del(Long id) {
        repository.findById(id).setAtivo(false);
    }

    public List<AcompanhamentoResponseDTO> findAll() {
        return repository.listAll().stream().filter(EntityClass::getAtivo).map(AcompanhamentoResponseDTO::new).collect(Collectors.toList());
    }

    public AcompanhamentoResponseDTO findById(Long id) {
        return new AcompanhamentoResponseDTO(repository
                .findById(id));
    }

    @Transactional
    public Acompanhamento update(Acompanhamento entity) {
        return repository.getEntityManager().merge(entity);
    }

}
