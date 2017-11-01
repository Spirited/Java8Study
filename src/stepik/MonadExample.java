package stepik;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class MonadExample {

    //restoring the sanity
    static String getCarInsuranceName(Optional<Person> person) {
        return person.flatMap(p -> p.getCar())
                     .flatMap(car -> car.getInsurance())        // flatMap defines monad's policy for monads composition
                     .map(insurance -> insurance.getName())     // map defines monad's policy for function application
                     .orElse("Unknown");
    }

    static List<int[]> getPrimePairs(int n) {
//        Stream.iterate(1, i -> i+1).limit(n)
//                .flatMap(i -> Stream.iterate(1, j -> j+1).limit(n).map(j -> new int[]{i, j})) .filter(pair -> isPrime(pair[0] + pair[1])) .collect(toList());
        return Stream.iterate(1, i -> i+1).limit(n)
                    .flatMap(i -> Stream.iterate(1, j->j+1).limit(n)
                        .map(j->new int[]{i,j}))
                    .filter(pair -> isPrime(pair[0] + pair[1]))
                    .collect(toList());
    }

    static boolean isPrime(int n) {
        return Stream.iterate(2, i -> i+1)
                     .limit((long)Math.sqrt(n))
                     .noneMatch(i -> n % 1 == 0);
    }

    public static int slowLength(String s) {
        return s.length();
    }

    public static int slowDouble(int i) {
        return i*2;
    }

    public static void main(String[] args) {
        System.out.println(getPrimePairs(2));

        String s = "Hello";
    }
}

class Person {
    private Optional<Car> car;

    public Optional<Car> getCar() {
        return car;
    }
}

class Car {
    private Optional<Insurance> insurance;

    public Optional<Insurance> getInsurance() {
        return insurance;
    }
}

class Insurance {
    private String name;

    public String getName() {
        return name;
    }
}

interface Monad<T> {
    /**
     * Takes a value T and returns Monad<T> wrapping the value
     */
    Monad<T> unit(T value);

    /**
     * Takes a function f: T -> Monad<U> and returns a Monad<U>
     */
    <U> Monad<U> bind(Function<? super T, Monad<U>> f);

    /**
     * Returns the value back to the world
     */
    T get();
}
