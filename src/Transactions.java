import java.io.*;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Oliver & Christopher 
 */


public class Transactions extends Object
{
    // Declaring variables that will be later used
    private String Date;
    private int Category;
    private String Recipient;
    private double Spendings;
    private int recordNum;
    
    // Declaring vairables that will then be used to convert from Integer and Double to String
    private String Spend;
    private String Cat;
    
    // Declaring Array tranHistory, as String
    private String[] tranHistory = new String [100];
    

    // Allows the user to add a Transaction
    public void addTransaction()
    {
        this.enterInfo();
        this.inputRecords();
    }
    
    // Gets the user to enter the information required to populate a record
    private void enterInfo()
    {
        this.isFileEmpty();
        this.enterDate();
        this.enterCategory();
        this.enterMoneySpent();
        this.enterRecipient();
    }
    
    // Checks if the file is empty - if it isn't empty then it will read in the content from the file.
    private void isFileEmpty()
    {
        try
        {
            BufferedReader readFile = new BufferedReader(new FileReader("TransactionDetails.txt"));
            
            try
            {
                if(readFile.readLine() != null)
                {
                    this.readRecords();
                    this.entryCount();
                }
                readFile.close();
            }
     
            catch (IOException e)
            {
                System.out.println("IOException has occured");
            }
        }
        
        catch (FileNotFoundException ex)
        {
            System.out.println("File Not Found Error");
        }
    }
    
    // Calls the methods that read data from the saved file
    public void readFile()
    {
        this.readRecords();
        this.entryCount();
    }
    
    // Reads in the current transactions stored in the text file
    private void readRecords()
    {
       ReadFile read = new ReadFile();
       tranHistory = read.loadRecords(tranHistory);
    }
    
    // Counts how many records are stored in the text file
    private void entryCount()
    {
        ReadFile count = new ReadFile();
        recordNum = count.loadCount(recordNum);
    }
    
    // Allows the user to enter the date
    private String enterDate()
    {
        System.out.println("Please enter the Date in dd/mm/yyyy ");
        
        Scanner inputDate = new Scanner(System.in);
        Date = inputDate.next();
        
        if(Date.isEmpty())
        {
            this.enterDate();
        }
        
        return Date;
    }
    
    // Allows the user to enter/choose a Category
    private int enterCategory()
    {
        System.out.println("Please enter the transaction Category number. "
                + "\n" + "1 - Rent" + "\n" + "2 - Electricity" + "\n" + "3 - ISP" + "\n" + "4 - Gas"
                + "\n" + "5 - Mobile Phone" + "\n" + "6 - Groceries" + "\n" + "7 - Entertainment"
                + "\n" + "8 - Eating Out" + "\n" + "9 - Public Transport" + "\n" + "10 - Car");
        
        Scanner inputCategory= new Scanner(System.in);
        Category = inputCategory.nextByte();
        
        // Switch Statement to provide feedback to user
        switch (Category) 
        {
            case 1:
                System.out.println("Rent Category Selected");
                break;
            case 2:   
                System.out.println("Electricity Category Selected");
                break;
            case 3:
                System.out.println("ISP Category Selected");
                break;
            case 4:
                System.out.println("Gas Category Selected");
                break;
            case 5:
                System.out.println("Mobile Phone Category Selected");
                break;
            case 6:
                System.out.println("Groceries Category Selected");
                break;
            case 7:
                System.out.println("Entertainment Category Selected");
                break;
            case 8:
                System.out.println("Eating Out Category Selected");
                break;
            case 9:
                System.out.println("Public Transport Category Selected");
                break;
            case 10: 
                System.out.println("Car Category Selected");
                break;     
            default:
                this.enterCategory();
        }
        Cat = Integer.toString(Category);
        
        if(Cat.isEmpty())
        {
            this.enterCategory();
        }
        return Category;
    }
    
    // Method that allows the user to enter the amount spent
    private double enterMoneySpent()
    {
        System.out.println("Please enter the amount of money spent");
         
        Scanner inputMoney = new Scanner(System.in);
        Spendings = inputMoney.nextDouble();
         
        DecimalFormat currency = new DecimalFormat("0.00");
        System.out.println("£" + currency.format(Spendings));
         
        Spend = Double.toString(Spendings);
        
        if(Spend.isEmpty())
        {
            this.enterMoneySpent();
        }
        
        return Spendings;
    }
    
    // Allows the user to enter the Recipient 
    private String enterRecipient()
    {
        System.out.println("Please enter the name of the recipient");
        
        Scanner inputRec = new Scanner(System.in);
        Recipient = inputRec.nextLine();

        if(Recipient.isEmpty())
        {
            this.enterRecipient();
        }      
        return Recipient;
    }
    
    // Takes the information the user has entered and assigns it to a record number in the array
    private void inputRecords()
    {
        tranHistory[recordNum] = Date + "  " + Cat + "  " + Spend  + "  " + Recipient + "  ";
        System.out.println(Arrays.toString(tranHistory));
        
        recordNum++;
        this.recordOptions();
    }
    
    // Provides the user with options once they have entered the required information 
    private void recordOptions()
    {
        Scanner inOption = new Scanner(System.in);
        System.out.println("Please enter:"
               + "\n" + "1 - Save & Add another row"
               + "\n" + "2 - Save & Exit back to the main screen"
               + "\n" + "3 - Cancel & Exit to the main screen");
        
        byte chosenOpt = inOption.nextByte();
        
        switch (chosenOpt)
        {
            case 1:
                System.out.println("You have chosen to Save & Add another row");
                this.saveRecords();
                this.addTransaction();
                break;

            case 2:
                System.out.println("You have chosen to Save & Exit back to the main screen");
                this.saveRecords();
                UI_Menu menu = new UI_Menu();
                menu.UI();
                break;

            case 3:
                System.out.println("You have chosen to Cancel & Exit back to the main screen");
                UI_Menu mainScreen = new UI_Menu();
                mainScreen.UI();
                break;

            default:
                System.out.println("Error, please enter either 1 or 2.");
                this.recordOptions();
        }
    }
    
    // Saves the reccords to a text file
    private void saveRecords()
    {
        try
        {
            PrintWriter transactionLog = new PrintWriter(
            new BufferedWriter(new FileWriter("TransactionDetails.txt")));
            
            for(int i = 0; i < tranHistory.length; i++)
            {
                transactionLog.println(tranHistory[i] + "\n");
            }
            transactionLog.flush();
            transactionLog.close();        
        }
        
        catch (IOException e)
        {
            System.out.println("IOException");    
        }
        System.out.println(Arrays.toString(tranHistory));
    }  
}