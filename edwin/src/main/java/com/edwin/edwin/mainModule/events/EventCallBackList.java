package com.edwin.edwin.mainModule.events;

import com.edwin.edwin.pojo.StripePojo;

import java.util.List;

public interface EventCallBackList {
    void onSuccess(List<StripePojo> list, int typeEvent);
    void onError(int typeEvent, String resMsg);
}
