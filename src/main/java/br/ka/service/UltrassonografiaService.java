package br.ka.service;

import br.ka.dto.UltrassonografiaDTO;
import br.ka.model.Mamae;
import br.ka.model.Ultrassonografia;
import br.ka.repository.MamaeRepository;
import br.ka.repository.UltrassonografiaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;

import java.util.List;

@ApplicationScoped
public class UltrassonografiaService{

    @Inject
    UltrassonografiaRepository repository;

    @Inject
    MamaeRepository mamaeRepository;

    public List<Ultrassonografia> findAll() {
        return repository.listAll();
    }

    public Ultrassonografia findById(Long id) {
        return repository
                .findById(id);
    }
    @Transactional
    public Response create(UltrassonografiaDTO entity, Long idMamae) {
        try {
            Ultrassonografia t = new Ultrassonografia();
            Mamae mamae = mamaeRepository.findById(idMamae);
            t.setIdadeGestacional(mamae.getGestacao().getIdadeGestacional());
            t.setObservacao(entity.observacao());
            t.setLinkArquivo(entity.linkArquivo());
            repository.persist(t);
            mamae.getUltrassonografias().add(t);
            return Response.ok().build();
        }catch (Exception e){
            return Response.noContent().build();
        }


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
