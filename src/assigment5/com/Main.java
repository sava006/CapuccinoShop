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
        Scanner scanner = new Scanner(System.in);
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
        System.out.println(listString);
       // List<String> Coffee2 = new ArrayList<String>()
            //create a String Array
        String Coffee [] = listString.split(",");
        //bufreader.close();
        //String names = "";
            // these are for the grand totals at the end for total store sales
        double CostDrink = 0.0;
            double CostDrink2 = 0.0;
        double Sales = 0.0;
        double profits = 0.0;
            double profits2 = 0.0;
        int count = 0;
            //we need to set the Coffee.lengt - 1 else an ArrayIndexoutBoundsException
            //will be thrown
        for (int i = 0; i < Coffee.length -1; i += 3
                ) {
            //How of each item were sold.
            System.out.println("How many cups of " + Coffee[i] + " were sold today?");
            //have the customer enter any value they want string or int, letter
            //etc. However we will catch the mistake
            String numInput = scanner.nextLine();
           // int number;
           // checkinput(numInput);
            //was originally going to do while loop but then I
            //wanted to put in a function
            /*while (numInput.matches("^[0-9]+$") == false){
                System.out.println("Your input is not an Integer" +
                        "Please reenter your values");
                numInput = scanner.nextLine();
                if (numInput.matches("^[0-9]+$") == true){
                    break;
                }
            }
            number = Integer.parseInt(numInput);*/
           // Pattern patter

            //int number = scanner.nextInt();

           // int number = Integer.parseInt(numInput);
            //would like to find away to return some of these
            //items into a method as well. Just to much taking places
            double price = Double.parseDouble(Coffee[i + 2]);
            double itemcost = Double.parseDouble(Coffee[i + 1]);
            double itemcost2 = Math.round(itemcost * 100.0) / 100.0;
            // CostDrink += itemcost2;
            double GrossProfit = checkinput(numInput) * price;
            double Grossprofit2 = Math.round(GrossProfit * 100.0) / 100.0;
            double costitemtotal = itemcost2 * checkinput(numInput);
            double cost2 = Math.round(costitemtotal * 100.0) / 100.0;
            double netprofit = GrossProfit - costitemtotal;
            double net2 = Math.round(netprofit * 100.0) / 100.0;
            System.out.println(Coffee[i] + " cups sold is: " + checkinput(numInput) + " cost $" +
                    itemcost2 + " price per cup $" + Coffee[i + 2] + " gross: $" + Grossprofit2 + " cost item total: "
                    + cost2 +
                    "$" + " net profit $" + net2);
            reports.write("Sold :" + checkinput(numInput) + " Expenses $" + cost2 + " Revenues $" + Grossprofit2 + " Profits $" +
            net2 + "\n");
            Sales += Grossprofit2;
            CostDrink += cost2;
            CostDrink2 = Math.round(CostDrink * 100.0)/100.0;
            profits += net2;
            count += checkinput(numInput);

        }
        System.out.println("total cups " + count + ", total sales $" + Sales +
                " total costs $" + CostDrink2 + " profits $" + profits);

            reports.write(count + " cups sold, total expensense $" + CostDrink2 + " total Revenues $" + Sales +
            "Profits $" + profits + "\n");
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
    public static int checkinput(String inputs){
        int nums;
        Scanner scanner2 = new Scanner(System.in);
        //tring inputs2 = inputs;
        while(inputs.matches("^[0-9]+$") == false){
            //enter another value to continue
           /* System.out.println("you enter a value that is not correct" +
                    " please reenter");
             inputs = scanner2.nextLine(); */
            if (inputs.matches("[0-9]") == true){
                break;
            }
            System.out.println("you enter a value that is not correct" +
                    " please reenter");
            inputs = scanner2.nextLine();
        }
        nums = Integer.parseInt(inputs);
        return nums;
    }

        }


