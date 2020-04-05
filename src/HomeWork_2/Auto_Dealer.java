package HomeWork_2;
/* Author Name: Cody Bishop
   Date: 1 - 28 - 2020
   Program: Auto Dealer Program
   Description: The Auto Dealer application is used to take an end users inputs using the Scanner class and preform
   mathematical calculations based on different criteria and return the list of information to the user about the cost
   of the vehicle in question.
*/

import java.util.Scanner;

public class Auto_Dealer
{
    public static void main(String[] args)
    {
//      Creating all variables used in the program
        int Choice;
        int WhatMonth;
        int Discount;
        int DownPay;
        double ModelCost;
        double InteriorCost;
        double ColorCost;
        double TaxCost;
        double SubTotal;
        double SubTotalDiscounted;
        double Total;
        double FinalTotal;
        Scanner scan = new Scanner(System.in);
//      Formulating the start of the application
        System.out.println
                ("Welcome to AutoDealer!"+
                "\n----------------------");
//      Ask the user what model they are picking
        System.out.println
                ("\nMake your model selection:\n" +
                "1 - Toyota\n" +
                "2 - Honda\n" +
                "3 - Ford\n" +
                "4 - Chevy");
        System.out.print("Selection: ");
        Choice = scan.nextInt();
//      Assign the Model Cost based on the choice by the user
        switch(Choice)
        {
            case 1:ModelCost = 23000;
            break;
            case 2:ModelCost = 25000;
            break;
            case 3:ModelCost = 22000;
            break;
            case 4:ModelCost = 23500;
            break;
            default:ModelCost = 19999;
        }
//      Ask the user which interior options they want
        System.out.println
                ("\nMake your Interior Selection:\n" +
                "1 - Cloth\n" +
                "2 - Leather\n" +
                "3 - Premium Leather");
        System.out.print("Selection: ");
        Choice = scan.nextInt();
//      Assign the Interior Cost based on the choice by the user
        switch(Choice)
        {
            case 1: InteriorCost = 1200;
            break;
            case 2: InteriorCost = 1500;
            break;
            case 3: InteriorCost = 1900;
            break;
            default: InteriorCost = 1000;
        }
        //      Ask the user which interior options they want
        System.out.println
                ("\nMake your Color Selection:\n" +
                        "1 - Purple\n" +
                        "2 - Gold\n" +
                        "3 - Blended");
        System.out.print("Selection: ");
        Choice = scan.nextInt();
//      Assign the Paint Cost based on the choice by the user
        switch(Choice)
        {
            case 1: ColorCost = 800;
            break;
            case 2: ColorCost = 900;
            break;
            case 3: ColorCost = 1100;
            break;
            default: ColorCost = 500;
        }
//      See what month the customer will buy the vehicle
        System.out.print("Month of Automobile Purchase: (Jan -> 1, Dec -> 12): ");
        WhatMonth = scan.nextInt();

//      Ask the user how much the down payment will be
        System.out.print("How much will the down payment be?: ");
        String UsrInput = scan.next();
        DownPay = Integer.parseInt(UsrInput.replace("$",""));
//      Based on the users input for the down payment the system will store a discount code to be used later
        if (DownPay >= 5000 && DownPay < 10000 )
        {
            Discount = 1;
        }
        else if (DownPay >= 10000)
        {
            Discount = 2;
        }
        else
        {
            Discount = 0;
        }
//      All computation statements are to follow
//      Based on the discount code stored above we have the program preform different functions
        switch (Discount)
        {
            case 1: ColorCost -= (ColorCost * 0.25);
            break;
            case 2: InteriorCost -= (InteriorCost * 0.35);
            break;
        }
        SubTotal = ModelCost + InteriorCost + ColorCost;
//      Below is the method that contains the users month of purchase to calculate the discounted subtotal
        switch (WhatMonth)
        {
            case 5:
            case 11:
                SubTotalDiscounted = SubTotal - (SubTotal * 0.10);
            break;
            default: SubTotalDiscounted = SubTotal;
        }
//      This section of code calculates our sales taxes and stores the value for later usage
        if (Discount == 2)
        {
            TaxCost = 0;
        }
        else
        {
            TaxCost = (SubTotalDiscounted * 0.0975);
        }
//      Follows are the final calculations that we need to form our system print-outs
        Total = TaxCost + SubTotalDiscounted;
        FinalTotal = Total - DownPay;
//      Below is the system output for all the different varibles that we created and stored throughout the program
        System.out.println("Base Model Price: $" + ModelCost);
        if (Discount == 1 )
        {
            System.out.println("Paint Color Cost: $" + ColorCost + "(With a 25% Discount!)");
        }
        else
        {
            System.out.println("Paint Color Cost: $" + ColorCost);
        }
        if (Discount == 2)
        {
            System.out.println("Interior Cost: $" + InteriorCost + "(With a 35% Discount!)");
        }
        else
        {
            System.out.println("Interior Color Cost: $" + InteriorCost);
        }
        System.out.println("-----------------------");
        switch(WhatMonth)
        {
            case 5:
            case 11:
                System.out.println("Subtotal: $" + SubTotal);
                System.out.println("With May/Nov Discount: $" + SubTotalDiscounted);
            break;
            default: System.out.println("Subtotal: $" + SubTotal);
        }
        System.out.println("-----------------------");
        if (TaxCost <= 0)
        {
            System.out.println("No Tax! - Large Down Payment!");
        }
        else
        {
            System.out.println("Tax Amount: $" + TaxCost);
        }
        System.out.println
                ("-----------------------\n" +
                "Total: $" + Total +
                "\n-----------------------\n" +
                "Subtract Down Payment: -$" + DownPay +
                "\n-----------------------" +
                "\nFinal Total: $" + FinalTotal +
                "\n-----------------------");
       /*
            In effort to reduce the amount of redundant calls I utilized Chucks of print statements and formatted them
            with escape codes. This allows for the proper formatting while reducing the Print functions called.
       */
    }
}
