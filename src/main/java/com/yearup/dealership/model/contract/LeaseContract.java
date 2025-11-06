package com.yearup.dealership.model.contract;

import com.yearup.dealership.model.Vehicle;

public class LeaseContract extends Contract {
    private double expectedEndingValue;
    private double leasingFee;

    public LeaseContract(String dateOfContract, String customerName, String customerEmail, Vehicle vehicleSold, double expectedEndingValue, double leasingFee) {
        super(dateOfContract, customerName, customerEmail, vehicleSold);
        this.expectedEndingValue = expectedEndingValue;
        this.leasingFee = leasingFee;
    }

    public double getTotalPrice() {
        return 0;
    }

    public double getMonthlyPayment() {
        return 0;
    }

}
