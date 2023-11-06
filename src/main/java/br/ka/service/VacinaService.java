package br.ka.service;

import br.ka.dto.VacinaDTO;
import br.ka.model.Vacina;
import br.ka.repository.VacinaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class VacinaService extends  BaseService<Vacina, Long, VacinaRepository> {
    public Response insert(VacinaDTO vacinaDTO){
        Vacina vacina = vacinaDTO.criaVacina(vacinaDTO);
        repository.persist(vacina);
        return Response.status(Response.Status.OK).build();
    }
}
