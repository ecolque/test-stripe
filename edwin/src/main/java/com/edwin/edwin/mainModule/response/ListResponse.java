package com.edwin.edwin.mainModule.response;

import com.edwin.edwin.pojo.StripePojo;

import java.util.List;

public class ListResponse extends StripeResponse {
    private List<StripePojo> list;

    public List<StripePojo> getList() {
        return list;
    }

    public void setList(List<StripePojo> list) {
        this.list = list;
    }

}
