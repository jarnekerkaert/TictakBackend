package com.hogent.tictak.user;

class LoginModel {

    private String name;
    private String password;

    LoginModel(String name, String password) {
        this.name = name;
        this.password = password;
    }

    LoginModel() {

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
