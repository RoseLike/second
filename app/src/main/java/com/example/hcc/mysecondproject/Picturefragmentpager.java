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

import com.person.MyPersonfragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/8.
 */
public class Picturefragmentpager extends Fragment implements RadioGroup.OnCheckedChangeListener, ViewPager.OnPageChangeListener {
    ViewPager viewPager;
    List<Fragment> picturelist;
    RadioGroup radioGroup;
    View navigationView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.picturepager_layout,null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager= (ViewPager) view.findViewById(R.id.pic_viewpagerId);
        radioGroup= (RadioGroup) view.findViewById(R.id.pic_radiogroupId);
        navigationView=view.findViewById(R.id.pic_navigatioonId);
        radioGroup.setOnCheckedChangeListener(this);
        intiData();
        MyfragmentAdapter myfragmentAdapter=new MyfragmentAdapter(getChildFragmentManager(),picturelist);
        viewPager.setAdapter(myfragmentAdapter);
        viewPager.setOnPageChangeListener(this);
    }

    private void intiData() {
        picturelist=new ArrayList<>();
        picturelist.add(new MyPersonfragment().getInstance("http://api.fengniao.com/app_ipad/pic_bbs_list_v2.php?appImei=000000000000000&osType=Android&osVersion=4.1.1&fid=101&page="));
//        picturelist.add(new MySightfragment().getInstance("http://api.fengniao.com/app_ipad/pic_bbs_list_v2.php?appImei=000000000000000&osType=Android&osVersion=4.1.1&fid=125&page="));
//        picturelist.add(new MyEnvirfragment().getInstance("http://api.fengniao.com/app_ipad/pic_bbs_list_v2.php?appImei=000000000000000&osType=Android&osVersion=4.1.1&fid=16&page="));
//        picturelist.add(new MyCamerafragment().getInstance("http://api.fengniao.com//app_ipad/pic_bbs_list_v2.php?appImei=000000000000000&osType=Android&osVersion=4.1.1&fid=24&page="));
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.pic1_radiobuttonId:
                viewPager.setCurrentItem(0);
                break;
            case R.id.pic2_radiobuttonId:
                viewPager.setCurrentItem(1);
                break;
            case R.id.pic3_radiobuttonId:
                viewPager.setCurrentItem(2);
                break;
            case R.id.pic4_radiobuttonId:
                viewPager.setCurrentItem(3);
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        LinearLayout.LayoutParams params=
                (LinearLayout.LayoutParams) navigationView.getLayoutParams();
        params.leftMargin=(int) ((position+positionOffset)
                *navigationView.getWidth());
        navigationView.setLayoutParams(params);
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
