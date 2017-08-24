package br.com.mv.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.support.ui.ExpectedConditions;

import br.com.mv.pages.EmissaoNotaFiscalAvulsaPage;
import br.com.mv.pages.PopupAprovacaoProdutoTrocaDevolucaoPage;
import br.com.mv.pages.PopupAprovacaoServicoTrocaDevolucaoPage;
import br.com.mv.pages.PopupCadastroSolicitacaoTDPage;
import br.com.mv.pages.PopupConsultaNotaFiscalPage;
import br.com.mv.pages.PopupMensagensPage;
import br.com.mv.pages.PopupObsAprovReprovPage;
import br.com.mv.pages.PopupObservacaoDevolucaoItemPage;
import br.com.mv.pages.PopupParametrosPage;
import br.com.mv.pages.PopupPreReciboPage;
import br.com.mv.pages.PopupSolicitacaoAprovacaoServicoPage;
import br.com.mv.pages.PopupTiposNotaFiscalAvulsaPage;
import br.com.mv.pages.PopupVinculoMotivoProdutoTDPage;
import br.com.mv.pages.PreReciboTrocaDevolucaoPage;
import br.com.mv.pages.ToolbarPage;
import br.com.mv.utils.AguardaCarregamento;
import br.com.mv.utils.ControleJanela;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

import static br.com.mv.model.SessionVariables.NRO_NF_AVULSA;

public class PreReciboTrocaDevolucaoSteps {

	@Steps
	PreReciboTrocaDevolucaoPage pesquisaPreRecibo;
	PopupPreReciboPage preRecibo;
	PopupCadastroSolicitacaoTDPage cadastroSolicitacao;
	PopupVinculoMotivoProdutoTDPage vinculoMotivo;
	PopupSolicitacaoAprovacaoServicoPage solicitacaoAprovacao;
	
	PopupAprovacaoProdutoTrocaDevolucaoPage aprovacaoProduto;
	PopupAprovacaoServicoTrocaDevolucaoPage aprovacaoServico;
	PopupObsAprovReprovPage obsAprovacao;
	
	EmissaoNotaFiscalAvulsaPage nfAvulsa;
	PopupTiposNotaFiscalAvulsaPage tiposNFAvulsa;
	PopupParametrosPage parametros;
	
	PopupConsultaNotaFiscalPage consultaNotaFiscal;
	PopupObservacaoDevolucaoItemPage obsDevolucaoItem;
	
	ToolbarPage toolbar;
	ControleJanela janela;
	PopupMensagensPage msg;
	AguardaCarregamento aguardarCarregamento;
	
	/**
	 * Clica no botao Novo pré-recibo
	 * 
	 * @throws InterruptedException
	 */
	@When("Eu clico no botao novo Pré-recibo")
	public void euClicoNoBotaoNovoPreRecibo() throws InterruptedException {
		aguardarCarregamento.aguardarCarregamentoArquiteturaAntiga();
		janela.abrirPopupClick(toolbar.getBtnNovo());
	}
	
	/**
	 * Informa o numero do pedido para criar o pré-recibo
	 * 
	 * @throws InterruptedException
	 */
	@When("Eu informo o numero do pedido")
	public void euInformoNumeroPedido() throws InterruptedException {
		preRecibo.informarNumeroPedido();
	}
	
	/**
	 * Informa o numero do pedido para criar o pré-recibo
	 * 
	 * @param nomEmpresa
	 * @throws InterruptedException
	 */
	@When("Eu seleciono a empresa $nomEmpresa")
	public void euSelecionoEmpresa(String nomEmpresa) throws InterruptedException {
		preRecibo.setEmpresa(nomEmpresa);
	}
	
	/**
	 * Informa o numero da loja
	 * 
	 * @param codNroLoja
	 * @throws InterruptedException
	 */
	@When("Eu informo a loja $codNroLoja")
	public void euInformoCodigoLoja(String codNroLoja) throws InterruptedException {
		preRecibo.setCodNroLoja(codNroLoja);
	}
	
	/**
	 * Informa o numero da loja
	 * 
	 * @param nomProcesso
	 * @throws InterruptedException
	 */
	@When("Eu seleciono o processo $nomProcesso")
	public void euSelecionoProceso(String nomProcesso) throws InterruptedException {
		preRecibo.setProcesso(nomProcesso);
	}
	
