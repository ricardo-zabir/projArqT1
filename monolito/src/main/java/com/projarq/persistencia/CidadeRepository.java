package com.projarq.persistencia;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.projarq.dominio.entidades.Cidade;
import com.projarq.dominio.repositorios.RepCidade;  

@Component
public class CidadeRepository implements RepCidade {
    private List<Cidade> cidades = new ArrayList<>();
    private Long idCounter = 1L;

    public CidadeRepository() {
        Cidade cidade = new Cidade(idCounter++, "São Paulo", 10);
        salvar(cidade);
        cidade = new Cidade(idCounter++, "Porto Alegre", 25);
        salvar(cidade);

        cidade = new Cidade(idCounter++, "Curitiba", 15);
        salvar(cidade);

        cidade = new Cidade(idCounter++, "Florianópolis", 20);
        salvar(cidade);


    }
    public Cidade salvar(Cidade cidade) {
        cidades.add(cidade);
        return cidade;
    }

    public Cidade findById(Long id) {
        for (Cidade cidade : cidades) {
            if (cidade.getId().equals(id)) {
                return cidade;
            }
        }
        return null;
    }

    public List<Cidade> findAll() {
        return cidades;
    }

    public void delete(Long id) {
        cidades.removeIf(cidade -> cidade.getId().equals(id));
    }
}
