public class Account
{
    private String accountNumber;
    private String accountOwnerName;
    private int pin;
    private double balance;
    
    public String getAccountNumber()
    {
        return accountNumber;
    }

    public String getAccountOwnerName()
    {
        return accountOwnerName;
    }

    public double getBalance()
    {
        return balance;
    }

    public boolean withdrawBalance(double amount)
    {
        if(balance<amount)
            return false;
        balance-=amount;
        return true;
    }

    public boolean depositBalance(double amount)
    {
        if(0>amount)
            return false;
        balance+=amount;
        return true;
    }

    public int getPin()
    {
        return pin;
    }
    public boolean setPin(int pin)
    {
        if(this.pin==pin)
            return false;
        this.pin=pin;
        return true;
    }

    public void setAccountNumber(String accountNumber)
    {
        this.accountNumber = accountNumber;
    }

    public void setAccountOwnerName(String accountOwnerName)
    {
        this.accountOwnerName = accountOwnerName;
    }

    public void setBalance(double balance)
    {
        this.balance = balance;
    }
}