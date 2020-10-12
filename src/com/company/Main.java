package com.company;

import com.company.test.House;
import com.company.test.Person;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // this demonstrates how to use ListExporter class

        // create an arraylist with custom objects
        ArrayList<Person> people = Person.getPeople();
        ArrayList<House> houses = House.getHouses();

        //export the data from each list to a csv file
        ListExporter.export(people,"people.csv");
        ListExporter.export(houses,"house.csv");


    }


}
