package com.Qicai;

import java.util.List;

/**
 * Created by Administrator on 2016/9/6.
 */
public class MyQicaiData {

    /**
     * totalpage : 3547
     */

    private TotalpageBean totalpage;
    /**
     * totalpage : {"totalpage":3547}
     * cid : 296
     * list : [{"title":"双盘合璧 \u201c芝\u201d你所想 东芝购X300送Q300","pic_url":"http://img2.fengniao.com/article/12_280x210/963/liGnyaQ2RnETQ.jpg","doc_url":"http://api.fengniao.com/app_ipad/news_doc.php?docid=5338625&isPad=1","comment_page_num":0,"comments_num":"0","more_comment_url":"http://api.fengniao.com/app_ipad/news_doc_comments.php?docid=5338625&isPad=1","doc_id":"5338625","web_url":"http://qicai.fengniao.com/533/5338625.html"},{"title":"让我们看见那片海 涠洲岛+德天瀑布纪行","pic_url":"http://img2.fengniao.com/article/12_280x210/939/lifBi0AdoBSyI.jpg","doc_url":"http://api.fengniao.com/app_ipad/news_doc.php?docid=5338161&isPad=1","comment_page_num":0,"comments_num":"0","more_comment_url":"http://api.fengniao.com/app_ipad/news_doc_comments.php?docid=5338161&isPad=1","doc_id":"5338161","web_url":"http://qicai.fengniao.com/533/5338161.html"},{"title":"可分期付款 适马150-600mm Sports售11980","pic_url":"http://img2.fengniao.com/article/12_280x210/940/liBNDf8g9nLQY.jpg","doc_url":"http://api.fengniao.com/app_ipad/news_doc.php?docid=5338616&isPad=1","comment_page_num":0,"comments_num":"0","more_comment_url":"http://api.fengniao.com/app_ipad/news_doc_comments.php?docid=5338616&isPad=1","doc_id":"5338616","web_url":"http://qicai.fengniao.com/533/5338616.html"},{"title":"性价比爆表 永诺35mm F2尼康版正式发货","pic_url":"http://img2.fengniao.com/article/12_280x210/944/liRekEZ2bByYs.jpg","doc_url":"http://api.fengniao.com/app_ipad/news_doc.php?docid=5338611&isPad=1","comment_page_num":0,"comments_num":"0","more_comment_url":"http://api.fengniao.com/app_ipad/news_doc_comments.php?docid=5338611&isPad=1","doc_id":"5338611","web_url":"http://qicai.fengniao.com/533/5338611.html"},{"title":"遥遥无期 尼康DL系列相机或将再次推迟发货","pic_url":"http://img2.fengniao.com/article/12_280x210/937/liHTtiASezUxk.jpg","doc_url":"http://api.fengniao.com/app_ipad/news_doc.php?docid=5338610&isPad=1","comment_page_num":0,"comments_num":"0","more_comment_url":"http://api.fengniao.com/app_ipad/news_doc_comments.php?docid=5338610&isPad=1","doc_id":"5338610","web_url":"http://qicai.fengniao.com/533/5338610.html"},{"title":"再发新品 索尼或于9月9日再发布E卡口镜头","pic_url":"http://img2.fengniao.com/article/12_280x210/936/liFcZBT6xAJ0k.jpg","doc_url":"http://api.fengniao.com/app_ipad/news_doc.php?docid=5338608&isPad=1","comment_page_num":0,"comments_num":"0","more_comment_url":"http://api.fengniao.com/app_ipad/news_doc_comments.php?docid=5338608&isPad=1","doc_id":"5338608","web_url":"http://qicai.fengniao.com/533/5338608.html"}]
     */

    private int cid;
    /**
     * title : 双盘合璧 “芝”你所想 东芝购X300送Q300
     * pic_url : http://img2.fengniao.com/article/12_280x210/963/liGnyaQ2RnETQ.jpg
     * doc_url : http://api.fengniao.com/app_ipad/news_doc.php?docid=5338625&isPad=1
     * comment_page_num : 0
     * comments_num : 0
     * more_comment_url : http://api.fengniao.com/app_ipad/news_doc_comments.php?docid=5338625&isPad=1
     * doc_id : 5338625
     * web_url : http://qicai.fengniao.com/533/5338625.html
     */

    private List<ListBean> list;

    public TotalpageBean getTotalpage() {
        return totalpage;
    }

    public void setTotalpage(TotalpageBean totalpage) {
        this.totalpage = totalpage;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
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

    public static class ListBean {
        private String title;
        private String pic_url;
        private String doc_url;
        private int comment_page_num;
        private String comments_num;
        private String more_comment_url;
        private String doc_id;
        private String web_url;

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

        public String getDoc_url() {
            return doc_url;
        }

        public void setDoc_url(String doc_url) {
            this.doc_url = doc_url;
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
    }
}
