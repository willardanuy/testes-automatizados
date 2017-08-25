package br.com.mv.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * ControleMenu
 * 
 */
public class ControleMenu {

	private WebDriver driver;

	public ControleMenu(WebDriver driver) {
		//super();
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}

	/**
	 * Responsável por navegar entre as opções do menu principal
	 * @param links, sequencia de links a serem acessados no menu
	 */
	public void navegar(String[] links) {

		WebElement btnClick = null;
		WebElement dropDown;
		WebDriverWait wait = new WebDriverWait(this.driver, 90);
		Actions actions = new Actions(this.driver);

		System.out.println(links.length);
		
		for (int i = 0; i < links.length; i++) {
			
			if (i > 0) {
				System.out.println(i + " - " + links[i].trim());
				List<WebElement> itens =  driver.findElements(By.xpath("//ul[contains(@class, 'dropdown-menu')]/li/a[not(contains(@class, 'raiz')) and text()='" + links[i].trim() + "']"));
				
				for (WebElement item : itens) {
					if (item.isDisplayed()) {
						btnClick = item;
						break;
					}
				}
				
			} else {
				System.out.println(i + " - " + links[i]);
				//btnClick = driver.findElement(By.linkText(links[i]));
				btnClick = driver.findElement(By.xpath(".//*[@id='conteudoMenu']/li/a[contains(text(), '" + links[i].trim() + "')]"));
			}
			
			actions.moveToElement(btnClick).build().perform();
			
			if (i + 1 == links.length) {
				
				System.out.printf("Abrir página: %s \n", links[i]);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(links[i].trim())));
				btnClick.click();
			} else {
				
				
				System.out.println("Menu: " + links[i + 1]);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(links[i + 1].trim())));
			}
		}
	}
	
	/**
	 * Responsável por navegar entre as opções do menu principal
	 * @param links, sequencia de links a serem acessados no menu
	 */
	public void navegarPDV(String[] links) {
		WebDriverWait wait = new WebDriverWait(this.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".navbar")));
		
		for (int i = 0; i < links.length; i++) {
			System.out.println("Abrir página: " + links[i]);
			driver.findElement(By.xpath("//nav/ul[2]/li/a[contains(text(), '" + links[i] + "')]")).click();
		}
	}
}