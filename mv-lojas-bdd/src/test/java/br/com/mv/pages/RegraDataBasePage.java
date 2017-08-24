package br.com.mv.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import br.com.mv.utils.Utils;
import net.thucydides.core.pages.PageObject;

public class RegraDataBasePage extends PageObject {

	@FindBy(css = "#btn-criar")
	private WebElement btnCriar;
	
	@FindBy(css = "#descricao")
	private WebElement descricao;
	
	@FindBy(css = "select[ng-model='editarDataBaseService.dataBase.tipo_regra']")
	private WebElement tipoRegra;
	
	@FindBy(css = "#dias-data-venda")
	private WebElement diasDataVenda;
	
	@FindBy(css = "#dias-data-entrega")
	private WebElement diasDataEntrega;
	
	@FindBy(css = "#dias-data-montagem")
	private WebElement diasDataMontagem;
	
	@FindBy(css = "#dias-data-faturamento")
	private WebElement diasDataFaturamento;
	
	@FindBy(xpath = ".//button[contains(text(), 'Salvar')]")
	private WebElement btnSalvar;

	@FindBy(css = "a.glyphicon-edit")
	private WebElement iconeEditar;
	
	@FindBy(css = "#descricao_data_base")
	private WebElement descricaoDataBase;
	
	@FindBy(css = "#btn-excluir-")
	private WebElement btnExcluir;
	
	@FindBy(css = "#btn-pesquisar")
	private WebElement btnPesquisar;
	
	@FindBy(xpath = ".//button[contains(text(), 'Sim')]")
	private WebElement btnSim;
	
	@FindBy(css = "#dias_apos_data_venda")
	private WebElement diasAposDataVenda;
	
	@FindBy(css = "#dias_apos_data_entrega")
	private WebElement diasAposDataEntrega;
	
	@FindBy(css = "#dias_apos_data_montagem")
	private WebElement diasAposDataMontagem;
	
	@FindBy(css = "#dias_apos_data_faturamento")
	private WebElement diasAposDataFaturamento;
	
	@FindBy(css = "select[ng-model='dataBase.params.tipo_regra']")
	private WebElement tipoRegraPesquisa;
	
	Utils utils;
	
	public RegraDataBasePage() {
		this.utils = new Utils();
	}
	
	public void clicarBtnCriar() {
		btnCriar.click();
	}
	
	public void clicarIconeEditar() {
		iconeEditar.click();
	}
	
	public void informarDescricao(String descricao) {
		this.descricao.clear();
		this.descricao.sendKeys(descricao);
	}
	
	public void informarTipoRegra(String tipoRegra) {
		new Select(this.tipoRegra).selectByVisibleText(tipoRegra);
	}
	
	public void informarDiasDataVenda(String diasDataVenda) {
		this.diasDataVenda.clear();
		this.diasDataVenda.sendKeys(diasDataVenda);
	}
	
	public void informarDiasDataEntrega(String diasDataEntrega) {
		this.diasDataEntrega.clear();
		this.diasDataEntrega.sendKeys(diasDataEntrega);
	}
	
	public void informarDiasDataMontagem(String diasDataMontagem) {
		this.diasDataMontagem.clear();
		this.diasDataMontagem.sendKeys(diasDataMontagem);
	}
	
	public void informarDiasDataFaturamento(String diasDataFaturamento) {
		this.diasDataFaturamento.clear();
		this.diasDataFaturamento.sendKeys(diasDataFaturamento);
	}
	
	public void clicarBtnSalvar() {
		this.btnSalvar.click();
	}
	
	public void clicarBtnPesquisar() {
		this.btnPesquisar.click();
	}
	
	public void validarMensagemSucesso() throws InterruptedException {
		Thread.sleep(1000);
		Assert.assertTrue("Erro ao salvar regra data base", $(".alert").containsText("Data base salva com sucesso."));
	}
	
	public void validarMensagemRegraDataBaseJaExistente() throws InterruptedException {
		Thread.sleep(1000);
		Assert.assertTrue("Erro ao validar regra data base ja existente", $(".alert").containsText("Já existe uma data base cadastrada com as configurações informada."));
	}
	
	public void informarDescricaoPesquisa(String descricao) {
		this.descricaoDataBase.clear();
		this.descricaoDataBase.sendKeys(descricao);
	}
	
	public void validarMensagemExclusao() throws InterruptedException {
		Assert.assertTrue("Erro ao excluir regra data base", $(".alert").containsText("Data base excluida com sucesso!"));
	}
	
	public void clicarIconeExcluirRegraDataBase() throws InterruptedException {
		Thread.sleep(1000);
		this.btnExcluir.click();
	}
	
	public void clicarBtnSim() {
		this.btnSim.click();
	}
	
	public void informarDiasDataVendaPesquisa(String diasDataVenda) {
		this.diasAposDataVenda.clear();
		this.diasAposDataVenda.sendKeys(diasDataVenda);
	}
	
	public void informarDiasDataEntregaPesquisa(String diasDataEntrega) {
		this.diasAposDataEntrega.clear();
		this.diasAposDataEntrega.sendKeys(diasDataEntrega);
	}
	
	public void informarDiasDataMontagemPesquisa(String diasDataMontagem) {
		this.diasAposDataMontagem.clear();
		this.diasAposDataMontagem.sendKeys(diasDataMontagem);
	}
	
	public void informarDiasDataFaturamentoPesquisa(String diasDataFaturamento) {
		this.diasAposDataFaturamento.clear();
		this.diasAposDataFaturamento.sendKeys(diasDataFaturamento);
	}
	
	public void informarTipoRegraPesquisa(String tipoRegra) {
		new Select(this.tipoRegraPesquisa).selectByVisibleText(tipoRegra);
	}
}