package br.com.mv.steps;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import br.com.mv.pages.PercentualEstoqueMinimoPage;
import net.thucydides.core.annotations.Steps;

public class PercentualEstoqueMinimoSteps {

	@Steps
	PercentualEstoqueMinimoPage percentualEstoqueMinimo;
	
	@When("Eu clico no botao Criar Percentual Estoque Minimo")
	public void euClicoBotaoCriarPercentualEstoqueMinimo() throws InterruptedException {
		Thread.sleep(2000);
		percentualEstoqueMinimo.clicarBtnCriar();
	}
	
	@When("Eu informo o percentual minimo $percentualMinimo")
	public void euInformoPercentualEstoqueMinimo(String percMinimo) {
		percentualEstoqueMinimo.valorPercentualMinimo(percMinimo);
	}
	
	@When("Eu informo a data inicio $dataInicio")
	public void euInformoDataInicio(String dtInicio) {
		percentualEstoqueMinimo.dataInicio(dtInicio);
	}
	
	@When("Eu informo a data fim $dataFim")
	public void euInformoDataFim(String dtFim) {
		percentualEstoqueMinimo.dataFim(dtFim);
	}
	
	@When("Eu informo o CD $cd")
	public void euInformoCD(String cd) throws InterruptedException {
		percentualEstoqueMinimo.selecaoCD(cd);
	}
	
	@When("Eu informo a situacao $situacao")
	public void euInformoSituacao(String situacao) {
		percentualEstoqueMinimo.situacao(situacao);
	}
	
	@When("Eu clico no botao Salvar percentual estoque minimo")
	public void euClicoSalvarPercentualEstoqueMinimo() {
		percentualEstoqueMinimo.clicarBtnSalvar();
	}
	
	@Then("Eu valido a mensagem de sucesso do percentual estoque minimo")
	public void euValidoMensagemSucessoPercentualEstoqueMinimo() {
		percentualEstoqueMinimo.validarMensagemSucesso();
	}
	
	@When("Na pesquisa eu informo o cd $cd")
	public void naPesquisaEuInformoCD(String cd) throws InterruptedException {
		percentualEstoqueMinimo.filtroCD(cd);
	}
	
	@When("Eu clico no botao Pesquisar percentual minimo")
	public void euClicoBotaoPesquisarPercentualMinimo() {
		percentualEstoqueMinimo.clicarBtnPesquisar();
	}
	
	@Then("Eu valido o resultado da pesquisa de percentual minimo")
	public void euValidoResultadoPesquiaPercentualMinimo() {
		percentualEstoqueMinimo.clicarBtnCriar();
	}
	
	@When("Eu clico no botao Ok do modal de percentual minimo")
	public void euClicoBotaoOkModalPercentualMinimo() {
		percentualEstoqueMinimo.clicarBtnCriar();
	}
	
	@When("Eu clico no botao Voltar")
	public void euClicoBotaoVoltar() {
		percentualEstoqueMinimo.clicarBtnCriar();
	}
	
	@When("Eu clico no botao Excluir do registro encontrado")
	public void euClicoBotaoExcluirPercentualMinimo() {
		percentualEstoqueMinimo.clicarIconeRemover();
	}
	
	@When("Eu clico no botao Exportar")
	public void euClicoBotaoExportarPercentualMinimo() {
		percentualEstoqueMinimo.clicarBtnCriar();
	}
	
	@When("Eu clico no icone Editar percentual minimo")
	public void euClicoBotaoEditarPercentualMinimo() {
		percentualEstoqueMinimo.clicarIconeEdicao();
	}
	
	@When("Eu clico Sim no modal percentual estoque minimo")
	public void euClicoSimModalPercentualMinimo() {
		percentualEstoqueMinimo.clicarBtnSimModal();
	}
	
	@Then("Eu valido mensagem de exclusao percentual estoque minimo")
	public void euValidoMensagemExclusao() {
		percentualEstoqueMinimo.validarMensagemExclusao();
	}
	
	
}