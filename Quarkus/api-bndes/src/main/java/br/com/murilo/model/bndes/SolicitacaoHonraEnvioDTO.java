package br.com.murilo.model.bndes;

import lombok.Data;

import javax.ws.rs.GET;

@Data
public class SolicitacaoHonraEnvioDTO {

    public String contratoRepasse;

    public String idOperacaoAgenteCreditoLivre;

    public String sistemaRepasse;

    public Double valorEncargosMoratorios;

    public Double valorSaldoDeJurosNaNormalidade;

    public String teste;

    public Double valorSaldoDevedorDePrincipal;

    public AmortizacaoEnvioDTO[] amortizacoesAteADataDaSolicitacaoDeHonra;


}
