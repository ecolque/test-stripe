package com.edwin.edwin.mainModule.events;

public interface EventCallBackCreate {
    void onSuccess(int stripeId, int typeEvent);
    void onError(int typeEvent, String resMsg);
}
