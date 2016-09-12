package com.school;

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
public class MySchoolfragment extends Fragment {
    List<MySchoolData.ListBean>schooldata=new ArrayList<>();
    PullToRefreshListView pullToRefreshListView;
    SchoolheadAdapter schoolheadAdapter;
    String res_path="";
    ViewPager viewPager;
    SchoolAdapter schoolAdapter;
    List<Fragment> schoolheadlist=new ArrayList<>();
    int num=1;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    String json= (String) msg.obj;
                    Gson gson=new Gson();
                    MySchoolData mySchoolData=gson.fromJson(json,MySchoolData.class);
                    schooldata.addAll(mySchoolData.getList());
                    schoolAdapter=new SchoolAdapter(getActivity(),schooldata);
                    schoolAdapter.notifyDataSetChanged();
                    pullToRefreshListView.setAdapter(schoolAdapter);
                    pullToRefreshListView.onRefreshComplete();
                    break;
            }
        }
    };
    public MySchoolfragment getInstance(String url){
        MySchoolfragment mySchoolfragment=new MySchoolfragment();
        Bundle bundle=new Bundle();
        bundle.putString("url",url);
        mySchoolfragment.setArguments(bundle);
        return  mySchoolfragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.school_fragmentlayout,null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        pullToRefreshListView= (PullToRefreshListView) view.findViewById(R.id.school_listviewId);
        View schoolheadview=LayoutInflater.from(getActivity()).inflate(R.layout.school_headlayout,null);
        viewPager= (ViewPager) schoolheadview.findViewById(R.id.four_viewpagerId);
        initheadData();
        schoolheadAdapter=new SchoolheadAdapter(getChildFragmentManager(),schoolheadlist);
        viewPager.setAdapter(schoolheadAdapter);
        pullToRefreshListView.getRefreshableView().addHeaderView(schoolheadview);

        res_path=getArguments().getString("url");
        HandloadJson.downLoadingJson(res_path+num,handler);

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

    private void initheadData() {
        schoolheadlist.add(new Myschoolheadfragmnet().getInstance(0));
        schoolheadlist.add(new Myschoolheadfragmnet().getInstance(1));
        schoolheadlist.add(new Myschoolheadfragmnet().getInstance(2));

    }


}
