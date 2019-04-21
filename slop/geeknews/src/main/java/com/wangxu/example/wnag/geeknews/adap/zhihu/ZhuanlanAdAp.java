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
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.wangxu.example.wnag.geeknews.R;
import com.wangxu.example.wnag.geeknews.bean.ZhuanlanBean;

import java.util.List;

public class ZhuanlanAdAp extends RecyclerView.Adapter<ZhuanlanAdAp.ViewHodel> {
    Context context;
    List<ZhuanlanBean.DataBean> data;

    public ZhuanlanAdAp(Context context, List<ZhuanlanBean.DataBean> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_reczhuanlanglide, null);
        ViewHodel viewHodel = new ViewHodel(view);

        return viewHodel;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodel holder, int position) {
        ViewHodel viewHodel = holder;
        ZhuanlanBean.DataBean bean = data.get(position);
        viewHodel.tv1.setText(bean.getName());
        viewHodel.tv2.setText(bean.getDescription());
        Glide.with(context)
                .load(bean.getThumbnail())
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(20)))
                .into(viewHodel.iv);

//        viewHodel.iv.setBackground(data.get(position).getThumbnail());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHodel extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tv1;
        TextView tv2;

        public ViewHodel(View itemView) {
            super(itemView);

            iv = itemView.findViewById(R.id.iv);
            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);
        }
    }
}
