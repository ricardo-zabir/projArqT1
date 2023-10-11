package com.projarq.controller;
import com.projarq.aplicacao.ValidaCEP_UC;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projarq.aplicacao.ListaCidades_UC;


@RestController
public class CalculoFreteController {
    private final ValidaCEP_UC validaCEP_UC;
    private final ListaCidades_UC listaCidades_UC;
    public CalculoFreteController(ValidaCEP_UC validaCEP_UC, ListaCidades_UC listaCidades_UC) {
        this.listaCidades_UC=listaCidades_UC;
        this.validaCEP_UC=validaCEP_UC;
    }

    @GetMapping("/cidadesatendidas")
    public ResponseEntity<List<String>> listaCidades(){
        List<String> lista = listaCidades_UC.run();

        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @GetMapping("/validacep")
    public ResponseEntity<Boolean> validaCEP(@RequestParam String cep) throws IOException{
        Boolean resposta = validaCEP_UC.run(cep);

        return ResponseEntity.status(HttpStatus.OK).body(resposta);
    }

}
