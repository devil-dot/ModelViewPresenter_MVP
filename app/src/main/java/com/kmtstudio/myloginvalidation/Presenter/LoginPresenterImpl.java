package com.kmtstudio.myloginvalidation.Presenter;

import android.os.Handler;
import android.os.Looper;

import com.kmtstudio.myloginvalidation.Model.IUser;
import com.kmtstudio.myloginvalidation.Model.UserImpl;
import com.kmtstudio.myloginvalidation.View.ILoginView;

public class LoginPresenterImpl implements ILoginPresenter{


    private ILoginView loginView;
    private Handler handler;

    public LoginPresenterImpl(ILoginView loginView) {
        this.loginView = loginView;

        handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void doLogin(String email, String pass) {


        IUser iUser = new UserImpl(email,pass);
        int loginCode = iUser.checkUserValidity();


        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                if (loginCode==0) {

                    loginView.onLoginErr("Please enter your email");

                } else if (loginCode==1) {

                    loginView.onLoginErr("Please enter a valid email");

                } else if (loginCode==2) {

                    loginView.onLoginErr("Please enter your password");

                } else if (loginCode==3) {

                    loginView.onLoginErr("Please enter password that should be more than 6 character");

                } else {

                    loginView.onLoginSuccess("Login Successful!!");
                }

            }
        },2000);


    }

    @Override
    public void setProgressBarVisibility(int visibility) {

        loginView.onSetProgressBarVisibility(visibility);

    }
}
