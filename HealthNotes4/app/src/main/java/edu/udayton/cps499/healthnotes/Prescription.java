package edu.udayton.cps499.healthnotes;

import android.location.Address;

import java.security.Provider;
import java.sql.Time;
import java.util.Date;

public class Prescription {
    private int id;
    private String scriptName;
    private String scriptStrength;
    private String scriptInstructions;
    private Date scriptDatePrescribed;
    private int scriptProviderIndex; //index in an array or arrayList of the provider
    private Address scriptPharmacy;
    private String scriptNumber;
    private int scriptNumberRefills;
    private Date scriptDateIssued;
    private Date scriptDateExpired;
    private Date scriptDateRefillBy;
    private Date scriptLastTakenDate;
    private Date scriptNextTakeDate;

    public Date getScriptLastTakenDate() {
        scriptLastTakenDate.setTime(2358);

        return scriptLastTakenDate;
    }

    public Prescription() {    }//end constructor

    public Prescription(String name, String strength, String instructions, Date datePrescribed, int providerIndex) {
        scriptName = name;
        scriptStrength = strength;
        scriptInstructions = instructions;
        scriptDatePrescribed = datePrescribed;
        scriptProviderIndex = providerIndex;
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


    //pharmacy setters and getters.
    public void setPharmacy(Address pharmacy) { scriptPharmacy = pharmacy; }
    public void setPharmacy(String name, int number, String street, String city, String zip, String phone){
        scriptPharmacy.setFeatureName(name);
        scriptPharmacy.setAddressLine(number, street);
        scriptPharmacy.setLocality(city);
        scriptPharmacy.setPostalCode(zip);
        scriptPharmacy.setPhone(phone);
    }//end set with all the goods
    public void setPharmacyAddress(int number, String street) { scriptPharmacy.setAddressLine( number, street ); }
    public void setPharmacyCity( String city ) { scriptPharmacy.setLocality(city); }
    public void setPharmacyPostalCode(String zip) { scriptPharmacy.setPostalCode(zip);}
    public void setPharmacyPhone(String phone) { scriptPharmacy.setPhone(phone);}
    public Address getPharmacy() { return scriptPharmacy; }
    public String getPharmacyAddressLine() { return scriptPharmacy.getAddressLine(0); }
    public String getPharmacyCity() { return scriptPharmacy.getLocality(); }
    public String getPharmacyPostalCode() { return scriptPharmacy.getPostalCode(); }
    public String getPharmacyPhone() { return scriptPharmacy.getPhone(); }




    public void take() {

    }//end take
}
