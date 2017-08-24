package br.com.mv.pages;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import br.com.mv.dao.PedidoDAO;
import br.com.mv.dao.PercentualPlusDAO;
import br.com.mv.utils.Utils;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.pages.PageObject;

import static br.com.mv.model.SessionVariables.NRO_PEDIDO;
import static br.com.mv.model.SessionVariables.COD_NRO_LOJA;
import static br.com.mv.model.SessionVariables.NRO_USUARIO;

public class PercentualPlusPage extends PageObject {
	
	@FindBy(css = "#btn-criar")
	private WebElement btnCriar;
	
	@FindBy(css = "#qtd_prod")
	private WebElement qtdProduto;
	
	@FindBy(css = "#qtd_serv")
	private WebElement qtdServico;
	
	@FindBy(css = "input[ng-model='percentualplus.lojaSelecionada']")
	private WebElement loja;
	
	@FindBy(css = "input[ng-model='percentualplus.lojaSelecionada'] ~ ul li a")
	private WebElement opcaoLoja;
	
	@FindBy(css = "input[ng-model='pesquisaPercentualPlusService.filtros.loja']")
	private WebElement pesquisaLoja;
	
	@FindBy(css = "input[ng-model='pesquisaPercentualPlusService.filtros.loja'] ~ ul li a")
	private WebElement pesquisaOpcaoLoja;
	
	@FindBy(xpath = ".//button[contains(text(), 'Gerar Tabela')]")
	private WebElement btnGerarTabela;
	
	@FindBy(xpath = ".//button[contains(text(), 'Salvar')]")
	private WebElement btnSalvar;
	
	@FindBy(css = "a[title='Excluir']")
	private WebElement btnExcluirTabela;
	
	@FindBy(css = "#btn-pesquisar")
	private WebElement btnPesquisar;

	@FindBy(xpath = "html/body/div[2]/div/div[5]/table/tbody/tr/td[1]/parent::tr/td[1]/a")
	private WebElement linkNumChave;
	
	Utils utils;
	
	public PercentualPlusPage() {
		this.utils = new Utils();
	}
	
	public void clicarBtnCriar() {
		btnCriar.click();
	}
	
	public void qtdProduto(String qtdProd) {
		qtdProduto.sendKeys(qtdProd);
	}
	
	public void qtdServico(String qtdServ) {
		qtdServico.sendKeys(qtdServ);
	}
	
	public PercentualPlusPage setQtdProd(String qtdProd) {
		this.qtdProduto.clear();
		this.qtdProduto.sendKeys(qtdProd);
		return this;
	}
	
	public PercentualPlusPage setQtdServ(String qtdServ) {
		this.qtdServico.clear();
		this.qtdServico.sendKeys(qtdServ);
		return this;
	}
	
	public PercentualPlusPage setLoja(String loja) throws InterruptedException {
		this.utils.preencherCampoTypeAHead(loja, this.loja);
		Thread.sleep(1000);
		this.opcaoLoja.click();
		return this;
	}
	
	public PercentualPlusPage setPesquisaLoja(String loja) throws InterruptedException {
		this.utils.preencherCampoTypeAHead(loja, this.pesquisaLoja);
		Thread.sleep(1000);
		this.pesquisaOpcaoLoja.click();
		return this;
	}
	
	public PercentualPlusPage clickPesquisar() {
		this.btnPesquisar.click();
		return this;
	}
	
	public PercentualPlusPage clickSalvar() {
		this.btnSalvar.click();
		return this;
	}
	
	public void clickExcluirTabela() {
		this.btnExcluirTabela.click();
		//return this;
	}
	
	public PercentualPlusPage clickGerarTabela() {
		this.btnGerarTabela.click();
		return this;
	}
	
	public PercentualPlusPage clickCriarMatrizPlus() {
		this.btnCriar.click();
		return this;
	}
	
