package br.ka.repository;

import br.ka.model.Observacao;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ObservacaoRepository implements PanacheRepository<Observacao> {
}
