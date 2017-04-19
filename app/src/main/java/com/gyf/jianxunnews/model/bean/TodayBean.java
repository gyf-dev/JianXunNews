package com.gyf.jianxunnews.model.bean;

import java.util.List;

/**
 * Created by geyifeng on 2017/4/10.
 */

public class TodayBean {

    /**
     * showapi_res_code : 0
     * showapi_res_error :
     * showapi_res_body : {"ret_code":0,"list":[{"title":"世界卫生组织宣布已经成功控制SARS","month":7,"img":"http://img.lssdjt.com/201107/5/099368663.jpg","year":"2003","day":5},{"title":"苏哈托起诉《时代》周刊","month":7,"img":"http://img.lssdjt.com/200407/5/88232314461.jpg","year":"1999","day":5},{"title":"香港启德机场正式关闭","month":7,"img":"http://img.lssdjt.com/200905/17/1C18735304.jpg","year":"1998","day":5},{"title":"全国金融工作会议在京召开","month":7,"year":"1993","day":5},{"title":"张艺谋一人捧走百花奖和金鸡奖最佳男主角","month":7,"img":"http://img.lssdjt.com/200905/17/E3181117916.jpg","year":"1988","day":5},{"title":"国家行政学院建立","month":7,"year":"1988","day":5},{"title":"第一届友好运动会在莫斯科举行","month":7,"year":"1986","day":5},{"title":"巴基斯坦发生军事政变，总理布托被捕内幕","month":7,"img":"http://img.lssdjt.com/200905/17/BC181332837.jpg","year":"1977","day":5},{"title":"中国首次远洋科学调查","month":7,"img":"http://img.lssdjt.com/201107/4/9B225917411.jpg","year":"1976","day":5},{"title":"中共代表团抵达莫斯科","month":7,"img":"http://img.lssdjt.com/201107/5/F693239857.jpg","year":"1963","day":5},{"title":"马寅初发表\u201c新人口论\u201d遭厄运","month":7,"img":"http://img.lssdjt.com/201107/5/A493358983.jpg","year":"1957","day":5},{"title":"世界上第一件比基尼泳装面世","month":7,"img":"http://img.lssdjt.com/201107/4/7A225557718.gif","year":"1946","day":5},{"title":"王稼祥首次提出\u201c毛泽东思想\u201d","month":7,"img":"http://img.lssdjt.com/201108/20/8221193197.jpg","year":"1943","day":5},{"title":"库尔斯克战役爆发","month":7,"img":"http://img.lssdjt.com/201108/20/C6211919785.jpg","year":"1943","day":5},{"title":"周恩来在联共会议上作报告","month":7,"year":"1930","day":5},{"title":"孙殿英盗掘东陵","month":7,"img":"http://img.lssdjt.com/200407/5/6B23220300.jpg","year":"1928","day":5},{"title":"中华民国军政府组成","month":7,"year":"1918","day":5},{"title":"光绪帝下谕奖励新学人材","month":7,"year":"1898","day":5},{"title":"《上海英法美租地章程》公布","month":7,"year":"1854","day":5},{"title":"法国占领阿尔及利亚","month":7,"year":"1830","day":5},{"title":"委内瑞拉独立","month":7,"year":"1811","day":5}]}
     */

    private int showapi_res_code;
    private String showapi_res_error;
    private ShowapiResBodyBean showapi_res_body;

    public int getShowapi_res_code() {
        return showapi_res_code;
    }

    public void setShowapi_res_code(int showapi_res_code) {
        this.showapi_res_code = showapi_res_code;
    }

    public String getShowapi_res_error() {
        return showapi_res_error;
    }

    public void setShowapi_res_error(String showapi_res_error) {
        this.showapi_res_error = showapi_res_error;
    }

    public ShowapiResBodyBean getShowapi_res_body() {
        return showapi_res_body;
    }

    public void setShowapi_res_body(ShowapiResBodyBean showapi_res_body) {
        this.showapi_res_body = showapi_res_body;
    }

    public static class ShowapiResBodyBean {
        /**
         * ret_code : 0
         * list : [{"title":"世界卫生组织宣布已经成功控制SARS","month":7,"img":"http://img.lssdjt.com/201107/5/099368663.jpg","year":"2003","day":5},{"title":"苏哈托起诉《时代》周刊","month":7,"img":"http://img.lssdjt.com/200407/5/88232314461.jpg","year":"1999","day":5},{"title":"香港启德机场正式关闭","month":7,"img":"http://img.lssdjt.com/200905/17/1C18735304.jpg","year":"1998","day":5},{"title":"全国金融工作会议在京召开","month":7,"year":"1993","day":5},{"title":"张艺谋一人捧走百花奖和金鸡奖最佳男主角","month":7,"img":"http://img.lssdjt.com/200905/17/E3181117916.jpg","year":"1988","day":5},{"title":"国家行政学院建立","month":7,"year":"1988","day":5},{"title":"第一届友好运动会在莫斯科举行","month":7,"year":"1986","day":5},{"title":"巴基斯坦发生军事政变，总理布托被捕内幕","month":7,"img":"http://img.lssdjt.com/200905/17/BC181332837.jpg","year":"1977","day":5},{"title":"中国首次远洋科学调查","month":7,"img":"http://img.lssdjt.com/201107/4/9B225917411.jpg","year":"1976","day":5},{"title":"中共代表团抵达莫斯科","month":7,"img":"http://img.lssdjt.com/201107/5/F693239857.jpg","year":"1963","day":5},{"title":"马寅初发表\u201c新人口论\u201d遭厄运","month":7,"img":"http://img.lssdjt.com/201107/5/A493358983.jpg","year":"1957","day":5},{"title":"世界上第一件比基尼泳装面世","month":7,"img":"http://img.lssdjt.com/201107/4/7A225557718.gif","year":"1946","day":5},{"title":"王稼祥首次提出\u201c毛泽东思想\u201d","month":7,"img":"http://img.lssdjt.com/201108/20/8221193197.jpg","year":"1943","day":5},{"title":"库尔斯克战役爆发","month":7,"img":"http://img.lssdjt.com/201108/20/C6211919785.jpg","year":"1943","day":5},{"title":"周恩来在联共会议上作报告","month":7,"year":"1930","day":5},{"title":"孙殿英盗掘东陵","month":7,"img":"http://img.lssdjt.com/200407/5/6B23220300.jpg","year":"1928","day":5},{"title":"中华民国军政府组成","month":7,"year":"1918","day":5},{"title":"光绪帝下谕奖励新学人材","month":7,"year":"1898","day":5},{"title":"《上海英法美租地章程》公布","month":7,"year":"1854","day":5},{"title":"法国占领阿尔及利亚","month":7,"year":"1830","day":5},{"title":"委内瑞拉独立","month":7,"year":"1811","day":5}]
         */

        private int ret_code;
        private List<ListBean> list;

        public int getRet_code() {
            return ret_code;
        }

        public void setRet_code(int ret_code) {
            this.ret_code = ret_code;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * title : 世界卫生组织宣布已经成功控制SARS
             * month : 7
             * img : http://img.lssdjt.com/201107/5/099368663.jpg
             * year : 2003
             * day : 5
             */

            private String title;
            private int month;
            private String img;
            private String year;
            private int day;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getMonth() {
                return month;
            }

            public void setMonth(int month) {
                this.month = month;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getYear() {
                return year;
            }

            public void setYear(String year) {
                this.year = year;
            }

            public int getDay() {
                return day;
            }

            public void setDay(int day) {
                this.day = day;
            }
        }
    }
}
