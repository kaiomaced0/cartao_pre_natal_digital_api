package br.ka.service;

import br.ka.dto.ExameDTO;
import br.ka.model.Exame;
import br.ka.repository.ExameRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class ExameService extends  BaseService<Exame, Long, ExameRepository> {
    public Response insert(ExameDTO exameDTO){
        Exame e = ExameDTO.criaExame(exameDTO);
        repository.persist(e);
        return Response.status(Response.Status.OK).build();
    }
}
