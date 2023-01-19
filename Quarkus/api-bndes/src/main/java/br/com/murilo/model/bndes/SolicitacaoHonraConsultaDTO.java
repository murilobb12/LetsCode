package br.com.murilo.model.bndes;

/**
 * Classe responsável por mapear a resposta da consulta de operação pelo ID AGENTE FINANCEIRO
 * endpoint: honra/solicitacoes/operacao/credito-livre/{idAgenteFinanceiro}
 *
 */
public class SolicitacaoHonraConsultaDTO {

        public String comLimite;

        public String contratoRepasse;

        public String dataEstimativaHonra;

        public String dataParcelaInicialASerHonrada;

        public String idOperacaoAgenteCreditoLivre;

        public String sistemaRepasse;

        public EstadoDTO estadoDTO;

        public int idSolicitacaoHonra;

        public double valorEstimadoHonra;

}
