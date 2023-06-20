package example_automatic_test.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTest {
    private WebDriver driver;
    private final String URL_BASE = "https://www.google.com/";
    private final String CAMINHO_DRIVER = "src/test/java/example_automatic_test/resource/chromedriver - v114.05735.exe";
    
    /*
     * Método responsável por intanciar um objeto do ChromeDriver e abrir o navegador na página da URL_BASE.
     */
    private void iniciar(){
        System.setProperty("webdriver.chrome.driver", CAMINHO_DRIVER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL_BASE);
    }

    /*
     * Realiza teste de busca no google.
     */
    @Test
    public void devePesquisarGoogle(){
        iniciar();
        WebElement inputPesquisa = driver.findElement(By.name("q"));
        inputPesquisa.sendKeys("Curso completo de Selenium" + Keys.ENTER);
        String resultado = driver.findElement(By.id("result-stats")).getText();
        assertTrue(resultado, resultado.contains("Aproximadamente"));
    }
}
