package br.ka.service;

import br.ka.model.Vacina;
import br.ka.repository.VacinaRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class VacinaService extends  BaseService<Vacina, Long, VacinaRepository> {
}
