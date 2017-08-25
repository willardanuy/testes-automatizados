package br.com.mv.pages;

import static br.com.mv.model.SessionVariables.NRO_PEDIDO;
import static br.com.mv.model.SessionVariables.NRO_PRE_RECIBO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.mv.utils.AguardaCarregamento;
import br.com.mv.utils.ControleMenu;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.pages.PageObject;

public class PopupCadastroSolicitacaoTDPage extends PageObject {

	@FindBy(id = "txtEmpresa")
	private WebElement empresa;
	
	@FindBy(id = "txtNroPedido")
	private WebElement pedido;
	
	@FindBy(id = "txtNroLojaPedido")
	private WebElement loja;
	
	@FindBy(id = "txtProcesso")
	private WebElement processo;
	
	@FindBy(id = "txtNumeroPreRecibo")
	private WebElement nroPreRecibo;
	
	@FindBy(id = "txtSituacaoPreRecibo")
	private WebElement situacaoPreRecibo;
	
	@FindBy(id = "txtValorPreRecibo")
	private WebElement valorPreRecibo;
	
	@FindBy(id = "btnSalvar")
	private WebElement btnSalvar;
	
	@FindBy(id = "btnCacelar")
	private WebElement btnCancelar;
	
	@FindBy(id = "btnMotivoProduto")
	private WebElement btnMotivoProduto;
	
	@FindBy(id = "btnMotivoServico")
	private WebElement btnMotivoServico;
	
	private ControleMenu menu;
	private AguardaCarregamento agCarregamento;
	
	public PopupCadastroSolicitacaoTDPage(WebDriver driver) {
		/*this.driver = driver;
		PageFactory.initElements(driver, this);
		
		controleJanela = new ControleJanela(driver);
		this.menu = new ControleMenu(driver);
		this.agCarregamento = new AguardaCarregamento(driver);
		this.wait = new WebDriverWait(driver, 20);*/
	}
	
	public String getEmpresa() {
		return empresa.getAttribute("value");
	}

	public PopupCadastroSolicitacaoTDPage setEmpresa(String empresa) {
		this.empresa.clear();
		this.empresa.sendKeys(empresa);
		return this;
	}

	public String getPedido() {
		return pedido.getAttribute("value");
	}

	public PopupCadastroSolicitacaoTDPage setPedido(String pedido) {
		this.pedido.clear();
		this.pedido.sendKeys(pedido);
		return this;
	}

	public String getLoja() {
		return loja.getAttribute("value");
	}

	public PopupCadastroSolicitacaoTDPage setLoja(String loja) {
		this.loja.clear();
		this.loja.sendKeys(loja);
		return this;
	}

	public String getProcesso() {
		return processo.getAttribute("value");
	}

	public PopupCadastroSolicitacaoTDPage setProcesso(String processo) {
		this.processo.clear();
		this.processo.sendKeys(processo);
		return this;
	}

	public String getNroPreRecibo() {
		return nroPreRecibo.getAttribute("value");
	}

	public PopupCadastroSolicitacaoTDPage setNroPreRecibo(String nroPreRecibo) {
		this.nroPreRecibo.clear();
		this.nroPreRecibo.sendKeys(nroPreRecibo);
		return this;
	}

	public String getSituacaoPreRecibo() {
		return situacaoPreRecibo.getAttribute("value");
	}

	public PopupCadastroSolicitacaoTDPage setSituacaoPreRecibo(String situacaoPreRecibo) {
		this.situacaoPreRecibo.clear();
		this.situacaoPreRecibo.sendKeys(situacaoPreRecibo);
		return this;
	}

	public String getValorPreRecibo() {
		return valorPreRecibo.getAttribute("value");
	}

	public PopupCadastroSolicitacaoTDPage setValorPreRecibo(String valorPreRecibo) {
		this.valorPreRecibo.clear();
		this.valorPreRecibo.sendKeys(valorPreRecibo);
		return this;
	}

