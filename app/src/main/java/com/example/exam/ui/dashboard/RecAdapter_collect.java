package com.example.exam.ui.dashboard;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.exam.R;
import com.example.exam.bean.BaseApp;
import com.example.exam.bean.DataBean;
import com.example.exam.bean.Event2;
import com.example.xts.greendaodemo.db.DataBeanDao;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

public class RecAdapter_collect extends RecyclerView.Adapter<RecAdapter_collect.Vh> {
    private List<DataBean> list;
    private Context con;
    private DataBeanDao beanDao;

    public RecAdapter_collect(List<DataBean> resultsBeans, Context con) {
        this.list = resultsBeans;
        this.con = con;
    }

    public void setList(List<DataBean> list) {
        this.list = list;
    }
    public void delect(){
        if (beanDao == null)
        beanDao = BaseApp.getInstance().getDaoSession().getDataBeanDao();
        for (int i = 0; i < list.size(); i++) {
            boolean flag = list.get(i).getIsok();
            if (flag){
                list.get(i).setIsok(false);
                beanDao.update( list.get(i));
                beanDao.delete(list.get(i));
                list.remove(list.get(i));
                i--;
            }
        }
        notifyDataSetChanged();
    }

    @Override
    public Vh onCreateViewHolder( ViewGroup viewGroup, int i) {
        View view = View.inflate(con, R.layout.layout_item2, null);
        return new Vh(view);
    }

    public void selectAll(boolean b){
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setIsok(b);
        }
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder( Vh vh, final int i) {
        Glide.with(con).load(list.get(i).getScene_pic_url()).into(vh.img);

        vh.cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                list.get(i).setIsok(b);
                Event2 event2 = new Event2(b);
                EventBus.getDefault().post(event2);
            }
        });

        vh.cb.setChecked(list.get(i).getIsok());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Vh extends RecyclerView.ViewHolder {
        ImageView img;
        CheckBox cb;
        public Vh( View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img_collect);
            cb = itemView.findViewById(R.id.cb);
        }
    }
}
