package br.com.mv.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import br.com.mv.utils.Utils;
import net.thucydides.core.pages.PageObject;

public class PercentualEstoqueMinimoPage extends PageObject {

	@FindBy(css = "#btn-criar")
	private WebElement btnCriar;
	
	@FindBy(css = "input[ng-model='editarService.data.perc_minimo']")
	private WebElement valorPercentualMinimo;
	
	@FindBy(css = "#data-inicio")
	private WebElement dtInicio;
	
	@FindBy(css = "#data-fim")
	private WebElement dtFim;
	
	@FindBy(css = "#loja")
	private WebElement cd;
	
	@FindBy(css = "#loja ~ ul li a")
	private WebElement opcaoCD;
	
	@FindBy(css = "#ind-ativo")
	private WebElement ativo;
	
	@FindBy(xpath = "html/body/div[2]/div/form/div[5]/div/button")
	private WebElement btnSalvar;
	
	@FindBy(css = "#btn-pesquisar")
	private WebElement btnPesquisar;
	
	@FindBy(xpath = "html/body/div[2]/div/div[5]/table/tbody[1]/tr/td[12]/a[1]")
	private WebElement iconeEditar;
	
	@FindBy(xpath = "html/body/div[2]/div/div[5]/table/tbody[1]/tr/td[12]/a[2]")
	private WebElement iconeRemover;
	
	@FindBy(xpath = "html/body/div[5]/div/div/div[3]/button[1]")
	private WebElement btnSim;
	
	@FindBy(css = "#filtro-cd")
	private WebElement filtroCD;
	
	@FindBy(css = "#filtro-cd ~ ul li a")
	private WebElement opcaoFiltroCD;
	
	Utils utils;
	
	public PercentualEstoqueMinimoPage() {
		this.utils = new Utils();
	}
	
	public void clicarBtnCriar() {
		btnCriar.click();
	}
	
	public void valorPercentualMinimo(String percMinimo) {
		this.valorPercentualMinimo.sendKeys(percMinimo);
	}
	
	public void dataInicio(String dtInicio) {
		this.dtInicio.clear();
		this.dtInicio.sendKeys(dtInicio);
	}
	
	public void dataFim(String dtFim) {
		this.dtFim.clear();
		this.dtFim.sendKeys(dtFim);
	}
	
	public void selecaoCD(String cd) throws InterruptedException {
		//new Select(this.cd).selectByVisibleText(cd);
		utils.preencherCampoTypeAHead(cd , this.cd);
		Thread.sleep(1000);
		this.opcaoCD.click();
	}
	
	public void situacao(String ativo) {
		this.ativo.sendKeys(ativo);
	}
	
	public void clicarBtnSalvar() {
		this.btnSalvar.click();
	}
	
	public void validarMensagemSucesso() {
		Assert.assertTrue("Erro ao salvar percentual minimo", $(".modal-content .modal-body p").containsText("Percentual de estoque mínimo salvo com sucesso."));
	}
	
	public void clicarBtnPesquisar() {
		this.btnPesquisar.click();
	}
	
	public void clicarIconeEdicao() {
		iconeEditar.click();
	}
	
	public void clicarIconeRemover() {
		iconeRemover.click();
	}
	
	public void clicarBtnSimModal() {
		btnSim.click();
	}
	
	public void validarMensagemExclusao() {
		Assert.assertTrue("Erro ao excluir percentual minimo", $(".modal-content .modal-body p").containsText("Registro excluido com sucesso."));
	}
	
	public void filtroCD(String cd) throws InterruptedException {
		//filtroCD.sendKeys(cd);
		
		utils.preencherCampoTypeAHead(cd , this.filtroCD);
		Thread.sleep(1000);
		this.opcaoFiltroCD.click();
	}
}