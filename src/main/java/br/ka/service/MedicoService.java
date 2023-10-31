package br.ka.service;

import br.ka.model.Medico;
import br.ka.repository.MedicoRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MedicoService extends  BaseService<Medico, Long, MedicoRepository> {
}
