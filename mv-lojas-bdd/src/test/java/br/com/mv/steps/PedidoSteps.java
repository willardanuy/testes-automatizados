package br.com.mv.steps;

import java.io.IOException;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import br.com.mv.pages.ConsultaProdutoModal;
import br.com.mv.pages.ConsultaPromocaoModal;
import br.com.mv.pages.PedidoPage;
import net.thucydides.core.annotations.Steps;

public class PedidoSteps {

	@Steps
	PedidoPage pedido;
	ConsultaProdutoModal consultaProdutoModal;
	ConsultaPromocaoModal consultaPromocaoModal;
	
	/**
	 * Seleciona o tipo de venda na tela de pedido.
	 * 
	 * @param tipoVenda
	 * @throws InterruptedException
	 */
	@When("Eu seleciono o tipo de venda $tipoVenda")
	public void euSelecionoTipoVenda(String tipoVenda) throws InterruptedException {
		pedido.selecionarTipoVenda(tipoVenda);
	}
	
	/**
	 * Seleciona o plano
	 * 
	 * @param plano
	 * @throws InterruptedException
	 */
	@When("Eu seleciono o plano $plano")
	public void euSelecionoPlano(String plano) throws InterruptedException {
		pedido.selecionarPlano(plano);
	}
	
	/**
	 * Seleciona o plano
	 * 
	 * @param plano
	 * @throws InterruptedException
	 */
	@When("Eu informo o valor da prestacao $vlrPrestacao")
	public void euInformoValorPrestacao(String vlrPrestacao) throws InterruptedException {
		pedido.informarValorPrestacao(vlrPrestacao);
	}
	
	
	
	/**
	 * Efetua o clique no botão adicionar produto.
	 * 
	 * @throws InterruptedException
	 */
	@When("Eu clico no botao adicionar produto")
	public void euClicoAdicionarProduto() throws InterruptedException {
		
		pedido.clicarInsereProduto();
	}
	
	/**
	 * Fecha o modal de promoção sem informar a promoção.
	 * @throws InterruptedException 
	 */
	@When("Eu deixo o produto sem promocao")
	public void euDeixoProdutoSemPromocao() throws InterruptedException {
		
		consultaPromocaoModal.deixarProdutoSemPromocao();
	}
	
	/**
	 * Efetua o clique no botão detalhes do produto informado.
	 * 
	 * @param codNroProduto
	 * @throws InterruptedException
	 */
	@When("Eu clico no icone detalhes do produto $codNroProduto")
	public void euClicoNoBotaoDetalhesDoProduto(String codNroProduto) throws InterruptedException {
		
		pedido.clicarIconeDetalhesProduto(codNroProduto);
	}
	
	/**
	 * Seleciona o local de empenho.
	 * 
	 * @param descLocalEmpenho
	 * @throws InterruptedException
	 */
	@When("Eu seleciono o local de empenho $descLocalEmpenho")
	public void euInformoLocalEmpenho(String descLocalEmpenho) throws InterruptedException {
		Thread.sleep(1000);

		pedido.informarLocalEmpenho(descLocalEmpenho);
		Thread.sleep(1000);

	}
	
	/**
	 * Seleciona a opção de entrega.
	 * 
	 * @param descOpcaoEntrega
	 * @throws InterruptedException
	 */
	@When("Eu seleciono a opcao de entrega $descOpcaoEntrega")
	public void euInformoOpcaoEntrega(String descOpcaoEntrega) throws InterruptedException {
		
		pedido.informarOpcaoEntrega(descOpcaoEntrega);
	}
	
	/**
	 * Informa a flag de entrega.
	 * 
	 * @param flagEntrega
	 * @values SIM, NÃO
 	 * @throws InterruptedException
	 */
	@When("Eu informo a flag entrega como $flagEntrega")
	public void euInformoFlagEntrega(String flagEntrega) throws InterruptedException {
		
		pedido.informarFlagEntrega(flagEntrega);
	}
	
