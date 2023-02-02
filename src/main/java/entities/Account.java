package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Account {
    private Long id;
    private Double balance;

    public void deposit(double amount) {
        checkIfInformedAmountIsPositive(amount);
        balance += amount;
    }

    public void withdraw(double amount) {
        checkIfInformedAmountIsPositive(amount);
        if (balance < amount) {
            throw new IllegalArgumentException("entities.Account balance must be greater than informed amount.");
        }

        balance -= amount;
    }

    private void checkIfInformedAmountIsPositive(double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Informed amount must be greater than 0.");
    }
}
