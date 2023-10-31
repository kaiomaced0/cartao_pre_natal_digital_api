package br.ka.service;

import br.ka.model.Exame;
import br.ka.repository.ExameRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ExameService extends  BaseService<Exame, Long, ExameRepository> {
}