	/**
	 * Efetua o clique no botão Reservar da tela de pedido.
	 * @throws InterruptedException 
	 */
	@When("Eu clico no botao Reservar")
	public void euClicoNoBotaoReservar() throws InterruptedException {
		
		pedido.clicarBtnEmpenharProduto();
	}
	
	/**
	 * Efetua o clique no botão OK do modal.
	 * @throws InterruptedException 
	 */
	@Then("Eu clico no botao Ok do modal")
	@When("Eu clico no botao Ok do modal")
	public void euClicoNoBotaoOkModal() throws InterruptedException {
		
		pedido.clicarBtnOkModal();
	}
	
	/**
	 * Efetua o clique no botão Sim do modal.
	 * @throws InterruptedException 
	 */
	@When("Eu clico no botao Sim do modal")
	public void euClicoNoBotaoSimModal() throws InterruptedException {
		
		pedido.clicarBtnSimModal();
	}
	
	/**
	 * Efetua o clique em uma aba da tela de pedido.
	 * 
	 * @param descAba
	 * @throws InterruptedException
	 */
	@When("Eu clico na aba $descAba")
	public void euClicoNaAba(String descAba) throws InterruptedException {
		
		pedido.clicarNaAba(descAba);
	}
	
	/**
	 * Efetua o clique no botão Adicionar Forma Pagamento.
	 * 
	 * @throws InterruptedException
	 */
	@When("Eu clico no botao Adicionar Forma Pagamento")
	public void euClicoNoBotaoAdicionarFormaPagamento() throws InterruptedException {
		
		pedido.clicarBtnInsereFormaPagamento();
	}
	
	/**
	 * Seleciona o tipo de pagamento.
	 * 
	 * @param idLinha => numeral(1,2,3...) de acordo com a quantidade de formas de pagamento informadas no cenário
	 * @param tipoFormaPagto
	 * @throws InterruptedException
	 */
	@When("Eu seleciono o $idLinha º tipo de pagamento $tipoPagamento")
	public void euInformoTipoPagamento(String idLinha, String tipoFormaPagto) throws InterruptedException {
		
		pedido.informarTipoPagamento(idLinha, tipoFormaPagto);
	}
	
	/**
	 * Seleciona a forma de pagamento.
	 * 
	 * @param idLinha => numeral(1,2,3...) de acordo com a quantidade de formas de pagamento informadas no cenário
	 * @param formaPagamento
	 * @throws InterruptedException
	 */
	@When("Eu seleciono a $idLinha ª forma de pagamento $formaPagamento")
	// @Alias("Eu seleciono a $idLinha ª forma de pagamento $formaPagamento e informo o valor de $valorFormaPagamento")
	public void euInformoFormaPagamento(String idLinha, String formaPagamento) throws InterruptedException {
		
		pedido.informarFormaPagamento(idLinha, formaPagamento);
		
		/*if (!valorFormaPagamento.isEmpty()) {
			pedido.informarValorFormaPagamento(idLinha, valorFormaPagamento);
		}*/
	}
	
	/**
	 * Informa o valor da forma de pagamento
	 * 
	 * @param idLinha => numeral(1,2,3...) de acordo com a quantidade de formas de pagamento informadas no cenário
	 * @param formaPagamento
	 * @throws InterruptedException
	 */
	@When("Eu informo o valor da $idLinha ª forma de pagamento $vlrFormaPagamento")
	// @Alias("Eu seleciono a $idLinha ª forma de pagamento $formaPagamento e informo o valor de $valorFormaPagamento")
	public void euInformoValorFormaPagamento(String idLinha, String vlrFormaPagamento) throws InterruptedException {
		
		pedido.informarValorFormaPagamento(idLinha, vlrFormaPagamento);
		
		/*if (!valorFormaPagamento.isEmpty()) {
			pedido.informarValorFormaPagamento(idLinha, valorFormaPagamento);
		}*/
	}
	
