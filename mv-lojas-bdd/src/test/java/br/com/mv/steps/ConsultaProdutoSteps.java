package br.com.mv.steps;

import org.jbehave.core.annotations.When;

import br.com.mv.pages.ConsultaProdutoModal;
import br.com.mv.pages.ConsultaPromocaoModal;
import net.thucydides.core.annotations.Steps;

public class ConsultaProdutoSteps {

	@Steps
	ConsultaProdutoModal consultaProdutoModal;
	ConsultaPromocaoModal consultaPromocaoModal;
	
	/**
	 * Realiza a pesquisa e seleção de um produto.
	 * 
	 * @param codNroProduto
	 * @throws InterruptedException
	 */
	@When("Eu pesquiso e seleciono o produto $codNroProduto")
	public void euPesquisoProduto(String codNroProduto) throws InterruptedException {
		
		consultaProdutoModal.pesquisarProduto(codNroProduto);
		Thread.sleep(2000);
		consultaProdutoModal.clickSelecionar();
		Thread.sleep(1000);
	}
	
	/**
	 * Realiza a pesquisa e seleção de um produto.
	 * 
	 * @param codNroProduto
	 * @throws InterruptedException
	 */
	@When("Eu pesquiso o produto $codNroProduto")
	public void euPesquisoOProduto(String codNroProduto) throws InterruptedException {
		
		consultaProdutoModal.pesquisarProduto(codNroProduto);
	}
	
	/**
	 * Clica no botão pesquisa de Kit
	 * 
	 * @param codNroProduto
	 * @throws InterruptedException
	 */
	@When("Eu clico no botao Kit")
	public void euClicoNoBotaoKit() throws InterruptedException {
		
		consultaProdutoModal.clicarBotaoKit();
	}
	
	/**
	 * Seleciona a opcao de kit Venda Avulsa
	 * 
	 * @param codNroProduto
	 * @throws InterruptedException
	 */
	@When("Eu seleciono a opcao de kit Venda Avulsa")
	public void euSelecionoOpcaoKitVendaAvulsa() throws InterruptedException {
		
		consultaProdutoModal.selecionarOpcaoKitVendaAvulsa();
	}
	
	/**
	 * Seleciona o kit
	 * 
	 * @param numeroKit
	 * @throws InterruptedException
	 */
	@When("Eu seleciono o kit $numeroKit")
	public void euSelecionoOKit(String nrokit) throws InterruptedException {
		
		consultaProdutoModal.selecionarKit(nrokit);
	}
	
	/**
	 * Clica no botao selecionar produto
	 * 
	 * @throws InterruptedException
	 */
	@When("Eu clico no botao Selecionar Produto")
	public void euClicoBotaoSelecionarProduto() throws InterruptedException {
		
		consultaProdutoModal.clickSelecionar();
	}
	
	/**
	 * Clica no botao selecionar produto
	 * 
	 * @throws InterruptedException
	 */
	@When("Eu seleciono a promocao de valor $valorPromocao")
	public void euSelecionoAPromocao(String valorPromocao) throws InterruptedException {
		
		consultaPromocaoModal.selecionarPromocao(valorPromocao);
	}
	
	
}