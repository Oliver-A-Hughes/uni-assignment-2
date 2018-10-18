/**
 * @author Oliver & Christopher 
 */


public class Date_Change 
{
    private String day;
    private String month;
    private String year;
    protected String dateChanged;
    
    // Takes the day, month and year and puts it together in the year, month, day format
    public void changeDate(String date)
    {
        this.removeDay(date);
        this.removeMonth(date);
        this.removeYear(date);
        dateChanged = year + month + day;
    }
    
    // Removes the day from the date string and assigns it to the day vairable
    private String removeDay(String date)
    {
        day = date.substring(0,2);
        return day;
    }
    
    // Removes the month from the date string and assigns it to the month vairable    
    private String removeMonth(String date)
    {
        month = date.substring(3,5); 
        return month;
    }
    
    // Removes the year from the date string and assigns it to the year vairable
    private String removeYear(String date)
    {
        year = date.substring(6,10); 
        return year;
    }   
}
