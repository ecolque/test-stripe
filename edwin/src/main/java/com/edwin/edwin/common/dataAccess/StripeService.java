package com.edwin.edwin.common.dataAccess;

import com.edwin.edwin.common.params.StripeParam;
import com.edwin.edwin.mainModule.response.CreateResponse;
import com.edwin.edwin.mainModule.response.ListResponse;
import com.edwin.edwin.pojo.StripePojo;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface StripeService {
    @POST("list")
    Call<ListResponse> getList(@Body StripeParam param, @Header("token") String token);

    @POST("create")
    Call<CreateResponse> create(@Body StripePojo obj, @Header("token") String token);
}
