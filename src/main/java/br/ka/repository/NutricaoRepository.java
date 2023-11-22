package br.ka.repository;

import br.ka.model.Nutricao;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class NutricaoRepository implements PanacheRepository<Nutricao> {
}
