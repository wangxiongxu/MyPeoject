package com.wangxu.example.wnag.geeknews.base;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActinity<P extends BasePresenter,V extends BaseView> extends AppCompatActivity implements BaseView{


    protected P basePresenter;
    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        unbinder = ButterKnife.bind(this);
        basePresenter = initPresenter();
        if (basePresenter != null) {
            basePresenter.getLong((V)this);
        }
        initView();
        initData();
        initListener();
    }

    protected abstract P initPresenter();

    protected void initData() {

    }

    protected void initListener() {

    }

    protected void initView() {

    }

    protected abstract int getLayoutId() ;

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (basePresenter != null) {
            basePresenter.onDestroy();
            basePresenter=null;
        }
    }
}
