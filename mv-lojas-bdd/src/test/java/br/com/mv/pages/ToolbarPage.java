package br.com.mv.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import net.thucydides.core.pages.PageObject;

public class ToolbarPage extends PageObject {

	@FindBy(css = "#toolbar input[id='toolbar:btnBack']")
	private WebElement btnVoltar;
	
	@FindBy(css = "#toolbar input[id='toolbar:btnNew']")
	private WebElement btnNovo;
	
	@FindBy(css = "#toolbar input[id='toolbar:btnEdit']")
	private WebElement btnEditar;
	
	@FindBy(css = "#toolbar input[id='toolbar:btnSearch']")
	private WebElement btnPesquisar;
	
	@FindBy(css = "#toolbar input[id='toolbar:btnRemove']")
	private WebElement btnRemover;
	
	@FindBy(css = "#toolbar input[id='toolbar:btnSave']")
	private WebElement btnSalvar;
	
	public ToolbarPage() {
		// TODO Auto-generated constructor stub
	}
	
	public ToolbarPage clickVoltar() {
		this.btnVoltar.click();
		return this;
	}
	
	public WebElement getBtnVoltar() {
		return this.btnVoltar;
	}
	
	public ToolbarPage clickNovo() {
		this.btnNovo.click();
		return this;
	}
	
	public WebElement getBtnNovo() {
		return this.btnNovo;
	}
	
	public ToolbarPage clickEditar() {
		this.btnEditar.click();
		return this;
	}
	
	public WebElement getBtnEditar() {
		return this.btnEditar;
	}
	
	public ToolbarPage clickPesquisar() {
		btnPesquisar.click();
		return this;
	}
	
	public WebElement getBtnPesquisar() {
		return this.btnPesquisar;
	}
	
	public ToolbarPage clickRemover() {
		btnRemover.click();
		return this;
	}
	
	public WebElement getBtnRemover() {
		return this.getBtnRemover();
	}
	
	public ToolbarPage clickSalvar() {
		this.btnSalvar.click();
		return this;
	}
	
	public WebElement getBtnSalvar() {
		return this.btnSalvar;
	}

}
