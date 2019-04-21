package com.wangxu.example.wnag.geeknews.fragerment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.wangxu.example.wnag.geeknews.R;
import com.wangxu.example.wnag.geeknews.adap.wechat.WeChatAdAp;
import com.wangxu.example.wnag.geeknews.base.BasePresenter;
import com.wangxu.example.wnag.geeknews.basefrager.BaseFrager;
import com.wangxu.example.wnag.geeknews.bean.WeChatBean;
import com.wangxu.example.wnag.geeknews.contract.Contract;
import com.wangxu.example.wnag.geeknews.frag.Iflist;
import com.wangxu.example.wnag.geeknews.presenter.WechatPresenter;

import java.io.IOException;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Fragwechat extends BaseFrager {
    private View view;
    private RecyclerView mRec;

    @Override
    protected BasePresenter initPresenter() {
        WechatPresenter wechatPresenter = new WechatPresenter();
        wechatPresenter.getPrensenter();
        return wechatPresenter;
    }

    @Override
    protected void initView(View view) {
        mRec = (RecyclerView) view.findViewById(R.id.rec);
        mRec.setLayoutManager(new LinearLayoutManager(getContext()));
        getData();
    }

    private void getData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.tianapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        Observable<WeChatBean> wechat = retrofit.create(Iflist.class).getWechat("1");
        wechat.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Observer<WeChatBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(WeChatBean weChatBean) {
                        List<WeChatBean.NewslistBean> newslist = weChatBean.getNewslist();
                        WeChatAdAp weChatAdAp = new WeChatAdAp(newslist, getContext());
                        mRec.setAdapter(weChatAdAp);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Override
    protected int initFlater() {
        return R.layout.layout_wechat;
    }


    public void getFkeng(String query) {
        Toast.makeText(getContext(),"s"+query,Toast.LENGTH_SHORT).show();
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://api.tianapi.com/wxnew/?key=52b7ec3471ac3bec6846577e79f20e4c&num=10&page=1" + "&word="+query)
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("tga", "onFailure: "+e.getMessage());
            }

            @Override
            public void onResponse(Call call,  Response response) throws IOException {
                final String string = response.body().string();
                getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                WeChatBean weChatBean = new Gson().fromJson(string, WeChatBean.class);
                                int code = weChatBean.getCode();
                                if (code == 200) {
                                    List<WeChatBean.NewslistBean> newslist = weChatBean.getNewslist();
                                    WeChatAdAp weChatAdAp = new WeChatAdAp(newslist, getContext());
                                    mRec.setAdapter(weChatAdAp);
                                } else {
                                    Toast.makeText(getContext(),weChatBean.getMsg(),Toast.LENGTH_SHORT).show();
                                }

                            }
                        });
            }
        });

    }
}
