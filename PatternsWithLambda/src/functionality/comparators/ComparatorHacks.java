package functionality.comparators;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import static java.util.Comparator.comparing;

/**
 * A demonstration of comparator in java 8 derived from Venkat's presentation https://www.youtube.com/watch?v=CeSoW83N4Y0
 * Created by grawat on 2/17/2016.
 */
public class ComparatorHacks {
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
                new Person("Tom", 23),
                new Person("Dres", 34),
                new Person("Fluff", 12),
                new Person("Clove", 12)
        );
        Function<Person, Integer> byAge = Person::getAge;
        Function<Person, String> byName = Person::getName;

        printSorted(persons, comparing(byAge).reversed());
        System.out.println("--");
        printSorted(persons, comparing(byName));
        System.out.println("--");
        printSorted(persons, comparing(byAge).thenComparing(byName));
    }

    private static void printSorted(List<Person> persons, Comparator<Person> comparing) {
        persons.stream().sorted(comparing).forEach(System.out::println);
    }

}

class Person {
    private int age;
    private String name;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}