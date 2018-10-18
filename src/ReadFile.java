import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Oliver & Christopher 
 */


public class ReadFile 
{
    
    private String[] savedRecords = new String [100];
    private int recordCount;
    
    //Takes the saved records and transfers them from a temperary array to an active array.
    public String[] loadRecords(String[] transactionLog)
    {
        this.getRecords();
        transactionLog = savedRecords;
        return transactionLog;
    }
    
    //Takes the counted unnmber of records in the file and transfers this value to an active variable
    public int loadCount(int counter)
    {
        this.getCount();
        counter = recordCount;
        return counter;
    }
    
      // Reads the records from the text file into an array
    private void getRecords()
    {
        try
        {
            BufferedReader readFile = new BufferedReader(new FileReader("TransactionDetails.txt"));
            List<String> entries = new ArrayList<String>();
            String tempStore;
            
            try
            {
                while((tempStore = readFile.readLine())!= null) 
                {
                    if(readFile.readLine() != null)
                    {
                        entries.add(tempStore);
                    }          
                }
                readFile.close();
                savedRecords = entries.toArray(new String[]{});
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

    // Counts how many records are currently stored in the text file
    private void getCount()
    {
        try
        {
            Scanner read = new Scanner(new File("TransactionDetails.txt"));
            int count = 0;
            
            while (read.hasNextLine())
            {
                String line = read.nextLine();
                
                if (!line.equals("null"))
                {
                    count++;
                }
            }
            recordCount = count - 100;
            System.out.println("Current Number of Records: " + recordCount);
        }
        
        catch (IOException e)
        {
            System.out.println("IOException has occured1");
        }
    }
}