	/**
	 * Clica no botao pesquisar pedido
	 * 
	 * @throws InterruptedException
	 */
	@When("Eu clico no botao pesquisar")
	public void euClicoNoBotaoPesquisar() throws InterruptedException {
		toolbar.clickPesquisar();
	}
	
	/**
	 * Clica no botao ok da tela de pre-recibo
	 * 
	 * @throws InterruptedException
	 */
	@When("Eu clico no botao Ok da tela de pre-recibo")
	public void euClicoNoBotaoOkTelaPreRecibo() throws InterruptedException {
		janela.abrirPopupClick(preRecibo.getBtnOk());
	}
	
	/**
	 * Clica no botao ok da tela de pre-recibo
	 * 
	 * @throws InterruptedException
	 */
	@When("Eu seleciono o produto item $idItem")
	public void euSelecionoProdutoItem(String idItem) throws InterruptedException {
		cadastroSolicitacao.selecionarProduto(idItem);
	}
	
	/**
	 * Clica no botao Motivo Produto
	 * 
	 * @throws InterruptedException
	 */
	@When("Eu clico no botao Motivo Produto")
	public void euClicoNoBotaoMotivoProduto() throws InterruptedException {
		janela.abrirPopupClick(cadastroSolicitacao.getBtnMotivoProduto());
	}
	
	/**
	 * Informa o motivo para o produto selecionado
	 * 
	 * @throws InterruptedException
	 */
	@When("Eu informo o motivo $nomMotivo para o produto selecionado")
	public void euInformoMotivoProdutoSelecionado(String nomMotivo) throws InterruptedException {
		vinculoMotivo.setMotivo(nomMotivo);
	}
	
	/**
	 * Informa o motivo para o produto selecionado
	 * 
	 * @throws InterruptedException
	 */
	@When("Eu informo uma observacao $observacao para o produto selecionado")
	public void euInformoUmaObservacao(String observacao) throws InterruptedException {
		vinculoMotivo.setObservacao(observacao);
	}
	
	/**
	 * Clica no botao Concluir
	 * 
	 * @throws InterruptedException
	 */
	@When("Eu clico no botao Concluir vinculo motivo")
	public void euClicoNoBotaoConcluirVinculoMotivo() throws InterruptedException {
		janela.fecharJanela(vinculoMotivo.getBtnConcluir());
	}
	
	/**
	 * Clica no botao Salvar solicitacao
	 * 
	 * @throws InterruptedException
	 */
	@When("Eu clico no botao Salvar solicitacao")
	public void euClicoNoBotaoSalvarVinculoMotivo() throws InterruptedException {
		cadastroSolicitacao.clickBtnSalvar();
		
		janela.voltarJanelaPrincipal();
	}
	
	/**
	 * Clica no botao Salvar solicitacao
	 * 
	 * @throws InterruptedException
	 */
	@When("Eu seleciono o servico item $descItem")
	public void euClicoNoBotaoSalvarVinculoMotivo(String descItem) throws InterruptedException {
		cadastroSolicitacao.selecionarServico(descItem);
	}
	
	/**
	 * Clica no botao Salvar solicitacao
	 * 
	 * @throws InterruptedException
	 */
	@When("Eu clico no botao Motivo Servico")
	public void euClicoNoBotaoMotivoServico() throws InterruptedException {
		janela.abrirPopupClick(cadastroSolicitacao.getBtnMotivoServico());
	}
	
	/**
	 * Informa o motivo para o servico selecionado
	 * 
	 * @throws InterruptedException
	 */
	@When("Eu informo uma observacao $observacao para o servico selecionado")
	public void euInformoUmaObservacaoServico(String observacao) throws InterruptedException {
		vinculoMotivo.setObservacao(observacao);
	}
	
	/**
	 * Informa o motivo para o serviço selecionado
	 * 
	 * @throws InterruptedException
	 */
	@When("Eu informo o motivo $nomMotivo para o servico selecionado")
	public void euClicoNoBotaoMotivoServico(String nomMotivo) throws InterruptedException {
		solicitacaoAprovacao.setMotivo(nomMotivo);
	}
	
