package br.com.mv.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import net.thucydides.core.pages.PageObject;

public class AberturaControleComissaoPage extends PageObject {

	@FindBy(css = ".mv-sf-filter-search")
	private WebElement btnPesquisar;
	
	@FindBy(css = "input[data-sf-column='mes_comissao,ano_comissao']")
	private WebElement mesAnoComissao;
	
	public AberturaControleComissaoPage() {
	}
	
	public AberturaControleComissaoPage setMesAnoComissao(String mesAnoComissao) {
		this.mesAnoComissao.clear();
		this.mesAnoComissao.sendKeys(mesAnoComissao + Keys.TAB);
		return this;
	}
	
	public AberturaControleComissaoPage clickBtnPesquisar() {
		this.btnPesquisar.click();
		return this;
	}
	
	public AberturaControleComissaoPage selecionarAnoMes(String ano, String mes) {
		getDriver().findElement(By.xpath("//table/tbody[*]/tr/td[text()='" + ano + "']/parent::tr/td[text()='" + mes + "']/parent::tr/td[1]/input")).click();
		return this;
	}
}
