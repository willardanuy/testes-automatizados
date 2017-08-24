package br.com.mv.steps;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import br.com.mv.pages.AberturaControleComissaoPage;
import br.com.mv.pages.ComissaoAnaliticoEspecialPage;
import br.com.mv.pages.ImpressaoPage;
import br.com.mv.pages.PopupControleComissaoPage;
import br.com.mv.pages.RelatorioComissaoPage;
import br.com.mv.pages.ToolbarPage;
import br.com.mv.utils.AguardaCarregamento;
import br.com.mv.utils.ControleJanela;
import net.thucydides.core.annotations.Steps;

public class RelatorioSteps {

	@Steps
	PopupControleComissaoPage popupControleComissao;
	RelatorioComissaoPage relatorioComissao;
	ImpressaoPage Impressao;
	
	ComissaoAnaliticoEspecialPage comissaoAnaliticoEspecial;
	AberturaControleComissaoPage aberturaControleComissao;
	
	ToolbarPage toolbar;
	ControleJanela janela;
	AguardaCarregamento aguardarCarregamento;
	
	@When("Eu clico no botao Referencia")
	public void euClicoBotaoReferencia() throws InterruptedException {
		aguardarCarregamento.aguardarCarregamentoArquiteturaAntiga();
		janela.abrirPopupClick(relatorioComissao.getBtnSearchReferencia());
	}
	
	@When("Eu informo o ano $anoReferencia da comissao")
	public void euInformoAnoComissao(String anoReferencia) throws InterruptedException {
		popupControleComissao.setAnoComissao(anoReferencia);
	}
	
	@When("Eu clico no botao pesquisar referencia")
	public void euInformoAnoComissao() throws InterruptedException {
		toolbar.clickPesquisar();
	}
	
	@When("Eu seleciono o mes da referencia")
	public void euSelecionoMesReferencia() throws InterruptedException {
		aguardarCarregamento.aguardarCarregamentoArquiteturaAntiga();
		popupControleComissao.selecionarMes();
	}
	
	@When("Eu informo o nro loja do relatorio de comissao analitico $codNroLoja")
	public void euInformoNroLojaRelatorioComissaoAnalitico(String codNroLoja) throws InterruptedException {
		relatorioComissao.setCodNroLoja(codNroLoja);
	}
	
	@When("Eu clico no botao imprimir relatorio de comissao analitico")
	public void euClicoBotaoImprimirRelatorioComissaoAnalitico() throws InterruptedException {
		janela.abrirPopupClick(relatorioComissao.getBtnImprimir(), true);
	}
	
	@Then("Eu valido o relatorio comissao analitico")
	public void euValidoRelatorioComissaoAnalitico() throws InterruptedException {
		relatorioComissao.validarRelatorio();
	}
	
	@When("Eu clico no botao pesquisar referencia do comissao analitico especial")
	public void euClicoBotaoPesquisarReferenciaComissaoAnaliticoEspecial() throws InterruptedException {
		comissaoAnaliticoEspecial.clickPesquisarReferencia();
	}
	
	@When("Eu informo a referencia $mesAno da comissao analitico especial")
	public void euInformoAnoComissaoAnaliticoEspecial(String mesAno) throws InterruptedException {
		Thread.sleep(3000);
		aberturaControleComissao.setMesAnoComissao(mesAno);
	}
	
	@When("Eu clico no botao pesquisar controle comissao analitico especial")
	public void euClicoBotaoPesquisarControleComissaoAnaliticoEspecial() throws InterruptedException {
		Thread.sleep(3000);
		aberturaControleComissao.clickBtnPesquisar();
	}
	
	@When("Eu seleciono o controle comissao analitico especial ano $ano mes $mes")
	public void euSelecionoControleComissaoAnaliticoEspecial(String ano, String mes) throws InterruptedException {
		aguardarCarregamento.aguardarCarregamentoNovaArquitetura();
		aberturaControleComissao.selecionarAnoMes(ano, mes);
	}
}