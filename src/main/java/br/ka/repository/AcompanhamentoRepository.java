package br.ka.repository;

import br.ka.model.Acompanhamento;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AcompanhamentoRepository implements PanacheRepository<Acompanhamento> {

}
