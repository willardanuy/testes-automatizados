package br.com.mv.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.mv.utils.AguardaCarregamento;
import br.com.mv.utils.Utils;
import net.thucydides.core.pages.PageObject;

public class ConsultaProdutoModal extends PageObject {

	@FindBy(css = "#body-consulta-produto input[data-column='cod_nro_produto']")
	private WebElement codNroProduto;
	
	@FindBy(css = "#body-consulta-produto input[data-column='cod_cor_produto']")
	private WebElement codCorProduto;
	
	@FindBy(css = "#body-consulta-produto input[data-column='cod_tipo_voltagem']")
	private WebElement codTipoVoltagem;
	
	@FindBy(css = "#btn-prod-pesq-prod")
	private WebElement btnProdPesqProd;
	
	@FindBy(xpath = "//div[contains(@class, 'mdl-consulta_produtos')]/div/div/div[3]/button[1]")
	private WebElement btnSelecionar;
	
	Utils utils;
			
	public ConsultaProdutoModal() {
		utils = new Utils();
	}
			
	public void pesquisarProduto(String codNroProduto) throws InterruptedException {
		Thread.sleep(2000);
		new AguardaCarregamento(this.getDriver()).aguardarCarregamentoModal();
		Thread.sleep(2000);
		new AguardaCarregamento(this.getDriver()).aguardarCarregamentoNovaArquitetura2();
		Thread.sleep(2000);
		
		if (codNroProduto.contains(".")) { // Ex:. 201791.4.0
			String[] codigosProduto = codNroProduto.split("\\.");
			this.codNroProduto.sendKeys(codigosProduto[0].trim());
			this.codCorProduto.sendKeys(codigosProduto[1].trim());
			this.codTipoVoltagem.sendKeys(codigosProduto[2].trim());
			
		} else {
			this.codNroProduto.sendKeys(codNroProduto);
		}
		Thread.sleep(1000);
		new AguardaCarregamento(this.getDriver()).aguardarCarregamentoModalDlg();
		Thread.sleep(1000);
		this.btnProdPesqProd.click();
		Thread.sleep(1000);
		checarProdutoEncontrado(codNroProduto);
	}
	
	public void checarProdutoEncontrado(String codNroProduto) throws InterruptedException {
		Thread.sleep(2000);
		$("//td[contains(text(), '" + codNroProduto + "')]/parent::tr/td[1]/input").click();
	}
	
	public void clickSelecionar() throws InterruptedException {
		Thread.sleep(2000);
		this.btnSelecionar.click();
		Thread.sleep(2000);
	}
	
	public void clicarBotaoKit() {
		$("#btn-prod-pesq-kit").click();
	}
	
	public void selecionarOpcaoKitVendaAvulsa() throws InterruptedException {
		Thread.sleep(2000);
		$(".//*[@id='grid-consulta-kit']/*/tr/td[@title=' VENDA AVULSA']/parent::tr/td[1]/input").click();
		$(".//div[not(@class='modal mdl-consulta_produtos in')]/div/div/div[3]/button[@class='btn btn-white btn-sm Selecionar mv-btn-bind']").click();
	}
	
	public void selecionarKit(String nroKit) throws InterruptedException {
		Thread.sleep(2000);
		new AguardaCarregamento(this.getDriver()).aguardarCarregamentoNovaArquitetura2();
		$(".//*[@id='grid-consulta-kit']/*/tr/td[contains(text(), '" + nroKit + "')]/parent::tr/td[1]/input").click();
		$(".//div[not(@class='modal mdl-consulta_produtos in')]/div/div/div[3]/button[@class='btn btn-white btn-sm Selecionar mv-btn-bind']").click();
	}
}
