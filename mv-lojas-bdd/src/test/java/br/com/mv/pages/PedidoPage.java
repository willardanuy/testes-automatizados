package br.com.mv.pages;

import static br.com.mv.model.SessionVariables.NRO_PEDIDO;
import static br.com.mv.model.SessionVariables.COD_NRO_LOJA;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import br.com.mv.dao.PedidoDAO;
import br.com.mv.model.RelatorioAutomacao;
import br.com.mv.utils.AguardaCarregamento;
import br.com.mv.utils.Utils;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import net.thucydides.core.webdriver.Configuration;


public class PedidoPage extends PageObject {

	@FindBy(css = "#cbx_nro_tipo_venda_chosen")
	private WebElement tipoVendaChosen;
	
	@FindBy(css = "#cbx_plano_chosen")
	private WebElement cbxPlano;
	
	@FindBy(css = "#cbx_garantias_avulsas_chosen")
	private WebElement garantiasAvulsas;
	
	@FindBy(css = "#btn-insere-produto")
	private WebElement btnInsereProduto;
	
	@FindBy(css = "#cbx_garantias_empresa_chosen")
	private WebElement garantiasEmpresa;
	
	@FindBy(css = "#cbx_local_empenho_chosen")
	private WebElement localEmpenho;
	
	@FindBy(css = "#cbx_opcao_entrega_chosen")
	private WebElement opcaoEntrega;
	
	@FindBy(css = "#chx-ind-entrega")
	private WebElement flagEntrega;
	
	@FindBy(css = "#btn-empenhar-produto")
	private WebElement btnEmpenharProduto;
	
	@FindBy(css = ".modal.in .btn.Ok")
	private WebElement btnOkModal;
	
	@FindBy(css = ".modal.in .btn.Sim")
	private WebElement btnSimModal;
	
	@FindBy(css = "#tab-planilha")
	private WebElement abaPlanilha;
	
	@FindBy(css = "#btn-nova-planilha")
	private WebElement btnInsereFormaPagamento;
	
	@FindBy(css = "#btn-salvar-pedido")
	private WebElement btnSalvarPedido;
	
	@FindBy(css = "#btn-fechamento-total-pedido")
	private WebElement btnFechamentoTotalPedido;
	
	@FindBy(css = "#txt-pedido-venda")
	private WebElement txtPedidoVenda;
	
	@FindBy(css = "#cbx_documento_chosen")
	private WebElement cbxDocumentoChosen;
	
	@FindBy(css = "#btn-recibo-troca-planilha")
	private WebElement btnReciboTrocaPlanilha;
	
	@FindBy(css = "input[data-column='rec_nro_pedido']")
	private WebElement recNroPedido;
	
	@FindBy(css = "input[data-column='rec_cod_nro_loja']")
	private WebElement recCodNroLoja;
	
	@FindBy(css = "#btn-verificar-credito")
	private WebElement btnVerificarCredito;
	
	@FindBy(css = "#btn-salvar-recibo-troca")
	private WebElement btnSalvarReciboTroca;
	
	@FindBy(css = "#btn-credito-sgr")
	private WebElement btnCreditoEnterprise;
	
	@FindBy(css = "#nro_pedido_enterprise_sgr")
	private WebElement nroPedidoEnterprise;
	
	@FindBy(css = "#nro_loja_enterprise_sgr")
	private WebElement nroLojaEnterprise;
	
	@FindBy(css = "#cmb_empresa_enterprise_chosen")
	private WebElement cmbEmpresaEnterpriseChosen;
	
	@FindBy(css = "#btn-verificar-credito-sgr")
	private WebElement btnVerificarCreditoEnterprise;
	
	@FindBy(css = "#btn-salvar-credito-sgr")
	private WebElement btnSalvarCreditoEnterprise;
	
	@FindBy(css = "#btn-cancelar-pedido")
	private WebElement btnCancelarPedido;

	Utils utils;
	Configuration configuration;
	
	private String nroPedido; 
	
	public PedidoPage() {
		this.utils = new Utils();
	}
			
	public void clicarBotaoCancelarPedido() throws InterruptedException {
		btnCancelarPedido.click();
		clicarBtnSimModal();
		clicarBtnOkModal();
	}
	