	/**
	 * Efetua o clique no botão Salvar da tela de pedido.
	 */
	@When("Eu clico no botao Salvar")
	public void whenEuClicoNoBotaoSalvar() {
		
		pedido.clicarBtnSalvarPedido();
	}
	
	/**
	 * Efetua o clique no botão Salvar da tela de pedido.
	 */
	@Then("Eu clico no botao Salvar")
	public void euClicoNoBotaoSalvar() {
		
		pedido.clicarBtnSalvarPedido();
	}
	
	/**
	 * Efetua o clique no botão Fechamento Total da tela de pedido.
	 * @throws InterruptedException 
	 */
	@Then("Eu clico no botao Fechamento Total")
	public void euClicoNoBotaoFechamentoTotal() throws InterruptedException {
		
		pedido.clicarBtnFechamentoTotalPedido();
	}
	
	/**
	 * Valida o status do pedido ao realizar o fechamento total do pedido.
	 * 
	 * @param statusPedido
	 * @throws InterruptedException 
	 */
	@Then("Eu valido o status do pedido $statusPedido")
	public void euValidoStatusDoPedido(String statusPedido) throws InterruptedException {
		
		pedido.validarStatusPedido(statusPedido);
	}
	
	/**
	 * Remove todos os serviços do pedido
	 */
	@When("Eu removo todos os serviços")
	public void euRemovoTodosServicos() {
		
		pedido.removerTodosServicos();
	}
	
	/**
	 * Remove o serviço informado.
	 * 
	 * @param nroServico
	 */
	@When("Eu removo o servico $nroServico")
	public void euRemovoOServico(String nroServico) {
		
		pedido.removerOServico(nroServico);
	}
	
	/**
	 * Remove o serviço informado.
	 * 
	 * @param nroServico
	 * @throws InterruptedException 
	 */
	@When("Eu clico em adicionar servico")
	public void euClicoAdicionarServico() throws InterruptedException {
		
		pedido.clicarEmAdicionarServico();
	}
	
	/**
	 * Adiciona o serviço informado.
	 * 
	 * @param nroServico
	 */
	@When("Eu adiciono o servico $nroServico")
	public void euAdicionoOServico(String nroServico) {
		
		pedido.adicionarOServico(nroServico);
	}

	/**
	 * Clica no botão Agendada
	 */
	@When("Eu clico no botao Agendada")
	public void euClicoBotaoAgendada() {
		
		pedido.clicarNoBotaoAgendada();
	}
	
	/**
	 * Seleciona uma data disponivel
	 * @throws InterruptedException 
	 */
	@When("Eu seleciono uma data disponivel")
	public void euSelecionoDataDisponivel() throws InterruptedException {
		
		pedido.selecionarDataDisponivel();
	}
	
	/**
	 * Seleciona a loja informada
	 * @throws InterruptedException 
	 */
	@When("Eu seleciono a loja disponivel $codNroLoja")
	public void euSelecionoLojaDisponivel(String codNroLoja) throws InterruptedException {
		
		pedido.selecionarLojaDisponivel(codNroLoja);
	}
	
	/**
	 * Seleciona a loja informada
	 * @throws InterruptedException 
	 */
	@When("Eu seleciono a liberacao $tipoLiberacao com flags $flagLiberacao para o produto $codNroProduto")
	public void euSelecionoALiberacao(String tipoLiberacao, String flagLiberacao, String codNroProduto) throws InterruptedException {
		
		pedido.selecionarALiberacao(tipoLiberacao, flagLiberacao, codNroProduto);
	}
	
	/**
	 * Clica no botão liberar
	 * @throws InterruptedException 
	 */
	@When("Eu clico no botao Liberar")
	public void euClicoBotaoLiberar() throws InterruptedException {
		
		pedido.clicarBotaoLiberar();
	}
	
	/**
	 * Clica no botão liberar
	 * @throws InterruptedException 
	 */
	@When("Eu informo a observacao $observacao da liberacao")
	public void euInformoObservacao(String observacao) throws InterruptedException {
		
		pedido.informarObservacao(observacao);
	}
	
