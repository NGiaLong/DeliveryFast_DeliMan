package com.graduationthesis.lungpanda.deliveryfast_deliman.ui.account;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.graduationthesis.lungpanda.deliveryfast_deliman.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_sign_in)
public class SignInActivity extends AppCompatActivity {
    @ViewById(R.id.edtPhoneNumber)
    EditText mEdtPhoneNumber;
    @ViewById(R.id.edtPassword)
    EditText mEdtPassword;
    @ViewById(R.id.btnSignIn)
    Button mBtnSignIn;

    @AfterViews
    void init(){

    }

    @Click(R.id.btnSignIn)
    void setmBtnSignIn(){
        String phoneNumber = mEdtPhoneNumber.getText().toString().trim();
        String password = mEdtPassword.getText().toString().trim();

        if (!phoneNumber.equals("")){
            if (phoneNumber.length() < 10){
                mEdtPhoneNumber.setError("Deliver's phone must be at least 10 digit!");
                mEdtPhoneNumber.requestFocus();
            } else if (!password.equals("")){
                if (password.length() < 8) {
                    mEdtPassword.setError("Password must be at least 8 characters!");
                    mEdtPassword.requestFocus();
                } else {
                    //gửi api
                }
            } else {
                mEdtPassword.setError("Password can't be blank!");
                mEdtPassword.requestFocus();
            }
        } else {
            mEdtPhoneNumber.setError("Deliver's phone can't be blank!");
            mEdtPhoneNumber.requestFocus();
        }

    }

}
