package com.edwin.edwin.common.dataAccess;

import com.edwin.edwin.common.params.StripeParam;
import com.edwin.edwin.mainModule.events.EventCallBackCreate;
import com.edwin.edwin.mainModule.events.EventCallBackList;
import com.edwin.edwin.mainModule.events.StripeEvent;
import com.edwin.edwin.mainModule.response.CreateResponse;
import com.edwin.edwin.mainModule.response.ListResponse;
import com.edwin.edwin.pojo.StripePojo;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StripeApi {
    public static String URL;
    private String token;

    public StripeApi(String token) {
        this.token = token;
    }

    public void getList(StripeParam param, final EventCallBackList callback){
        try {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(this.URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            StripeService service = retrofit.create(StripeService.class);
            Call<ListResponse> call = service.getList(param, this.token);

            call.enqueue(new Callback<ListResponse>() {
                @Override
                public void onResponse(Call<ListResponse> call, Response<ListResponse> response) {
                    if(!response.isSuccessful()){
                        callback.onError(StripeEvent.ERROR, response.message());
                        return;
                    }
                    ListResponse result = response.body();
                    if(!result.isStatus()){
                        callback.onError(StripeEvent.ERROR, result.getMessage());
                        return;
                    }
                    callback.onSuccess(result.getList(), StripeEvent.getStripeListRef);
                }

                @Override
                public void onFailure(Call<ListResponse> call, Throwable t) {
                    callback.onError(StripeEvent.ERROR, t.getMessage());
                }
            });

        }catch (Exception e){
            callback.onError(StripeEvent.ERROR, e.getMessage());
        }
    }

    public void create(StripePojo obj, final EventCallBackCreate callback){
        try {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(this.URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            StripeService service = retrofit.create(StripeService.class);
            Call<CreateResponse> call = service.create(obj, this.token);

            call.enqueue(new Callback<CreateResponse>() {
                @Override
                public void onResponse(Call<CreateResponse> call, Response<CreateResponse> response) {
                    if(!response.isSuccessful()){
                        callback.onError(StripeEvent.ERROR, response.message());
                        return;
                    }
                    CreateResponse result = response.body();
                    if(!result.isStatus()){
                        callback.onError(StripeEvent.ERROR, result.getMessage());
                        return;
                    }
                    callback.onSuccess(result.getId(), StripeEvent.getStripeCreateRef);
                }

                @Override
                public void onFailure(Call<CreateResponse> call, Throwable t) {
                    callback.onError(StripeEvent.ERROR, t.getMessage());
                }
            });

        }catch (Exception e){
            callback.onError(StripeEvent.ERROR, e.getMessage());
        }
    }
}
