package br.com.sicredi.votacao.repository;

import br.com.sicredi.votacao.model.Associado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssociadoRepository extends JpaRepository<Associado, Integer>{

}
