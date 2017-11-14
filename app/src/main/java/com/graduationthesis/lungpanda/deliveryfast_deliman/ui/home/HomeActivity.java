package com.graduationthesis.lungpanda.deliveryfast_deliman.ui.home;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;

import com.graduationthesis.lungpanda.deliveryfast_deliman.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.lang.reflect.Field;

@EActivity(R.layout.activity_home)
public class HomeActivity extends AppCompatActivity {
    @ViewById(R.id.bottom_navigation)
    BottomNavigationView bottomNavigation;
    Fragment fragment;
    FragmentManager fragmentManager;
    FragmentTransaction transaction;
    @AfterViews
    void inti(){
        bottomNavigation.inflateMenu(R.menu.bottom_menu);
        fragmentManager = getSupportFragmentManager();
        replaceFragment(BillFragment_.builder().build());
        disableShiftMode(bottomNavigation);
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                int selectedItemId = bottomNavigation.getSelectedItemId();
                try {
                    InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                } catch (Exception e) {
                }
                if (id == selectedItemId) return false;
                switch (id) {
                    case R.id.action_bill:
                        fragment = BillFragment_.builder().build();
                        break;
                    case R.id.action_notification:
                        fragment = NotificationFragment_.builder().build();
                        break;
                    case R.id.action_user:
                        fragment = AccountFragment_.builder().build();
                        break;
                }
//                fragment.setEnterTransition(new Slide(Gravity.RIGHT));
                replaceFragment(fragment);
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        int seletedItemId = bottomNavigation.getSelectedItemId();
        if (R.id.action_bill != seletedItemId) {
            Log.i("TEST123456", "false");
            bottomNavigation.setSelectedItemId(R.id.action_bill);
        } else {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(HomeActivity.this);
            //AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();

            // Setting Dialog Title
            alertDialog.setTitle("EXIT");
//            alertDialog.setIcon(R.drawable.delete);

            // Setting Dialog Message
            alertDialog.setMessage("Do you want to exit?");

            // Setting Positive "Yes" Button
            alertDialog.setPositiveButton("YES",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });
            // Setting Negative "NO" Button
            alertDialog.setNegativeButton("NO",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });

            // closed

            // Showing Alert Message
            alertDialog.show();

        }
    }

    public void replaceFragment(Fragment frag) {
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.main_container, frag).commit();
    }

    public void selectFragment(Fragment fragment){
        bottomNavigation.setSelectedItemId(fragment.getId());
    }

    @SuppressLint("RestrictedApi")
    public void disableShiftMode(BottomNavigationView view) {
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);
        try {
            Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(menuView, false);
            shiftingMode.setAccessible(false);
            for (int i = 0; i < menuView.getChildCount(); i++) {
                BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(i);
                item.setShiftingMode(false);
                // set once again checked value, so view will be updated
                item.setChecked(item.getItemData().isChecked());
            }
        } catch (NoSuchFieldException e) {
            Log.e("TAG", "Unable to get shift mode field");
        } catch (IllegalAccessException e) {
            Log.e("TAG", "Unable to change value of shift mode");
        }
    }
}

