package com.person;

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
public class PersonAdapter extends BaseAdapter {
    Context context;
    List<MyPersonData.ListBean>list;

    public PersonAdapter(Context context, List<MyPersonData.ListBean> list) {
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
        PersonHolder personHolder=null;
        if (convertView==null){
            personHolder=new PersonHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.pictureshare_item,null);
            personHolder.leftimageview= (ImageView) convertView.findViewById(R.id.picimageviewId);
            personHolder.rightimageview= (ImageView) convertView.findViewById(R.id.picimageviewId2);
            personHolder.lefttextview= (TextView) convertView.findViewById(R.id.pictextviewId);
            personHolder.righttextview= (TextView) convertView.findViewById(R.id.pictextviewId2);
           convertView.setTag(personHolder);
        } else{
            personHolder= (PersonHolder) convertView.getTag();
        }
        personHolder.lefttextview.setText(list.get(position*2).getTitle());
        personHolder.righttextview.setText(list.get(position*2+1).getTitle());
        Picasso.with(context).load(list.get(position*2).getPic_url()).placeholder(R.drawable.bg_b).error(R.drawable.bg_b).into(personHolder.leftimageview);
        Picasso.with(context).load(list.get(position*2+1).getPic_url()).placeholder(R.drawable.bg_b).error(R.drawable.bg_b).into(personHolder.rightimageview);
        personHolder.leftimageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setAction("com.he.jump");
                intent.putExtra("url", list.get(position*2+1).getWeb_url());
                context.startActivity(intent);
            }
        });
        personHolder.rightimageview.setOnClickListener(new View.OnClickListener() {
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
class  PersonHolder{
    ImageView leftimageview,rightimageview;
    TextView lefttextview,righttextview;
}