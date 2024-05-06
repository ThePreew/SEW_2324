package ue06_Lambdas;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Übung {
    public static void main(String[] args) {
        // Liste von Personen
        List<Person> persons = Arrays.asList(
                new Person("Alice", 25, "New York"),
                new Person("Bob", 30, "Los Angeles"),
                new Person("Charlie", 45, "Chicago"),
                new Person("David", 50, "New York"),
                new Person("Emma", 28, "Chicago"),
                new Person("Frank", 55, "Los Angeles"),
                new Person("Grace", 40, "New York"),
                new Person("Henry", 35, "Los Angeles"),
                new Person("Isabella", 60, "Chicago"),
                new Person("Jack", 22, "New York")
        );

        System.out.println(aP(persons));
        System.out.println(aA(persons));
        System.out.println(aL(persons));
        System.out.println(aD(persons));
    }

    public static Person aP(List<Person> persons){
        return persons.stream().max(Comparator.comparingInt(Person::getAge)).orElse(null);
    }

    public static int aA(List<Person> persons){
        return (int) persons.stream().mapToInt(Person::getAge).average().orElse(0);
    }

    public static Map<String, Long> aL(List<Person> persons){
        return persons.stream().collect(Collectors.groupingBy(Person::getTown, Collectors.counting()));
    }

    public static List<String> aD(List<Person> persons){
        return persons.stream().collect(Collectors.groupingBy(Person::getTown, Collectors.counting())).entrySet().stream().filter(entry -> entry.getValue() >=2 ).map(Map.Entry::getKey).collect(Collectors.toList());
    }


}
class Person{
    public String name;
    public int age;
    public String town;

    public Person(String name, int age, String town) {
        this.name=name;
        this.age=age;
        this.town=town;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getTown() {
        return town;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", town='" + town + '\'' +
                '}';
    }
}

