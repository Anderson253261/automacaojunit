import static org.junit.Assert.assertEquals;


import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.Set;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.ScreenshotException;

import com.google.common.io.Files;

@SuppressWarnings("unused")
public class Bancointer {
	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		//primeira parte 4dev//

		// Codigo para indicar o navegador
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		// comando para chamar o driver dentro do before
		driver = new ChromeDriver();
		//comando para indicar o url
		driver.get("https://www.4devs.com.br/gerador_de_pessoas");
		//comando para maximinizar a tela 
		driver.manage().window().maximize();
        
		// comando para interagir o elemento 
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#bt_gerar_pessoa")).click();
		Thread.sleep(2000);
		String nome = driver.findElement(By.xpath("//*[@id=\"nome\"]")).getText();
		System.out.println(nome);
		String celular = driver.findElement(By.xpath("//*[@id=\"telefone_fixo\"]")).getText();
		System.out.println(celular);
		String email = driver.findElement(By.xpath("//*[@id=\"email\"]")).getText();
		System.out.println(email);
		String cpf = driver.findElement(By.xpath("//*[@id=\"cpf\"]")).getText();
		System.out.println(cpf);
		String Datanascimento = driver.findElement(By.xpath("//*[@id=\"data_nasc\"]")).getText();
		System.out.println(Datanascimento);
		
		
		Thread.sleep(2000);
		driver.quit();

		// Codigo para indicar o navegador
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		// comando para chamar o driver dentro do before
		driver = new ChromeDriver();
		
		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
        driver.get("https://www.bancointer.com.br/");
		// comandos para maximinizar a tela
		driver.manage().window().maximize();

		driver.findElement(By.cssSelector(
				"#gatsby-focus-wrapper > div > header > section > div > div > div > div > div.styles__LogoNIcons-sc-1gbjc3e-6.gjJzHM > div.styles__SearchNFlags-sc-1gbjc3e-8.yVPnY > div.styles__ButtonsWrapper-sc-1gbjc3e-9.PKrxs > button:nth-child(1)"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.id("onetrust-accept-btn-handler")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("nome")).sendKeys(nome);
		Thread.sleep(1000);
		driver.findElement(By.id("celular")).sendKeys(celular);
		Thread.sleep(1000);
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("cpf")).sendKeys(cpf);
		driver.findElement(By.id("dataNascimento")).sendKeys(Datanascimento);
	    Thread.sleep(3000);
		driver.findElement(By.cssSelector(
				"body > div.style__ModalContent-wuavw4-0.hOXgJK > div.style__Container-sc-138k8xa-0.dlLgSU.d-flex.align-items-center > div > div:nth-child(2) > form > div > div:nth-child(6) > div > label"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("body > div.style__ModalContent-wuavw4-0.hOXgJK > div.style__Container-sc-138k8xa-0.dlLgSU.d-flex.align-items-center > div > div:nth-child(2) > form > div > div.col-12.text-center > button")).click();

	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException, IOException {
		Thread.sleep(3000);
		String texto = driver.findElement(By.cssSelector(
				"body > div.style__ModalContent-wuavw4-0.hOXgJK > div.style__Container-sc-138k8xa-0.dlLgSU.d-flex.align-items-center.sent > div > p"))
				.getText();
		System.out.println(texto);
		assertEquals("Prontinho! Recebemos os seus dados.", texto);
		//Tirar print
		File print=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//Salvar print
		Files.copy(print, new File("C:\\Users\\Anderson\\Desktop\\print\\Projetos eclipse.jpg"));

	}

}
