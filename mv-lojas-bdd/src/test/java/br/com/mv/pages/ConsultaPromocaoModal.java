package br.com.mv.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.mv.utils.AguardaCarregamento;
import br.com.mv.utils.Utils;
import net.thucydides.core.pages.PageObject;

public class ConsultaPromocaoModal extends PageObject {

	@FindBy(css = "input[data-column='cod_nro_produto']")
	private WebElement codNroProduto;
	
	@FindBy(css = "#btn-prod-pesq-prod")
	private WebElement btnProdPesqProd;
	
	@FindBy(xpath = "//div[contains(@class, 'mdl-consulta_produtos')]/div/div/div[3]/button[1]")
	private WebElement btnSelecionar;
	
	@FindBy(css = "#grid-consulta-promocao input[data-id='1'].radio-seleciona-promocao")
	private WebElement selecionaPromocao;
	
	@FindBy(css = ".btn.Ok")
	private WebElement btnOk;
	
	@FindBy(css = ".btn.Sim")
	private WebElement btnSim;
	
	Utils utils;
			
	public ConsultaPromocaoModal() {
		utils = new Utils();
	}
			
	public ConsultaPromocaoModal setPromocao() {
		this.selecionaPromocao.click();
		return this;
	}
	
	public ConsultaPromocaoModal clickSelecionar() {
		this.btnSelecionar.click();
		return this;
	}
	
	public ConsultaPromocaoModal deixarProdutoSemPromocao() throws InterruptedException {
		new AguardaCarregamento(this.getDriver()).aguardarCarregamentoNovaArquitetura2();
		Thread.sleep(1000);
		this.btnOk.click();
		Thread.sleep(1000);
		this.btnSim.click();
		return this;
	}
	
	public void selecionarPromocao(String valorPromocao) throws InterruptedException {
		$(".//*[@id='grid-consulta-promocao']/*/tr/td[contains(text(), '" + valorPromocao + "')]/parent::tr/td[1]/input").click();
		new AguardaCarregamento(this.getDriver()).aguardarCarregamentoNovaArquitetura2();
		this.btnOk.click();
	}
}
