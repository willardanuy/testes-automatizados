package br.com.mv.steps;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import br.com.mv.pages.RotaPage;
import br.com.mv.pages.RoteiroPage;
import br.com.mv.pages.SequenciaEmpenhoPage;
import br.com.mv.pages.ToolbarPage;
import br.com.mv.utils.AguardaCarregamento;
import net.thucydides.core.annotations.Steps;

public class RoteirizacaoSteps {

	@Steps
	RotaPage rota;
	RoteiroPage roteiro;
	SequenciaEmpenhoPage sequenciaEmpenho;
	
	ToolbarPage toolbar;
	AguardaCarregamento aguardarCarregamento;
	
	@When("Eu removo a rota $nroRota")
	public void euRemovoRota(String nroRota) throws InterruptedException {
		rota.removerRota(nroRota);
	}
	
	@When("Eu clico no botao nova rota")
	public void euClicoBotaoNovaRota() throws InterruptedException {
		toolbar.clickNovo();
	}
	
	@When("Eu informo a base $codBase")
	public void euInformoBase(String codBase) throws InterruptedException {
		rota.setBase(codBase);
	}
	
	@When("Eu informo a rota $nroRota")
	public void euInformoRota(String nroRota) throws InterruptedException {
		rota.setRota(nroRota);
	}
	
	@When("Eu informo o nro loja de refaturamento $codNroLoja")
	public void euInformoNroLojaFaturamento(String codNroLoja) throws InterruptedException {
		rota.setLojaRefaturamento(codNroLoja);
	}
	
	@When("Eu informo o nro loja de abastecimento $codNroLoja")
	public void euInformoNroLojaAbastecimento(String codNroLoja) throws InterruptedException {
		rota.setLojaAbastecimento(codNroLoja);
	}
	
	@When("Eu informo a empresa base $empresaBase")
	public void euInformoEmpresaBase(String empresaBase) throws InterruptedException {
		rota.setEmpresaBase(empresaBase);
	}
	
	@When("Eu removo o roteiro")
	public void euRemovoRoteiro() throws InterruptedException {
		roteiro.removerRoteiro();
	}
	
	@When("Eu clico no botao novo roteiro")
	public void euClicoBotaoNovoRoteiro() throws InterruptedException {
		roteiro.clickNovo();
		aguardarCarregamento.aguardarCarregamentoNovaArquitetura();
	}
	
	@When("Eu informo o codigo loja $codNroLoja do roteiro")
	public void euInformoCodigoLojaRoteiro(String codNroLoja) throws InterruptedException {
		roteiro.setCodLoja(codNroLoja);
	}
	
	@When("Eu informo o uf $uf do roteiro")
	public void euInformoUFRoteiro(String uf) throws InterruptedException {
		roteiro.setUf(uf);
		aguardarCarregamento.aguardarCarregamentoNovaArquitetura();
	}
	
	@When("Eu informo a cidade $cidade do roteiro")
	public void euInformoCidadeRoteiro(String cidade) throws InterruptedException {
		Thread.sleep(3000);
		roteiro.setCidade(cidade);
	}
	
	@When("Eu informo no roteiro a rota $rota")
	public void euInformoRotaRoteiro(String rota) throws InterruptedException {
		aguardarCarregamento.aguardarCarregamentoNovaArquitetura();
		Thread.sleep(4000);
		roteiro.setRota(rota);
	}
	
	@When("Eu informo a sequencia $sequencia do roteiro")
	public void euInformoSequenciaRoteiro(String sequencia) throws InterruptedException {
		aguardarCarregamento.aguardarCarregamentoNovaArquitetura();
		Thread.sleep(3000);
		roteiro.setSequencia(sequencia);
	}
	
	@When("Eu informo a data de intervalo $dtInvervalo do roteiro")
	public void euInformoDataIntervaloRoteiro(String dtIntervalo) throws InterruptedException {
		aguardarCarregamento.aguardarCarregamentoNovaArquitetura();
		Thread.sleep(3000);
		roteiro.setDtIntervalo(dtIntervalo);
	}
	
