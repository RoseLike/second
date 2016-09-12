package com.example.hcc.mysecondproject;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.New.MyNewfragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/8.
 */
public class Newfragmentpager extends Fragment implements RadioGroup.OnCheckedChangeListener, ViewPager.OnPageChangeListener {
    ViewPager viewPager;
    List<Fragment>newlist;
    RadioGroup radioGroup;
    View hdview;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.newviewpager_layout,null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager= (ViewPager) view.findViewById(R.id.new_viewpagerId);
        radioGroup= (RadioGroup) view.findViewById(R.id.new_radiogroupId);
        hdview=view.findViewById(R.id.new_navigatioonId);
        radioGroup.setOnCheckedChangeListener(this);
        intiData();
        MyfragmentAdapter myfragmentAdapter=new MyfragmentAdapter(getChildFragmentManager(),newlist);
        viewPager.setAdapter(myfragmentAdapter);
        viewPager.setOnPageChangeListener(this);
    }

    private void intiData() {
        newlist=new ArrayList<>();
        newlist.add(new MyNewfragment().getInstance("http://api.fengniao.com/app_ipad/news_jingxuan.php?appImei=000000000000000&osType=Android&osVersion=4.1.1&page="));
//        newlist.add(new MyQicaifragment().getInstance("http://api.fengniao.com/app_ipad/news_list.php?appImei=000000000000000&osType=Android&osVersion=4.1.1&cid=296&page="));
//        newlist.add(new MyVideofragment().getInstance("http://api.fengniao.com/app_ipad/news_list.php?appImei=000000000000000&osType=Android&osVersion=4.1.1&cid=192&page="));
//        newlist.add(new MySchoolfragment().getInstance("http://api.fengniao.com/app_ipad/news_list.php?appImei=000000000000000&osType=Android&osVersion=4.1.1&cid=190&page="));
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.new1_radiobuttonId:
                viewPager.setCurrentItem(0);
                break;
            case R.id.new2_radiobuttonId:
                viewPager.setCurrentItem(1);
                break;
            case R.id.new3_radiobuttonId:
                viewPager.setCurrentItem(2);
                break;
            case R.id.new4_radiobuttonId:
                viewPager.setCurrentItem(3);
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        LinearLayout.LayoutParams params=
                (LinearLayout.LayoutParams) hdview.getLayoutParams();
        params.leftMargin=(int) ((position+positionOffset)
                *hdview.getWidth());
        hdview.setLayoutParams(params);
    }

    @Override
    public void onPageSelected(int position) {
        RadioButton button;
        for (int i = 0; i < radioGroup.getChildCount(); i++) {
            button=(RadioButton) radioGroup.getChildAt(i);
            //如果为当前选择，改变字体颜色，不是的话修改为原始颜色
            if (i==position) {
                button.setTextColor(Color.BLUE);
            }else {
                button.setTextColor(Color.BLACK);
            }

        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

}
