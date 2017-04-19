package com.gyf.jianxunnews;

import com.gyf.jianxunnews.model.JokeModel;
import com.gyf.jianxunnews.model.bean.IJokeBean;
import com.gyf.jianxunnews.model.listener.OnLoadJokeListListener;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest{
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void io(){
        Map<String, String> map = new HashMap<>();
        map.put("maxResult", "20");
        map.put("page", "1");
        map.put("time", "2016-07-01");
        JokeModel jokeModel = new JokeModel();
        jokeModel.loadTextJoke(map, new OnLoadJokeListListener() {
            @Override
            public void onSuccess(IJokeBean jokeBean) {

            }

            @Override
            public void onFail(Throwable e) {

            }
        });
    }
}