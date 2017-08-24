package br.com.mv.steps;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import br.com.mv.pages.RegraLocalRetiradaPage;
import net.thucydides.core.annotations.Steps;

public class RegraLocalRetiradaSteps {

	@Steps
	RegraLocalRetiradaPage regraLocalRetirada;
	
	@When("Eu clico no botao Cadastrar regra local retirada")
	public void euClicoBotaoCadastrarRegraDataBase() throws InterruptedException {
		regraLocalRetirada.clicarBtnCriar();
	}
	
	@When("Eu informo descricao regra local retirada $descricao")
	public void euInformoDescricaoRegraLocalRetirada(String descricao) throws InterruptedException {
		regraLocalRetirada.descricaoTratativa(descricao);
	}
	
	@When("Eu clico no botao Salvar regra local retirada")
	public void euClicoBotaoSalvarRegraLocalRetirada() throws InterruptedException {
		regraLocalRetirada.clicarBtnSalvar();
	}
	
	@Then("Eu valido mensagem de sucesso regra local retirada")
	public void euValidoMensagemSucessoRegraLocalRetirada() throws InterruptedException {
		regraLocalRetirada.validarMensagemSucessoSalvarRegraLocalRetirada();
	}
	
	@When("Eu seleciono retirada loja $flagLoja regra local retirada")
	public void euSelecionoRetiradaLojaRegraLocalRetirada(String flagLoja) throws InterruptedException {
		regraLocalRetirada.selecionarFlagLoja(flagLoja);
	}
	
	@When("Eu seleciono retirada cd $flagCd regra local retirada")
	public void euSelecionoRetiradaCdRegraLocalRetirada(String flagCd) throws InterruptedException {
		regraLocalRetirada.selecionarFlagCd(flagCd);
	}
	
	@When("Eu seleciono regra retirada loja base $flagLojaBase regra local retirada")
	public void euSelecionoRetiradaLojaBaseRegraLocalRetirada(String flagLojaBase) throws InterruptedException {
		regraLocalRetirada.selecionarFlagLojaBase(flagLojaBase);
	}
	
	@When("Eu seleciono o filtro retirada loja $flagLoja regra local retirada")
	public void euSelecionoFiltroRetiradaLojaRegraLocalRetirada(String flagLoja) throws InterruptedException {
		regraLocalRetirada.selecionarFiltroFlagLoja(flagLoja);
	}
	
	@When("Eu seleciono o filtro retirada cd $flagCd regra local retirada")
	public void euSelecionoFiltroRetiradaCdRegraLocalRetirada(String flagCd) throws InterruptedException {
		regraLocalRetirada.selecionarFiltroFlagCd(flagCd);
	}
	
	@When("Eu seleciono o filtro regra retirada loja base $flagLojaBase regra local retirada")
	public void euSelecionoFiltroRetiradaLojaBaseRegraLocalRetirada(String flagLojaBase) throws InterruptedException {
		regraLocalRetirada.selecionarFiltroFlagLojaBase(flagLojaBase);
	}
	
	@When("Eu clico no botao Pesquisar Regra Local Retirada")
	public void euClicoBotaoPesquisarRegraLocalRetirada() throws InterruptedException {
		regraLocalRetirada.clicarBtnPesquisar();
	}
	
	@When("Eu clico no icone Editar Regra Local Retirada")
	public void euClicoIconeEditarRegraLocalRetirada() throws InterruptedException {
		regraLocalRetirada.clicarIconeEditar();
	}
	
	@When("Eu clico no icone Excluir regra local retirada")
	public void euClicoIconeExcluirRegraLocalRetirada() throws InterruptedException {
		regraLocalRetirada.clicarIconeExcluir();
	}
	
	@When("Eu clico no botao Sim modal regra local retirada")
	public void euClicoBotaoSimModalRegraLocalRetirada() throws InterruptedException {
		regraLocalRetirada.clicarBtnSim();
	}
	
	@Then("Eu valido mensagem sucesso de exclusao regra local retirada")
	public void euValidoMensagemSucessoExclusaoRegraLocalRetirada() throws InterruptedException {
		regraLocalRetirada.validarMensagemSucessoExclusaoRegraLocalRetirada();
	}
}