package com.projarq.controller;

import com.projarq.dominio.Orcamento;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projarq.aplicacao.ListaOrcamentosPorData_UC;
import com.projarq.aplicacao.SalvaOrcamento_UC;

@RestController
public class CalculoFreteController {
    private final ListaOrcamentosPorData_UC listaOrcamentosPorData_UC;
    private final SalvaOrcamento_UC salvaOrcamento_UC;

    public CalculoFreteController(ListaOrcamentosPorData_UC listaOrcamentosPorData_UC, SalvaOrcamento_UC salvaOrcamento_UC) { // Correção aqui
        this.listaOrcamentosPorData_UC = listaOrcamentosPorData_UC;
        this.salvaOrcamento_UC = salvaOrcamento_UC;
    }

    @GetMapping("/listaorcamentospordata")
    public ResponseEntity<List<Orcamento>> listaOrcamentosPorData(@RequestParam LocalDate data) {
        List<Orcamento> resposta = listaOrcamentosPorData_UC.run(data);
        return ResponseEntity.status(HttpStatus.OK).body(resposta);
    }

    @PostMapping("/salvaorcamento")
    public ResponseEntity<Orcamento> salvaOrcamento(@RequestBody Orcamento orcamento) {
        Orcamento resposta = salvaOrcamento_UC.run(orcamento);
        return ResponseEntity.status(HttpStatus.OK).body(resposta);
    }

}
