package edu.udayton.cps499.healthnotes;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class Prescription {
    private int id;
    private String scriptName;
    private String scriptStrength;
    private String scriptInstructionsStringOnly;
    private PrescriptionsInstruction scriptInstruction;
    private LocalDateTime scriptDatePrescribed;  //change back to Date when it's working
    private Provider scriptPharmacy;
    private String scriptNumber;
    private int scriptNumberRefills;
    private int quantity;
    private LocalDateTime scriptDateIssued;
    private LocalDateTime scriptDateExpired;
    private LocalDateTime scriptDateRefillBy;
    private LocalDateTime scriptLastTakenDate;
    private LocalDateTime scriptNextTakeDate;
    private Provider scriptProvider;

    public LocalDateTime getScriptLastTakenDate() {
        return scriptLastTakenDate;
    }

    public Prescription() {    }//end constructor

    public Prescription(String name, String strength, String instructions, LocalDateTime datePrescribed, Provider provider) {
        scriptName = name;
        scriptStrength = strength;
        scriptInstructionsStringOnly = instructions;
        scriptDatePrescribed = datePrescribed;
        scriptProvider = provider;
    }//end constructor with basic info

    public Prescription(String name, String strength, String instructions, LocalDateTime datePrescribed, Provider provider, PrescriptionsInstruction newInstructions) {
        scriptName = name;
        scriptStrength = strength;
        scriptInstructionsStringOnly = instructions;
        scriptDatePrescribed = datePrescribed;
        scriptProvider = provider;
        scriptInstruction = newInstructions;
    }//end constructor with basic info

    public void setName(String name) { this.scriptName = name; }
    public String getName() { return scriptName; }

    public void setStrength(String strength) { this.scriptStrength = strength; }
    public String getStrength() { return scriptStrength; }

    public void setInstructions(String instructions) { this.scriptInstructionsStringOnly = instructions; }
    public String getInstructions() { return scriptInstructionsStringOnly; }

    public void setDatePrescribed(LocalDateTime datePrescribed) { this.scriptDatePrescribed = datePrescribed; }
    public LocalDateTime getDatePrescribed() { return scriptDatePrescribed; }

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


    //scriptInstructions setters and getters.
    public PrescriptionsInstruction getScriptInstruction() {
        return scriptInstruction;
    }

    public void setScriptInstruction(PrescriptionsInstruction scriptInstruction) {
        this.scriptInstruction = scriptInstruction;
    }

    //date setters and getters


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

    public LocalDateTime getScriptDatePrescribed() {
        return scriptDatePrescribed;
    }

    public void setScriptDatePrescribed(LocalDateTime scriptDatePrescribed) {
        this.scriptDatePrescribed = scriptDatePrescribed;
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

    public void setScriptNextTakeDate(LocalDateTime scriptNextTakeDate) {
        this.scriptNextTakeDate = scriptNextTakeDate;
    }


    public void take() {

    }//end take


}//end class
