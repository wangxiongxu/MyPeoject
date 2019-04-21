package com.wangxu.example.wnag.geeknews.adap.vtex;

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
import com.wangxu.example.wnag.geeknews.bean.FramhtmlBean;

import java.util.List;

public class VtexFramadap extends RecyclerView.Adapter<VtexFramadap.Viewhodel> {
    List<FramhtmlBean> list;
    Context context;

    public VtexFramadap(List<FramhtmlBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Viewhodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_vtexrecfrag, null);
        Viewhodel viewhodel = new Viewhodel(inflate);
        return viewhodel;
    }

    @Override
    public void onBindViewHolder(@NonNull Viewhodel holder, int position) {
        Viewhodel viewhodel=holder;
        viewhodel.tv1.setText(list.get(position).getTitle());
        viewhodel.tv2.setText(list.get(position).getXinXi());
        viewhodel.tv3.setText(list.get(position).getPingLun());
        Glide.with(context).load("https:"+list.get(position).getTuPianurl()).into(viewhodel.iv);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Viewhodel extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tv1;
        TextView tv2;
        TextView tv3;
        public Viewhodel(View itemView) {
            super(itemView);
            iv=itemView.findViewById(R.id.iv);
            tv1=itemView.findViewById(R.id.tv1);
            tv2=itemView.findViewById(R.id.tv2);
            tv3=itemView.findViewById(R.id.tv3);
        }
    }
}
