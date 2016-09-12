package com.example.hcc.mysecondproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/9/9.
 */
public class Settingfragmentpager  extends Fragment implements View.OnClickListener {
    TextView textView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.settingpager_layout,null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView= (TextView) view.findViewById(R.id.setting1_textviewId);
        textView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(getActivity(),LoginActivity.class);
        getActivity().startActivity(intent);

    }
}
