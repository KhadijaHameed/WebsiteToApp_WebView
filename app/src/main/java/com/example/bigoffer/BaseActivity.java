package com.example.bigoffer;

import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

public class BaseActivity extends AppCompatActivity implements BaseView {
    private ActionBarDrawerToggle toggle;
    private Integer jobCardId = 0;
    private String chassisNo;
    private String registrationNo;
    private String contactNo;
    public String currentFragment = "";


    public String getChassisNo() {
        return chassisNo;
    }

    public void setChassisNo(String chassisNo) {
        this.chassisNo = chassisNo;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public void loadFragment(BaseFragment baseFragment, Boolean addToBackStack, Bundle bundle) {

    }

    @Override
    public void setTitle(String title) {

    }

    @Override
    public void onFailureResult(Throwable t) {

    }

    @Override
    public void showErrorMessage(String message) {

    }

    @Override
    public void showProgressIndicator() {

    }

    @Override
    public void hideProgressIndicator() {

    }

    @Override
    public void showErrorMessage(int resourceId) {

    }

    @Override
    public void showSuccessMessage(String message) {

    }

    @Override
    public void showSuccessMessage(int resourceId) {

    }

    @Override
    public Integer getJobCardId() {
        return jobCardId == null ? 0 : jobCardId;
    }

    @Override
    public void setJobCardId(int id) {
        this.jobCardId = id;
    }

    @Override
    public void viewPagerNextItem() {

    }

    @Override
    public void viewPagerPreviousItem() {

    }


    @Override
    public void clearFragmentStack() {
        getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }

    @Override
    public String getContactNo() {
        return contactNo;
    }

    @Override
    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }



}
