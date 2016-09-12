package com.example.hcc.mysecondproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
   EditText usereditText,passwordeditword;
    Button registerbutton,loginbutton;
    String name=null;
    String password=null;
    SharedPreferences sharedPreferences=null;
    SharedPreferences.Editor editor=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usereditText= (EditText) findViewById(R.id.userId);
        passwordeditword= (EditText) findViewById(R.id.passwordId);
        registerbutton= (Button) findViewById(R.id.regiserId);
        loginbutton= (Button) findViewById(R.id.loginId);
        sharedPreferences=getSharedPreferences("user_info",MODE_PRIVATE);
        editor=sharedPreferences.edit();
        registerbutton.setOnClickListener(this);
        loginbutton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        name=usereditText.getText().toString();
        password=passwordeditword.getText().toString();
        switch (v.getId()){
            case R.id.regiserId:
                Intent intent2=new Intent("com.he.register");
                startActivity(intent2);
                break;
            case  R.id.loginId:
                if (!TextUtils.isEmpty(name)&&!TextUtils.isEmpty(password)){
                    if(name.equals(sharedPreferences.getString("name","fengniao"))&&password.equals(sharedPreferences.getString("password","000000"))){
                        Toast.makeText(getApplicationContext(),"登录成功",Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent("com.he.ccc");
                        startActivity(intent);
                        this.finish();
                    } else{
                        Toast.makeText(getApplicationContext(),"账户或密码错误",Toast.LENGTH_SHORT).show();
                    }
                } else{
                    Toast.makeText(getApplicationContext(),"账户或密码不能为空",Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }

    }
}
