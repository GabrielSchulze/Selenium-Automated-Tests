package automatizado.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import automatizado.builder.ProdutoBuilder;
import automatizado.pageObject.ControleProdutoPo;
import automatizado.pageObject.LoginPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ControleDeProdutosTest extends BaseTest {

    private static LoginPO loginPage;
    private static ControleProdutoPo controleProdutoPage;

    @BeforeClass
    public static void prepararTestes() {
        loginPage = new LoginPO(driver);
        loginPage.executarAcaoLogar("admin@admin.com", "admin@123");

        controleProdutoPage = new ControleProdutoPo(driver);

        assertEquals(controleProdutoPage.obterTituloPagina(), "Controle de Produtos");

    }

    @Test
    public void TC001_deveAbrirModalParaCadastroAoClicarNoBotaoCriar() {
        controleProdutoPage.buttonAdicionar.click();
        controleProdutoPage.buttonAdicionar.click();
        String Titulo = controleProdutoPage.tituloModal.getText();
        assertEquals("Produto", Titulo);
        controleProdutoPage.buttonSair.click();
        controleProdutoPage.buttonSair.click();
    }

    @Test
    public void TCE002_naoDeveSerPossivelCadastrarProdutoSemPreencherTodosOsCampos() {
        controleProdutoPage.buttonAdicionar.click();
        controleProdutoPage.buttonAdicionar.click();
        //controleProdutoPage.buttonAdicionar.click();
        //controleProdutoPage.cadastrarProduto("1", "Picanha", "50", "50,00", "");

        //Instancia o objeto para adiconar na tela
        ProdutoBuilder produtoBuilder = new ProdutoBuilder(controleProdutoPage);
        
        //Aqui adiciona as informações do produto na tela
        produtoBuilder.adicionarNome("Martelo");
        produtoBuilder.builder();

        //Busca mensagem
        String mensagem = controleProdutoPage.spanMensagem.getText();

        //Verificar e compara mensagem
        assertEquals("Todos os campos são obrigatórios para o cadastro!", mensagem);
    }

}