	public void selecionarTipoVenda(String tipoVenda) throws InterruptedException {
		
		//System.out.println("url: " + configuration.getBaseUrl());
		//System.out.println("baseUrl: " + pages.getConfiguration().getBaseUrl());
		/*if (configuration.getBaseUrl().contains("100")) { // Na 101 não está apresentando o modal (VERIFICAR O MOTIVO)
			new AguardaCarregamento(this.getDriver()).aguardarCarregamentoNovaArquitetura();
		}*/
		
		Thread.sleep(3000);
		this.waitFor(ExpectedConditions.elementToBeClickable(tipoVendaChosen));
		utils.preencherCampoChosen(tipoVendaChosen, tipoVenda);
	}
	
	public void selecionarPlano(String plano) throws InterruptedException {
		Thread.sleep(1000);
		utils.preencherCampoChosen(cbxPlano, plano);
	}
	
	public void informarValorPrestacao(String vlrPrestacao) throws InterruptedException {
		Thread.sleep(1000);
		$("#txt-vr-prestacao").clear();
		Thread.sleep(1000);
		$("#txt-vr-prestacao").sendKeys(vlrPrestacao);
		Thread.sleep(1000);
	}
	
	public void clicarInsereProduto() throws InterruptedException {
		Thread.sleep(2000);
		new AguardaCarregamento(this.getDriver()).aguardarCarregamentoNovaArquitetura2();
		Thread.sleep(2000);
		new AguardaCarregamento(this.getDriver()).aguardarCarregamentoModalDlg();
		Thread.sleep(2000);
		btnInsereProduto.click();
		Thread.sleep(2000);
	}
	
	public void clicarIconeDetalhesProduto(String codNroProduto) throws InterruptedException {
		new AguardaCarregamento(this.getDriver()).aguardarCarregamentoNovaArquitetura2();
		$(".//*[@id='grd-produtos']/tbody/tr/td[contains(text(), '" + codNroProduto + "')]/parent::tr/td[1]/button[@title='Detalhes']").click();
	}
	
	public void informarLocalEmpenho(String descLocalEmpenho) throws InterruptedException {
		Thread.sleep(2000);
		new AguardaCarregamento(this.getDriver()).aguardarCarregamentoNovaArquitetura2();
		Thread.sleep(2000);
		utils.preencherCampoChosen(this.localEmpenho, descLocalEmpenho);
		Thread.sleep(1000);

	}
	
	
	public void informarOpcaoEntrega(String descOpcaoEntrega) throws InterruptedException {
		new AguardaCarregamento(this.getDriver()).aguardarCarregamentoNovaArquitetura2();
		
		// Utilizado quando se pesquisa por AGENDADA pois ao digitar efetuar a pesquisa o resultado aparecem dois registros 
		if (descOpcaoEntrega.equals("AGENDADA")) {
			this.opcaoEntrega.click();
			this.opcaoEntrega.findElement(By.cssSelector(".chosen-drop .chosen-search input")).clear();
			this.opcaoEntrega.findElement(By.cssSelector(".chosen-drop .chosen-search input")).sendKeys(descOpcaoEntrega);
			
			Thread.sleep(3000);
			
			$(".//*[@id='cbx_opcao_entrega_chosen']/div/ul/li[2]").click();
		} else {
			utils.preencherCampoChosen(this.opcaoEntrega, descOpcaoEntrega);
		}
	}
	
	public void informarFlagEntrega(String flagEntrega) throws InterruptedException {
		//new AguardaCarregamento(this.getDriver()).aguardarCarregamentoNovaArquitetura2();
		/*Thread.sleep(2000);
		String statusflagEntrega = this.flagEntrega.getAttribute("checked");
		
		System.out.println("Status Flag Entrega: " + statusflagEntrega);
		*/
		
		Thread.sleep(1000);
		String indFlagEntrega = "false";
		
		if (flagEntrega.equals("SIM")) {
			indFlagEntrega = "true";
		}
		
		System.out.println("Flag entrega: "+ indFlagEntrega);
		
		this.evaluateJavascript("$('#chx-ind-entrega').prop('checked', " + indFlagEntrega + ");$('#chx-ind-entrega').change().trigger('chosen:updated');$('#chx-ind-entrega').val();");
		
	}
	
	public void clicarBtnEmpenharProduto() throws InterruptedException {
		Thread.sleep(1000);
		btnEmpenharProduto.click();
		new AguardaCarregamento(this.getDriver()).aguardarCarregamentoNovaArquitetura2();
		Thread.sleep(3000);
	}
	