	/**
	 * Informa o usuário e senha para validar a liberação
	 * @throws InterruptedException 
	 */
	@When("Eu informo o usuario $usuario e senha $senha para validar liberacao")
	public void euInformoUsuarioSenhaValidacao(String usuario, String senha) throws InterruptedException {
		
		pedido.informarUsuarioSenhaValidacaoLiberacao(usuario, senha);
	}
	
	/**
	 * Informa o usuário e senha para validar a exclusão
	 * @throws InterruptedException 
	 */
	@When("Eu informo o usuario $usuario e senha $senha para validar exclusao")
	public void euInformoUsuarioSenhaValidarExclusao(String usuario, String senha) throws InterruptedException {
		
		pedido.informarUsuarioSenhaValidacaoLiberacao(usuario, senha);
	}
	
	/**
	 * Informa uma data de retenção disponível
	 * @throws InterruptedException 
	 */
	@When("Eu informo uma data de retencao disponivel")
	public void euInformoUmaDataRetencaoDiposponivel() throws InterruptedException {
		
		pedido.informarDataRetencaoDisponivel();
	}
	
	/**
	 * Informa o número de série
	 * 
	 * @throws InterruptedException 
	 */
	@When("Eu informo o numero de serie $nroSerie")
	public void euInformoNumeroSerie(String nroSerie) throws InterruptedException {
		
		pedido.informarNumeroSerie(nroSerie);
	}
	
	/**
	 * Remove a garantia de um produto
	 * 
	 * @throws InterruptedException 
	 */
	@When("Eu removo a garantia $nroGarantia do produto $codNroProduto")
	public void euRemovoAGarantiaProduto(String nroGarantia, String codNroProduto) throws InterruptedException {
		
		pedido.removerGarantiaProduto(nroGarantia, codNroProduto);
	}
	
	/**
	 * Clica no botão + Garantia
	 * 
	 * @throws InterruptedException 
	 */
	@When("Eu clico no botao Adicionar Garantia")
	public void euClicoNoBotaoAdicionarGarantia() throws InterruptedException {
		
		pedido.clicarBotaoAdicionarGarantia();
	}
	
	/**
	 * Adiciona uma garantia
	 * 
	 * @throws InterruptedException 
	 */
	@When("Eu clico no produto $codNroProduto")
	public void euClicoNoProduto(String codNroProduto) throws InterruptedException {
		
		pedido.clicarNoProduto(codNroProduto);
	}
	
	/**
	 * Seleciona uma garantia
	 * 
	 * @throws InterruptedException 
	 */
	@When("Eu seleciono a garantia $nroGarantia")
	public void euSelecionoAGarantia(String nroGarantia) throws InterruptedException {
		
		pedido.selecionarGarantia(nroGarantia);
	}
	
	/**
	 * Seleciona uma garantia
	 * 
	 * @throws InterruptedException 
	 */
	@When("Eu seleciono a tabela $descTabela para o produto $codNroProduto")
	public void euSelecionoATabela(String descTabela, String codNroProduto) throws InterruptedException {
		
		pedido.selecionarTabelaPorProduto(descTabela, codNroProduto);
	}
	
	/**
	 * Seleciona uma data e um turno disponível
	 * 
	 * @throws InterruptedException 
	 */
	@When("Eu informo uma data e um turno disponivel")
	public void euInformoUmDataTurnoDisponivel() throws InterruptedException {
		
		pedido.informarDataTurnoDisponivel();
	}
	
	/**
	 * Valida se o serviço foi adicionado
	 * 
	 * @throws InterruptedException 
	 */
	@When("Eu valido se o servico $nroServico ja foi adicionado")
	public void euValidoServicoAdicionado(String nroServico) throws InterruptedException {
		
		pedido.validarServicoAdicionado(nroServico);
	}
	
