import java.util.ArrayList;
public class ATM extends Account
{
    public ArrayList<Account> accounts;
    public ArrayList<Account> initValues()
    {
        Account acc = new Account();
        acc.setAccountNumber("AC1234");
        acc.setAccountOwnerName("Nidhi");
        acc.setPin(1234);
        acc.setBalance(5000.00);

        Account acc1 = new Account();
        acc1.setAccountNumber("AC5678");
        acc1.setAccountOwnerName("Rajvir");
        acc1.setPin(5678);
        acc1.setBalance(5000.00);

        accounts = new ArrayList<Account>();
        accounts.add(acc);
        accounts.add(acc1);

        return accounts;
    }
}