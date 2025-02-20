import java.util.ArrayList;
public class ATM
{
    private ArrayList<Account> accounts;

    public ATM() {
        accounts = new ArrayList<>();
        accounts.add(new Account("AC1234", "Nidhi", 1234, 5000.00));
        accounts.add(new Account("AC5678", "Rajvir", 5678, 5000.00));
    }

    public Account findAccount(String accountNumber, int pin) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber) && account.getPin() == pin) {
                return account;
            }
        }
        return null;
    }
}