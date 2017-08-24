package br.com.mv.steps;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import br.com.mv.pages.GrupoAcessoAprovacaoPage;
import net.thucydides.core.annotations.Steps;

public class GrupoAcessoAprovacaoSteps {

	@Steps
	GrupoAcessoAprovacaoPage grupoAcessoAprovacao;
	
	@When("Eu clico no botao Cadastrar grupo acesso aprovacao")
	public void euClicoBotaoIncluirLojas() throws InterruptedException {
		grupoAcessoAprovacao.clicarBtnCriar();
	}
	
	@When("Eu informo perfil acesso $perfilAcesso grupo acesso aprovacao")
	public void euClicoBotaoIncluirLojas(String perfilAcesso) throws InterruptedException {
		grupoAcessoAprovacao.selecionarPerfilAcesso(perfilAcesso);
	}
	
	@When("Eu seleciono $indAtivo ativo grupo acesso aprovacao")
	public void euSelecionoIndAtivo(String indAtivo) throws InterruptedException {
		grupoAcessoAprovacao.selecionarAtivo(indAtivo);
	}
	
	@When("Eu clico no botao Salvar grupo acesso aprovacao")
	public void euClicoBotaoSalvar() throws InterruptedException {
		grupoAcessoAprovacao.clicarBtnSalvar();
	}
	
	@Then("Eu valido mensagem sucesso grupo acesso aprovacao")
	public void euValidoMensagemSucesso() throws InterruptedException {
		grupoAcessoAprovacao.validarMensagemSucesso();
	}
	
	@When("Eu informo filtro perfil acesso $perfilAcesso grupo acesso aprovacao")
	public void euInformoFiltroPerfilAcesso(String perfilAcesso) throws InterruptedException {
		grupoAcessoAprovacao.selecionarFiltroPerfilAcesso(perfilAcesso);
	}
	
	@When("No filtro grupo acesso aprovacao eu seleciono $indAtivo ativo")
	public void euSelecionoFiltroIndAtivo(String indAtivo) throws InterruptedException {
		grupoAcessoAprovacao.selecionarFiltroAtivo(indAtivo);
	}
	
	@When("Eu clico no botao icone Editar grupo acesso aprovacao")
	public void euClicoIconeEditar() throws InterruptedException {
		grupoAcessoAprovacao.clicarIconeEditar();
	}
	
	@When("Eu clino no botao Pesquisar grupo acesso aprovacao")
	public void euClicoBotaoPesquisar() throws InterruptedException {
		grupoAcessoAprovacao.clicarBtnPesquisar();
	}
	
}