package org.example.projectinform.DBRepository.Entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Data;
import lombok.Getter;

@DatabaseTable(tableName = "Students")
public class Student {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField()
    private String firstName;

    @DatabaseField()
    private String lastName;

    @DatabaseField()
    private String role;

    @DatabaseField()
    private int classStudent;

    @DatabaseField()
    private String login;

    @DatabaseField()
    private String password;

    @DatabaseField()
    private int countCoins = 0;

    @DatabaseField()
    private int resultDragonPicker = 0;

    public Student(){}

    public Student(String firstName, String lastName, String role, int classStudent, String login, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.classStudent = classStudent;
        this.login = login;
        this.password = password;
    }

    public Student(String role, int classStudent, String login, String password){
        this.role = role;
        this.classStudent = classStudent;
        this.login = login;
        this.password = password;
    }

    public void PrintInfo(){
        System.out.println(firstName + " " + lastName);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getClassStudent() {
        return classStudent;
    }

    public void setClassStudent(int classStudent) {
        this.classStudent = classStudent;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCountCoins() {
        return countCoins;
    }

    public void setCountCoins(int countCoins) {
        this.countCoins = countCoins;
    }

    public int getResultDragonPicker() {
        return resultDragonPicker;
    }

    public void setResultDragonPicker(int resultDragonPicker) {
        this.resultDragonPicker = resultDragonPicker;
    }
}
