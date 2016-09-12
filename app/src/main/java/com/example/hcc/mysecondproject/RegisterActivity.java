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

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    Button button;
    EditText editText, editText2, editText3;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String name = null;
    String password = null;
    String emall = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        button = (Button) findViewById(R.id.submitId);
        editText = (EditText) findViewById(R.id.reguserId);
        editText2 = (EditText) findViewById(R.id.regpasswordId);
        editText3 = (EditText) findViewById(R.id.regemallId);
        sharedPreferences = getSharedPreferences("user_info", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        button.setOnClickListener(this);
    }

    String[] emalls = {"@qq.com", "@163.com", "@126.com", "@sina.com", "@sohu.com"};

    @Override
    public void onClick(View v) {
        name = editText.getText().toString();
        password = editText2.getText().toString();
        emall = editText3.getText().toString();
        if (name.length() > 4 && name.length() < 14) {
            if (password.length() > 6 && password.length() < 16) {
//                for (int i = 0; i < emalls.length; i++) {
//                    String str = emall.substring(emalls.length - 4, emalls.length - 1);
//                    if (str.equals(emalls[i])) {
                        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(password) && !TextUtils.isEmpty(emall)) {
                            editor.putString("name", name);
                            editor.putString("password", password);
                            editor.putString("emall", emall);
                            editor.commit();
                            Toast.makeText(getApplicationContext(), "注册成功", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent("com.he.ccc");
                            startActivity(intent);
                            this.finish();
                        } else {
                            Toast.makeText(getApplicationContext(), "用户名或密码或邮箱不能为空", Toast.LENGTH_SHORT).show();
//                        }
//                    } else {
//                        Toast.makeText(getApplicationContext(), "邮箱格式错误", Toast.LENGTH_SHORT).show();
//                    }
                }

            } else {
                Toast.makeText(getApplicationContext(), "密码格式错误", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getApplicationContext(), "用户名格式错误", Toast.LENGTH_SHORT).show();
        }

    }
}
