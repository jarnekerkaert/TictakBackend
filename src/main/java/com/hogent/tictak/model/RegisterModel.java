package com.hogent.tictak.model;

public class RegisterModel {
    private String name;
    private String password;

    public RegisterModel(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public RegisterModel() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
