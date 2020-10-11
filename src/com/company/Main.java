package com.company;

import com.company.test.House;
import com.company.test.Person;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // this demonstrates how to use ListExporter class

        // create an arraylist with custom object
        ArrayList<Person> people = Person.getPeople();
        ArrayList<House> houses = House.getHouses();

        ListExporter.Export(people,"people.csv");
        ListExporter.Export(houses,"house.csv");


    }


}
