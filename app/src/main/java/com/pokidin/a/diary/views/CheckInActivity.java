package com.pokidin.a.diary.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.pokidin.a.diary.R;
import com.pokidin.a.diary.common.UserData;
import com.pokidin.a.diary.contracts.CheckInContract;
import com.pokidin.a.diary.presenters.CheckInPresenterImpl;

public class CheckInActivity extends AppCompatActivity implements CheckInContract.CheckInView {
    private static final String TAG = LoginActivity.class.getSimpleName();

    private AutoCompleteTextView mName;
    private AutoCompleteTextView mSurname;
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private EditText mPasswordConfirmView;
    private View mProgressView;
    private View mLoginFormView;
    private CheckInContract.CheckInPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in);

        initView();
    }

    @Override
    public void initView() {
        mName = findViewById(R.id.name);
        mSurname = findViewById(R.id.surname);
        mEmailView = findViewById(R.id.email);
        mPasswordView = findViewById(R.id.password);
        mPasswordConfirmView = findViewById(R.id.password_confirm);
        Button mEmailRegisterButton = findViewById(R.id.email_register_button);
        mPresenter = new CheckInPresenterImpl(this);
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
        UserData userData = UserData.getInstance();
        userData.setEmail(mEmailView.getText().toString());
        userData.setPassword(mPasswordView.getText().toString());
        userData.setPasswordConfirm(mPasswordConfirmView.getText().toString());
        userData.setName(mName.getText().toString());
        userData.setSurname(mSurname.getText().toString());
        return userData;
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }
}
