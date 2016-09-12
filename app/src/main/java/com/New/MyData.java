package com.New;

import java.util.List;

/**
 * Created by Administrator on 16-9-3.
 */
public class MyData {


    /**
     * title : 更均衡的一个5 佳能EOS 5D Mark IV评测
     * pic_url : http://img2.fengniao.com/product/157_580x280/809/ceD31rNJV2Qs6.jpg
     * date : 2016-09-03 03:01:46
     * doc_url : http://api.fengniao.com/app_ipad/news_doc.php?docid=5338515&isPad=1
     * doc_id : 5338515
     * web_url : http://qicai.fengniao.com/533/5338515.html
     * comment_page_num : 0
     * comments_num : 0
     * more_comment_url : http://api.fengniao.com/app_ipad/news_doc_comments.php?docid=5338515&isPad=1
     */

    private Bean3Bean Bean3;
    /**
     * totalpage : 855
     */

    private TotalpageBean totalpage;
    /**
     * title : 强大视频功能 松下三款数码相机或将发布
     * pic_url : http://img2.fengniao.com/product/157_160x120/477/ce8IojP6TRNvg.jpg
     * date : 2016-09-02 06:00:00
     * author : 房时宇
     * doc_url : http://api.fengniao.com/app_ipad/news_doc.php?docid=5338525&isPad=1
     * doc_id : 5338525
     * web_url : http://qicai.fengniao.com/533/5338525.html
     * comment_page_num : 0
     * comments_num : 0
     * more_comment_url : http://api.fengniao.com/app_ipad/news_doc_comments.php?docid=5338525&isPad=1
     */

    private List<BeanBean> Bean;
    /**
     * title : 蜂鸟网延伸摄影＋ 开启宠物狂欢趴
     * pic_url : http://img2.fengniao.com/product/157_280x280/657/ceF0F6DTZZVU.jpg
     * date : 2016-09-02 12:32:16
     * doc_url : http://api.fengniao.com/app_ipad/news_doc.php?docid=5338542&isPad=1
     * doc_id : 5338542
     * web_url : http://qicai.fengniao.com/533/5338542.html
     * comment_page_num : 0
     * comments_num : 0
     * more_comment_url : http://api.fengniao.com/app_ipad/news_doc_comments.php?docid=5338542&isPad=1
     */

    private List<Bean2Bean> Bean2;

    public Bean3Bean getBean3() {
        return Bean3;
    }

    public void setBean3(Bean3Bean Bean3) {
        this.Bean3 = Bean3;
    }

    public TotalpageBean getTotalpage() {
        return totalpage;
    }

    public void setTotalpage(TotalpageBean totalpage) {
        this.totalpage = totalpage;
    }

    public List<BeanBean> getBean() {
        return Bean;
    }

    public void setBean(List<BeanBean> Bean) {
        this.Bean = Bean;
    }

    public List<Bean2Bean> getBean2() {
        return Bean2;
    }

    public void setBean2(List<Bean2Bean> Bean2) {
        this.Bean2 = Bean2;
    }

    public static class Bean3Bean {
        private String title;
        private String pic_url;
        private String date;
        private String doc_url;
        private String doc_id;
        private String web_url;
        private int comment_page_num;
        private String comments_num;
        private String more_comment_url;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPic_url() {
            return pic_url;
        }

        public void setPic_url(String pic_url) {
            this.pic_url = pic_url;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getDoc_url() {
            return doc_url;
        }

        public void setDoc_url(String doc_url) {
            this.doc_url = doc_url;
        }

        public String getDoc_id() {
            return doc_id;
        }

        public void setDoc_id(String doc_id) {
            this.doc_id = doc_id;
        }

        public String getWeb_url() {
            return web_url;
        }

        public void setWeb_url(String web_url) {
            this.web_url = web_url;
        }

        public int getComment_page_num() {
            return comment_page_num;
        }

        public void setComment_page_num(int comment_page_num) {
            this.comment_page_num = comment_page_num;
        }

        public String getComments_num() {
            return comments_num;
        }

        public void setComments_num(String comments_num) {
            this.comments_num = comments_num;
        }

        public String getMore_comment_url() {
            return more_comment_url;
        }

        public void setMore_comment_url(String more_comment_url) {
            this.more_comment_url = more_comment_url;
        }
    }

    public static class TotalpageBean {
        private int totalpage;

        public int getTotalpage() {
            return totalpage;
        }

        public void setTotalpage(int totalpage) {
            this.totalpage = totalpage;
        }
    }

    public static class BeanBean {
        private String title;
        private String pic_url;
        private String date;
        private String author;
        private String doc_url;
        private String doc_id;
        private String web_url;
        private int comment_page_num;
        private String comments_num;
        private String more_comment_url;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPic_url() {
            return pic_url;
        }

        public void setPic_url(String pic_url) {
            this.pic_url = pic_url;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getDoc_url() {
            return doc_url;
        }

        public void setDoc_url(String doc_url) {
            this.doc_url = doc_url;
        }

        public String getDoc_id() {
            return doc_id;
        }

        public void setDoc_id(String doc_id) {
            this.doc_id = doc_id;
        }

        public String getWeb_url() {
            return web_url;
        }

        public void setWeb_url(String web_url) {
            this.web_url = web_url;
        }

        public int getComment_page_num() {
            return comment_page_num;
        }

        public void setComment_page_num(int comment_page_num) {
            this.comment_page_num = comment_page_num;
        }

        public String getComments_num() {
            return comments_num;
        }

        public void setComments_num(String comments_num) {
            this.comments_num = comments_num;
        }

        public String getMore_comment_url() {
            return more_comment_url;
        }

        public void setMore_comment_url(String more_comment_url) {
            this.more_comment_url = more_comment_url;
        }
    }

    public static class Bean2Bean {
        private String title;
        private String pic_url;
        private String date;
        private String doc_url;
        private String doc_id;
        private String web_url;
        private int comment_page_num;
        private String comments_num;
        private String more_comment_url;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPic_url() {
            return pic_url;
        }

        public void setPic_url(String pic_url) {
            this.pic_url = pic_url;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getDoc_url() {
            return doc_url;
        }

        public void setDoc_url(String doc_url) {
            this.doc_url = doc_url;
        }

        public String getDoc_id() {
            return doc_id;
        }

        public void setDoc_id(String doc_id) {
            this.doc_id = doc_id;
        }

        public String getWeb_url() {
            return web_url;
        }

        public void setWeb_url(String web_url) {
            this.web_url = web_url;
        }

        public int getComment_page_num() {
            return comment_page_num;
        }

        public void setComment_page_num(int comment_page_num) {
            this.comment_page_num = comment_page_num;
        }

        public String getComments_num() {
            return comments_num;
        }

        public void setComments_num(String comments_num) {
            this.comments_num = comments_num;
        }

        public String getMore_comment_url() {
            return more_comment_url;
        }

        public void setMore_comment_url(String more_comment_url) {
            this.more_comment_url = more_comment_url;
        }
    }
}
