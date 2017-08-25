package br.com.mv.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import br.com.mv.dao.RoteiroDAO;
import br.com.mv.utils.Utils;
import net.thucydides.core.pages.PageObject;

public class RoteiroPage extends PageObject{

	@FindBy(css = "#txt-sf-loja-cod-nro-loja-key")
	private WebElement codLoja;
	
	@FindBy(css = "#btn-sf-loja-search")
	private WebElement lojaSearch;
	
	@FindBy(css = "#inputRota")
	private WebElement rota;
	
	@FindBy(css = "#inputSequencia")
	private WebElement sequencia;
	
	@FindBy(css = "#dt_intervalo")
	private WebElement dtIntervalo;
	
	@FindBy(css = "#inputLojaPedido")
	private WebElement lojaPedido;
	
	@FindBy(css = "input[data-column='qtde_dias_entrega']")
	private WebElement qtdeDiasEntrega;
	
	@FindBy(css = "#cbx_uf_chosen")
	private WebElement uf;
	
	@FindBy(css = "#cbx_cod_cgl_chosen")
	private WebElement cidade;
	
	@FindBy(css = "#cbx_origem_chosen")
	private WebElement origem;
	
	@FindBy(css = "#cbx_empresa_base_chosen")
	private WebElement empresaBase;
	
	@FindBy(css = "#cbx_bairro_chosen")
	private WebElement bairro;
	
	@FindBy(css = "#btn-novo")
	private WebElement btnNovo;
	
	@FindBy(css = "#btn-salvar")
	private WebElement btnSalvar;
	
	@FindBy(css = "#hd-filtro-adicional")
	private WebElement filtroAdicional;
	
	@FindBy(css = "#ckb-todos-bairros")
	private WebElement chkTodosBairros;
	
	private Utils utils;
	private RoteiroDAO roteiroDAO;
	
	public RoteiroPage() {
		this.roteiroDAO = new RoteiroDAO();
		this.utils = new Utils();
	}
	
	public RoteiroPage setCodLoja(String codLoja) {
		this.codLoja.clear();
		this.codLoja.sendKeys(codLoja + Keys.TAB);
		return this;
	}
	
	public RoteiroPage setRota(String rota) {
		this.rota.clear();
		this.rota.sendKeys(rota);
		return this;
	}
	
	public RoteiroPage setSequencia(String sequencia) {
		this.sequencia.clear();
		this.sequencia.sendKeys(sequencia);
		return this;
	}
	
	public RoteiroPage setDtIntervalo(String dtIntervalo) {
		this.dtIntervalo.clear();
		this.dtIntervalo.sendKeys(dtIntervalo);
		return this;
	}
	
	public RoteiroPage setLojaPedido(String lojaPedido) {
		this.lojaPedido.clear();
		this.lojaPedido.sendKeys(lojaPedido);
		return this;
	}
	
	public RoteiroPage setQtdeDiasEntrega(String qtdeDiasEntrega) {
		this.qtdeDiasEntrega.clear();
		this.qtdeDiasEntrega.sendKeys(qtdeDiasEntrega);
		return this;
	}
	
	public RoteiroPage setOrigem(String origem) {
		this.utils.preencherCampoChosen(this.origem, origem);
		return this;
	}
	
	public RoteiroPage setEmpresaBase(String empresaBase) {
		this.utils.preencherCampoChosen(this.empresaBase, empresaBase);
		return this;
	}
	
	public RoteiroPage setUf(String uf) {
		this.utils.preencherCampoChosen(this.uf, uf);
		return this;
	}
	
	public RoteiroPage setCidade(String cidade) {
		this.utils.preencherCampoChosen(this.cidade, cidade);
		return this;
	}
	
	public RoteiroPage clickNovo() {
		this.btnNovo.click();
		return this;
	}
	
	public RoteiroPage clickSalvar() {
		this.btnSalvar.click();
		return this;
	}
	
	public RoteiroPage clickFiltroAdicional() {
		this.filtroAdicional.click();
		return this;
	}
	
	public RoteiroPage setBairro(String bairro) {
		this.utils.preencherCampoChosen(this.bairro, bairro);
		return this;
	}
	
	public RoteiroPage setTodosBairros() {
		System.out.println("vai clicar");
		//this.waitFor(ExpectedConditions.elementToBeClickable(chkTodosBairros));
		this.waitFor(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ckb-todos-bairros")));
		System.out.println("esperou");
		this.chkTodosBairros.click();
		return this;
	}
	
	public void removerRoteiro() {
		roteiroDAO.removerRoteiro();
	}
	
	public void validarMensagemCadastro() {
		// Registro salvo com sucesso!
		String msg = $("div[id^=mdl].modal.in .modal-body").getText();
		
		Assert.assertTrue("O roteiro não foi salvo.", msg.contains("Roteiro salvo com sucesso!"));
		
		getDriver().quit();
	}
}