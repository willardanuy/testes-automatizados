package br.com.mv.steps;
import java.io.File;
import java.util.Map;

import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxProfile;

import br.com.mv.pages.HomePage;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class LoginSteps {

	@Steps
	HomePage home;
	//Pages pages;
	
	@BeforeScenario
	public void setupProfile() {
		
		//File pathToBinary = new File("C:\\Program Files (x86)\\Mozilla FirefoxMV\\");
		
		System.out.println("Meu profile setado!! S2");
		FirefoxProfile myProfile = new FirefoxProfile();
		// Evita a abertura de alert (Bloquear janela de confirmação!) 
		myProfile.setPreference("dom.successive_dialog_time_limit", 0);
		myProfile.setAlwaysLoadNoFocusLib(true);
		myProfile.setEnableNativeEvents(true);
		Serenity.useFirefoxProfile(myProfile);
	}
	
	/**
	 * Endereço da instância. Ex: http://10.41.0.100:8080
	 * 
	 * @param url
	 */
	@Given("Eu acesso a instancia $url")
    public void iAccess(String url) {
		
		String urlInstancia = "";
		
		Map<String, String> metadata = HomePage.getTags();
		
		System.out.println("meta: " + metadata);
		
		// A URL padrão se encontra dentro do arquivo serenity.properties, config.: webdriver.base.url
		if (url.equals("padrao")) {
			String urlHomologacao = "";
			
			EnvironmentVariables variaveisAmbiente = SystemEnvironmentVariables.createEnvironmentVariables();
			
			String urlPadraoPedidosRELOH = variaveisAmbiente.getProperty("mvlojas.urlPadraoHomologacaoPedidosRELOH");
			String urlPadraoPedidosMVSH = variaveisAmbiente.getProperty("mvlojas.urlPadraoHomologacaoPedidosMVSH");
			
			String urlPadraoAdmCDRELOH = variaveisAmbiente.getProperty("mvlojas.urlPadraoHomologacaoAdmCDRELOH");
			String urlPadraoAdmCDMVSH = variaveisAmbiente.getProperty("mvlojas.urlPadraoHomologacaoAdmCDMVSH");
			
			if (metadata.get("grupoInstancias").equals("Pedidos")) {
				
				urlHomologacao = urlPadraoPedidosRELOH;
				
				if (metadata.get("base").equals("MVSH")) {
					urlHomologacao = urlPadraoPedidosMVSH;
				}
				
			} else if (metadata.get("grupoInstancias").equals("AdmCD")) {
				
				urlHomologacao = urlPadraoAdmCDRELOH;
				
				if (metadata.get("base").equals("MVSH")) {
					urlHomologacao = urlPadraoAdmCDMVSH;
				}
			}
			
			//urlInstancia = SystemEnvironmentVariables.createEnvironmentVariables().getProperty(ThucydidesSystemProperty.WEBDRIVER_BASE_URL);
			//urlInstancia = "http://10.30.232.20:8080/lojas/seguranca?action=login";
			
			urlInstancia = urlHomologacao + "/lojas/seguranca?action=login";
			
			System.out.println("urlPadrao: " + urlInstancia);
			
		} else if (url.equals("padraoProducao")) {
			String urlProducao = SystemEnvironmentVariables.createEnvironmentVariables().getProperty("mvlojas.urlProducao");
			
			System.out.println("UrlProducao: " + urlProducao);
			
			urlInstancia = urlProducao + "/lojas/seguranca?action=login";
			
		} else {
			
			urlInstancia = url + "/lojas/seguranca?action=login";
		}
		
		//pages.setDefaultBaseUrl(urlInstancia);
		
		home.setDefaultBaseUrl(urlInstancia);
		home.open();
		
		//home.setUrlInstancia(urlInstancia);
    }
	
	/**
	 * Endereço da instância PDV WEB.
	 * 
	 * @param url
	 */
	@Given("Eu acesso o pdv web $url")
    public void euAcessoPDVWeb(String url) {
		
		Boolean receberPedido = Boolean.parseBoolean(SystemEnvironmentVariables.createEnvironmentVariables().getProperty("mvlojas.receber.pedido"));
		Map<String, String> metadata = HomePage.getTags();
		
		if (receberPedido) {
			
			String urlInstancia = "";
			
			// A URL padrão se encontra dentro do arquivo serenity.properties, config.: webdriver.base.url
			if (url.equals("padrao")) {
				
				String urlHomologacao = "";
				
				EnvironmentVariables variaveisAmbiente = SystemEnvironmentVariables.createEnvironmentVariables();
				
				String urlPadraoCaixaRELOH = variaveisAmbiente.getProperty("mvlojas.urlPadraoHomologacaoCaixaRELOH"); // v56
				String urlPadraoCaixaMVSH = variaveisAmbiente.getProperty("mvlojas.urlPadraoHomologacaoCaixaMVSH"); // v56
				
				urlHomologacao = urlPadraoCaixaRELOH;
				
				if (metadata.get("base").equals("MVSH")) {
					urlHomologacao = urlPadraoCaixaMVSH;
				}
				
				urlInstancia = urlHomologacao + "/mv-admin/";
			} else {
				urlInstancia = url + "/mv-admin/";
			}
			
			//pages.setDefaultBaseUrl(urlInstancia);
			
			System.out.println(urlInstancia);
			
			home.setDefaultBaseUrl(urlInstancia);
			home.open();
			
			//home.setUrlInstancia(urlInstancia);
		}
    }
	
	/**
	 * Tela de login do sistema.
	 * 
	 * @param loja
	 * @param usuario
	 * @param senha
	 * @throws InterruptedException 
	 */
	@When("Eu faco login na loja $loja com usuario $usuario e senha $senha")
    public void euFacoLoginNaLoja(String loja, String usuario, String senha) throws InterruptedException {
		Thread.sleep(1000);

		home.login(loja, usuario, senha);
		Thread.sleep(1000);
    }	
	
	/**
	 * Tela de login do sistema PDV WEB.
	 * 
	 * @param loja
	 * @param usuario
	 * @param senha
	 * @throws InterruptedException 
	 */
	@When("Eu faco login no pdv web $pdv na loja $loja com usuario $usuario e senha $senha")
    public void euFacoLoginPDVWeb(String pdv, String loja, String usuario, String senha) throws InterruptedException {
		Boolean receberPedido = Boolean.parseBoolean(SystemEnvironmentVariables.createEnvironmentVariables().getProperty("mvlojas.receber.pedido"));
		
		if (receberPedido) {
			Thread.sleep(1000);
	
			home.logarPDVWeb(pdv, loja, usuario, senha);
			Thread.sleep(1000);
		}
    }	
}