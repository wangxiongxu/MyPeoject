package com.wangxu.example.wnag.geeknews.adap.zhihu;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wangxu.example.wnag.geeknews.R;
import com.wangxu.example.wnag.geeknews.bean.ReMenBean;

import java.util.List;

public class RenmenAdAp extends RecyclerView.Adapter<RenmenAdAp.ViewHodel> {
    List<ReMenBean.RecentBean> recent;
    Context context;

    public RenmenAdAp(List<ReMenBean.RecentBean> recent, Context context) {
        this.recent = recent;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_recrenmenshuju, null);
        ViewHodel viewHodel = new ViewHodel(inflate);
        return viewHodel;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodel holder, int position) {
        ViewHodel viewHodel=holder;
        viewHodel.tv.setText(recent.get(position).getTitle());
        String url = recent.get(position).getThumbnail();
        Glide.with(context).load(url).into(viewHodel.iv);
    }

    @Override
    public int getItemCount() {
        return recent.size();
    }

    public class ViewHodel extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tv;
        public ViewHodel(View itemView) {
            super(itemView);
            iv=itemView.findViewById(R.id.iv);
            tv=itemView.findViewById(R.id.tv);

        }
    }
}
