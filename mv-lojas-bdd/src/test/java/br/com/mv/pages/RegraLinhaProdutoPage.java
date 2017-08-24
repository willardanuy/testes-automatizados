package br.com.mv.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.mv.utils.Utils;
import net.thucydides.core.pages.PageObject;

public class RegraLinhaProdutoPage extends PageObject {

	@FindBy(css = "#btn-criar")
	private WebElement btnCriar;
	
	@FindBy(css = "#descricao-tratativa")
	private WebElement descricaoRegra;
	
	@FindBy(css = "#filtro-departamento")
	private WebElement departamento;
	
	@FindBy(css = "#filtro-departamento ~ ul li a")
	private WebElement opcaoDepartamento;
	
	@FindBy(xpath = ".//*[@id='form-tratativas']/div[3]/fieldset[2]/button")
	private WebElement btnAdicionar;
	
	@FindBy(xpath = ".//button[contains(text(), 'Salvar')]")
	private WebElement btnSalvar;
	
	@FindBy(xpath = ".//button[contains(text(), 'Cancelar')]")
	private WebElement btnCancelar;
	
	@FindBy(css = "#btn-pesquisar")
	private WebElement btnPesquisar;
	
	@FindBy(css = "a.glyphicon-edit")
	private WebElement iconeEditar;
	
	@FindBy(css = "a.glyphicon-trash")
	private WebElement iconeExcluir;
	
	@FindBy(xpath = ".//button[contains(text(), 'Sim')]")
	private WebElement btnSim;
	
	Utils utils;
	
	public RegraLinhaProdutoPage() {
		this.utils = new Utils();
	}
	
	public void clicarBtnCriar() {
		btnCriar.click();
	}
	
	public void descricaoRegra(String descricao) {
		descricaoRegra.clear();
		descricaoRegra.sendKeys(descricao);
	}
	
	public void selecionarDepartamento(String departamento) throws InterruptedException {
		utils.preencherCampoTypeAHead(departamento , this.departamento);
		Thread.sleep(1000);
		this.opcaoDepartamento.click();
	}
	
	public void clicarBtnAdicionar() {
		this.btnAdicionar.click();
	}
	
	public void clicarBtnSalvar() {
		this.btnSalvar.click();
	}
	
	public void clicarBtnCancelar() {
		this.btnCancelar.click();
	}
	
	public void clicarBtnPesquisar() {
		this.btnPesquisar.click();
	}
	
	public void clicarIconeEditar() {
		this.iconeEditar.click();
	}
	
	public void clicarIconeExcluir() {
		this.iconeExcluir.click();
	}
	
	public void validarMensagemSucessoExclusaoRegraLinhaProduto() throws InterruptedException {
		Thread.sleep(1000);
		Assert.assertTrue("Erro ao excluir regra linha produto.", $(".alert").containsText("Regra de linha de produto excluida com sucesso!"));
	}
	
	public void clicarBtnSim() {
		this.btnSim.click();
	}
	
	public void validarMensagemSucessoCadastroRegraLinhaProduto() throws InterruptedException {
		Thread.sleep(1000);
		Assert.assertTrue("Erro ao salvar regra linha produto.", $(".alert").containsText("Registro salvo com sucesso!"));
	}
}