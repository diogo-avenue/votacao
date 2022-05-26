package br.com.sicredi.votacao.task;

import br.com.sicredi.votacao.dto.ResultadoDto;
import br.com.sicredi.votacao.model.Pauta;
import br.com.sicredi.votacao.service.VotacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaSenderTask {

    @Autowired
    private VotacaoService votacaoService;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public Runnable kafkaSenderRunnable (int idSessao, Pauta pauta){
        return new Runnable() {
            @Override
            public void run() {
                ResultadoDto resultadoDto = votacaoService.obterResultado(idSessao);
                kafkaTemplate.send("resultado-votacao", resultadoDto.toString());
            }
        };
    }

}
