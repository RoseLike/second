package com.New;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
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
 * Created by Administrator on 2016/9/7.
 */
public class Mynewheadfragment extends Fragment {
    ImageView imageView;
    TextView textView;
    String str="http://api.fengniao.com/app_ipad/focus_pic.php?mid=19928?appImei=000000000000000&osType=Android&osVersion=4.1.1%20HTTP/1.1";
    int num=0;
    List<MyheadData> headlist;
    MyheadData myheadData;
    Handler handler =new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    String json= (String) msg.obj;
                    if (json!=null) {
                    Gson gson=new Gson();
                    Type type=new TypeToken<List<MyheadData>>(){}.getType();
                    headlist=gson.fromJson(json,type);
                    myheadData=headlist.get(num);
                        Picasso.with(getActivity()).load(myheadData.getPic_src()).placeholder(R.drawable.bg_b).error(R.drawable.bg_b).into(imageView);
                        textView.setText(myheadData.getTitle());
                    }
                    break;
            }
        }
    };
    public Mynewheadfragment getInstance(int headdata){
        Mynewheadfragment mynewheadfragment=new Mynewheadfragment();
        Bundle bundle=new Bundle();
        bundle.putInt("headdata",headdata);
        mynewheadfragment.setArguments(bundle);
        return  mynewheadfragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.new_headfragment,null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageView= (ImageView) view.findViewById(R.id.headimageId);
        textView= (TextView) view.findViewById(R.id.headtextview);
        num=getArguments().getInt("headdata");
        Log.d("head","======"+str);
        HandloadJson.downLoadingJson(str,handler);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setAction("com.he.jump");
                intent.putExtra("url", myheadData.getWeb_url());
                getActivity().startActivity(intent);
            }
        });
    }
}
