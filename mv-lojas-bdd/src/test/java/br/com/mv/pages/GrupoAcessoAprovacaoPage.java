package br.com.mv.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import br.com.mv.utils.Utils;
import net.thucydides.core.pages.PageObject;

public class GrupoAcessoAprovacaoPage extends PageObject {

	@FindBy(css = "#btn-criar")
	private WebElement btnCriar;
	
	@FindBy(css = "#filtro-perfil-acesso")
	private WebElement perfilAcesso;
	
	@FindBy(css = "#filtro-perfil-acesso ~ ul li a")
	private WebElement opcaoPerfilAcesso;
	
	@FindBy(css = "select[ng-model='edita.data.ind_ativo']")
	private WebElement indAtivo;
	
	@FindBy(css = "#perfil")
	private WebElement filtroPerfilAcesso;
	
	@FindBy(css = "#perfil ~ ul li a")
	private WebElement opcaoFiltroPerfilAcesso;
	
	@FindBy(css = "select[ng-model='ind_ativo']")
	private WebElement filtroIndAtivo;
	
	@FindBy(xpath = ".//button[contains(text(), 'Salvar')]")
	private WebElement btnSalvar;

	@FindBy(css = "#btn-pesquisar")
	private WebElement btnPesquisar;
	
	@FindBy(css = "a.glyphicon-edit")
	private WebElement iconeEditar;
	
	
	Utils utils;
	
	public GrupoAcessoAprovacaoPage() {
		this.utils = new Utils();
	}
	
	public void clicarBtnCriar() {
		btnCriar.click();
	}
	
	public void clicarBtnSalvar() {
		this.btnSalvar.click();
	}
	
	public void clicarBtnPesquisar() {
		this.btnPesquisar.click();
	}
	
	public void clicarIconeEditar() {
		this.iconeEditar.click();
	}
	
	public void selecionarPerfilAcesso(String perfilAcesso) throws InterruptedException {
		utils.preencherCampoTypeAHead(perfilAcesso, this.perfilAcesso);
		Thread.sleep(1000);
		this.opcaoPerfilAcesso.click();
	}
	
	public void selecionarFiltroPerfilAcesso(String perfilAcesso) throws InterruptedException {
		utils.preencherCampoTypeAHead(perfilAcesso, this.filtroPerfilAcesso);
		Thread.sleep(1000);
		this.opcaoFiltroPerfilAcesso.click();
	}
	
	public void selecionarAtivo(String indAtivo) {
		new Select(this.indAtivo).selectByVisibleText(indAtivo);
	}
	
	public void selecionarFiltroAtivo(String indAtivo) {
		new Select(this.filtroIndAtivo).selectByVisibleText(indAtivo);
	}
	
	public void validarMensagemSucesso() throws InterruptedException {
		Thread.sleep(1000);
		Assert.assertTrue("Erro ao salvar grupo acesso aprovação.", $(".alert").containsText("Registro salvo com sucesso!"));
	} 
}