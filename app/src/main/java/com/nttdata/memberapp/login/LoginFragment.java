package com.nttdata.memberapp.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.nttdata.memberapp.R;
import com.nttdata.memberapp.dashboard.DashboardActivity;

import static android.content.Context.INPUT_METHOD_SERVICE;

public class LoginFragment extends Fragment implements ILoginView, View.OnClickListener {

    private EditText editUser;
    private EditText editPass;
    private TextView errortv;
    private Button btnLogin;
    private Button btnClear;
    private ILoginPresenter loginPresenter;
    private ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        editUser = view.findViewById(R.id.et_login_username);
        editPass = view.findViewById(R.id.et_login_password);
        errortv = view.findViewById(R.id.error_tv);
        btnLogin = view.findViewById(R.id.btn_login_login);
        btnClear = view.findViewById(R.id.btn_login_clear);
        progressBar = view.findViewById(R.id.progress_login);

        //set listener
        btnLogin.setOnClickListener(this);
        btnClear.setOnClickListener(this);

        //init
        loginPresenter = new LoginPresenterCompl(this);
        loginPresenter.setProgressBarVisiblity(View.INVISIBLE);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login_clear:
                loginPresenter.clear();
                break;
            case R.id.btn_login_login:
                loginPresenter.setProgressBarVisiblity(View.VISIBLE);
                btnLogin.setEnabled(false);
                btnClear.setEnabled(false);
                hideSoftKeyboard();
                loginPresenter.doLogin(editUser.getText().toString(), editPass.getText().toString());
                break;
        }
    }

    @Override
    public void onClearText() {
        editUser.setText("");
        editPass.setText("");
        errortv.setText("");
    }

    private void hideSoftKeyboard() {
        if(getActivity().getCurrentFocus() != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
        }
    }

    @Override
    public void onLoginResult(String username, String password, Boolean result) {
        loginPresenter.setProgressBarVisiblity(View.INVISIBLE);
        btnLogin.setEnabled(true);
        btnClear.setEnabled(true);
        if(result) {
            boolean valid = true;
            if (username.length() > 30 || username.length() < 8) {
                errortv.setText("username should be less than 30 and more than 8 characters in length.");
                valid = false;
            }
            if (password.length() > 20 || password.length() < 10) {
                errortv.setText("Password should be less than 20 and more than 10 characters in length.");
                valid = false;
            }
            String upperCaseChars = "(.*[A-Z].*)";
            if (!password.matches(upperCaseChars )) {
                errortv.setText("Password should contain atleast one upper case alphabet");
                valid = false;
            }
            String lowerCaseChars = "(.*[a-z].*)";
            if (!password.matches(lowerCaseChars )) {
                errortv.setText("Password should contain atleast one lower case alphabet");
                valid = false;
            }
            String numbers = "(.*[0-9].*)";
            if (!password.matches(numbers )) {
                errortv.setText("Password should contain atleast one number.");
                valid = false;
            }
            String specialChars = "(.*[,~,!,@,#,$,%,^,&,*,(,),-,_,=,+,[,{,],},|,;,:,<,>,/,?].*$)";
            if (!password.matches(specialChars )) {
                errortv.setText("Password should contain atleast one special character");
                valid = false;
            }
            if (valid) {
                startActivity(new Intent(getActivity(), DashboardActivity.class));
            }
        } else {
            Toast.makeText(getActivity(), "Login Fail", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onSetProgressBarVisibility(int visibility) {
        progressBar.setVisibility(visibility);
    }

    @Override
    public void onUsernameValidated(boolean isValid) {

    }

    @Override
    public void onPasswordValidated(boolean isValid) {

    }

    @Override
    public void onCredentialsValidated(boolean isValid) {

    }
}
