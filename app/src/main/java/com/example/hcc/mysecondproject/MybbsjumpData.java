package com.example.hcc.mysecondproject;

import java.util.List;

/**
 * Created by Administrator on 2016/9/9.
 */
public class MybbsjumpData {

    /**
     * count : 6435
     */

    private CountBean count;
    /**
     * listTotalPage : 322
     */

    private ListTotalPageBean listTotalPage;
    /**
     * title : 风雪219-2016梧桐凤凰新藏线骑行纪实
     * author : oysw
     * views : 29061
     * reply : 1251
     * doc_url : http://api.fengniao.com/app_ipad/bbs_hot_detail.php?tid=9268127&fid=15&isPad=1&cid=0&sid=999&page=1
     * doc_url_v2 : http://api.fengniao.com/app_ipad/bbs_hot_detail_v2.php?tid=9268127&fid=15&isPad=1&cid=0&sid=999&page=1
     * docTotalPage : 63
     * tid : 9268127
     * fid : 15
     * web_url : http://bbs.fengniao.com/forum/9268127.html
     * docLzTotalPage : 59
     */

    private List<ListBean> list;

    public CountBean getCount() {
        return count;
    }

    public void setCount(CountBean count) {
        this.count = count;
    }

    public ListTotalPageBean getListTotalPage() {
        return listTotalPage;
    }

    public void setListTotalPage(ListTotalPageBean listTotalPage) {
        this.listTotalPage = listTotalPage;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class CountBean {
        private String count;

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }
    }

    public static class ListTotalPageBean {
        private int listTotalPage;

        public int getListTotalPage() {
            return listTotalPage;
        }

        public void setListTotalPage(int listTotalPage) {
            this.listTotalPage = listTotalPage;
        }
    }

    public static class ListBean {
        private String title;
        private String author;
        private String views;
        private String reply;
        private String doc_url;
        private String doc_url_v2;
        private int docTotalPage;
        private String tid;
        private String fid;
        private String web_url;
        private int docLzTotalPage;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getViews() {
            return views;
        }

        public void setViews(String views) {
            this.views = views;
        }

        public String getReply() {
            return reply;
        }

        public void setReply(String reply) {
            this.reply = reply;
        }

        public String getDoc_url() {
            return doc_url;
        }

        public void setDoc_url(String doc_url) {
            this.doc_url = doc_url;
        }

        public String getDoc_url_v2() {
            return doc_url_v2;
        }

        public void setDoc_url_v2(String doc_url_v2) {
            this.doc_url_v2 = doc_url_v2;
        }

        public int getDocTotalPage() {
            return docTotalPage;
        }

        public void setDocTotalPage(int docTotalPage) {
            this.docTotalPage = docTotalPage;
        }

        public String getTid() {
            return tid;
        }

        public void setTid(String tid) {
            this.tid = tid;
        }

        public String getFid() {
            return fid;
        }

        public void setFid(String fid) {
            this.fid = fid;
        }

        public String getWeb_url() {
            return web_url;
        }

        public void setWeb_url(String web_url) {
            this.web_url = web_url;
        }

        public int getDocLzTotalPage() {
            return docLzTotalPage;
        }

        public void setDocLzTotalPage(int docLzTotalPage) {
            this.docLzTotalPage = docLzTotalPage;
        }
    }
}
