package automatizado.pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO {
    //#region Região dos WebElements
    @FindBy(id = "email")
    public WebElement inputEmail;

    @FindBy(id = "senha")
    public WebElement inputSenha;

    @FindBy(id = "btn-entrar")
    public WebElement buttonEntrar;

    @FindBy(css = "form.form-login>div.alert>span")
    public WebElement spanMessage;

    //#region Região Construtor
    /**
     * Construtor padrão para criação de uma nova instância da página de login.
     * 
     * @param driver driver da página de login.
     */
    public LoginPO(WebDriver driver) {
        super(driver);
        // TODO Auto-generated constructor stub
    }

    //#region Região dos Metodos
    public void executarAcaoLogar(String Email, String Senha) {
        escrever(inputEmail, Email);
        escrever(inputSenha, Senha);
        buttonEntrar.click();
    }

    public void escrever(WebElement input, String texto) {
        input.clear();
        input.sendKeys(texto + Keys.TAB);
    }
     /*Metodo que obtem a mensagem disparada na tela e a retorna */
    public String obterMensagem() {
        return spanMessage.getText();
    }

}
