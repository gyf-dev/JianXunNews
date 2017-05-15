package com.gyf.jianxunnews.mvp.model.bean;

/**
 * 阿里api bean基类
 * Created by geyifeng on 2017/4/26.
 */

public class AliBean<T> {

    public int showapi_res_code;
    public String showapi_res_error;
    public T showapi_res_body;

}
