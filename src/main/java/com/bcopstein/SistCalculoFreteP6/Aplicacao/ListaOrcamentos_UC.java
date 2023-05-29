package com.bcopstein.SistCalculoFreteP6.Aplicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bcopstein.SistCalculoFreteP6.Dominio.Orcamento;
import com.bcopstein.SistCalculoFreteP6.Dominio.ServicoOrcamento;

@Component
public class ListaOrcamentos_UC {
    private ServicoOrcamento servicoOrcamento;

    @Autowired
    public ListaOrcamentos_UC(ServicoOrcamento servicoOrcamento){
        this.servicoOrcamento = servicoOrcamento;
    }

    public List<Orcamento> run(int dia,int mes, int ano){
        return servicoOrcamento.deUmaData(dia, mes, ano);
    }
}
