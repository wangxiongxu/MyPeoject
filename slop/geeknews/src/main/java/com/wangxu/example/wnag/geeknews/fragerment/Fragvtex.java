package com.wangxu.example.wnag.geeknews.fragerment;



import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;

import android.view.View;

import android.widget.ImageView;

import com.wangxu.example.wnag.geeknews.R;
import com.wangxu.example.wnag.geeknews.activity.VtexShuActivity;
import com.wangxu.example.wnag.geeknews.adap.vtex.VtexVpFrag;
import com.wangxu.example.wnag.geeknews.base.BasePresenter;
import com.wangxu.example.wnag.geeknews.basefrager.BaseFrager;
import com.wangxu.example.wnag.geeknews.bean.FramhtmlBean;
import com.wangxu.example.wnag.geeknews.bean.TabBean;
import com.wangxu.example.wnag.geeknews.frag.vtex.Vtexfrag;
import com.wangxu.example.wnag.geeknews.presenter.VtexPresenter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//王旭  1808A
public class Fragvtex extends BaseFrager {
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            for (int i = 0; i < tabBeans.size(); i++) {
                Vtexfrag vtexfrag = new Vtexfrag();
                Bundle bundle = new Bundle();
                bundle.putSerializable("1", (Serializable) framhtmlBeans);
                vtexfrag.setArguments(bundle);
                strings.add(vtexfrag);
            }
            VtexVpFrag vtexVpFrag = new VtexVpFrag(getChildFragmentManager(), tabBeans, strings);
            mVp.setAdapter(vtexVpFrag);
            mTab.setupWithViewPager(mVp);

        }
    };
    private static final String TAG = "tagkl";
    private View view;
    private TabLayout mTab;
    private ImageView mIv;
    private ViewPager mVp;
    private String mUrl = "https://www.v2ex.com/";
    private List<TabBean> tabBeans;
    private List<FramhtmlBean> framhtmlBeans;
    private ArrayList<Fragment> strings;

    @Override
    protected BasePresenter initPresenter() {
        VtexPresenter vtexPresenter = new VtexPresenter();
        return vtexPresenter;
    }
    @Override
    protected int initFlater() {
        return R.layout.layout_vtex;
    }

    @Override
    protected void initView(View view) {
        mTab = (TabLayout) view.findViewById(R.id.tab);
        mIv = (ImageView) view.findViewById(R.id.iv);
        mVp = (ViewPager) view.findViewById(R.id.vp);
        tabBeans = new ArrayList<>();
        framhtmlBeans = new ArrayList<>();
        strings = new ArrayList<>();
        mIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),VtexShuActivity.class));
            }
        });
        getData();
    }

    private void getData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Document document = Jsoup.connect(mUrl).get();
                    Elements select = document.select("div#Tabs");
                    Elements select1 = select.select("a[href]");
                    for (Element element : select1) {
                        String href = element.attr("href");
                        //Log.i("tag", "run: "+href);
                        String text = element.text();
                        tabBeans.add(new TabBean(text,href));
                        //Log.i("tag", "run: "+text);
                    }
                    //新闻标题



                    Elements select2 = document.select("div.cell.item");
                    for (Element element : select2) {
                        Elements select3 = element.select("table tr td a > img.avatar");
                        String hred = select3.attr("src");
                        //Log.i("tag", "run: "+hred);
                     //title
                        Elements title = element.select("table tbody tr td span.item_title > a");
                        String text = title.text();
                        //Log.i("tag", "title: "+text);
                        Elements select4 = element.select("table tr td a.count_livid");
                        String text1="";
                        if (select4 != null) {
                            String href = select4.attr("href");
                             text1 = select4.text();
                            //Log.i("tag", "run: "+href+"  kop  "+text1);
                        } else {
                            text1="0";
                            //Log.i("tag", "run: "+"无数据");
                        }
                        //topic_info
                        Element topic = element.select("table tbody tr td span.topic_info").first();
                        Element secondaryTab = topic.select("a.node").first();
                        String q = secondaryTab.text();
                        Log.i("tagkl", "1: "+q);

                        String w = topic.text();
                        Log.i("tagkl", "2: "+w);
                        String t="";
                        String g="";
                        Elements e = topic.select("strong > a");
                        if (e.size() > 0) {
                            Element r = e.get(0);
                            t = r.text();
                            Log.i("tagkl", "3: "+t);
                        }
                        if (e.size() > 1) {
                            Element f = e.get(1);
                            g = f.text();
                            Log.i("tagkl", "4: "+g);
                        }
                        framhtmlBeans.add(new FramhtmlBean(hred,text,text1,q+t+w+g));

                       /* String s = select5.toString();
                        Log.i("tagg", "run: "+s);*/


                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
                Message message = new Message();
                handler.sendMessage(message);

            }
        }).start();



    }


}
