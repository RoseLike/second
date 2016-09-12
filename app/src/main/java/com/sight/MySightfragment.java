package com.sight;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
 * Created by Administrator on 2016/9/8.
 */
public class MySightfragment extends Fragment {
    PullToRefreshListView pullToRefreshListView;
    List<MySightData.ListBean> sightlist=new ArrayList<>();
    String sightstr="";
    SightAdapter sightAdapter;
    int num=1;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    String json= (String) msg.obj;
                    Gson gson=new Gson();
                    MySightData mySightData=gson.fromJson(json, MySightData.class);
                    sightlist.addAll(mySightData.getList());
                    sightAdapter=new SightAdapter(getActivity(), sightlist);
                    sightAdapter.notifyDataSetChanged();
                    pullToRefreshListView.setAdapter(sightAdapter);
                    pullToRefreshListView.getRefreshableView();
                    break;
            }
        }
    };
    public MySightfragment getInstance(String url){
        MySightfragment mySightfragment=new MySightfragment();
        Bundle bundle=new Bundle();
        bundle.putString("url",url);
        mySightfragment.setArguments(bundle);
        return  mySightfragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.pictureshare_layout,null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        pullToRefreshListView= (PullToRefreshListView) view.findViewById(R.id.pictureshare_listviewId);
        sightstr=getArguments().getString("url");
        HandloadJson.downLoadingJson(sightstr+num,handler);

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
                        num++;
                        HandloadJson.downLoadingJson(sightstr+num,handler);

                    }
                }).start();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {

            }
        });
    }
}
