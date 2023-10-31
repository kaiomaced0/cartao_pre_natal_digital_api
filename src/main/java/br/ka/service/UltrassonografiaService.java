package br.ka.service;

import br.ka.model.Ultrassonografia;
import br.ka.repository.UltrassonografiaRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UltrassonografiaService extends  BaseService<Ultrassonografia, Long, UltrassonografiaRepository> {
}
