package br.com.mv.pages;

import static br.com.mv.model.SessionVariables.NRO_PEDIDO;
import static br.com.mv.model.SessionVariables.COD_NRO_LOJA;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import br.com.mv.dao.NotaFiscalDAO;
import br.com.mv.model.NotaFiscal;
import br.com.mv.utils.AguardaCarregamento;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.pages.PageObject;

public class PopupParametrosPage extends PageObject {

	@FindBy(id = "txtNumeroCupomFiscal")
	private WebElement nroCumpomFiscal;
	
	@FindBy(id = "cmbEmpresasCupomFiscal")
	private WebElement empresaCupomFiscal;
	
	@FindBy(id = "txtCodNumeroLojaCupomFiscal")
	private WebElement codNroLojaCupomFiscal;
	
	@FindBy(id = "txtNumeroSerieCF")
	private WebElement nroSerieCF;
	
	@FindBy(id = "btnBuscarCupomFiscal")
	private WebElement btnSearchBuscarCupomFiscal;
	
	@FindBy(id = "txtNumeroNotaFiscal")
	private WebElement nroNotaFiscal;
	
	@FindBy(id = "cmbEmpresasNotaFiscal")
	private WebElement empresaNotaFiscal;
	
	@FindBy(id = "txtCodNumeroLojaNotaFiscal")
	private WebElement codNroLojaNotaFiscal;
	
	@FindBy(id = "txtNumeroSerieNF")
	private WebElement nroSerieNF;
	
	@FindBy(id = "btnBuscarNotaFiscal")
	private WebElement btnSearchBuscarNotaFiscal;
	
	@FindBy(id = "txtNumeroCF")
	private WebElement numeroCupom;
	
	@FindBy(id = "txtNumeroNF")
	private WebElement numeroNotaFiscal;
	
	@FindBy(id = "txtDataEmissao")
	private WebElement dataEmissao;
	
	@FindBy(id = "txtValorTotalNF")
	private WebElement valorTotalNF;
	
	@FindBy(id = "btnConcluir")
	private WebElement btnConcluir;
	
	@FindBy(id = "cbxEmpresa")
	private WebElement cbxEmpresa;
	
	@FindBy(id = "cbxLojaDestino")
	private WebElement cbxLojaDestino;
	
	@FindBy(id = "cbxGrupoEstoqueDestino")
	private WebElement cbxGrupoEstoqueDestino;
	
	NotaFiscalDAO nfDAO;
	NotaFiscal cupomFiscal;
	
	public PopupParametrosPage() {
		nfDAO = new NotaFiscalDAO();
		//this.setDadosCupomFiscal();
	}

	public String getNroCumpomFiscal() {
		return nroCumpomFiscal.getAttribute("value");
	}

	public void setDadosNotaFiscal(String tiposNF) {
		String nroPedido = Serenity.sessionVariableCalled(NRO_PEDIDO);
		String codNroLoja = Serenity.sessionVariableCalled(COD_NRO_LOJA);
		//String tiposNF = "5"; // NFCE
		
		//System.out.println("nroPedido: " + nroPedido + " codNroLoja: " + codNroLoja + " tiposNF: " + tiposNF);
		
		this.cupomFiscal = nfDAO.getNotaFiscal(codNroLoja, nroPedido,  tiposNF);
		
	}
	
	public PopupParametrosPage setNroCumpomFiscal(String tipoNF) {
		
		/*String nroPedido = "4634820"; //Serenity.sessionVariableCalled(NRO_PEDIDO);
		String codNroLoja = "291"; //Serenity.sessionVariableCalled(COD_NRO_LOJA);
		String tiposNF = "1";
		
		System.out.println("nroPedido: " + nroPedido + " codNroLoja: " + codNroLoja + " tiposNF: " + tiposNF);
		
		NotaFiscal cupomFiscal = nfDAO.getNotaFiscal(codNroLoja, nroPedido,  tiposNF);*/
		
		setDadosNotaFiscal(tipoNF);
		
		String nroCupomFiscal = "";
		
		if (tipoNF.equals("1")) {
			nroCupomFiscal = Integer.toString(this.cupomFiscal.getNroCupom());
			
			this.nroCumpomFiscal.clear();
			this.nroCumpomFiscal.sendKeys(nroCupomFiscal);
			
		} else {
			nroCupomFiscal = Integer.toString(this.cupomFiscal.getNroNf());
			this.setNroNotaFiscal(nroCupomFiscal);
		}
		
		System.out.println("nroCupomFiscal: " + nroCupomFiscal);
		
		
		return this;
	}
	
	public String getEmpresaCupomFiscal() {
		return new Select(empresaCupomFiscal).getFirstSelectedOption().getText();
	}

	public PopupParametrosPage setEmpresaCupomFiscal(String tipoNF) {
		
		//String empresaCupomFiscal = "";
		//new Select(this.empresaCupomFiscal).selectByVisibleText(empresaCupomFiscal);
		return this;
	}

	public String getCodNroLojaCupomFiscal() {
		return codNroLojaCupomFiscal.getAttribute("value");
	}

	public PopupParametrosPage setCodNroLojaCupomFiscal(String tipoNF) {
		
		setDadosNotaFiscal(tipoNF);
		String codNroLojaCumpomFiscal = Integer.toString(this.cupomFiscal.getCodNroLoja());
		
		if (tipoNF.equals("1")) {
			this.codNroLojaCupomFiscal.clear();
			this.codNroLojaCupomFiscal.sendKeys(codNroLojaCumpomFiscal);
			
		} else {
			this.setCodNroLojaNotaFiscal(codNroLojaCumpomFiscal);
		}
		
		//System.out.println("codNroLojaCumpomFiscal: " + codNroLojaCumpomFiscal);
		
		
		return this;
	}

