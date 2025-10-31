package com.yearup.dealership;
/*

public class DealershipFileManager {

    public Dealership getDealership(){
        Dealership dealership = new Dealership(
                "Year Up Motors",
                "123 Main St, Columbus, OH",
                "614-555-1212"
        );

        // Add 10 vehicles to the dealership's inventory
        dealership.addVehicle(new Vehicle(1001, 2020, "Toyota", "Camry", "Sedan", "Silver", 32000, 18995.00));
        dealership.addVehicle(new Vehicle(1002, 2019, "Honda", "Civic", "Sedan", "Blue", 45000, 15995.00));
        dealership.addVehicle(new Vehicle(1003, 2021, "Ford", "F-150", "Truck", "Red", 25000, 29995.00));
        dealership.addVehicle(new Vehicle(1004, 2018, "Chevrolet", "Equinox", "SUV", "White", 60000, 17495.00));
        dealership.addVehicle(new Vehicle(1005, 2022, "Tesla", "Model 3", "Sedan", "Black", 12000, 35995.00));
        dealership.addVehicle(new Vehicle(1006, 2017, "Subaru", "Outback", "Wagon", "Green", 78000, 13995.00));
        dealership.addVehicle(new Vehicle(1007, 2020, "Jeep", "Wrangler", "SUV", "Orange", 31000, 28995.00));
        dealership.addVehicle(new Vehicle(1008, 2019, "BMW", "X5", "SUV", "Gray", 50000, 33995.00));
        dealership.addVehicle(new Vehicle(1009, 2021, "Hyundai", "Elantra", "Sedan", "White", 18000, 17995.00));
        dealership.addVehicle(new Vehicle(1010, 2018, "Nissan", "Altima", "Sedan", "Blue", 67000, 13995.00));

        return dealership;
    }
    public void saveDealership(Dealership dealership) {

    }
}
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class DealershipFileManager {

    /*
    Line,Field 1,Field 2,Field 3,Field 4,Field 5,Field 6,Field 7,Field 8
    Line 1,Name,Address,Phone
    Vehicle,VIN/ID,Year,Make,Model,Type,Color,Mileage,Price
     */
    public Dealership getDealership() {
        Dealership dealership = null; // List to hold loaded objects.
        int lineNumber = 0; // Tracks the line number for special handling of Line 1 (dealership info)
        try {
            // File I/O Setup (Read)
            FileReader fileReader = new FileReader("inventory.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            // Loop to process every line in the file
            while ((line = bufferedReader.readLine()) != null) {
                // Splits the line using the pipe character '|' as a delimiter.
                String[] parts = line.split(Pattern.quote("|"));
                //line 1 is Dealership information
                if (lineNumber == 0) {
                    // Set Data
                    String name = (parts[0]);
                    String address = (parts[1]);
                    String phone = (parts[2]);

                    // Create Object
                    dealership = new Dealership(name, address, phone);
                } else if (dealership != null) { //need to guarantee the dealership variable is created
                    int vin = Integer.parseInt(parts[0]);
                    int year = Integer.parseInt(parts[1]);
                    String make = parts[2];
                    String model = parts[3];
                    String vehicleType = parts[4];
                    String color = parts[5];
                    int mileage = Integer.parseInt(parts[6]);
                    double price = Double.parseDouble(parts[7]);

                    Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, mileage, price);
                    dealership.addVehicle(vehicle);
                }
                lineNumber++;
            }
            bufferedReader.close(); // Close the reader (essential step).
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dealership;// Returns the list of all transactions loaded from the file.
    }

    public void saveDealership(Dealership dealership) {

    }
}

