package br.ka.service;

import br.ka.dto.MedicoDTO;
import br.ka.dto.MedicoResponseDTO;
import br.ka.dto.UsuarioResponseDTO;
import br.ka.model.Especializacao;
import br.ka.model.Medico;
import br.ka.model.Usuario;
import br.ka.repository.MedicoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class MedicoService{

    @Inject
    MedicoRepository repository;

    @Inject
    HashService hash;

    public List<Medico> findAll() {
        return repository.listAll();
    }

    public Medico findById(Long id) {
        return repository
                .findById(id);
    }
    @Transactional
    public MedicoResponseDTO create(MedicoDTO entity) {
        Medico t = new Medico();
        t.setNome(entity.nome());
        t.setCrm(entity.crm());
        t.setTelefone(entity.telefone());
        t.setCpf(entity.cpf());
        t.setEmail(entity.email());
        t.setSenha(hash.getHashSenha(entity.senha()));
        List<Especializacao> especializacoes = new ArrayList<>();
        especializacoes.add(Especializacao.valueOf(entity.idEspecializacao().intValue()));
        t.setEspecializacoes(especializacoes);
        repository.persist(t);
        return new MedicoResponseDTO(t);
    }

    @Transactional
    public Medico update(Medico entity) {
        return repository.getEntityManager().merge(entity);
    }

    @Transactional
    public void deleteById(Long id) {
        repository.findById(id).setAtivo(false);
    }
}
