package br.com.mv.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import br.com.mv.utils.Utils;
import net.thucydides.core.pages.PageObject;

public class AgendaAbastecimentoPage extends PageObject {

	@FindBy(css = "#btn-criar")
	private WebElement btnCriar;
	
	@FindBy(css = "input[ng-model='editarService.data.titulo']")
	private WebElement titulo;
	
	@FindBy(css = "#flag-tipo-praca")
	private WebElement flagTipoPraca;
			
	@FindBy(css = "#filtro-produto")
	private WebElement filtroProduto;

	@FindBy(css = "#filtro-produto ~ ul li a")
	private WebElement opcaoFiltroProduto;
	
	@FindBy(css = "input[ng-model='editarService.data.qtd_expectativa_venda']")
	private WebElement qtdeExpectativaVenda;
	
	@FindBy(css = "#filtro-loja")
	private WebElement filtroLoja;
	
	@FindBy(css = "#filtro-loja ~ ul li a")
	private WebElement opcaoFiltroLoja;
	
	@FindBy(xpath = "html/body/div[2]/div/form/div[5]/fieldset[3]/button")
	private WebElement btnAdicionar;
	
	@FindBy(xpath = "html/body/div[2]/div/form/div[7]/div/button")
	private WebElement btnSalvar;
	
	@FindBy(css = "#data-fim")
	private WebElement dataFim;
	
	@FindBy(css = "#btn-pesquisar")
	private WebElement btnPesquisar;
	
	@FindBy(css = "#btn-editar-")
	private WebElement btnEditar;
	
	@FindBy(css = "#btn-remover-")
	private WebElement btnRemover;
	
	@FindBy(xpath = "html/body/div[5]/div/div/div[2]")
	private WebElement mensagemExclusao;
	
	@FindBy(xpath = "html/body/div[5]/div/div/div[3]/button[1]")
	private WebElement btnSim;
	
	Utils utils;
	
	public AgendaAbastecimentoPage() {
		this.utils = new Utils();
	}
	
	public void clicarBtnCriar() {
		btnCriar.click();
	}
	
	public void titulo(String titulo) {
		this.titulo.sendKeys(titulo);
	}
	
	public void tipoPraca(String tipoPraca) {
		new Select(this.flagTipoPraca).selectByVisibleText(tipoPraca);
	}
	
	public void produto(String produto) throws InterruptedException {
		utils.preencherCampoTypeAHead(produto, this.filtroProduto);
		Thread.sleep(1000);
		this.opcaoFiltroProduto.click();
	}
	
	public void qtdeExpectativaVenda(String qtdeExpectativa) {
		this.qtdeExpectativaVenda.sendKeys(qtdeExpectativa);
	}
	
	public void filtroLoja(String loja) throws InterruptedException {
		utils.preencherCampoTypeAHead(loja, this.filtroLoja);
		Thread.sleep(1000);
		this.opcaoFiltroLoja.click();
	}
	
	public void clicarBotaoAdicionarProdutoAgenda() {
		btnAdicionar.click();
	}
	
	public void clicarBotaoSalvarAgendaAbastecimento() {
		btnSalvar.click();
	}
	
	public void validarMensagemSucesso() {
		Assert.assertTrue("Erro ao salvar agenda abastecimento", $(".modal-content .modal-body p").containsText("Agendamento de abastecimento salvo com sucesso."));
	}
	
	public void informarDataFimValida() {
		dataFim.sendKeys(utils.getDataAdd(1));
	}
	
	public void clicarBotaoPesquisar() {
		btnPesquisar.click();
	}
	
	public void clicarIconeEditarAgenda() {
		btnEditar.click();
	}
	
	public void clicarIconeExcluirAgenda() {
		btnRemover.click();
	}
	
	public void validarMensagemSucessoExclusao() {
		Assert.assertTrue("Erro ao excluir agenda abastecimento", mensagemExclusao.getText().equals("Registro excluido com sucesso."));
	}
	
	public void clicarBotaoSim() {
		btnSim.click();
	}
}