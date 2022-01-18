package com.edwin.edwin.mainModule.events;

import com.edwin.edwin.pojo.StripePojo;

import java.util.List;

public class StripeEvent {
    public static final int getStripeListRef = 1;
    public static final int getStripeCreateRef = 2;

    public static final int ERROR = 101;

    private int typeEvent;
    private String resMsg;
    private List<StripePojo> list;
    private int stripeId;

    public int getTypeEvent() {
        return typeEvent;
    }

    public void setTypeEvent(int typeEvent) {
        this.typeEvent = typeEvent;
    }

    public String getResMsg() {
        return resMsg;
    }

    public void setResMsg(String resMsg) {
        this.resMsg = resMsg;
    }

    public List<StripePojo> getList() {
        return list;
    }

    public void setList(List<StripePojo> list) {
        this.list = list;
    }

    public int getStripeId() {
        return stripeId;
    }

    public void setStripeId(int stripeId) {
        this.stripeId = stripeId;
    }
}
