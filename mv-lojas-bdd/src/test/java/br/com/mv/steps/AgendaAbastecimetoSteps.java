package br.com.mv.steps;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import br.com.mv.pages.AgendaAbastecimentoPage;
import net.thucydides.core.annotations.Steps;

public class AgendaAbastecimetoSteps {

	@Steps
	AgendaAbastecimentoPage agendaAbastecimento;
	
	@When("Eu clico no botao Criar Agenda Abastecimento")
	public void euClicoBotaoAgendaAbastecimento() throws InterruptedException {
		Thread.sleep(2000);
		agendaAbastecimento.clicarBtnCriar();
	}
	
	@When("Eu informo o titulo $titulo da agenda")
	public void euInformoTituloAgenda(String titulo) throws InterruptedException {
		agendaAbastecimento.titulo(titulo);
	}
	
	@When("Eu seleciono o tipo de praca $tipoPraca da agenda")
	public void euSelecionoTipoPraca(String tipoPraca) throws InterruptedException {
		agendaAbastecimento.tipoPraca(tipoPraca);
	}
	
	@When("No cadastro de agenda de abastecimento eu informo o produto $produto")
	public void cadastroAgendaAbastecimentoInformaProduto(String produto) throws InterruptedException {
		agendaAbastecimento.produto(produto);
	}
	
	@When("Eu informo a expectativa de venda $qtdeExpectativaVenda")
	public void euInformoExpectativaVenda(String qtdeExpectativaVenda) throws InterruptedException {
		agendaAbastecimento.qtdeExpectativaVenda(qtdeExpectativaVenda);
	}
	
	@When("Na agenda de abastecimento eu informo a loja $loja")
	public void naAgendaAbastecimentoInformoLoja(String loja) throws InterruptedException {
		agendaAbastecimento.filtroLoja(loja);
	}
	
	@When("Eu clico no botao Adicionar produto na agenda")
	public void euClicoBotaoAdicionarProdutoAgenda() throws InterruptedException {
		agendaAbastecimento.clicarBotaoAdicionarProdutoAgenda();
	}
	
	@When("Eu clico no botao Salvar agenda abastecimento")
	public void euClicoBotaoSalvarAgendaAbastecimento() throws InterruptedException {
		agendaAbastecimento.clicarBotaoSalvarAgendaAbastecimento();
	}
	
	@Then("Eu valido a mensagem de sucesso da agenda de abastecimento")
	public void euValidoMensagemSucessoAgendaAbastecimento() throws InterruptedException {
		agendaAbastecimento.validarMensagemSucesso();
	}
	
	@When("Na agenda abastecimento eu informo uma data fim valida")
	public void naAgendaAbastecimentoEuInformoDataFimValida() throws InterruptedException {
		agendaAbastecimento.informarDataFimValida();
	}
	
	@When("Eu clico no botao Pesquisar agenda de abastecimento")
	public void euClicoBotaoPesquisarAgendaAbastecimento() throws InterruptedException {
		agendaAbastecimento.clicarBotaoPesquisar();
	}
	
	@When("Eu clico no icone Editar agenda")
	public void euClicoIconeEditarAgendaAbastecimento() throws InterruptedException {
		agendaAbastecimento.clicarIconeEditarAgenda();
	}
	
	@When("Eu clico no icone Excluir agenda")
	public void euClicoIconeExcluirAgendaAbastecimento() throws InterruptedException {
		agendaAbastecimento.clicarIconeExcluirAgenda();
	}
	
	@Then("Eu valido a mensagem de exclusao da agenda de abastecimento")
	public void euValidoMensagemExclusaoAgendaAbastecimento() throws InterruptedException {
		agendaAbastecimento.validarMensagemSucessoExclusao();
	}
	
	@When("Eu clico Sim no modal agenda abastecimento")
	public void euClicoSimModalAgenda() {
		agendaAbastecimento.clicarBotaoSim();
	}
}