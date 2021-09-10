package com.kmtstudio.myloginvalidation.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.kmtstudio.myloginvalidation.Presenter.ILoginPresenter;
import com.kmtstudio.myloginvalidation.Presenter.LoginPresenterImpl;
import com.kmtstudio.myloginvalidation.R;

public class MainActivity extends AppCompatActivity implements ILoginView {

    private EditText email, password;
    private Button loginBtn;
    private ProgressBar progressBar;


    private ILoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        email = findViewById(R.id.emailID);
        password = findViewById(R.id.passwordID);

        loginBtn = findViewById(R.id.loginBtnID);

        progressBar = findViewById(R.id.progressBar);


        loginPresenter = new LoginPresenterImpl(this);


        loginPresenter.setProgressBarVisibility(View.INVISIBLE);


        loginBtn.setOnClickListener(view -> {

            loginPresenter.setProgressBarVisibility(View.VISIBLE);

            loginPresenter.doLogin(email.getText().toString().trim(), password.getText().toString().trim());

        });

    }

    @Override
    public void onLoginSuccess(String msg) {

        loginPresenter.setProgressBarVisibility(View.INVISIBLE);

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onLoginErr(String msg) {

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onSetProgressBarVisibility(int visibility) {

        progressBar.setVisibility(visibility);

    }
}