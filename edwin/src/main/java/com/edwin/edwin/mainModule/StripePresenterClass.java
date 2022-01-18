package com.edwin.edwin.mainModule;

import com.edwin.edwin.common.dataAccess.StripeApi;
import com.edwin.edwin.common.params.StripeParam;
import com.edwin.edwin.mainModule.events.StripeEvent;
import com.edwin.edwin.mainModule.model.StripeInteractor;
import com.edwin.edwin.mainModule.model.StripeInteractorClass;
import com.edwin.edwin.mainModule.view.StripeView;
import com.edwin.edwin.pojo.StripePojo;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class StripePresenterClass implements StripePresenter {

    private StripeView mView;
    private StripeInteractor mInteractor;

    public StripePresenterClass(String token, StripeView mView, String url) {
        this.mView = mView;
        mInteractor = new StripeInteractorClass(token);
        StripeApi.URL = url;
    }

    @Override
    public void onCreate() {
        EventBus.getDefault().register(this);
    }

    @Override
    public void onDestroy() {
        EventBus.getDefault().unregister(this);
        mView = null;
    }

    @Override
    public void getList(StripeParam param) {
        if(setProgress()){
            mInteractor.getList(param);
        }
    }

    @Override
    public void createStripe(StripePojo obj) {
        if(setProgress()){
            mInteractor.createStripe(obj);
        }
    }

    private boolean setProgress(){
        if(mView != null){
            mView.showProgress();
            return true;
        }
        return false;
    }

    @Subscribe
    @Override
    public void onEventListener(StripeEvent event) {
        if(mView != null){
            mView.hideProgress();
            switch ( event.getTypeEvent() ){
                case StripeEvent.getStripeListRef:
                    mView.resList(event.getList() );
                    break;
                case StripeEvent.getStripeCreateRef:
                    mView.resCreate(event.getStripeId());
                    break;
                case StripeEvent.ERROR:
                    mView.onShowError(event.getResMsg());
                    break;
            }
        }
    }
}
