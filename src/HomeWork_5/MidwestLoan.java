package HomeWork_5;

import java.util.Scanner;

/*
   Author Name: Cody Bishop
   Date: 03/06/2020
   Program: Midwest Loan
   Description: This program was created to be utilized by employees of Midwest Loan, the purpose of the program is to
   store customer data and create loan schedules from that data
*/
public class MidwestLoan
{
    public static void main(String[] args)
    {
        //Creation of some major variables used throughout the program
        Scanner scan = new Scanner(System.in);
        int customerID = 1;
        int currentArrayLocation = 0;
        int trigger = 0;
        int who;
        int error;
        String menuChoice;
        String[][] customerData = new String[100][6];
        double[][] loanInfo = new double[100][4];
        //While loop to create and use the menu system. The system will not exit until the user chooses to exit
        while (trigger == 0)
        {
            //Main body of the menu, This is the listing of all
            System.out.println("Welcome to Midwest Loan's Loan creation application!\n" +
                    "Please choose one of the following options" );
            System.out.println("(C)reate a new Customer \n" +
                    "(P)rint a Loan Amortization Table \n" +
                    "(V)iew Customer Info\n" +
                    "(E)xit" );
            System.out.println("(Enter either the first word or letter of your desired choice): ");
            menuChoice = scan.next();
            //Makes sure the system does not accidentally throw an out of bounds exception
            if (menuChoice.length() >= 1)
            {
                menuChoice = menuChoice.substring(0, 1);
                menuChoice = menuChoice.toLowerCase();
            }

            //This if statement contains all data regarding customer creation.
            if(menuChoice.equals("c"))
            {
                // Utilization of methods to keep the main application clean.
                // The usage of temporary arrays allows the data to be added to our larger main array easily
                String[] tempCustomer = customerCreation(customerID);
                double[] tempLoan = loanCreation(customerID);
                //Copying of data from temp arrays to main arrays
                for(int i = 0; i < 6; i++)
                {
                    customerData[currentArrayLocation][i] = tempCustomer[i];
                    // this if statement allows the two arrays to be copied in 1 for loop
                    if(i < 4)
                    {
                        loanInfo[currentArrayLocation][i] = tempLoan[i];
                    }
                }
                System.out.println("Customer was created successfully!\n");
                //These keep track of the next empty array position and the customer id that was assigned automatically
                currentArrayLocation++;
                customerID ++;
            }

            // This if statement contains all data regarding amortization schedule creation and display.
            if(menuChoice.equals("p"))
            {
                customerSelection(customerData,currentArrayLocation);
                System.out.println("Please Enter the customer ID you would like to print");
                who = scan.nextInt();
                who --;
                //Logic to gather the correct customers information
                double loanAmt = loanInfo[who][1];
                double interestRate = loanInfo[who][2];
                interestRate /= 100;
                interestRate /= 12;
                double monthlyPayment = loanInfo[who][3];
                //This is used to ensure that the customer can pay off the loan within 1000 months.
                error = loanLength(loanAmt, interestRate, monthlyPayment);
                //If the customer is unable to pay off the loan in 1000 months it is most likely using incorrect info
                if(error == -1)
                {
                    // If there is an error the system allows the user to correct the information or Change the terms
                    System.out.printf("Please reenter %s's Loan data%n",customerData[who][1] + " " +
                            customerData[who][2]);
                    double[] editedLoan = loanCreation(who + 1);
                    for(int i = 0; i < 4; i++)
                    {
                        loanInfo[who][i]= editedLoan[i];
                    }
                    //after the loan data is altered the user goes back to the main menu to preform the next operation
                }
                //if the loan is able to be paid off within 1000 months the system will print the Amortization Table
                else
                {
                    // Here we use some print statements to create a visually pleasing and informative printout
                    System.out.println("_____________________________________________________________________");
                    System.out.printf("%-59s%n",
                            "|----------------------MidWest Loan Company-------------------------|");
                    System.out.printf("%-59s%n",
                            "|---------------------Loan Amortization Schedule--------------------|");
                    System.out.printf("|Customer Name : %-22s Loan Amount : $%-13.2f|%n",
                            customerData[who][1] + " " + customerData[who][2], loanAmt);
                    System.out.printf("|Interest Rate: %5.2f%-18s Monthly Payment: $%-10.2f|%n",
                            ((interestRate * 100) * 12), "%", monthlyPayment);
                    //Once the header is created the system calls the loanCalculator method
                    loanCalculator(loanAmt,interestRate,monthlyPayment);
                    System.out.println("|___________________________________________________________________|\n");
                }
            }
            //Use this choice to view a customer data print out
            if(menuChoice.equals("v"))
            {
                customerSelection(customerData,currentArrayLocation);
                System.out.println("Please Enter the customer ID you would like to print");
                who = scan.nextInt();
                who --;
                printCustomerData(customerData[who],loanInfo[who]);
            }
            //If the user wishes to exit the program the system changes the trigger value thus breaking the loop
            if (menuChoice.equals("e"))
            {
                System.out.println("Have a nice day!");
                trigger = 1;
            }
        }
    }
    // This is the method to gather all customer data and return the array to the main application
    public static String[] customerCreation(int id)
    {
        Scanner scan = new Scanner(System.in);
        String[] tempCustomer = new String[6];
        tempCustomer[0] = id + "";
        System.out.println("Please Enter Customer's First Name: ");
        tempCustomer[1] = scan.nextLine();
        System.out.println("Please Enter Customer's Last Name: ");
        tempCustomer[2] = scan.nextLine();
        System.out.println("Please Enter Customer's Address: ");
        tempCustomer[3] = scan.nextLine();
        System.out.println("Please Enter Customer's Cell Phone Number: ");
        tempCustomer[4] = scan.nextLine();
        System.out.println("Please Enter Customer's Age: ");
        tempCustomer[5] = scan.nextLine();
        return tempCustomer;
    }
    //Method used to create loan data for the double array.
    public static double[] loanCreation(int id)
    {
        Scanner scan = new Scanner(System.in);
        double[] tempLoan = new double[4];
        tempLoan[0] = id;
        System.out.println("Please Enter Loan Amount: ");
        tempLoan[1] = scan.nextDouble();
        System.out.println("Please Enter Loan Interest Rate: ");
        tempLoan[2] = scan.nextDouble();
        System.out.println("Please Enter Desired Monthly Payment: ");
        tempLoan[3] = scan.nextDouble();
        return tempLoan;
    }
    //A method to print out the customer data menu
    public static void customerSelection(String[][] data,int currentLoc)
    {
        for (int o = 0; o < currentLoc; o++)
        {
            for (int i = 0; i < 3; i++)
            {
                System.out.printf("%-10s",data[o][i]);
            }
            System.out.println(" ");
        }
    }
    // a method to created a printout of customer data
    public static void printCustomerData(String[] customer,double[] loan)
    {
        System.out.println("_____________________________________________________________________");
        System.out.printf("%-59s%n",
                "|---------------------Customer Data Printout------------------------|");
        System.out.printf("|Customer ID : %-10s Customer Name: %-27s|%n",
                customer[0],customer[1] + " " + customer[2]);
        System.out.printf("|Customer Address: %-49s|%n",customer[3]);
        String formattedNum = customer[4].replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3" );
        System.out.printf("|Phone Number: %-17s Customer Age: %-21s|%n", formattedNum,customer[5]);
        System.out.printf("|Loan Amount: $%-16.2f  Interest Rate: %5.2f%-15s|%n" +
                        "|Monthly Payment: $%-49.2f|%n", loan[1], loan[2], "%", loan[3]);
        System.out.println("|___________________________________________________________________|\n");
    }
    //The most detailed method in the program to handle all calculations and calls to other crucial methods
    public static void loanCalculator(double principle, double interest, double payment)
    {
        double currentBal;
        double endBal = principle;
        double monthlyInterest;
        int loanLength = loanLength(principle, interest, payment);
        if(loanLength == -1)
        {
            return;
        }
        //this is were the amortization schedule is built.
        double[][] amortizationTable = new double[loanLength][5];
        for (int i = 0; i < loanLength; i++)
        {
            currentBal = endBal;
            amortizationTable[i][0] = i + 1;
            amortizationTable[i][1] = currentBal;
            monthlyInterest = currentBal * interest;
            amortizationTable[i][2] = monthlyInterest;
            endBal = currentBal + (monthlyInterest - payment);
            if(endBal <= 0)
            {
                payment = currentBal + monthlyInterest;
                endBal = 0;
            }
            amortizationTable[i][3] = payment;
            amortizationTable[i][4] = endBal;
        }
        //here is the method call for the printing function
        printTable(amortizationTable);
    }
    //loanLength method used to calculate the length of the loan
    public static int loanLength(double principle, double interest, double payment)
    {
        int loanLength = 0;
        double currentBalance;
        double endBalance = principle;
        int error = 0;
        while(endBalance > 0)
        {
            currentBalance = endBalance;
            endBalance = currentBalance + ((currentBalance * interest) - payment);
            loanLength++;
            error++;
            //This loop has the ability to exit the while loop if the loan is invalid due to possible errors
            if(error > 1000)
            {
                System.out.println("Error customer can not pay off this loan with the current constraints\n" +
                        "Please inform customer");
                loanLength = -1;
                break;
            }
        }
        return loanLength;
    }
    //method used to print the amortization table
    public static void printTable(double[][] data)
    {
        double totInt= 0.0;
        System.out.printf("|%-11s| |%-11s| |%-11s| |%-11s| |%-11s|%n", "Month","Balance","Interest","Payment","End Balance");
        for(int o = 0; o < data.length;o++)
        {
            System.out.printf("|%-11.0f|",data[o][0]);
            System.out.print(" ");
            for(int i =1; i <5; i++)
            {
                System.out.printf("|$%,-10.2f|", data[o][i]);
                System.out.print(" ");
                if(i == 2)
                {
                    totInt += data[o][i];
                }
            }
            System.out.println();
        }
        System.out.printf("|Total Interest Paid : $%-44.2f|%n|Total Payment Amount: $%-44.2f|%n",
                totInt, (data[0][1] + totInt));
    }
}
