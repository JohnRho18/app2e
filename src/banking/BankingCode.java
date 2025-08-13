package banking;

import java.util.Scanner;

public class BankingCode {
    private final int accountNo;
    private int pin;
    private float initialBalance;

    public BankingCode(int accountNo, int pin) {
        this.accountNo = accountNo;
        this.pin = pin;
        this.initialBalance = 0.0f;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public int getPin() {
        return pin;
    }
    
    public void setPin(int pin) {
        this.pin = pin;
    }

    public boolean verifyAccount(int acc, int pn) {
        return (this.accountNo == acc && this.pin == pn);
    }
    
    public void viewBalance() {
        System.out.println("Current balance: " + this.initialBalance);
    }
    
    public void deposit(float amount) {
        this.initialBalance += amount;
        System.out.println("Deposit successful. New balance: " + this.initialBalance);
    }
    
    public boolean withdraw(float amount) {
        if (this.initialBalance >= amount) {
            this.initialBalance -= amount;
            System.out.println("Withdrawal successful. New balance: " + this.initialBalance);
            return true;
        } else {
            System.out.println("Insufficient balance.");
            return false;
        }
    }
}