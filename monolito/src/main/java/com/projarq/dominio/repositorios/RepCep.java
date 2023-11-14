package com.projarq.dominio.repositorios;

import java.io.IOException;

public interface RepCep {
    String verificaCEP(String cep) throws IOException;
}
