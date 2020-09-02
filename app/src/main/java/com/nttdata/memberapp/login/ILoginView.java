package com.nttdata.memberapp.login;

public interface ILoginView {
    public void onClearText();
    public void onLoginResult(String username, String password, Boolean result);
    public void onSetProgressBarVisibility(int visibility);
    public void onUsernameValidated(boolean isValid);
    public void onPasswordValidated(boolean isValid);
    public void onCredentialsValidated(boolean isValid);
}
