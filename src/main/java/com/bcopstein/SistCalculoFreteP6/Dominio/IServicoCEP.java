package com.bcopstein.SistCalculoFreteP6.Dominio;

import com.bcopstein.SistCalculoFreteP6.util.ResultadoPesquisaCEP;

public interface IServicoCEP {

    public ResultadoPesquisaCEP pesquisaCEP(String umCEP) throws Exception;
}
