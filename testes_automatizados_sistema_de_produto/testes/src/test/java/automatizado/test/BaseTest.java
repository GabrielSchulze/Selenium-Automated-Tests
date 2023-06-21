package automatizado.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Classe base que serve de herança para todas as classes de testes.
 */
public abstract class BaseTest {
    
    /**Driver do navegador da página atual */
    protected static WebDriver driver;
    
    /**Caminho base da URL do sistema a ser testado. */
    private static final String URL_BASE = "file:///C:/Users/Gabriel%20Schulze/Documents/Curso%20QA-Tester%20Automatizado%20Selenium%20+%20Java/controle-de-produtos/sistema/login.html";
    
    /** Caminho relativo do driver ao projeto referente ao path */
    private static final String CAMINHO_DRIVER = "C:/Users/Gabriel Schulze/Documents/Curso QA-Tester Automatizado Selenium + Java/Automatizado/automatizado/src/test/java/automatizado/resource/chromedriver-v110.0.5481.exe";

    /**
     * Metodo para iniciar o driver do navegador antes de qualquer classe de testes.
     */
    @BeforeClass
    public static void iniciar(){
        System.setProperty("webdriver.chrome.driver", CAMINHO_DRIVER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL_BASE);
    }

    /**
     * Metodo para finalizar o driver do navegador antes de qualquer classe de testes.
     */
    @AfterClass
    public static void finalizar(){
        driver.quit();
    }
}
