package br.com.sicredi.votacao.repository;

import br.com.sicredi.votacao.model.Sessao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessaoRepository extends JpaRepository<Sessao, Integer>{

}
