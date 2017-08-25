package br.com.mv.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.thucydides.core.pages.PageObject;

public class PopupObsAprovReprovPage extends PageObject {

	@FindBy(id = "txtObsAprovReprov")
	private WebElement observacao;
	
	@FindBy(id = "btnCan")
	private WebElement btnCancelar;
	
	@FindBy(id = "btnFe")
	private WebElement btnOk;
	
	public PopupObsAprovReprovPage() {
	}

	public String getObservacao() {
		return observacao.getAttribute("value");
	}

	public PopupObsAprovReprovPage setObservacao(String observacao) {
		this.observacao.clear();
		this.observacao.sendKeys(observacao);
		return this;
	}

	public WebElement getBtnCancelar() {
		return btnCancelar;
	}

	public PopupObsAprovReprovPage clickBtnCancelar() {
		this.btnCancelar.click();
		return this;
	}

	public WebElement getBtnOk() {
		return btnOk;
	}

	public PopupObsAprovReprovPage clickBtnOk() {
		this.btnOk.click();
		return this;
	}
}