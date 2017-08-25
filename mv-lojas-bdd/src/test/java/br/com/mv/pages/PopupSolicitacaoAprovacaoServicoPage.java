package br.com.mv.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import net.thucydides.core.pages.PageObject;

public class PopupSolicitacaoAprovacaoServicoPage extends PageObject {

	@FindBy(id = "txtSolicitacao")
	private WebElement solicitacao;
	
	@FindBy(id = "txtSituacaoPreRecibo")
	private WebElement status;
	
	@FindBy(id = "txtProcesso")
	private WebElement tipo;
	
	@FindBy(id = "nroServicoASTD")
	private WebElement nroServico;
	
	@FindBy(id = "descServicoASTD")
	private WebElement descServico;
	
	@FindBy(id = "nroProdutoASTD")
	private WebElement nroProduto;
	
	@FindBy(id = "descProdutoASTD")
	private WebElement descProduto;
	
	@FindBy(id = "solASTD")
	private WebElement solicitacaoProdutoAssociado;
	
	@FindBy(id = "stASTD")
	private WebElement statusProdutoAssociado;
	
	@FindBy(id = "dtASTD")
	private WebElement dataAprovReprov;
	
	@FindBy(id = "cmbMotivos")
	private WebElement motivo;
	
	@FindBy(id = "txtObservacao")
	private WebElement observacao;
	
	@FindBy(className = "buttonSearchField")
	private WebElement btnSearchFieldObs;
	
	@FindBy(id = "btnOk")
	private WebElement btnConcluir;
	
	public PopupSolicitacaoAprovacaoServicoPage() {
	}

	public String getSolicitacao() {
		return solicitacao.getText();
	}

	public PopupSolicitacaoAprovacaoServicoPage setSolicitacao(String solicitacao) {
		this.solicitacao.clear();
		this.solicitacao.sendKeys(solicitacao);
		return this;
	}

	public String getStatus() {
		return status.getText();
	}

	public PopupSolicitacaoAprovacaoServicoPage setStatus(String status) {
		this.status.clear();
		this.status.sendKeys(status);
		return this;
	}

	public String getTipo() {
		return tipo.getText();
	}

	public PopupSolicitacaoAprovacaoServicoPage setTipo(String tipo) {
		this.tipo.clear();
		this.tipo.sendKeys(tipo);
		return this;
	}

	public String getNroServico() {
		return nroServico.getText();
	}

	public PopupSolicitacaoAprovacaoServicoPage setNroServico(String nroServico) {
		this.nroServico.clear();
		this.nroServico.sendKeys(nroServico);
		return this;
	}

	public String getDescServico() {
		return descServico.getText();
	}

	public PopupSolicitacaoAprovacaoServicoPage setDescServico(String descServico) {
		this.descServico.clear();
		this.descServico.sendKeys(descServico);
		return this;
	}

	public String getNroProduto() {
		return nroProduto.getText();
	}

	public PopupSolicitacaoAprovacaoServicoPage setNroProduto(String nroProduto) {
		this.nroProduto.clear();
		this.nroProduto.sendKeys(nroProduto);
		return this;
	}

	public String getDescProduto() {
		return descProduto.getText();
	}

	public PopupSolicitacaoAprovacaoServicoPage setDescProduto(String descProduto) {
		this.descProduto.clear();
		this.descProduto.sendKeys(descProduto);
		return this;
	}

	public String getSolicitacaoProdutoAssociado() {
		return solicitacaoProdutoAssociado.getText();
	}

	public PopupSolicitacaoAprovacaoServicoPage setSolicitacaoProdutoAssociado(String solicitacaoProdutoAssociado) {
		this.solicitacaoProdutoAssociado.clear();
		this.solicitacaoProdutoAssociado.sendKeys(solicitacaoProdutoAssociado);
		return this;
	}

	public String getStatusProdutoAssociado() {
		return statusProdutoAssociado.getText();
	}

	public PopupSolicitacaoAprovacaoServicoPage setStatusProdutoAssociado(String statusProdutoAssociado) {
		this.statusProdutoAssociado.clear();
		this.statusProdutoAssociado.sendKeys(statusProdutoAssociado);
		return this;
	}

	public String getDataAprovReprov() {
		return dataAprovReprov.getText();
	}

	public PopupSolicitacaoAprovacaoServicoPage setDataAprovReprov(String dataAprovReprov) {
		this.dataAprovReprov.clear();
		this.dataAprovReprov.sendKeys(dataAprovReprov);
		return this;
	}
	
	public String getMotivo(){
		return this.motivo.getText();
	}
	
	public PopupSolicitacaoAprovacaoServicoPage setMotivo(String motivo) {
		new Select(this.motivo).selectByVisibleText(motivo);
		return this;
	}
	
	public String getObservacao() {
		return this.observacao.getText();
	}
	
	public PopupSolicitacaoAprovacaoServicoPage setObservacao(String observacao) {
		this.observacao.clear();
		this.observacao.sendKeys(observacao);
		return this;
	}
	
	public WebElement getBntSearchFieldObs() {
		return this.btnSearchFieldObs;
	}
	
	public PopupSolicitacaoAprovacaoServicoPage clickBtnSearchFieldObs() {
		this.btnSearchFieldObs.click();
		return this;
	}
	
	public WebElement getBtnConcluir() {
		return this.btnConcluir;
	}
	
	public PopupSolicitacaoAprovacaoServicoPage clickBtnConcluir() {
		this.btnConcluir.click();
		return this;
	}

}