	/**
	 * Informa um valor de entrada
	 * 
	 * @throws InterruptedException 
	 */
	@When("Eu informo um valor de entrada de $vlrEntrada")
	public void euInformoUmValorDeEntrada(String vlrEntrada) throws InterruptedException {
		
		pedido.infomarValorEntrada(vlrEntrada);
	}
	
	/**
	 * Informa o número do documento
	 * 
	 * @throws InterruptedException 
	 */
	@When("Eu clico no botao Gerar Financiamento")
	public void euClicoNoBotaoGerarFinanciamento() throws InterruptedException {
		
		pedido.clicarBotaoGerarFinanciamento();
	} 
	
	/**
	 * Informa o número do documento
	 * 
	 * @throws InterruptedException 
	 */
	@When("Eu informo o numero $nroDocumento para o documento")
	public void euInformoONumeroDocumento(String nroDocumento) throws InterruptedException {
		
		pedido.informarNumeroDocumento(nroDocumento);
	}
	
	/**
	 * Valida se a garantia informada já está adicionada
	 * 
	 * @throws InterruptedException 
	 */
	@When("Eu valido se a garantia $nroGarantia foi adicionada para o produto $codNroProduto")
	public void euValidoSeAGarantiaFoiAdicionadaParaProduto(String nroGarantia, String codNroProduto) throws InterruptedException {
		
		pedido.validoGarantiaPorProduto(nroGarantia, codNroProduto);
	}
	
	
	// GARANTIA AVULSA
	
	/**
	 * Clica no botão adicionar Garantia Avulsa
	 * 
	 * @throws InterruptedException 
	 */
	@When("Eu clico no botao adicionar Garantia Avulsa")
	public void euClicoNoBotaoAdicionarGarantiaAvulsa() throws InterruptedException {
		
		pedido.clicarBotaoAdicionarGarantiaAvulsa();
	}
	
	/**
	 * Informa o número do pedido anterior
	 * 
	 * @throws InterruptedException 
	 */
	@When("Eu informo o numero do pedido anterior")
	public void euInformoONumeroPedidoAnterior() throws InterruptedException {
		
		pedido.informarNumeroPedidoAnterior();
	}
	
	/**
	 * Informa o numero da loja
	 * 
	 * @throws InterruptedException 
	 */
	@When("Eu informo o numero da loja $codNroLoja")
	public void euInformoONumeroLoja(String codNroLoja) throws InterruptedException {
		
		pedido.informarNumeroLoja(codNroLoja);
	}
	
	/**
	 * Informa o numero do produto
	 * 
	 * @throws InterruptedException 
	 */
	@When("Eu informo o numero do produto $codNroProduto")
	public void euInformoONumeroProduto(String codNroProduto) throws InterruptedException {
		
		pedido.informarNumeroProduto(codNroProduto);
	}
	
	/**
	 * Seleciona a nota relacionada ao produto
	 * 
	 * @throws InterruptedException 
	 */
	@When("Eu seleciono a nota relacionada ao produto $codNroProduto")
	public void euSelecionoNotaRelacionadaProduto(String codNroProduto) throws InterruptedException {
		
		pedido.selecionarNotaRelacionadaProduto(codNroProduto);
	}
	
	/**
	 * Seleciona uma garantia avulsa
	 * 
	 * @throws InterruptedException 
	 */
	@When("Eu seleciono uma garantia avulsa $desGarantia")
	public void euSelecionoUmaGarantiaAvulsa(String descGarantia) throws InterruptedException {
		
		pedido.selecionarUmaGarantiaAvulsa(descGarantia);
	}
	
	/**
	 * Clica no botão Inserir Garantia
	 * 
	 * @throws InterruptedException 
	 */
	@When("Eu clico no botao Inserir Garantia")
	public void euClicoNoBotaoInserirGarantia() throws InterruptedException {
		
		pedido.clicarNoBotaoInserirGarantia();
	}
	
