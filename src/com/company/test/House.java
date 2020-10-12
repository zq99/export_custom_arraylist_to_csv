package com.company.test;

import java.util.ArrayList;

public class House {

    /* this is just a test class to test the export process */

    private final int doorNumbers;
    private final String streetName;
    private final String zipPostCode;
    private final String district;
    private final String countryCode;

    public House(int doorNumbers, String streetName, String zipPostCode, String district, String countryCode) {
        this.doorNumbers = doorNumbers;
        this.streetName = streetName;
        this.zipPostCode = zipPostCode;
        this.district = district;
        this.countryCode = countryCode;
    }

    public int getDoorNumbers() {
        return doorNumbers;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getZipPostCode() {
        return zipPostCode;
    }

    public String getDistrict() {
        return district;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public static ArrayList<House> getHouses(){
        House house1 = new House(12,"Street A","zip1","dist1","us");
        House house2 = new House(13,"Street B","zip2","dist2","us");
        House house3 = new House(14,"Street C","zip3","dist1","us");

        ArrayList<House> houses = new ArrayList<>();
        houses.add(house1);
        houses.add(house2);
        houses.add(house3);
        return houses;
    }
}
