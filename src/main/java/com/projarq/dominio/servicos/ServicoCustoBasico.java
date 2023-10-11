package com.projarq.dominio.servicos;

import org.springframework.stereotype.Service;

import com.projarq.dominio.entidades.Cidade;
@Service
public class ServicoCustoBasico {
    public ServicoCustoBasico() {
    }
    public double getCustoBasico(Cidade origem, Cidade destino, int gramas){
        double custoBasico = 0.00;
        if(origem.getNome().equals(destino.getNome())) {
            custoBasico = destino.getCustoBasicoParaSaoPaulo();
        }
        else {
            if (origem.getNome().equals("São Paulo") || destino.getNome().equals("São Paulo")) {
                if(origem.getNome().equals("São Paulo")) {
                    custoBasico = destino.getCustoBasicoParaSaoPaulo();
                }
                else {
                    custoBasico = origem.getCustoBasicoParaSaoPaulo();
                }
            }
            else {
                custoBasico = destino.getCustoBasicoParaSaoPaulo() + origem.getCustoBasicoParaSaoPaulo();
            }
        }
        return custoBasico;
    }
}