	/**
	 * Clica no botao Concluir na aprovacao de servico
	 * 
	 * @throws InterruptedException
	 */
	@When("Eu clico no botao Concluir aprovacao de servico")
	public void euClicoNoBotaoConcluirAprovacaoServico() throws InterruptedException {
		
		solicitacaoAprovacao.clickBtnConcluir();
		janela.voltarJanelaPrincipal();
		//janela.fecharJanela(solicitacaoAprovacao.getBtnConcluir());
	}
	
	/**
	 * Clica no botao Concluir solicitacao aprovacao
	 * 
	 * @throws InterruptedException
	 */
	@When("Eu clico OK no alert para Concluir solicitacao aprovacao")
	public void euClicoOkAlertConcluirAprovacaoServico() throws InterruptedException {
		
		cadastroSolicitacao.clickBtnSalvar();
		
		//janela.voltarJanelaPrincipal(true);
		
		//janela.fecharJanela(solicitacaoAprovacao.getBtnConcluir());
	}
	
	/**
	 * Informa o motivo para o serviço selecionado
	 * 
	 * @throws InterruptedException
	 */
	@When("Eu seleciono o status $statusPreRecibo do pre-recibo")
	public void euSelecionoStatusPreRecibo(String statusPreRecibo) throws InterruptedException {
		pesquisaPreRecibo.setCbxStatus(statusPreRecibo);
	}
	
	/**
	 * Pesquisa o pre-recibo
	 * 
	 * @throws InterruptedException
	 */
	@When("Eu pesquiso o pre-recibo")
	public void euPesquisoPreRecibo() throws InterruptedException {
		pesquisaPreRecibo.informarNroPreRecibo();
	}
	
	/**
	 * Seleciona o pre-recibo pesquisado
	 * 
	 * @throws InterruptedException
	 */
	@When("Eu seleciono o pre-recibo")
	public void euSelecionoPreRecibo() throws InterruptedException {
		pesquisaPreRecibo.selecionarPreRecibo();
	}
	
	/**
	 * Clica em no botao editar o pre-recibo pesquisado
	 * 
	 * @throws InterruptedException
	 */
	@When("Eu clico no botao Editar pre-recibo")
	public void euClicoBotaoEditarPreRecibo() throws InterruptedException {
		janela.abrirPopupClick(toolbar.getBtnEditar());
	}
	
	/**
	 * Clica em no botao editar o pre-recibo pesquisado
	 * 
	 * @throws InterruptedException
	 */
	@When("Eu seleciono produto $nroProduto pendente aprovacao")
	public void euSelecionoProdutoParaAprovacao(String nroProduto) throws InterruptedException {
		preRecibo.selecionarProdutoTD(nroProduto);
	}
	
	/**
	 * Clica em botao Fluxo Aprovacao
	 * 
	 * @throws InterruptedException
	 */
	@When("Eu clico no botao Fluxo Aprovacao de produto")
	public void euClicoBotaoFluxoAprovacaoProduto() throws InterruptedException {
		janela.abrirPopupClick(preRecibo.getBtnFluxoAprovacaoProduto());
	}
	
	/**
	 * Clica em botao Fluxo Aprovacao
	 * 
	 * @throws InterruptedException
	 */
	@When("Eu seleciono a Etapa $descEtapa pendente aprovacao")
	public void euSelecionoEtapaPendenteAprovacao(String descEtapa) throws InterruptedException {
		aprovacaoProduto.selecionarAprovacaoPendente(descEtapa);
	}
	
	/**
	 * Clica em botao Fluxo Aprovacao
	 * 
	 * @throws InterruptedException
	 */
	@When("Eu informo uma observacao para a Etapa $descEtapa")
	public void euInformoObservacaoEtapa(String descEtapa) throws InterruptedException {
		janela.abrirPopupClick(aprovacaoProduto.getBtnObservacao(descEtapa));
		obsAprovacao.setObservacao("Aprovação " + descEtapa);
		
		janela.fecharJanela(obsAprovacao.getBtnOk());
	}
	
	/**
	 * Clica em botao Fluxo Aprovacao
	 * 
	 * @throws InterruptedException
	 */
	@When("Eu clico no botao Aprovar produto")
	public void euClicoNoBotaoAprovarProduto() throws InterruptedException {
		
		aprovacaoProduto.clickBtnAprovar();
		
		janela.voltarJanelaPrincipal();
	}
	
