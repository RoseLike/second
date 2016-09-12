package com.Video;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.Downloading.HandloadJson;
import com.example.hcc.mysecondproject.R;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/7.
 */
public class MyVideofragment extends Fragment {
    List<MyVideoData.ListBean> videodatalist=new ArrayList<>();
    PullToRefreshListView pullToRefreshListView;
    VideoAdapter videoAdapter;
    ViewPager viewPager;
    List<Fragment> videoheadlist=new ArrayList<>();
    VideoheadAdapter videoheadadapter;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    String json= (String) msg.obj;
                    Gson gson=new Gson();
                    MyVideoData myVideoData=gson.fromJson(json,MyVideoData.class);
                    videodatalist.addAll(myVideoData.getList());
                    videoAdapter=new VideoAdapter(getActivity(),videodatalist);
                    videoAdapter.notifyDataSetChanged();
                    pullToRefreshListView.setAdapter(videoAdapter);
                    pullToRefreshListView.onRefreshComplete();
                    break;
            }
        }
    };
    String res_path="";
    int num=1;
    public MyVideofragment getInstance(String url){
        MyVideofragment myVideofragment=new MyVideofragment();
        Bundle bundle=new Bundle();
        bundle.putString("url",url);
        myVideofragment.setArguments(bundle);
        return  myVideofragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.video_fragmentlayout,null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        pullToRefreshListView= (PullToRefreshListView) view.findViewById(R.id.video_listviewId);
        View videoview=LayoutInflater.from(getActivity()).inflate(R.layout.video_headlayout,null);
        viewPager= (ViewPager) videoview.findViewById(R.id.third_viewpagerId);
        inttvideoData();
        videoheadadapter=new VideoheadAdapter(getChildFragmentManager(),videoheadlist);
        viewPager.setAdapter(videoheadadapter);
        pullToRefreshListView.getRefreshableView().addHeaderView(videoview);

        res_path=getArguments().getString("url");
        HandloadJson.downLoadingJson(res_path+num,handler);
        intipulllistener();
    }

    private void inttvideoData() {
        videoheadlist.add(new Myvideoheadfragment().getInstance(0));
        videoheadlist.add(new Myvideoheadfragment().getInstance(1));
        videoheadlist.add(new Myvideoheadfragment().getInstance(2));
    }

    private void intipulllistener() {
        pullToRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);
        pullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        num--;
                        HandloadJson.downLoadingJson(res_path+num,handler);
                    }
                }).start();

            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        num++;
                        HandloadJson.downLoadingJson(res_path+num,handler);
                    }
                }).start();
            }
        });
    }
}
