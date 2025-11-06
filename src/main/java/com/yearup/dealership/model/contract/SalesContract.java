package com.yearup.dealership.model.contract;

import com.yearup.dealership.model.Vehicle;

public class SalesContract extends Contract {
/*
• Sales Tax Amount (5%)
• Recording Fee ($100)
• Processing fee ($295 for vehicles under $10,000 and $495 for all others
• Whether they want to finance (yes/no)
• Monthly payment (if financed) based on:
    • All loans are at 4.25% for 48 months if the price is $10,000 or more
    • Otherwise they are at 5.25% for 24 months
*/

    private double salesTaxAmount;
    private double recordingFee;
    private boolean isFinanced;


    public SalesContract(String dateOfContract, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(dateOfContract, customerName, customerEmail, vehicleSold);
        this.salesTaxAmount
    }


}