	/**
	 * Clica em no botao editar o pre-recibo pesquisado
	 * 
	 * @throws InterruptedException
	 */
	@When("Eu seleciono servico $nroServico pendente aprovacao")
	public void euSelecionoServicoParaAprovacao(String nroServico) throws InterruptedException {
		preRecibo.selecionarServicoTD(nroServico);
	}
	
	/**
	 * Clica em botao Fluxo Aprovacao de servico
	 * 
	 * @throws InterruptedException
	 */
	@When("Eu clico no botao Fluxo Aprovacao de servico")
	public void euClicoBotaoFluxoAprovacaoServico() throws InterruptedException {
		janela.abrirPopupClick(preRecibo.getBtnFluxoAprovacaoServico());
	}
	
	/**
	 * Informa uma observacao para a aprovacao do servico
	 * 
	 * @throws InterruptedException
	 */
	@When("Eu informo uma observacao para aprovar o servico")
	public void euInformoObservacaoAprovarServico() throws InterruptedException {
		aprovacaoServico.setObsAprovacaoReprovacao("Aprovação de serviço");
	}
	
	/**
	 * Clica no botao Aprovar servico
	 * 
	 * @throws InterruptedException
	 */
	@When("Eu clico no botao Aprovar servico")
	public void euClicoBotaoAprovarServico() throws InterruptedException {
		//janela.fecharJanela(aprovacaoServico.getBtnAprovar());
		
		aprovacaoServico.clickBtnAprovar();
		janela.voltarJanelaPrincipal();
	}
	
	/**
	 * Clica no botao Aprovar servico
	 * 
	 * @throws InterruptedException
	 */
	@When("Eu clico no botao Ok para concluir pre-recibo")
	public void euClicoBotaoOkTelaPreRecibo() throws InterruptedException {
		janela.fecharJanela(solicitacaoAprovacao.getBtnConcluir());
	}
	
	/**
	 * Clica no botao Pesquisar pre-recibo
	 * 
	 * @throws InterruptedException
	 */
	@When("Eu clico no botao Pesquisar pre-recibo")
	public void euClicoBotaoPesquisarPreRecibo() throws InterruptedException {
		toolbar.clickPesquisar();
	}
	
	/**
	 * Seleciona a operacao de Entrada da nota fiscal
	 * 
	 * @throws InterruptedException
	 */
	@When("Eu seleciono a operacao de $tipoOperacao da nota fiscal")
	public void euSelecionoOperacaoNotaFiscal(String tipoOperacao) throws InterruptedException {
		janela.abrirPopupSelect(nfAvulsa.getOperacaoNF(), "Entrada");
	}
	
	/**
	 * Seleciona a operacao de Entrada da nota fiscal
	 * 
	 * @throws InterruptedException
	 */
	@When("Eu seleciono o tipo de nota fiscal $tipoNF")
	public void euSelecionoTipoNotaFiscal(String tipoNF) throws InterruptedException {
		tiposNFAvulsa.selecionarTipoNotaFiscal(tipoNF);
	}
	
	/**
	 * Seleciona a grupo de estoque origem
	 * 
	 * @throws InterruptedException
	 */
	@When("Eu seleciono o grupo de estoque origem $grupoEstoqueOrigem")
	public void euSelecionoGrupoEstoqueOrigem(String grupoEstoqueOrigem) throws InterruptedException {
		nfAvulsa.setGrupoEstoqueOrigem(grupoEstoqueOrigem);
	}
	
	/**
	 * Clica no botao informar parametros
	 * 
	 * @throws InterruptedException
	 */
	@When("Eu clico no botao Informar Parametros")
	public void euClicoBotaoInformarParametros() throws InterruptedException {
		janela.abrirPopupClick(nfAvulsa.getBtnInformarParametros());
	}
	
	/**
	 * Informa o numero do cupom fiscal
	 * 
	 * @throws InterruptedException
	 */
	@When("Eu informo o numero da nota tipo $tipoNF")
	public void euInformoNumeroCupomFiscal(String tipoNF) throws InterruptedException {
		parametros.setNroCumpomFiscal(tipoNF);
	}
	
	/**
	 * Informa a empresa do cupom fiscal
	 * 
	 * @throws InterruptedException
	 */
	@When("Eu informo a empresa da nota tipo $tipoNF")
	public void euInformoEmpresaCupomFiscal(String tipoNF) throws InterruptedException {
		parametros.setEmpresaCupomFiscal(tipoNF);
	}
	
