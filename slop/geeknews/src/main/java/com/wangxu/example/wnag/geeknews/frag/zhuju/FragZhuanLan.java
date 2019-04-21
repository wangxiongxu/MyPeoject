package com.wangxu.example.wnag.geeknews.frag.zhuju;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wangxu.example.wnag.geeknews.R;
import com.wangxu.example.wnag.geeknews.bean.ZhuanlanBean;
import com.wangxu.example.wnag.geeknews.frag.Iflist;
import com.wangxu.example.wnag.geeknews.adap.zhihu.ZhuanlanAdAp;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class FragZhuanLan extends Fragment {
    private View view;
    private RecyclerView mRec;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.layout_zhuanlan, null);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        mRec = (RecyclerView) inflate.findViewById(R.id.rec);
        mRec.setLayoutManager(new GridLayoutManager(getContext(),2));
        getData();
    }

    private void getData() {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://news-at.zhihu.com/")
                .build();
        Iflist iflist = retrofit.create(Iflist.class);
        Observable<ZhuanlanBean> zhuanlan = iflist.getZhuanlan();
        zhuanlan.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Observer<ZhuanlanBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ZhuanlanBean zhuanlanBean) {
                        List<ZhuanlanBean.DataBean> data = zhuanlanBean.getData();
                        ZhuanlanAdAp zhuanlanAdAp = new ZhuanlanAdAp(getContext(), data);
                        mRec.setAdapter(zhuanlanAdAp);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
