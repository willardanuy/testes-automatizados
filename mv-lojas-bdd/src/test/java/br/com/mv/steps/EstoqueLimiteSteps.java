package br.com.mv.steps;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import br.com.mv.pages.EstoqueLimitePage;
import net.thucydides.core.annotations.Steps;

public class EstoqueLimiteSteps {

	@Steps
	EstoqueLimitePage estoqueLimite;
	
	@When("Eu clico no botao Adicionar Novo estoque limite")
	public void euClicoBotaoAdicionarEstoqueLimite() throws InterruptedException {
		Thread.sleep(2000);
		estoqueLimite.clicarBtnCriar();
	}
	
	@When("Eu seleciono a opcao $tipoSelecaoLoja do campo selecao de lojas")
	public void euSelecionoOpcaoSelecaoLojas(String tipoSelecaoLoja) {
		estoqueLimite.selecaoLojas(tipoSelecaoLoja);
	}
	
	@When("No estoque limite eu informo a loja $loja")
	public void euInformoLoja(String loja) throws InterruptedException {
		estoqueLimite.loja(loja);
	}
	
	@When("Eu seleciono a opcao $tipoSelecaoProduto do campo selecao de produtos")
	public void euSelecionoOpcaoSelecaoProdutos(String tipoSelecaoProduto) throws InterruptedException {
		estoqueLimite.selecaoProdutos(tipoSelecaoProduto);
	}
	
	@When("Eu informo a quantidade $qtdeMaxima")
	public void euInformoQuantidadeMaxima(String qtdeMaxima) {
		estoqueLimite.qtdeMaxima(qtdeMaxima);
	}
	
	@When("Eu informo o produto $produto")
	public void euInformoProduto(String produto) throws InterruptedException {
		estoqueLimite.produto(produto);
	}
	
	@When("Eu clico no botao Adicionar estoque limite")
	public void euClicoBotaoAdicionarEstoqueLimtie() {
		estoqueLimite.clicarBotaoAdicionar();
	}
	
	@When("Eu clico no botao Salvar estoque limite")
	public void euClicoBotaoSalvarEstoqueLimite() {
		estoqueLimite.clicarBotaoSalvar();
	}
	
	@When("Eu clico Sim no modal estoque limite")
	public void euClicoSimModalEstoqueLimite() {
		estoqueLimite.clicarBotaoSim();
	}
	
	@Then("Eu valido a mensagem de sucesso do cadastro estoque limite")
	public void euValidoMensagemSucessoEstoqueLimite() {
		estoqueLimite.validarMensagemSucesso();
	}
	
	@When("Na pesquisa estoque limite eu seleciono a opcao $tipoSelecaoLoja da selecao de lojas")
	public void naPesquisaEstoqueLimiteEuSelecionoSelecaoLoja(String tipoSelecaoLoja) throws InterruptedException {
		Thread.sleep(2000);
		estoqueLimite.pesquisarPorSelecaoLoja(tipoSelecaoLoja);
	}
	
	@When("Na pesquisa estoque limite eu informo a loja $loja")
	public void naPesquisaEstoqueLimiteEuInformoLoja(String loja) throws InterruptedException {
		estoqueLimite.filroLoja(loja);
	}
	
	@When("Eu clico no botao Pesquisar estoque limite")
	public void euClicoBotaoPesquisarEstoqueLimite() {
		estoqueLimite.clicarBotaoPesquisar();
	}
	
	@When("Eu clico no icone Editar estoque limite")
	public void euClicoIconeEditarEstoqueLimite() {
		estoqueLimite.clicarIconeEdicao();
	}
	
	@When("Eu clico no botao Confirmar Edicao estoque limite")
	public void euClicoBotaoConfirmarEdicaoEstoqueLimite() {
		estoqueLimite.clicarBotaoConfirmarEdicao();
	}
	
	@When("Eu clico no botao Excluir estoque limite")
	public void euClicoBotaoExcluirEstoqueLimite() {
		estoqueLimite.clicarBotaoExcluirEstoqueLimite();
	}
	
	@Then("Eu valido a mensagem de exclusao de estoque limite")
	public void euValidoMensagemExclusao() {
		estoqueLimite.validarMensagemSucessoExclusao();
	}
	
	@When("Eu seleciono o estoque limite para excluir")
	public void euSelecionoEstoqueLimiteParaExcluir() {
		estoqueLimite.selecionarEstoqueLimiteParaExcluir();
	}
	
}