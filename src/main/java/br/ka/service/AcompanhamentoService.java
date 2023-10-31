package br.ka.service;

import br.ka.dto.AcompanhamentoDTO;
import br.ka.model.Acompanhamento;
import br.ka.repository.AcompanhamentoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class AcompanhamentoService extends  BaseService<Acompanhamento, Long, AcompanhamentoRepository> {

    @Transactional
    public Acompanhamento create(AcompanhamentoDTO a ) {
        Acompanhamento entity = AcompanhamentoDTO.geraAcompanhamento(a);
        repository.persist(entity);
        return entity;
    }

    @Transactional
    public void del(Long id) {
        repository.findById(id).setAtivo(false);
    }
}
