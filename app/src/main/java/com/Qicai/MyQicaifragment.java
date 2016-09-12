package com.Qicai;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.Downloading.HandloadJson;
import com.example.hcc.mysecondproject.R;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/6.
 */
public class MyQicaifragment extends Fragment implements AdapterView.OnItemClickListener {
    List<MyQicaiData.ListBean> datalist = new ArrayList<>();
    QicaiAdapter qicaiAdapter;
    PullToRefreshListView pullToRefreshListView;
    ViewPager viewPager;
    List<Fragment> headfragmentlist=new ArrayList<>();
    int num = 1;
    String resqicai_path=null;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case  1:
                    String json= (String) msg.obj;
                    Gson gson=new Gson();
                    MyQicaiData myQicaiData=gson.fromJson(json,MyQicaiData.class);
                    Log.d("heef","===="+myQicaiData);
                    datalist.addAll(myQicaiData.getList());
                    qicaiAdapter=new QicaiAdapter(getActivity(),datalist);
                    qicaiAdapter.notifyDataSetChanged();
                    pullToRefreshListView.setAdapter(qicaiAdapter);
                    pullToRefreshListView.onRefreshComplete();
                    break;
            }
        }
    };

    public MyQicaifragment getInstance(String url){
        MyQicaifragment myQicaifragment=new MyQicaifragment();
        Bundle bundle=new Bundle();
        bundle.putString("url",url);
        myQicaifragment.setArguments(bundle);
        return  myQicaifragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.qicai_fragmentlayout, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        pullToRefreshListView = (PullToRefreshListView) view.findViewById(R.id.qicai_listviewId);
        View qicaiview=LayoutInflater.from(getActivity()).inflate(R.layout.qicai_headlayout,null);
        viewPager= (ViewPager) qicaiview.findViewById(R.id.second_viewpagerId);
        initheadData();
        QicaiheadAdapter qicaiheadadapter=new QicaiheadAdapter(getChildFragmentManager(),headfragmentlist);
        viewPager.setAdapter(qicaiheadadapter);
        pullToRefreshListView.getRefreshableView().addHeaderView(qicaiview);

        resqicai_path = getArguments().getString("url");
        Log.d("dadad","========="+resqicai_path);
        HandloadJson.downLoadingJson(resqicai_path+1,handler);

        pullToRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);
        pullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(final PullToRefreshBase<ListView> refreshView) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        num--;
                        HandloadJson.downLoadingJson(resqicai_path+num,handler);

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
                        HandloadJson.downLoadingJson(resqicai_path+num,handler);

                    }
                }).start();
            }
        });
 pullToRefreshListView.setOnItemClickListener(this);
    }

    private void initheadData() {
        headfragmentlist.add(new Myqicaiheadfragment().getInstance(0));
        headfragmentlist.add(new Myqicaiheadfragment().getInstance(1));
        headfragmentlist.add(new Myqicaiheadfragment().getInstance(2));
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (position>2){
            Intent intent=new Intent();

            String str=datalist.get(position-3).getWeb_url();
            Log.d("str","========"+str);
            intent.putExtra("url",str);
            intent.setAction("com.he.jump");
            startActivity(intent);
        }
    }
}
