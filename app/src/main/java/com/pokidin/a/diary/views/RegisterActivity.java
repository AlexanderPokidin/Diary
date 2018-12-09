package com.pokidin.a.diary.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.pokidin.a.diary.R;
import com.pokidin.a.diary.common.UserData;
import com.pokidin.a.diary.contracts.RegisterContract;
import com.pokidin.a.diary.presenters.LoginPresenterImpl;
import com.pokidin.a.diary.presenters.RegisterPresenterImpl;

public class RegisterActivity extends AppCompatActivity implements RegisterContract.RegisterView {
    private static final String TAG = LoginActivity.class.getSimpleName();

    private AutoCompleteTextView mName;
    private AutoCompleteTextView mSurname;
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private EditText mPasswordConfirmView;
    private View mProgressView;
    private View mLoginFormView;
    private RegisterContract.RegisterPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    @Override
    public void initView() {
        mName = findViewById(R.id.name);
        mSurname = findViewById(R.id.surname);
        mEmailView = findViewById(R.id.email);
        mPasswordView = findViewById(R.id.password);
        mPasswordConfirmView = findViewById(R.id.password_confirm);
        Button mEmailRegisterButton = findViewById(R.id.email_register_button);
        mPresenter = new RegisterPresenterImpl(this);
        mEmailRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Register button is pressed");
                mPresenter.registerBtnClicked();
            }
        });
        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
    }

    @Override
    public UserData getUserData() {
        return null;
    }

    @Override
    public void showToast(String message) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }
}
