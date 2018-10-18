import java.util.Scanner;

/**
 * @author Oliver & Christopher 
 */


public class UI_Menu
{   
    public void UI()
    {
        this.menuGrp_1();
    }
    
    // User selects between Reports or Transactions
    private void menuGrp_1()
    {
        Scanner inpGrp_1 = new Scanner(System.in);
        System.out.println("Please select to one of the following options: "
                + "\n" + "1 - Genterate a Report"
                + "\n" + "2 - Add New Transactions"
                + "\n" + "3 - Exit the program");
        
        byte optGrp_1 = inpGrp_1.nextByte();
        
        switch (optGrp_1)
        {
            case 1:
                System.out.println("You have to selected to Generate a Report.");
                this.menuGrp_2();
                break;
                
            case 2:
                System.out.println("You have to selected to Add New Transactions.");
                Transactions newInput  = new Transactions();
                newInput.addTransaction();
                break;

            case 3:
                System.exit(0);
                break;
            
            default:
                System.out.println("Error, please enter either 1 or 2.");
                this.menuGrp_1();
        }
    }
    
    // User selects between the 4 Report options
    private void menuGrp_2() 
    {
        Scanner inpGrp_2 = new Scanner(System.in);
        System.out.println("Please select which type of Report to Generate. "
                + "\n" + "1 - The total amount of money spent between any two supplied dates."
                + "\n" + "2 - The amount spent on a given category between two supplied dates."
                + "\n" + "3 - A list of all transaction records between any two supplied dates."
                + "\n" + "4 - A list of transactions with a given recipient between any two supplied dates."
                + "\n" + "5 - To go back to the previous option group");
        
        byte optGrp_2 = inpGrp_2.nextByte();
        
        switch (optGrp_2)
        {
            case 1:
                System.out.println("The total amount of money spent between any two supplied dates.");
                // Calls the corresponding method from the Reports class
                Reports rep1 = new Reports();
                rep1.generateReport1();
                break;
                
            case 2:
                System.out.println("The amount spent on a given category between two supplied dates.");
                // Calls the corresponding method from the Reports class
                Reports rep2 = new Reports();
                rep2.generateReport2();
                break;
                
            case 3:
                System.out.println("A list of all transaction records between any two supplied dates.");
                // Calls the corresponding method from the Reports class
                Reports rep3 = new Reports();
                rep3.generateReport3();
                break;
                
            case 4:
                System.out.println("A list of transactions with a given recipient between any two supplied dates.");
                // Calls the corresponding method from the Reports classbreak;
                Reports rep4 = new Reports();
                rep4.generateReport4();
                break;
            
            case 5:
                System.out.println("To go back to the previous option group");
                this.menuGrp_1();
                break;
                
            default:
                System.out.println("Error, please enter either 1, 2, 3, 4 or 5");
                this.menuGrp_2();
        }
    }
}