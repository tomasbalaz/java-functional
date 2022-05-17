package streams;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

import static streams._Stream.GENDER.FEMALE;
import static streams._Stream.GENDER.MALE;


public class _Stream {

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Aisha", FEMALE),
                new Person("Alex", MALE),
                new Person("Alice", FEMALE)
        );

        IntConsumer println = x -> System.out.println(x);
        ToIntFunction<String> length = String::length;
        Function<Person, String> personStringFunction = person -> person.name;

        people.stream()
                .map(personStringFunction)
                .mapToInt(length)
                .forEach(println);
    }

    public static class Person {
        private final String name;
        private final GENDER gender;

        public Person(String name,GENDER gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "People{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    public enum GENDER {
        MALE,
        FEMALE
    }
}
