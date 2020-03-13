package com.example.exam.https;

import com.example.exam.bean.ShouYeBean;

public interface ResultCallback {
    void ok(ShouYeBean shouYeBean);
    void no(String s);
}
