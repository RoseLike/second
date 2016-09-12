package com.example.hcc.mysecondproject;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/8.
 */
public class Bbsfragmentpager extends Fragment implements AdapterView.OnItemClickListener, RadioGroup.OnCheckedChangeListener {
    ListView listView;
    RadioGroup radioGroup;
    List<String>contentlist=new ArrayList<>();
    ArrayAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.bbspager_layout,null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView= (ListView) view.findViewById(R.id.bbs_listview);
        radioGroup= (RadioGroup) view.findViewById(R.id.bbs_radioGroup);
        radioGroup.setOnCheckedChangeListener(this);
        listView.setOnItemClickListener(this);
        intifirstData();
        adapter=new ArrayAdapter(getActivity(),R.layout.bbs_item,contentlist);
        listView.setAdapter(adapter);
    }

    private void intifirstData() {
        contentlist.add("热帖");
        contentlist.add("精华帖");
        contentlist.add("最新帖子");
        contentlist.add("最新回复");
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent=new Intent();
        intent.setAction("com.bbs.jump");
        getActivity().startActivity(intent);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        RadioButton radiobutton;
        for (int i = 0; i <group.getChildCount() ; i++) {
            radiobutton= (RadioButton) group.getChildAt(i);
            if(checkedId==group.getChildAt(i).getId()){
                radiobutton.setTextColor(Color.BLUE);
            }else{
              radiobutton.setTextColor(Color.BLACK);
            }

        }
        switch (checkedId){
            case R.id.bbs_radiobutton:
                contentlist.clear();
                intifirstData();
                adapter.notifyDataSetChanged();
                break;
            case R.id.bbs2_radiobutton:
                String [] bbs2={"人物","风光","纪实","人体","儿童","建筑","生态","宠物"};
                contentlist.clear();
                for (int i = 0; i < bbs2.length; i++) {
                    contentlist.add(bbs2[i]);
                }
                adapter.notifyDataSetChanged();
                break;
            case R.id.bbs3_radiobutton:
                String [] bbs3={"商业","女性视觉","新手","数码","黑白","实验","生活摄影","高校","手机","葡萄酒"};
                contentlist.clear();
                for (int i = 0; i <bbs3.length ; i++) {
                    contentlist.add(bbs3[i]);
                }
                adapter.notifyDataSetChanged();
                break;
            case R.id.bbs4_radiobutton:
                String [] bbs4={"交易警示","二手交易","器材维修"};
                contentlist.clear();
                for (int i = 0; i <bbs4.length ; i++) {
                    contentlist.add(bbs4[i]);
                }
                adapter.notifyDataSetChanged();
                break;
            case R.id.bbs5_radiobutton:
                String [] bbs5={"北京","上海","武汉"};
                contentlist.clear();
                for (int i = 0; i <bbs5.length ; i++) {
                    contentlist.add(bbs5[i]);
                }
                adapter.notifyDataSetChanged();
                break;
            case R.id.bbs6_radiobutton:
                String [] bbs6={"单反和镜头","大中画幅","便携数码"};
                contentlist.clear();
                for (int i = 0; i <bbs6.length ; i++) {
                    contentlist.add(bbs6[i]);
                }
                adapter.notifyDataSetChanged();
                break;
            case R.id.bbs7_radiobutton:
                String [] bbs7={"活动区","网友服务","蜂鸟茶馆"};
                contentlist.clear();
                for (int i = 0; i <bbs7.length ; i++) {
                    contentlist.add(bbs7[i]);
                }
                adapter.notifyDataSetChanged();
                break;
           default:
            break;
        }
    }
}
