package models.person;

import java.time.LocalDate;

public abstract class Person {
    private String name;
    private LocalDate dayOfBirth;
    private String gender;
    private String id;
    private String phoneNumber;
    private String email;

    public Person() {
    }

    public Person(String name, LocalDate dayOfBird, String gender, String id, String phoneNumber, String email) {
        this.name = name;
        this.dayOfBirth = dayOfBird;
        this.gender = gender;
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(LocalDate dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Name = " + name + ", DayOfBirth = " + dayOfBirth + ", Gender = " + gender + ", ID = " + id +
                ", PhoneNumber = " + phoneNumber + ", Email = " + email;
    }
    public  String getInfoToCsvFile(){
        return getName() + "," + getDayOfBirth()+ "," +getGender()+ "," +getId()+ "," +getPhoneNumber()+ "," +
                getEmail();
    }
}
