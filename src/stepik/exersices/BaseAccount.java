package stepik.exersices;

import java.util.UUID;

public class BaseAccount {
    private UUID uuid;
    private long balance;

    public BaseAccount(UUID uuid, long balance) {
        this.uuid = uuid;
        this.balance = balance;
    }

    public UUID getUuid() {
        return uuid;
    }

    public long getBalance() {
        return balance;
    }
}
