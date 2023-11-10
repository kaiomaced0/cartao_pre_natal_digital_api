package br.ka.repository;

import br.ka.model.Acompanhamento;
import br.ka.model.Gestacao;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GestacaoRepository implements PanacheRepository<Gestacao> {
}
