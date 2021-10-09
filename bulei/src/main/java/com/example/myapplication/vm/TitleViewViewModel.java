package com.example.myapplication.vm;

import com.example.myapplication.bean.News;
import com.lib.base.viewmodel.BaseViewModel;

/**
 * @author :huangguofeng
 * date    :2021/2/28
 * package :com.example.myapplication.vm
 * desc    :
 */
public class TitleViewViewModel extends BaseViewModel {
    public News.ResultBean.DataBean dataBean;

    public void setDataBean(News.ResultBean.DataBean dataBean) {
        this.dataBean = dataBean;
    }


    public News.ResultBean.DataBean getDataBean() {
        return dataBean;
    }
}
