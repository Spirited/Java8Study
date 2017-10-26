package stepik.exersices;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

/**
 * 2.29 Almost like a SQL: click count
 */
public class ClickCount {
    private static final String ROOT = "cpa/";
    private static final String ADMIN = "admin/";
    private static final String GUEST = "guest/";

    private static final String ADMIN_LOGIN = "pushok";
    private static final String USER_LOGIN = "dyrak";

    public static void main(String[] args) {
        List<LogEntry> logs = history();
        Map<String, Long> clickCount = logs
                .stream()
                .collect(groupingBy(LogEntry::getUrl, counting()));

        System.out.println(clickCount);
    }

    private static List<LogEntry> history() {
        LogEntry log1 = createLog(ADMIN_LOGIN, ROOT);
        LogEntry log2 = createLog(ADMIN_LOGIN, ADMIN);
        LogEntry log3 = createLog(USER_LOGIN, GUEST);
        LogEntry log4 = createLog(USER_LOGIN, ROOT);
        LogEntry log5 = createLog(USER_LOGIN, ADMIN);

        return Arrays.asList(log1, log2, log3, log4, log5);
    }

    private static LogEntry createLog(String login, String url) {
        return new LogEntry(new Date(), login, url);
    }
}

class LogEntry {
    private Date created;
    private String login;
    private String url;

    public LogEntry(Date created, String login, String url) {
        this.created = created;
        this.login = login;
        this.url = url;
    }

    public Date getCreated() {
        return created;
    }

    public String getLogin() {
        return login;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "LogEntry{" +
                "created=" + created +
                ", login='" + login + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}