package br.com.mv.pages;

import static br.com.mv.model.SessionVariables.COD_NRO_LOJA;
import static br.com.mv.model.SessionVariables.NRO_NF_AVULSA;
import static br.com.mv.model.SessionVariables.NRO_PEDIDO;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import br.com.mv.dao.NotaFiscalDAO;
import br.com.mv.utils.AguardaCarregamento;
import br.com.mv.utils.ControleJanela;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.pages.PageObject;

public class EmissaoNotaFiscalAvulsaPage extends PageObject {

	@FindBy(id = "cbxOperacaoNotaFiscal")
	private WebElement operacaoNF;
	
	@FindBy(id = "txtCodigoTipoNotaFiscal")
	private WebElement codTipoNF;
	
	@FindBy(id = "txtDescricaoTipoNotaFiscal")
	private WebElement descTipoNF;
	
	@FindBy(id = "btnBuscarTiposNotaFiscal")
	private WebElement btnBuscarTiposNF;
	
	@FindBy(id = "txtNaturezaOperacao")
	private WebElement naturezaOperacao;
	
	@FindBy(id = "cbxGrupoEstoqueOrigem")
	private WebElement grupoEstoqueOrigem;
	
	@FindBy(id = "chxAverbaSeguro")
	private WebElement chkAverbarNoSeguro;
	
	@FindBy(id = "btnIformarParametros")
	private WebElement btnInformarParametros;
	
	//botões de nagegação entre as abas de nota fiscal
	@FindBy(xpath = "//span[contains(text(), \"Cabeçalho\")]")
	private WebElement abaCabecalho;
	
	@FindBy(xpath = "//span[contains(text(), \"Itens\")]")
	private WebElement abaItens;
	
	@FindBy(xpath = "//span[contains(text(), \"Transportador\")]")
	private WebElement abaTransportador;
	
	@FindBy(xpath = "//span[contains(text(), \"Outros\")]")
	private WebElement 	abaOutros;
	
	@FindBy(xpath = "//span[contains(text(), \"Adicionais\")]")
	private WebElement abaDados;
	//.
	
	//Elementos Aba Cabeçalho
	@FindBy(id = "txtDataEmissao")
	private WebElement dataEmissao;
	
	@FindBy(id = "txtDescricaoUsuario")
	private WebElement descUsuario;
	
	@FindBy(id = "txtCodigoUsuario")
	private WebElement codUsuario;
	
	@FindBy(id = "txtNumeroNota")
	private WebElement nroNota;
	
	@FindBy(id = "txtNumeroCupom")
	private WebElement nroCupom;
	
	@FindBy(id = "txtNFReferencia")
	private WebElement nfReferencia;
	
	@FindBy(id = "txtNatureza")
	private WebElement natrueza;
	
	@FindBy(id = "txtCFOP")
	private WebElement cfop;
	
	@FindBy(id = "txtDataSaida")
	private WebElement dataSaida;
	
	@FindBy(id = "txtNomeRazaoSocial")
	private WebElement razaoSocial;
	
	@FindBy(id = "txtCnpjCpf")
	private WebElement cnpjCpf;
	
	@FindBy(id = "txtIE")
	private WebElement inscricaoEstadual;
	
	@FindBy(id = "txtDescricaoTipoLogradouro")
	private WebElement descTipoLogradouro;
	
	@FindBy(id = "txtDescricaoLogradouro")
	private WebElement descLogradouro;
	
	@FindBy(id = "txtNumeroEndereco")
	private WebElement nroEndereco;
	
	@FindBy(id = "txtComplementoEndereco")
	private WebElement complementoEndereco;
	
	@FindBy(id = "txtNomeBairro")
	private WebElement bairro;
	
	@FindBy(id = "txtNomeLocalidade")
	private WebElement localidade;
	
	@FindBy(id = "txtUf")
	private WebElement estado;
	
	@FindBy(id = "txtCep")
	private WebElement cep;
	//.
	
	//Elementos Aba Itens
	@FindBy(id = "btnIncluirProduto")
	private WebElement btnIncluirProduto;
	
	@FindBy(id = "btnRemoverProduto")
	private WebElement btnRemoverProduto;
	
	@FindBy(id = "txtNumeroSerie")
	private WebElement nroSerie;
	
