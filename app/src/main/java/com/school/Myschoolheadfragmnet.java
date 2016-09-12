package com.school;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.Downloading.HandloadJson;
import com.example.hcc.mysecondproject.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Administrator on 2016/9/8.
 */
public class Myschoolheadfragmnet extends Fragment {
    List<MyschoolheadData> schoolheadlist;
    ImageView imageView;
    TextView textView;
    MyschoolheadData myschoolheadData;
    int num=0;
    String res_patsda="http://api.fengniao.com/app_ipad//focus_pic.php?appImei=000000000000000&osType=Android&osVersion=4.1.1&mid=19931";
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case  1:
                 String json= (String) msg.obj;
                    Gson gson=new Gson();
                    Type type=new TypeToken<List<MyschoolheadData>>(){}.getType();
                    schoolheadlist=gson.fromJson(json,type);
                    myschoolheadData=schoolheadlist.get(num);
                    Picasso.with(getActivity()).load(myschoolheadData.getPic_src()).placeholder(R.drawable.bg_b).error(R.drawable.bg_b).into(imageView);
                    textView.setText(myschoolheadData.getTitle());

                    break;
            }
        }
    };
    public Myschoolheadfragmnet getInstance(int headdata){
        Myschoolheadfragmnet myschoolheadfragmnet=new Myschoolheadfragmnet();
        Bundle bundle=new Bundle();
        bundle.putInt("headdata",headdata);
        myschoolheadfragmnet.setArguments(bundle);
        return  myschoolheadfragmnet;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.school_headfragment,null);
    }
        @Override
        public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
             num=getArguments().getInt("headdata");
             imageView= (ImageView) view.findViewById(R.id.schoolheadimageId);
             textView= (TextView) view.findViewById(R.id.schoolheadtextview);
             HandloadJson.downLoadingJson(res_patsda,handler);
             imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent();
                    intent.setAction("com.he.jump");
                    intent.putExtra("url", myschoolheadData.getWeb_url());
                    getActivity().startActivity(intent);
                }
            });
        }

}
