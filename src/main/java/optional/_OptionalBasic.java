package optional;

import java.util.Optional;
import java.util.function.Supplier;

public class _OptionalBasic {

    public static void main(String[] args) {
        Object defaultValue = Optional.ofNullable(null)
                .orElseGet(() -> "default value");

        System.out.println(defaultValue);

        String value = Optional.ofNullable("Hello")
                .orElseGet(() -> "default value");

        System.out.println(value);

        Optional.ofNullable("john@gmail.com")
                .ifPresent(email -> System.out.println("Sending email to " + email));

        Optional.ofNullable(null)
                .ifPresentOrElse(
                        email -> System.out.println("Sending email to " + email),
                        () -> {
                            System.out.println("Can not send email");
                        });

        Supplier<IllegalStateException> exception = () -> new IllegalStateException("exception");
        Object exceptionValue = Optional.ofNullable(null)
                .orElseThrow(exception);

        System.out.println(exceptionValue);
    }
}
