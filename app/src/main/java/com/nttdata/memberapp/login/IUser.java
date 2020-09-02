package com.nttdata.memberapp.login;

public interface IUser {

    String getName();
    String getPasswd();
    int checkUserValidity(String name, String passwd);
    int isUsernameValid(String username);
    int isPasswordValid(String password);
    int isCredentialsValid(String username, String password);
}