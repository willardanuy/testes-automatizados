package br.com.mv.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import net.thucydides.core.pages.PageObject;

public class ComissaoAnaliticoEspecialPage extends PageObject {

	@FindBy(xpath = ".//*[@id='sf-referencia']/div/button[1]")
	private WebElement btnPesquisarReferencia;
	
	@FindBy(css = "#btn-imprimir")
	private WebElement btnImprimir;
	
	@FindBy(xpath = ".//*[@id='sf-funcionario']/input[1]")
	private WebElement codFuncionario;
	
	public ComissaoAnaliticoEspecialPage() {
	}
	
	public ComissaoAnaliticoEspecialPage clickPesquisarReferencia() {
		this.btnPesquisarReferencia.click();
		return this;
	}
	
	public ComissaoAnaliticoEspecialPage setCodFuncionario(String codFuncionario) {
		this.codFuncionario.clear();
		this.codFuncionario.sendKeys(codFuncionario + Keys.TAB);
		return this;
	}
	
	public ComissaoAnaliticoEspecialPage clickBtnImprimir() {
		this.btnImprimir.click();
		return this;
	}
	
	public WebElement getBtnImprimir() {
		return btnImprimir;
	}
}