	public String getNroSerieCF() {
		return nroSerieCF.getAttribute("value");
	}

	public PopupParametrosPage setNroSerieCF(String tipoNF) {
		
		setDadosNotaFiscal(tipoNF);
		
		String nroSerieCF = this.cupomFiscal.getSerieNf();
		
		if (tipoNF.equals("1")) {
			this.nroSerieCF.clear();
			this.nroSerieCF.sendKeys(nroSerieCF);
			
		} else {
			this.setNroSerieNF(nroSerieCF);
		}
		
		//System.out.println("nroSerieCF: " + nroSerieCF);
		
		return this;
	}

	public WebElement getBtnSearchBuscarCupomFiscal() {
		return btnSearchBuscarCupomFiscal;
	}

	public PopupParametrosPage clickBtnSearchBuscarCupomFiscal(String tipoNF) {
		
		if (tipoNF.equals("1")) {
			this.btnSearchBuscarCupomFiscal.click();
		} else {
			this.clickBtnSearchBuscarNotaFiscal();
		}
		
		return this;
	}

	public String getNroNotaFiscal() {
		return nroNotaFiscal.getAttribute("value");
	}

	public PopupParametrosPage setNroNotaFiscal(String nroNotaFiscal) {
		this.nroNotaFiscal.clear();
		this.nroNotaFiscal.sendKeys(nroNotaFiscal);
		return this;
	}

	public String getEmpresaNotaFiscal() {
		return new Select(empresaNotaFiscal).getFirstSelectedOption().getText();
	}

	public PopupParametrosPage setEmpresaNotaFiscal(String empresaNotaFiscal) {
		new Select(this.empresaNotaFiscal).selectByVisibleText(empresaNotaFiscal);
		return this;
	}

	public String getCodNroLojaNotaFiscal() {
		return codNroLojaNotaFiscal.getAttribute("value");
	}

	public PopupParametrosPage setCodNroLojaNotaFiscal(String codNroLojaNotaFiscal) {
		this.codNroLojaNotaFiscal.clear();
		this.codNroLojaNotaFiscal.sendKeys(codNroLojaNotaFiscal);
		return this;
	}

	public String getNroSerieNF() {
		return nroSerieNF.getAttribute("value");
	}

	public PopupParametrosPage setNroSerieNF(String nroSerieNF) {
		this.nroSerieNF.clear();
		this.nroSerieNF.sendKeys(nroSerieNF);
		return this;
	}

	public WebElement getBtnSearchBuscarNotaFiscal() {
		return btnSearchBuscarNotaFiscal;
	}

	public PopupParametrosPage clickBtnSearchBuscarNotaFiscal() {
		this.btnSearchBuscarNotaFiscal.click();
		return this;
	}

	public String getNumeroCumpom() {
		return numeroCupom.getAttribute("value");
	}

	public PopupParametrosPage setNumeroCumpom(String numeroCumpom) {
		this.numeroCupom.clear();
		this.numeroCupom.sendKeys(numeroCumpom);
		return this;
	}

	public String getNumeroNotaFiscal() {
		return numeroNotaFiscal.getAttribute("value");
	}

	public PopupParametrosPage setNumeroNotaFiscal(String numeroNotaFiscal) {
		this.numeroNotaFiscal.clear();
		this.numeroNotaFiscal.sendKeys(numeroNotaFiscal);
		return this;
	}

	public String getDataEmissao() {
		return dataEmissao.getAttribute("value");
	}

	public PopupParametrosPage setDataEmissao(String dataEmissao) {
		this.dataEmissao.clear();
		this.dataEmissao.sendKeys(dataEmissao);
		return this;
	}

	public String getValorTotalNF() {
		return valorTotalNF.getAttribute("value");
	}

	public PopupParametrosPage setValorTotalNF(String valorTotalNF) {
		this.valorTotalNF.clear();
		this.valorTotalNF.sendKeys(valorTotalNF);
		return this;
	}

	public WebElement getBtnConcluir() {
		return btnConcluir;
	}

	public PopupParametrosPage clickBtnConcluir() {
		this.btnConcluir.click();
		return this;
	}
	
	public PopupParametrosPage selecionarNFCF() throws InterruptedException {
		
		String nroPedido = Serenity.sessionVariableCalled(NRO_PEDIDO);
		
		//AguardaCarregamento agCarregamento = new AguardaCarregamento(this.driver);
		$("//table[@id='tableNFCF:tContent']/tbody/tr/td[text()='" + nroPedido + "']/parent::tr/td[2]").click();
		//agCarregamento.aguardarCarregamentoArquiteturaAntiga();
		return this;
	}

	public PopupParametrosPage setEmpresa(String empresa) {
		new Select(this.cbxEmpresa).selectByVisibleText(empresa);
		return this;
	}
	
	public PopupParametrosPage setLojaDestino(String lojaDestino) {
		new Select(this.cbxLojaDestino).selectByVisibleText(lojaDestino);
		return this;
	}
	
	public PopupParametrosPage setGrupoEstoqueDestino(String grupoEstoque) {
		new Select(this.cbxGrupoEstoqueDestino).selectByVisibleText(grupoEstoque);
		return this;
	}
}