	/**
	 * Informa o codigo loja do cupom fiscal
	 * 
	 * @throws InterruptedException
	 */
	@When("Eu informo o codigo loja da nota tipo $tipoNF")
	public void euInformoCodigoLojaCupomFiscal(String tipoNF) throws InterruptedException {
		parametros.setCodNroLojaCupomFiscal(tipoNF);
	}
	
	/**
	 * Informa o numero da serie do cupom fiscal
	 * 
	 * @throws InterruptedException
	 */
	@When("Eu informo o numero da serie da nota tipo $tipoNF")
	public void euInformoNumeroSerieCupomFiscal(String tipoNF) throws InterruptedException {
		parametros.setNroSerieCF(tipoNF);
	}
	
	/**
	 * Clica no botao Pesquisar cupom fiscal
	 * 
	 * @throws InterruptedException
	 */
	@When("Eu clico no botao Pesquisar nota fiscal tipo $tipoNF")
	public void euClicoBotaoPesquisarCupomFiscal(String tipoNF) throws InterruptedException {
		parametros.clickBtnSearchBuscarCupomFiscal(tipoNF);
	}
	
	/**
	 * Seleciona o cupom fiscal
	 * 
	 * @throws InterruptedException
	 */
	@When("Eu seleciono o cupom fiscal")
	public void euSelecionoCupomFiscal() throws InterruptedException {
		parametros.selecionarNFCF();
	}
	
	/**
	 * Clica no botao concluir parametros
	 * 
	 * @throws InterruptedException
	 */
	@When("Eu clico no botao Concluir parametros")
	public void euClicoBotaoConcluirParametros() throws InterruptedException {
		janela.fecharJanela(parametros.getBtnConcluir());
	}
	
	/**
	 * Seleciona o cupom fiscal
	 * 
	 * @throws InterruptedException
	 */
	@When("Eu clico no botao Concluir emissao nf avulsa tipo $tipoNFAvulsa")
	public void euClicoBotaoConcluirEmissaoNFAvulsa(String tipoNFAvulsa) throws InterruptedException {
		nfAvulsa.clickAbaItens().setObsItemNF("Teste");
		nfAvulsa.clickBtnConcluir();
		
		// Deseja concluir?
		janela.abrirPopupAlert(true);
		msg.clickBtnFechar();
		
		// Deseja realizar impressão NFE?
		janela.voltarJanelaPrincipal(false);
		
		nfAvulsa.setNroNotaSessao(tipoNFAvulsa);
	}
	
	/**
	 * Clica no botao pesquisar controle de devolucao
	 * 
	 * @throws InterruptedException
	 */
	@When("Eu clico no botao Pesquisar controle de devolucao")
	public void euClicoBotaoPesquisarControleDevolucao() throws InterruptedException {
		toolbar.clickPesquisar();
	}
	
	/**
	 * Clica no botao pesquisar nota fiscal
	 * 
	 * @throws InterruptedException
	 */
	@When("Eu clico no botao Pesquisar nota fiscal")
	public void euClicoBotaoPesquisarNotaFiscal() throws InterruptedException {
		janela.abrirPopupClick(obsDevolucaoItem.getBtnPesquisarNotaFiscal());
	}
	
	/**
	 * Informa o numero da nota fiscal 
	 * 
	 * @throws InterruptedException
	 */
	@When("Eu informo o numero da nota fiscal para consultar nota fiscal")
	public void euInformoNumeroNotaFiscal() {
		consultaNotaFiscal.setNroNF();
	}
	
	/**
	 * Limpa o campo loja de destino
	 * 
	 * @throws InterruptedException
	 */
	@When("Eu limpo o campo loja de destino")
	public void euLimpoCampoLojaDestino() throws InterruptedException {
		consultaNotaFiscal.setLojaDestino("");
	}
	
	/**
	 * Seleciona o filtro somente notas
	 * 
	 * @throws InterruptedException
	 */
	@When("Eu seleciono o filtro somente notas $somenteNotas")
	public void euLimpoCampoLojaDestino(String somenteNotas) throws InterruptedException {
		consultaNotaFiscal.setProcesso(somenteNotas);
	}
	
	/**
	 * Clica no botao pesquisar
	 * 
	 * @throws InterruptedException
	 */
	@When("Eu clico no botao Pesquisar")
	public void euClicoBotaoPesquisar() throws InterruptedException {
		toolbar.clickPesquisar();
	}
	
