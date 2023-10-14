package com.projarq.controller;

import com.projarq.aplicacao.ValidaCEP_UC;
import com.projarq.dominio.entidades.Orcamento;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projarq.aplicacao.ListaCidades_UC;
import com.projarq.aplicacao.CalculaOrcamento_UC;
import com.projarq.aplicacao.ListaOrcamentosPorData_UC;

@RestController
public class CalculoFreteController {
    private final ValidaCEP_UC validaCEP_UC;
    private final ListaCidades_UC listaCidades_UC;
    private final CalculaOrcamento_UC calculaOrcamento_UC;
    private final ListaOrcamentosPorData_UC listaOrcamentosPorData_UC;

    public CalculoFreteController(ValidaCEP_UC validaCEP_UC, ListaCidades_UC listaCidades_UC,
            CalculaOrcamento_UC calculaOrcamento_UC, ListaOrcamentosPorData_UC listaOrcamentosPorData_UC) { // Correção
                                                                                                            // aqui
        this.listaCidades_UC = listaCidades_UC;
        this.validaCEP_UC = validaCEP_UC;
        this.calculaOrcamento_UC = calculaOrcamento_UC;
        this.listaOrcamentosPorData_UC = listaOrcamentosPorData_UC;
    }

    @GetMapping("/cidadesatendidas")
    public ResponseEntity<List<String>> listaCidades() {
        List<String> lista = listaCidades_UC.run();

        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @GetMapping("/validacep")
    public ResponseEntity<Boolean> validaCEP(@RequestParam String cep) throws IOException {
        Boolean resposta = validaCEP_UC.run(cep);

        return ResponseEntity.status(HttpStatus.OK).body(resposta);
    }

    // exemplo pra teste:
    // http://localhost:8080/calculafrete?origem=1&destino=2&gramas=15000
    @GetMapping("/calculafrete")
    public ResponseEntity<?> calculaFrete(@RequestParam String origem, @RequestParam String destino,
            @RequestParam int gramas) {
        try {
            Double resposta = calculaOrcamento_UC.run(origem, destino, gramas);
            return ResponseEntity.status(HttpStatus.OK).body(resposta);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cidade não encontrada no banco de dados.");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno ao calcular o frete.");
        }
    }

    @GetMapping("/listaorcamentospordata")
    public ResponseEntity<List<Orcamento>> listaOrcamentosPorData(@RequestParam LocalDate data) {
        List<Orcamento> resposta = listaOrcamentosPorData_UC.run(data);
        return ResponseEntity.status(HttpStatus.OK).body(resposta);
    }
}
