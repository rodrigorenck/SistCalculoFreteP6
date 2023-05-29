package com.bcopstein.SistCalculoFreteP6.Aplicacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bcopstein.SistCalculoFreteP6.Dominio.Orcamento;
import com.bcopstein.SistCalculoFreteP6.Dominio.ServicoOrcamento;

@Component
public class CriaOrcamento_UC {
    private ServicoOrcamento servicoOrcamento;

    @Autowired
    public CriaOrcamento_UC(ServicoOrcamento servicoOrcamento){
        this.servicoOrcamento = servicoOrcamento;
    }

    public CustoTempoEntregaDTO run(SolicitaCustoDTO solicitaCustoDTO){
        Orcamento orcamento = servicoOrcamento.calculaOrcamento(solicitaCustoDTO);
        CustoTempoEntregaDTO cte = null;
        if (orcamento != null){
            cte = new CustoTempoEntregaDTO.Builder()
                .cepDestino(solicitaCustoDTO.cepDestino())
                .cepOrigem(solicitaCustoDTO.cepOrigem())
                .cidadeDestino(orcamento.getCidadeDestino().getNome())
                .cidadeOrigem(orcamento.getCidadeOrigem().getNome())
                .custoBasico(orcamento.getCustoBasico())
                .custoFinal(orcamento.getValorFinal())
                .desconto(orcamento.getDesconto())
                .impostosTaxas(orcamento.getImpostos())
                .peso(orcamento.getPeso())
                .diasUteisParaEntrega(orcamento.getDiasUteisParaEntrega())
                .build();
        }else{
            cte = new CustoTempoEntregaDTO.Builder().build();
        }
        return cte;
    }
}