	/**
	 * Clica no botao pesquisar
	 * 
	 * @throws InterruptedException
	 */
	@When("Eu clico no botao Pesquisar nota fiscal consulta")
	public void euClicoBotaoPesquisarNotaFiscalConsulta() throws InterruptedException {
		consultaNotaFiscal.clickBtnPesquisar();
	}
	
	/**
	 * Seleciono a nota fiscal
	 * 
	 * @throws InterruptedException
	 */
	@When("Eu seleciono a nota fiscal avulsa")
	public void euSelecionoNotaFiscal() throws InterruptedException {
		
		consultaNotaFiscal.selecionarNf(Serenity.sessionVariableCalled(NRO_NF_AVULSA));
		janela.fecharJanela(consultaNotaFiscal.getBtnSelecionar());
	}
	
	/**
	 * Seleciono o item que serah devolvido
	 * 
	 * @throws InterruptedException
	 */
	@When("Eu seleciono o item devolvido $codNroItem")
	public void euSelecionoItemDevolvido(String codNroItem) throws InterruptedException {
		obsDevolucaoItem.selecionarItem(codNroItem);
	}
	
	/**
	 * Clica no botao editar do toolbar
	 * 
	 * @throws InterruptedException
	 */
	@When("Eu clico no botao Editar")
	public void euClicaBotaoEditarToolbar() throws InterruptedException {
		toolbar.clickEditar();
	}
	
	/**
	 * Seleciona o status do controle de devolucao
	 * 
	 * @throws InterruptedException
	 */
	@When("Eu seleciono o status do controle de devolucao $statusControleDevolucao")
	public void euSelecionoStatusControleDevolucao(String statusControleDevolucao) throws InterruptedException {
		obsDevolucaoItem.setStatus(statusControleDevolucao);
	}
	
	/**
	 * Seleciona o status do controle de devolucao
	 * 
	 * @throws InterruptedException
	 */
	@When("Eu informo uma observacao do controle de devolucao")
	public void euInformoObservacaoControleDevolucao() throws InterruptedException {
		obsDevolucaoItem.setObservacao("Teste Automatizado - devolução realizada com sucesso!");
	}
	
	/**
	 * Clica no botao salvar do toolbar
	 * 
	 * @throws InterruptedException
	 */
	@When("Eu clico no botao Salvar controle de devolucao")
	public void euClicaBotaoSalvarToolbar() throws InterruptedException {
		toolbar.clickSalvar();
	}
	
	/**
	 * Clica no botao autorizar emissao recibo
	 * 
	 * @throws InterruptedException
	 */
	@When("Eu clico no botao Autorizar Emissao Recibo")
	public void euClicaBotaoAutorizarEmissaoRecibo() throws InterruptedException {
		obsDevolucaoItem.clickBtnAutorizarEmissaoRecibo();
	}
	
	/**
	 * Clica no botao remover produto
	 * 
	 * @throws InterruptedException
	 */
	@When("Eu clico no botao Remover Produto da solicitacao")
	public void euClicaBotaoRemoverProdutoSolicitacao() throws InterruptedException {
		preRecibo.clickRemoverProduto();
	}
	
	/**
	 * Clica no botao remover servico
	 * 
	 * @throws InterruptedException
	 */
	@When("Eu clico no botao Remover Servico da solicitacao")
	public void euClicaBotaoRemoverServicoSolicitacao() throws InterruptedException {
		preRecibo.clickRemoverServico();
	}
	
	@Given("Eu adiciono o tipo de venda $tipoVenda para regra $seqRegra de trocadevolucao")
	public void euAdicionoTipoVendaRegra(String tipoVenda, String seqRegra) throws InterruptedException {
		preRecibo.adicionarTipoVendaRegra(tipoVenda, seqRegra);
	}
	
	@When("Eu removo o tipo de venda $tipoVenda da regra $seqRegra")
	public void euRemovoTipoVendaRegra(String tipoVenda, String seqRegra) throws InterruptedException {
		preRecibo.removerTipoVendaRegra(tipoVenda, seqRegra);
	}
	
	@When("Eu valido a regra $seqRegra")
	public void euValidoRegra(String seqRegra) throws InterruptedException {
		preRecibo.validarRegra(seqRegra);
	}
}