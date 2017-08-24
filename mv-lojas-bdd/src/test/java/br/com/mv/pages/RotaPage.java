package br.com.mv.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import br.com.mv.dao.RotaDAO;
import net.thucydides.core.pages.PageObject;

public class RotaPage extends PageObject {
	
	@FindBy(css = "#comboBase")
	private WebElement comboBase;
	
	@FindBy(css = "#rota")
	private WebElement rota;
	
	@FindBy(xpath = ".//*[@id='searchLoja']/tbody/tr/td[1]/input")
	private WebElement lojaRefaturamento;
	
	@FindBy(xpath = ".//*[@id='searchLoja']/tbody/tr/td[3]/input")
	private WebElement searchLojaRefaturamento;
	
	@FindBy(xpath = ".//*[@id='searchLoja1']/tbody/tr/td[1]/input")
	private WebElement lojaAbastecimento;
	
	@FindBy(xpath = ".//*[@id='searchLoja1']/tbody/tr/td[3]/input")
	private WebElement searchLojaAbastecimento;
	
	@FindBy(css = "#comboEmpresaBase")
	private WebElement comboEmpresaBase;
	
	private RotaDAO rotaDAO;
	
	public RotaPage() {
		this.rotaDAO = new RotaDAO();
	}
	
	public RotaPage setBase(String base) {
		new Select(this.comboBase).selectByVisibleText(base);
		return this;
	}
	
	public RotaPage setRota(String nroRota) {
		this.rota.clear();
		this.rota.sendKeys(nroRota);
		return this;
	}
	
	public RotaPage setLojaRefaturamento(String lojaRefaturamento) {
		this.lojaRefaturamento.clear();
		this.lojaRefaturamento.sendKeys(lojaRefaturamento);
		this.searchLojaRefaturamento.click();
		return this;
	}
	
	public RotaPage setLojaAbastecimento(String lojaAbastecimento) {
		this.lojaAbastecimento.clear();
		this.lojaAbastecimento.sendKeys(lojaAbastecimento);
		this.searchLojaAbastecimento.click();
		return this;
	}
	
	public RotaPage setEmpresaBase(String empresaBase) {
		new Select(this.comboEmpresaBase).selectByVisibleText(empresaBase);
		return this;
	}
	
	public void removerRota(String rota) {
		rotaDAO.removerRota(rota);
	}
}