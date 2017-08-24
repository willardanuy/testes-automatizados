package br.com.mv.steps;

import java.io.IOException;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import br.com.mv.dao.PercentualPlusDAO;
import br.com.mv.pages.PercentualPlusPage;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class PercentualPlusSteps {

	@Steps
	PercentualPlusPage percentualPlus;
	
	@When("Eu clico no botao Criar Matriz Plus")
	public void euClicoBotaoCriarMatrizPlus() throws InterruptedException {
		Thread.sleep(2000);
		percentualPlus.clicarBtnCriar();
	}
	
	@When("Na matriz plus eu informo a quantidade de produtos $qtdeProdutos para gerar tabela")
	public void euInformoQtdeProdutosGerarTabela(String qtdeProdutos) throws InterruptedException {
		percentualPlus.setQtdProd(qtdeProdutos);
	}
	
	@When("Na matriz plus eu informo a quantidade de servicos $qtdeServicos para gerar tabela")
	public void euInformoQtdeServicosGerarTabela(String qtdeServicos) throws InterruptedException {
		percentualPlus.qtdServico(qtdeServicos);
	}
	
	@When("Eu clico no botao Gerar tabela percentual plus")
	public void euClicoBotaoGerarTabela() throws InterruptedException {
		percentualPlus.clickGerarTabela();
	}
	
	@When("Eu informo os valores da tabela percentual para $qtdProduto produtos e $qtdServico servicos")
	public void euInformoValoresTabelaPercentualProdutosServicos(String qtdeProdutos, String qtdeServicos) throws InterruptedException {
		double[][] tabelaPercentualProdutos = { {0.01, 50.0}, {50.01, 100.0} };
		double[][] tabelaPercentualServicos = { {0.01, 50.0}, {50.01, 100.0} };
		double[] tabelaPercentualPlus 		= {  0.02, 0.03, 0.04, 0.05};
		String qtdProd = "2";
		String qtdServ = "2";
		
		percentualPlus.setTabelaPercentualPlus(tabelaPercentualProdutos, tabelaPercentualServicos, tabelaPercentualPlus, Integer.parseInt(qtdProd), Integer.parseInt(qtdServ));
	}
	
	@When("Eu clico no botao Salvar matriz percentual")
	public void euClicoBotaoSalvarMatriz() throws InterruptedException {
		percentualPlus.clickSalvar();
	}
	
	@Then("Eu valido a mensagem de sucesso do cadastro percentual plus")
	public void euValidoMensagemSucessoPercentualPlus() throws InterruptedException {
		percentualPlus.validarMensagemSucesso();
	}
	
	@When("Eu clico no botao Pesquisar matriz plus")
	public void euClicoBotaoPesquisarMatrizPlus() throws InterruptedException {
		percentualPlus.clickPesquisar();
	}
	
	@When("Eu clico na chave do percentual plus")
	public void euClicoChavePercentualPlus() throws InterruptedException {
		percentualPlus.clicarChavePercentualPlus();
	}
	
	@When("Na pesquisa matriz plus eu informo a loja $loja")
	public void naPesquisaMatrizPlusInformoLoja(String loja) throws InterruptedException {
		percentualPlus.setPesquisaLoja(loja);
	}
	
	@When("Eu clico no botao Excluir tabela percentual")
	public void euClicoBotaoExcluirTabela() throws InterruptedException {
		percentualPlus.clickExcluirTabela();
	}
	
	@When("Eu confirmo exclusao tabela percentual")
	public void euConfirmoExclusaoTabelaPercentual() throws InterruptedException {
		percentualPlus.confirmarExclusaoTabelaPercentual();
	}
	
	@Then("Eu valido a mensagem de exclusao de tabela percentual")
	public void euValidoMensagemExclusaoTabelaPercentual() throws InterruptedException {
		percentualPlus.validarMensagemSucessoExclusao();
	}
	
	@When("Na matriz plus eu informo a loja $loja")
	public void naMatrizPlusInformoLoja(String loja) throws InterruptedException {
		percentualPlus.setLoja(loja);
	}
	
	@Then("Eu valido o valor do campo plus juros")
	public void euValidoValorCampoPlusJuros() throws InterruptedException {
		percentualPlus.validarValorPlusJuros();
	}
	
	@Then("Eu valido a mensagem de matriz percentual plus ja existente")
	public void euValidoMensagemMatrizExistente() throws InterruptedException {
		percentualPlus.validarMensagemMatrizExistente();
	}
	
	@When("Eu valido os percentuais no base de dados")
	public void euValidoQtdePercentuais() throws InterruptedException, IOException {
		percentualPlus.validarDadosPercentuaisNaBase();
	}
}