	@FindBy(id = "txtObservacaoItemNf")
	private WebElement obsItemNF;
	
	@FindBy(id = "txtBaseCalculoIcms")
	private WebElement baseCalculoICMS;
	
	@FindBy(id = "txtValorIcms")
	private WebElement valorICMS;
	
	@FindBy(id = "txtValorTotalIPI")
	private WebElement valorTotalIPI;
	
	@FindBy(id = "txtBaseCalculoIcmsSubst")
	private WebElement baseCalculoICMSSubst;
	
	@FindBy(id = "txtValorIcmsSubst")
	private WebElement valorICMSSubst;
	
	@FindBy(id = "txtValorTotalProdutos")
	private WebElement valorTotalProdutos;
	
	@FindBy(id = "txtValorFrete")
	private WebElement valorFrete;
	
	@FindBy(id = "txtValorSeguro")
	private WebElement valorSeguro;
	
	@FindBy(id = "txtValorOutrasDespesas")
	private WebElement valorOutrasDespesas;
	
	@FindBy(id = "txtValorTotalNota")
	private WebElement valorTotalNota;
	//.
	
	//Elementos Aba Transportador
	@FindBy(css = "#scTransportadoraNf input[type='text']")
	private WebElement transportadora;
	
	@FindBy(css = "#scTransportadoraNf input:nth(1)")
	private WebElement btnSearchTransportadora;
	
	@FindBy(css = "#scTransportadoraNf input:nth(2)")
	private WebElement btnLimparTransportadora;
	
	@FindBy(id = "txtPlacaVeiculo")
	private WebElement placaVeiculo;
	
	@FindBy(id = "cbxVeiculoUf")
	private WebElement veiculoEstado;
	
	@FindBy(id = "cbxTipoFrete")
	private WebElement tipoFrete;
	//.
	
	//Elementos Aba Outros
	@FindBy(id = "txtPesoBruto")
	private WebElement pesoBruto;
	
	@FindBy(id = "txtPesoLiquido")
	private WebElement pesoLiquido;
	
	@FindBy(id = "txtDesEspecieProduto")
	private WebElement descEspecieProduto;
	
	@FindBy(id = "txtQtdProdEspecie")
	private WebElement qtdProdutoEspecie;
	//.
	
	//Elementos Aba Dados Adicionais
	@FindBy(id = "txtObsSistema")
	private WebElement obsSistema;
	
	@FindBy(id = "txtObsUsuario")
	private WebElement obsUsuario;
	
	@FindBy(id = "txtNomeCliente")
	private WebElement nomeCliente;
	
	@FindBy(id = "txtNumeroCliente")
	private WebElement nroCliente;
	
	@FindBy(id = "txtNomeVendedor")
	private WebElement nomeVendedor;
	
	@FindBy(id = "txtNumeroVendedor")
	private WebElement nroVendedor;
	
	@FindBy(id = "txtNumeroPedido")
	private WebElement nroPedido;
	
	@FindBy(id = "txtLojaPedido")
	private WebElement lojaPedido;
	
	@FindBy(id= "txtLojaFaturamento")
	private WebElement lojaFaturamento;
	
	@FindBy(id = "txtNumeroPDV")
	private WebElement nroPdv;
	//.
	
	@FindBy(id = "btnAlterarNroNF")
	private WebElement btnAlterarNroNF;
	
	@FindBy(id = "btnEmitirEspelho")
	private WebElement btnEmitirEspelho;
	
	@FindBy(id = "btnConcluir")
	private WebElement btnConcluir;
	
	@FindBy(id = "btnCancelar")
	private WebElement btnCancelar;
	
	private ControleJanela controleJanela;
	private AguardaCarregamento agCarregamento;
	//private Mensagens msg;
	
	NotaFiscalDAO nfDAO;
	
	public EmissaoNotaFiscalAvulsaPage() {
		this.nfDAO = new NotaFiscalDAO();
		/*this.driver = driver;
		PageFactory.initElements(driver, this);
		this.controleJanela = new ControleJanela(driver);
		this.agCarregamento = new AguardaCarregamento(driver);
		this.msg = new Mensagens(this.driver);
		this.wait = new WebDriverWait(driver, 20);*/
	}
	