	@When("Eu informo a quantidade dias $qtdeDiasEntrega do roteiro para entrega")
	public void euInformoQuantidadeDiasEntrega(String qtdeDiasEntrega) throws InterruptedException {
		roteiro.setQtdeDiasEntrega(qtdeDiasEntrega);
	}
	
	@When("Eu informo a origem $origem do roteiro")
	public void euInformoOrigemRoteiro(String origem) throws InterruptedException {
		roteiro.setOrigem(origem);
	}
	
	@When("Eu informo no roteiro a empresa base $empresaBase")
	public void euInformoRoteiroEmpresaBase(String empresaBase) throws InterruptedException {
		roteiro.setEmpresaBase(empresaBase);
	}
	
	@When("Eu clico no filtro adicional do roteiro")
	public void euClicoFiltroAdicional() throws InterruptedException {
		roteiro.clickFiltroAdicional();
	}
	
	@When("Eu clico no filtro todos os bairros do roteiro")
	public void euClicoFiltroTodosBairros() throws InterruptedException {
		Thread.sleep(5000);
		roteiro.setTodosBairros();
	}
	
	@When("Eu informo o bairro $bairro do roteiro")
	public void euInformoBairroRoteiro(String bairro) throws InterruptedException {
		Thread.sleep(5000);
		roteiro.setBairro(bairro);
	}
	
	@When("Eu clico no salvar roteiro")
	public void euClicoBotaoSalvarRoteiro() throws InterruptedException {
		roteiro.clickSalvar();
	}
	
	@When("Eu removo a sequencia de empenho")
	public void euRemovoSequenciaEmpenho() throws InterruptedException {
		sequenciaEmpenho.removerSequenciaEmpenho();
	}
	
	@When("Eu clico no botao nova sequencia de empenho")
	public void euClicoBotaoNovaSequenciaEmpenho() throws InterruptedException {
		toolbar.clickNovo();
	}
	
	@When("Eu informo a sequencia $seqEmpenho da sequencia de empenho")
	public void euClicoBotaoNovaSequenciaEmpenho(String seqEmpenho) throws InterruptedException {
		sequenciaEmpenho.setSequencia(seqEmpenho);
	}
	
	@When("Eu informo o nro loja de sequencia de empenho $codNroLoja")
	public void euInformoLojaSequenciaEmpenho(String codNroLoja) throws InterruptedException {
		sequenciaEmpenho.setLojaEmpenho(codNroLoja);
	}
	
	@When("Eu informo na tela sequencia de empenho a empresa base $empresa")
	public void euInformoTelaSequenciaEmpenhoEmpresaBase(String empresa) throws InterruptedException {
		sequenciaEmpenho.setEmpresaBase(empresa);
	}
	
	@When("Eu informo a data inicio da validade da sequencia de empenho $dtInicio")
	public void euInformoDataInicioSequenciaEmpenho(String dtInicio) throws InterruptedException {
		sequenciaEmpenho.setDtInicio(dtInicio);
	}
	
	@When("Eu informo a data fim da validade da sequencia de empenho $dtFim")
	public void euInformoDataFimSequenciaEmpenho(String dtFim) throws InterruptedException {
		sequenciaEmpenho.setDtFim(dtFim);
	}
	
	@When("Eu clico salvar sequencia de empenho")
	public void euClicoSalvarSeqEmpenho() throws InterruptedException {
		toolbar.clickSalvar();
	}
	
	@Then("Eu valido mensagem de sucesso da sequencia de empenho")
	public void euValidoMensagemCadastroSeqEmpenho() throws InterruptedException {
		sequenciaEmpenho.validarMensagemCadastro();
	}
	
	@Then("Eu valido mensagem de sucesso do roteiro")
	public void euValidoMensagemCadastroRoteiro() throws InterruptedException {
		roteiro.validarMensagemCadastro();
	}
}