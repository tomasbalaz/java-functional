package streams;

import java.util.*;
import java.util.stream.Collectors;

import static streams._StreamAdvanced.Gender.FEMALE;

public class _StreamAdvanced {

    public static void main(String[] args) {

        List<Person> people = getPeople();

        // Imperative approach ❌
        List<Person> females = new ArrayList<>();
        for(Person female : people) {
            if(FEMALE.equals(female.gender)) {
                females.add(female);
            }
        }

       // females.forEach(System.out::println);

        // Declarative approach ✅

        // Filter
        List<Person> females2 = people.stream()
                .filter(person -> FEMALE.equals(person.gender))
                .collect(Collectors.toList());
       // females2.forEach(System.out::println);

        // Sort
        List<Person> sorted = people.stream()
                .sorted(Comparator.comparing(Person::getAge)
                        .thenComparing(Person::getGender)
                        .reversed())
                .collect(Collectors.toList());

        sorted.forEach(System.out::println);

        // All match
        boolean allMatch = people.stream()
                .allMatch(person -> person.getAge() > 8);

        System.out.println(allMatch);

        // Any match
        boolean anyMatch = people.stream()
                .anyMatch(person -> person.getAge() > 121);
        System.out.println(anyMatch);

        // None match
        boolean noneMatch = people.stream()
                .noneMatch(person -> person.getName().equals("Antonio"));
        System.out.println(noneMatch);

        // Max
        people.stream()
                .max(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);
        // Min
        people.stream()
                .min(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);
        // Group
        Map<Gender, List<Person>> groupingByGender = people.stream()
                .collect(Collectors.groupingBy(Person::getGender));

        groupingByGender.forEach((gender, people1) -> {
            System.out.println(gender);
            people1.forEach(System.out::println);
            System.out.println();
        });

        Optional<String> oldestFemaleAge = people.stream()
                .filter(person -> FEMALE.equals(person.gender))
                .max(Comparator.comparing(Person::getAge))
                .map(Person::getName);

        oldestFemaleAge.ifPresent(System.out::println);
    }

    static class Person {
        private final String name;
        private final int age;
        private final Gender gender;

        Person(String name, int age, Gender gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public Gender getGender() {
            return gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", gender=" + gender +
                    '}';
        }
    }


    static enum Gender {
        MALE,
        FEMALE
    }

    private static List<Person> getPeople() {
        return List.of(
                new Person("James Bond", 20, Gender.MALE),
                new Person("Alina Smith", 33, FEMALE),
                new Person("Helen White", 57, FEMALE),
                new Person("Alex Boz", 14, Gender.MALE),
                new Person("Jamie Goa", 99, Gender.MALE),
                new Person("Anna Cook", 7, FEMALE),
                new Person("Zelda Brown", 120, FEMALE)
        );
    }
}
