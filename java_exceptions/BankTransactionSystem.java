package java_exceptions;

import java.util.Scanner;

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}


class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }


    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount!"); // Negative amount check
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance!"); // Low balance check
        }
        balance -= amount;
        System.out.println("Withdrawal successful, new balance: " + balance);
    }


    public double getBalance() {
        return balance;
    }
}


public class BankTransactionSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the bank balance = ");
        double initial_bal = sc.nextDouble();
        BankAccount account = new BankAccount(initial_bal);


        try {
            System.out.println("Enter the amount for withdrawl = ");
            double withdraw = sc.nextDouble();
            account.withdraw(withdraw); // Valid withdrawal
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Enter the another amt of withdrawl = ");
            double withdraw2 = sc.nextDouble();
            account.withdraw(withdraw2);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }
}
