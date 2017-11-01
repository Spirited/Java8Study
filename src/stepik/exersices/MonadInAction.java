package stepik.exersices;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public class MonadInAction {
    private static final Set<User> users = new HashSet<>();

    public static Optional<User> findUserByLogin(String login) {
        return users.stream().filter(user -> user.getLogin().equals(login)).findAny();

    }

    public static void printBalanceIfNotEmpty(String userLogin) {
        findUserByLogin(userLogin)
                .map(User::getAccount)
                .map(BaseAccount::getBalance)
                .filter(balance -> balance > 0)
                .ifPresent(balance -> System.out.println(userLogin + ": " + balance));
    }

    public static void main(String[] args) {
        BaseAccount account = new BaseAccount(UUID.randomUUID(), 100L);
        User user = new User("login", account);

        BaseAccount account2 = new BaseAccount(UUID.randomUUID(), 3900L);
        User user2 = new User("ele", account2);

        BaseAccount account3 = new BaseAccount(UUID.randomUUID(), -100L);
        User user3 = new User("sleep", account3);

        BaseAccount account4 = new BaseAccount(UUID.randomUUID(), 99900L);
        User user4 = new User("sleep2", account4);

        users.add(user);
        users.add(user2);
        users.add(user3);
        users.add(user4);


        printBalanceIfNotEmpty("ele");
        printBalanceIfNotEmpty("234");
        printBalanceIfNotEmpty("sleep");
        printBalanceIfNotEmpty("sleep2");

    }
}


