package com.nttdata.memberapp.model;

public class Member {

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String gender;
    private String name;
    private String phoneNumber;
    private String email;

    public Member(String name, String gender, String phoneNumber, String email) {
        this.name = name;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    @Override
    public String toString() {
        return "DataModel{" +
                "gender=" + gender +
                ", name='" + name + '\'' +
                ", email=" + email +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
