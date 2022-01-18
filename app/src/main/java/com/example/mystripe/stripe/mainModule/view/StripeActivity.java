package com.example.mystripe.stripe.mainModule.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.edwin.edwin.common.params.StripeParam;
import com.edwin.edwin.mainModule.StripePresenter;
import com.edwin.edwin.mainModule.StripePresenterClass;
import com.edwin.edwin.mainModule.view.StripeView;
import com.example.mystripe.R;
import com.edwin.edwin.pojo.StripePojo;

import java.util.List;

public class StripeActivity extends AppCompatActivity implements StripeView {

    private StripePresenter mPresenter;

    private Button mBtnOk;
    private  Button mBtnCreate;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stripe);

        mPresenter = new StripePresenterClass("123456", this, "http://10.10.0.102:8082/edwin/stripe/service/");
        mPresenter.onCreate();

        mBtnOk = findViewById(R.id.btnOk);
        mBtnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StripeParam param = new StripeParam();
                param.setName("edwin");
                param.setLastname("colque");
                mPresenter.getList(param);
            }
        });
        mBtnCreate = findViewById(R.id.btnCreate);
        mBtnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                StripePojo obj = new StripePojo();
                obj.setName("name");
                mPresenter.createStripe(obj);
            }
        });
    }


    @Override
    public void showProgress() {
        Toast.makeText(this, "Show Progress", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideProgress() {
        Toast.makeText(this, "Hide Progress", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void resList(List<StripePojo> list) {
        Toast.makeText(this, "ok::: " + list.size(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void resCreate(int stripeId) {
        Toast.makeText(this, "stripeId::: " + stripeId, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onShowError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}