package edu.udayton.cps499.healthnotes;

import android.widget.Switch;

import java.util.Arrays;

public class PrescriptionsInstruction {
    //VARS
    //Constants
    //Types set to int values
    private final int PILL = 1;
    private final int LIQUID = 2;
    private final int PATCH = 3;
    private final int INJECTION = 4;
    private final int CREAM = 5;
    private final int OTHER = 99; //Set to 99 to leave room for other types if needed
    //timed intervals
    private final int EVERYHOURS = 1;
    private final int TIMESPERDAY = 2;
    private final int EVERYXDAYS = 3;
    private final int ASDIRECTED = 99;
    //times of day
    private final int MORNING = 1; //5am to 9am
    private final int MIDMORNING = 2; //9am to 12pm
    private final int AFTERNOON = 3; //12pm to 3pm
    private final int MIDAFTERNOON = 4; //3pm to 6pm
    private final int EVENING = 5; //6pm to 9pm
    private final int NIGHT = 6; //9pm to 5am
    //reminder flags
    private final int REMINDOFF = 0;
    private final int REMINDON = 1;
    private final int REMINDDAY = 2;

    /*
        Instructions are broken down into six segments
        1. Type
            Defined using the constants above which will influence further segments

        2. Amount
            Typically a number and a unit for measured, for items like creams or injections will use
            different variables to track where to apply cream or the injection vars noted below

        3. Interval
            Defines how often the prescription is used.  (ie take pills EVERY 4 HOURS)
            a. Interval (IE every x hours, x times a day, every x days, as directed on package
            b. Amount (simply an integer for X number of something or if times per day then chosen
                intervals are entered into an ArrayList

        4. Duration
            Sets duration to x number of days then the prescription is no longer added when user
            indicates they have taken the last dose

        5. As Needed
            Flags if the medicine is to only be taken for a user defined condition
                - Meant for use with things like Antibiotics which are taken for X days.

        6. Reminders
            Turns reminders for the meds to On, Off, to only fire during the day.

        7. Notes
            User defined field, 0-25 characters, for notes like "May cause drowsiness", or "Do not
            operate Machinery"
     */

    //1. Type
    private int type = -1; //set to one of the values for types listed above

    //2. Amount
    private int amountQty = -1; //number or amount of type listed (ie 1 for one pill, 15 for 15ml
    private String amountUnit = " "; //unit for amount (ie, 'pill(s)', 'fl oz', 'ml', or for cream set to what would follow "Apply to ")
    private boolean amountIsPrepared = true; //true if in an injectable pen model like EpiPen or Emgality
    private boolean asDirected = false; //flags if the medicine is to be taken as directed
        // This for items like Insulin which can be directed to take different amounts depending on glucose levels
    private String amountOtherDirection= " "; //user defined for type Other

    //3. Interval
    private int timingInterval = -1; //set to one of the possible constant variables for timing.
    private int timingAmount = -1; //value o = -1 X for the interval noted above or -1 if as directed.
    private int[] timingTimeOfDays; //Used to track selected times of days for the

    //4. Duration
    private boolean durationLimited = false; //set to true if for x# of days, false for all others
    private int durationInDays = -1; //set by user to a number of days the medicine will be used.

    //5. As Needed
    private boolean isAsNeeded = false; //false if only meant to be taken as needed for user defined x.
    private String asNeededFor = " "; //user defined string for as needed for (ie pain, nausea)

    //6. Reminders
    private int reminderSetting = -1; //set to value to correspond with constants above

    //7. Notes
    private String notes = " "; //user defined notes set to limited length of no more than x characters


    //constructors
    public PrescriptionsInstruction() {}//default constructor

    //constructor all fields
    public PrescriptionsInstruction(int type, int amountQty, String amountUnit, boolean amountIsPrepared, boolean asDirected,
                                    String amountOtherDirection, int timingInterval, int timingAmount, boolean durationLimited, int durationInDays,
                                    boolean isAsNeeded, String asNeededFor, int reminderSetting, String notes) {
        this.type = type;
        this.amountQty = amountQty;
        this.amountUnit = amountUnit;
        this.amountIsPrepared = amountIsPrepared;
        this.asDirected = asDirected;
        this.amountOtherDirection = amountOtherDirection;
        this.timingInterval = timingInterval;
        this.timingAmount = timingAmount;
        this.durationLimited = durationLimited;
        this.durationInDays = durationInDays;
        this.isAsNeeded = isAsNeeded;
        this.asNeededFor = asNeededFor;
        this.reminderSetting = reminderSetting;
        this.notes = notes;
    }

    //constructor general pill
    public PrescriptionsInstruction(int type, int amountQty, String amountUnit, boolean asDirected, String amountOtherDirection,
                                    int timingInterval, int timingAmount, boolean durationLimited, int durationInDays,
                                    boolean isAsNeeded, String asNeededFor, String notes) {
        this.type = type;
        this.amountQty = amountQty;
        this.amountUnit = amountUnit;
        this.asDirected = asDirected;
        this.amountOtherDirection = amountOtherDirection;
        this.timingInterval = timingInterval;
        this.timingAmount = timingAmount;
        this.durationLimited = durationLimited;
        this.durationInDays = durationInDays;
        this.isAsNeeded = isAsNeeded;
        this.asNeededFor = asNeededFor;
        this.notes = notes;
    }//end General Pill Constructor

