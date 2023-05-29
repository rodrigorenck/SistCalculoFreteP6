package com.bcopstein.SistCalculoFreteP6.Dominio;

import java.util.List;

import com.bcopstein.SistCalculoFreteP6.Dominio.Cidade;

public interface IRepositorioDeCidades {
    List<Cidade> todas();
    Cidade get(long id);
    Cidade get(String nome);
}