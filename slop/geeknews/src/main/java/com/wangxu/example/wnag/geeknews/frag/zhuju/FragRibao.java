package com.wangxu.example.wnag.geeknews.frag.zhuju;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.clans.fab.FloatingActionButton;
import com.google.gson.Gson;
import com.wangxu.example.wnag.geeknews.R;
import com.wangxu.example.wnag.geeknews.activity.RiLiActivity;
import com.wangxu.example.wnag.geeknews.adap.zhihu.RiBaoAdAp;
import com.wangxu.example.wnag.geeknews.bean.RiBaoBean;
import com.wangxu.example.wnag.geeknews.frag.Iflist;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class FragRibao extends Fragment {
    private View view;
    private RecyclerView mRec;
    RiBaoBean riBean;
    private RiBaoAdAp riBaoAdAp;
    private FloatingActionButton mfvb;
    String a;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.layout_ribao, null);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        mRec = (RecyclerView) inflate.findViewById(R.id.rec);
        mRec.setLayoutManager(new LinearLayoutManager(getContext()));
        mfvb = (FloatingActionButton) inflate.findViewById(R.id.fal);
        mfvb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(getActivity(),RiLiActivity.class),100);
            }
        });
        riBaoAdAp = new RiBaoAdAp(getContext());
        mRec.setAdapter(riBaoAdAp);

        getData();

    }
    private void getDate() {
        /*riBaoAdAp.getcler();*/
        String date = riBean.getDate();
        List<RiBaoBean.StoriesBean> stories = riBean.getStories();
        List<RiBaoBean.TopStoriesBean> top_Banner = riBean.getTop_stories();
        riBaoAdAp.daTa(a);
        if (date != null) {
            riBaoAdAp.getdata(date);
        }

        if (stories != null) {
            riBaoAdAp.getstories(stories);
        }else {

        }

        if (top_Banner != null) {
            riBaoAdAp.getban(top_Banner);
        }else {
            List<RiBaoBean.TopStoriesBean> objects = new ArrayList<>();
            riBaoAdAp.getban(objects);
        }

    }

    private void getData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://news-at.zhihu.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        Iflist iflist = retrofit.create(Iflist.class);
        iflist.getRibao().observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Observer<RiBaoBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RiBaoBean riBaoBean) {
                        riBean=riBaoBean;
                        a="1";
                        getDate();

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
//王旭  1808A
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == 200) {
            String stringExtra = data.getStringExtra("1");
            getDa(stringExtra);
        }
    }

    private void getDa(String stringExtra) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://news-at.zhihu.com/api/4/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Iflist iflist = retrofit.create(Iflist.class);
        iflist.getwnagriRibao(stringExtra)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Observer<RiBaoBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RiBaoBean riBaoBean) {
                        riBean=riBaoBean;
                        a="5";
                        getDate();

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("tag", "onError: "+e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
