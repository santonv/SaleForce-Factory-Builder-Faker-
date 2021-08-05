package Tests;

import lombok.extern.log4j.Log4j2;
import models.Account;
import models.AccountFactory;
import org.testng.annotations.Test;

@Log4j2
public class AccountCreateTest extends BaseTest{

    @Test(description = "Account should be created")
    public void Test(){
        loginPage.open().
                logIn(NAME,PASSWORD);

        // Builder, Random Data, Factory
        Account account = AccountFactory.get();
        accountsModalPage.open().
                clickNewButton().
                create(account).
                openDetailsTab().
                validateAccount(account);
    }
}
