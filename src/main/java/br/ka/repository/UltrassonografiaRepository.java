package br.ka.repository;

import br.ka.model.Ultrassonografia;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UltrassonografiaRepository implements PanacheRepository<Ultrassonografia> {
}
