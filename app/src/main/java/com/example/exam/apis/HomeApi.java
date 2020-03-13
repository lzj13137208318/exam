package com.example.exam.apis;

import com.example.exam.bean.ShouYeBean;

public interface HomeApi {
    interface View {
        void HomeDataReturn(ShouYeBean shouYeBean);

        void showErroe(String s);
    }
    interface Percenter{
        void getHomeData(int page , int size);
    }
}
