package com.example.exam.ui.home;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.exam.R;
import com.example.exam.bean.BaseApp;
import com.example.exam.bean.DataBean;
import com.example.xts.greendaodemo.db.DataBeanDao;

import java.util.List;


public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.Vh> {

    private final List<DataBean> list;
    private final Context context;
    private DataBeanDao beanDao;


    public HomeAdapter(List<DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Vh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.item_special, null);
        return new Vh(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull final Vh holder, final int position) {

        if (beanDao == null)
            beanDao = BaseApp.getInstance().getDaoSession().getDataBeanDao();

        holder.title.setText(list.get(position).getTitle()+"<font color=\"#FF0000\"> &yen;"+list.get(position).getPrice_info()+"元起</font>");
        holder.desc.setText(list.get(position).getSubtitle());
        Glide.with(context).load(list.get(position).getScene_pic_url()).into(holder.img);
        final DataBean topicListBean = list.get(position);
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.btn.getText().toString().equals("收藏")){
                    holder.btn.setText("已收藏");
                    topicListBean.setIsok(true);
                }else {
                    holder.btn.setText("收藏");
                    topicListBean.setIsok(false);

                }
                beanDao.insertOrReplace(list.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Vh extends RecyclerView.ViewHolder {

        private final ImageView img;
        private final TextView title;
        private final TextView desc;
        private final Button btn;

        public Vh(@NonNull View itemView) {
            super(itemView);

            img = (ImageView) itemView.findViewById(R.id.iv_item_special_img);
            title = (TextView) itemView.findViewById(R.id.tv_item_special_title);
            desc = (TextView) itemView.findViewById(R.id.tv_item_special_desc);
            btn = (Button) itemView.findViewById(R.id.btn);
        }

    }
}
