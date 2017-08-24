package br.com.mv.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import br.com.mv.dao.SequenciaEmpenhoDAO;
import net.thucydides.core.pages.PageObject;

public class SequenciaEmpenhoPage extends PageObject {

	@FindBy(css = "#comboBase")
	private WebElement comboBase;
	
	@FindBy(css = "#txtSequencia")
	private WebElement sequencia;
	
	@FindBy(xpath = ".//*[@id='searchLojaEmpenho']/tbody/tr/td[1]/input")
	private WebElement lojaEmpenho;
	
	@FindBy(xpath = ".//*[@id='sfEmpresaBase']/tbody/tr/td[3]/input")
	private WebElement searchLojaEmpenho;
	
	@FindBy(xpath = ".//*[@id='sfEmpresaBase']/tbody/tr/td[1]/input")
	private WebElement empresaBase;
	
	@FindBy(xpath = ".//*[@id='sfEmpresaBase']/tbody/tr/td[3]/input")
	private WebElement searchEmpresaBase;
	
	@FindBy(css = "#txtDtInicio")
	private WebElement dtInicio;
	
	@FindBy(css = "#txtDtFim")
	private WebElement dtFim;

	private SequenciaEmpenhoDAO sequenciaEmpenhoDAO;
	
	public SequenciaEmpenhoPage() {
		sequenciaEmpenhoDAO = new SequenciaEmpenhoDAO();
	}
	
	public SequenciaEmpenhoPage setBase(String base) {
		new Select(this.comboBase).selectByVisibleText(base);
		return this;
	}
	
	public SequenciaEmpenhoPage setSequencia(String sequencia) {
		this.sequencia.clear();
		this.sequencia.sendKeys(sequencia);
		return this;
	}
	
	public SequenciaEmpenhoPage setLojaEmpenho(String lojaEmpenho) {
		this.lojaEmpenho.clear();
		this.lojaEmpenho.sendKeys(lojaEmpenho);
		this.searchLojaEmpenho.click();
		return this;
	}
	
	public SequenciaEmpenhoPage setEmpresaBase(String empresaBase) {
		this.empresaBase.clear();
		this.empresaBase.sendKeys(empresaBase);
		this.searchEmpresaBase.click();
		return this;
	}
	
	public SequenciaEmpenhoPage setDtInicio(String dtInicio) {
		this.dtInicio.clear();
		this.dtInicio.sendKeys(dtInicio);
		return this;
	}
	
	public SequenciaEmpenhoPage setDtFim(String dtFim) {
		this.dtFim.clear();
		this.dtFim.sendKeys(dtFim);
		return this;
	}
	
	public void removerSequenciaEmpenho() {
		sequenciaEmpenhoDAO.removerSequenciaEmpenho();
	}
	
	public void validarMensagemCadastro() {
		// Registro salvo com sucesso!
		this.waitFor(ExpectedConditions.alertIsPresent());
		String msg = this.getAlert().getText();
		
		Assert.assertTrue("A sequência de empenho não foi salva!", msg.contains("Registro salvo com sucesso"));
		
		getDriver().quit();
	}
}