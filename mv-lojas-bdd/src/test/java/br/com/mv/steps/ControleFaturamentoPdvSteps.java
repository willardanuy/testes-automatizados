package br.com.mv.steps;

import org.jbehave.core.annotations.When;

import br.com.mv.pages.ControleFaturamentoPdvPage;
import net.thucydides.core.annotations.Steps;

public class ControleFaturamentoPdvSteps {

	@Steps
	ControleFaturamentoPdvPage controleFaturamento;
	
	/**
	 * Informa o numero do pedido para filtro
	 * 
	 * @throws InterruptedException
	 */
	@When("Eu informo o filtro numero do pedido controle de faturamento")
	public void euInformoNumeroPedido() throws InterruptedException {
		controleFaturamento.setTxtPedido();
	}
	
	/**
	 * Informa o numero do pedido para filtro
	 * 
	 * @throws InterruptedException
	 */
	@When("Eu clico no botao pesquisar controle de faturamento")
	public void euClicoBotaoPesquisarControle() throws InterruptedException {
		controleFaturamento.clickBtnPesquisar();
	}
	
	/**
	 * Seleciona o controle de faturamento
	 * 
	 * @throws InterruptedException
	 */
	@When("Eu seleciono o controle de faturamento")
	public void euSelecionoControleFaturamento() throws InterruptedException {
		controleFaturamento.selecionarPedido();
	}
	
	/**
	 * Seleciona o controle de faturamento
	 * 
	 * @throws InterruptedException
	 */
	@When("Eu clico no botao Faturar controle de faturamento")
	public void euClicoBotaoFaturarControle() throws InterruptedException {
		controleFaturamento.clickBtnFaturar();
	}
	
}
