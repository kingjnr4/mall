package main.logic.model;

import main.logic.Role;

import java.util.Date;

public class Account {
    String name,surname,gender;
    Date dob;
    Role role;

    public Account(String name, String surname, String gender, Date dob, Role role) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.dob = dob;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getGender() {
        return gender;
    }

    public Date getDob() {
        return dob;
    }

    public Role getRole() {
        return role;
    }



}
