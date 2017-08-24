package br.com.mv.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import br.com.mv.utils.Utils;
import net.thucydides.core.pages.PageObject;

public class EstoqueLimitePage extends PageObject {

	@FindBy(css = "#btn-criar")
	private WebElement btnCriar;
	
	@FindBy(css = "#uf")
	private WebElement selecaoLojas;
	
	@FindBy(css = "#filtro-loja-nf")
	private WebElement loja;
	
	@FindBy(css = "#filtro-loja-nf ~ ul li a")
	private WebElement opcaoLoja;
	
	@FindBy(css = "#cmb-selecao-produtos")
	private WebElement selecaoProdutos;
	
	@FindBy(css = "input[ng-model='param.qtdade_maxima']")
	private WebElement qtdeMaxima;
	
	@FindBy(css = "input[ng-model='param.produto']")
	private WebElement produto;
	
	@FindBy(css = "input[ng-model='param.produto'] ~ ul li a")
	private WebElement opcaoProduto;
	
	@FindBy(xpath = "html/body/div[2]/div/form/div[2]/div/button[1]")
	private WebElement btnAdicionar;
	
	@FindBy(xpath = "html/body/div[2]/div/form/div[3]/div[2]/button")
	private WebElement btnSalvar;
	
	@FindBy(xpath = "html/body/div[5]/div/div/div[3]/button[1]")
	private WebElement btnSim;
	
	@FindBy(css = "#radio-loja")
	private WebElement radioLoja;
	
	@FindBy(css = "#filtro-loja")
	private WebElement filtroLoja;
	
	@FindBy(css = "#filtro-loja ~ ul li a")
	private WebElement opcaoFiltroLoja;
	
	@FindBy(css = "#btn-pesquisar")
	private WebElement btnPesquisar;
	
	@FindBy(css = "a.glyphicon-edit")
	private WebElement iconeEditar;
	
	@FindBy(xpath = "html/body/div[2]/div/form/div[2]/div/button[2]")
	private WebElement btnConfirmarEdicao;
			
	@FindBy(css = "input[ng-model='data.check']")
	private WebElement chkExclusao;
			
	@FindBy(xpath = "html/body/div[5]/div/div/div[2]")
	private WebElement mensagemExclusao;

	@FindBy(css = "#btn-excluir-registros")
	private WebElement btnExcluirRegistros;

	Utils utils;
	
	public EstoqueLimitePage() {
		this.utils = new Utils();
	}
	
	public void clicarBtnCriar() {
		btnCriar.click();
	}
	
	public void selecaoLojas(String tipoSelecaoLoja) {
		new Select(this.selecaoLojas).selectByVisibleText(tipoSelecaoLoja);
	}
	
	public void loja(String loja) throws InterruptedException {
		utils.preencherCampoTypeAHead(loja, this.loja);
		Thread.sleep(1000);
		this.opcaoLoja.click();
	}
	
	public void filroLoja(String loja) throws InterruptedException {
		utils.preencherCampoTypeAHead(loja, this.filtroLoja);
		Thread.sleep(1000);
		this.opcaoFiltroLoja.click();
	}
	
	public void selecaoProdutos(String tipoSelecaoProduto) throws InterruptedException {
		new Select(this.selecaoProdutos).selectByVisibleText(tipoSelecaoProduto);
	}
	
	public void qtdeMaxima(String qtdeMaxima) {
		this.qtdeMaxima.sendKeys(qtdeMaxima);
	}
	
	public void produto(String produto) throws InterruptedException {
		utils.preencherCampoTypeAHead(produto, this.produto);
		Thread.sleep(1000);
		this.opcaoProduto.click();
	}
	
	public void clicarBotaoAdicionar() {
		btnAdicionar.click();
	}
	
	public void clicarBotaoSalvar() {
		btnSalvar.click();
	}
	
	public void clicarBotaoSim() {
		btnSim.click();
	}
	
	public void validarMensagemSucesso() {
		Assert.assertTrue("Erro ao salvar estoque limite", $(".modal-content .modal-body p").containsText("Configurações salvas com sucesso."));
	}
	
	public void pesquisarPorSelecaoLoja(String tipoSelecaoLoja) {
		if (tipoSelecaoLoja.equals("Loja")) {
			radioLoja.click();
		}
	}
	
	public void clicarBotaoPesquisar() {
		btnPesquisar.click();
	}
	
	public void clicarIconeEdicao() {
		iconeEditar.click();
	}
	
	public void clicarBotaoConfirmarEdicao() {
		btnConfirmarEdicao.click();
	}
	
	public void selecionarEstoqueLimiteParaExcluir() {
		chkExclusao.click();
	}
	
	public void clicarBotaoExcluirEstoqueLimite() {
		btnExcluirRegistros.click();
	}
	
	public void validarMensagemSucessoExclusao() {
		Assert.assertTrue("Erro ao excluir estoque limite", mensagemExclusao.getText().equals("Configurações excluidas com sucesso."));
	}
	
}