    //constructor general pill
    public PrescriptionsInstruction(int type, int amountQty, String amountUnit, boolean asDirected, String amountOtherDirection,
                                    int timingInterval, int timingAmount, boolean durationLimited, int durationInDays,
                                    boolean isAsNeeded, String asNeededFor, String notes, int[] timingTimeOfDays) {
        this.type = type;
        this.amountQty = amountQty;
        this.amountUnit = amountUnit;
        this.asDirected = asDirected;
        this.amountOtherDirection = amountOtherDirection;
        this.timingInterval = timingInterval;
        this.timingAmount = timingAmount;
        this.durationLimited = durationLimited;
        this.durationInDays = durationInDays;
        this.isAsNeeded = isAsNeeded;
        this.asNeededFor = asNeededFor;
        this.notes = notes;

        this.timingTimeOfDays = Arrays.copyOf(timingTimeOfDays, timingTimeOfDays.length);
    }//end General Pill Constructor


    //Getters and Setters
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getAmountQty() {
        return amountQty;
    }

    public void setAmountQty(int amountQty) {
        this.amountQty = amountQty;
    }

    public String getAmountUnit() {
        return amountUnit;
    }

    public void setAmountUnit(String amountUnit) {
        if (amountUnit.length() > 10 ){
            this.amountUnit = amountUnit.substring(0, 10);//take only first 10 characters
        } else {
            this.amountUnit = amountUnit;
        }
    }

    public boolean isAmountIsPrepared() {
        return amountIsPrepared;
    }

    public void setAmountIsPrepared(boolean amountIsPrepared) {
        this.amountIsPrepared = amountIsPrepared;
    }

    public boolean isAsDirected() {
        return asDirected;
    }

    public void setAsDirected(boolean asDirected) {
        this.asDirected = asDirected;
    }

    public String getAmountOtherDirection() {
        return amountOtherDirection;
    }

    public void setAmountOtherDirection(String amountOtherDirection) {
        this.amountOtherDirection = amountOtherDirection;
    }

    public int getTimingInterval() {
        return timingInterval;
    }

    public void setTimingInterval(int timingInterval) {
        this.timingInterval = timingInterval;
    }

    public int getTimingAmount() {
        return timingAmount;
    }

    public void setTimingAmount(int timingAmount) {
        this.timingAmount = timingAmount;
    }

    public boolean isDurationLimited() {
        return durationLimited;
    }

    public void setDurationLimited(boolean durationLimited) {
        this.durationLimited = durationLimited;
    }

    public int getDurationInDays() {
        return durationInDays;
    }

    public void setDurationInDays(int durationInDays) {
        this.durationInDays = durationInDays;
    }

    public boolean isAsNeeded() {
        return isAsNeeded;
    }

    public void setAsNeeded(boolean asNeeded) {
        isAsNeeded = asNeeded;
    }

    public String getAsNeededFor() {
        return asNeededFor;
    }

    public void setAsNeededFor(String asNeededFor) {
        this.asNeededFor = asNeededFor;
    }

    public int getReminderSetting() {
        return reminderSetting;
    }

    public void setReminderSetting(int reminderSetting) {
        this.reminderSetting = reminderSetting;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int[] getTimingTimeOfDays() {
        return timingTimeOfDays;
    }

    public void setTimingTimeOfDays(int[] timingTimeOfDays) {
        this.timingTimeOfDays = Arrays.copyOf(timingTimeOfDays, timingTimeOfDays.length);
    }
    public void setTimingTimeOfDays(String timingTimeOfDays) {
        for (int x = 0; x < this.timingTimeOfDays.length; x++) {
            if (timingTimeOfDays.charAt(x) != 'x') this.timingTimeOfDays[x] = 0;
            else this.timingTimeOfDays[x] = 1;
        }
    }


    //toString - put it all together
    public String toString() {
        String value = "";
        if (!asDirected) {
            switch (type) {
                case PILL:
                    value = "Take " + amountQty + " " + amountUnit;
                    if (amountQty > 1) value += "s";
                    break;
                case LIQUID:
                    value = "Take " + amountQty + " " + amountUnit;
                    break;
                case PATCH:
                    value = "Apply " + amountQty + " " + amountUnit;
                    if (amountQty > 1) value += "s";
                    break;
                case INJECTION:
                    value = "Inject " + amountQty + " " + amountUnit;
                    if (amountQty > 1) value += "s";
                    break;
                case CREAM:
                    value = "Apply to " + amountUnit;
                    break;
                case OTHER:
                    value = amountOtherDirection;
                    break;
                default: break;
            }
        } else {
            value = "See package for instructions to take";
        }
        //timing
        switch (timingInterval){
            case EVERYHOURS: value += " every " + timingAmount + " hours"; break;
            case TIMESPERDAY: value += " " + timingAmount + " times a day"; break;
            case EVERYXDAYS: value += " every " + timingAmount + " days"; break;
            default: value += " as directed on package"; break;
        }
        //duration
        if (durationLimited) {
            value += " for " + " days";
        }
        //as needed
        if (isAsNeeded) {
            value += " as needed for " + asNeededFor;
        }

        //notes
        value += ". " + notes;

        return value;
    }//end toString
}//end PrescriptionsInstruction Class
