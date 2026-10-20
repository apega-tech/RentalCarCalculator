package com.pluralsight;

import java.util.Scanner;

public class RentalCarCalculator {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter pickup date (MM/DD): ");
        String pickupDate = scanner.nextLine();

        System.out.print("Enter number of days for the rental: ");
        int rentalDays = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Do you want an electric toll tag ($3.95/day)? (yes/no): ");
        String tollTag = scanner.nextLine();

        System.out.print("Do you want a GPS ($2.95/day) (yes/no): ");
        String gps = scanner.nextLine();

        System.out.print("Do you want roadside assistance ($3.95/day) (yes/no): ");
        String roadside = scanner.nextLine();

        System.out.print("Enter your current age: ");
        int age = scanner.nextInt();

        double basicCarRental = calculateBasicCost(rentalDays);
        double optionsCosts = calculateOptionCost(rentalDays, tollTag, gps, roadside);
        double underageSurcharge = calculateUnderageSurcharge(basicCarRental, age);
        double totalCost = basicCarRental + optionsCosts + underageSurcharge;

        displaySummary(basicCarRental, optionsCosts, underageSurcharge, totalCost);
        scanner.close();
    }


    public static double calculateBasicCost(int days) {
        return days * 29.99;
    }

    public static double calculateOptionCost(int days, String tollTag, String gpsOption, String road) {
        double dailyOptionsTotal = 0.0;

        if (tollTag.equalsIgnoreCase("yes")){
            dailyOptionsTotal += 3.95;
        }
        if (gpsOption.equalsIgnoreCase("yes")){
            dailyOptionsTotal += 2.95;
        }
        if(road.equalsIgnoreCase("yes")){
            dailyOptionsTotal += 3.95;
        }
        return dailyOptionsTotal * days;
    }

    public static double calculateUnderageSurcharge(double basicCost, int driverAge){
        if (driverAge < 25){
            return basicCost * 0.30;
        } else{
            return 0.0;
        }
    }

    public static void displaySummary(double basic, double options, double surcharge, double total){
        System.out.println("\n--- Rental Car Summary ---");
        System.out.printf("Basic car rental:   $%.2f%n", basic);
        System.out.printf("Options cost:       $%.2f%n", options);
        System.out.printf("Underage surcharge: $%.2f%n", surcharge);
        System.out.printf("Total cost:         $%.2f%n", total);
    }
}
