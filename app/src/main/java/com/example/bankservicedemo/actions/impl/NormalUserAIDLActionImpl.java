package com.example.bankservicedemo.actions.impl;


import android.util.Log;

import com.example.bankservicedemo.NormalUserAction;

public class NormalUserAIDLActionImpl extends NormalUserAction.Stub {
    private String TAG ="NormalUserAIDLActionImpl" ;

    @Override
    public void saveMoney(float money){
        Log.d(TAG,"存钱"+money);
    }

    @Override
    public float getMoney(){
        return 100;
    }

}
