package com.camera;

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
 * Created by Administrator on 2016/9/8.
 */
public class CameraAdapter extends BaseAdapter {
    Context context;
    List<MyCameraData.ListBean>list;

    public CameraAdapter(Context context, List<MyCameraData.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
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
        CameraHolder cameraHolder=null;
        if (convertView==null) {
            cameraHolder=new CameraHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.pictureshare_item,null);
            cameraHolder.leftimageview= (ImageView) convertView.findViewById(R.id.picimageviewId);
            cameraHolder.rightimageview= (ImageView) convertView.findViewById(R.id.picimageviewId2);
            cameraHolder.leftitextview= (TextView) convertView.findViewById(R.id.pictextviewId);
            cameraHolder.righttextview= (TextView) convertView.findViewById(R.id.pictextviewId2);
            convertView.setTag(cameraHolder);
        } else{
            cameraHolder= (CameraHolder) convertView.getTag();
        }
        cameraHolder.leftitextview.setText(list.get(position*2).getTitle());
        cameraHolder.righttextview.setText(list.get(position*2+1).getTitle());
        Picasso.with(context).load(list.get(position*2).getPic_url()).placeholder(R.drawable.bg_b).error(R.drawable.bg_b).into(cameraHolder.leftimageview);
        Picasso.with(context).load(list.get(position*2+1).getPic_url()).placeholder(R.drawable.bg_b).error(R.drawable.bg_b).into(cameraHolder.rightimageview);
        cameraHolder.leftimageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setAction("com.he.jump");
                intent.putExtra("url", list.get(position*2).getWeb_url());
                context.startActivity(intent);
            }
        });
        cameraHolder.rightimageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setAction("com.he.jump");
                intent.putExtra("url", list.get(position*2+1).getWeb_url());
                context.startActivity(intent);
            }
        });
        return convertView;
    }
}
class CameraHolder{
    ImageView leftimageview,rightimageview;
    TextView leftitextview,righttextview;
}