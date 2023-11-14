package com.projarq.dominio.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cidades")
public class Cidade {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String nome;
    private double custoBasicoParaSaoPaulo;

    public Cidade(Long id,String nome, double custoBasicoParaSaoPaulo) {
        this.id = id;
        this.nome = nome;
        this.custoBasicoParaSaoPaulo = custoBasicoParaSaoPaulo;
    }


    protected Cidade() {}

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getCustoBasicoParaSaoPaulo() {
        return custoBasicoParaSaoPaulo;
    }

    public void setCustoBasicoParaSaoPaulo(double custoBasicoParaSaoPaulo) {
        this.custoBasicoParaSaoPaulo = custoBasicoParaSaoPaulo;
    }
}