	public PercentualPlusPage setTabelaPercentualPlus(double[][] tabelaPercentualProdutos, double[][] tabelaPercentualServicos, double[] tabelaPercentualPlus, int qtdProdutos, int qtdServicos) {
		
		// Percentual produtos
		int x = 3;
		for (int i = 0; i < tabelaPercentualProdutos.length; i++) {
			for (int j = 0; j < qtdProdutos; j++) {
				String val = Double.toString(tabelaPercentualProdutos[i][j]);
				
				WebElement campo = this.getDriver().findElement(By.xpath("//*[@id='form-percentualplus']/div/div[6]/table/tbody/tr[" + x + "]/td[1]/input["+ (j + 1) +"]"));
				if (campo.isEnabled()) {
					campo.sendKeys(val);
				}
			}
			
			x++;
		}
		
		// Percentual Servicos
		for (int i = 0; i < tabelaPercentualServicos.length; i++) {
			for (int j = 0; j < qtdServicos; j++) {
				String val = Double.toString(tabelaPercentualServicos[i][j]);
				
				WebElement campo = this.getDriver().findElement(By.xpath(".//*[@id='form-percentualplus']/div/div[6]/table/tbody/tr[2]/td["+ (i+1) +"]/input[" + (j+1) + "]"));
				if (campo.isEnabled()) {
					campo.sendKeys(val);
				}
			}
		}
		
		// Percentual plus
		x = 0;
		int qtdPercentuais = qtdProdutos * qtdServicos;
		for (int i = 3; i <= qtdPercentuais; i++) {
			for (int j = 2; j < qtdPercentuais; j++) {
				String val = Double.toString(tabelaPercentualPlus[x]);
				this.getDriver().findElement(By.xpath("//*[@id='form-percentualplus']/div/div[6]/table/tbody/tr[" + i + "]/td[" + j + "]/input")).sendKeys(val);
				x++;
			}
		}
		
		return this;
	}
	
	public void validarMensagemSucesso() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertTrue("Erro ao salvar tabela percentual", $(".alert").containsText("Registro salvo com sucesso!"));
	}
	
	public void clicarChavePercentualPlus() {
		linkNumChave.click();
	}
	
	public void confirmarExclusaoTabelaPercentual() throws InterruptedException {
		//Thread.sleep(1000);
		
		btnExcluirTabela.click();
		this.getDriver().switchTo().alert().accept();
		
		
		//this.waitFor(ExpectedConditions.alertIsPresent());
		//this.getDriver().switchTo().alert().accept();
	}
	
	public void validarMensagemSucessoExclusao() throws InterruptedException {
		//Thread.sleep(1000);
		Assert.assertTrue("Erro ao excluir tabela percentual", $(".alert").containsText("Registro excluido com sucesso!"));
	}
	
	public void validarValorPlusJuros() {
		
		String nroPedido = Serenity.sessionVariableCalled(NRO_PEDIDO);
		String codNroLoja = Serenity.sessionVariableCalled(COD_NRO_LOJA);
		String nroVendedor = Serenity.sessionVariableCalled(NRO_USUARIO);
		
		System.out.println("nroPedido: " + nroPedido + " codNroLoja: " + codNroLoja + " nroVendedor: "+ nroVendedor);
		
		PedidoDAO pedidoDAO = new PedidoDAO();
		double basePlusJuros = pedidoDAO.buscarValorBasePlusJuros(codNroLoja, nroPedido);
		
		double percentualPlusVendFinan = pedidoDAO.buscarPercentualPlusVendFinan(codNroLoja, nroVendedor);
		
		double plusJuros = (basePlusJuros * percentualPlusVendFinan) / 100;
		
		DecimalFormat decimal = new DecimalFormat("0.00");
		
		String vlrComissaoPlusJurosCalculada = decimal.format(plusJuros);
		
		System.out.println("PlusJuros: " + vlrComissaoPlusJurosCalculada);
		
		String vlrComissaoPlusJuros = $("#txt-comissao-plus-juros").getValue();

		System.out.println("ComissaoPlusJuros: " + vlrComissaoPlusJuros);
		
		Assert.assertTrue("O valor Plus juros estah incorreto. [" + vlrComissaoPlusJurosCalculada + " eh diferente de " + vlrComissaoPlusJuros + "]", vlrComissaoPlusJuros.equals(vlrComissaoPlusJurosCalculada));
	}
	
	public void validarMensagemMatrizExistente() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertTrue("Erro ao validar matriz jah existente", $(".alert").containsText("Existe uma matriz já cadastrada e vigente que conflita com o período informado."));
	}
	
	public void validarDadosPercentuaisNaBase() throws IOException {
		String numChave = linkNumChave.getText();
		
		PercentualPlusDAO percentualPlusDAO = new PercentualPlusDAO();
		int qtdPercentuais = percentualPlusDAO.buscarQtdeMatrizPercentuais(numChave);
		
		Assert.assertTrue("Erro ao validar dados percentuais na base. qtdPercentuais: " + qtdPercentuais, qtdPercentuais == 4);
	}
}