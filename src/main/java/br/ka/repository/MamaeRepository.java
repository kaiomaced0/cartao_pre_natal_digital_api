package br.ka.repository;

import br.ka.model.Mamae;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MamaeRepository implements PanacheRepository<Mamae> {
    public Mamae findByIdModificado(String id){
        if (id == null)
            return null;

        return find("id = ?1", id).firstResult();
    }
}
