
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
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */
public class ClockDisplay
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String dayTime;
    private String displayString;    // simulates the actual display
    private int alarmHour;
    private int alarmMinute;
    private String alarmDayTime;
    private boolean isAlarmActive;
    
    /**
     * Constructor for ClockDisplay objects. This constructor 
     * creates a new clock set at 00:00.
     */
    public ClockDisplay()
    {
        hours = new NumberDisplay(12);
        minutes = new NumberDisplay(60);
        alarmHour = -1;
        alarmMinute = -1;
        alarmDayTime = null;
        isAlarmActive = false;
        updateDisplay();
    }

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters.
     */
    public ClockDisplay(int hour, int minute, String pDayTime)
    {
        hours = new NumberDisplay(12);
        minutes = new NumberDisplay(60);
        alarmHour = -1;
        alarmMinute = -1;
        alarmDayTime = null;
        isAlarmActive = false;
        setTime(hour, minute, pDayTime);
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    public void timeTick()
    {
        minutes.increment();
        if(minutes.getValue() == 0) {  // it just rolled over!
            if (hours.getValue() == 11) {
                dayTime = dayTime.equals("am") ? "pm" : "am";
            }
            hours.increment();
        }
        updateDisplay();
    }

    /**
     * Set the time of the display to the specified hour and
     * minute.
     */
    public void setTime(int hour, int minute, String pDayTime)
    {
        hours.setValue(hour);
        minutes.setValue(minute);
        dayTime = pDayTime;
        updateDisplay();
    }
    
    /**
     * Set the time of the alarm
     */
    public void setAlarm(int hour, int minute, String dayTime) {
        alarmHour = hour;
        alarmMinute = minute;
        alarmDayTime = dayTime;
    }
    
    /**
     * Activate or de-activate the alarm clock
     */
    public void setAlarmActive(boolean isActive) {
        isAlarmActive = isActive;
    }

    /**
     * Return the current time of this display in the format HH:MM.
     */
    public String getTime()
    {
        return displayString;
    }
    
    /**
     * Return the set alarm time
     */
    public String getAlarmTime() {
        String alarmString;
        if (alarmHour > -1 && alarmMinute > -1) {
            alarmString = alarmHour + ":" + alarmMinute + " " + alarmDayTime;
            if (isAlarmActive) {
                alarmString += " ALARM ACTIVE";
            } else {
                alarmString += " ALARM NOT ACTIVE";
            }
        } else {
            alarmString = "no alarm set, enjoy the sleep :)";
        }
        return alarmString;
    }
    
    /**
     * Update the internal string that represents the display.
     */
    private void updateDisplay()
    {
        String formattedHour = hours.getDisplayValue();
        if (formattedHour.equals("12")) {
            formattedHour = "00";
        }
        displayString = formattedHour + ":" + 
                        minutes.getDisplayValue() + " " +
                        dayTime;
                        
        // Check for the alarm
        if (isAlarmActive == true 
            && alarmHour == hours.getValue()
            && alarmMinute == minutes.getValue()
            && alarmDayTime == dayTime) {
            System.out.println("Riiiiiiiing");    
        }
    }
}
