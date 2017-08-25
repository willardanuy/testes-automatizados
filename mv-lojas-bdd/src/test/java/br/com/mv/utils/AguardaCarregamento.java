package br.com.mv.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.thucydides.core.pages.PageObject;

public class AguardaCarregamento extends PageObject {
	
	private WebDriver driver;
	private Boolean abriuModalCarregamento = false;
	
	public AguardaCarregamento(WebDriver driver) {
		this.driver = driver;
	}

	public Boolean blockOverlayVisivel() {
		return (Boolean)((JavascriptExecutor)this. driver).executeScript("return $('.blockOverlay').is(':visible')");
	}
	
	public Boolean modalMVAguarde() {
		return (Boolean)((JavascriptExecutor)this. driver).executeScript("return $('#_mv_aguarde_').is(':visible')");
	}
	
	public Boolean modalMVDlgAguarde() {
		return (Boolean)((JavascriptExecutor)this. driver).executeScript("return $('.modal.in.mv-dlg-aguarde').is(':visible')");
	}
	
	public void aguardarCarregamentoModalDlg() throws InterruptedException {
		
		Boolean blockUI = true;
		
		while (blockUI == true) {
			Thread.sleep(2000);
			blockUI = modalMVDlgAguarde();
		}
	}

	public void aguardarCarregamentoModal() {
		
		Boolean blockUI = true;
		
		while (blockUI == true) {
			blockUI = modalMVAguarde();
		}
	}
	
	public void aguardarCarregamentoNovaArquitetura2() throws InterruptedException {
		
		Boolean blockUI = true;
		
		while (blockUI == true) {
			Thread.sleep(2000);
			blockUI = blockOverlayVisivel();
		}
	}
	
	public void aguardarCarregamentoArquiteturaAntiga() throws InterruptedException {
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(this.driver, 90);
		
		if (validarExistenciaAguardar()) {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[id='divAguarde']")));
		}
		Thread.sleep(1000);
	}
	
	private boolean validarExistenciaAguardar() {
		boolean present;
		try {
			boolean divAguarde = driver.findElement(By.cssSelector("div[id='divAguarde']")).isDisplayed();
			if (!divAguarde) {
				return false;
			}
			present = true;
		} catch (NoSuchElementException e) {
			present = false;
		}
		return present;
	}
	
	/**
	 * Utilizado na tela de pesquisa de cliente
	 */
	public void aguardarCarregamentoNovaArquitetura() {
		
		Boolean blockUI = true;
		
		while (abriuModalCarregamento == false) {
			blockUI = blockOverlayVisivel();
			
			if (blockUI == true) {
				abriuModalCarregamento = true;
				
				while (blockUI == true) {
					blockUI = blockOverlayVisivel();
				}
			}
		}
	}
}
