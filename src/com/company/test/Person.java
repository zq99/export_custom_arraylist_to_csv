package com.company.test;

import java.util.ArrayList;
import java.util.Date;

public class Person {

    /* this is just a dummy class to test the export process
     */

    private String name;
    private double age;
    private Date birthday;

    public Person(String name, double age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString(){
        return this.name + ", " + this.age + ", " + this.birthday;
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
