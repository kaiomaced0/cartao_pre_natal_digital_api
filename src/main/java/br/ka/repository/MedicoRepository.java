package br.ka.repository;

import br.ka.model.Medico;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MedicoRepository extends BaseRepository<Medico, Long> {
}
