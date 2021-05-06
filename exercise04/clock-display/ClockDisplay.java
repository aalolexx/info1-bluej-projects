
/**
 * The ClockDisplay class implements a digital clock display for a
 * European-style 24 hour clock. The clock shows hours and minutes. The 
 * range of the clock is 00:00 (midnight) to 23:59 (one minute before 
 * midnight).
 * 
 * The clock display receives "ticks" (via the timeTick method) every minute
 * and reacts by incrementing the display. This is done in the usual clock
 * fashion: the hour increments when the minutes roll over to zero.
 * 
 * @author Michael Kölling and David J. Barnes enhanced by Alexander Ehrenhöfer
 * @version 2021.05.05
 */
public class ClockDisplay
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString;    // simulates the actual display
    
    /**
     * Constructor for ClockDisplay objects. This constructor 
     * creates a new clock set at 00:00.
     */
    public ClockDisplay()
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        updateDisplay();
    }

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters.
     */
    public ClockDisplay(int europeanHour, int minute)
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        setTime(europeanHour, minute);
    }
    
    /**
     * Constructor to set the time by american format
     */
    public ClockDisplay(int americanHour, int minute, String postFix)
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
            
        // Check if the hour input is valid for american format
        if (americanHour > 12) {
            System.err.println("Invalid time input for american format");
            updateDisplay();
            return;
        }
        
        // Map the american hour to a european one
        int europeanHour = mapAmericanToEuropean(americanHour, postFix);
        
        setTime(europeanHour, minute);
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    public void timeTick()
    {
        minutes.increment();
        if(minutes.getValue() == 0) {  // it just rolled over!
            hours.increment();
        }
        updateDisplay();
    }

    /**
     * Set the time of the display to the specified hour and
     * minute.
     */
    public void setTime(int hour, int minute)
    {
        hours.setValue(hour);
        minutes.setValue(minute);
        updateDisplay();
    }
    
    /**
     * Set the time of the display to the specified hour and
     * minute as an american format.
     */
    public void setTime(int americanHour, int minute, String postFix)
    {
        int europeanHour = mapAmericanToEuropean(americanHour, postFix);
        hours.setValue(europeanHour);
        minutes.setValue(minute);
        updateDisplay();
    }

    /**
     * Return the current time of this display in the format HH:MM.
     */
    public String getTime()
    {
        return displayString;
    }
    
    /**
     * Update the internal string that represents the display.
     * Note: This method creates an american style output.
     */
    private void updateDisplay()
    {
        String postFix;
        int americanHours;
        
        if (hours.getValue() >= 12) {
            postFix = "PM";
            if (hours.getValue() == 12) {
                americanHours = 12;
            } else {
                americanHours = hours.getValue() - 12;
            }
        } else {
            postFix ="AM";
            if (hours.getValue() == 0) {
                americanHours = 12;
            } else {
                americanHours = hours.getValue();
            }
        }
        displayString = americanHours + ":" + 
                        minutes.getDisplayValue() + " " +
                        postFix;
    }
    
    private int mapAmericanToEuropean(int americanHour, String postFix) 
    {
        int europeanHour;
        if (postFix == "PM") {
            europeanHour = americanHour + 12;
        } else {
            if (americanHour == 12) {
                europeanHour = 0;
            } else {
                europeanHour = americanHour;
            }
        }
        return europeanHour;
    }
}
