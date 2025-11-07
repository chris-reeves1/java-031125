package XoopLab;

public class Bank {
    private final Account[] accountArray = new Account[3];
    private int nextId = 1;

    public Account addAccount(String owner, double balance) {
    for (int i = 0; i < accountArray.length; i++) {
        if (accountArray[i] == null) {
            Account a = new Account(nextId++, owner, balance);
            accountArray[i] = a;
            return a;
        } 
    } return null;
}

    public Account getAccount(String owner) {
        for (Account a : accountArray) {
            if (a != null && a.getOwner().equals(owner)) {
                return a;
            }
        }
        return null;
    }
}
