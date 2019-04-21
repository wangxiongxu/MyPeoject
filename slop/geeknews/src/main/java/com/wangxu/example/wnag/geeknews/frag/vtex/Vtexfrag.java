package com.wangxu.example.wnag.geeknews.frag.vtex;

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
import com.wangxu.example.wnag.geeknews.adap.vtex.VtexFramadap;
import com.wangxu.example.wnag.geeknews.bean.FramhtmlBean;

import java.io.Serializable;
import java.util.List;

public class Vtexfrag extends Fragment {
    private View view;
    private RecyclerView mRec;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.layout_vtexchilfrag, null);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        mRec = (RecyclerView) inflate.findViewById(R.id.rec);
        mRec.setLayoutManager(new LinearLayoutManager(getContext()));
        Bundle arguments = getArguments();
        List<FramhtmlBean> list = (List<FramhtmlBean>) arguments.getSerializable("1");
        VtexFramadap vtexFramadap = new VtexFramadap(list, getContext());
        mRec.setAdapter(vtexFramadap);
    }
}
