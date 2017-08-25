package br.com.mv.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.thucydides.core.pages.PageObject;

public class ImpressaoPage extends PageObject {

	@FindBy(css = "#btnImprimir")
	private WebElement btnImprimir;
	
	@FindBy(css = "#btnFecharImpressao")
	private WebElement btnFecharImpressao;
	
	@FindBy(css = "form input[value='Fechar']")
	private WebElement btnFecharRelatorio;
	
	public ImpressaoPage() {
	}
	
	public ImpressaoPage clickBtnImprimir() {
		this.btnImprimir.click();
		return this;
	}
	
	public WebElement getBtnImprimir() {
		return btnImprimir;
	}
	
	public ImpressaoPage clickBtnFecharImpressao() {
		this.btnFecharImpressao.click();
		return this;
	}
	
	public WebElement getBtnFecharImpressao() {
		return this.btnFecharImpressao;
	}
	
	public ImpressaoPage clickBtnFecharRelatorio() {
		this.btnFecharRelatorio.click();
		return this;
	}
	
	public WebElement getBtnFecharRelatorio() {
		return this.btnFecharRelatorio;
	}
}
