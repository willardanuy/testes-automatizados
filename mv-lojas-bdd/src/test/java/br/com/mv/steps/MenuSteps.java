package br.com.mv.steps;
import java.util.ArrayList;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.When;

import br.com.mv.pages.HomePage;
import br.com.mv.utils.ControleMenu;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class MenuSteps {

	@Steps
	HomePage home;
	//Pages pages;
	
	/**
	 * Acesso ao menu
	 * 
	 * @param url
	 */
	@When("Eu acesso o menu $descMenu")
    public void euAcessoOMenu(String descMenu) {
		
		home.acessarMenu(descMenu);
    }
	
	/**
	 * Acesso ao menu do pdv
	 * 
	 * @param url
	 */
	@When("Eu acesso o pdv menu $descMenu")
    public void euAcessoOPdvMenu(String descMenu) {
		Boolean receberPedido = Boolean.parseBoolean(SystemEnvironmentVariables.createEnvironmentVariables().getProperty("mvlojas.receber.pedido"));
		
		if (receberPedido) {
			home.acessarPDVMenu(descMenu);
		}
    }
}