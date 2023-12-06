package br.ka.service;

import br.ka.dto.UltrassonografiaDTO;
import br.ka.dto.UltrassonografiaResponseDTO;
import br.ka.model.Mamae;
import br.ka.model.Ultrassonografia;
import br.ka.repository.MamaeRepository;
import br.ka.repository.UltrassonografiaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class UltrassonografiaService{

    @Inject
    UltrassonografiaRepository repository;

    @Inject
    MamaeRepository mamaeRepository;

    public List<UltrassonografiaResponseDTO> findAll() {
        return repository.listAll().stream().map(UltrassonografiaResponseDTO::new).collect(Collectors.toList());
    }

    public UltrassonografiaResponseDTO findById(Long id) {
        return new UltrassonografiaResponseDTO(repository
                .findById(id));
    }
    @Transactional
    public Response create(UltrassonografiaDTO entity, Long idMamae) {
        try {
            Ultrassonografia t = new Ultrassonografia();
            Mamae mamae = mamaeRepository.findById(idMamae);
            if(entity.idadeGestacional() == null){
                t.setIdadeGestacional(mamae.getGestacao().getIdadeGestacional());
            }else{
                t.setIdadeGestacional(entity.idadeGestacional());
            }
            t.setObservacao(entity.observacao());
            t.setLinkArquivo(entity.linkArquivo());
            t.setLiq(entity.liq());
            t.setIgdum(entity.igdum());
            t.setDoppler(entity.doppler());
            t.setPlacenta(entity.placenta());
            repository.persist(t);
            mamae.getUltrassonografias().add(t);
            return Response.ok(new UltrassonografiaResponseDTO(t)).build();
        }catch (Exception e){
            return Response.noContent().build();
        }


    }

    @Transactional
    public UltrassonografiaResponseDTO update(UltrassonografiaDTO entity, Long id) {
        Ultrassonografia u = repository.findById(id);
        u.setLiq(entity.liq());
        u.setIgdum(entity.igdum());
        u.setPlacenta(entity.placenta());
        u.setObservacao(entity.observacao());
        u.setLinkArquivo(entity.linkArquivo());
        u.setDoppler(entity.doppler());
        u.setIdadeGestacional(u.getIdadeGestacional());

        return new UltrassonografiaResponseDTO(u);
    }

    @Transactional
    public void deleteById(Long id) {
        repository.findById(id).setAtivo(false);
    }
}
