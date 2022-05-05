package agibank_pesquisa.steps_defs;

import agibank_pesquisa.web.PesquisaPage;
import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Before;

import static org.junit.Assert.assertTrue;


public class AgibankSteps {

    PesquisaPage paginaPesquisa;

    @After
    public void afterEach(){
        this.paginaPesquisa.fechar();
    }

    @Dado("que estou na tela principal do AgiBank")
    public void que_estou_na_tela_principal_do_agi_bank() {
        this.paginaPesquisa = new PesquisaPage();
    }

    @Dado("clico na lupa")
    public void clico_na_lupa() {
        this.paginaPesquisa.abriCampoDePesquisa();
    }

    @Quando("não insiro valor")
    public void não_insiro_valor() {
       this.paginaPesquisa.escreverNoCampoPesquisa("");
    }

    @Quando("clico em pesquisar")
    public void clico_em_pesquisar() {
        this.paginaPesquisa.clicarEmPesquisar();
    }

    @Então("recebo um resultado default")
    public void recebo_um_resultado_default() {
        assertTrue(this.paginaPesquisa.resultadoPesquisaDefault());
    }

    @Então("visualizo mensagem de não há resultado para a pesquisa")
    public void visualizo_mensagem_de_não_há_resultado_para_a_pesquisa() {
        assertTrue(this.paginaPesquisa.semResultadoParaPesquisa());;
        assertTrue(this.paginaPesquisa.isSemResultadoDePesquisa());;
    }

    @Quando("insiro no campo {string}")
    public void insiro_no_campo(String pesquisa) {
        this.paginaPesquisa.escreverNoCampoPesquisa(pesquisa);
    }

    @Então("visualizo somente postagens que contém o texto pesquisado")
    public void visualizo_somente_postagens_que_contém_o_texto_pesquisado() {
        assertTrue(this.paginaPesquisa.pesquisaComResultado());
    }
}
