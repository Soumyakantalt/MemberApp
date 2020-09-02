package com.nttdata.memberapp.login;

public interface ILoginPresenter {
    void clear();
    void doLogin(String name, String passwd);
    void setProgressBarVisiblity(int visiblity);
    void isUsernameValid(String username);
    void isPasswordValid(String password);
    void isCredentialsValid(String username, String password);
}
