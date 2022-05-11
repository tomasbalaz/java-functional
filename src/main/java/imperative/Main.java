package imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static imperative.Main.GENDER.FEMALE;
import static imperative.Main.GENDER.MALE;

public class Main {

    public static void main(String[] args) {
        List<Person>  people = List.of(
                new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Aisha", FEMALE),
                new Person("Alex", MALE),
                new Person("Alice", FEMALE)
        );

        //Imperative approach
        System.out.println("//Imperative approach");
        List<Person> females = new ArrayList<>();

        for(Person person: people) {
            if(FEMALE.equals(person.gender)) {
                females.add(person);
            }
        }

        for(Person female: females) {
            System.out.println(female);
        }

        //Declarative approach
        System.out.println("//Declarative approach");
        people.stream()
                .filter(person -> FEMALE.equals(person.gender))
                .forEach(System.out::println);
    }

    public static class Person {
        private final String name;
        private final GENDER gender;

        public Person(String name, GENDER gender) {
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
