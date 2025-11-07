package XoopLab;

public class Account{
    private int id;
    private String owner;
    private double balance;


    Account(int id, String owner, double balance) {
    this.id = id;
    this.owner = owner;
    this.balance = balance;
    }

    protected void deposit(double amount) {
    if (amount <= 0) {
        throw new IllegalArgumentException("Deposit must be positive");
    } else {balance += amount;}
    }

    protected void withdraw(double amount) {
        if (amount <= 0 || amount > balance) {
            throw new IllegalArgumentException("Withdrawal must be positive and not exceed balance");
        } else {balance -= amount;}  
    }

    protected String getDetails() {
        return "ID: " + id + " Owner: " + owner + " Balance: " + balance;
    }
    
    // do i really want this??
    // @Override
    // public String toString() {
    //     return "Account [id=" + id + ", owner=" + owner + ", balance=" + balance + ", getDetails()=" + getDetails()
    //     + ", getOwner()=" + getOwner() + "]";
    // }
    
    protected void addInterest() {
        balance += (balance * 0.025);
    }

    protected String getOwner() {
        return owner;
    }
}
