package br.com.mv.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import br.com.mv.utils.Utils;
import net.thucydides.core.pages.PageObject;

public class RegraLocalRetiradaPage extends PageObject {

	@FindBy(css = "#btn-criar")
	private WebElement btnCriar;
	
	@FindBy(css = "#descricao-tratativa")
	private WebElement descricaoTratativa;
	
	@FindBy(xpath = ".//button[contains(text(), 'Salvar')]")
	private WebElement btnSalvar;
	
	@FindBy(xpath = ".//button[contains(text(), 'Cancelar')]")
	private WebElement btnCancelar;
	
	@FindBy(css = "select[ng-model='editaService.data.flag_loja']")
	private WebElement flagLoja;
	
	@FindBy(css = "select[ng-model='editaService.data.flag_cd']")
	private WebElement flagCd;
	
	@FindBy(css = "select[ng-model='editaService.data.flag_loja_base']")
	private WebElement flagLojaBase;
	
	@FindBy(css = "select[ng-model='filtro.flag_loja']")
	private WebElement filtroFlagLoja;
	
	@FindBy(css = "select[ng-model='filtro.flag_cd']")
	private WebElement filtroFlagCd;
	
	@FindBy(css = "select[ng-model='filtro.flag_loja_base']")
	private WebElement filtroFlagLojaBase;
	
	@FindBy(css = "#btn-pesquisar")
	private WebElement btnPesquisar;
	
	@FindBy(css = "a.glyphicon-edit")
	private WebElement iconeEditar;
	
	@FindBy(css = "a.glyphicon-trash")
	private WebElement iconeExcluir;
	
	@FindBy(xpath = ".//button[contains(text(), 'Sim')]")
	private WebElement btnSim;
	
	Utils utils;
	
	public RegraLocalRetiradaPage() {
		this.utils = new Utils();
	}
	
	public void clicarBtnCriar() {
		btnCriar.click();
	}
	
	public void descricaoTratativa(String descricao) {
		descricaoTratativa.clear();
		descricaoTratativa.sendKeys(descricao);
	}
	
	public void clicarBtnSalvar() {
		this.btnSalvar.click();
	}
	
	public void clicarBtnCancelar() {
		this.btnCancelar.click();
	}
	
	public void validarMensagemSucessoSalvarRegraLocalRetirada() throws InterruptedException {
		Thread.sleep(1000);
		Assert.assertTrue("Erro ao salvar regra local retirada.", $(".alert").containsText("Registro salvo com sucesso!"));
	}
	
	public void selecionarFlagLoja(String flagLoja) {
		new Select(this.flagLoja).selectByVisibleText(flagLoja);
	}
	
	public void selecionarFlagCd(String flagCd) {
		new Select(this.flagCd).selectByVisibleText(flagCd);
	}
	
	public void selecionarFlagLojaBase(String flagLojaBase) {
		new Select(this.flagLojaBase).selectByVisibleText(flagLojaBase);
	}
	
	public void selecionarFiltroFlagLoja(String flagLoja) {
		new Select(this.filtroFlagLoja).selectByVisibleText(flagLoja);
	}
	
	public void selecionarFiltroFlagCd(String flagCd) {
		new Select(this.filtroFlagCd).selectByVisibleText(flagCd);
	}
	
	public void selecionarFiltroFlagLojaBase(String flagLojaBase) {
		new Select(this.filtroFlagLojaBase).selectByVisibleText(flagLojaBase);
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
	
	public void validarMensagemSucessoExclusaoRegraLocalRetirada() throws InterruptedException {
		Thread.sleep(1000);
		Assert.assertTrue("Erro ao excluir regra local retirada.", $(".alert").containsText("Regra de local de retirada excluida com sucesso!"));
	}
	
	public void clicarBtnSim() {
		this.btnSim.click();
	}
}