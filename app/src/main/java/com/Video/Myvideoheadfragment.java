package com.Video;

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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/8.
 */
public class Myvideoheadfragment extends Fragment {
    List<MyvideoheadData> videoheadlist=new ArrayList<>();
    MyvideoheadData myvideoheadData;
    ImageView imageView;
    TextView textView;
    int num=0;
    String res_sfffs="http://api.fengniao.com/app_ipad//focus_pic.php?appImei=000000000000000&osType=Android&osVersion=4.1.1&mid=19930";
   Handler handler=new Handler(){
       @Override
       public void handleMessage(Message msg) {
           super.handleMessage(msg);
           switch (msg.what){
               case 1:
                   String json= (String) msg.obj;
                   Gson gson=new Gson();
                   Type type=new TypeToken<List<MyvideoheadData>>(){}.getType();
                   videoheadlist=gson.fromJson(json,type);
                   myvideoheadData=videoheadlist.get(num);
                   Log.d("myvideoheadData","=========="+myvideoheadData);
                   textView.setText(myvideoheadData.getTitle());
                   Picasso.with(getActivity()).load(myvideoheadData.getPic_src()).placeholder(R.drawable.bg_b).error(R.drawable.bg_b).into(imageView);
                   onListener();
                   break;
           }
       }
   };

    private void onListener() {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setAction("com.he.jump");
                intent.putExtra("url", myvideoheadData.getWeb_url());
                getActivity().startActivity(intent);
            }
        });
    }

    public Myvideoheadfragment getInstance(int headdata){
        Myvideoheadfragment myvideoheadfragment=new Myvideoheadfragment();
        Bundle bundle=new Bundle();
        bundle.putInt("headdata",headdata);
        myvideoheadfragment.setArguments(bundle);
        return  myvideoheadfragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.video_headfragment,null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        num=getArguments().getInt("headdata");
        imageView= (ImageView) view.findViewById(R.id.videoheadimageId);
        Log.d("videoimageview","======="+imageView);
        textView= (TextView) view.findViewById(R.id.videoheadtextview);
        Log.d("videotextview","========="+textView);
        HandloadJson.downLoadingJson(res_sfffs,handler);

    }
}
