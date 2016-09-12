package com.New;


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

import com.Downloading.HandlerUtils;
import com.example.hcc.mysecondproject.R;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 16-9-3.
 */
public class MyNewfragment extends Fragment implements AdapterView.OnItemClickListener {
    List<MyData.BeanBean> Bean = new ArrayList<>();
    List<MyData.Bean2Bean> Bean2 = new ArrayList<>();
    ViewPager viewPager;
    List<Fragment>newheadlist=new ArrayList<>();
    NewheadAdapter newheadAdapter;
    NewAdapter1 newAdapter1;
    PullToRefreshListView pullToRefreshListView;
    int num = 1;
    int hehe=0;
    String res_path=null;
    HandlerUtils handlerUtils;
    Handler handler2=new Handler();
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    String string= (String) msg.obj;
                    String strings = string.replace("280280", "Bean2");
                    String json = strings.replace("160120", "Bean");
                    Gson gson=new Gson();
                    MyData data=gson.fromJson(json,MyData.class);
                   // Bean2.clear();
                    Bean2.addAll(data.getBean2());
                  //  Bean.clear();
                    Bean.addAll(data.getBean());
                    newAdapter1.notifyDataSetChanged();
                    break;
            }
        }
    };

  public MyNewfragment getInstance(String url){
      MyNewfragment myNewfragment=new MyNewfragment();
      Bundle bundle=new Bundle();
      bundle.putString("url",url);
      myNewfragment.setArguments(bundle);
      return  myNewfragment;
  }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.new_fragmentlayout, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        pullToRefreshListView = (PullToRefreshListView) view.findViewById(R.id.new_listviewId);
        View headview=LayoutInflater.from(getActivity()).inflate(R.layout.new_headlayout,null);
        viewPager= (ViewPager) headview.findViewById(R.id.first_viewpagerId);
        intiheadData();
        newheadAdapter=new NewheadAdapter(getChildFragmentManager(),newheadlist);
        viewPager.setAdapter(newheadAdapter);
        //pullToRefreshListView.getRefreshableView().addHeaderView(headview);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(hehe<3){
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                   handler2.post(new Runnable() {
                       @Override
                       public void run() {
                           viewPager.setCurrentItem(hehe);
                           newheadAdapter.notifyDataSetChanged();
                       }
                   });
                    hehe++;
                    if(hehe==3){
                        hehe=0;
                    }
                }
            }
        }).start();

        handlerUtils = new HandlerUtils(handler);
        res_path= (String) getArguments().get("url");
        handlerUtils.downLoadingJson(res_path + num);

        newAdapter1 = new NewAdapter1(getActivity(), Bean2, Bean);
        pullToRefreshListView.setAdapter(newAdapter1);


        pullToRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);
        pullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {

//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        try {
//                            Thread.sleep(2000);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
                        num++;
                        handlerUtils.downLoadingJson(res_path+num);
                        pullToRefreshListView.onRefreshComplete();

               //     }
             //   }).start();


            }

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
                        handlerUtils.downLoadingJson(res_path+num);

                    }
                }).start();
            }
        });


        pullToRefreshListView.setOnItemClickListener(this);
    }



    private void intiheadData() {
        newheadlist.add(new Mynewheadfragment().getInstance(0));
        newheadlist.add(new Mynewheadfragment().getInstance(1));
        newheadlist.add(new Mynewheadfragment().getInstance(2));
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.d("position","========="+position);
        if (position>2){
            Intent intent=new Intent();
//            intent.setAction(Intent.ACTION_VIEW);
//            intent.setData(Uri.parse(Bean.get(position-3).getWeb_url()));
//            startActivity(intent);

            String str=Bean.get(position-3).getWeb_url();
            Log.d("str","========"+str);
            intent.putExtra("url",str);
            intent.setAction("com.he.jump");
            startActivity(intent);
        }
    }
}
