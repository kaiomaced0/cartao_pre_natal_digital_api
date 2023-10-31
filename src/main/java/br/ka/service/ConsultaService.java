package br.ka.service;

import br.ka.model.Consulta;
import br.ka.repository.ConsultaRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ConsultaService extends  BaseService<Consulta, Long, ConsultaRepository> {
}
