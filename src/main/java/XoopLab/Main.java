package XoopLab;

public class Main {
    public static void main(String[] args) {
        
        Account account = new Account(1, "chris", 1000);
        account.deposit(1000);
        account.withdraw(1500);
        //account.deposit(-10);
        //account.withdraw(10000);

        // problems with an array??
        Account[] accounts = {
            new Account(2, "x", 1000),
            new Account(3, "y", 1000),
            new Account(4, "z", 1000)
        };

        for (Account a : accounts) {
            System.out.println(a.getDetails());
        }
        
        Account myAccount = new Account(5, "a", 100);
        myAccount.addInterest();
        System.out.println(myAccount.getDetails());


        // shared reference - be carful!!!
        Account partnerAccount = myAccount;
        partnerAccount.addInterest();
        System.out.println(myAccount.getDetails());

        processAccount(myAccount);        
        System.out.println(myAccount.getDetails());

        int k=100;
        incInt(k);
        System.out.println(k);
    }  

    private static void processAccount(Account acc){ 
	acc.addInterest();
    }

    private static void incInt(int x) {
    x++;
    System.out.println(x);
    }

}
