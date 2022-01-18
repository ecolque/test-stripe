package com.edwin.edwin.common.params;

import java.io.Serializable;

public class StripeParam implements Serializable {
    private String name;
    private String lastname;

//    @Exclude
//    private int tmp;
//
//    @Exclude
//    public int getTmp() {
//        return tmp;
//    }
//    @Exclude
//    public void setTmp(int tmp) {
//        this.tmp = tmp;
//    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
