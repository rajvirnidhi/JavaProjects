public class Account
{
    private String accountNumber;
    private String accountOwnerName;
    private int pin;
    private double balance;

    public Account(String accountNumber, String accountOwnerName, int pin, double balance) 
    {
        this.accountNumber = accountNumber;
        this.accountOwnerName = accountOwnerName;
        this.pin = pin;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountOwnerName() {
        return accountOwnerName;
    }

    public double getBalance() {
        return balance;
    }

    public boolean withdrawBalance(double amount) {
        if (amount <= 0 || balance < amount) {
            return false;
        }
        balance -= amount;
        return true;
    }

    public boolean depositBalance(double amount) {
        if (amount <= 0) {
            return false;
        }
        balance += amount;
        return true;
    }

    public int getPin() {
        return pin;
    }

    public boolean setPin(int newPin) {
        if (this.pin == newPin) {
            return false;
        }
        this.pin = newPin;
        return true;
    }
}