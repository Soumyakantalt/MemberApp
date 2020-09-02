package com.nttdata.memberapp.login;

import android.os.Handler;
import android.os.Looper;
import android.view.inputmethod.InputMethodManager;

import com.nttdata.memberapp.model.UserModel;

import static android.content.Context.INPUT_METHOD_SERVICE;

public class LoginPresenterCompl implements ILoginPresenter {

    ILoginView iLoginView;
    IUser user;
    Handler handler;

    public LoginPresenterCompl(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
       // initUser();
        handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void clear() {
        iLoginView.onClearText();
    }

    @Override
    public void doLogin(final String name, final String passwd) {
        Boolean isLoginSuccess = true;
        final Boolean result = isLoginSuccess;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                    iLoginView.onLoginResult(name, passwd, result);
            }
        }, 5000);
    }

    @Override
    public void setProgressBarVisiblity(int visiblity){
        iLoginView.onSetProgressBarVisibility(visiblity);
    }

    @Override
    public void isUsernameValid(String username) {

    }

    @Override
    public void isPasswordValid(String password) {

    }

    @Override
    public void isCredentialsValid(String username, String password) {

    }
}
