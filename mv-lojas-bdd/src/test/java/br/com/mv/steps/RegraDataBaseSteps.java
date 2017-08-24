package br.com.mv.steps;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import br.com.mv.pages.RegraDataBasePage;
import net.thucydides.core.annotations.Steps;

public class RegraDataBaseSteps {

	@Steps
	RegraDataBasePage regraDataBase;
	
	@When("Eu clico no botao Cadastrar Regra Data Base")
	public void euClicoBotaoCadastrarRegraDataBase() throws InterruptedException {
		regraDataBase.clicarBtnCriar();
	}
	
	@When("Eu informo descricao regra data base $descricao")
	public void euInformoDescricaoRegraDataBase(String descricao) throws InterruptedException {
		regraDataBase.informarDescricao(descricao);
	}
	
	@When("Eu seleciono o tipo regra data base $tipoRegra")
	public void euSelecionoTipoRegraDataBase(String tipoRegra) throws InterruptedException {
		regraDataBase.informarTipoRegra(tipoRegra);
	}
	
	@When("Eu informo dias data venda $qtdDias")
	public void euInformoDiasDataVenda(String qtdDias) throws InterruptedException {
		regraDataBase.informarDiasDataVenda(qtdDias);
	}
	
	@When("Eu clico no botao Salvar regra data base")
	public void euClicoBotaoSalvarRegraDataBase() throws InterruptedException {
		regraDataBase.clicarBtnSalvar();
	}
	
	@Then("Eu valido mensagem de sucesso regra data base")
	public void euValidoMensagemSucessoRegraDataBase() throws InterruptedException {
		regraDataBase.validarMensagemSucesso();
	}
	
	@Then("Eu valido mensagem de regra data base ja existente")
	public void euValidoMensagemRegraDataBaseJaExistente() throws InterruptedException {
		regraDataBase.validarMensagemRegraDataBaseJaExistente();
	}
	
	@When("Na pesquisa de regra data base eu informo descricao $descricao")
	public void naPesquisaRegraDataBaseInformoDescricao(String descricao) throws InterruptedException {
		regraDataBase.informarDescricaoPesquisa(descricao);
	}
	
	@When("Eu clico no botao Pesquisar Regra Data Base")
	public void euClicoBotaoPesquisarRegraDataBase() throws InterruptedException {
		regraDataBase.clicarBtnPesquisar();
	}
	
	@When("Eu clico no icone Editar regra data base")
	public void euClicoIconeEditarRegraDataBase() throws InterruptedException {
		regraDataBase.clicarIconeEditar();
	}
	
	@When("Eu informo dias data entrega $qtdDias")
	public void euInformoDiasDataEntrega(String qtdDias) throws InterruptedException {
		regraDataBase.informarDiasDataEntrega(qtdDias);
	}
	
	@When("Eu informo dias data montagem $qtdDias")
	public void euInformoDiasDataMontagem(String qtdDias) throws InterruptedException {
		regraDataBase.informarDiasDataMontagem(qtdDias);
	}
	
	@When("Eu informo dias data faturamento $qtdDias")
	public void euInformoDiasDataFaturamento(String qtdDias) throws InterruptedException {
		regraDataBase.informarDiasDataFaturamento(qtdDias);
	}
	
	@Then("Eu valido mensagem de exclusao regra data base")
	public void euValidoMensagemExclusaoRegraDataBase() throws InterruptedException {
		regraDataBase.validarMensagemExclusao();
	}
	
	@When("Eu clico no icone Excluir regra data base")
	public void euClicoIconeExcluirRegraDataBase() throws InterruptedException {
		regraDataBase.clicarIconeExcluirRegraDataBase();
	}
	
	@When("Eu clico no botao Sim modal regra data base")
	public void euClicoBotaoSimModalRegraDataBase() throws InterruptedException {
		regraDataBase.clicarBtnSim();
	}
	
	@When("Na pesquisa de regra data base eu informo dias data venda $qtdDias")
	public void naPesquisaeuInformoDiasDataVenda(String qtdDias) throws InterruptedException {
		regraDataBase.informarDiasDataVendaPesquisa(qtdDias);
	}
	
	@When("Na pesquisa de regra data base eu informo dias data entrega $qtdDias")
	public void naPesquisaeuInformoDiasDataEntrega(String qtdDias) throws InterruptedException {
		regraDataBase.informarDiasDataEntregaPesquisa(qtdDias);
	}
	
	@When("Na pesquisa de regra data base eu informo dias data montagem $qtdDias")
	public void naPesquisaeuInformoDiasDataMontagem(String qtdDias) throws InterruptedException {
		regraDataBase.informarDiasDataMontagemPesquisa(qtdDias);
	}
	
	@When("Na pesquisa de regra data base eu informo dias data faturamento $qtdDias")
	public void naPesquisaeuInformoDiasDataFaturamento(String qtdDias) throws InterruptedException {
		regraDataBase.informarDiasDataFaturamentoPesquisa(qtdDias);
	}

	@When("Na pesquisa de regra data base eu seleciono tipo regra $tipoRegra")
	public void naPesquisaeuSelecionoTipoRegraDataBase(String tipoRegra) throws InterruptedException {
		regraDataBase.informarTipoRegraPesquisa(tipoRegra);
	}
	
}