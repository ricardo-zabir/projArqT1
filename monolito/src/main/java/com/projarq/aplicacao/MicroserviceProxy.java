 package com.projarq.aplicacao;

import java.time.LocalDate;
import com.projarq.dominio.entidades.Orcamento;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "microservico")
public interface MicroserviceProxy {
    @GetMapping("/servicoorcamento/listaorcamentospordata?data={data}")
    public List<Orcamento> retrieveExchangeValue(@PathVariable LocalDate data);
}
