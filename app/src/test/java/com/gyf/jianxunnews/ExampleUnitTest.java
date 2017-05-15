package com.gyf.jianxunnews;

import com.gyf.jianxunnews.mvp.model.NewsModel;
import com.gyf.jianxunnews.mvp.model.TodayModel;
import com.gyf.jianxunnews.mvp.model.bean.NewsBean;
import com.gyf.jianxunnews.mvp.model.bean.TodayBean;
import com.gyf.jianxunnews.mvp.model.listener.OnLoadListener;
import com.gyf.jianxunnews.mvp.presenter.NewsPresenter;
import com.gyf.jianxunnews.mvp.presenter.TodayPresenter;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest{
    @Test
    public void addition_isCorrect() throws Exception {
        //assertEquals(4, 2 + 2);
        int i = 0;
        i++;
        ++i;
        System.out.println(i);
    }
    @Test
    public void io(){
        new NewsPresenter().load("体育","1");
//        Map<String, String> map = new HashMap<>();
//        map.put("channel", "头条");
//        map.put("num", "20");
//        map.put("start", "0");
//        new NewsModel().load(map, new OnLoadListener<NewsBean>() {
//            @Override
//            public void onSuccess(NewsBean data) {
//                System.out.println(data.getResult().getList().get(0).getTitle());
//            }
//
//            @Override
//            public void onFail(Throwable e) {
//
//            }
//        });
    }
}