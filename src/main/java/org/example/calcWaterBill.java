package org.example;

public class calcWaterBill {

    public static int waterCost(int waterUsage, int rentalMonths) {
        final int miniWaterUsage = 0;
        final int miniRentalMonths = 1;
        final int maxRentalMonths = 12;
        final int inValid = -1;
        if (waterUsage < miniWaterUsage || rentalMonths > maxRentalMonths || rentalMonths < miniRentalMonths) {
            return inValid;
        }
        final int freeUsage = 15;
        final int maxBasicUsage = 30;
        final int basicCost = 20000;
        final int highCost = 25000;
        final int miniMonthDiscount = 7;
        final double loyaltyDiscount = 0.5;
        int totalWaterBill;
        if (waterUsage <= freeUsage) {
            totalWaterBill = 0;
        } else if (waterUsage <= maxBasicUsage) {
            totalWaterBill = (waterUsage - freeUsage) * basicCost;
        } else {
            totalWaterBill = (waterUsage - freeUsage) * highCost;
        }
        if (rentalMonths >= miniMonthDiscount) {
            totalWaterBill *= loyaltyDiscount;
        }
        return totalWaterBill;
    }
}