	// GARANTIA AVULSA - VENDA EXTERNA
	/**
	 * Informa numero da nota fiscal
	 * 
	 * @throws InterruptedException 
	 */
	@When("Eu informo o numero da nota fiscal venda externa")
	public void euInformoNumeroDaNotaFiscalGarantiaExterna() throws InterruptedException{
		pedido.informarNotaFiscalGarantiaExterna();
	}
	
	/**
	 * Informa data da nota fiscal externa
	 * 
	 * @throws InterruptedException 
	 */
	@When("Eu informo a data emissao da nota externa")
	public void euInformoDataEmissaoNotaExterna() throws InterruptedException{
		pedido.informarDataEmissaoNotaExterna();
	}
	
	/**
	 * Informa empresa da nota fiscal externa
	 * 
	 * @throws InterruptedException 
	 */
	@When("Eu informo a empresa da nota externa $descEmpresa")
	public void euInformoEmpresaDaNotaExterna(String empresaNotaExterna) throws InterruptedException{
		pedido.informarEmpresaNotaExterna(empresaNotaExterna);
	}
	
	/**
	 * Clica na lupa para pesquisar produto
	 * 
	 * @throws InterruptedException 
	 */
	@When("Eu clico no icone pesquisar produto da venda externa")
	public void euClicoNoIconeDePesquisarProduto() throws InterruptedException{
		pedido.clicarNoIconePesquisarProduto();
		
	}
	
	/**
	 * Informa o codigo pai do produto
	 * 
	 * @throws InterruptedException 
	 */
	@When("Eu informo o codigo pai do produto $codigoPai da venda externa")
	public void euInformoCodigoPaiDoProduto(String codigoPai) throws InterruptedException{
		pedido.informarCodigoPaiDoProduto(codigoPai);
	}
	
	/**
	 * Clica no botao pesquisar produto para inserir garantia avulsa
	 * 
	 * @throws InterruptedException 
	 */
	@When("Eu clico no botao Pesquisar da venda externa")
	public void euClicoNoBotaoPesquisar() throws InterruptedException{
		pedido.clicarNoBotaoPesquisar();
	}
	
	/**
	 * Seleciona o produto
	 * 
	 * @throws InterruptedException 
	 */
	@When("Eu seleciono o produto $codNroProduto para garantia avulsa venda externa")
	public void euSelecionoProduto(String codNroProduto) throws InterruptedException{
		pedido.selecionarProdutoGarantiaExterna(codNroProduto);
	}
	
	/**
	 * Clico na garantia avulsa na grid da venda externa
	 * 
	 * @throws InterruptedException 
	 */
	@When("Eu clico na garantia avulsa na grid da venda externa")
	public void euClicoNaGarantiaAvulsaNaGridDaVendaExterna() throws InterruptedException{
		pedido.clicarNaGarantiaAvulsaNaGridVendaExterna();
	}
	
	/**
	 * Clico na garantia avulsa na grid da venda externa
	 * 
	 * @throws InterruptedException 
	 */
	@When("Eu clico no botao para remover garantia avulsa na grid da venda externa")
	public void euClicoNoBotaoParaRemoverGarantiaAvulsa() throws InterruptedException{
		pedido.clicarNoBotaoParaRemoverGarantiaAvulsa();
	}
	
	// CONSULTA DE PEDIDO
	
	/**
	 * Consulta o pedido
	 * 
	 * @throws InterruptedException 
	 */
	@When("Eu consulto o pedido")
	public void euConsultoPedido() throws InterruptedException {
		
		pedido.consultarPedido();
	}
	
	/**
	 * Consulta o pedido
	 * 
	 * @throws InterruptedException 
	 */
	@When("Eu clico no botao Cancelar pedido")
	public void euClicoBotaoCancelarPedido() throws InterruptedException {
		pedido.clicarBotaoCancelarPedido();
	}
	
	/**
	 * Reabre o pedido
	 * 
	 * @throws InterruptedException 
	 */
	@When("Eu clico no botao Reabertura")
	public void euReabroPedido() throws InterruptedException {
		
		pedido.reabrirPedido();
	}
	
