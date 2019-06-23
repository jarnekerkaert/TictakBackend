package com.hogent.tictak.user;

class RegisterModel {
    private String name;
    private String password;

    RegisterModel(String name, String password) {
        this.name = name;
        this.password = password;
    }

    RegisterModel() {

    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getPassword() {
        return password;
    }

    void setPassword(String password) {
        this.password = password;
    }
}
