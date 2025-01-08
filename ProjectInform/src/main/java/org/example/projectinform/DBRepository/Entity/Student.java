package org.example.projectinform.DBRepository.Entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Data;

@Data
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

}
