package models.person;


import java.time.LocalDate;

public class Employee extends Person {
    private String employeeCode;
    private String educationLevel;
    private String position;
    private double salary;

    public Employee() {
    }

    public Employee(String name, LocalDate dayOfBirth, String gender, String id, String phoneNumber, String email, String employeeCode, String educationLevel, String position, double salary) {
        super(name, dayOfBirth, gender, id, phoneNumber, email);
        this.employeeCode = employeeCode;
        this.educationLevel = educationLevel;
        this.position = position;
        this.salary = salary;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String getInfoToCsvFile() {
        return super.getInfoToCsvFile()+ "," + getEmployeeCode()+ "," + getEducationLevel()+ "," +getPosition()+ "," +getSalary();
    }

    @Override
    public String toString() {
        return super.toString() + ", employee id = " + employeeCode + ", education level = " + educationLevel + ", position = " + position+", salary = " + salary;
    }
}
