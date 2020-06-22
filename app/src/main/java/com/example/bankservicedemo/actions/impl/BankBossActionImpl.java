package com.example.bankservicedemo.actions.impl;

import android.os.Binder;
import android.util.Log;

import com.example.bankservicedemo.actions.interfaces.IBankBossAction;

public class BankBossActionImpl extends Binder implements IBankBossAction {
    @Override
    public void modifyUserAccountMoney(float money) {
        Log.d("BankBossActionImpl","modify user acctount  money is  1000000 ");
    }
    @Override
    public void checkUserCredit() {
        Log.d("BankBossActionImpl","check user credit is 790");
    }

    @Override
    public void freezeUserAccount() {
        Log.d("BankBossActionImpl","freeze user account is 0");
    }

    @Override
    public void saveMoney(float money) {
        Log.d("BankBossActionImpl","save money  "+money);
    }

    @Override
    public float getMoney() {
        Log.d("BankBossActionImpl","get money  100.00 ");
        return (float) 100.00;
    }

    @Override
    public float loanMoney() {
        Log.d("BankBossActionImpl","loan money 100.00 ");
        return (float) 100.00;
    }
}
