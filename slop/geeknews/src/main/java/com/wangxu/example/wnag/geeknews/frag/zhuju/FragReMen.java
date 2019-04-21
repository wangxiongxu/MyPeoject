package com.wangxu.example.wnag.geeknews.frag.zhuju;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wangxu.example.wnag.geeknews.R;
import com.wangxu.example.wnag.geeknews.bean.ReMenBean;
import com.wangxu.example.wnag.geeknews.frag.Iflist;
import com.wangxu.example.wnag.geeknews.adap.zhihu.RenmenAdAp;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class FragReMen extends Fragment {
    private View view;
    private RecyclerView mRec;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.layout_remen, null);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        mRec = (RecyclerView) inflate.findViewById(R.id.rec);
        mRec.setLayoutManager(new LinearLayoutManager(getContext()));
        getData();
    }

    private void getData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://news-at.zhihu.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        Iflist iflist = retrofit.create(Iflist.class);
        iflist.getRemen().observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Observer<ReMenBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ReMenBean reMenBean) {
                        List<ReMenBean.RecentBean> recent = reMenBean.getRecent();
                        RenmenAdAp renmenAdAp = new RenmenAdAp(recent, getContext());
                        mRec.setAdapter(renmenAdAp);
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
