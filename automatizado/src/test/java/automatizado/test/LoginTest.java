package automatizado.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import automatizado.pageObject.LoginPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest extends BaseTest {
    private static LoginPO loginPage;

    @BeforeClass
    public static void prepararTestes() {
        loginPage = new LoginPO(driver);
    }

    @Test
    public void TC001_naoDeveLogarNoSistemaComEmailSenhaVazios() {
        loginPage.executarAcaoLogar("", "");
        String message = loginPage.obterMensagem();
        assertEquals(message, "Informe usuário e senha, os campos não podem ser brancos.");
    }

    @Test
    public void TC002_naoDeveLogarNoSistemaComEmailErradoSenhaVazia() {
        loginPage.executarAcaoLogar("teste", "");
        String message = loginPage.obterMensagem();
        assertEquals(message, "Informe usuário e senha, os campos não podem ser brancos.");
    }

    @Test
    public void TC003_naoDeveLogarNoSistemaComEmailVazioSenhaErrada() {
        loginPage.executarAcaoLogar("", "123");
        String message = loginPage.obterMensagem();
        assertEquals(message, "Informe usuário e senha, os campos não podem ser brancos.");
    }

    @Test
    public void TC004_deveLogarComEmailSenhaCorretos() {
        loginPage.executarAcaoLogar("admin@admin.com", "admin@123");
        assertEquals(loginPage.obterTituloPagina(), "Controle de Produtos");
    }

}
