package agibank_pesquisa.web;

import agibank_pesquisa.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PesquisaPage extends PageObject {

    private static final String URL_PRINCIPAL = "https://blogdoagi.com.br/";


    public PesquisaPage() {
        super(null);
        this.browser.navigate().to(URL_PRINCIPAL);
    }

    public void abriCampoDePesquisa(){
        this.browser.findElement(By.id("search-open")).click();
    }

    public void escreverNoCampoPesquisa(String pesquisa){
        this.browser.findElement(By.className("search-field")).sendKeys(pesquisa);
    }

    public void clicarEmPesquisar(){
        this.browser.findElement(By.className("search-submit")).click();
    }

    public boolean resultadoPesquisaDefault(){
        return this.browser.getCurrentUrl().contentEquals("https://blogdoagi.com.br/?s=");
    }

    public boolean semResultadoParaPesquisa(){
        return this.browser.getCurrentUrl().contentEquals("https://blogdoagi.com.br/?s=111111111111111111111111111111111111111111111");
    }

    public boolean isSemResultadoDePesquisa() {
        return this.browser.getPageSource().contains("Nenhum resultado");
    }

    public boolean pesquisaComResultado() {
        return this.browser.getCurrentUrl().contentEquals("https://blogdoagi.com.br/?s=dinheiro");
    }
}
