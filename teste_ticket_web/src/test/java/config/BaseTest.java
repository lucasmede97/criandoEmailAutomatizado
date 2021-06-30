package config;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    public WebDriver driver;
    protected BasePage basePage;

    @Before
    public void before(){

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://stackoverflow.com/questions/3422262/how-can-i-take-a-screenshot-with-selenium-webdriver");
        //driver.get("https://accounts.google.com/signup/v2/webcreateaccount?service=mail&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F%3Fpc%3Dtopnav-about-n-en&flowName=GlifWebSignIn&flowEntry=SignUp");
        driver.manage().window().maximize();

        basePage = new BasePage(driver);
    }

    @After
    public void after(){
        driver.quit();
    }
}
