package com.gyf.jianxunnews.mvp.model.bean;

import java.util.List;

/**
 * Created by geyifeng on 2017/5/3.
 */

public class NewsStatusBean {

    private String status;
    private String msg;
    private NewsResultBean result;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public NewsResultBean getResult() {
        return result;
    }

    public void setResult(NewsResultBean result) {
        this.result = result;
    }

    public class NewsResultBean {

        private String channel;
        private String num;
        private List<NewsBean> list;

        public String getChannel() {
            return channel;
        }

        public void setChannel(String channel) {
            this.channel = channel;
        }

        public String getNum() {
            return num;
        }

        public void setNum(String num) {
            this.num = num;
        }

        public List<NewsBean> getList() {
            return list;
        }

        public void setList(List<NewsBean> list) {
            this.list = list;
        }

    }
}
