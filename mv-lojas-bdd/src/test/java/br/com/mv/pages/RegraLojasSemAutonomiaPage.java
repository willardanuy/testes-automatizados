package br.com.mv.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import br.com.mv.utils.Utils;
import net.thucydides.core.pages.PageObject;

public class RegraLojasSemAutonomiaPage extends PageObject {

	@FindBy(css = "#btn-criar")
	private WebElement btnCriar;
	
	@FindBy(css = "#filtro-loja")
	private WebElement loja;
	
	@FindBy(css = "#filtro-loja ~ ul li a")
	private WebElement opcaoLoja;
	
	@FindBy(css = "#loja")
	private WebElement filtroLoja;
	
	@FindBy(css = "#loja ~ ul li a")
	private WebElement filtroOpcaoLoja;
	
	@FindBy(css = "select[ng-model='editarService.data.ind_ativo']")
	private WebElement indAtivo;

	@FindBy(css = "select[ng-model='ind_ativo']")
	private WebElement filtroIndAtivo;
	
	@FindBy(xpath = ".//*[@id='form-tratativas']/div/fieldset[3]/button")
	private WebElement btnAdicionar;
		
	@FindBy(xpath = ".//button[contains(text(), 'Salvar')]")
	private WebElement btnSalvar;

	@FindBy(css = "#btn-pesquisar")
	private WebElement btnPesquisar;
	
	@FindBy(xpath = ".//*[@id='btn-ativar-lojas'][1]")
	private WebElement btnAtivarLojas;
	
	@FindBy(xpath = ".//*[@id='btn-ativar-lojas'][2]")
	private WebElement btnDesativarLojas;
	
	@FindBy(css = "input[ng-model='regra.check']")
	private WebElement chkAtivarDesativar;
	
	Utils utils;
	
	public RegraLojasSemAutonomiaPage() {
		this.utils = new Utils();
	}
	
	public void clicarBtnCriar() {
		btnCriar.click();
	}
	
	public void selecionarLoja(String loja) throws InterruptedException {
		utils.preencherCampoTypeAHead(loja, this.loja);
		Thread.sleep(1000);
		this.opcaoLoja.click();
	}
	
	public void selecionarFiltroLoja(String loja) throws InterruptedException {
		utils.preencherCampoTypeAHead(loja, this.filtroLoja);
		Thread.sleep(1000);
		this.filtroOpcaoLoja.click();
	}
	
	public void selecionarAtivo(String indAtivo) {
		new Select(this.indAtivo).selectByVisibleText(indAtivo);
	}
	
	public void selecionarFiltroAtivo(String indAtivo) {
		new Select(this.filtroIndAtivo).selectByVisibleText(indAtivo);
	}
	
	public void clicarBtnAdicionar() {
		this.btnAdicionar.click();
	}
	
	public void clicarBtnSalvar() {
		this.btnSalvar.click();
	}
	
	public void clicarBtnPesquisar() {
		this.btnPesquisar.click();
	}
	
	public void validarMensagemSucessoCadastro() throws InterruptedException {
		Thread.sleep(1000);
		Assert.assertTrue("Erro ao adicionar lojas.", $(".alert").containsText("Lojas adicionadas com sucesso! Você será redirecionado pra a tela de consulta."));
	}
	
	public void clicarBtnAtivarLojas() {
		this.btnAtivarLojas.click();
	}
	
	public void clicarBtnDesativarLojas() {
		this.btnDesativarLojas.click();
	}
	
	public void clicarChkAtivarDesativar() {
		this.chkAtivarDesativar.click();
	}
	
	public void validarMensagemSucessoDesativacao() throws InterruptedException {
		Thread.sleep(1000);
		Assert.assertTrue("Erro ao desativar lojas.", $(".alert").containsText("Loja(s) atualizada(s) com sucesso!"));
	}
	
	public void validarMensagemSucessoAtivacao() throws InterruptedException {
		Thread.sleep(1000);
		Assert.assertTrue("Erro ao ativar lojas.", $(".alert").containsText("Loja(s) atualizada(s) com sucesso!"));
	}
}