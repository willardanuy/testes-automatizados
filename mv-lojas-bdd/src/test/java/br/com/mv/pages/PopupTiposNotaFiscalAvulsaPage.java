package br.com.mv.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.mv.utils.ControleJanela;
import net.thucydides.core.pages.PageObject;

public class PopupTiposNotaFiscalAvulsaPage extends PageObject {

	@FindBy(id = "btnFechar")
	private WebElement btnFechar;
	
	ControleJanela janela;
	
	public PopupTiposNotaFiscalAvulsaPage() {
		
	}
	
	public WebElement getBtnFechar() {
		return this.btnFechar;
	}
	
	public PopupTiposNotaFiscalAvulsaPage clickBtnFechar() {
		this.btnFechar.click();
		return this;
	}
	
	public PopupTiposNotaFiscalAvulsaPage selecionarTipoNotaFiscal(String nroTipoNF) throws InterruptedException {
		//ControleJanela controleJanela = new ControleJanela(this.driver);
		WebElement linha = $("//table[@id='tableTiposNotaFiscal:tContent']/tbody/tr/td[text()='" + nroTipoNF + "']/parent::tr/td[2]");
		
		janela.fecharJanela(linha);
		
		return this;
	}

}
