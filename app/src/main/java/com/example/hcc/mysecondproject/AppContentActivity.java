package com.example.hcc.mysecondproject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

public class AppContentActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener, View.OnTouchListener {
    ViewPager viewPager;
    List<Fragment> list=new ArrayList<>();
    RadioGroup radioGroup;
    MyfragmentAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_content);
        viewPager = (ViewPager) findViewById(R.id.viewpagerId);
        initDataContent();
        adapter=new MyfragmentAdapter(getSupportFragmentManager(),list);
        viewPager.setAdapter(adapter);
        radioGroup = (RadioGroup) findViewById(R.id.radiogroupId);
        radioGroup.setOnCheckedChangeListener(this);
        viewPager.setOnTouchListener(this);
    }

    private void initDataContent() {
        list.add(new Newfragmentpager());
        list.add(new Picturefragmentpager());
        list.add(new Bbsfragmentpager());
        list.add(new Settingfragmentpager());

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radiobuttonId:
                      viewPager.setCurrentItem(0);
                        break;
                    case R.id.radiobuttonId2:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.radiobuttonId3:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.radiobuttonId4:
                        viewPager.setCurrentItem(3);
                        break;

        }

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return true;
    }
}

