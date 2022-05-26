package br.com.sicredi.votacao.repository;

import br.com.sicredi.votacao.model.Pauta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PautaRepository extends JpaRepository<Pauta, Integer>{

    @Query("select distinct p from Pauta p " +
            "inner join Sessao s on s.pauta.id = p.id")
    Pauta getPautaByIdSessao(int idSessao);
}
