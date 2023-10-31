package br.ka.service;

import br.ka.model.Nutricao;
import br.ka.repository.NutricaoRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class NutricaoService extends  BaseService<Nutricao, Long, NutricaoRepository> {
}
