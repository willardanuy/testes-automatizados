package br.com.mv.pages;

import static br.com.mv.model.SessionVariables.NRO_PEDIDO;
import static br.com.mv.model.SessionVariables.NRO_NF_AVULSA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.pages.PageObject;

public class PopupConsultaNotaFiscalPage extends PageObject {

	@FindBy(id = "txtDataEmissaoInicio")
	private WebElement dataEmissaoIni;
	
	@FindBy(id = "txtDataEmissaoFim")
	private WebElement dataEmissaoFim;
	
	@FindBy(id = "txtCupom")
	private WebElement cupom;
	
	@FindBy(id = "txtNumeroNf")
	private WebElement nroNF;
	
	@FindBy(id = "cbxSituacao")
	private WebElement situacaoNF;
	
	@FindBy(id = "cbxProcessado")
	private WebElement processo;
	
	@FindBy(id = "txtLojaOrigem")
	private WebElement lojaOrigem;
	
	@FindBy(id = "cbxEmpresaOrigem")
	private WebElement empresaOrigem;
	
	@FindBy(id = "txtLojaDestino")
	private WebElement lojaDestino;
	
	@FindBy(id = "cbxEmpresaDestino")
	private WebElement empresaDestino;
	
	@FindBy(id = "txtSerieNotaFiscal")
	private WebElement serieNF;
	
	@FindBy(css = "#searchCrudTipoNF input[type='text']")
	private WebElement tipoNF;
	
	@FindBy(css = "css=input.buttonSearchField")
	private WebElement btnSearchTipoNF;
	
	@FindBy(id = "txtNumeroPedido")
	private WebElement nroLoja;
	
	@FindBy(id = "txtNumeroLojaPedido")
	private WebElement nroLojaPedido;
	
	@FindBy(css = "#toolbarvazia input[id='toolbarvazia:btnSearch']")
	private WebElement btnPesquisar;
	
	@FindBy(id = "btnSelecionar")
	private WebElement btnSelecionar;
	
	public PopupConsultaNotaFiscalPage() {
	}

	public String getDataEmissaoIni() {
		return dataEmissaoIni.getAttribute("value");
	}

	public PopupConsultaNotaFiscalPage setDataEmissaoIni(String dataEmissaoIni) {
		this.dataEmissaoIni.clear();
		this.dataEmissaoIni.sendKeys(dataEmissaoIni);
		return this;
	}

	public String getDataEmissaoFim() {
		return dataEmissaoFim.getAttribute("value");
	}

	public PopupConsultaNotaFiscalPage setDataEmissaoFim(String dataEmissaoFim) {
		this.dataEmissaoFim.clear();
		this.dataEmissaoFim.sendKeys(dataEmissaoFim);
		return this;
	}

	public String getCupom() {
		return cupom.getAttribute("value");
	}

	public PopupConsultaNotaFiscalPage setCupom(String cupom) {
		this.cupom.clear();
		this.cupom.sendKeys(cupom);
		return this;
	}

	public String getNroNF() {
		return nroNF.getAttribute("value");
	}

	public PopupConsultaNotaFiscalPage setNroNF() {
		
		String nroNF = Serenity.sessionVariableCalled(NRO_NF_AVULSA);
		
		this.nroNF.clear();
		this.nroNF.sendKeys(nroNF);
		return this;
	}

	public String getSituacaoNF() {
		return situacaoNF.getAttribute("value");
	}

	public PopupConsultaNotaFiscalPage setSituacaoNF(String situacaoNF) {
		new Select(this.situacaoNF).selectByVisibleText(situacaoNF);
		return this;
	}

	public String getProcesso() {
		return processo.getAttribute("value");
	}

	public PopupConsultaNotaFiscalPage setProcesso(String processo) {
		new Select(this.processo).selectByVisibleText(processo);
		return this;
	}

	public String getLojaOrigem() {
		return lojaOrigem.getAttribute("value");
	}

	public PopupConsultaNotaFiscalPage setLojaOrigem(String lojaOrigem) {
		this.lojaOrigem.clear();
		this.lojaOrigem.sendKeys(lojaOrigem);
		return this;
	}

	public String getEmpresaOrigem() {
		return empresaOrigem.getAttribute("value");
	}

	public PopupConsultaNotaFiscalPage setEmpresaOrigem(String empresaOrigem) {
		new Select(this.empresaOrigem).selectByVisibleText(empresaOrigem);
		return this;
	}

	public String getLojaDestino() {
		return lojaDestino.getAttribute("value");
	}

	public PopupConsultaNotaFiscalPage setLojaDestino(String lojaDestino) {
		this.lojaDestino.clear();
		this.lojaDestino.sendKeys(lojaDestino);
		return this;
	}

	public String getEmpresaDestino() {
		return empresaDestino.getAttribute("value");
	}

	public PopupConsultaNotaFiscalPage setEmpresaDestino(String empresaDestino) {
		new Select(this.empresaDestino).selectByVisibleText(empresaDestino);
		return this;
	}

	public String getSerieNF() {
		return serieNF.getAttribute("value");
	}

	public PopupConsultaNotaFiscalPage setSerieNF(String serieNF) {
		this.serieNF.clear();
		this.serieNF.sendKeys(serieNF);
		return this;
	}

	public String getTipoNF() {
		return tipoNF.getAttribute("value");
	}

	public PopupConsultaNotaFiscalPage setTipoNF(String tipoNF) {
		this.tipoNF.clear();
		this.tipoNF.sendKeys(tipoNF);
		return this;
	}

	public WebElement getBtnSearchTipoNF() {
		return btnSearchTipoNF;
	}

	public PopupConsultaNotaFiscalPage clickBtnSearchTipoNF() {
		this.btnSearchTipoNF.click();
		return this;
	}

	public String getNroLoja() {
		return nroLoja.getAttribute("value");
	}

	public PopupConsultaNotaFiscalPage setNroLoja(String nroLoja) {
		this.nroLoja.clear();
		this.nroLoja.sendKeys(nroLoja);
		return this;
	}

	public String getNroLojaPedido() {
		return nroLojaPedido.getAttribute("value");
	}

	public PopupConsultaNotaFiscalPage setNroLojaPedido(String nroLojaPedido) {
		this.nroLojaPedido.clear();
		this.nroLojaPedido.sendKeys(nroLojaPedido);
		return this;
	}

	public WebElement getBtnSelecionar() {
		return btnSelecionar;
	}

	public PopupConsultaNotaFiscalPage setBtnSelecionar() {
		this.btnSelecionar.click();
		return this;
	}
	
	public WebElement getBtnPesquisar() {
		return this.btnPesquisar;
	}
	
	public PopupConsultaNotaFiscalPage clickBtnPesquisar() {
		this.btnPesquisar.click();
		return this;
	}
	
	public PopupConsultaNotaFiscalPage selecionarNf(String nroNF) {
		$("//table[@id='table:tContent']/tbody/tr/td[3]/a[text()='" + nroNF + "']/parent::td/parent::tr/td[1]/input").click();
		
		//table[@id='table:tContent']/tbody/tr//parent::td/following-sibling::td[1]
		
		return this;
	}
	
}