	public void clicarBtnOkModal() throws InterruptedException {
		new AguardaCarregamento(this.getDriver()).aguardarCarregamentoNovaArquitetura2();
		//new AguardaCarregamento(this.getDriver()).aguardarCarregamentoNovaArquitetura();
		Thread.sleep(5000);
		btnOkModal.click();
	}
	
	public void clicarBtnSimModal() throws InterruptedException {
		//new AguardaCarregamento(this.getDriver()).aguardarCarregamentoNovaArquitetura();
		Thread.sleep(2000);
		btnSimModal.click();
	}
	
	public void clicarNaAba(String descAba) throws InterruptedException {
		Thread.sleep(1000);
		//new AguardaCarregamento(this.getDriver()).aguardarCarregamentoNovaArquitetura();
		Thread.sleep(2000);
		$(".//*[@id='tab-itens-pedido']/*/a[contains(text(), '" + descAba + "')]").click();
	}
	
	public void clicarBtnInsereFormaPagamento() throws InterruptedException {
		new AguardaCarregamento(this.getDriver()).aguardarCarregamentoModal();
		this.btnInsereFormaPagamento.click();
	}
	
	public void informarTipoPagamento(String idLinha, String tipoFormaPagto) throws InterruptedException {
		$("#grd-planilha-pagto tr[id='" + idLinha + "'] select[data-column='flag_tipo_pagto_pedido']").selectByVisibleText(tipoFormaPagto);
	}
	
	public void informarFormaPagamento(String idLinha, String formaPagamento) throws InterruptedException {
		$("#grd-planilha-pagto tr[id='" + idLinha + "'] select[data-column='nro_forma_pagto']").selectByVisibleText(formaPagamento);
	}
	
	public void informarValorPagto(String indiceFormaPagto, String valorFormaPagto) throws InterruptedException {
		$("#grd-planilha-pagto tr[id='" + indiceFormaPagto + "'] select[data-column='vr_planilha']").sendKeys(valorFormaPagto);
	}
	
	public String getNumeroPedido() {
		String descNroPedido = this.txtPedidoVenda.getAttribute("value");
		//System.out.println("Número pedido1: " + nroPedido);
		String[] desc = descNroPedido.split("/", 2);
		//System.out.println("Número pedido2: " + nroPedido);
		
		return desc[0];
	}
	
	public void clicarBtnSalvarPedido() {
		// Salvar nro do pedido
		String nroPedido = this.getNumeroPedido();
		
		//System.out.println("Número pedido3: " + nroPedido);
		
		Serenity.setSessionVariable(NRO_PEDIDO).to(nroPedido.trim());
		//System.out.println("Número pedido: " + Serenity.sessionVariableCalled(NRO_PEDIDO));
		
		btnSalvarPedido.click();
	}
	
	public void clicarBtnFechamentoTotalPedido() throws InterruptedException {
		Thread.sleep(1000);
		
		System.out.println("Numero pedido: " + Serenity.sessionVariableCalled(NRO_PEDIDO));
		
		btnFechamentoTotalPedido.click();
		Thread.sleep(1000);
	}
	
