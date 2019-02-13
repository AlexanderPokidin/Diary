package com.pokidin.a.diary.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.pokidin.a.diary.R;
import com.pokidin.a.diary.common.UserData;
import com.pokidin.a.diary.contracts.EntryContract;
import com.pokidin.a.diary.presenters.EntryPresenterImpl;

public class LoginActivity extends AppCompatActivity implements EntryContract.EntryView {
    private static final String TAG = LoginActivity.class.getSimpleName();

    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;
    private EntryContract.EntryPresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
    }

    @Override
    public void initView() {
        mEmailView = findViewById(R.id.email);
        mPasswordView = findViewById(R.id.password);
        Button mEmailSignInButton = findViewById(R.id.email_sign_in_button);
        mPresenter = new EntryPresenterImpl(this);
        mEmailSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Sign In button is pressed");
                mPresenter.entryBtnClicked();
            }
        });
        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
    }

    @Override
    public UserData getUserData() {
        UserData userData = UserData.getInstance();
        userData.setEmail(mEmailView.getText().toString());
        userData.setPassword(mPasswordView.getText().toString());
        return userData;
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress() {
        mProgressView.setVisibility(View.VISIBLE);
        mLoginFormView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressView.setVisibility(View.GONE);
        mLoginFormView.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }
}
