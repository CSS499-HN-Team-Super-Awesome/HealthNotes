package edu.udayton.cps499.healthnotes;

import android.location.Address;
import java.util.Date;

public class Provider {
    private String providerSalutation = "Default";  //ie: Dr, Mr., Mrs., LPN.,
    private Address providerAddress = setDefaultAddress();
    private String providerSpecialty = "DefaultSpecialty";  //General Practice, Cardiologist, etc

    //Constructors

    private Address setDefaultAddress() {
        Address address = null;
        address.setFeatureName("Default Name");
        address.setAddressLine(0, "Default St");
        address.setLocality("Default City");
        address.setPostalCode("00000");
        address.setPhone("000-000-0000");
        return address;
    }

    public Provider() {} //end default constructor

    public Provider(String salutation, Address address, String specialty) {
        providerSalutation = salutation;
        providerAddress = address;
        providerSpecialty = specialty;
    }//end constructor

    public Provider(String salutation, String name, int number, String street, String city,
                    String zip, String phone, String specialty){
        providerSalutation = salutation;  //ie: Dr, Mr., Mrs., LPN.,
        providerAddress.setFeatureName(name);
        providerAddress.setAddressLine(number, street);
        providerAddress.setLocality(city);
        providerAddress.setPostalCode(zip);
        providerAddress.setPhone(phone);
        providerSpecialty = specialty;
    }//end constructor to set everything from individual bits.

    //getters and setters

    public String getProviderSalutation() { return providerSalutation; }
    public void setProviderSalutation(String salutation) { providerSalutation = salutation; }

    public String getProviderNameAndSalutation() { return providerSalutation + " " + providerAddress.getFeatureName(); }

    //public void setProvider(ProviderObject provider) { scriptProvider = provider; }
    public void setProvider(String name, int number, String street, String city, String zip, String phone){
        providerAddress.setFeatureName(name);
        providerAddress.setAddressLine(number, street);
        providerAddress.setLocality(city);
        providerAddress.setPostalCode(zip);
        providerAddress.setPhone(phone);
    }//end set with all the goods
    public void setProviderName(String name) { providerAddress.setFeatureName(name);}
    public void setProviderAddress(int number, String street) { providerAddress.setAddressLine( number, street ); }
    public void setProviderCity( String city ) { providerAddress.setLocality(city); }
    public void setProviderPostalCode(String zip) { providerAddress.setPostalCode(zip);}
    public void setProviderPhone(String phone) { providerAddress.setPhone(phone);}

    public Provider getProvider() { return new Provider(providerSalutation, providerAddress, providerSpecialty); }
    public String getProviderAddressLine() { return providerAddress.getAddressLine(0); }
    public String getProviderCity() { return providerAddress.getLocality(); }
    public String getProviderPostalCode() { return providerAddress.getPostalCode(); }
    public String getProviderPhone() { return providerAddress.getPhone(); }

    public String getProviderSpecialty() { return providerSpecialty; }
    public void setProviderSpecialty(String specialty) { providerSpecialty = specialty; }

}//end Provider class
