package com.projarq.dominio.servicos;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class ServicoImposto implements InterfaceServicosImposto{
    public ServicoImposto() {
    }

    public double getImposto(double precoBasico) {
        double imposto = precoBasico * 0.05;
        return imposto;
    }
}
