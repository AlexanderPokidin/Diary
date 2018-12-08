 package com.pokidin.a.diary.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.pokidin.a.diary.R;

 public class RegisterActivity extends AppCompatActivity {

     private AutoCompleteTextView mName;
     private AutoCompleteTextView mSurname;
     private AutoCompleteTextView mEmailView;
     private EditText mPasswordView;
     private EditText mPasswordConfirmView;
     private View mProgressView;
     private View mLoginFormView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

     public void initView() {
        mName = findViewById(R.id.name);
        mSurname = findViewById(R.id.surname);
         mEmailView = findViewById(R.id.email);
         mPasswordView = findViewById(R.id.password);
         mPasswordConfirmView = findViewById(R.id.password_confirm);
         Button mEmailSignInButton = findViewById(R.id.email_register_button);
//         mPresenter = new LoginPresenterImpl(this);
//         mEmailSignInButton.setOnClickListener(new View.OnClickListener() {
//             @Override
//             public void onClick(View view) {
//                 Log.d(TAG, "Sign In button is pressed");
//                 mPresenter.signInBtnClicked();
//             }
//         });
         mLoginFormView = findViewById(R.id.login_form);
         mProgressView = findViewById(R.id.login_progress);
     }
}