	public void validarStatusPedido(String statusPedido) throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertTrue("O status do pedido está incorreto.", $("div[id^='mdl'].modal.in .modal-body").containsText(statusPedido));
	}
	
	public void removerTodosServicos() {
		// Remover todos os servicos
	}
	
	public void removerOServico(String nroServico) {
		$("button[id^=btn-excluir-servico-" + nroServico).click();
		new AguardaCarregamento(this.getDriver()).aguardarCarregamentoModal();
	}
	
	public void adicionarOServico(String nroServico) {
		$(".//*[@id='grid-consulta-servico']/*/tr/td[contains(text(), '" + nroServico + "')]/parent::tr/td[1]/input").click();
		$("div[id^=mdl-].modal.in .Selecionar").click();
	}
	
	public void clicarEmAdicionarServico() throws InterruptedException {
		Thread.sleep(2000);
		$("#btn-insere-servico").click();
		Thread.sleep(1000);
	}
	
	public void clicarNoBotaoAgendada() {
		$("#btn-buscar-data-entrega-agendada").click();
	}
	
	public void selecionarDataDisponivel() throws InterruptedException {
		new AguardaCarregamento(this.getDriver()).aguardarCarregamentoModal();
		new AguardaCarregamento(this.getDriver()).aguardarCarregamentoNovaArquitetura2();
		$("#grd-data-entrega tr[id='1']").click();
		$("#btn-escolher-data").click();
	}
	
	public void selecionarLojaDisponivel(String codNroLoja) throws InterruptedException {
		new AguardaCarregamento(this.getDriver()).aguardarCarregamentoModal();
		
		$(".//*[@id='grd-lojas-empenho']/*/tr/td[contains(text(), '" + codNroLoja + "')]/parent::tr/td[1]/input").click();
		$("#btn-escolher-loja-empenho").click();
		
		new AguardaCarregamento(this.getDriver()).aguardarCarregamentoNovaArquitetura2();
		Thread.sleep(2000);
	}
	
	public void selecionarALiberacao(String tipoLiberacao, String flagLiberacao, String codNroProduto) {
		$(".//*[@id='grd-liberacoes']/tbody/tr/td[contains(text(), '" + tipoLiberacao + "') or contains(text(), '" + flagLiberacao + "')]/parent::tr/td[contains(@title, '" + codNroProduto + "')]/parent::tr/td[1]/input").click();
	}
	
	public void clicarBotaoLiberar() {
		$("#btn-modal-liberar").click();
	}
	
	public void informarObservacao(String observacao) {
		$("#txt-obs-liberacao").sendKeys(observacao);
		$("#btn-liberar-liberacao").click();
	}
	
	public void informarUsuarioSenhaValidacaoLiberacao(String usuario, String senha) throws InterruptedException {
		new AguardaCarregamento(this.getDriver()).aguardarCarregamentoNovaArquitetura2();
		$("#modal-validacao-usuario #usuario").sendKeys(usuario);
		$("#modal-validacao-usuario #senha").sendKeys(senha);
		$("#modal-validacao-usuario .modal-validar-privilegio-ok").click();

		new AguardaCarregamento(this.getDriver()).aguardarCarregamentoModalDlg();
		new AguardaCarregamento(this.getDriver()).aguardarCarregamentoNovaArquitetura2();
//		new AguardaCarregamento(this.getDriver()).aguardarCarregamentoNovaArquitetura();
		Thread.sleep(1000);
	}
	
	public void informarDataRetencaoDisponivel() throws InterruptedException {
		System.out.println("Data retencao: " + this.utils.getDataAdd(10));
		Thread.sleep(3000);
		$("#txt-dt-retencao").sendKeys(this.utils.getDataAdd(10));
	}
	
	public void informarNumeroSerie(String nroSerie) throws InterruptedException {
		new AguardaCarregamento(this.getDriver()).aguardarCarregamentoNovaArquitetura2();
		Thread.sleep(2000);
		System.out.println("nro serie: " + nroSerie);
		$(".//*[@id='1_desc_info_adicional']").sendKeys(nroSerie);
	}
	
	public void removerGarantiaProduto(String nroGarantia, String codNroProduto) {
		Actions actions = new Actions(this.getDriver());
		
		WebElement btnExcluirGarantia = this.getDriver().findElement(By.xpath(".//*[@id='grd-garantias']/tbody/tr/td[contains(text(), '" + codNroProduto + "')]/following-sibling::td[contains(text(), '" + nroGarantia + "')]/parent::tr/td[1]/button"));
		actions.moveToElement(btnExcluirGarantia).build().perform();
		
		btnExcluirGarantia.click();
		
		//$(".//*[@id='grd-garantias']/tbody/tr/td[contains(text(), '" + codNroProduto + "')]/following-sibling::td[contains(text(), '" + nroGarantia + "')]/parent::tr/td[1]/button").click();
	}
	
	public void clicarBotaoAdicionarGarantia() {
		$("#btn-insere-garantia").click();
	}
	
	public void clicarNoProduto(String codNroProduto) throws InterruptedException {
		new AguardaCarregamento(this.getDriver()).aguardarCarregamentoModal();
		new AguardaCarregamento(this.getDriver()).aguardarCarregamentoNovaArquitetura2();
		Thread.sleep(1000);
		$(".//*[@id='grd-produtos']/*/tr/td[contains(text(), '" + codNroProduto + "')]").click();
	}
	
	public void selecionarGarantia(String nroGarantia) {
		$(".//*[@id='grd-inserir-garantia']/*/tr/td[contains(text(), '" + nroGarantia + "')]/parent::tr/td[1]/input").click();
		$("#btn-adicionar-garantia").click();
	}
	
	public void selecionarTabelaPorProduto(String descTabela, String codNroProduto) {
		$(".//*[@id='grd-produtos']/*/tr/td[contains(text(), '" + codNroProduto + "')]/following-sibling::td[6]/*/select").selectByVisibleText(descTabela);
	}
	
	public void informarDataTurnoDisponivel() throws InterruptedException {
		System.out.println("Data/turno disponivel: " + this.utils.getDataAdd(32));
		
		$("#txt-data-entrega-cliente").clear();
		$("#txt-data-entrega-cliente").sendKeys(this.utils.getDataAdd(32));
		$("#btn-validar-data").click();
		
		new AguardaCarregamento(this.getDriver()).aguardarCarregamentoModal();
		Thread.sleep(1000);
		$(".//*[@id='grd-data-entrega']/*/tr[@id='1']").click();
		$("#btn-escolher-data").click();
	}
	
	public void validarServicoAdicionado(String nroServico) {
		Assert.assertTrue("O serviço: " + nroServico + " não foi adicionado.", $(".//*[@id='grd-servicos']/*/tr[@id='" + nroServico + "']").isPresent());
	}
	
	public void informarValorFormaPagamento(String idLinha, String valorFormaPagamento) {
		$("#grd-planilha-pagto tr[id='" + idLinha + "'] input[data-column='vr_planilha']").clear();
		$("#grd-planilha-pagto tr[id='" + idLinha + "'] input[data-column='vr_planilha']").sendKeys(valorFormaPagamento);
	}
	
	public void infomarValorEntrada(String vlrEntrada) {
		$("#txt-entrada").clear();
		$("#txt-entrada").sendKeys(vlrEntrada);
	}
	
	public void clicarBotaoGerarFinanciamento() {
		$("#btn-gera-financiamento-planilha").click();
	}
	
	public void informarNumeroDocumento(String nroDocumento) {
		$("#mdl-gerar-financiamento input[data-column='nro_docto_pagto").sendKeys(nroDocumento);
		$("#btn-salvar-gerar-financiamento").click();
	}
	
	public void validoGarantiaPorProduto(String nroGarantia, String codNroProduto) {
		Assert.assertTrue("A garantia: " + nroGarantia + " não foi adicionada.", $(".//*[@id='grd-garantias']/tbody/tr/td[contains(text(), '" + codNroProduto + "')]/following-sibling::td[contains(text(), '" + nroGarantia + "')]").isPresent());
	}
	
	public void clicarBotaoAdicionarGarantiaAvulsa() {
		$("#btn-insere-garantia-avulsa").click();
	}
	
	public void informarNumeroPedidoAnterior() {
		// Pegar o numero do pedido salvo e informar aqui
		System.out.println("Número pedido anterior: " + Serenity.sessionVariableCalled(NRO_PEDIDO));
		
		String numPedido = (String) Serenity.sessionVariableCalled(NRO_PEDIDO);
		
		$(".//div[@id='dados-pedido-garantia']/div/*/input[@name='servico-garantia-avulso']").click(); // v2
		//$(".//div[@id='dados-pedido']/div/*/input[@name='servico-garantia-avulso']").click(); // v1
		$("#aba-venda-interna #tx-nro-pedido").sendKeys(numPedido);
	}
	
	public void informarNumeroLoja(String codNroLoja) {
		$("#aba-venda-interna #txt-ssf-loja-garantias-cod-nro-loja-key").sendKeys(codNroLoja);
	}
	
	public void informarNumeroProduto(String codNroProduto) {
		$("#aba-venda-interna #tx-nro-produto").sendKeys(codNroProduto);
		$(".//*[@id='aba-venda-interna']/div[7]/div/div/button[1]").click();
	}
	
	public void selecionarNotaRelacionadaProduto(String codNroProduto) {
		$(".//*[@id='grid-notas']/*/tr/td[contains(text(), '" + codNroProduto + "')]").click();
		$("div[id^='mdl-'].in .Selecionar").click();
	}
	
	public void selecionarUmaGarantiaAvulsa(String descGarantia) throws InterruptedException {
		Thread.sleep(1000);
		utils.preencherCampoChosen(garantiasAvulsas, descGarantia);
		Thread.sleep(1000);
	}
	
	public void clicarNoBotaoInserirGarantia() throws InterruptedException {
		Thread.sleep(1000);
		$("#btn-ins-garantia").click();
		Thread.sleep(1000);
	}
	
	public void informarNotaFiscalGarantiaExterna() throws InterruptedException{
		$("#aba-venda-externa #tx-nota-fiscal-externa").sendKeys("1111");
	}
	
	public void informarDataEmissaoNotaExterna() throws InterruptedException{
		$("#aba-venda-externa #tx-data-emissao-nf-externa").sendKeys(this.utils.getDataAdd(-1));
	}
	
	public void informarEmpresaNotaExterna(String descGarantia) throws InterruptedException{
		Thread.sleep(1000);
		utils.preencherCampoChosen(garantiasEmpresa, descGarantia);
		Thread.sleep(1000);
	}
	
	public void clicarNoIconePesquisarProduto() throws InterruptedException{
		$("#btn-sf-produto-garantia-avulsa-search").click();
		//$("#btn-sf-produto-search").click();
		Thread.sleep(1000);
	}
	
	public void informarCodigoPaiDoProduto(String codigoPai) throws InterruptedException{
		$("#mdl-sf-produto-garantia-avulsa input[data-sf-column='cod_nro_produto']").sendKeys(codigoPai);
		//$("#mdl-sf-produto input[data-sf-column='cod_nro_produto']").sendKeys(codigoPai);
	}
	
	public void clicarNoBotaoPesquisar() throws InterruptedException{
		$("//div[@id='gview_grid-sf-produto-garantia-avulsa']/div/span/button[2]").click();
		//$(".//*[@id='gview_grid-sf-produto']/div[1]/span/button[2]").click();
	}
	
	public void selecionarProdutoGarantiaExterna(String codNroProduto) throws InterruptedException{
		$("#mdl-sf-produto-garantia-avulsa input[data-row-id='1']").click();
		//$("#mdl-sf-produto input[data-row-id='1']").click();
		Thread.sleep(1000);
	}
	
	public void clicarNaGarantiaAvulsaNaGridVendaExterna() throws InterruptedException{
		$("#grid-garantias-avulsas td[title='TV PANASONIC 32 TC-32A400B LED HD']").click();
	}
	
	public void clicarNoBotaoParaRemoverGarantiaAvulsa()throws InterruptedException{
		$("#btn-rem-garantia").click();
	}
	
	public void consultarPedido() throws InterruptedException {
		Thread.sleep(1000);
		String numPedido = (String) Serenity.sessionVariableCalled(NRO_PEDIDO);
		Thread.sleep(1000);
		$("#txt-pedido").sendKeys(numPedido);
		Thread.sleep(1000);
		$("#btn-consultar-pedido").click();
		
		Thread.sleep(1000);
		$("td[title='" + numPedido + "'] button").click();
		Thread.sleep(1000);
	}
	
	public void reabrirPedido() throws InterruptedException {
		Thread.sleep(2000);
		new AguardaCarregamento(this.getDriver()).aguardarCarregamentoNovaArquitetura2();
		this.waitFor(ExpectedConditions.elementToBeClickable(By.cssSelector("#btn-reabertura-pedido")));
		$("#btn-reabertura-pedido").click();
		Thread.sleep(2000);
		this.clicarBtnSimModal();
		Thread.sleep(2000);
		this.clicarBtnOkModal();
		Thread.sleep(2000);
	}
	
	public void cancelarReserva() throws InterruptedException {
		new AguardaCarregamento(this.getDriver()).aguardarCarregamentoNovaArquitetura2();
		Thread.sleep(1000);
		$("#btn-cancelar-empenho-produto").click();
	}
	
	public void removerTodasFormasPagamento() {
		//
	}
	
	public void removerFormaPagamento() {
		
		$(".btn-excluir-planilha").click();
	}
	
	public void alterarQuantidadeServico(String codNroServico, String quantidade) {
		$(".//*[@id='" + codNroServico + "_qtde_servico']").clear();
		$(".//*[@id='" + codNroServico + "_qtde_servico']").sendKeys(quantidade);
	}
	
	public void alterarOValorUnitarioServico(String codNroServico, String vlrUnitario) {
		$(".//*[@id='" + codNroServico + "_vr_unitario_servico']").sendKeys(vlrUnitario);
	}
	
	public void removerPlanilhas() throws InterruptedException {
		while ($(".btn-excluir-planilha").isPresent()) {
			$(".btn-excluir-planilha").click();
		}
	}
	
	public void clicarBotaoCMC7() {
		$("#btn-cmc7-planilha").click();
	}
	
	public void informarCMC7(String cmc7) {
		$("#txt-cmc7").clear();
		$("#txt-cmc7").sendKeys(cmc7);
	}
	
	public void clicarBotaoValidarCMC7() {
		$("#btn-validar-cmc7").click();
	}
	
	public void informarDtAberturaContaCMC7(String dtAberturaConta) {
		$("#frm-cheque input[data-column='dt_conta']").sendKeys(dtAberturaConta);
	}
	
	public void clicarBotaoSalvarCheque() {
		$("#btn-salvar-cheque").click();
	}
	
	public void removerProduto(String codNroProduto) throws InterruptedException {
		new AguardaCarregamento(this.getDriver()).aguardarCarregamentoNovaArquitetura2();
		$(".//*[@id='grd-produtos']/tbody/tr/td[contains(text(), '" + codNroProduto + "')]/parent::tr/td[1]/button[@title='Excluir']").click();
	}
	
	public void executarScriptReset(String nomScript) throws IOException {
		 new PedidoDAO().executarScriptReset(nomScript);
	}
	
	public void clicarBotaoImprimirDocumentos() throws InterruptedException {
		Thread.sleep(2000);
		$("#btn-imprimir-documentos").click();
	}
	
	public void selecionarDocumento(String nomDocumento) throws InterruptedException {
		Thread.sleep(2000);
		utils.preencherCampoChosen(this.cbxDocumentoChosen, nomDocumento);
	}
	
	public void clicarBotaoGerarRelatorio() {
		$("#btn-modal-imprimir").click();
	}
	
	public void validarTermoAdesaoAntivirusHero() {
		
	}
	
	public void validarTermoAdesaoPassaporte() {
		
	}
	
	public void salvarPedidoRelatorio(String codTeste) throws IOException {
		
		Boolean gravarPedidoRelatorio = Boolean.parseBoolean(SystemEnvironmentVariables.createEnvironmentVariables().getProperty("mvlojas.gravar.pedido.relatorio"));
		
		if (gravarPedidoRelatorio) {
			new RelatorioAutomacao().salvarPedidoRelatorio(codTeste, Serenity.sessionVariableCalled(NRO_PEDIDO));
		}
	}
	
	public void clicarBtnReciboTrocaPlanilha() {
		btnReciboTrocaPlanilha.click();
	}
	
	public void informarPedidoComCredito() {
		recNroPedido.clear();
		recNroPedido.sendKeys(Serenity.sessionVariableCalled(NRO_PEDIDO));
	}
	
	public void informarLojaPedidoComCredito() {
		recCodNroLoja.clear();
		recCodNroLoja.sendKeys(Serenity.sessionVariableCalled(COD_NRO_LOJA));
	}
	
	public void clicarBtnVerificarCredito() {
		btnVerificarCredito.click();
	}
	
	public void clicarBtnSalvarReciboTroca() {
		btnSalvarReciboTroca.click();
	}
	
	public void clicarBtnCreditoEnterprise() {
		btnCreditoEnterprise.click();
	}
	
	public void informarPedidoComCreditoEnterprise(String nroPedido) {
		nroPedidoEnterprise.clear();
		nroPedidoEnterprise.sendKeys(nroPedido);
	}
	
	public void informarLojaPedidoComCreditoEnterprise(String nroLojaPedido) {
		nroLojaEnterprise.clear();
		nroLojaEnterprise.sendKeys(nroLojaPedido);
	}
	
	public void selecionarEmpresaCreditoEnterprise(String nomEmpresa) throws InterruptedException {
		Thread.sleep(2000);
		utils.preencherCampoChosen(this.cmbEmpresaEnterpriseChosen, nomEmpresa);
	}
	
	public void clicarBtnVerificarCreditoEnterprise() {
		btnVerificarCreditoEnterprise.click();
	}
	
	public void clicarBtnUtilizarCreditoEnterprise() {
		btnSalvarCreditoEnterprise.click();
	}
	
	public void clicarBtnOkModalCreditoEnterprise() throws InterruptedException {
		Thread.sleep(3000);
		btnOkModal.click();
	}
	
}