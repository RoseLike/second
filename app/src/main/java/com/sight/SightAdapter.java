package com.sight;

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
public class SightAdapter extends BaseAdapter {
    Context context;
    List<MySightData.ListBean> list;

    public SightAdapter(Context context, List<MySightData.ListBean> list) {
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
        SightHolder sightHolder=null;
        if (convertView==null){
            sightHolder=new SightHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.pictureshare_item,null);
            sightHolder.leftimageview= (ImageView) convertView.findViewById(R.id.picimageviewId);
            sightHolder.rightimageview= (ImageView) convertView.findViewById(R.id.picimageviewId2);
            sightHolder.lefttextview= (TextView) convertView.findViewById(R.id.pictextviewId);
            sightHolder.righttextview= (TextView) convertView.findViewById(R.id.pictextviewId2);
            convertView.setTag(sightHolder);
        } else{
            sightHolder= (SightHolder) convertView.getTag();
        }
        sightHolder.lefttextview.setText(list.get(position*2).getTitle());
        sightHolder.righttextview.setText(list.get(position*2+1).getTitle());
        Picasso.with(context).load(list.get(position*2).getPic_url()).placeholder(R.drawable.bg_b).error(R.drawable.bg_b).into(sightHolder.leftimageview);
        Picasso.with(context).load(list.get(position*2+1).getPic_url()).placeholder(R.drawable.bg_b).error(R.drawable.bg_b).into(sightHolder.rightimageview);
        sightHolder.leftimageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setAction("com.he.jump");
                intent.putExtra("url", list.get(position*2+1).getWeb_url());
                context.startActivity(intent);
            }
        });
        sightHolder.rightimageview.setOnClickListener(new View.OnClickListener() {
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
class SightHolder {
    ImageView leftimageview,rightimageview;
    TextView lefttextview,righttextview;
}