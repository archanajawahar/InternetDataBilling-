package com.billing;

import java.util.Scanner;

public class InternetDataBilling {

    public static double calculateBill(String plan, double usage) {

        double basePrice;
        double dataLimit;
        double extraRate;

        switch (plan.toLowerCase()) {
            case "basic":
                basePrice = 399;
                dataLimit = 50;
                extraRate = 10;
                break;

            case "standard":
                basePrice = 599;
                dataLimit = 100;
                extraRate = 8;
                break;

            case "premium":
                basePrice = 899;
                dataLimit = 200;
                extraRate = 5;
                break;

            default:
                throw new IllegalArgumentException("Invalid plan");
        }

        double bill = basePrice;

        if (usage > dataLimit) {
            double extraData = usage - dataLimit;
            bill += extraData * extraRate;
        }

        return bill;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of customers: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {

            System.out.println("\nCustomer " + i);

            System.out.print("Enter customer name: ");
            String name = sc.next();

            System.out.print("Enter plan (Basic/Standard/Premium): ");
            String plan = sc.next();

            System.out.print("Enter data usage in GB: ");
            double usage = sc.nextDouble();

            double bill = calculateBill(plan, usage);

            System.out.println("\n----- BILL -----");
            System.out.println("Customer Name : " + name);
            System.out.println("Plan          : " + plan);
            System.out.println("Data Usage    : " + usage + " GB");
            System.out.printf("Monthly Bill  : Rs. %.2f%n", bill);
        }

        sc.close();
    }
}
