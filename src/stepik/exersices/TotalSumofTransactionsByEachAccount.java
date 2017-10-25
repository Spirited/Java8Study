package stepik.exersices;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * 2.28 Almost like a SQL: the total sum of transactions by each account
 */
public class TotalSumofTransactionsByEachAccount {
    public static void main(String[] args) {
        Account ivan = new Account("12345", 1021L);
        Account yan = new Account("90877", 2045L);

        Transaction t1 = new Transaction("111-01", 10L, ivan);
        Transaction t2 = new Transaction("111-02", 49L, ivan);
        Transaction t3 = new Transaction("111-03", 100L, yan);

        List<Transaction> transactions = Arrays.asList(t1,t2,t3);

        LongSummaryStatistics statistics = transactions.stream().collect(summarizingLong(Transaction::getSum));
        Map<String, Long> totalSumTransByEachAccount = transactions.stream()
                .collect(groupingBy(t -> t.getAccount().getNumber(), summingLong(Transaction::getSum)));

        System.out.println(totalSumTransByEachAccount);

        //System.out.println(transactions.stream().collect(groupingBy(transactions2 -> transactions2.getAccount().getNumber(), summarizingLong(Transaction::getSum))));
    }
}

class Account {
    private String number;
    private Long balance;

    public Account(String number, Long balance) {
        this.number = number;
        this.balance = balance;
    }

    public String getNumber() {
        return number;
    }

    public Long getBalance() {
        return balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (number != null ? !number.equals(account.number) : account.number != null) return false;
        return balance != null ? balance.equals(account.balance) : account.balance == null;
    }

    @Override
    public int hashCode() {
        int result = number != null ? number.hashCode() : 0;
        result = 31 * result + (balance != null ? balance.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Account{" +
                "number='" + number + '\'' +
                ", balance=" + balance +
                '}';
    }
}

class Transaction {
    private String uuid;
    private Long sum;
    private Account account;

    public Transaction(String uuid, Long sum, Account account) {
        this.uuid = uuid;
        this.sum = sum;
        this.account = account;
    }

    public String getUuid() {
        return uuid;
    }

    public Long getSum() {
        return sum;
    }

    public Account getAccount() {
        return account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaction that = (Transaction) o;

        if (uuid != null ? !uuid.equals(that.uuid) : that.uuid != null) return false;
        if (sum != null ? !sum.equals(that.sum) : that.sum != null) return false;
        return account != null ? account.equals(that.account) : that.account == null;
    }

    @Override
    public int hashCode() {
        int result = uuid != null ? uuid.hashCode() : 0;
        result = 31 * result + (sum != null ? sum.hashCode() : 0);
        result = 31 * result + (account != null ? account.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "uuid='" + uuid + '\'' +
                ", sum=" + sum +
                ", account=" + account +
                '}';
    }
}