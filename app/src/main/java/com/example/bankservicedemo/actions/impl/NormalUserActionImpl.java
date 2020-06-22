package com.example.bankservicedemo.actions.impl;

import android.os.Binder;
import android.util.Log;

import com.example.bankservicedemo.actions.interfaces.INormalUserAction;

public class NormalUserActionImpl  extends Binder implements INormalUserAction {
    @Override
    public void saveMoney(float money) {
        Log.d("NormalUserActionImpl","save money  "+money);
    }

    @Override
    public float getMoney() {
        Log.d("NormalUserActionImpl","get money  100.00 ");
        return (float) 100.00;
    }

    @Override
    public float loanMoney() {
        Log.d("NormalUserActionImpl","loan money 100.00 ");
        return (float) 100.00;
    }
}
