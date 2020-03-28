package edu.udayton.cps499.healthnotes;

public class Provider {
    private String salutation;
    private String name;
    private String specialty;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zip;
    private String phone;

    public Provider() { }//default constructor

    public Provider(String salutation, String name, String address, String city, String state,
                    String zip, String phone, String specialty) {
        this.salutation = salutation;
        this.name = name;
        this.specialty = specialty;
        this.address1 = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
    }//end constructor with 1address

    //Setters:
    public void setAddress1(String address1) {this.address1 = address1;  }
    public void setAddress2(String address2) {this.address2 = address2; }
    public void setCity(String city) { this.city = city; }
    public void setState(String state) { this.state = state; }
    public void setZip(String zip) { this.zip = zip; }
    public void setPhone(String phone) { this.phone = phone; }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }


    //Getters:
    public String getAddress1() { return address1; }
    public String getAddress2() { return address2; }
    public String getCity() { return city; }
    public String getState() { return state; }
    public String getZip() { return zip; }
    public String getPhone() { return phone; }

    public String getSalutation() {
        return salutation;
    }

    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }
}
