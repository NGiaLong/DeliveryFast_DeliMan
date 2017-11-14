package com.graduationthesis.lungpanda.deliveryfast_deliman.ui.home;


import android.support.v4.app.Fragment;
import android.widget.Button;

import com.graduationthesis.lungpanda.deliveryfast_deliman.R;
import com.graduationthesis.lungpanda.deliveryfast_deliman.ui.account.ProfileActivity_;
import com.graduationthesis.lungpanda.deliveryfast_deliman.ui.account.SignInActivity_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_account)
public class AccountFragment extends Fragment {
    @ViewById(R.id.btnSignIn)
    Button mBtnSignIn;
    @ViewById(R.id.btnProfile)
    Button mBtnProfile;
    @ViewById(R.id.btnHistory)
    Button mBtnHistory;
    @ViewById(R.id.btnSetting)
    Button mBtnSetting;
    @ViewById(R.id.btnSignOut)
    Button mBtnSignOut;

    @AfterViews
    void init(){

    }

    @Click(R.id.btnSignIn)
    void setmBtnSignIn(){
        SignInActivity_.intent(this).start();
    }

    @Click(R.id.btnProfile)
    void setmBtnProfile(){
        ProfileActivity_.intent(this).start();
    }


}
