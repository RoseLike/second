package com.person;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
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
public class MyPersonfragment extends Fragment {

    List<MyPersonData.ListBean> personList=new ArrayList<>();
    PullToRefreshListView pullToRefreshListView;
    String re_path="";
    int num=1;
    PersonAdapter personAdapter;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                   String json= (String) msg.obj;
                    Gson gson=new Gson();
                    MyPersonData myPersonData=gson.fromJson(json,MyPersonData.class);
                    Log.d("myPersonData","========"+myPersonData);
                    if (myPersonData!=null){
                        personList.addAll(myPersonData.getList());
                        personAdapter=new PersonAdapter(getActivity(),personList);
                        personAdapter.notifyDataSetChanged();
                        pullToRefreshListView.setAdapter(personAdapter);
                        pullToRefreshListView.getRefreshableView();
                    }

                    break;
            }
        }
    };
    public MyPersonfragment getInstance(String url){
        MyPersonfragment myPersonfragment=new MyPersonfragment();
        Bundle bundle=new Bundle();
        bundle.putString("url",url);
        myPersonfragment.setArguments(bundle);
        return  myPersonfragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.pictureshare_layout,null);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        re_path=getArguments().getString("url");
        pullToRefreshListView= (PullToRefreshListView) view.findViewById(R.id.pictureshare_listviewId);
        HandloadJson.downLoadingJson(re_path+num,handler);

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
                        HandloadJson.downLoadingJson(re_path+num,handler);

                    }
                }).start();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {

            }
        });


    }
}
