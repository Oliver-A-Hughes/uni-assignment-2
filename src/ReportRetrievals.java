/**
 * @author Oliver & Christopher 
 */


public class ReportRetrievals 
{
    protected String recordCat;
    protected String recordSpend;
    protected String recordRecipient;
    
    // Retrieves the amount spent from the record and assigns it to a vairable
    protected String retrieveSpent(String spend)
    {
        recordSpend = spend.substring(0); 
        return recordSpend;
    }
    
    // Retrieves the Category from the record and assigns it to a vairable
    protected String retrieveCategory(String category)
    {
        recordCat = category.substring(0); 
        return recordCat;
    }
    
    // Retrieves the Recipient from the record and assigns it to a vairable
    protected String retrieveRecipient(String recipient)
    {
        recordRecipient = recipient.substring(0); 
        return recordRecipient;
    }
}
