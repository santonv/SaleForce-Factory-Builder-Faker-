package Pages;

import Elements.DropDown;
import Elements.Input;
import Elements.TextArea;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class AccountsModal extends BasePage{

    public static final String ACCOUNTS = "/lightning/o/Account/list?filterName=Recent";
    public static final By NEW_BUTTON = By.cssSelector("[title=New]");
    public static final By SAVE_BUTTON = By.xpath("//button[@title='Save']");
    public static final By ACCOUNT_MODAL_TITLE = By.xpath("//h2[text()='New Account']");


    public AccountsModal(WebDriver driver) {
        super(driver);
    }

    public AccountsModal open(){
        driver.get(BASE_URL + ACCOUNTS);
        return this;
    }

    @Override
    @Step("Checking Account modal page open")
    public boolean isPageOpened() {
        log.info("Checking Account modal page open");
        return isExist(ACCOUNT_MODAL_TITLE);
    }

    public AccountsModal clickNewButton(){
        driver.findElement(NEW_BUTTON).click();
        return new AccountsModal(driver);
    }

    @Step("Input data to create new Account")
    public AccountDetailsPage create(Account account) {
        log.info("Input data to create new Account");
        new Input(driver,"Account Name").write(account.getAccountName());
        new Input(driver, "Phone").write(account.getPhone());
        new Input(driver, "Website").write(account.getWebsite());
        new Input(driver, "Employees").write(account.getEmployees());
        new Input(driver, "Billing City").write(account.getBillingCity());
        new Input(driver, "Billing State/Province").write(account.getBillingState());
        new Input(driver, "Billing Zip/Postal Code").write(account.getBillingZipCode());
        new Input(driver, "Billing Country").write(account.getBillingCountry());
        new Input(driver, "Shipping Zip/Postal Code").write(account.getShippingZipCode());
        new Input(driver, "Shipping Country").write(account.getShippingCountry());
        new Input(driver, "Shipping City").write(account.getShippingCity());
        new Input(driver, "Shipping State/Province").write(account.getShippingState());
        new TextArea(driver,"Description").write(account.getDescription());
        new TextArea(driver,"Billing Street").write(account.getBillingStreet());
        new TextArea(driver, "Shipping Street").write(account.getShippingStreet());
        save();
        return new AccountDetailsPage(driver);
    }

    @Step("Click the button Save")
    public void save() {
        log.info("Click the button Save");
        driver.findElement(SAVE_BUTTON).click();
    }
}