	public WebElement getBtnSalvar() {
		return btnSalvar;
	}

	public PopupCadastroSolicitacaoTDPage clickBtnSalvar() {
		
		String nroPreRecibo = this.getNroPreRecibo();
		
		Serenity.setSessionVariable(NRO_PRE_RECIBO).to(nroPreRecibo.trim());
		
		this.btnSalvar.click();
		
		this.waitFor(ExpectedConditions.alertIsPresent());
		this.getAlert().accept();
		
		this.waitFor(ExpectedConditions.alertIsPresent());
		this.getAlert().accept();
		
		return this;
	}

	public WebElement getBtnCancelar() {
		return btnCancelar;
	}

	public PopupCadastroSolicitacaoTDPage clickBtnCancelar() {
		this.btnCancelar.click();
		return this;
	}

	public WebElement getBtnMotivoProduto() {
		return btnMotivoProduto;
	}

	public PopupCadastroSolicitacaoTDPage clickBtnMotivoProduto() {
		this.btnMotivoProduto.click();
		return this;
	}

	public WebElement getBtnMotivoServico() {
		return btnMotivoServico;
	}

	public PopupCadastroSolicitacaoTDPage clickBtnMotivoServico() {
		this.btnMotivoServico.click();
		return this;
	}

	public PopupCadastroSolicitacaoTDPage selecionarProduto(String produto) {
		$("//table[@id='tableProdutos:tContent']/tbody/tr/td[text()='" + produto + "']/parent::tr/td[2]").click();
		return this;
	}
	
	public PopupCadastroSolicitacaoTDPage selecionarServico(String servico) {
		$("//table[@id='tableServicos:tContent']/tbody/tr/td[text()='" + servico + "']/parent::tr/td[3]").click();
		return this;
	}
	
	/**
	 * Informa um motivo de troca/devolução ao produto de forma aleatória
	 * @param produtos, Lista do tipo Produto com todos os produtos contidos no pedido
	 * @throws InterruptedException
	 * @throws SQLException
	 */
	/*public void informarMotivoProduto(List<Produto> produtos, int lojaLogada, int pedido, int lojaPedido, int fluxo, int nroMotivoTrocaDevol) throws InterruptedException, SQLException {
		
		PopupVinculoMotivoProdutoTD vinculoMotivoProduto = new PopupVinculoMotivoProdutoTD(driver);
		PopupTextarea textArea = new PopupTextarea(driver);
		MotivoAprovacaoTrocadevolDAO motivoDAO = new MotivoAprovacaoTrocadevolDAO();
		List<MotivoAprovacaoTrocadevol> motivos = new ArrayList<MotivoAprovacaoTrocadevol>();
		
		for (Produto prod : produtos) {
			
			//popup cadastro solicitação TD
			System.out.println(prod.getDescProduto());
			
			selecionarProduto(prod.getDescProduto());
			controleJanela.abrirPopupClick(getBtnMotivoProduto());
			
			motivos = motivoDAO.getMotivos(lojaLogada, pedido, lojaPedido, prod.getNroItemPedidoProduto(), fluxo);
			String motivo = selecionarMotivo(motivos, nroMotivoTrocaDevol);
			System.out.println(motivo);
			Thread.sleep(1000);
			
			//popup vinculo motivo produto
			vinculoMotivoProduto.setMotivo(motivo.trim());
			controleJanela.abrirPopupClick(vinculoMotivoProduto.getBtnSearchFieldObs());
			
			//popup textarea
			textArea.setTextArea("Troca teste");
			controleJanela.fecharJanela(textArea.getBtnOk());
			
			//popup vinculo motivo produto
			controleJanela.fecharJanela(vinculoMotivoProduto.getBtnConcluir());
		}
	}*/
	
