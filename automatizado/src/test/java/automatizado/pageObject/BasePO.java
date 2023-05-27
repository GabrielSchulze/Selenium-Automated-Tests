package automatizado.pageObject;

import java.lang.reflect.Constructor;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Classe base para criação das novas pagesObjects.
 * Todas as pages devem ser herdadas desta classe.
 */
public abstract class BasePO {
    /** Driver base que será usado pelas pages */
    protected WebDriver driver;
    
    /**
     * Construtor base para ciação da fabrica de elementos. (PageFactory).
     * @param driver Driver da página atual.
     */
    public BasePO(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
    /**
     * Método que retorna o título da página atual
     * @return
     */
    public String obterTituloPagina(){
        return driver.getTitle();
    }

    /**
     * Metodo que sabe escrever em qualquer WebElement do tipo Input e da um TAB ao final.
     * @param input Input a qual será escrito.
     * @param texto Texto que será escrito no input.
     */
    public void escrever(WebElement input, String texto) {
        input.clear();
        input.sendKeys(texto + Keys.TAB);
    }

}
