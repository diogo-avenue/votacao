package br.com.sicredi.votacao.repository;

import br.com.sicredi.votacao.model.Associado;
import br.com.sicredi.votacao.model.Sessao;
import br.com.sicredi.votacao.model.Votacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VotacaoRepository extends JpaRepository<Votacao, Integer>{
    List<Votacao> findAllBySessao(Sessao sessao);
    boolean existsByAssociadoAndSessao(Associado associado, Sessao sessao);
}
