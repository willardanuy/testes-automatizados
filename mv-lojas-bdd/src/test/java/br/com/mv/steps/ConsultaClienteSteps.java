package br.com.mv.steps;
import org.jbehave.core.annotations.When;

import br.com.mv.pages.ConsultaClientePage;
import net.thucydides.core.annotations.Steps;

public class ConsultaClienteSteps {

	@Steps
	ConsultaClientePage consultaCliente; 

	/**
	 * Pesquisa um cliente atraves do cpf
	 * 
	 * @param cpf
	 * @throws InterruptedException 
	 */
	@When("Eu pesquiso o cpf $cpf")
    public void iSearchForCpf(String cpf) throws InterruptedException {
		
		consultaCliente.consultarCpf(cpf);
    }
	
	/**
	 * Pesquisa um cliente atraves do cnpj
	 * 
	 * @param cnpj
	 * @throws InterruptedException 
	 */
	@When("Eu pesquiso o cnpj $cnpj")
    public void iSearchForCnpj(String cnpj) throws InterruptedException {
		
		consultaCliente.consultarCnpj(cnpj);
    }
	
	/**
	 * Efetua o clique em um botão 'x' na tela de pesquisa do cliente
	 * 
	 * @param nomeBotao
	 * @throws InterruptedException
	 */
	@When("Eu clico no botao '$nomeBotao'")
    public void euClicoNoBotao(String nomeBotao) throws InterruptedException {
		Thread.sleep(1000);

		consultaCliente.clicarNoBotao(nomeBotao);
		Thread.sleep(1000);

    }
}