	/**
	 * Informa um motivo de Troca/Devolução para os serviços existente do pedido que necessite de um motivo
	 * @param servicos, Lista do tipo Servico, com todos os serviços existentes no pedido que necessitam de um motivo
	 * @throws InterruptedException
	 */
	/*public void informarMotivoServico(List<Servico> servicos, String motivo, String obs) throws InterruptedException {
		
		PopupSolicitacaoAprovacaoServico aprovacaoServico = new PopupSolicitacaoAprovacaoServico(driver);
		
		for (Servico serv : servicos) {

			if (serv.getFlagDevolucao().equalsIgnoreCase("N")) {
				//popup cadastro solicitação TD
				selecionarServico(serv.getDescServico());
				controleJanela.abrirPopupClick(getBtnMotivoServico());
				
				//popup solicitação aprovação serviço
				aprovacaoServico.setMotivo(motivo).setObservacao(obs);
				controleJanela.fecharJanela(aprovacaoServico.getBtnConcluir());
			}
			
		}
		
	}*/
	
	/**
	 * Recebe todos os motivos para troca/devolução de um produto e seleciona um motivo aleatório, que não seja jurídico
	 * @param motivos, Lista do tipo Motivo, com todos os motivos para Troca/Devolução
	 * @return motivo, String com o motivo selecionado aleatoriamente 'nro_motivo' - 'desc_motivo'. Ex.: '1 - Serviço Inativo'
	 */
	/*public String selecionarMotivo(List<MotivoAprovacaoTrocadevol> motivos, int nroMotivoTrocaDevol) {
		
		int nroMotivo = 0;
		String descMotivo = "";
		
		if (nroMotivoTrocaDevol == 0) {
			Random random = new Random();
			boolean motivoEncontrado = false;
			int n = 0;
			
			while (!motivoEncontrado) {
				n = random.nextInt(motivos.size());
				descMotivo = motivos.get(n).getDescMotivoFluxoAprovacao().trim();
				if (!descMotivo.startsWith("JURIDICO") && !descMotivo.startsWith("CRC")) {
					motivoEncontrado = true;
				}
			}
			
			nroMotivo = motivos.get(n).getNroMotivoFluxoAprovacao();
			
		} else {
			for (MotivoAprovacaoTrocadevol motivo : motivos) {
				nroMotivo = motivo.getNroMotivoFluxoAprovacao();
				
				if (nroMotivo == nroMotivoTrocaDevol) {
					descMotivo = motivo.getDescMotivoFluxoAprovacao();
					
					break;
				}
				
			}
		}
			
		return Integer.toString(nroMotivo) + " - " + descMotivo;
		
	}*/
	
