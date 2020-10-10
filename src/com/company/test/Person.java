package com.company.test;

import java.util.ArrayList;

public class Person {

    /* this is just a dummy class to test the export process
     */

    private final String name;
    private final double age;

    public Person(String name, double age) {
        this.name = name;
        this.age = age;
    }

    public double getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return this.name + ", " + this.age;
    }

    public static ArrayList<Person> getPeople(){
        Person person1 = new Person("Elon",50);
        Person person2 = new Person("Zuckerberg",30);
        Person person3 = new Person("Gates",65);

        ArrayList<Person> people = new ArrayList<>();
        people.add(person1);
        people.add(person2);
        people.add(person3);
        people.add(person1);
        return people;
    }
}
