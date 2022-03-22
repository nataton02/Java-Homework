public class Account {
    public int id;
    public double balance;
    public boolean isLocked;

    public Account(int id, double balance, boolean isLocked) {
        this.id = id;
        this.balance = balance;
        this.isLocked = isLocked;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                ", isLocked=" + isLocked +
                '}';
    }
}
