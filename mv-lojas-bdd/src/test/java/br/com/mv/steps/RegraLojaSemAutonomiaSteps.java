package br.com.mv.steps;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import br.com.mv.pages.RegraLojasSemAutonomiaPage;
import net.thucydides.core.annotations.Steps;

public class RegraLojaSemAutonomiaSteps {

	@Steps
	RegraLojasSemAutonomiaPage regraLojaSemAutonomia;
	
	@When("Eu clico no botao Incluir Lojas regra lojas sem autonomia")
	public void euClicoBotaoIncluirLojas() throws InterruptedException {
		regraLojaSemAutonomia.clicarBtnCriar();
	}
	
	@When("Eu informo loja $loja regra lojas sem autonomia")
	public void euInformoLoja(String loja) throws InterruptedException {
		regraLojaSemAutonomia.selecionarLoja(loja);
	}
	
	@When("Eu seleciono ativo $indAtivo regra loja sem autonomia")
	public void euSelecionoAtivo(String indAtivo) throws InterruptedException {
		regraLojaSemAutonomia.selecionarAtivo(indAtivo);
	}
	
	@When("Eu clico no botao Adicionar regra loja sem autonomia")
	public void euClicoBotaoAdicionar() throws InterruptedException {
		regraLojaSemAutonomia.clicarBtnAdicionar();
	}
	
	@When("Eu clico no botao Salvar regra loja sem autonomia")
	public void euClicoBotaoSalvar() throws InterruptedException {
		regraLojaSemAutonomia.clicarBtnSalvar();
	}
	
	@Then("Eu valido mensagem sucesso cadastro regra loja sem autonomia")
	public void euValidoMensagemSucessoCadastro() throws InterruptedException {
		regraLojaSemAutonomia.validarMensagemSucessoCadastro();
	}
	
	@When("Eu informo filtro loja $loja regra loja sem autonomia")
	public void euInformoFiltroLoja(String loja) throws InterruptedException {
		regraLojaSemAutonomia.selecionarFiltroLoja(loja);
	}
	
	@When("Eu seleciono filtro ativo $indAtivo regra loja sem autonomia")
	public void euSelecionoFiltroAtivo(String indAtivo) throws InterruptedException {
		regraLojaSemAutonomia.selecionarFiltroAtivo(indAtivo);
	}
	
	@When("Eu clico botao desativar lojas regra loja sem autonomia")
	public void euClicoBotaoDesativarLojas() throws InterruptedException {
		regraLojaSemAutonomia.clicarBtnDesativarLojas();
	}
	
	@When("Eu clico botao ativar lojas regra loja sem autonomia")
	public void euClicoBotaoAtivarLojas() throws InterruptedException {
		regraLojaSemAutonomia.clicarBtnAtivarLojas();
	}
	
	@When("Eu seleciono checkbox ativar/desativar regra loja sem autonomia")
	public void euSelecionoCheckboxLojaLojas() throws InterruptedException {
		regraLojaSemAutonomia.clicarChkAtivarDesativar();
	}
	
	@When("Eu clico no botao Pesquisar regra loja sem autonomia")
	public void euClicoBotaoPesquisar() throws InterruptedException {
		regraLojaSemAutonomia.clicarBtnPesquisar();
	}
	
	@Then("Eu valido mensagem sucesso desativacao loja regra loja sem autonomia")
	public void euValidoMensagemSucessoDesativacaoLoja() throws InterruptedException {
		regraLojaSemAutonomia.validarMensagemSucessoDesativacao();
	}
	
	@Then("Eu valido mensagem sucesso ativacao loja regra loja sem autonomia")
	public void euValidoMensagemSucessoAtivacaoLoja() throws InterruptedException {
		regraLojaSemAutonomia.validarMensagemSucessoAtivacao();
	}
}