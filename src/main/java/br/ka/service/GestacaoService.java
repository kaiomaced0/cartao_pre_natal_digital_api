package br.ka.service;

import br.ka.model.Gestacao;
import br.ka.repository.GestacaoRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GestacaoService extends  BaseService<Gestacao, Long, GestacaoRepository> {
}
