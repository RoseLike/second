package com.example.hcc.mysecondproject;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.Downloading.HandloadJson;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class BBsActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView listView;
    String bbsjump="http://api.fengniao.com/app_ipad/bbs_all_hot.php?appImei=000000000000000&osType=Android&osVersion=4.1.1&page=1";
    List<MybbsjumpData.ListBean>bbsjumplist=new ArrayList();
    MybbsjumpAdapter mybbsjumpadapter;
    Handler handler=new Handler(){
       @Override
       public void handleMessage(Message msg) {
           switch (msg.what){
               case 1:
                   String json= (String) msg.obj;
                   Gson gson=new Gson();
                   MybbsjumpData mybbsjumpdata=gson.fromJson(json,MybbsjumpData.class);
                   Log.d("HE","========="+mybbsjumpdata);
                   bbsjumplist.addAll(mybbsjumpdata.getList());
                   mybbsjumpadapter.notifyDataSetChanged();
                   break;
           }

       }
   };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bbs);
        listView= (ListView) findViewById(R.id.bbsjumplistId);
        HandloadJson.downLoadingJson(bbsjump,handler);
        mybbsjumpadapter=new MybbsjumpAdapter(getApplicationContext(),bbsjumplist);
        listView.setAdapter(mybbsjumpadapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent=new Intent();
        intent.setAction("com.he.jump");
        intent.putExtra("url",bbsjumplist.get(position).getWeb_url());
        startActivity(intent);
    }
}
