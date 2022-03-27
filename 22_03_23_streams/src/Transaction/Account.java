package Transaction;

import java.util.ArrayList;
import java.util.List;

public class Account {
    public String uuid;
    public long balance;
    public List<Transaction> transactions;

    public Account(String uuid, long balance, List<Transaction> transactions) {
        this.uuid = uuid;
        this.balance = balance;
        this.transactions = new ArrayList();
    }

    public String getUuid() {
        return uuid;
    }

    public long getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
