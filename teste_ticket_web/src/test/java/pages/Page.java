package pages;

import config.BasePage;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.io.FileUtils;

import java.io.File;

public class Page extends BasePage {

    public Page(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"headingText\"]/span")
    public WebElement title_Criar_Conta;

    @FindBy(id = "firstName")
    public WebElement field_firstName;

    @FindBy(id = "lastName")
    public WebElement field_lastName;

    @FindBy(id = "username")
    public WebElement field_user_name;

    @FindBy(xpath = "//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[2]/div[1]/div/div[2]/div[1]")
    public WebElement message_user_name;

    @FindBy(xpath = "//*[@id=\"passwd\"]/div[1]/div/div[1]/input")
    public WebElement field_password;

    @FindBy(xpath = "//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[3]/div[2]/div/span")
    public WebElement message_password;

    @FindBy(xpath = "//*[@id=\"confirm-passwd\"]/div[1]/div/div[1]/input")
    public WebElement field_confirm_password;

    @FindBy(xpath = "//*[@id=\"accountDetailsNext\"]/div/button/span")
    public WebElement button_next_criar_conta;


    @FindBy(xpath = "//*[@id=\"headingText\"]/span")
    public WebElement title_welcome;

    @FindBy(id = "day")
    public WebElement field_day;

    @FindBy(id = "month")
    public WebElement combo_month;

    @FindBy(id = "year")
    public WebElement field_year;

    @FindBy(id = "gender")
    public WebElement combo_gender;

    @FindBy(id = "//*[@id=\"view_container\"]/div/div/div[2]/div/div[2]/div/div[1]/div/div/button/div[2]")
    public WebElement button_next_welcome;


    @FindBy(xpath = "//*[@id=\"headingText\"]/span")
    public WebElement title_privacy;

    @FindBy(xpath = "//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/div/form/span/section[2]/div/div/div[1]/div[1]/div/div/div[1]/div/input")
    public WebElement checkBox_1;

    @FindBy(xpath = "//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/div/form/span/section[2]/div/div/div[2]/div[1]/div/div/div[1]/div/input")
    public WebElement checkBox_2;

    @FindBy(xpath = "//*[@id=\"headingText\"]/span")
    public WebElement button_create_account;


    public Page preencherCamposCriarConta(){
        Assert.assertEquals("Criar sua Conta do Google",title_Criar_Conta.getText());
        field_firstName.sendKeys("Lucas");
        field_lastName.sendKeys("Medeiros");
        field_user_name.sendKeys("lucasmedeirosticket01");
        Assert.assertEquals("Você pode usar letras, números e pontos finais",message_user_name.getText());
        field_password.sendKeys("rcllll21");
        Assert.assertEquals("Use oito ou mais caracteres com uma combinação de letras, números e símbolos",message_password.getText());
        field_confirm_password.sendKeys("rcllll21");
        button_next_criar_conta.click();
        sleepPage(5000);
        return this;
    }

    public Page preencherCamposWelcome(){
        Assert.assertEquals("Bem-vindo ao Google",title_welcome.getText());
        field_day.sendKeys("27");
        Select combobox1 = new Select(combo_month);
        combobox1.selectByValue("9");
        field_year.sendKeys("1999");
        Select combobox2 = new Select(combo_gender);
        combobox2.selectByValue("1");
        button_next_welcome.click();
        sleepPage(7000);
        return this;
    }

    public Page aceiteDeTermos(){
        Assert.assertEquals("Privacidade e Termos",title_privacy.getText());
        rolarScrollBar();
        sleepPage(4000);
        checkBox_1.click();
        sleepPage(2000);
        checkBox_2.click();
        sleepPage(2000);
        button_create_account.click();
        sleepPage(12000);
        return this;
    }

    public Page screenshot() {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "/src/test/resources/screenshot/screenshots.png"), true);
        } catch (Exception e){}
        return  this;
    }

    public Page rolarScrollBar(){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scrollBy(0,8000)", "");
        return this;
    }

}
