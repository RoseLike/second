package com.Video;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hcc.mysecondproject.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2016/9/7.
 */
public class VideoAdapter extends BaseAdapter {
    Context context;
    List<MyVideoData.ListBean>list;

    public VideoAdapter(Context context, List<MyVideoData.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size()/2;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position*2);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        VideoHolder videoHolder;
        if (convertView==null){
            videoHolder=new VideoHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.video_item,null);
            videoHolder.leftImageView= (ImageView) convertView.findViewById(R.id.videoimageId);
            videoHolder.rightImageView= (ImageView) convertView.findViewById(R.id.videoimageId2);
            videoHolder.leftTextview= (TextView) convertView.findViewById(R.id.videotextviewId);
            videoHolder.rightTextview= (TextView) convertView.findViewById(R.id.videotextviewId2);
            convertView.setTag(videoHolder);

        }else {
            videoHolder= (VideoHolder) convertView.getTag();
        }
        videoHolder.rightTextview.setText(list.get(position*2).getTitle());
        videoHolder.leftTextview.setText(list.get(position*2+1).getTitle());
        Picasso.with(context).load(list.get(position*2+1).getPic_url()).placeholder(R.drawable.bg_b).error(R.drawable.bg_b).into(videoHolder.leftImageView);
        Picasso.with(context).load(list.get(position*2).getPic_url()).placeholder(R.drawable.bg_b).error(R.drawable.bg_b).into(videoHolder.rightImageView);
        videoHolder.leftImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setAction("com.he.jump");
                intent.putExtra("url", list.get(position*2+1).getWeb_url());
                context.startActivity(intent);
            }
        });
        videoHolder.rightImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setAction("com.he.jump");
                intent.putExtra("url", list.get(position*2).getWeb_url());
                context.startActivity(intent);
            }
        });
        return convertView;
    }
}
class VideoHolder{
    ImageView leftImageView,rightImageView;
    TextView leftTextview,rightTextview;
}