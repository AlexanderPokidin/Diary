package com.pokidin.a.diary.common;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserLogin {

    @SerializedName("firstName")
    @Expose
    private String name;
    @SerializedName("lastName")
    @Expose
    private String surname;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("passwordConfirmation")
    @Expose
    private String passwordConfirm;


    public UserLogin(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UserLogin(String name, String surname, String email, String password, String passwordConfirm) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}