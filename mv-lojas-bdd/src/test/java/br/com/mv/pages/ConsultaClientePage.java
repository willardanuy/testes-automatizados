package br.com.mv.pages;

import org.openqa.selenium.NoSuchElementException;

import br.com.mv.utils.AguardaCarregamento;
import net.thucydides.core.pages.PageObject;

public class ConsultaClientePage extends PageObject {

	public void consultarCpf(String cpf) throws InterruptedException {
		
		try {
			Thread.sleep(3000);
			new AguardaCarregamento(this.getDriver()).aguardarCarregamentoNovaArquitetura2();
			
			$("#cbx-cpf").clear();
			$("#cbx-cpf").sendKeys(cpf);
			
			Thread.sleep(4000);
			
			$("#btn-pesquisar").click();
			
		      
		} catch(NoSuchElementException e) {
			throw new NoSuchElementException(e.getMessage());
		}
	}
	
	public void consultarCnpj(String cnpj) throws InterruptedException {
		
		try {
			new AguardaCarregamento(this.getDriver()).aguardarCarregamentoNovaArquitetura();
			Thread.sleep(2000);
			$("#ckb-tipo-pessoa").click();
			
			Thread.sleep(2000);
			
			$("#cbx-cnpj").clear();
			$("#cbx-cnpj").sendKeys(cnpj);
			
			Thread.sleep(2000);
			
			$("#btn-pesquisar").click();
			Thread.sleep(1000);

		      
		} catch(NoSuchElementException e) {
			throw new NoSuchElementException(e.getMessage());
		}
	}

	public void clicarNoBotao(String nomeBotao) throws InterruptedException {
		Thread.sleep(1000);

		//new AguardaCarregamento(this.getDriver()).aguardarCarregamentoNovaArquitetura();
		Thread.sleep(2000);

		$(".//*/button[contains(text(), '" + nomeBotao + "')]").click();
		Thread.sleep(1000);

	}
}            