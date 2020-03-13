package com.example.exam.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exam.R;
import com.example.exam.bean.BaseApp;
import com.example.exam.bean.DataBean;
import com.example.exam.bean.Event2;
import com.example.xts.greendaodemo.db.DataBeanDao;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

public class DashboardFragment extends Fragment implements View.OnClickListener {
    private View view;
    private RecyclerView mRecCollect;
    private CheckBox mCbCollect;
    /**
     * 0/10
     */
    private TextView mTvNum;
    /**
     * 删除
     */
    private Button mBtnDelete;
    private RecAdapter_collect adapter;
    /**
     * 全选
     */
    private TextView mTvAll;
    private List<DataBean> list;
    private DataBeanDao beanDao;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_collect, null);
        if (!EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().register(this);
        }
        initView(view);
        beanDao = BaseApp.getInstance().getDaoSession().getDataBeanDao();
        return view;
    }

    @Subscribe
    public void setqqq(Event2 event2){
        setNum();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden==false) {
            setNum();
            adapter = new RecAdapter_collect(list, getActivity());
            mRecCollect.setAdapter(adapter);
            adapter.notifyDataSetChanged();

        }else {
            mCbCollect.setChecked(false);
        }
    }

    private void setNum() {
        int num = 0;
        list = beanDao.loadAll();
        if (list.size() == 0)
            mTvNum.setText(0 + "/" + 0);

        for (int i = 0; i < list.size(); i++) {
            boolean flag = list.get(i).getIsok();
            if (flag) {
                num++;
            }
        }
        mTvNum.setText(num + "/" + list.size());

        if (num<list.size()){
            mTvAll.setText("全选");
            mCbCollect.setChecked(false);
        }
        if (num != 0 && list.size() != 0 && num==list.size()){
            mTvAll.setText("取消");
            mCbCollect.setChecked(true);
        }
    }

    private void initView(View view) {
        mTvAll = (TextView) view.findViewById(R.id.tv_all);
        mRecCollect = (RecyclerView) view.findViewById(R.id.rec_collect);
        mRecCollect.setLayoutManager(new LinearLayoutManager(getActivity()));
        mCbCollect = (CheckBox) view.findViewById(R.id.cb_collect);
        mTvNum = (TextView) view.findViewById(R.id.tv_num);
        mBtnDelete = (Button) view.findViewById(R.id.btn_delete);
        mBtnDelete.setOnClickListener(this);


        mCbCollect.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isPressed())
                    adapter.selectAll(b);

                if (b) {
                    mTvAll.setText("取消");

                } else {
                    mTvAll.setText("全选");
                }
                setNum();
            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn_delete:
                adapter.delect();
                mTvAll.setText("全选");
                mCbCollect.setChecked(false);
                setNum();
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}