	public String getOperacaoNFValor() {
		return operacaoNF.getAttribute("value");
	}
	
	public WebElement getOperacaoNF() {
		return operacaoNF;
	}

	public EmissaoNotaFiscalAvulsaPage setOperacaoNF(String operacaoNF) {
		new Select(this.operacaoNF).selectByVisibleText(operacaoNF);
		return this;
	}

	public String getCodTipoNF() {
		return codTipoNF.getAttribute("value");
	}

	public EmissaoNotaFiscalAvulsaPage setCodTipoNF(String codTipoNF) {
		this.codTipoNF.clear();
		this.codTipoNF.sendKeys(codTipoNF);
		return this;
	}

	public String getDescTipoNF() {
		return descTipoNF.getAttribute("value");
	}

	public EmissaoNotaFiscalAvulsaPage setDescTipoNF(String descTipoNF) {
		this.descTipoNF.clear();
		this.descTipoNF.sendKeys(descTipoNF);
		return this;
	}

	public WebElement getBtnBuscarTiposNF() {
		return btnBuscarTiposNF;
	}

	public EmissaoNotaFiscalAvulsaPage clickBtnBuscarTiposNF() {
		this.btnBuscarTiposNF.click();
		return this;
	}

	public String getNaturezaOperacao() {
		return naturezaOperacao.getAttribute("value");
	}

	public EmissaoNotaFiscalAvulsaPage setNaturezaOperacao(String naturezaOperacao) {
		this.naturezaOperacao.clear();
		this.naturezaOperacao.sendKeys(naturezaOperacao);
		return this;
	}

	public String getGrupoEstoqueOrigem() {
		return grupoEstoqueOrigem.getAttribute("value");
	}

	public EmissaoNotaFiscalAvulsaPage setGrupoEstoqueOrigem(String grupoEstoqueOrigem) {
		new Select(this.grupoEstoqueOrigem).selectByVisibleText(grupoEstoqueOrigem);
		return this;
	}

	public String getChkAverbarNoSeguro() {
		return chkAverbarNoSeguro.getAttribute("value");
	}

	public EmissaoNotaFiscalAvulsaPage clickChkAverbarNoSeguro() {
		this.chkAverbarNoSeguro.click();
		return this;
	}

	public WebElement getBtnInformarParametros() {
		return btnInformarParametros;
	}

	public EmissaoNotaFiscalAvulsaPage clickBtnInformarParametros() {
		this.btnInformarParametros.click();
		return this;
	}

	public WebElement getAbaCabecalho() {
		return abaCabecalho;
	}

	public EmissaoNotaFiscalAvulsaPage clickAbaCabecalho() {
		this.abaCabecalho.click();
		return this;
	}

	public WebElement getAbaItens() {
		return abaItens;
	}

	public EmissaoNotaFiscalAvulsaPage clickAbaItens() {
		this.abaItens.click();
		return this;
	}

	public WebElement getAbaTransportador() {
		return abaTransportador;
	}

	public EmissaoNotaFiscalAvulsaPage clickAbaTransportador() {
		this.abaTransportador.click();
		return this;
	}

	public WebElement getAbaOutros() {
		return abaOutros;
	}

	public EmissaoNotaFiscalAvulsaPage clickAbaOutros() {
		this.abaOutros.click();
		return this;
	}

	public WebElement getAbaDados() {
		return abaDados;
	}

	public EmissaoNotaFiscalAvulsaPage clickAbaDados() {
		this.abaDados.click();
		return this;
	}

	public String getDataEmissao() {
		return dataEmissao.getAttribute("value");
	}

	public EmissaoNotaFiscalAvulsaPage setDataEmissao(String dataEmissao) {
		this.dataEmissao.clear();
		this.dataEmissao.sendKeys(dataEmissao);
		return this;
	}

	public String getDescUsuario() {
		return descUsuario.getAttribute("value");
	}

	public EmissaoNotaFiscalAvulsaPage setDescUsuario(String descUsuario) {
		this.descUsuario.clear();
		this.descUsuario.sendKeys(descUsuario);
		return this;
	}

	public String getCodUsuario() {
		return codUsuario.getAttribute("value");
	}

