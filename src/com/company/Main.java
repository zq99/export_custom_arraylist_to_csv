package com.company;

import com.company.test.Person;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // this demonstrates how to use ExportCustomList class

        // create an arraylist with custom object
        ArrayList<Person> people = Person.getPeople();

        try {
            // export arraylist to csv
            ExportCustomList exportCustomList = new ExportCustomList(people,"test.csv");
            exportCustomList.setHeadersRequired(true);
            exportCustomList.setIndexRequired(true);
            exportCustomList.output();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
