package stepik.exersices.monad;

import java.util.function.Function;

public class Failure<A> implements Try<A> {
    private final Object value;

    public Failure(Object value) {
        this.value = value;
    }

    @Override
    public <B> Try<B> flatMap(Function<A, Try<B>> f) {
        return (Failure<B>)this;
    }

    @Override
    public <B> Try<B> map(Function<A, B> f) {
        return (Failure<B>)this;
    }

    @Override
    public boolean isFailure() {
        return false;
    }
}
