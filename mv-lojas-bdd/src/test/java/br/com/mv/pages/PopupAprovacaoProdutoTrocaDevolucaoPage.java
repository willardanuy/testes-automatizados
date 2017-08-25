package br.com.mv.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import br.com.mv.utils.ControleJanela;
import net.thucydides.core.pages.PageObject;

public class PopupAprovacaoProdutoTrocaDevolucaoPage extends PageObject {

	@FindBy(id = "nroAPTD")
	private WebElement nroSolicitacao;
	
	@FindBy(id = "stsAPTD")
	private WebElement status;
	
	@FindBy(id = "tipoAPTD")
	private WebElement tipo;
	
	@FindBy(id = "txtPedidoAPTD")
	private WebElement nroPedido;
	
	@FindBy(id = "empresaAPTD")
	private WebElement empresa;
	
	@FindBy(id = "txtCodLojaAPTD")
	private WebElement codNroLoja;
	
	@FindBy(id = "txtMotivo")
	private WebElement motivo;
	
	@FindBy(id = "txtObsSol")
	private WebElement obsSolicitacao;
	
	@FindBy(id = "nroServicoAPTD")
	private WebElement nroProduto;
	
	@FindBy(id = "descProdutoAPTD")
	private WebElement descProduto;
	
	@FindBy(id = "btnAprov")
	private WebElement btnAprovar;
	
	@FindBy(id = "btnReprov")
	private WebElement btnReprovar;
	
	@FindBy(id = "btnFe")
	private WebElement btnFechar;
	
	public PopupAprovacaoProdutoTrocaDevolucaoPage() {
	}

	public String getNroSolicitacao() {
		return nroSolicitacao.getAttribute("value");
	}

	public PopupAprovacaoProdutoTrocaDevolucaoPage setNroSolicitacao(String nroSolicitacao) {
		this.nroSolicitacao.clear();
		this.nroSolicitacao.sendKeys(nroSolicitacao);
		return this;
	}

	public String getStatus() {
		return status.getAttribute("value");
	}

	public PopupAprovacaoProdutoTrocaDevolucaoPage setStatus(String status) {
		this.status.clear();
		this.status.sendKeys(status);
		return this;
	}

	public String getTipo() {
		return tipo.getAttribute("value");
	}

	public PopupAprovacaoProdutoTrocaDevolucaoPage setTipo(String tipo) {
		this.tipo.clear();
		this.tipo.sendKeys(tipo);
		return this;
	}

	public String getNroPedido() {
		return nroPedido.getAttribute("value");
	}

	public PopupAprovacaoProdutoTrocaDevolucaoPage setNroPedido(String nroPedido) {
		this.nroPedido.clear();
		this.nroPedido.sendKeys(nroPedido);
		return this;
	}

	public String getEmpresa() {
		return empresa.getAttribute("value");
	}

	public PopupAprovacaoProdutoTrocaDevolucaoPage setEmpresa(String empresa) {
		this.empresa.clear();
		this.empresa.sendKeys(empresa);
		return this;
	}

	public String getCodNroLoja() {
		return codNroLoja.getAttribute("value");
	}

	public PopupAprovacaoProdutoTrocaDevolucaoPage setCodNroLoja(String codNroLoja) {
		this.codNroLoja.clear();
		this.codNroLoja.sendKeys(codNroLoja);
		return this;
	}

	public String getMotivo() {
		return motivo.getAttribute("value");
	}

	public PopupAprovacaoProdutoTrocaDevolucaoPage setMotivo(String motivo) {
		this.motivo.clear();
		this.motivo.sendKeys(motivo);
		return this;
	}

	public String getObsSolicitacao() {
		return obsSolicitacao.getAttribute("value");
	}

	public PopupAprovacaoProdutoTrocaDevolucaoPage setObsSolicitacao(String obsSolicitacao) {
		this.obsSolicitacao.clear();
		this.obsSolicitacao.getAttribute(obsSolicitacao);
		return this;
	}

	public String getNroProduto() {
		return nroProduto.getAttribute("value");
	}

	public PopupAprovacaoProdutoTrocaDevolucaoPage setNroProduto(String nroProduto) {
		this.nroProduto.clear();
		this.nroProduto.sendKeys(nroProduto);
		return this;
	}

	public String getDescProduto() {
		return descProduto.getAttribute("value");
	}

	public PopupAprovacaoProdutoTrocaDevolucaoPage setDescProduto(String descProduto) {
		this.descProduto.clear();
		this.descProduto.sendKeys(descProduto);
		return this;
	}

	public WebElement getBtnAprovar() {
		return btnAprovar;
	}

	public PopupAprovacaoProdutoTrocaDevolucaoPage clickBtnAprovar() {
		this.btnAprovar.click();
		
		// Etapas APROVADA(s) com sucesso!
		this.waitFor(ExpectedConditions.alertIsPresent());
		this.getAlert().accept();
		
		return this;
	}

	public WebElement getBtnReprovar() {
		return btnReprovar;
	}

	public PopupAprovacaoProdutoTrocaDevolucaoPage clickBtnReprovar() {
		this.btnReprovar.click();
		return this;
	}

	public WebElement getBtnFechar() {
		return btnFechar;
	}

	public PopupAprovacaoProdutoTrocaDevolucaoPage setBtnFechar() {
		this.btnFechar.click();
		return this;
	}
	
	public PopupAprovacaoProdutoTrocaDevolucaoPage selecionarAprovacaoPendente(String descAprovacao) throws InterruptedException {
		$("//table[@id='Etapas:tContent']/tbody/tr/td[text()='" + descAprovacao + "']/parent::tr/td[1]").click();
		Thread.sleep(1000);
		
		return this;
	}
	
	public WebElement getBtnObservacao(String descAprovacao) {
		return $("//table[@id='Etapas:tContent']/tbody/tr/td[text()='" + descAprovacao + "']/parent::tr/td/input[@type='button']");
	}
}
