package br.com.mv.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import net.thucydides.core.pages.PageObject;

public class PopupMensagensPage extends PageObject {

	@FindBy(id = "btnFechar")
	private WebElement btnFechar;
	
	@FindBy(xpath = "//table/tbody[@id='tbodyTabMensagens']/tr[1]/td[2]")
	private WebElement msg;
	
	@FindBy(xpath = "//div[contains(@class, 'alert') and contains(@style, 'block')]/div/div/div[contains(@class, 'modal-footer')]/button")
	private WebElement btnOkDialog;
	
	public PopupMensagensPage() {
	}
	
	public WebElement getBtnFechar() {
		return this.btnFechar;
	}
	
	public PopupMensagensPage clickBtnFechar() {
		this.btnFechar.click();
		return this;
	}
	
	public String getMsg() {
		return this.msg.getText();
	}
	
	public PopupMensagensPage clickBtnOkDialog() {
		this.btnOkDialog.click();
		return this;
	}

}
