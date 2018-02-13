package stepik.exersices.monad;

import java.util.function.Function;

public interface Try<M> {
    <B> Try<B> flatMap(Function<M, Try<B>> f);
    <B> Try<B> map(Function<M, B> f);
    boolean isFailure();
}
