package com.example.hcc.mysecondproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2016/9/9.
 */
public class MybbsjumpAdapter extends BaseAdapter {
    Context context;
    List<MybbsjumpData.ListBean>list;

    public MybbsjumpAdapter(Context context, List<MybbsjumpData.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BbsjumpHolder bbsjumpHolder;
        if (convertView==null){
            bbsjumpHolder=new BbsjumpHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.bbs_jump_item,null);
            bbsjumpHolder.authertextview= (TextView) convertView.findViewById(R.id.authorId);
            bbsjumpHolder.titletextView= (TextView) convertView.findViewById(R.id.bbs_jump_textviewId);
            convertView.setTag(bbsjumpHolder);
        } else {
            bbsjumpHolder= (BbsjumpHolder) convertView.getTag();
        }
        bbsjumpHolder.titletextView.setText(list.get(position).getTitle());
        bbsjumpHolder.authertextview.setText(list.get(position).getAuthor());
        return convertView;
    }
}
class BbsjumpHolder{
    TextView titletextView,authertextview;
}
