package com.projarq.dominio.servicos;

import com.projarq.dominio.entidades.Cidade;

public interface InterfaceServicosImposto {
    double getImposto(double precoBasico, Cidade cidadeOrigem);
}
