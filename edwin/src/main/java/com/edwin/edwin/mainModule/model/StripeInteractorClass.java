package com.edwin.edwin.mainModule.model;

import android.util.Log;

import com.edwin.edwin.common.dataAccess.StripeApi;
import com.edwin.edwin.common.params.StripeParam;
import com.edwin.edwin.mainModule.events.EventCallBackCreate;
import com.edwin.edwin.mainModule.events.EventCallBackList;
import com.edwin.edwin.mainModule.events.StripeEvent;
import com.edwin.edwin.pojo.StripePojo;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

public class StripeInteractorClass implements StripeInteractor{

    private StripeApi mService;

    public StripeInteractorClass(String token) {
        this.mService = new StripeApi(token);
    }


    @Override
    public void getList(StripeParam param) {
        mService.getList(param, new EventCallBackList() {
            @Override
            public void onSuccess(List<StripePojo> list, int typeEvent) {
                post(list, typeEvent);
            }

            @Override
            public void onError(int typeEvent, String resMsg) {
                Log.e("edwin", resMsg);
                post(typeEvent, resMsg);
            }
        });
    }

    @Override
    public void createStripe(StripePojo obj) {
        mService.create(obj, new EventCallBackCreate() {
            @Override
            public void onSuccess(int stripeId, int typeEvent) {
                Log.e("edwin::", stripeId + "");
                post(typeEvent, stripeId);
            }

            @Override
            public void onError(int typeEvent, String resMsg) {
                post(typeEvent, resMsg);
            }
        });
    }

    void post(int typeEvent, int stripeId){ post(null, stripeId, typeEvent, null); }
    void post(int typeEvent, String resMsg){
        post(null, 0, typeEvent, resMsg);
    }
    void post(List<StripePojo> list, int typeEvent) { post(list, 0, typeEvent, null); }
    void post(List<StripePojo> list, int stripeId, int typeEvent, String resMsg){
        StripeEvent event = new StripeEvent();
        event.setList(list);
        event.setTypeEvent(typeEvent);
        event.setResMsg(resMsg);
        event.setStripeId(stripeId);
        EventBus.getDefault().post(event);
    }
}
