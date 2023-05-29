package com.bcopstein.SistCalculoFreteP6.Persistencia;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.bcopstein.SistCalculoFreteP6.Dominio.IRepositorioDeCidades;
import org.springframework.stereotype.Repository;

import com.bcopstein.SistCalculoFreteP6.Dominio.Cidade;

@Repository
public class RepositorioDeCidades implements IRepositorioDeCidades {
    private List<Cidade> cidades;

    public RepositorioDeCidades(){
        cidades = new LinkedList<>();
        
        cidades.add(new Cidade(1,"Porto Alegre",25));
        cidades.add(new Cidade(2,"Florianópolis",20));
        cidades.add(new Cidade(3,"Curitiba",15));
        cidades.add(new Cidade(4,"São Paulo",10));
    }

    public List<Cidade> todas(){
        return new ArrayList<>(cidades);
    }

    public Cidade get(long id){
        return cidades.stream()
            .filter(c->(c.getId() == id))
            .findAny()
            .orElse(null);
    }

    public Cidade get(String nome){
        return cidades.stream()
            .filter(c->c.getNome().equals(nome))
            .findAny()
            .orElse(null);
    }
}
