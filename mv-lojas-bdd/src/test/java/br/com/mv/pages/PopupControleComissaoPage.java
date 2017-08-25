package br.com.mv.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.mv.utils.ControleJanela;
import net.thucydides.core.pages.PageObject;

public class PopupControleComissaoPage extends PageObject {

	@FindBy(css = "#anoComissaoControle")
	private WebElement anoComissao;
	
	@FindBy(css = "#dtRefInicialComissaoControle")
	private WebElement dtRefInicialComissaoControle;
	
	@FindBy(css = "#dtRefFinalComissaoControle")
	private WebElement dtRefFinalComissaoControle;
	
	public PopupControleComissaoPage() {
	}
	
	public PopupControleComissaoPage setAnoComissao(String anoComissao) {
		this.anoComissao.clear();
		this.anoComissao.sendKeys(anoComissao);
		return this;
	}
	
	public PopupControleComissaoPage selecionarMes() throws InterruptedException {
		new ControleJanela(this.getDriver()).fecharJanela(By.xpath("//*[@id='table:tContent']/tbody/tr[1]/td[2]"));
		return this;
	}
	
	public PopupControleComissaoPage setDtRefInicial(String dtRefInicial) {
		this.dtRefInicialComissaoControle.clear();
		this.dtRefInicialComissaoControle.click();
		return this;
	}
	
	public PopupControleComissaoPage setDtRefFinal(String dtRefFinal) {
		this.dtRefFinalComissaoControle.clear();
		this.dtRefFinalComissaoControle.sendKeys(dtRefFinal);
		return this;
	}
}
