package com.projarq.aplicacao;

import com.projarq.dominio.entidades.Cidade;
import com.projarq.dominio.servicos.ServicosCidade;

import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cidades")
public class cidadeUC{
    private final ServicosCidade servicosCidade;

    public cidadeUC(ServicosCidade servicosCidade) {
        this.servicosCidade = servicosCidade;
    }

    @GetMapping("/lista")
    @CrossOrigin(origins = "*")
    public String listarCidades() {
        return servicosCidade.listarCidades().stream().map(Cidade::getNome).collect(Collectors.toList()).toString();
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "*")
    public Cidade obterCidade(@PathVariable Long id) {
        return servicosCidade.obterCidadePorId(id);
    }

    @GetMapping("/{id}/verificaCEP")
    @CrossOrigin(origins = "*")
    public boolean verificaCEP(@PathVariable Long id, @RequestParam String cep) throws IOException {
        return servicosCidade.verificaCEP(cep, id)? true : false;
    }
}
