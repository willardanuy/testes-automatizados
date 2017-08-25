package br.com.mv.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import net.thucydides.core.pages.PageObject;

public class PopupVinculoMotivoProdutoTDPage extends PageObject {

	@FindBy(id = "txtSolicitacao")
	private WebElement solicitacao;
	
	@FindBy(id = "txtSituacaoPreRecibo")
	private WebElement status;
	
	@FindBy(id = "txtProcesso")
	private WebElement tipo;
	
	@FindBy(id = "cmbMotivos")
	private WebElement motivo;
	
	@FindBy(id = "txtCodigoFluxo")
	private WebElement codFluxo;
	
	@FindBy(id = "txtDescricaoFluxo")
	private WebElement descFluxo;
	
	@FindBy(id = "txtObservacao")
	private WebElement observacao;
	
	@FindBy(className = "buttonSearchField")
	private WebElement btnSearchFieldObs;
	
	@FindBy(id = "btnConcluir")
	private WebElement btnConcluir;
	
	public PopupVinculoMotivoProdutoTDPage() {
		//super(driver);
	}

	public String getSolicitacao() {
		return solicitacao.getAttribute("value");
	}

	public PopupVinculoMotivoProdutoTDPage setSolicitacao(String solicitacao) {
		this.solicitacao.clear();
		this.solicitacao.sendKeys(solicitacao);
		return this;
	}

	public String getStatus() {
		return status.getAttribute("value");
	}

	public PopupVinculoMotivoProdutoTDPage setStatus(String status) {
		this.status.clear();
		this.status.sendKeys(status);
		return this;
	}

	public String getTipo() {
		return tipo.getAttribute("value");
	}

	public PopupVinculoMotivoProdutoTDPage setTipo(String tipo) {
		this.tipo.clear();
		this.tipo.sendKeys(tipo);
		return this;
	}

	public String getMotivo() {
		return motivo.getAttribute("value");
	}

	public PopupVinculoMotivoProdutoTDPage setMotivo(String motivo) {
		new Select(this.motivo).selectByVisibleText(motivo);
		return this;
	}

	public String getCodFluxo() {
		return codFluxo.getAttribute("value");
	}

	public PopupVinculoMotivoProdutoTDPage setCodFluxo(String codFluxo) {
		this.codFluxo.clear();
		this.codFluxo.sendKeys(codFluxo);
		return this;
	}

	public String getDescFluxo() {
		return descFluxo.getAttribute("value");
	}

	public PopupVinculoMotivoProdutoTDPage setDescFluxo(String descFluxo) {
		this.descFluxo.clear();
		this.descFluxo.sendKeys(descFluxo);
		return this;
	}

	public String getObservacao() {
		return observacao.getAttribute("value");
	}

	public PopupVinculoMotivoProdutoTDPage setObservacao(String observacao) {
		this.observacao.clear();
		this.observacao.sendKeys(observacao);
		return this;
	}

	public WebElement getBtnSearchFieldObs() {
		return btnSearchFieldObs;
	}

	public PopupVinculoMotivoProdutoTDPage clickBtnSearchFieldObs() {
		this.btnSearchFieldObs.click();
		return this;
	}

	public WebElement getBtnConcluir() {
		return this.btnConcluir;
	}
	
	public PopupVinculoMotivoProdutoTDPage clickBtnConcluir() {
		this.btnConcluir.click();
		return this;
	}

}
