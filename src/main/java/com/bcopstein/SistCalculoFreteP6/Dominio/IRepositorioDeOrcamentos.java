package com.bcopstein.SistCalculoFreteP6.Dominio;

import java.util.ArrayList;
import java.util.List;

public interface IRepositorioDeOrcamentos {

     List<Orcamento> todos();


     List<Orcamento> deUmaData(int dia,int mes,int ano);


     Orcamento cadastra(Orcamento orcamento);

}
