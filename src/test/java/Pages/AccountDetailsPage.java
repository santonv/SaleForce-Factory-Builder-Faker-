package Pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class AccountDetailsPage extends BasePage{

    public static final By DETAILS_TAB = By.xpath("//div[contains(@class,'active')]//*[@id='detailTab__item']");

    public AccountDetailsPage(WebDriver driver) {
        super(driver);
    }
    public boolean isPageOpened() {
        return false;
    }

    @Step("Open Account details page")
    public AccountDetailsPage openDetailsTab() {
        log.info("Open Account details page");
        driver.findElement(DETAILS_TAB).click();
        return this;
    }

    @Step("Check account information")
    public void validateAccount(Account account) {
    log.info("Check account information");
    checkElement("Account Name", account.getAccountName());
    checkElement("Phone", account.getPhone());
    checkElement("Website", account.getWebsite());
    checkElement("Employees", account.getEmployees());
    checkElement("Description", account.getDescription());
    checkElements("Billing Address", new String[]{account.getBillingCity(), account.getBillingCountry(),
            account.getBillingState(), account.getBillingStreet(), account.getBillingZipCode()});
    checkElements("Shipping Address", new String[]{account.getShippingCity(), account.getShippingCountry(),
            account.getShippingState(), account.getShippingStreet(), account.getShippingZipCode()});
    }
}
