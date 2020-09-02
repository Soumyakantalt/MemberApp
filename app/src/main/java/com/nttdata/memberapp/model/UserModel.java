package com.nttdata.memberapp.model;

import com.nttdata.memberapp.login.IUser;

public class UserModel implements IUser {

    String name;
    String passwd;

    public UserModel(String name, String passwd) {
        this.name = name;
        this.passwd = passwd;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPasswd() {
        return passwd;
    }

    @Override
    public int checkUserValidity(String name, String passwd) {
        if (name == null || passwd == null || !name.equals(getName()) || !passwd.equals(getPasswd())) {
            return -1;
        }
        return 0;
    }

    @Override
    public int isUsernameValid(String username) {
        return 0;
    }

    @Override
    public int isPasswordValid(String password) {
        boolean valid = true;
        if (password.length() > 20 || password.length() < 10) {
            System.out.println("Password should be less than 20 and more than 10 characters in length.");
            valid = false;
        }
        if (password.indexOf(password) > -1) {
            System.out.println("Password Should not be same as user name");
            valid = false;
        }
        String upperCaseChars = "(.*[A-Z].*)";
        if (!password.matches(upperCaseChars )) {
            System.out.println("Password should contain atleast one upper case alphabet");
            valid = false;
        }
        String lowerCaseChars = "(.*[a-z].*)";
        if (!password.matches(lowerCaseChars )) {
            System.out.println("Password should contain atleast one lower case alphabet");
            valid = false;
        }
        String numbers = "(.*[0-9].*)";
        if (!password.matches(numbers )) {
            System.out.println("Password should contain atleast one number.");
            valid = false;
        }
        String specialChars = "(.*[,~,!,@,#,$,%,^,&,*,(,),-,_,=,+,[,{,],},|,;,:,<,>,/,?].*$)";
        if (!password.matches(specialChars )) {
            System.out.println("Password should contain atleast one special character");
            valid = false;
        }
        if (valid) {
            System.out.println("Password is valid.");
        }
        return 0;
    }

    @Override
    public int isCredentialsValid(String username, String password) {
        return 0;
    }
}
