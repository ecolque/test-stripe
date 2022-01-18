package com.edwin.edwin.mainModule.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.edwin.edwin.pojo.StripePojo;

import java.util.List;

public class StripeActivity2 extends AppCompatActivity  {
//implements StripeView
//    private StripePresenter mPresenter;
//
//    private Button mBtnOk;
//    private  Button mBtnCreate;
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        mPresenter.onDestroy();
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_stripe);
//
//        mPresenter = new StripePresenterClass("123456", this);
//        mPresenter.onCreate();
//
//        mBtnOk = findViewById(R.id.btnOk);
//        mBtnOk.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                StripeParam param = new StripeParam();
//                param.setName("edwin");
//                param.setLastname("colque");
//                mPresenter.getList(param);
//            }
//        });
//        mBtnCreate = findViewById(R.id.btnCreate);
//        mBtnCreate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                StripePojo obj = new StripePojo();
//                obj.setName("name");
//                mPresenter.createStripe(obj);
//            }
//        });
//    }
//
//
//    @Override
//    public void showProgress() {
//        Toast.makeText(this, "Show Progress", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void hideProgress() {
//        Toast.makeText(this, "Hide Progress", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void resList(List<StripePojo> list) {
//        Toast.makeText(this, "ok::: " + list.size(), Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void resCreate(int stripeId) {
//        Toast.makeText(this, "stripeId::: " + stripeId, Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void onShowError(String msg) {
//        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
//    }
}