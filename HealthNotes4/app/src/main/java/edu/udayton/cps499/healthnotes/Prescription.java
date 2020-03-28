package edu.udayton.cps499.healthnotes;

import java.util.Date;

public class Prescription {
    private int id;
    private String scriptName;
    private String scriptStrength;
    private String scriptInstructions;
    private Date scriptDatePrescribed;  //change back to Date when it's working
    private Provider scriptPharmacy;
    private String scriptNumber;
    private int scriptNumberRefills;
    private int quantity;
    private Date scriptDateIssued;
    private Date scriptDateExpired;
    private Date scriptDateRefillBy;
    private Date scriptLastTakenDate;
    private Date scriptNextTakeDate;
    private Provider scriptProvider;

    public Date getScriptLastTakenDate() {
        scriptLastTakenDate.setTime(2358);

        return scriptLastTakenDate;
    }

    public Prescription() {    }//end constructor

    public Prescription(String name, String strength, String instructions, Date datePrescribed, Provider provider) {
        scriptName = name;
        scriptStrength = strength;
        scriptInstructions = instructions;
        scriptDatePrescribed = datePrescribed;
        scriptProvider = provider;
    }//end constructor with basic info

    public void setName(String name) { this.scriptName = name; }
    public String getName() { return scriptName; }

    public void setStrength(String strength) { this.scriptStrength = strength; }
    public String getStrength() { return scriptStrength; }

    public void setInstructions(String instructions) { this.scriptInstructions = instructions; }
    public String getInstructions() { return scriptInstructions; }

    public void setDatePrescribed(Date datePrescribed) { this.scriptDatePrescribed = datePrescribed; }
    public Date getDatePrescribed() { return scriptDatePrescribed; }

    //provider setters and getters.
    public Provider getScriptProvider() {
        return scriptProvider;
    }

    public void setScriptProvider(Provider scriptProvider) {
        this.scriptProvider = scriptProvider;
    }


    //pharmacy setters and getters.
    public Provider getScriptPharmacy() {
        return scriptPharmacy;
    }

    public void setScriptPharmacy(Provider scriptPharmacy) {
        this.scriptPharmacy = scriptPharmacy;
    }



    public void take() {

    }//end take
}
