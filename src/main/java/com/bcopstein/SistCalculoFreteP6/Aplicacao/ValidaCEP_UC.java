package com.bcopstein.SistCalculoFreteP6.Aplicacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bcopstein.SistCalculoFreteP6.Persistencia.ServicoCEP;
import com.bcopstein.SistCalculoFreteP6.Persistencia.RepositorioDeCidades;

@Component
public class ValidaCEP_UC {
    private ServicoCEP servicoCEP;
    private RepositorioDeCidades repositorioDeCidades;

    @Autowired
    public ValidaCEP_UC(ServicoCEP servicoCEP,RepositorioDeCidades repositorioDeCidades){
        this.servicoCEP = servicoCEP;
        this.repositorioDeCidades = repositorioDeCidades; 
    }

    public String run(String umCEP){
        try {
            var consulta = servicoCEP.pesquisaCEP(umCEP);
            if (consulta == null) {
                return "invalido";
            }
            var nomeCidade = consulta.getLocalidade();
            var cidade = repositorioDeCidades.get(nomeCidade);
            if (cidade != null) {
                return cidade.getNome();
            } else {
                return "nao atendida";
            }
        } catch (Exception e) {
            return "excecao";
        }
    }
}
