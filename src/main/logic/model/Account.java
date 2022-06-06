package main.logic.model;

public class Account {
    String username,password,fullname;

    public Account setUsername(String username) {
        this.username = username;
        return this;
    }

    public Account setFullname(String fullname) {
        this.fullname = fullname;
        return this;
    }
}
