package com.edwin.edwin.mainModule;

import com.edwin.edwin.common.params.StripeParam;
import com.edwin.edwin.mainModule.events.StripeEvent;
import com.edwin.edwin.pojo.StripePojo;

public interface StripePresenter {
    void onCreate();
    void onDestroy();

    void getList(StripeParam param);
    void createStripe(StripePojo obj);

    void onEventListener(StripeEvent event);
}
