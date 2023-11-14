package com.projarq.dominio.servicos;
import com.projarq.dominio.entidades.Cidade;

public interface InterfaceServicosPromocao {
    double calculaDesconto(Cidade cidadeOrigem, Cidade cidadeDestino, int kg, double valor);
    String retornaPromoVigente();
}
