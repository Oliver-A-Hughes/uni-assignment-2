import java.util.Scanner;
import java.text.DecimalFormat;
/**
 * @author Oliver & Christopher 
 */


public class Reports 
{
    //Array used to store the records in the text file
    private String[] reportArray = new String [100];
    
    // Variables used to accept and compare user inputed dates 
    private int startDate;  
    private int endDate;
    
    // Variables used to retrieve the date from each record 
    private String s_arrayDate;
    private int arrayDate;
    
    // Variable used to accept user inputed recipient 
    private String enteredRecipient;
    
    // Variable used to retrieve the recipient from each record 
    private String s_arrayRecipient;

    // Variables used to retrieve and add the amount spent from each record
    private String s_arraySpent;
    private double arraySpent;
    
    // Variables used to retrieve the category from each record from each record
    private String s_arrayCat;
    private int arrayCat;
    
    // Variable used to accept user inputed category 
    private int categoryNum;
    
    //Variable used to store which report was requested by the user
    private int reportNum;
    
    //Variable used to keep track of the total cost in report1 & report2.
    private double totalCost;
    
    // Method used to generate report 1
    protected void generateReport1()
    {   
        reportNum = 1;
        this.enterDate();
        this.readRecords();
        this.createReport();
        this.displayTotal();
    }
    
    // Method used to generate report 2
    protected void generateReport2()
    {
        reportNum = 2;
        this.enterDate();
        this.enterCategory();
        this.readRecords();
        this.createReport();
        this.displayTotal();
    }
    
    // Method used to generate report 3
    protected void generateReport3()
    {
        reportNum = 3;
        this.enterDate();
        this.readRecords();
        this.createReport();
    }
    
    // Method used to generate report 4
    protected void generateReport4()
    {
        reportNum = 4;
        this.enterDate();
        this.enterRecipient();
        this.readRecords();
        this.createReport();
    }
    
    // Collaborates both the enterStartDate and enterEndDate for efficiency 
    private void enterDate()
    {
        this.enterStartDate();
        this.enterEndDate();
    }
    
    // Allows the user to enter the start date and converts the input to yyyymmdd format
    private Integer enterStartDate()
    {
        String s_startDate;
        
        System.out.println("Please enter the starting date in dd/mm/yyyy ");
       
        Scanner inputDate = new Scanner(System.in);
        s_startDate = inputDate.next();
        
        Date_Change convert = new Date_Change();
        convert.changeDate(s_startDate);
        s_startDate = convert.dateChanged;
        
        startDate = Integer.parseInt(s_startDate);
        
        return startDate;
    }
    
    // Allows the user to enter the end date and converts the input to yyyymmdd format
    private Integer enterEndDate()
    {
        String s_endDate;
        
        System.out.println("Please enter the ending date in dd/mm/yyyy ");
        
        Scanner inputDate = new Scanner(System.in);
        s_endDate = inputDate.next();
        
        Date_Change convert = new Date_Change();
        convert.changeDate(s_endDate);
        s_endDate = convert.dateChanged;
        
        endDate = Integer.parseInt(s_endDate);
        
        return endDate;
    }
    
    // Allows the user to enter the Recipient
    private String enterRecipient()
    {
        System.out.println("Please enter the name of the Recipient you are looking for");
        
        Scanner inputRecipient = new Scanner(System.in);
        enteredRecipient = inputRecipient.nextLine();
        
        return enteredRecipient;
    }
    
    // Allows the user to enter the Category
    private Integer enterCategory()
    {
        System.out.println("Please enter the Category number you would like to search by.");
        
        Scanner inputCategory = new Scanner(System.in);
        categoryNum = inputCategory.nextInt();
        
        return categoryNum;
    }

    // Reads the records from the text file into an array
    private void readRecords()
    {
        ReadFile read = new ReadFile();
        reportArray = read.loadRecords(reportArray);
    }

    // Returns the Date from the array in yyymmdd form
    private Integer getArrayDate()
    {
        String[] getDate = s_arrayDate.split(" ");
        s_arrayDate = getDate[0];
        
        Date_Change convert = new Date_Change();
        convert.changeDate(s_arrayDate);
        s_arrayDate = convert.dateChanged;
        
        arrayDate = Integer.parseInt(s_arrayDate);
        
        return arrayDate;
    }
    
    // Returns the amount spent on each item from the array
    private Double getArraySpent()
    {
        String[] getSpent = s_arraySpent.split("  ");
        s_arraySpent = getSpent[2];
        
        ReportRetrievals spendings = new ReportRetrievals();
        spendings.retrieveSpent(s_arraySpent);
        s_arraySpent = spendings.recordSpend;
        
        arraySpent = Double.parseDouble(s_arraySpent);
        
        return arraySpent;
    }
    
    // Returns the categorgy from the array
    private Integer getArrayCat()
    {
        String[] getCat = s_arrayCat.split("  ");
        s_arrayCat = getCat[1];
        
        ReportRetrievals category = new ReportRetrievals();
        category.retrieveCategory(s_arrayCat);
        s_arrayCat = category.recordCat;
        
        arrayCat = Integer.parseInt(s_arrayCat);
        
        return arrayCat;
    }
    
    // Returns the Recipient from the array
    private String getArrayRecipient()
    {
        String[] getRecip = s_arrayRecipient.split("  ");
        s_arrayRecipient = getRecip[3];
        
        ReportRetrievals recipient = new ReportRetrievals();
        recipient.retrieveRecipient(s_arrayRecipient);
        s_arrayRecipient = recipient.recordRecipient;
        
        return s_arrayRecipient;
    }
    
    /* Creates a report using the information provided by the user. 
    Case numbers correspond to the report numbers */
    private void createReport()
    {
        for (String compareRecord : reportArray) 
        {
            s_arrayDate = compareRecord;
            if (!"null".equals(s_arrayDate)) 
            {
                this.getArrayDate();
                
                if ((arrayDate <= endDate) && (arrayDate >= startDate)) 
                {
                    switch (reportNum) 
                    {
                        case 1: 
                            s_arraySpent = compareRecord;
                            this.getArraySpent();
                            totalCost = totalCost + arraySpent;                     
                            break;
                    
                        case 2:
                            s_arrayCat = compareRecord;
                            this.getArrayCat();
                            if (arrayCat == categoryNum) 
                            {
                               s_arraySpent = compareRecord;
                               this.getArraySpent();
                               totalCost = totalCost + arraySpent;
                            }  
                            break;
                    
                        case 3:
                            System.out.println(compareRecord);
                            break;
                    
                        case 4:
                            s_arrayRecipient = compareRecord;
                            this.getArrayRecipient();
                            if (s_arrayRecipient.equals(enteredRecipient)) 
                            {
                                System.out.println(compareRecord);
                            }   
                            break;
                        
                        default:
                            System.out.println("Error has occured, returning to main menu");
                            UI_Menu home = new UI_Menu();
                            home.UI();
                            break;
                    }
                }
            }
        }
    }
    
    /*Outputs the amount of money spent for reports one and two. 
    Case numbers correspond to the report numbers*/
    private void displayTotal()
    {      
        DecimalFormat total = new DecimalFormat("##.00"); 
        switch (reportNum) 
         {
            case 1: 
                System.out.println("The amount spent between the supplied dates is: £" + total.format(totalCost));  
                break;
            
            case 2:    
                System.out.println("The amount spent between the supplied dates for category " 
                        + categoryNum + " is: £" + total.format(totalCost));
                break;
         }                      
    }
}