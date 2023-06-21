package automatizado.builder;

import org.openqa.selenium.WebDriver;

import automatizado.pageObject.ControleProdutoPo;
import automatizado.test.ControleDeProdutosTest;

/**
 * Classe que sabe construir ou adicionar um produto na tela.
 */

public class ProdutoBuilder {

    private String codigo = "001";
    private String nome = "Picanha";
    private Integer quantidade = 5;
    private Double valor = 1.0;
    private String data = "23/02/2023";

    private ControleProdutoPo controleProdutoPo;

    /**
     * Construtor do ProdutoBuilder que recebe a página de controle de produtos.
     * @param controleProdutoPo
     */
    public ProdutoBuilder(ControleProdutoPo controleProdutoPo){
        this.controleProdutoPo = controleProdutoPo;
    }
    
    /**
     * Método que sabe adicionar um código ao Builder
     * @param codigo que será adicionado ao Builder
     * @return retorna a própria classe Builder.
     */
    public ProdutoBuilder adicionarCodigo(String codigo) {
        this.codigo = codigo;
        return this;
    }

    public ProdutoBuilder adicionarNome(String nome) {
        this.nome = nome;
        return this;
    }

    public ProdutoBuilder adicionarQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
        return this;
    }

    public ProdutoBuilder adicionarValor(Double valor) {
        this.valor = valor;
        return this;
    }

    public ProdutoBuilder adicionarData(String data) {
        this.data = data;
        return this;
    }

    /**
     * Metodo que constroi o produto, ou seja, adiciona o produto pela tela de cadastro de produto.
     */
    public void builder() {
        controleProdutoPo.escrever(controleProdutoPo.inputCodigo, codigo);
        controleProdutoPo.escrever(controleProdutoPo.inputNome, nome);
        controleProdutoPo.escrever(controleProdutoPo.inputQuantidade, (quantidade != null) ? quantidade.toString() : "");
        controleProdutoPo.escrever(controleProdutoPo.inputValor, (valor != null) ? valor.toString() : "");
        controleProdutoPo.escrever(controleProdutoPo.inputData, data);

        controleProdutoPo.buttonSalvar.click();
    }
}
