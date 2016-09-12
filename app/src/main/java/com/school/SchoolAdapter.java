package com.school;

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
public class SchoolAdapter extends BaseAdapter {
    Context context;
    List<MySchoolData.ListBean> list;

    public SchoolAdapter(Context context, List<MySchoolData.ListBean> list) {
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
        SchoolHolder schoolHolder;
        if (convertView==null){
            schoolHolder=new SchoolHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.school_item,null);
            schoolHolder.leftTextview= (TextView) convertView.findViewById(R.id.schooltextviewId);
            schoolHolder.rightTextview = (TextView) convertView.findViewById(R.id.schooltextviewId2);
            schoolHolder.leftImageView= (ImageView) convertView.findViewById(R.id.schoolimageId);
            schoolHolder.rightImageView= (ImageView) convertView.findViewById(R.id.schoolimageId2);
            convertView.setTag(schoolHolder);
        } else{
            schoolHolder= (SchoolHolder) convertView.getTag();
        }
        schoolHolder.rightTextview.setText(list.get(position*2).getTitle());
        schoolHolder.leftTextview.setText(list.get(position*2+1).getTitle());
        Picasso.with(context).load(list.get(position*2+1).getPic_url()).placeholder(R.drawable.bg_b).error(R.drawable.bg_b).into(schoolHolder.leftImageView);
        Picasso.with(context).load(list.get(position*2).getPic_url()).placeholder(R.drawable.bg_b).error(R.drawable.bg_b).into(schoolHolder.rightImageView);
        schoolHolder.leftImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setAction("com.he.jump");
                intent.putExtra("url", list.get(position*2+1).getWeb_url());
                context.startActivity(intent);
            }
        });
        schoolHolder.rightImageView.setOnClickListener(new View.OnClickListener() {
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
 class  SchoolHolder{
     ImageView leftImageView,rightImageView;
     TextView leftTextview,rightTextview;
 }