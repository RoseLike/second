package com.Qicai;

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
 * Created by Administrator on 2016/9/6.
 */
public class QicaiAdapter extends BaseAdapter{
    Context context;
    List<MyQicaiData.ListBean> list;

    public QicaiAdapter(Context context, List<MyQicaiData.ListBean> list) {
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
        QicaiHolder qicaiHolder;
        if (convertView==null){
            qicaiHolder=new QicaiHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.qicai_item,null);
            qicaiHolder.leftTextview= (TextView) convertView.findViewById(R.id.qicailefttextviewId);
            qicaiHolder.rightTextview = (TextView) convertView.findViewById(R.id.qicairighttextviewId);
            qicaiHolder.leftImageView= (ImageView) convertView.findViewById(R.id.qicaleftimageId);
            qicaiHolder.rightImageView= (ImageView) convertView.findViewById(R.id.qicairightmageId);
            convertView.setTag(qicaiHolder);
        } else{
            qicaiHolder= (QicaiHolder) convertView.getTag();
        }
        qicaiHolder.rightTextview.setText(list.get(position*2).getTitle());
        qicaiHolder.leftTextview.setText(list.get(position*2+1).getTitle());
        Picasso.with(context).load(list.get(position*2+1).getPic_url()).placeholder(R.drawable.bg_b).error(R.drawable.bg_b).into(qicaiHolder.leftImageView);
        Picasso.with(context).load(list.get(position*2).getPic_url()).placeholder(R.drawable.bg_b).error(R.drawable.bg_b).into(qicaiHolder.rightImageView);
        qicaiHolder.leftImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setAction("com.he.jump");
                intent.putExtra("url", list.get(position*2+1).getWeb_url());
                context.startActivity(intent);
            }
        });
        qicaiHolder.rightImageView.setOnClickListener(new View.OnClickListener() {
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
 class QicaiHolder{
     ImageView leftImageView,rightImageView;
     TextView leftTextview,rightTextview;
 }