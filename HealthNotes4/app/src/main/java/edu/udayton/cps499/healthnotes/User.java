package edu.udayton.cps499.healthnotes;

import java.time.LocalDateTime;

public class User {

    private int id;
    private String nameFirst;
    private String nameLast;
    private String userName;
    private String emailAddress;
    private double weightInPounds;
    private int heightFeet;
    private int heightInches;
    private LocalDateTime dateBirth;
    private char sex; // (M or m) male, (F or f) female, (O or o) Other

    public User(String nameFirst, String nameLast, String userName, String emailAddress, double weightInPounds, int heightFeet, int heightInches, LocalDateTime dateBirth, char sex) {
        this.nameFirst = nameFirst;
        this.nameLast = nameLast;
        this.userName = userName;
        this.emailAddress = emailAddress;
        this.weightInPounds = weightInPounds;
        this.heightFeet = heightFeet;
        this.heightInches = heightInches;
        this.dateBirth = dateBirth;
        this.sex = sex;
    } //end constructor full

    public User(String nameFirst, String nameLast, String userName, String emailAddress) {
        this.nameFirst = nameFirst;
        this.nameLast = nameLast;
        this.userName = userName;
        this.emailAddress = emailAddress;
    } //end constructor name, username, email

    public User(String nameFirst, String nameLast, String emailAddress) {
        this.nameFirst = nameFirst;
        this.nameLast = nameLast;
        this.emailAddress = emailAddress;
    } //end constructor name, email

    public User(String nameFirst, String nameLast) {
        this.nameFirst = nameFirst;
        this.nameLast = nameLast;
        this.emailAddress = emailAddress;
    } //end constructor name

    public User() {
        this.nameFirst = "First";
        this.nameLast = "Last";
        this.emailAddress = "Email";
    } //end constructor name

    public String getNameFirst() {
        return nameFirst;
    }

    public void setNameFirst(String nameFirst) {
        this.nameFirst = nameFirst;
    }

    public String getNameLast() {
        return nameLast;
    }

    public void setNameLast(String nameLast) {
        this.nameLast = nameLast;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public double getWeightInPounds() {
        return weightInPounds;
    }

    public void setWeightInPounds(double weightInPounds) {
        this.weightInPounds = weightInPounds;
    }

    public int getHeightFeet() {
        return heightFeet;
    }

    public void setHeightFeet(int heightFeet) {
        this.heightFeet = heightFeet;
    }

    public int getHeightInches() {
        return heightInches;
    }

    public void setHeightInches(int heightInches) {
        this.heightInches = heightInches;
    }

    public LocalDateTime getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(LocalDateTime dateBirth) {
        this.dateBirth = dateBirth;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //Method assumes the input string is a combination of either "FirstName", or "FirstName LastName"
    public void setName(String string) {
        int spaceIndex = string.indexOf(' ');
        if ( spaceIndex < 0 ) {
            nameFirst = string;
        }
        else {
            nameFirst = string.substring(0, spaceIndex);
            nameLast = string.substring(spaceIndex + 1);
        }
    }

    public String getName() {
        return (nameFirst + ' ' + nameLast);
    }
}//end user class
