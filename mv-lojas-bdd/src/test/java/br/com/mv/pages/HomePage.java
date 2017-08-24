package br.com.mv.pages;

import static br.com.mv.model.SessionVariables.NRO_USUARIO;
import static br.com.mv.model.SessionVariables.COD_NRO_LOJA;

import java.util.Map;

import br.com.mv.utils.ControleMenu;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.pages.PageObject;

public class HomePage extends PageObject {

	private String urlInstancia;
	
	public void setUrlInstancia(String urlInstancia) {
		this.urlInstancia = urlInstancia;
	}
	
	public Boolean ehInstancia(String ip) {
		return this.urlInstancia.contains(ip);
	}
	
	public void login(String store, String user, String password) throws InterruptedException {
		Thread.sleep(1000);
		$("#j_loja").clear();
		$("#j_loja").sendKeys(store);
		Thread.sleep(1000);

		Serenity.setSessionVariable(NRO_USUARIO).to(user.trim());
		Serenity.setSessionVariable(COD_NRO_LOJA).to(store.trim());
		
		String codNroLoja = Serenity.sessionVariableCalled(COD_NRO_LOJA);
		String nroVendedor = Serenity.sessionVariableCalled(NRO_USUARIO);
		
		$("#j_username_fake").sendKeys(user);
		Thread.sleep(1000);

		$("#j_password").sendKeys(password);
		Thread.sleep(1000);

		$("#btnEntrar").click();
		Thread.sleep(1000);

	}
	
	public void logarPDVWeb(String pdv, String store, String user, String password) throws InterruptedException {
		Thread.sleep(5000);
		
		$("#j_pdv").clear();
		$("#j_pdv").sendKeys(pdv);
		Thread.sleep(1000);
		
		$("#j_loja").clear();
		$("#j_loja").sendKeys(store);
		Thread.sleep(1000);

		$("#j_username_fake").sendKeys(user);
		Thread.sleep(1000);

		$("#j_password").sendKeys(password);
		Thread.sleep(1000);

		$("#btnEntrar").click();
		Thread.sleep(1000);

	}
	
	public void acessarMenu(String descMenu) {
		String[] links = descMenu.split(">");
		
		//System.out.println("Links" + links);
		
		new ControleMenu(this.getDriver()).navegar(links);
	}
	
	public void acessarPDVMenu(String descMenu) {
		String[] links = descMenu.split(">");
		
		//System.out.println("Links qtd: " + links.length + " | link: " + links[0]);
		
		new ControleMenu(this.getDriver()).navegarPDV(links);
	}
	
	public static Map<String, String> getTags() {
		Map<String, String> metadata = Serenity.getCurrentSession().getMetaData();
		
		return metadata;
	}
	
	
}