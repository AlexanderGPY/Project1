package com.example.text1;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.support.v7.app.ActionBar;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button btn1;
    private TextView text2;
    private TextView text3;
    private RadioGroup rg1;
    private RadioGroup rg2;
    private EditText et3;
    private EditText et6;
    private Button btn4;
    private int i = 0;
    private int j = 0;
    private int k = 0;
    private int kind = 0;
    private int[] kind1 = new int[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //左上角返回按钮
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        btn1 = (Button) findViewById(R.id.button1);
        text2 = (TextView) findViewById(R.id.textView2);
        rg1 = (RadioGroup) findViewById(R.id.rg1);
        et3 = (EditText) findViewById(R.id.et3);
        text3 = (TextView)findViewById(R.id.textView7);
        Intent in = getIntent();
        String name = in.getStringExtra("name");
        text3.setText(name);
        kind1[k++] = 0;
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, final int checkedId) {
                if (checkedId == R.id.radioButton1) {
                    i = 0;
                    j = 0;
                    kind = 0;
                    kind1[k++] = kind;
                    text2.setText("数小牛睡觉觉！");
                } else if (checkedId == R.id.radioButton2) {
                    i = 0;
                    j = 0;
                    kind = 1;
                    kind1[k++] = kind;
                    text2.setText("数绵羊睡觉觉！");
                } else {
                    i = 0;
                    j = 0;
                    kind = 2;
                    kind1[k++] = kind;
                    text2.setText("数小猪睡觉觉！");
                }
            }

        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int min = 1;
                int max = 190;
                Random random = new Random();
                int red = random.nextInt(max) % (max - min + 1) + min;
                int green = random.nextInt(max) % (max - min + 1) + min;
                int blue = random.nextInt(max) % (max - min + 1) + min;
                i++;
                if (et3.getText().toString().trim().equals("")&& (kind != 4)) {
                    if (kind==0)
                        text2.setText(i + "只牛！");
                    else if (kind==1)
                        text2.setText(i + "只羊！");
                    else if(kind == 2)
                        text2.setText(i + "只猪！");
                }else{
                    kind = 4;
                    j++;
                    String s1 = et3.getText().toString();
                    if(s1.equals("")){
                        i = 1;
                        kind = kind1[k-1];
                        if(kind == 0)
                            text2.setText(i + "只牛！");
                        else if (kind==1)
                            text2.setText(i + "只羊！");
                        else if(kind == 2)
                            text2.setText(i + "只猪！");
                    }
                    else
                       text2.setText(j + "只"+s1+"！");
                }

                ToastUtil.newToast(MainActivity.this, "您已经点击了" + i + "次！");
                text2.setTextColor(Color.rgb(red, green, blue));
            }
        });
        btn4 = (Button) findViewById(R.id.baidu);
        et6 = (EditText) findViewById(R.id.et6);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ss= et6.getText().toString();
                Intent in = new Intent();
                in.setAction("android.intent.action.VIEW");
                in.setData(Uri.parse("http://www.baidu.com/s?wd="+ss));
                startActivity(in);
            }
        });
    }


        public void Click2 (View v){
            String s1 = et3.getText().toString();
            if (kind == 0)
                text2.setText("数小牛睡觉觉！");
            else if (kind == 1)
                text2.setText("数绵羊睡觉觉！");
            else if(kind ==2)
                text2.setText("数小猪睡觉觉！");
            else
                text2.setText( "数"+s1+"睡觉觉！");

            ToastUtil.newToast(MainActivity.this, "已清零");
            i = 0;
            j = 0;
            text2.setTextColor(Color.BLACK);
        }


    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

