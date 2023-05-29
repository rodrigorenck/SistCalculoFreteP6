package com.bcopstein.SistCalculoFreteP6.Aplicacao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Promocoes_UC {
    public List<String> run(){
        List<String> lst = new ArrayList<>();
        lst.add("nenhuma");
        return lst;
    }
}
