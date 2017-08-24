package br.com.mv.steps;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import br.com.mv.pages.RegraLinhaProdutoPage;
import net.thucydides.core.annotations.Steps;

public class RegraLinhaProdutoSteps {
	
	@Steps
	RegraLinhaProdutoPage regraLinhaProduto;
	
	@When("Eu clico no botao Cadastrar regra linha produto")
	public void euClicoBotaoCadastrarRegraLinhaProduto() throws InterruptedException {
		regraLinhaProduto.clicarBtnCriar();
	}
	
	@When("Eu informo descricao regra linha produto $descricao")
	public void euClicoBotaoCadastrarRegraDataBase(String descricao) throws InterruptedException {
		regraLinhaProduto.descricaoRegra(descricao);
	}

	@When("Eu seleciono departamento $depto regra linha produto")
	public void euSelecionoDepartamentoRegraLinhaProduto(String depto) throws InterruptedException {
		regraLinhaProduto.selecionarDepartamento(depto);
	}
	
	@When("Eu clico no botao Adicionar departamento regra linha produto")
	public void euClicoBotaoAdicionarDepartamentoRegraLinhaProduto() throws InterruptedException {
		regraLinhaProduto.clicarBtnAdicionar();
	}
	
	@When("Eu clico no botao Salvar regra linha produto")
	public void euClicoBotaoSalvarRegraLinhaProduto() throws InterruptedException {
		regraLinhaProduto.clicarBtnSalvar();
	}
	
	@Then("Eu valido mensagem sucesso cadastro regra linha produto")
	public void euValidoMensagemSucessoRegraLinhaProduto() throws InterruptedException {
		regraLinhaProduto.validarMensagemSucessoCadastroRegraLinhaProduto();
	}
	
	@When("Eu clico no botao Pesquisar regra linha produto")
	public void euClicoBotaoPesquisarRegraLinhaProduto() throws InterruptedException {
		regraLinhaProduto.clicarBtnPesquisar();
	}
	
	@When("Eu clico no icone Editar regra linha produto")
	public void euClicoIconeEditarRegraLinhaProduto() throws InterruptedException {
		regraLinhaProduto.clicarIconeEditar();
	}
	
	@When("Eu clico no icone Excluir regra linha produto")
	public void euClicoIconeExcluirRegraLinhaProduto() throws InterruptedException {
		regraLinhaProduto.clicarIconeExcluir();
	}
	
	@When("Eu clico no botao Sim modal regra linha produto")
	public void euClicoBotaoSimRegraLinhaProduto() throws InterruptedException {
		regraLinhaProduto.clicarBtnSim();
	}
	
	@Then("Eu valido mensagem sucesso de exclusao regra linha produto")
	public void euValidoMensagemSucessoExclusaoRegraLinhaProduto() throws InterruptedException {
		regraLinhaProduto.validarMensagemSucessoExclusaoRegraLinhaProduto();
	}
}