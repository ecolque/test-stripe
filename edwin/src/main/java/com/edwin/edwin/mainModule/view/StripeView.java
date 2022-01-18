package com.edwin.edwin.mainModule.view;

import com.edwin.edwin.pojo.StripePojo;

import java.util.List;

public interface StripeView {

    void showProgress();
    void hideProgress();

    void resList(List<StripePojo> list);
    void resCreate(int stripeId);

    void onShowError(String msg);
}

