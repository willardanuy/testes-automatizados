package br.com.mv.pages;

import static br.com.mv.model.SessionVariables.NRO_PEDIDO;
import static br.com.mv.model.SessionVariables.NRO_PRE_RECIBO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import br.com.mv.utils.Utils;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.pages.PageObject;

public class PreReciboTrocaDevolucaoPage extends PageObject {

	//Seleção das lojas do pré-recibo
	@FindBy(id = "radioLojaUnico")
	private WebElement radioLoja;
	
	@FindBy(id = "radioLoja")
	private WebElement radioAgrupamentoLoja;
	
	@FindBy(id = "radioRegiao")
	private WebElement radioRegiao;
	
	@FindBy(id = "radioEstado")
	private WebElement radioEstado;
	
	@FindBy(css = "#searchLoja input.inputText")
	private WebElement searchFieldLoja;
	
	@FindBy(xpath = "(//input[@type='button'])[4]")
	private WebElement searchAgrupamentoLoja;
	
	@FindBy(id = "cbxRegiao")
	private WebElement cbxRegiao;
	
	@FindBy(id = "cbxEstado")
	private WebElement cbxEstado;
	//--
	
	@FindBy(id = "nroPreRecibo")
	private WebElement preRecibo;
	
	@FindBy(id = "dtInicio")
	private WebElement dataInicio;
	
	@FindBy(id = "dtFim")
	private WebElement dataFim;
	
	@FindBy(id = "cbxStatus")
	private WebElement cbxStatus;
	
	@FindBy(id = "cmbTipo")
	private WebElement cbxTipo;
	
	@FindBy(id = "txtPedido")
	private WebElement nroPedido;
	
	@FindBy(id = "cmbEmpresas")
	private WebElement cbxEmpresa;
	
	@FindBy(id = "txtCodNumeroLoja")
	private WebElement codNroLoja;
	
	@FindBy(id = "cmbProcesso")
	private WebElement cmbProcesso;
	
	//botões toolbar
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
	
	Utils utils;
	
	public PreReciboTrocaDevolucaoPage() {
		this.utils = new Utils();
	}

	public PreReciboTrocaDevolucaoPage clickRadioLoja() {
		radioLoja.click();
		return this;
	}
	
	public PreReciboTrocaDevolucaoPage clickRadioAgrupamentoLoja() {
		radioAgrupamentoLoja.click();
		return this;
	}
	
	public WebElement getRadioAgrupamentoLoja() {
		return radioAgrupamentoLoja;
	}
	
	public PreReciboTrocaDevolucaoPage setRadioRegiao() {
		radioRegiao.click();
		return this;
	}
	
	public PreReciboTrocaDevolucaoPage setRadioEstado() {
		radioEstado.click();
		return this;
	}
	
	public PreReciboTrocaDevolucaoPage setSearchFieldLoja(String loja) {
		searchFieldLoja.clear();
		searchFieldLoja.sendKeys(loja);
		return this;
	}
	
	public PreReciboTrocaDevolucaoPage clickSearchAgrupamentoLoja() {
		searchAgrupamentoLoja.click();
		return this;
	}
	
	public WebElement getSearchAgrupamentoLoja() {
		return searchAgrupamentoLoja;
	}
	
	public PreReciboTrocaDevolucaoPage setCbxRegiao(String txtRegiao) {
		new Select(this.cbxRegiao).selectByVisibleText(txtRegiao);
		return this;
	}
	
	public PreReciboTrocaDevolucaoPage setCbxEstado(String txtEstado) {
		new Select(cbxEstado).selectByVisibleText(txtEstado);
		return this;
	}
	
	public PreReciboTrocaDevolucaoPage informarNroPreRecibo() {
		
		String nroPreRecibo = Serenity.sessionVariableCalled(NRO_PRE_RECIBO);
		
		System.out.println("Pré-recibo: " + nroPreRecibo);
		
		preRecibo.clear();
		preRecibo.sendKeys(nroPreRecibo);
		return this;
	}
	
	public String preRecibo() {
		return preRecibo.getAttribute("value");
	}
	
	public PreReciboTrocaDevolucaoPage setDataInicio(String dtInicio) {
		dataInicio.clear();
		dataInicio.sendKeys(dtInicio);
		return this;
	}
	
	public PreReciboTrocaDevolucaoPage setDataFim(String dtFim) {
		dataFim.clear();
		dataFim.sendKeys(dtFim);
		return this;
	}

	public PreReciboTrocaDevolucaoPage setCbxStatus(String txtStatus) {
		new Select(cbxStatus).selectByVisibleText(txtStatus);
		return this;
	}
	
	public PreReciboTrocaDevolucaoPage setCbxTipo(String txtTipo) {
		new Select(cbxTipo).selectByVisibleText(txtTipo);
		return this;
	}
	
	public PreReciboTrocaDevolucaoPage setNroPedido(String txtNroPedido) {
		nroPedido.clear();
		nroPedido.sendKeys(txtNroPedido);
		return this;
	}
	
	public PreReciboTrocaDevolucaoPage setCbxEmpresa(String txtEmpresa) {
		new Select(cbxEmpresa).selectByVisibleText(txtEmpresa);
		return this;
	}
	
	public PreReciboTrocaDevolucaoPage setCbxProcesso(String txtProcesso) {
		new Select(cmbProcesso).selectByVisibleText(txtProcesso);
		return this;
	}
	
	public PreReciboTrocaDevolucaoPage setCodNroLoja(String txtCodNroLoja) {
		codNroLoja.clear();
		codNroLoja.sendKeys(txtCodNroLoja);
		return this;
	}
	
	public PreReciboTrocaDevolucaoPage aguardar() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	};
	
	public PreReciboTrocaDevolucaoPage selecionarPreRecibo() {
		String nroPreRecibo = Serenity.sessionVariableCalled(NRO_PRE_RECIBO);
		
		$(".//table[@id='table:tContent']/tbody/tr/td[text()='" + nroPreRecibo + "']/parent::tr/td[1]").click();
		
		return this;
	}
}
