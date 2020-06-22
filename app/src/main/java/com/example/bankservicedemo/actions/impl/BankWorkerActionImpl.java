package com.example.bankservicedemo.actions.impl;

import android.os.Binder;
import android.util.Log;
import android.widget.BaseAdapter;

import com.example.bankservicedemo.actions.interfaces.IBankWorkerAction;

public class BankWorkerActionImpl extends Binder implements IBankWorkerAction {
    @Override
    public void checkUserCredit() {
        Log.d("BankWorkerActionImpl","check user credit is 790");
    }

    @Override
    public void freezeUserAccount() {
        Log.d("BankWorkerActionImpl","freeze user account is 0");
    }

    @Override
    public void saveMoney(float money) {
        Log.d("BankWorkerActionImpl","save money  "+money);
    }

    @Override
    public float getMoney() {
        Log.d("BankWorkerActionImpl","get money  100.00 ");
        return (float) 100.00;
    }

    @Override
    public float loanMoney() {
        Log.d("BankWorkerActionImpl","loan money 100.00 ");
        return (float) 100.00;
    }
}
