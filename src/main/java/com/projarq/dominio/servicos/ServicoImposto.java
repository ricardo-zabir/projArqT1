package com.projarq.dominio.servicos;

import org.springframework.stereotype.Service;

@Service
public class ServicoImposto {
    public ServicoImposto() {
    }

    public double getImposto(double precoBasico) {
        double imposto = precoBasico * 0.05;
        return imposto;
    }
}
