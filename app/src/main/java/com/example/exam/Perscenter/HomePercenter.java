package com.example.exam.Perscenter;

import com.example.exam.apis.HomeApi;
import com.example.exam.bean.ShouYeBean;
import com.example.exam.https.ResultCallback;
import com.example.exam.modle.HomeM;

public class HomePercenter{

    private final HomeApi.View view;
    private final HomeM homeM;

    public HomePercenter(HomeApi.View view) {
        this.view = view;
        homeM = new HomeM();
    }

    public void getData() {
        homeM.getData(new ResultCallback() {
            @Override
            public void ok(ShouYeBean shouYeBean) {
                view.HomeDataReturn(shouYeBean);
            }

            @Override
            public void no(String s) {
                view.showErroe(s);
            }
        });
    }


}