	/**
	 * Cancela reserva
	 * 
	 * @throws InterruptedException 
	 */
	@When("Eu clico no botao Cancelar Reserva")
	public void euClicoNoBotaoCancelarReserva() throws InterruptedException {
		
		pedido.cancelarReserva();
	}
	
	/**
	 * Altera a quantidade do serviço
	 * 
	 * @throws InterruptedException 
	 */
	@When("Eu altero a quantidade do servico $codNroServico para $quantidade")
	public void euAlteroAQuantidadeServico(String codNroServico, String quantidade) throws InterruptedException {
		
		pedido.alterarQuantidadeServico(codNroServico, quantidade);
	}
	
	/**
	 * Altera o valor unitario do serviço
	 * 
	 * @throws InterruptedException 
	 */
	@When("Eu altero o valor unitario do servico $codNroServico para $vlrUnitario")
	public void euAlteroOValorUnitarioServico(String codNroServico, String vlrUnitario) throws InterruptedException {
		
		pedido.alterarOValorUnitarioServico(codNroServico, vlrUnitario);
	}
	
	/**
	 * Remove todas as planilhas do pedido
	 * 
	 * @throws InterruptedException 
	 */
	@When("Eu removo todas as planilhas")
	public void euRemovoTodasAsPlanilhas() throws InterruptedException {
		
		pedido.removerPlanilhas();
	}
	
	/**
	 * Clica no botão CMC7
	 * 
	 * @throws InterruptedException 
	 */
	@When("Eu clico no botao CMC7")
	public void euClicoNoBotaoCMC7() throws InterruptedException {
		
		pedido.clicarBotaoCMC7();
	}
	
	/**
	 * Clica no botão validar CMC7
	 * 
	 * @throws InterruptedException 
	 */
	@When("Eu clico no botao validar CMC7")
	public void euClicoNoBotaoValidarCMC7() throws InterruptedException {
		
		pedido.clicarBotaoValidarCMC7();
	}
	
	/**
	 * Informar o CMC7
	 * 
	 * @throws InterruptedException 
	 */
	@When("Eu informo o numero do cheque $nroCheque")
	public void euInformoCMC7(String nroCheque) throws InterruptedException {
		
		pedido.informarCMC7(nroCheque);
	}
	
	/**
	 * Informar data abertura conta
	 * 
	 * @throws InterruptedException 
	 */
	@When("Eu informo a data $dtAbertura de abertura da conta do cheque")
	public void euInformoDataAberturaContaCheque(String dtAbertura) throws InterruptedException {
		
		pedido.informarDtAberturaContaCMC7(dtAbertura);
	}
	
	/**
	 * Remove todas as planilhas do pedido
	 * 
	 * @throws InterruptedException 
	 */
	@When("Eu clico no botao Salvar Cheque")
	public void euClicoNoBotaoSalvarCheque() throws InterruptedException {
		
		pedido.clicarBotaoSalvarCheque();
	}
	
	/**
	 * Remove um produto
	 * 
	 * @throws InterruptedException 
	 */
	@When("Eu removo o produto $codNroProduto")
	public void euRemovoOProduto(String codNroProduto) throws InterruptedException {
		
		pedido.removerProduto(codNroProduto);
	}
	
