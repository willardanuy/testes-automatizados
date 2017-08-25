package br.com.mv.pages;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.mv.utils.AguardaCarregamento;
import br.com.mv.utils.ControleJanela;
import net.thucydides.core.pages.PageObject;

public class RelatorioComissaoPage extends PageObject {

	@FindBy(css = "#searchComissaoControle .buttonSearchField")
	private WebElement btnSearchReferencia;
	
	@FindBy(css = "#searchLoja .inputText")
	private WebElement codNroLoja;
	
	@FindBy(css = "#btnImprimir")
	private WebElement btnImprimir;
	
	ImpressaoPage impressao;
	
	public RelatorioComissaoPage() {
	}
	
	public WebElement getBtnSearchReferencia() {
		return btnSearchReferencia;
	}
	
	public RelatorioComissaoPage setCodNroLoja(String codNroLoja) {
		this.codNroLoja.clear();
		this.codNroLoja.sendKeys(codNroLoja);
		return this;
	}
	
	public RelatorioComissaoPage clickBtnImprimir() {
		this.btnImprimir.click();
		return this;
	}
	
	public WebElement getBtnImprimir() {
		return btnImprimir;
	}
	
	public void validarRelatorio() throws InterruptedException {
		int tempoEmissaoRelatorio = 120;
		
		for (int i = 0; i < tempoEmissaoRelatorio; i++) {
			System.out.println(new Date());
			Thread.sleep(1000);
		}
		
		new AguardaCarregamento(getDriver()).aguardarCarregamentoArquiteturaAntiga();
		
		try {
			getDriver().findElement(By.cssSelector("#ifRelatorio"));
			
			new ControleJanela(getDriver()).fecharJanela(impressao.getBtnFecharRelatorio());
			
			getDriver().close();
			
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException("O relatório não foi encontrado!");
		}
	}
}
