package com.yearup.dealership.console;
import com.yearup.dealership.model.contract.Contract;
import com.yearup.dealership.data.ContractDataManager;
import com.yearup.dealership.model.contract.SalesContract;
import com.yearup.dealership.model.Dealership;
import com.yearup.dealership.model.Vehicle;
import com.yearup.dealership.data.DealershipFileManager;

import java.time.LocalDate;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    private Scanner scanner = new Scanner(System.in);

    public void display() {
        ContractDataManager contractDataManager = new ContractDataManager();

        System.out.println("Dealership App");

        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        this.dealership = dealershipFileManager.getDealership();

        Contract salesContract = new SalesContract(LocalDate.now(), "John Doe", "johndoe@example.com", this.dealership.getAllVehicles().set(0), 22000.00 * 0.05, 100.00, true);

        // Print all vehicles in the inventory
        System.out.println("Inventory for " + dealership.getAllVehicles().size() + " vehicles ");
        System.out.println("Dealership Inventory:\n");

        for (Vehicle vehicle : dealership.getAllVehicles()) {
            System.out.println(vehicle);
            System.out.println("---------------------------");
        }


    }

    private void displayMenu() {
        System.out.println("\n--- Main Menu ---");
        System.out.println("1 - Find vehicles within a price range");
        System.out.println("2 - Find vehicles by make / model");
        System.out.println("3 - Find vehicles by year range");
        System.out.println("4 - Find vehicles by color");
        System.out.println("5 - Find vehicles by mileage range");
        System.out.println("6 - Find vehicles by type (car, truck, SUV, van)");
        System.out.println("7 - List ALL vehicles");
        System.out.println("8 - Add a vehicle");
        System.out.println("9 - Remove a vehicle");
        System.out.println("99 - Quit");
    }


}
/*
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    private DealershipFileManager fileManager;
    private Scanner scanner = new Scanner(System.in);

    public UserInterface() {
        this.dealership = dealership;
    }

    public void display() {
        init();

        int option;

        displayMenu();

        System.out.println("Enter an option: ");
        option = scanner.nextInt();
        scanner.nextLine(); // eats a line

        switch (option) {
            case 1 -> processGetByPriceRequest();
            case 2 -> processGetByMakeModelRequest();
            case 3 -> processGetByYearRequest();
            case 4 -> processGetByColorRequest();
            case 5 -> processGetByMileageRequest();
            case 6 -> processGetByVehicleTypeRequest();
            case 7 -> processGetAllVehiclesRequest();
            case 8 -> processAddVehicleRequest();
            case 9 -> processRemoveVehicleRequest();
            //case 10 ->
            case 99 -> {
                System.out.println("Exiting application.");
                // This calls the DealershipFileManager to write the current dealership
                // inventory back to the file (data persistence), and then 'return;'
                // immediately stops the display loop and terminates the application.
                fileManager.saveDealership(dealership);
                return;
            }



        }
    }

    public void processGetByPriceRequest() {

    }

    public void processGetByMakeModelRequest() {

    }

    public void processGetByYearRequest() {

    }

    public void processGetByColorRequest() {

    }

    public void processGetByMileageRequest() {

    }

    public void processGetByVehicleTypeRequest() {

    }

    public void processGetAllVehiclesRequest() {

    }

    public void processAddVehicleRequest() {

    }

    public void processRemoveVehicleRequest() {

    }

    public void init() {
        this.dealership = fileManager.getDealership();
        System.out.println("The dealership is " + dealership.getName());
    }

    private void displayMenu() {
        System.out.println("\n--- Main Menu ---");
        System.out.println("1 - Find vehicles within a price range");
        System.out.println("2 - Find vehicles by make / model");
        System.out.println("3 - Find vehicles by year range");
        System.out.println("4 - Find vehicles by color");
        System.out.println("5 - Find vehicles by mileage range");
        System.out.println("6 - Find vehicles by type (car, truck, SUV, van)");
        System.out.println("7 - List ALL vehicles");
        System.out.println("8 - Add a vehicle");
        System.out.println("9 - Remove a vehicle");
        System.out.println("10 - Sell/Lease a vehicle");
        System.out.println("99 - Quit");
    }
}*/
