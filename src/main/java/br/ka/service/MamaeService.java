package br.ka.service;

import br.ka.model.Mamae;
import br.ka.repository.MamaeRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MamaeService extends  BaseService<Mamae, Long, MamaeRepository> {
}
