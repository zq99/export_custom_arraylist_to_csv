# Export Custom Java List to CSV

A utility class to export the data from a java list containing custom objects to a csv file.

## Example

        // create an arraylist with custom objects
        
        ArrayList<Person> people = Person.getPeople();
        ArrayList<House> houses = House.getHouses();

        //export the data from each list to a csv file
        
        ListExporter.export(people,"people.csv");
        ListExporter.export(houses,"house.csv");

## Things to complete

- Custom objects with attributes that are also custom objects
- Arraylist with primitives


