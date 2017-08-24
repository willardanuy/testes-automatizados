package br.com.mv.pages;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.pages.PageObject;
import static br.com.mv.model.SessionVariables.NRO_PEDIDO;

import org.junit.Assert;

public class PDVWebPage extends PageObject {

	public void pesquisarPedido() throws InterruptedException {
		Thread.sleep(5000);
		$("#filtro-flag-acesso").clear();
		$("#filtro-flag-acesso").sendKeys((String) Serenity.sessionVariableCalled(NRO_PEDIDO));
		
		$("#btn-pesquisar").click();
	}
	
	public void receberPedido() throws InterruptedException {
		Thread.sleep(5000);
		$("#btn-receber").click();
	}
	
	public void preencherValores() throws InterruptedException {
		Thread.sleep(5000);
		
		//System.out.println("qtdFormas: " + buscarQtdFormasPagto());
		
		for (int i = 1; i <= buscarQtdFormasPagto(); i++) {
			
			String formaPagto = $("//label[contains(text(), 'Formas de Pagamento')]/parent::div/table/tbody/tr['" + i + "']/td[1]").getText();
			String vlrReceber = $("//label[contains(text(), 'Formas de Pagamento')]/parent::div/table/tbody/tr['" + i + "']/td[2]").getText();
			
			//System.out.println("vlrReceber: " + vlrReceber);
			
			String vlrReceberFormaPagto = (String) this.evaluateJavascript("var vlrReceber = '" + vlrReceber + "'; return vlrReceber.replace(/[\\D]+/g,'');");
	    	
			//System.out.println(".. " + formaPagto + ": " + vlrReceberFormaPagto);
			
			Thread.sleep(5000);
			
	    	$(".table input[ng-model='planilha.valorRecebidoPedido']").sendKeys(vlrReceberFormaPagto);
	    }
	}
	
	public void validarMsgRecebimentoPedido() throws InterruptedException {
		Thread.sleep(5000);
		Assert.assertTrue("O pedido NÃO foi recebido.", $("//html/body/div[2]/div/div[2]/div/div/strong").containsText("recebido com sucesso!"));
	}
	
	public void clickBotaoEmitirCupom() throws InterruptedException {
		Thread.sleep(2000);
		$("#btn-emitir-cupom").click();
	}
	
	public Long buscarQtdFormasPagto() {
		Long qtdformasPagto = (long) this.evaluateJavascript("var scope = $('table').scope(); return scope.pedido.planilhas.length;");
		
		return qtdformasPagto;
	}
}