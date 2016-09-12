package com.person;

import java.util.List;

/**
 * Created by Administrator on 2016/9/8.
 */
public class MyPersonData {

    /**
     * totalpage : 129
     */

    private TotalpageBean totalpage;
    /**
     * forumname : 人像
     */

    private ForumnameBean forumname;
    /**
     * date : 1472627920
     * title : 悠弦.森琳【森系美女大提琴】——琳琳出镜
     * pic_url : http://img3.fengniao.com/forum/attachpics/931/60/37211909_200.jpg
     * detail_url : http://api.fengniao.com/app_ipad/pic_bbs_detail.php?id=9246259&fid=101
     * web_url : http://bbs.fengniao.com/forum/9246259.html
     */

    private List<ListBean> list;

    public TotalpageBean getTotalpage() {
        return totalpage;
    }

    public void setTotalpage(TotalpageBean totalpage) {
        this.totalpage = totalpage;
    }

    public ForumnameBean getForumname() {
        return forumname;
    }

    public void setForumname(ForumnameBean forumname) {
        this.forumname = forumname;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
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

    public static class ForumnameBean {
        private String forumname;

        public String getForumname() {
            return forumname;
        }

        public void setForumname(String forumname) {
            this.forumname = forumname;
        }
    }

    public static class ListBean {
        private String date;
        private String title;
        private String pic_url;
        private String detail_url;
        private String web_url;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

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

        public String getDetail_url() {
            return detail_url;
        }

        public void setDetail_url(String detail_url) {
            this.detail_url = detail_url;
        }

        public String getWeb_url() {
            return web_url;
        }

        public void setWeb_url(String web_url) {
            this.web_url = web_url;
        }
    }
}
