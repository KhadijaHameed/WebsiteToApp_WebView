package com.example.bigoffer;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class BaseFragment extends Fragment implements BaseView {

    public void onBackPressed() {
        if (getActivity() != null)
            ((BaseActivity) getActivity()).onBackPressed();
    }

    public String getChassisNo() {
        return  getActivity() != null ? ((BaseActivity) getActivity()).getChassisNo() : "";
    }

    public void setChassisNo(String chassisNo) {
        if (getActivity() != null)
            ((BaseActivity) getActivity()).setChassisNo(chassisNo);
    }

    public String getRegistrationNo() {
        return  getActivity() != null ? ((BaseActivity) getActivity()).getRegistrationNo() : "";
    }

    public void setRegistrationNo(String registrationNo) {
        if (getActivity() != null)
            ((BaseActivity) getActivity()).setRegistrationNo(registrationNo);
    }

    public BaseFragment() {
        // Required empty public constructor
    }

    @Override
    public void loadFragment(BaseFragment baseFragment, Boolean addToBackStack, Bundle bundle) {
        if (getActivity() != null)
            ((BaseActivity) getActivity()).loadFragment(baseFragment, addToBackStack,bundle);
    }

    @Override
    public void setTitle(String title) {
        if (getActivity() != null)
            ((BaseActivity) getActivity()).setTitle(title);
    }

    @Override
    public void onFailureResult(Throwable t) {
        if (getActivity() != null)
            ((BaseActivity) getActivity()).onFailureResult(t);
    }

    @Override
    public void showErrorMessage(String message) {
        if (getActivity() != null)
            ((BaseActivity) getActivity()).showErrorMessage(message);
    }

    @Override
    public void showProgressIndicator() {
        if (getActivity() != null)
            ((BaseActivity) getActivity()).showProgressIndicator();
    }

    @Override
    public void hideProgressIndicator() {
        if (getActivity() != null)
            ((BaseActivity) getActivity()).hideProgressIndicator();
    }

    @Override
    public void showErrorMessage(int resourceId) {
        if (getActivity() != null)
            ((BaseActivity) getActivity()).showErrorMessage(resourceId);
    }

    @Override
    public void showSuccessMessage(String message) {
        if (getActivity() != null)
            ((BaseActivity) getActivity()).showSuccessMessage(message);
    }

    @Override
    public void showSuccessMessage(int resourceId) {
        if (getActivity() != null)
            ((BaseActivity) getActivity()).showSuccessMessage(resourceId);
    }

    @Override
    public Integer getJobCardId() {
        return getActivity() != null ? ((BaseActivity) getActivity()).getJobCardId() : 0;
    }

    @Override
    public void setJobCardId(int id) {
        if (getActivity() != null)
            ((BaseActivity) getActivity()).setJobCardId(id);
    }

    @Override
    public void viewPagerNextItem() {
        if (getActivity() != null)
            ((BaseActivity) getActivity()).viewPagerNextItem();
    }

    @Override
    public void viewPagerPreviousItem() {
        if (getActivity() != null)
            ((BaseActivity) getActivity()).viewPagerPreviousItem();
    }

    @Override
    public void clearFragmentStack() {
        if (getActivity() != null)
            ((BaseActivity) getActivity()).clearFragmentStack();
    }

    @Override
    public String getContactNo() {
        return  getActivity() != null ? ((BaseActivity) getActivity()).getContactNo() : "";
    }

    @Override
    public void setContactNo(String contactNo) {
        if (getActivity() != null)
            ((BaseActivity) getActivity()).setContactNo(contactNo);
    }

}
