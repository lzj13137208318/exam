package com.example.exam.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class DataBean {
            /**
             * id : 314
             * title : 关爱他成长的每一个足迹
             * price_info : 0
             * scene_pic_url : https://yanxuan.nosdn.127.net/14943267735961674.jpg
             * subtitle : 专业运动品牌同厂，毛毛虫鞋买二送一
             */

            private int id;
            @Id
            private String title;
            private float price_info;
            private String scene_pic_url;
            private String subtitle;
            private boolean isok;
            @Generated(hash = 275608542)
            public DataBean(int id, String title, float price_info, String scene_pic_url,
                    String subtitle, boolean isok) {
                this.id = id;
                this.title = title;
                this.price_info = price_info;
                this.scene_pic_url = scene_pic_url;
                this.subtitle = subtitle;
                this.isok = isok;
            }
            @Generated(hash = 908697775)
            public DataBean() {
            }
            public int getId() {
                return this.id;
            }
            public void setId(int id) {
                this.id = id;
            }
            public String getTitle() {
                return this.title;
            }
            public void setTitle(String title) {
                this.title = title;
            }
            public float getPrice_info() {
                return this.price_info;
            }
            public void setPrice_info(float price_info) {
                this.price_info = price_info;
            }
            public String getScene_pic_url() {
                return this.scene_pic_url;
            }
            public void setScene_pic_url(String scene_pic_url) {
                this.scene_pic_url = scene_pic_url;
            }
            public String getSubtitle() {
                return this.subtitle;
            }
            public void setSubtitle(String subtitle) {
                this.subtitle = subtitle;
            }
            public boolean getIsok() {
                return this.isok;
            }
            public void setIsok(boolean isok) {
                this.isok = isok;
            }

        
        }