	/*public void validarRegra(int nroMotivoFluxoAprovacao, int nroLoja, int nroPedido, int nroUsuario) throws InterruptedException {
		
		PopupPreRecibo preRecibo = new PopupPreRecibo(driver);
		
		if (nroMotivoFluxoAprovacao == 404) {
			// Regra: 4-ALERTAR_AUTOMATICAMENTE_PDVS_REC_DEV_PENDENTE - Processo: Troca
			System.out.println("Validando regra: 4-ALERTAR_AUTOMATICAMENTE_PDVS_REC_DEV_PENDENTE");
			
			boolean existePreRecibo = new PreReciboDAO().existePreReciboPendenteEmissaoRecibo(nroLoja, nroPedido);
			
			Assert.assertEquals("Pré-recibo não disponível para emissão de recibo.", true, existePreRecibo);
				
			System.out.println("Regra: 4-ALERTAR_AUTOMATICAMENTE_PDVS_REC_DEV_PENDENTE validada com sucesso!");
			
		} else if (nroMotivoFluxoAprovacao == 405) {
			// Regra: 1-PERMITE_GERAR_CONTROLE_FATURAMENTO_DEV_APOS_APROVACAO_FLUXO - Processo: Troca

			System.out.println("Regra: 1-PERMITE_GERAR_CONTROLE_FATURAMENTO_DEV_APOS_APROVACAO_FLUXO validada com sucesso!");
			
		} else if (nroMotivoFluxoAprovacao == 406) {
			// Regra: 5-EXIGE_APROVACAO_FINANCEIRO - Processo: Devolução
			System.out.println("Validando regra: 5-EXIGE_APROVACAO_FINANCEIRO");
			
			boolean existePrivilegioUsuario = new UsuarioDAO().existePrivilegioUsuario(nroUsuario, nroMotivoFluxoAprovacao);
			
			Assert.assertEquals("O usuário não tem permissão para aprovar a regra 5-EXIGE_APROVACAO_FINANCEIRO.", true, existePrivilegioUsuario);
			
			System.out.println("Regra: 5-EXIGE_APROVACAO_FINANCEIRO validada com sucesso!");
			
		} else if (nroMotivoFluxoAprovacao == 407) {
			// Regra: 6-APROVA_REVERSAO_AUTOMATICO - Processo: Devolução
			System.out.println("Validando regra: 6-APROVA_REVERSAO_AUTOMATICO");
			
			boolean existePrivilegioUsuario = new UsuarioDAO().existePrivilegioUsuario(nroUsuario, nroMotivoFluxoAprovacao);
			
			Assert.assertEquals("O usuário não tem permissão para aprovar a regra 6-APROVA_REVERSAO_AUTOMATICO.", true, existePrivilegioUsuario);
			Assert.assertEquals("REVERSÃO APROVADA", preRecibo.getSituacaoReversao());
			Assert.assertEquals(false, preRecibo.btnAprovReversaoHabilitado());
			Assert.assertEquals(false, preRecibo.btnReprovReversaoHabilitado());
			
			System.out.println("Regra: 6-APROVA_REVERSAO_AUTOMATICO validada com sucesso!");
			
		} else if (nroMotivoFluxoAprovacao == 410) {
			// Regra: 7-TROCA_SOMENTE_FATURADO - Processo: Troca
			System.out.println("Validando regra: 7-TROCA_SOMENTE_FATURADO");
			
			wait.until(ExpectedConditions.alertIsPresent());
			String text = driver.switchTo().alert().getText();
			
			// 53 = Cartao Credito, 7 = Regra
			new TipoVendaRegraTrocaDevolucaoDAO().excluirTipoVendaRegraTrocaDevolucao(53, 7);
			
			Assert.assertTrue("A mensagem de proibição de troca para produtos não faturados não foi encontrada.", "Não é permitido a troca de produtos não faturados para o tipo de venda: 'Cartao de credito'.".equals(text));
			
			System.out.println("Regra: 7-TROCA_SOMENTE_FATURADO validada com sucesso!");
			
			System.exit(0);
			
		} else if (nroMotivoFluxoAprovacao == 412) {
			// Regra: 9-APROVA_ATD_PRODUTO_NAO_FATURADO - Processo: Troca
			System.out.println("Regra: 9-APROVA_ATD_PRODUTO_NAO_FATURADO validada com sucesso!");
			
			System.exit(0);
			
		} else if (nroMotivoFluxoAprovacao == 411) {
			// Regra: 8-NAO_PERMITE_DEVOLUCAO - Processo: Devolução
			System.out.println("Validando regra: 8-NAO_PERMITE_DEVOLUCAO");
			
			wait.until(ExpectedConditions.alertIsPresent());
			String text = driver.switchTo().alert().getText();
			
			// 1 = A Vista, 8 = Regra
			new TipoVendaRegraTrocaDevolucaoDAO().excluirTipoVendaRegraTrocaDevolucao(1, 8);
			
			Assert.assertTrue("A mensagem de proibição de devolução não foi encontrada.", "Não é permitida a devolução para o tipo de venda: 'A Vista'.".equals(text));
			
			System.out.println("Regra: 8-NAO_PERMITE_DEVOLUCAO validada com sucesso!");
			
			System.exit(0);
		}
	}*/

}
