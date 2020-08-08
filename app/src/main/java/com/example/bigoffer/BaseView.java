package com.example.bigoffer;

import android.os.Bundle;

public interface BaseView {
    void loadFragment(BaseFragment baseFragment, Boolean addToBackStack, Bundle bundle);

    void setTitle(String title);

    void onFailureResult(Throwable t);

    void showErrorMessage(String message);

    void showProgressIndicator();

    void hideProgressIndicator();

    void showErrorMessage(int resourceId);

    void showSuccessMessage(String message);

    void showSuccessMessage(int resourceId);

    Integer getJobCardId();

    void setJobCardId(int id);

    void viewPagerNextItem();

    void viewPagerPreviousItem();

    void clearFragmentStack();

    String getContactNo();

    void setContactNo(String contactNo);
}
