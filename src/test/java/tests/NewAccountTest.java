package tests;

import dto.Account;
import dto.AccountFactory;
import org.junit.jupiter.api.Test;

import static enumUI.EnumContAcc.*;
import static enumUI.Options.*;

public class NewAccountTest extends BaseTest {

    Account account2 = Account.builder()
            .build();

    Account account3 = AccountFactory.getAccount("Gosha");

    @Test
    public void checkAddNewAccount() {
        loginPage.authorization("will", "will");
        newAccountPage
                .openPage()
                .addNewAccount(account2)
                .clickCheckbox(OPTED_OUT)
                .clickCheckbox(INVALID)
                .choiceOption(TYPE.toString(), INTEGRATOR)
                .choiceOption(INDUSTRY.toString(), ENERGY)
                .saveAccount();
    }
}
