/*
    Course: CPS 499-14  Spring 2020 Semester @ The University of Dayton
    Author: Michael Graham
    Instructor Tom Ongwere
 */
package edu.udayton.cps499.healthnotes;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import java.time.LocalDateTime;

@RequiresApi(api = Build.VERSION_CODES.O)
public class Prescription {
    //vars
    private static final String TAG = "Prescription Object";

    //constants
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
    //
    private final int MINUTESTOPAD = 30; //used to flag items not overdue if still within x minutes of take time

    //instance Vars
    private int id;
    private String scriptName;
    private String scriptStrength;
    private String scriptInstructionsStringOnly;
    private PrescriptionsInstruction scriptInstruction;
    private LocalDateTime scriptDatePrescribed = LocalDateTime.of(2010, 1, 1,0, 0, 1);  //change back to Date when it's working
    private Provider scriptPharmacy;
    private String scriptNumber;
    private int scriptNumberRefills;
    private int quantity;
    private LocalDateTime scriptDateIssued = LocalDateTime.of(2010, 1, 1,0, 0, 1);
    private LocalDateTime scriptDateExpired = LocalDateTime.of(2010, 1, 1,0, 0, 1);
    private LocalDateTime scriptDateRefillBy = LocalDateTime.of(2010, 1, 1,0, 0, 1);
    private LocalDateTime scriptLastTakenDate = LocalDateTime.of(2009, 1, 1,0, 0, 1);
    private LocalDateTime scriptNextTakeDate = LocalDateTime.of(2010, 1, 1,0, 0, 1);
    private Provider scriptProvider;

    public LocalDateTime getScriptLastTakenDate() {
        return scriptLastTakenDate;
    }

    public Prescription() {    }//end constructor

    public Prescription(Prescription script) {
        id = script.getId();
        scriptName = script.getScriptName();
        scriptStrength = script.getScriptStrength();
        scriptInstructionsStringOnly = script.getScriptInstructionsStringOnly();
        scriptInstruction = script.getScriptInstruction();
        scriptDatePrescribed = script.getScriptDatePrescribed();
        scriptPharmacy = script.getScriptPharmacy();
        scriptNumber = script.getScriptNumber();
        scriptNumberRefills = script.getScriptNumberRefills();
        quantity = script.getQuantity();
        scriptDateIssued = script.getScriptDateIssued();
        scriptDateExpired = script.getScriptDateExpired();
        scriptDateRefillBy = script.getScriptDateRefillBy();
        scriptLastTakenDate = script.getScriptLastTakenDate();
        scriptNextTakeDate = script.getScriptNextTakeDate();
        scriptProvider = script.getScriptProvider();
    }//end constructor from another prescription

    public Prescription(String name, String strength, String instructions, LocalDateTime datePrescribed, Provider provider) {
    scriptName = name;
    scriptStrength = strength;
    scriptInstructionsStringOnly = instructions;
    scriptDatePrescribed = datePrescribed;
    scriptProvider = provider;
}//end constructor with basic info

    public Prescription(String name, String strength, String instructions, LocalDateTime datePrescribed,
                        Provider provider, PrescriptionsInstruction newInstructions) {
        scriptName = name;
        scriptStrength = strength;
        scriptInstructionsStringOnly = instructions;
        scriptDatePrescribed = datePrescribed;
        scriptProvider = provider;
        scriptInstruction = newInstructions;
    }//end constructor with new instructions

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getScriptName() {
        return scriptName;
    }

    public void setScriptName(String scriptName) {
        this.scriptName = scriptName;
    }

    public String getScriptStrength() {
        return scriptStrength;
    }

    public void setScriptStrength(String scriptStrength) {
        this.scriptStrength = scriptStrength;
    }

    public String getScriptInstructionsStringOnly() {
        return scriptInstructionsStringOnly;
    }

    public void setScriptInstructionsStringOnly(String scriptInstructionsStringOnly) {
        this.scriptInstructionsStringOnly = scriptInstructionsStringOnly;
    }

    public PrescriptionsInstruction getScriptInstruction() {
        return scriptInstruction;
    }

