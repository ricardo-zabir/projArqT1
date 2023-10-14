package com.projarq.aplicacao;

import org.springframework.stereotype.Component;

import com.projarq.dominio.servicos.InterfaceServicosPromocao;
import com.projarq.dominio.servicos.ServicosPromocoes;


@Component
public class RetornaPromoVigente_UC {
    private final ServicosPromocoes servicosPromocao;

    public RetornaPromoVigente_UC(ServicosPromocoes servicosPromocao) {
        this.servicosPromocao = servicosPromocao;
    }

    public String run() {
        return this.servicosPromocao.retornaPromoVigente();
    }
}
