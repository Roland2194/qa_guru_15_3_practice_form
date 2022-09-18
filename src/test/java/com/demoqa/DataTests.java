package com.demoqa;

import java.io.File;

public class DataTests {
    private String firstName, lastName, email, gender, userNumber, address, state, city, subjects, hobbies;
    private File picture;
    public DataTests() {
        this.firstName = "Egor";
        this.lastName = "Dobroskok";
        this.email = "egor_dobroskok@mail.ru";
        this.gender = "Male";
        this.userNumber = "9379997103";
        this.address = "Samara, Gagarina street, 35";
        this.state = "NCR";
        this.city = "Delhi";
        this.subjects = "History";
        this.hobbies = "Music";
        this.picture = new File("src/test/resources/exampleFile.jpg");
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public String getAddress() {
        return address;
    }

    public File getPicture() {
        return picture;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getSubjects() {
        return subjects;
    }

    public String getHobbies() {
        return hobbies;
    }
}
