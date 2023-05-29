package com.bcopstein.SistCalculoFreteP6.Aplicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bcopstein.SistCalculoFreteP6.Persistencia.RepositorioDeCidades;

@Component
public class CidadesAtendidas_UC {
    private RepositorioDeCidades repositorioDeCidades;

    @Autowired
    public CidadesAtendidas_UC(RepositorioDeCidades repositorioDeCidades){
        this.repositorioDeCidades = repositorioDeCidades;
    }

    public List<String> run(){
        return repositorioDeCidades
            .todas()
            .stream()
            .map(c->c.getNome())
            .toList();
    }
}
