package com.example.bankservicedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    //普通用户被点击了
    public void normalUserClick(View view){
        Intent intent=new Intent(this,NormalUserActivity.class);
        startActivity(intent);
    }

    //银行工作人员被点击了
    public void bankWorkerUser(View view){
        Intent intent=new Intent(this,BankWorkerActivity.class);
        startActivity(intent);
    }

    //老板按钮被点击了
    public void bankBossUser(View view){
        Intent intent=new Intent(this,BankBossActivity.class);
        startActivity(intent);
    }
}
