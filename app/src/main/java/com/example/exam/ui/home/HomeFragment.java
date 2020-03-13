package com.example.exam.ui.home;


import android.os.Bundle;
import android.util.EventLog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exam.Perscenter.HomePercenter;
import com.example.exam.R;
import com.example.exam.apis.HomeApi;
import com.example.exam.bean.DataBean;
import com.example.exam.bean.ShouYeBean;


import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements HomeApi.View {

    private HomePercenter homePercenter;
    private List<DataBean> list;
    private HomeAdapter homeAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View inflate = inflater.inflate(R.layout.fragment_home, null);
        initView(inflate);
        homePercenter = new HomePercenter(this);
        initData();
        return inflate;
    }


    private void initData() {
        homePercenter.getData();
    }

    private void initView(View inflate) {
        RecyclerView rec = inflate.findViewById(R.id.rec_home);
        rec.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        homeAdapter = new HomeAdapter(list, getContext());
        rec.setAdapter(homeAdapter);
    }

    @Override
    public void HomeDataReturn(ShouYeBean shouYeBean) {
        List<DataBean> data = shouYeBean.getData().getData();
        list.addAll(data);
        homeAdapter.notifyDataSetChanged();
    }

    @Override
    public void showErroe(String s) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }
}