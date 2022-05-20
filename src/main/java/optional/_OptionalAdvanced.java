package optional;

import java.util.Optional;

public class _OptionalAdvanced {

    public static void main(String[] args) {

        System.out.println("//Optional.empty()");
        Optional<Object> empty = Optional.empty();
        System.out.println(empty);
        System.out.println(empty.isPresent());
        System.out.println(empty.isEmpty());
        System.out.println();

        System.out.println("//Optional.of()");
        Optional<String> hello = Optional.of("hello");
        System.out.println(hello);
        System.out.println(hello.isPresent());
        System.out.println(hello.isEmpty());

        String orElse = hello.orElse("hello world");
        System.out.println(orElse);
        System.out.println();

        System.out.println("//Optional.ofNullable()");
        Optional<String> helloNull = Optional.ofNullable(null);
        Object orElseNullable = helloNull.orElse("hello world");
        System.out.println(orElseNullable);

        String orElseNullable2 = helloNull
                .map(String::toUpperCase)
                .orElse("hello world");

        String orElseNullable3 = helloNull
                .map(String::toUpperCase)
                .orElseGet(() -> {
                    // ... extra computation to retrieve the value
                    return "world";
                });

//        String orElseNullable4 = helloNull
//                .map(String::toUpperCase)
//                .orElseThrow(IllegalStateException::new);

        Optional.ofNullable("hello")
                .map(String::toUpperCase)
                .ifPresent(word -> {
                    System.out.println(word);
                });

        Optional.ofNullable(null)
                .ifPresentOrElse(System.out::println, () -> System.out.println("world"));


        // How to avoid null pointer exception when accessing object field
        // v1
        Person person = new Person("james", "JAMES@gmail.com");
        String email = person.getEmail().map(String::toLowerCase).orElse("email not provides");
        System.out.println(email);

        Person person2 = new Person("james", null);
        String email2 = person2.getEmail().map(String::toLowerCase).orElse("email not provided");
        System.out.println(email2);

        // How to avoid null pointer exception when accessing object field
        // v2
        if(person.getEmail().isPresent()) {
            String email3 = person.getEmail().get();
            System.out.println(email3.toLowerCase());
        }
        else {
            System.out.println("email not provided");
        }

    }

    static class Person {
        private final String name;
        private final String email;

        Person(String name, String email) {
            this.name = name;
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public Optional<String> getEmail() {
            return Optional.ofNullable(email);
        }
    }
}
