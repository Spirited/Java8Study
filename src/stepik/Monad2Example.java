package stepik;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public class Monad2Example {
    public static void main(String[] args) {
        final Bank bank = new Bank("010122113", Optional.ofNullable("The Great & Reliable Bank"));
        final Account account = new Account(UUID.randomUUID(), Optional.ofNullable(bank), 1000L);
        final User user = new User("Lesly", "Hawk", Optional.ofNullable(account));

//        System.out.println(getBankNameWhereUserHasAccount(user));
//
//        CompletableFuture d;

    }

//    private static String getBankNameWhereUserHasAccount(User user) {
//        return Optional.ofNullable(user)
//                .map(User::getAccount)
//                .map(Account::getBank)
//                .map(Bank::getName)
//                .orElse("<No bank found>");
//    }


}

class User {
    private String firstName;
    private String lastName;
    private Optional<Account> account;

    public User(String firstName, String lastName, Optional<Account> account) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.account = account;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Optional<Account> getAccount() {
        return account;
    }
}

class Account {
    private UUID uuid;
    private Optional<Bank> bank;
    private long balance;

    public Account(UUID uuid, Optional<Bank> bank, long balance) {
        this.uuid = uuid;
        this.bank = bank;
        this.balance = balance;
    }

    public UUID getUuid() {
        return uuid;
    }

    public Optional<Bank> getBank() {
        return bank;
    }

    public long getBalance() {
        return balance;
    }
}

class Bank {
    private String uniqueName;
    private Optional<String> name;

    public Bank(String uniqueName, Optional<String> name) {
        this.uniqueName = uniqueName;
        this.name = name;
    }

    public String getUniqueName() {
        return uniqueName;
    }

    public Optional<String> getName() {
        return name;
    }
}
