package com.example.bankservicedemo.actions.interfaces;

public interface IBankBossAction extends IBankWorkerAction {
    //修改用户的账户金额
    void modifyUserAccountMoney(float money);
}