    public void setScriptInstruction(PrescriptionsInstruction scriptInstruction) {
        this.scriptInstruction = scriptInstruction;
    }

    public LocalDateTime getScriptDatePrescribed() {
        return scriptDatePrescribed;
    }

    public void setScriptDatePrescribed(LocalDateTime scriptDatePrescribed) {
        this.scriptDatePrescribed = scriptDatePrescribed;
    }

    public Provider getScriptPharmacy() {
        return scriptPharmacy;
    }

    public void setScriptPharmacy(Provider scriptPharmacy) {
        this.scriptPharmacy = scriptPharmacy;
    }

    public String getScriptNumber() {
        return scriptNumber;
    }

    public void setScriptNumber(String scriptNumber) {
        this.scriptNumber = scriptNumber;
    }

    public int getScriptNumberRefills() {
        return scriptNumberRefills;
    }

    public void setScriptNumberRefills(int scriptNumberRefills) {
        this.scriptNumberRefills = scriptNumberRefills;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getScriptDateIssued() {
        return scriptDateIssued;
    }

    public void setScriptDateIssued(LocalDateTime scriptDateIssued) {
        this.scriptDateIssued = scriptDateIssued;
    }

    public LocalDateTime getScriptDateExpired() {
        return scriptDateExpired;
    }

    public void setScriptDateExpired(LocalDateTime scriptDateExpired) {
        this.scriptDateExpired = scriptDateExpired;
    }

    public LocalDateTime getScriptDateRefillBy() {
        return scriptDateRefillBy;
    }

    public void setScriptDateRefillBy(LocalDateTime scriptDateRefillBy) {
        this.scriptDateRefillBy = scriptDateRefillBy;
    }

    public void setScriptLastTakenDate(LocalDateTime scriptLastTakenDate) {
        this.scriptLastTakenDate = scriptLastTakenDate;
    }

    public LocalDateTime getScriptNextTakeDate() {
        return scriptNextTakeDate;
    }

    public Provider getScriptProvider() {
        return scriptProvider;
    }

    public void setScriptProvider(Provider scriptProvider) {
        this.scriptProvider = scriptProvider;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public LocalDateTime calcScriptNextTakeDate() {
        return calcNextTakeDate();
    }

    public void setScriptNextTakeDate(LocalDateTime scriptNextTakeDate) {
        this.scriptNextTakeDate = scriptNextTakeDate;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private LocalDateTime calcNextTakeDate() {
        Log.d(TAG, "calcNextTakeDate init interval " + scriptInstruction.getTimingInterval() );

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nextTake = now;
        LocalDateTime todayAtZeroHour = LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(),
                0, 0, 1);

        //switch based on timing
        switch ( scriptInstruction.getTimingInterval() ) {
            case EVERYHOURS:
                Log.d(TAG, "EVERYHOURS LastTake:" + scriptLastTakenDate + "  NextTake initial:" + scriptNextTakeDate);

                //if missed last dose and next take is before half the interval before now.
                if ( scriptLastTakenDate.isBefore(scriptNextTakeDate.plusHours((long) scriptInstruction.getTimingAmount()/2))
                            && scriptNextTakeDate.isBefore(now.minusHours((long) scriptInstruction.getTimingAmount()/2))) {
                    Log.d(TAG, "Missed Last Dose");

                    //Missed last dose: test if more than halfway to the next take time if so set to currentHalf hour
                    if ( scriptNextTakeDate.plusHours((long) scriptInstruction.getTimingAmount()).isBefore(now) ) {
                        Log.d(TAG, "Setting to current half hour");

                        if (now.getMinute() < 30) {
                            nextTake = LocalDateTime.of(now.getYear(), now.getMonthValue(), now.getDayOfMonth(), now.getHour(), 0, 0);
                        } else {
                            nextTake = LocalDateTime.of(now.getYear(), now.getMonthValue(), now.getDayOfMonth(), now.getHour(), 30, 0);
                        }
                    }
                    //else leave as is
                    else {
                        nextTake = scriptNextTakeDate;
                    }
                }//end if missed last dose
                // else did not miss last dose set next
                else {
                    Log.d(TAG, "Setting to current half hour of next interval");

                    //set next to halfhour of nextTakeDate + timingAmount
                    nextTake = scriptNextTakeDate.plusHours((long) scriptInstruction.getTimingAmount());
                }//end if did not miss last dose
                break;

            case TIMESPERDAY:
                Log.d(TAG, "X Times Per Day at timingAmount: " + scriptInstruction.getTimingAmount());

                switch (scriptInstruction.getTimingAmount()){
                    case (1):  //LOGIC APPEARS TO BE WORKING
                        //Log.d(TAG, "case one time a day");

                        //if take time has not been set for today
                        if ( scriptNextTakeDate.isBefore(todayAtZeroHour) ) {
                            Log.d(TAG, "ScriptNextTakeDate is before midnight. NexTakeDate: " + scriptNextTakeDate);

                            //if not set take for today based on time of day selected
                            switch (scriptInstruction.getTimingTimeOfDays()[0]) {
                                case 1://Morning
                                    Log.d(TAG, "set for morning");
                                    if (now.getHour() > 14) { //check for if after 2pm if so set for tomorrow
                                        LocalDateTime tomorrow = now.plusDays(1);
                                        nextTake = LocalDateTime.of(tomorrow.getYear(), tomorrow.getMonth(), tomorrow.getDayOfMonth(),
                                                6, 0, 0);
                                    } else {
                                        nextTake = LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(),
                                                6, 0, 0);
                                    }
                                    break;
                                case 2://midmorning
                                    Log.d(TAG, "set for midmorning");
                                    if (now.getHour() > 17) { //check for if after 11pm if so set for tomorrow
                                        LocalDateTime tomorrow = now.plusDays(1);
                                        nextTake = LocalDateTime.of(tomorrow.getYear(), tomorrow.getMonth(), tomorrow.getDayOfMonth(),
                                                10, 0, 0);
                                    } else {
                                        nextTake = LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(),
                                                10, 0, 0);
                                    }
                                    break;
                                case 3://afternoon
                                    Log.d(TAG, "set for afternoon");
                                    if (now.getHour() > 20) { //check for if after 11pm if so set for tomorrow
                                        LocalDateTime tomorrow = now.plusDays(1);
                                        nextTake = LocalDateTime.of(tomorrow.getYear(), tomorrow.getMonth(), tomorrow.getDayOfMonth(),
                                                13, 0, 0);
                                    } else {
                                        nextTake = LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(),
                                                13, 0, 0);
                                    }
                                    break;
                                case 4://midafternoon
                                    Log.d(TAG, "set for midafternoon");
                                    if (now.getHour() > 23) { //check for if after 11pm if so set for tomorrow
                                        LocalDateTime tomorrow = now.plusDays(1);
                                        nextTake = LocalDateTime.of(tomorrow.getYear(), tomorrow.getMonth(), tomorrow.getDayOfMonth(),
                                                16, 0, 0);
                                    } else {
                                        nextTake = LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(),
                                                16, 0, 0);
                                    }
                                    break;
                                case 5://evening
                                    Log.d(TAG, "set for evening");
                                    if (now.getHour() > 23) { //check for if after 11pm if so set for tomorrow
                                        LocalDateTime tomorrow = now.plusDays(1);
                                        nextTake = LocalDateTime.of(tomorrow.getYear(), tomorrow.getMonth(), tomorrow.getDayOfMonth(),
                                                19, 0, 0);
                                    } else {
                                        nextTake = LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(),
                                                19, 0, 0);
                                    }
                                    break;
                                case 6://night
                                    Log.d(TAG, "set for night");
                                    if (now.getHour() > 23) { //check for if after 11pm if so set for tomorrow
                                        LocalDateTime tomorrow = now.plusDays(1);
                                        nextTake = LocalDateTime.of(tomorrow.getYear(), tomorrow.getMonth(), tomorrow.getDayOfMonth(),
                                                21, 0, 0);
                                    } else {
                                        nextTake = LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(),
                                                21, 0, 0);
                                    }
                                    break;
                                default://set way out
                                    nextTake = LocalDateTime.of(now.getYear() + 10, now.getMonth(), now.getDayOfMonth(),
                                            21, 0, 0);
                            }//end set once a day
                        } //else set to nextday
                        else {
                            nextTake = scriptNextTakeDate.plusDays(1);
                        }
                        break;
                    case (2): //2 times a day 9am and 8pm
                        //check if not set for today then set first instance today.
                        if ( scriptNextTakeDate.isBefore(todayAtZeroHour) ) {
                            //confirm now is no later than noon then set for 9am
                            if ( now.isBefore( LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(),
                                    12, 0, 0))) {
                                nextTake = LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(),
                                        9, 0, 0);
                            } else {//set to take tonight
                                nextTake = LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(),
                                        20, 0, 0);
                            }
                        } else { //else it has been set for today already
                            //check if nextTakeDate is before noon and if not set for tonight else don't set again.
                            if ( scriptNextTakeDate.isBefore( LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(),
                                    12, 0, 0) ) ) {
                                nextTake = LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(),
                                        20, 0, 0);
                            }
                        }
                        break;
                    case (3)://three times a day 8am, 2pm, 8pm
                        //Log.d(TAG, "3X nextTakeDate: " + scriptNextTakeDate);
                        //check if not set for today and if not then set for first take of the day.
                        if ( scriptNextTakeDate.isBefore(todayAtZeroHour) ) {
                            //Log.d(TAG, "3X perDay Set first for today");
                            //confirm now is no later than noon if so set for this morning
                            if (now.getHour() < 12) {
                                nextTake = LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(),
                                        8, 0, 0);
                            }//else check if before 4pm if so set to 2pm
                            else if (now.getHour() < 16) {
                                nextTake = LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(),
                                        14, 0, 0);
                            } else {//set to take at 8pm
                                nextTake = LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(),
                                        20, 0, 0);
                            }
                        } else if (scriptNextTakeDate.getDayOfMonth() == now.getDayOfMonth() &&
                                scriptNextTakeDate.getHour() < 19) { //else set for second or third of today only if not already set
                            //Log.d(TAG, "3X perDay Set for today");
                            //if scriptNextTakeDate is before noon set for 2pm
                            if (scriptNextTakeDate.getHour() < 14 && now.getHour() < 17) { //if today, and the hour of next Take is before 2pm and now is bfore 5pm

                                nextTake = LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(),
                                        14, 0, 0);
                            }
                            else if (scriptNextTakeDate.getHour() < 20 && now.getHour() < 23){ //if today, and the hour of next Take is before 8pm and now is bfore 11pm
                                nextTake = LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(),
                                        20, 0, 0);
                            }
                        } else { //else set for tomorrow
                            //Log.d(TAG, "3X perDay Set for tomorrow");

                            if (scriptNextTakeDate.getDayOfMonth() == now.getDayOfMonth()) { //if dateNextTake is today set for tomorrow morning
                                     nextTake = LocalDateTime.of(now.getYear(), now.getMonth(), now.plusDays(1).getDayOfMonth(),
                                             8, 0, 0);
                            } else { //script next take is already set for tomorrow test if it is set to before noon if so set to 2pp
                                if (scriptNextTakeDate.getHour() < 12) {
                                    nextTake = LocalDateTime.of(now.getYear(), now.getMonth(), now.plusDays(1).getDayOfMonth(),
                                            14, 0, 0);
                                } else {
                                    nextTake = LocalDateTime.of(now.getYear(), now.getMonth(), now.plusDays(1).getDayOfMonth(),
                                            20, 0, 0);
                                }
                            }
                        }


                        break;
                    case (4):
                        Log.d(TAG, "4X nextTakeDate initial : " + scriptNextTakeDate);
                        //check if not set for today and if not then set for first take of the day.
                        if ( scriptNextTakeDate.isBefore(todayAtZeroHour) ) {
                            Log.d(TAG, "4X perDay Set first for today");
                            //confirm now is no later than 10 if so set for this morning
                            if (now.getHour() < 10) {
                                nextTake = LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(),
                                        8, 0, 0);
                            }//else check if before 2pm if so set to 12pm
                            else if (now.getHour() < 14) {
                                nextTake = LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(),
                                        12, 0, 0);
                            }//els check if before 6pm if so set to 4pm
                            else if (now.getHour() < 18) {
                                nextTake = LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(),
                                        16, 0, 0);
                            } else {//set to take at 8pm
                                nextTake = LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(),
                                        20, 0, 0);
                            }
                        } else if (scriptNextTakeDate.getDayOfMonth() == now.getDayOfMonth() &&
                                scriptNextTakeDate.getHour() < 19) { //else set for additional times for today only if
                            Log.d(TAG, "4X perDay Set for today");
                            //if scriptNextTakeDate is before noon set for 2pm
                            if (scriptNextTakeDate.getHour() < 10 && now.getHour() < 14) { //if today, and the hour of next Take is before 10am and now is bfore 2pm
                                nextTake = LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(),
                                        12, 0, 0);
                            } else if (scriptNextTakeDate.getHour() < 14 && now.getHour() < 18) { //if today, and the hour of next Take is before 2pm and now is bfore 6pm
                                nextTake = LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(),
                                        16, 0, 0);
                            } else { //if today, and the hour of next Take is before 6pm and now is bfore 11pm
                                nextTake = LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(),
                                        20, 0, 0);
                            }
                        } else { //else set for tomorrow
                            Log.d(TAG, "4X perDay Set for tomorrow");

                            if (scriptNextTakeDate.getDayOfMonth() == now.getDayOfMonth()) { //if dateNextTake is today set for tomorrow morning
                                nextTake = LocalDateTime.of(now.getYear(), now.getMonth(), now.plusDays(1).getDayOfMonth(),
                                        8, 0, 0);
                            } else { //script next take is already set for tomorrow test if it is set to before 10a if so set to 12pm
                                if (scriptNextTakeDate.getHour() < 10) {
                                    nextTake = LocalDateTime.of(now.getYear(), now.getMonth(), now.plusDays(1).getDayOfMonth(),
                                            12, 0, 0);
                                } else if (scriptNextTakeDate.getHour() < 14){
                                    nextTake = LocalDateTime.of(now.getYear(), now.getMonth(), now.plusDays(1).getDayOfMonth(),
                                            16 , 0, 0);
                                } else {
                                    nextTake = LocalDateTime.of(now.getYear(), now.getMonth(), now.plusDays(1).getDayOfMonth(),
                                            20, 0, 0);
                                }
                            }
                        }
                        break;
                    case (5):
                        Log.d(TAG, "tag 2");
                        break;
                    default: //default six
                        Log.d(TAG, "tag 3");

                        break;
                }

                break;

            case EVERYXDAYS:
                Log.d(TAG, "tag 5");

                break;

            default:
                Log.d(TAG, "tag 6");

                break;
        }

        Log.d(TAG, "Returning the value: " + nextTake);

        return nextTake;
    }//end calcAndSetNextTakeDate


    @RequiresApi(api = Build.VERSION_CODES.O)
    private int timeOfDay(LocalDateTime date) {
        //get current hour 0 to 23
        int hour = date.getHour();

        if ( hour > 5 && hour <= 9 ) {
            return MORNING;
        } else if ( hour > 9 && hour <= 12 ) {
            return MIDMORNING;
        } else if ( hour > 12 && hour <= 15 ) {
            return AFTERNOON;
        } else if ( hour > 15 && hour <= 18 ) {
            return MIDAFTERNOON;
        } else if ( hour > 18 && hour <= 21 ) {
            return EVENING;
        } else {
            return NIGHT;
        }
    }//end currentTimeOfDay


    public Boolean isOverdue() {
        if (getScriptNextTakeDate().isBefore(LocalDateTime.now().minusMinutes(MINUTESTOPAD)))  //if before X minutes ago
            return true;
        else
            return false;
    }

    public Boolean isDue() {
        if ( getScriptNextTakeDate().isBefore(LocalDateTime.now().plusMinutes(MINUTESTOPAD)) )
            return true;
        else
            return false;
    }


    public void take() {

    }//end take


}//end class
