package com.kmtstudio.myloginvalidation.View;

public interface ILoginView {

    void onLoginSuccess (String msg);
    void onLoginErr (String msg);
    void onSetProgressBarVisibility (int visibility);
}
