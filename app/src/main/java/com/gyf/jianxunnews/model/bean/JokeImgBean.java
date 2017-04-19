package com.gyf.jianxunnews.model.bean;

import org.greenrobot.greendao.annotation.Entity;

import java.util.List;

/**
 * Created by geyifeng on 2017/4/1.
 */

public class JokeImgBean implements IJokeBean{

    /**
     * showapi_res_code : 0
     * showapi_res_error :
     * showapi_res_body : {"allPages":657,"ret_code":0,"contentlist":[{"id":"58de38e56e3600471c4821e2","title":"要是不救一下，我也许还能活！","img":"http://sc1.hao123img.com/data/8a0d982d84eafcc87316da15e5d72d9f_0","type":2,"ct":"2017-03-31 19:09:25.522"},{"id":"58de301a6e3600471c47f8c3","title":"曾经的我你看不起，现在的我~~~","img":"http://sc3.hao123img.com/data/8bcb6de4812ec3ee1c12f3b0cd0a59d9_0","type":2,"ct":"2017-03-31 18:31:54.343"},{"id":"58de1e036e3600471c47c220","title":"这身材还有什么好说的了","img":"http://sc4.hao123img.com/data/75147218b0cb4d80fb57af0d9d51b47e_0","type":2,"ct":"2017-03-31 17:14:43.969"},{"id":"58db70df6e3600471c3d796b","title":"这是一张充满味道的图","img":"http://sc0.hao123img.com/data/e4dc340249a34e808f44bf60301265fd_0","type":2,"ct":"2017-03-29 16:31:27.032"},{"id":"58db62c56e3600471c3d3c2c","title":"这剧组到底是有多穷？","img":"http://sc4.hao123img.com/data/8ee75b5ceda356cebd6f3397ffb1b629_0","type":2,"ct":"2017-03-29 15:31:17.681"},{"id":"58db62c26e3600471c3d3c24","title":"那些说身材重要的都看看吧！","img":"http://sc2.hao123img.com/data/427b8ad3a69e27628c2374e179d6fbec_430","type":2,"ct":"2017-03-29 15:31:14.193"},{"id":"58db62bf6e3600471c3d3c1a","title":"蓝衣服大哥，你是有多想赢啊","img":"http://sc4.hao123img.com/data/23db2b3c6cb5701b81806f138bc97710_0","type":2,"ct":"2017-03-29 15:31:11.949"},{"id":"58d9fdcf6e3600471c37fa20","title":"这婚咱还能好好结么","img":"http://sc2.hao123img.com/data/f447fa82ec37c4d64981179ce0006fc9_0","type":2,"ct":"2017-03-28 14:08:15.107"},{"id":"58d9f5e76e3600471c37d47b","title":"穿这个上街也是没sei了~","img":"http://sc3.hao123img.com/data/817616ae15110baecd0b9d498be153d4_0","type":2,"ct":"2017-03-28 13:34:31.987"},{"id":"58d9efa56e3600471c37beda","title":"我不会告诉你，穿帮在右下角","img":"http://sc1.hao123img.com/data/480728cce614b476ff62f77fd9a1c5ee_0","type":2,"ct":"2017-03-28 13:07:49.317"},{"id":"58d9efa56e3600471c37bed9","title":"这小子，前途不可限量啊！","img":"http://sc4.hao123img.com/data/2320b096982cf717946856f21fe61df7_0","type":2,"ct":"2017-03-28 13:07:49.309"},{"id":"58d3b2876e3600471c214bb1","title":"这样的婚礼还是头一次见","img":"http://sc4.hao123img.com/data/8b539e3f4471a3010a870f70f1b67cbc_0","type":2,"ct":"2017-03-23 19:33:27.067"},{"id":"58d3ace66e3600471c213fe9","title":"骚年你也太敢玩儿了吧","img":"http://sc1.hao123img.com/data/68c45571326c8ddc856d226b1be1d972_0","type":2,"ct":"2017-03-23 19:09:26.728"},{"id":"58d3ace66e3600471c213fe8","title":"女神一到家就露出原形了！","img":"http://sc0.hao123img.com/data/cca75b2762152284430494d3a0c69409_0","type":2,"ct":"2017-03-23 19:09:26.716"},{"id":"58d2773b6e3600471c1d0e8c","title":"美女这身裙子太有内涵了","img":"http://sc2.hao123img.com/data/704225c6cff93c65c952d0ead8e65b26_0","type":2,"ct":"2017-03-22 21:08:11.028"},{"id":"58d269166e3600471c1ce476","title":"姑娘身后总有亮点","img":"http://sc0.hao123img.com/data/8c4ad575ab9d49bfd0498eafdbb7ece6_0","type":2,"ct":"2017-03-22 20:07:50.223"},{"id":"58d260ac6e3644eae802e16b","title":"一看就是有自信的妹子","img":"http://sc1.hao123img.com/data/5cf1490bd7fdf722ecd8e77712deeebb_430","type":2,"ct":"2017-03-22 19:31:56.696"},{"id":"58d25b3d6e3644eae802d33a","title":"据说这姿势很内涵，大神求解","img":"http://sc3.hao123img.com/data/645d32c2c915551402c0c825066f0c4c_0","type":2,"ct":"2017-03-22 19:08:45.628"},{"id":"58d25b3d6e3644eae802d339","title":"女汉子都是这样的吗","img":"http://sc2.hao123img.com/data/9886b4f52b3efcc8a49ba3a1ebfeef0c_430","type":2,"ct":"2017-03-22 19:08:45.601"},{"id":"58d2526e6e3644eae802ad5d","title":"妹子的衣服很内涵啊","img":"http://sc2.hao123img.com/data/3c3a517fb7fd895e6ff2c3634417e0b2_0","type":2,"ct":"2017-03-22 18:31:10.094"}],"currentPage":1,"allNum":13136,"maxResult":20}
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
         * allPages : 657
         * ret_code : 0
         * contentlist : [{"id":"58de38e56e3600471c4821e2","title":"要是不救一下，我也许还能活！","img":"http://sc1.hao123img.com/data/8a0d982d84eafcc87316da15e5d72d9f_0","type":2,"ct":"2017-03-31 19:09:25.522"},{"id":"58de301a6e3600471c47f8c3","title":"曾经的我你看不起，现在的我~~~","img":"http://sc3.hao123img.com/data/8bcb6de4812ec3ee1c12f3b0cd0a59d9_0","type":2,"ct":"2017-03-31 18:31:54.343"},{"id":"58de1e036e3600471c47c220","title":"这身材还有什么好说的了","img":"http://sc4.hao123img.com/data/75147218b0cb4d80fb57af0d9d51b47e_0","type":2,"ct":"2017-03-31 17:14:43.969"},{"id":"58db70df6e3600471c3d796b","title":"这是一张充满味道的图","img":"http://sc0.hao123img.com/data/e4dc340249a34e808f44bf60301265fd_0","type":2,"ct":"2017-03-29 16:31:27.032"},{"id":"58db62c56e3600471c3d3c2c","title":"这剧组到底是有多穷？","img":"http://sc4.hao123img.com/data/8ee75b5ceda356cebd6f3397ffb1b629_0","type":2,"ct":"2017-03-29 15:31:17.681"},{"id":"58db62c26e3600471c3d3c24","title":"那些说身材重要的都看看吧！","img":"http://sc2.hao123img.com/data/427b8ad3a69e27628c2374e179d6fbec_430","type":2,"ct":"2017-03-29 15:31:14.193"},{"id":"58db62bf6e3600471c3d3c1a","title":"蓝衣服大哥，你是有多想赢啊","img":"http://sc4.hao123img.com/data/23db2b3c6cb5701b81806f138bc97710_0","type":2,"ct":"2017-03-29 15:31:11.949"},{"id":"58d9fdcf6e3600471c37fa20","title":"这婚咱还能好好结么","img":"http://sc2.hao123img.com/data/f447fa82ec37c4d64981179ce0006fc9_0","type":2,"ct":"2017-03-28 14:08:15.107"},{"id":"58d9f5e76e3600471c37d47b","title":"穿这个上街也是没sei了~","img":"http://sc3.hao123img.com/data/817616ae15110baecd0b9d498be153d4_0","type":2,"ct":"2017-03-28 13:34:31.987"},{"id":"58d9efa56e3600471c37beda","title":"我不会告诉你，穿帮在右下角","img":"http://sc1.hao123img.com/data/480728cce614b476ff62f77fd9a1c5ee_0","type":2,"ct":"2017-03-28 13:07:49.317"},{"id":"58d9efa56e3600471c37bed9","title":"这小子，前途不可限量啊！","img":"http://sc4.hao123img.com/data/2320b096982cf717946856f21fe61df7_0","type":2,"ct":"2017-03-28 13:07:49.309"},{"id":"58d3b2876e3600471c214bb1","title":"这样的婚礼还是头一次见","img":"http://sc4.hao123img.com/data/8b539e3f4471a3010a870f70f1b67cbc_0","type":2,"ct":"2017-03-23 19:33:27.067"},{"id":"58d3ace66e3600471c213fe9","title":"骚年你也太敢玩儿了吧","img":"http://sc1.hao123img.com/data/68c45571326c8ddc856d226b1be1d972_0","type":2,"ct":"2017-03-23 19:09:26.728"},{"id":"58d3ace66e3600471c213fe8","title":"女神一到家就露出原形了！","img":"http://sc0.hao123img.com/data/cca75b2762152284430494d3a0c69409_0","type":2,"ct":"2017-03-23 19:09:26.716"},{"id":"58d2773b6e3600471c1d0e8c","title":"美女这身裙子太有内涵了","img":"http://sc2.hao123img.com/data/704225c6cff93c65c952d0ead8e65b26_0","type":2,"ct":"2017-03-22 21:08:11.028"},{"id":"58d269166e3600471c1ce476","title":"姑娘身后总有亮点","img":"http://sc0.hao123img.com/data/8c4ad575ab9d49bfd0498eafdbb7ece6_0","type":2,"ct":"2017-03-22 20:07:50.223"},{"id":"58d260ac6e3644eae802e16b","title":"一看就是有自信的妹子","img":"http://sc1.hao123img.com/data/5cf1490bd7fdf722ecd8e77712deeebb_430","type":2,"ct":"2017-03-22 19:31:56.696"},{"id":"58d25b3d6e3644eae802d33a","title":"据说这姿势很内涵，大神求解","img":"http://sc3.hao123img.com/data/645d32c2c915551402c0c825066f0c4c_0","type":2,"ct":"2017-03-22 19:08:45.628"},{"id":"58d25b3d6e3644eae802d339","title":"女汉子都是这样的吗","img":"http://sc2.hao123img.com/data/9886b4f52b3efcc8a49ba3a1ebfeef0c_430","type":2,"ct":"2017-03-22 19:08:45.601"},{"id":"58d2526e6e3644eae802ad5d","title":"妹子的衣服很内涵啊","img":"http://sc2.hao123img.com/data/3c3a517fb7fd895e6ff2c3634417e0b2_0","type":2,"ct":"2017-03-22 18:31:10.094"}]
         * currentPage : 1
         * allNum : 13136
         * maxResult : 20
         */

