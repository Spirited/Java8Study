package streamapi.operation;

import java.util.Optional;

public class OptionalOverview {
    private static void print(String x) {
        System.out.println(x);
    }

    public static void main(String[] args) {
        String notNull = "serge";
        String mayBeNull = null;
        Optional<String> opt = Optional.of(notNull);
        Optional<String> mayBe = Optional.ofNullable(mayBeNull);
        Optional<String> n = Optional.empty();

        System.out.println(opt);
        System.out.println(mayBe);
        System.out.println(n);

        opt.ifPresent(OptionalOverview::print);

        opt.filter(x -> x.contains("ab")).ifPresent(OptionalOverview::print);

        opt.map(String::trim).filter(t -> t.length() > 1).ifPresent(OptionalOverview::print);
    }
}
