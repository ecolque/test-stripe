package com.edwin.edwin.mainModule.model;

import com.edwin.edwin.common.params.StripeParam;
import com.edwin.edwin.pojo.StripePojo;


public interface StripeInteractor {
    void getList(StripeParam param);
    void createStripe(StripePojo obj);
}