        private int allPages;
        private int ret_code;
        private int currentPage;
        private int allNum;
        private int maxResult;
        private List<ContentlistBean> contentlist;

        public int getAllPages() {
            return allPages;
        }

        public void setAllPages(int allPages) {
            this.allPages = allPages;
        }

        public int getRet_code() {
            return ret_code;
        }

        public void setRet_code(int ret_code) {
            this.ret_code = ret_code;
        }

        public int getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(int currentPage) {
            this.currentPage = currentPage;
        }

        public int getAllNum() {
            return allNum;
        }

        public void setAllNum(int allNum) {
            this.allNum = allNum;
        }

        public int getMaxResult() {
            return maxResult;
        }

        public void setMaxResult(int maxResult) {
            this.maxResult = maxResult;
        }

        public List<ContentlistBean> getContentlist() {
            return contentlist;
        }

        public void setContentlist(List<ContentlistBean> contentlist) {
            this.contentlist = contentlist;
        }

        public static class ContentlistBean {
            /**
             * id : 58de38e56e3600471c4821e2
             * title : 要是不救一下，我也许还能活！
             * img : http://sc1.hao123img.com/data/8a0d982d84eafcc87316da15e5d72d9f_0
             * type : 2
             * ct : 2017-03-31 19:09:25.522
             */

            private String id;
            private String title;
            private String img;
            private int type;
            private String ct;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getCt() {
                return ct;
            }

            public void setCt(String ct) {
                this.ct = ct;
            }
        }
    }
}
