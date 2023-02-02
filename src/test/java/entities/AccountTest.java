package entities;

import factory.AccountFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    @Test
    void depositShouldIncreaseBalanceWhenPositiveAmount() {
        Account account = AccountFactory.createAccount(0.0);
        account.deposit(200.0);
        assertEquals(200.0, account.getBalance());
    }

    @Test
    void depositShouldThrowExceptionWhenAmountIsNotPositive() {
        Account account = AccountFactory.createAccount(0.0);

        assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(0);
        });
    }

    @Test
    void withdrawShouldDecreaseBalanceWhenPositiveAmountAndSufficientBalance() {
        Account account = AccountFactory.createAccount(200.0);
        account.withdraw(100.0);
        assertEquals(100.0, account.getBalance());
    }

    @Test
    void withdrawShouldThrowExceptionWhenAmountIsNotPositive() {
        Account account = AccountFactory.createAccount(0.0);
        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(0.0);
        });
    }

    @Test
    void withdrawShouldThrowExceptionWhenInsufficientBalance() {
        Account account = AccountFactory.createAccount(0.0);
        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(100.0);
        });
    }
}