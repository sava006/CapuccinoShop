package assigment5.com;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.List;
import  java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
	// write your code here
        try {
            //we need a scanner to look for new new variables
        //Scanner scanner = new Scanner(System.in);
            //read the text with a buffer reader
        BufferedReader bufreader = new BufferedReader(new FileReader("coffee (2).txt"));
            //read the file report into the sales-reports.txt files
            FileWriter reports = new FileWriter("sales-reports.txt");
            //read line by line using the bufreader
        String line = bufreader.readLine();
            //Add each line into an Arraylist
        ArrayList<String> drinks = new ArrayList <String> ();
        while (line != null){
            //read line by line to the String line
            line = bufreader.readLine();
            //add each line to line to our Array
            drinks.add(line);
        }
            //remove null values from drinks
        drinks.remove(null);
            //remove empty values
            drinks.remove("");
            //add our list to a string
        String listString = "";

        for (String  s: drinks){
            //adds one big super string
            listString += s + ",\n";
        }
            //replace all values that are equal ; with a ,
       listString = listString.replaceAll(";",",");
       //close the bufreader.
        bufreader.close();
            // print our list string so we know what the list should look like
       // System.out.println(listString);
       // List<String> Coffee2 = new ArrayList<String>()
            //create a String Array
        String Coffee [] = listString.split(",");
        //bufreader.close();
        //String names = "";
            // these are for the grand totals at the end for total store sales
        double CostDrink = 0.0;
        double Sales = 0.0;
        double profits = 0.0;
        int count = 0;
            //we need to set the Coffee.lengt - 1 else an ArrayIndexoutBoundsException
            //will be thrown
        for (int i = 0; i < Coffee.length -1; i += 3
                ) {
            //How of each item were sold.
            System.out.println("How many cups of " + Coffee[i] + " were sold today?");
            //have the customer enter any value they want string or int, letter
            //etc. However we will catch the mistake
            Scanner scanner = new Scanner(System.in);

            String numInput = scanner.nextLine();
            double expense = Expenses(checkinput(numInput), Coffee[i+1]);
            double revs  = Revenues(checkinput(numInput), Coffee[i+2]);
            System.out.println(Coffee[i] + " cups sold is: " + checkinput(numInput) + " cost per cup, $" +
                    Coffee[i+1] + " price per cup $" + Coffee[i + 2] + " gross: $" + revs + " cost item total: "
                    + expense + "$" + " net profit $" + Profits(expense, revs));
            reports.write("Sold :" + checkinput(numInput) + " Expenses $" + expense + " Revenues $" + revs + " Profits $" +
            Profits(expense,revs) + "\n");
            Sales += revs;
            CostDrink += expense;
            profits += Profits(expense, revs);
            count += checkinput(numInput);
        }
        System.out.println("total cups " + count + ", total sales $" + roundfinals(Sales) +
                " total costs $" + roundfinals(CostDrink) + " profits $" + roundfinals(profits));
            reports.write(count + " cups sold, total expensense $" + roundfinals(CostDrink) + " total Revenues $" + roundfinals(Sales) +
            "Profits $" + roundfinals(profits) + "\n");
            reports.close();
        }
        catch (IOException ae){
            ae.printStackTrace();
            System.out.println("The file was not read or written " +
                    "correctly");
        }
        catch (InputMismatchException b){
            System.out.println("Data entered is not an integer");
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("there is nothing left");
        }
        }
    //rounds all final input for final sales into sensible values that are not .666666655 etc
    //and only rounding it once not each time
    public static double roundfinals(double z){
        double moneyvalue = Math.round(z * 100.0)/100.0;
        return moneyvalue;
    }
    //code to calculate expenses for each drink
    public static double Expenses(int num, String costit){
        double itemcost = Double.parseDouble(costit);
        double totaldrinkcost = num * itemcost;
        double totaldrinkcostround = Math.round(totaldrinkcost * 100.0)/100.0;
        return totaldrinkcostround;
    }
    //The revenues method for each product
    public static double Revenues(int num, String sales){
        double saleprice = Double.parseDouble(sales);
        double salesfordrink = num * saleprice;
        double salesfordrinkround = Math.round(salesfordrink * 100.0)/100.0;
        return salesfordrinkround;
    }
    //Profits for each item
    public static double Profits (double revnues, double sales){
        double profits = sales - revnues;
        double profitsround = Math.round(profits * 100.0)/100.0;
        return profitsround;

    }
    public static int checkinput(String inputs) {
        int nums;
        Scanner scanner2 = new Scanner(System.in);
        //tring inputs2 = inputs;
        while (inputs.matches("^[0-9]+$") == false) {
            //enter another value to continue
            String inputs2;
            System.out.println("you enter a value that is not correct" +
                    " please reenter");
             inputs2 = scanner2.nextLine();
            if (inputs2.matches("^[0-9]+$") == true){
                inputs = inputs2;
            break;
        }
        //System.out.println("you enter a value that is not correct" +
          //      " please reenter");
       // inputs = scanner2.nextLine();
    }
        nums = Integer.parseInt(inputs);
        return nums;
    }

        }


