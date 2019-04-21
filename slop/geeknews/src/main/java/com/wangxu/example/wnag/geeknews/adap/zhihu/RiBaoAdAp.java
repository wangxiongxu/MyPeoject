package com.wangxu.example.wnag.geeknews.adap.zhihu;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wangxu.example.wnag.geeknews.R;
import com.wangxu.example.wnag.geeknews.bean.RiBaoBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class RiBaoAdAp extends RecyclerView.Adapter {
    String date = "";
    String data = "";
    public void daTa(String string){
        data=string;
    }

   private List<RiBaoBean.StoriesBean> stories = new ArrayList<>();
   private List<RiBaoBean.TopStoriesBean> top_Banner = new ArrayList<>();
    Context context;
    private int a;
    private BanVH banVH;
    private Banner banner;

    public RiBaoAdAp(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 1) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.layout_recribaobanner, null);
            BanVH banVH = new BanVH(inflate);
            return banVH;
        } else if (viewType == 2) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.layout_recribaotext, null);
            TeVH teVH = new TeVH(inflate);
            return teVH;
        }else {
            View inflate = LayoutInflater.from(context).inflate(R.layout.layout_recribaoshuju, null);
            ShuJuVH shuJuVH = new ShuJuVH(inflate);
            return shuJuVH;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        if (itemViewType == 1) {
            banVH = (BanVH) holder;
            //banVH.textView.setText(top_Banner.get(position).getTitle());

            banner = banVH.banner.setImages(top_Banner);
            /*ArrayList<String> strings = new ArrayList<>();
            if (top_Banner.size() > 0) {
                for (RiBaoBean.TopStoriesBean bean : top_Banner) {
                    strings.add(bean.getTitle());
                }
            }*/
            //banner.setBannerTitles(strings);
            banner.setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    RiBaoBean.TopStoriesBean bean= (RiBaoBean.TopStoriesBean) path;
                    Glide.with(context).load(bean.getImage()).into(imageView);
                }
            }).start();
            banner.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {
                    if (top_Banner.size() == 0) {

                    } else {
                        banVH.textView.setText(top_Banner.get(position).getTitle());
                    }

                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });
        } else if (itemViewType == 2) {
            TeVH teVH = (TeVH) holder;
            if (data.equals("1")) {
                teVH.tv.setText("热点新闻");

            } else {
                teVH.tv.setText(date);
            }

        } else {
            a = position-1;
            if (top_Banner.size() > 0) {
                a -= 1;
            }
            ShuJuVH shuJuVH= (ShuJuVH) holder;
            shuJuVH.tv.setText(stories.get(a).getTitle());
            Glide.with(context).load(stories.get(a).getImages().get(0)).into(shuJuVH.iv);
        }
    }

    @Override
    public int getItemCount() {
        if (top_Banner.size() > 0) {
            return 1 + stories.size() + 1;
        } else {
            return 1+stories.size();
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (top_Banner.size() > 0) {
            if (position == 0) {
                return 1;
            } else if (position == 1) {
                return 2;
            } else {
                return 3;
            }

        } else {
            if (position == 0) {
                return 2;
            } else {
                return 3;
            }
        }

    }


    class BanVH extends RecyclerView.ViewHolder{
        Banner banner;
        TextView textView;
        public BanVH(View itemView) {
            super(itemView);
            banner=itemView.findViewById(R.id.ban);
            textView=itemView.findViewById(R.id.tvtitle);
        }
    }
    class TeVH extends RecyclerView.ViewHolder{
        TextView tv;
        public TeVH(View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.tv);
        }
    }
    class ShuJuVH extends RecyclerView.ViewHolder{
        ImageView iv;
        TextView tv;
        public ShuJuVH(View itemView) {
            super(itemView);
            iv=itemView.findViewById(R.id.iv);
            tv=itemView.findViewById(R.id.tv);
        }


    }
    public void getstories(List<RiBaoBean.StoriesBean> s) {
        stories=s;
        notifyDataSetChanged();
    }
    public void getdata(String d) {
        date=d;
        notifyDataSetChanged();
    }
    public void getban(List<RiBaoBean.TopStoriesBean> anner) {
        top_Banner=anner;
        notifyDataSetChanged();
    }
    public void getcler() {
        top_Banner.clear();

        notifyDataSetChanged();
    }
    public void getcccccler() {
        stories.clear();
        notifyDataSetChanged();
    }

}
