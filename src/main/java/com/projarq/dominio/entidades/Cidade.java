package com.projarq.dominio.entidades;


public class Cidade {
    private Long id;
    private String nome;
    private double custoBasicoParaSaoPaulo;

    public Cidade(Long id,String nome, double custoBasicoParaSaoPaulo) {
        this.id = id;
        this.nome = nome;
        this.custoBasicoParaSaoPaulo = custoBasicoParaSaoPaulo;
    }

    public Cidade() {
    }

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