	/**
	 * Executa script
	 * 
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	@Given("Eu executo o script de reset $nomScript")
	public void euExecutoScriptReset(String nomScript) throws InterruptedException, IOException {
		
		pedido.executarScriptReset(nomScript);
	}
	
	/**
	 * Executa script
	 * 
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	@When("Eu executo o script de reset $nomScript")
	public void euExecutoScriptResetWhen(String nomScript) throws InterruptedException, IOException {
		
		pedido.executarScriptReset(nomScript);
	}
	
	@When("Eu clico no botao Imprimir Documentos")
	public void euClicoNoBotaoImprimirDocumentos() throws InterruptedException {
		pedido.clicarBotaoImprimirDocumentos();
	}
	
	@When("Eu seleciono o documento $nomDocumento") 
	public void euSelecionoODocumento(String nomDocumento) throws InterruptedException {
		pedido.selecionarDocumento(nomDocumento);
	}
	
	@When("Eu clico no botao Gerar Relatorio")
	public void euClicoNoBotaoGerarRelatorio() {
		pedido.clicarBotaoGerarRelatorio();
	}
	
	@Then("Eu valido o Termo de Adesão Antivirus Hero")
	public void euValidoTermoAdesaoAntivirusHero() {
		pedido.validarTermoAdesaoAntivirusHero();
	}
	
	@Then("Eu valido o Termo de Adesão Passaporte")
	public void euValidoTermoAdesaoPassaporte() {
		pedido.validarTermoAdesaoPassaporte();
	}
	
	@Then("Eu salvo o pedido do teste $codTeste no relatorio")
	public void euSalvoOPedidoNoRelatorio(String codTeste) throws IOException {
		pedido.salvarPedidoRelatorio(codTeste);
	}
	
	@When("Eu clico no botao pesquisar Recibo de Troca")
	public void euClicoBotaoPesquisarReciboTroca() throws IOException {
		pedido.clicarBtnReciboTrocaPlanilha();
	}
	
	@When("Eu informo o pedido com credito")
	public void euInformoPedidoCredito() throws IOException {
		pedido.informarPedidoComCredito();
	}
	
	@When("Eu informo o codigo da loja do pedido com credito")
	public void euInformoCodigoLojaPedidoCredito() throws IOException {
		pedido.informarLojaPedidoComCredito();
	}
	
	@When("Eu informo a empresa do pedido com credito")
	public void euInformoEmpresaPedidoCredito() throws IOException {
		
	}
	
	@When("Eu clico no botao Verificar Credito")
	public void euClicoBotaoVerificarCredito() throws IOException {
		pedido.clicarBtnVerificarCredito();
	}
	
	@When("Eu clico no botao Utilizar Credito")
	public void euClicoBotaoUtilizarCredito() throws IOException {
		pedido.clicarBtnSalvarReciboTroca();
	}
	
	/* CREDITO ENTERPRISE */
	
	@When("Eu clico no botao pesquisar Credito Enterprise")
	public void euClicoBotaoCreditoEnterprise() throws IOException {
		pedido.clicarBtnCreditoEnterprise();
	}
	
	@When("Eu informo o pedido $nroPedido com credito enterprise")
	public void euInformoPedidoCreditoEnterprise(String nroPedido) throws IOException {
		pedido.informarPedidoComCreditoEnterprise(nroPedido);
	}
	
	@When("Eu informo o codigo da loja $codNroLoja do pedido com credito enterprise")
	public void euInformoCodLojaCreditoEnterprise(String codNroLoja) throws IOException {
		pedido.informarLojaPedidoComCreditoEnterprise(codNroLoja);
	}
	
	@When("Eu informo a empresa $nomEmpresa do pedido com credito enteprise")
	public void euInformoEmpresaCreditoEnterprise(String nomEmpresa) throws IOException, InterruptedException {
		pedido.selecionarEmpresaCreditoEnterprise(nomEmpresa);
	}
	
	@When("Eu clico no botao Verificar Credito enterprise")
	public void euClicoBotaoVerificarCreditoEnterprise() throws IOException {
		pedido.clicarBtnVerificarCreditoEnterprise();
	}
	
	@When("Eu clico no botao Utilizar Credito enterprise")
	public void euClicoBotaoUtilizarCreditoEnterprise() throws IOException {
		pedido.clicarBtnUtilizarCreditoEnterprise();
	}
	
	@When("Eu clico no botao Ok do modal credito enterprise")
	public void euClicoBotaoOkModalCreditoEnterprise() throws IOException, InterruptedException {
		pedido.clicarBtnOkModalCreditoEnterprise();
	}
		
	 
}