package com.example.bankservicedemo.actions.interfaces;

public interface INormalUserAction {
    //存钱,需要有参数传进来
    void saveMoney(float money);

    //取钱，需要有返回值
    float getMoney();

    //贷款，需要有返回值
    float loanMoney();
}
