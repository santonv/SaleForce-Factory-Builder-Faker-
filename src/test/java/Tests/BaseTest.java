package Tests;

import Pages.AccountsModal;
import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
;
import org.testng.annotations.BeforeMethod;


import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static final String NAME = "sidorik.a97-vqps@force.com";
    public static final String PASSWORD = "Compton2016";
    public WebDriver driver;
    protected WebDriverWait wait;
    protected AccountsModal accountsModalPage;
    protected LoginPage loginPage;
    protected HomePage homePage;

    @BeforeMethod
    public void setUP() {
        System.setProperty("webdriver.chrome.driver", "D:\\testing\\SaleForce\\src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 5);
        accountsModalPage = new AccountsModal(driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }
//    @AfterMethod
//    public void exit(){
//        driver.quit();
//    }
}
