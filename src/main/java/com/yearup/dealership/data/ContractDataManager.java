package com.yearup.dealership.data;

import com.yearup.dealership.model.contract.LeaseContract;
import com.yearup.dealership.model.contract.SalesContract;
import com.yearup.dealership.model.contract.Contract;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ContractDataManager {
    private final String filePath = "contracts.csv";

    public void saveContract(Contract contract) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.newLine();

            if (contract instanceof SalesContract) {
                writer.write("Sale|20210928|Fred Wyatt|fred@texas.com|10112|1993|Ford|Explorer|SUV|Red|525123|995.00|49.75|100.00|295.00|1439.75|NO|0.00")

            } else if (contract instanceof LeaseContract) {

            }

        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
