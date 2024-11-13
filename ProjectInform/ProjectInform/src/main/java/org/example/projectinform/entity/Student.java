package org.example.projectinform.entity;

import lombok.Data;

@Data
public class Student {
    private String firstName;
    private String lastName;
    private String privateName;
    private int password;
    private String role;
    private int countCoins;
}