	public EmissaoNotaFiscalAvulsaPage setCodUsuario(String codUsuario) {
		this.codUsuario.clear();
		this.codUsuario.sendKeys(codUsuario);
		return this;
	}

	public String getNroNota() {
		return nroNota.getAttribute("value");
	}

	public EmissaoNotaFiscalAvulsaPage setNroNota(String nroNota) {
		this.nroNota.clear();
		this.nroNota.sendKeys(nroNota);
		return this;
	}

	public String getNroCupom() {
		return nroCupom.getAttribute("value");
	}

	public EmissaoNotaFiscalAvulsaPage setNroCupom(String nroCupom) {
		this.nroCupom.clear();
		this.nroCupom.sendKeys(nroCupom);
		return this;
	}

	public String getNfReferencia() {
		return nfReferencia.getAttribute("value");
	}

	public EmissaoNotaFiscalAvulsaPage setNfReferencia(String nfReferencia) {
		this.nfReferencia.clear();
		this.nfReferencia.sendKeys(nfReferencia);
		return this;
	}

	public String getNatrueza() {
		return natrueza.getAttribute("value");
	}

	public EmissaoNotaFiscalAvulsaPage setNatrueza(String natureza) {
		this.natrueza.clear();
		this.natrueza.sendKeys(natureza);
		return this;
	}

	public String getCfop() {
		return cfop.getAttribute("value");
	}

	public EmissaoNotaFiscalAvulsaPage setCfop(String cfop) {
		this.cfop.clear();
		this.cfop.sendKeys(cfop);
		return this;
	}

	public String getDataSaida() {
		return dataSaida.getAttribute("value");
	}

	public EmissaoNotaFiscalAvulsaPage setDataSaida(String dataSaida) {
		this.dataSaida.clear();
		this.dataSaida.sendKeys(dataSaida);
		return this;
	}

	public String getRazaoSocial() {
		return razaoSocial.getAttribute("value");
	}

	public EmissaoNotaFiscalAvulsaPage setRazaoSocial(String razaoSocial) {
		this.razaoSocial.clear();
		this.razaoSocial.sendKeys(razaoSocial);
		return this;
	}

	public String getCnpjCpf() {
		return cnpjCpf.getAttribute("value");
	}

	public EmissaoNotaFiscalAvulsaPage setCnpjCpf(String cnpjCpf) {
		this.cnpjCpf.clear();
		this.cnpjCpf.sendKeys(cnpjCpf);
		return this;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual.getAttribute("value");
	}

