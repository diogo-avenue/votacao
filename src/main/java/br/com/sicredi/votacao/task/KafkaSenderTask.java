package br.com.sicredi.votacao.task;

import br.com.sicredi.votacao.dto.ResultadoDto;
import br.com.sicredi.votacao.service.VotacaoService;
import org.springframework.beans.factory.annotation.Autowired;

public class KafkaSenderTask implements Runnable{

    @Autowired
    private VotacaoService votacaoService;

    private int idSessao;

    public KafkaSenderTask(int idSessao) {
        this.idSessao = idSessao;
    }

    public int getIdSessao() {
        return idSessao;
    }

    public void setIdSessao(int idSessao) {
        this.idSessao = idSessao;
    }

    @Override
    public void run() {
        ResultadoDto resultadoDto = votacaoService.obterResultado(idSessao);
        //TODO Publish resultadoDto in a kakfa queue.
        System.out.println(resultadoDto);
    }
}
