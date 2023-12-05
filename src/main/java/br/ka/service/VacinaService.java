package br.ka.service;

import br.ka.dto.VacinaDTO;
import br.ka.dto.VacinaResponseDTO;
import br.ka.model.EntityClass;
import br.ka.model.Mamae;
import br.ka.model.Vacina;
import br.ka.repository.MamaeRepository;
import br.ka.repository.VacinaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class VacinaService{

    @Inject
    VacinaRepository repository;
    @Inject
    MamaeRepository mamaeRepository;

    @Transactional
    public Response insert(Long id, VacinaDTO vacinaDTO){
        try {
            Mamae m = mamaeRepository.findById(id);
            Vacina vacina = vacinaDTO.criaVacina(vacinaDTO);
            repository.persist(vacina);
            m.getVacinas().add(vacina);
            return Response.ok(vacina).build();
        }catch (Exception e){
            return Response.notModified(e.toString()).build();
        }
    }


    public List<VacinaResponseDTO> findAll() {
        return repository.listAll().stream().filter(EntityClass::getAtivo).map(VacinaResponseDTO::new).collect(Collectors.toList());
    }

    public VacinaResponseDTO findById(Long id) {
        return new VacinaResponseDTO(repository
                .findById(id));
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