	public EmissaoNotaFiscalAvulsaPage setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual.clear();
		this.inscricaoEstadual.sendKeys(inscricaoEstadual);
		return this;
	}

	public String getDescTipoLogradouro() {
		return descTipoLogradouro.getAttribute("value");
	}

	public EmissaoNotaFiscalAvulsaPage setDescTipoLogradouro(String descTipoLogradouro) {
		this.descTipoLogradouro.clear();
		this.descTipoLogradouro.sendKeys(descTipoLogradouro);
		return this;
	}

	public String getDescLogradouro() {
		return descLogradouro.getAttribute("value");
	}

	public EmissaoNotaFiscalAvulsaPage setDescLogradouro(String descLogradouro) {
		this.descLogradouro.clear();
		this.descLogradouro.sendKeys(descLogradouro);
		return this;
	}

	public String getNroEndereco() {
		return nroEndereco.getAttribute("value");
	}

	public EmissaoNotaFiscalAvulsaPage setNroEndereco(String nroEndereco) {
		this.nroEndereco.clear();
		this.nroEndereco.sendKeys(nroEndereco);
		return this;
	}

	public String getComplementoEndereco() {
		return complementoEndereco.getAttribute("value");
	}

	public EmissaoNotaFiscalAvulsaPage setComplementoEndereco(String complementoEndereco) {
		this.complementoEndereco.clear();
		this.complementoEndereco.sendKeys(complementoEndereco);
		return this;
	}

	public String getBairro() {
		return bairro.getAttribute("value");
	}

	public EmissaoNotaFiscalAvulsaPage setBairro(String bairro) {
		this.bairro.clear();
		this.bairro.sendKeys(bairro);
		return this;
	}

	public String getLocalidade() {
		return localidade.getAttribute("value");
	}

	public EmissaoNotaFiscalAvulsaPage setLocalidade(String localidade) {
		this.localidade.clear();
		this.localidade.sendKeys(localidade);
		return this;
	}

	public String getEstado() {
		return estado.getAttribute("value");
	}

	public EmissaoNotaFiscalAvulsaPage setEstado(String estado) {
		this.estado.clear();
		this.estado.sendKeys(estado);
		return this;
	}

	public String getCep() {
		return cep.getAttribute("value");
	}

	public EmissaoNotaFiscalAvulsaPage setCep(String cep) {
		this.cep.clear();
		this.cep.sendKeys(cep);
		return this;
	}

	public WebElement getBtnIncluirProduto() {
		return btnIncluirProduto;
	}

	public EmissaoNotaFiscalAvulsaPage clickBtnIncluirProduto() {
		this.btnIncluirProduto.click();
		return this;
	}

	public WebElement getBtnRemoverProduto() {
		return btnRemoverProduto;
	}

	public EmissaoNotaFiscalAvulsaPage clickBtnRemoverProduto() {
		this.btnRemoverProduto.click();
		return this;
	}

	public String getNroSerie() {
		return nroSerie.getAttribute("value");
	}

	public EmissaoNotaFiscalAvulsaPage setNroSerie(String nroSerie) {
		this.nroSerie.clear();
		this.nroSerie.sendKeys(nroSerie);
		return this;
	}

	public String getObsIntemNF() {
		return obsItemNF.getAttribute("value");
	}

	public EmissaoNotaFiscalAvulsaPage setObsItemNF(String obsItemNF) {
		this.obsItemNF.clear();
		this.obsItemNF.sendKeys(obsItemNF);
		return this;
	}

	public String getBaseCalculoICMS() {
		return baseCalculoICMS.getAttribute("value");
	}

	public EmissaoNotaFiscalAvulsaPage setBaseCalculoICMS(String baseCalculoICMS) {
		this.baseCalculoICMS.clear();
		this.baseCalculoICMS.sendKeys(baseCalculoICMS);
		return this;
	}

	public String getValorICMS() {
		return valorICMS.getAttribute("value");
	}

	public EmissaoNotaFiscalAvulsaPage setValorICMS(String valorICMS) {
		this.valorICMS.clear();
		this.valorICMS.sendKeys(valorICMS);
		return this;
	}

	public String getValorTotalIPI() {
		return valorTotalIPI.getAttribute("value");
	}

	public EmissaoNotaFiscalAvulsaPage setValorTotalIPI(String valorTotalIPI) {
		this.valorTotalIPI.clear();
		this.valorTotalIPI.sendKeys(valorTotalIPI);
		return this;
	}

	public String getBaseCalculoICMSSubst() {
		return baseCalculoICMSSubst.getAttribute("value");
	}

	public EmissaoNotaFiscalAvulsaPage setBaseCalculoICMSSubst(String baseCalculoICMSSubst) {
		this.baseCalculoICMSSubst.clear();
		this.baseCalculoICMSSubst.sendKeys(baseCalculoICMSSubst);
		return this;
	}

	public String getValorICMSSubst() {
		return valorICMSSubst.getAttribute("value");
	}

	public EmissaoNotaFiscalAvulsaPage setValorICMSSubst(String valorICMSSubst) {
		this.valorICMSSubst.clear();
		this.valorICMSSubst.sendKeys(valorICMSSubst);
		return this;
	}

	public String getValorTotalProdutos() {
		return valorTotalProdutos.getAttribute("value");
	}

	public EmissaoNotaFiscalAvulsaPage setValorTotalProdutos(String valorTotalProdutos) {
		this.valorTotalProdutos.clear();
		this.valorTotalProdutos.sendKeys(valorTotalProdutos);
		return this;
	}

	public String getValorFrete() {
		return valorFrete.getAttribute("value");
	}

	public EmissaoNotaFiscalAvulsaPage setValorFrete(String valorFrete) {
		this.valorFrete.clear();
		this.valorFrete.sendKeys(valorFrete);
		return this;
	}

	public String getValorSeguro() {
		return valorSeguro.getAttribute("value");
	}

	public EmissaoNotaFiscalAvulsaPage setValorSeguro(String valorSeguro) {
		this.valorSeguro.clear();
		this.valorSeguro.sendKeys(valorSeguro);
		return this;
	}

	public String getValorOutrasDespesas() {
		return valorOutrasDespesas.getAttribute("value");
	}

	public EmissaoNotaFiscalAvulsaPage setValorOutrasDespesas(String valorOutrasDespesas) {
		this.valorOutrasDespesas.clear();
		this.valorOutrasDespesas.sendKeys(valorOutrasDespesas);
		return this;
	}

	public String getValorTotalNota() {
		return valorTotalNota.getAttribute("value");
	}

	public EmissaoNotaFiscalAvulsaPage setValorTotalNota(String valorTotalNota) {
		this.valorTotalNota.clear();
		this.valorTotalNota.sendKeys(valorTotalNota);
		return this;
	}

	public String getTransportadora() {
		return transportadora.getAttribute("value");
	}

	public EmissaoNotaFiscalAvulsaPage setTransportadora(String transportadora) {
		this.transportadora.clear();
		this.transportadora.sendKeys(transportadora);
		return this;
	}

	public WebElement getBtnSearchTransportadora() {
		return btnSearchTransportadora;
	}

	public EmissaoNotaFiscalAvulsaPage clickBtnSearchTransportadora() {
		this.btnSearchTransportadora.click();
		return this;
	}

	public WebElement getBtnLimparTransportadora() {
		return btnLimparTransportadora;
	}

	public EmissaoNotaFiscalAvulsaPage clickBtnLimparTransportadora() {
		this.btnLimparTransportadora.click();
		return this;
	}

	public String getPlacaVeiculo() {
		return placaVeiculo.getAttribute("value");
	}

	public EmissaoNotaFiscalAvulsaPage setPlacaVeiculo(String placaVeiculo) {
		this.placaVeiculo.clear();
		this.placaVeiculo.sendKeys(placaVeiculo);
		return this;
	}

	public String getVeiculoEstado() {
		return veiculoEstado.getAttribute("value");
	}

	public EmissaoNotaFiscalAvulsaPage setVeiculoEstado(String veiculoEstado) {
		new Select(this.veiculoEstado).selectByVisibleText(veiculoEstado);
		return this;
	}

	public String getTipoFrete() {
		return tipoFrete.getAttribute("value");
	}

	public EmissaoNotaFiscalAvulsaPage setTipoFrete(String tipoFrete) {
		new Select(this.tipoFrete).selectByVisibleText(tipoFrete);
		return this;
	}

	public String getPesoBruto() {
		return pesoBruto.getAttribute("value");
	}

	public EmissaoNotaFiscalAvulsaPage setPesoBruto(String pesoBruto) {
		this.pesoBruto.clear();
		this.pesoBruto.sendKeys(pesoBruto);
		return this;
	}

	public String getPesoLiquido() {
		return pesoLiquido.getAttribute("value");
	}

	public EmissaoNotaFiscalAvulsaPage setPesoLiquido(String pesoLiquido) {
		this.pesoLiquido.clear();
		this.pesoLiquido.sendKeys(pesoLiquido);
		return this;
	}

	public String getDescEspecieProduto() {
		return descEspecieProduto.getAttribute("value");
	}

	public EmissaoNotaFiscalAvulsaPage setDescEspecieProduto(String descEspecieProduto) {
		this.descEspecieProduto.sendKeys(descEspecieProduto);
		return this;
	}

	public String getQtdProdutoEspecie() {
		return qtdProdutoEspecie.getAttribute("value");
	}

	public EmissaoNotaFiscalAvulsaPage setQtdProdutoEspecie(String qtdProdutoEspecie) {
		this.qtdProdutoEspecie.clear();
		this.qtdProdutoEspecie.sendKeys(qtdProdutoEspecie);
		return this;
	}

	public String getObsSistema() {
		return obsSistema.getAttribute("value");
	}

	public EmissaoNotaFiscalAvulsaPage setObsSistema(String obsSistema) {
		this.obsSistema.clear();
		this.obsSistema.sendKeys(obsSistema);
		return this;
	}

	public String getObsUsuario() {
		return obsUsuario.getAttribute("value");
	}

	public EmissaoNotaFiscalAvulsaPage setObsUsuario(String obsUsuario) {
		this.obsUsuario.clear();
		this.obsUsuario.sendKeys(obsUsuario);
		return this;
	}

	public String getNomeCliente() {
		return nomeCliente.getAttribute("value");
	}

	public EmissaoNotaFiscalAvulsaPage setNomeCliente(String nomeCliente) {
		this.nomeCliente.clear();
		this.nomeCliente.sendKeys(nomeCliente);
		return this;
	}

	public String getNroCliente() {
		return nroCliente.getAttribute("value");
	}

	public EmissaoNotaFiscalAvulsaPage setNroCliente(String nroCliente) {
		this.nroCliente.clear();
		this.nroCliente.sendKeys(nroCliente);
		return this;
	}

	public String getNomeVendedor() {
		return nomeVendedor.getAttribute("value");
	}

	public EmissaoNotaFiscalAvulsaPage setNomeVendedor(String nomeVendedor) {
		this.nomeVendedor.clear();
		this.nomeVendedor.sendKeys(nomeVendedor);
		return this;
	}

	public String getNroVendedor() {
		return nroVendedor.getAttribute("value");
	}

	public EmissaoNotaFiscalAvulsaPage setNroVendedor(String nroVendedor) {
		this.nroVendedor.clear();
		this.nroVendedor.sendKeys(nroVendedor);
		return this;
	}

	public String getNroPedido() {
		return nroPedido.getAttribute("value");
	}

	public EmissaoNotaFiscalAvulsaPage setNroPedido(String nroPedido) {
		this.nroPedido.clear();
		this.nroPedido.sendKeys(nroPedido);
		return this;
	}

	public String getLojaPedido() {
		return lojaPedido.getAttribute("value");
	}

	public EmissaoNotaFiscalAvulsaPage setLojaPedido(String lojaPedido) {
		this.lojaPedido.clear();
		this.lojaPedido.sendKeys(lojaPedido);
		return this;
	}

	public String getLojaFaturamento() {
		return lojaFaturamento.getAttribute("value");
	}

	public EmissaoNotaFiscalAvulsaPage setLojaFaturamento(String lojaFaturamento) {
		this.lojaFaturamento.clear();
		this.lojaFaturamento.sendKeys(lojaFaturamento);
		return this;
	}

	public String getNroPdv() {
		return nroPdv.getAttribute("value");
	}

	public EmissaoNotaFiscalAvulsaPage setNroPdv(String nroPdv) {
		this.nroPdv.clear();
		this.nroPdv.sendKeys(nroPdv);
		return this;
	}

	public WebElement getBtnAlterarNroNF() {
		return btnAlterarNroNF;
	}

	public EmissaoNotaFiscalAvulsaPage clickBtnAlterarNroNF() {
		this.btnAlterarNroNF.click();
		return this;
	}

	public WebElement getBtnEmitirEspelho() {
		return btnEmitirEspelho;
	}

	public EmissaoNotaFiscalAvulsaPage clickBtnEmitirEspelho() {
		this.btnEmitirEspelho.click();
		return this;
	}

	public WebElement getBtnConcluir() {
		return btnConcluir;
	}

	public EmissaoNotaFiscalAvulsaPage clickBtnConcluir() {
		this.btnConcluir.click();
		return this;
	}

	public WebElement getBtnCancelar() {
		return btnCancelar;
	}

	public EmissaoNotaFiscalAvulsaPage clickBtnCancelar() {
		this.btnCancelar.click();
		return this;
	}

	public void setNroNotaSessao(String tipoNFAvulsa) {
		// Pegar nroNotadoBanco
		String nroLoja = (String) Serenity.sessionVariableCalled(COD_NRO_LOJA);
		String nroPedido = (String) Serenity.sessionVariableCalled(NRO_PEDIDO);
		
		String nroNFAvulsa = Integer.toString(nfDAO.getNotaFiscal(nroLoja, nroPedido, tipoNFAvulsa).getNroNf());
		
		System.out.println("nroNFAvulsa: " + nroNFAvulsa);
		
		Serenity.setSessionVariable(NRO_NF_AVULSA).to(nroNFAvulsa);
	}
}