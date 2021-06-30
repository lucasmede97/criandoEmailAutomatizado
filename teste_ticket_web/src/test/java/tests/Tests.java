package tests;

import config.BaseTest;
import org.junit.Test;
import pages.Page;

public class Tests extends BaseTest {

    //Desafio para criar email (gmail) com automação
    @Test
    public void preenchendoDadosObrigatóriosParaCadastroDeEmail(){
        Page page = new Page(driver);
        page.preencherCamposCriarConta();
        page.preencherCamposWelcome();
        page.aceiteDeTermos();
        page.screenshot();

    }

}
