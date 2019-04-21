package com.wangxu.example.wnag.geeknews.frag;

import com.wangxu.example.wnag.geeknews.bean.ReMenBean;
import com.wangxu.example.wnag.geeknews.bean.RiBaoBean;
import com.wangxu.example.wnag.geeknews.bean.WeChatBean;
import com.wangxu.example.wnag.geeknews.bean.ZhuanlanBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Iflist {
//http://news-at.zhihu.com/
    //http://news-at.zhihu.com/api/4/sections
    //http://news-at.zhihu.com/api/4/news/hot
    //http://news-at.zhihu.com/api/4/news/before/{date}
    @GET("api/4/news/latest")
    Observable<RiBaoBean> getRibao();
    @GET("api/4/sections")
    Observable<ZhuanlanBean> getZhuanlan();
    @GET("api/4/news/hot")
    Observable<ReMenBean> getRemen();
    @GET("news/before/{date}")
    Observable<RiBaoBean> getwnagriRibao(@Path("date") String string);
    //http://api.tianapi.com/wxnew/?key=52b7ec3471ac3bec6846577e79f20e4c&num=10&page=1
    @GET("wxnew/?key=52b7ec3471ac3bec6846577e79f20e4c&num=10&")
    Observable<WeChatBean> getWechat(@Query("page") String string);

}
