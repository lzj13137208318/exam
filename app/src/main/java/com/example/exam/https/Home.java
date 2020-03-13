package com.example.exam.https;

import com.example.exam.bean.ShouYeBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Home {
    public static String url = "https://cdwan.cn/api/";
    @GET("topic/list")
    Observable<ShouYeBean> getHomeBean();
}
