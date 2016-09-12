package com.Environmental;

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
public class EnvironmentalAdapter extends BaseAdapter {
    Context context;
    List<MyEnvironmentalData.ListBean>list;

    public EnvironmentalAdapter(Context context, List<MyEnvironmentalData.ListBean> list) {
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
        EnviroHolder enviroHolder=null;
        if (convertView==null) {
            enviroHolder=new EnviroHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.pictureshare_item,null);
            enviroHolder.leftimageview= (ImageView) convertView.findViewById(R.id.picimageviewId);
            enviroHolder.rightimageview= (ImageView) convertView.findViewById(R.id.picimageviewId2);
            enviroHolder.leftitextview= (TextView) convertView.findViewById(R.id.pictextviewId);
            enviroHolder.righttextview= (TextView) convertView.findViewById(R.id.pictextviewId2);
            convertView.setTag(enviroHolder);
        } else{
            enviroHolder= (EnviroHolder) convertView.getTag();
        }
        enviroHolder.leftitextview.setText(list.get(position*2).getTitle());
        enviroHolder.righttextview.setText(list.get(position*2+1).getTitle());
        Picasso.with(context).load(list.get(position*2).getPic_url()).placeholder(R.drawable.bg_b).error(R.drawable.bg_b).into(enviroHolder.leftimageview);
        Picasso.with(context).load(list.get(position*2+1).getPic_url()).placeholder(R.drawable.bg_b).error(R.drawable.bg_b).into(enviroHolder.rightimageview);
        enviroHolder.leftimageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setAction("com.he.jump");
                intent.putExtra("url", list.get(position*2).getWeb_url());
                context.startActivity(intent);
            }
        });
        enviroHolder.rightimageview.setOnClickListener(new View.OnClickListener() {
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
class EnviroHolder{
    ImageView leftimageview,rightimageview;
    TextView leftitextview,righttextview;
}