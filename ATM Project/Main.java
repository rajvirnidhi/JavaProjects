import java.util.Scanner;
import java.util.ArrayList;

class Main extends ATM
{
    public static void main(String args[])
    {
        Scanner s= new Scanner(System.in);

        ATM atm = new ATM();
        ArrayList<Account> acc = atm.initValues();

        System.out.println("Enter account number");
        String accN=s.nextLine();
        
        System.out.println("Enter pin");
        int pin=s.nextInt();
        boolean isValid = false;
        for(Account account : acc)
        {
            if(account.getPin()==pin && account.getAccountNumber()==accN)
            {
                System.out.println("Welcome");
                isValid=true;
                break;
            }
        }
        if(isValid)
        {
            
        

        System.out.println("Select account you want to access");
        int ch=0;
        int ch1=-1;
        do
        {
            System.out.println("1. Savings Account");
            System.out.println("2. Current Account");
            System.out.println("3. Change Pin");
            System.out.println("0. Exit");
            ch=s.nextInt();

            while(ch==1 && ch1!=0)
            {
                System.out.println("Select action");
                System.out.println("1. Check Balance");
                System.out.println("2. Withdraw");
                System.out.println("3. Deposit");
                System.out.println("0. Exit");
                ch1=s.nextInt();
            }
        }while(ch!=3);
    }
    }
}