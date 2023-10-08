package com.projarq.domain;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;


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

    // consumindo a API do viacep

    public boolean verificaCEP(String cep) throws IOException {
        cep = cep.replace("-", "");
        cep = cep.replace(".", "");
        URL url = new URL("https://viacep.com.br/ws/" + cep + "/json/");
        URLConnection connection = url.openConnection();
        InputStream inputStream = connection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new java.io.InputStreamReader(inputStream, "UTF-8"));

        StringBuilder jsont = new StringBuilder();
        String linha;
        while((linha = bufferedReader.readLine()) != null) {
            System.out.println(linha);
            jsont.append(linha);
        }
        String json = jsont.toString();
        String nomeCidadeAPI = json.substring(json.indexOf("localidade")+14, json.indexOf("localidade")+14+json.substring(json.indexOf("localidade")+14).indexOf("\""));
        System.out.println(nomeCidadeAPI);
        if (nomeCidadeAPI.equalsIgnoreCase(nome)) {
            System.out.println("Cidade encontrada");
            return true;
        }
           System.out.println("Cidade não encontrada");
        return false;
    }
}
