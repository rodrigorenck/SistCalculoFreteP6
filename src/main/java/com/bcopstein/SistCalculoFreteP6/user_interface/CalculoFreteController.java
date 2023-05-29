
package com.bcopstein.SistCalculoFreteP6.user_interface;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bcopstein.SistCalculoFreteP6.Aplicacao.CidadesAtendidas_UC;
import com.bcopstein.SistCalculoFreteP6.Aplicacao.CriaOrcamento_UC;
import com.bcopstein.SistCalculoFreteP6.Aplicacao.CustoTempoEntregaDTO;
import com.bcopstein.SistCalculoFreteP6.Aplicacao.ListaOrcamentos_UC;
import com.bcopstein.SistCalculoFreteP6.Aplicacao.Promocoes_UC;
import com.bcopstein.SistCalculoFreteP6.Aplicacao.SolicitaCustoDTO;
import com.bcopstein.SistCalculoFreteP6.Aplicacao.ValidaCEP_UC;
import com.bcopstein.SistCalculoFreteP6.Dominio.Orcamento;

@RestController
@RequestMapping("/calculoFrete")
public class CalculoFreteController {
    private CidadesAtendidas_UC cidadesAtendidas_UC;
    private ValidaCEP_UC validaCEP_UC;
    private Promocoes_UC promocoes_UC;
    private CriaOrcamento_UC criaOrcamento_UC;
    private ListaOrcamentos_UC listaOrcamentos_UC;

    @Autowired
    public CalculoFreteController(CidadesAtendidas_UC cidadesAtendidasUC, ValidaCEP_UC validaCEP_UC, 
                                  Promocoes_UC promocoes_UC,CriaOrcamento_UC criaOrcamento_UC,
                                  ListaOrcamentos_UC listaOrcamentos_UC) {
        this.cidadesAtendidas_UC = cidadesAtendidasUC;
        this.validaCEP_UC = validaCEP_UC;
        this.promocoes_UC = promocoes_UC;
        this.criaOrcamento_UC = criaOrcamento_UC;
        this.listaOrcamentos_UC = listaOrcamentos_UC;
    }

    @GetMapping("/cidadesAtendidas")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<String>> consultaCidadesAtendidas() {
        List<String> nomesCidades = cidadesAtendidas_UC.run();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(nomesCidades);
    }

    @GetMapping("/validaCEP/{umCEP}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<String> validaCEP(@PathVariable("umCEP") String umCEP) {
        String resp = validaCEP_UC.run(umCEP);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(resp);
    }

    @GetMapping("/promocoes")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<String>> consultaPromocoes() {
        List<String> promocoes = promocoes_UC.run();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(promocoes);
    }

    @PostMapping("/custoEntrega")
    @CrossOrigin(origins = "*")
    public ResponseEntity<CustoTempoEntregaDTO> calculaCustoEntrega(@RequestBody final SolicitaCustoDTO solCusto) {
        CustoTempoEntregaDTO custoEntrega = criaOrcamento_UC.run(solCusto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(custoEntrega);
    }

    @GetMapping("/recuperaOrcamento/{dia}/{mes}/{ano}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<Orcamento>> recuperaOrcamento(@PathVariable("dia") int umDia,
            @PathVariable("mes") int umMes, @PathVariable("ano") int umAno) {
        List<Orcamento> orcamentos = listaOrcamentos_UC.run(umDia, umMes, umAno);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(orcamentos);
    }
}