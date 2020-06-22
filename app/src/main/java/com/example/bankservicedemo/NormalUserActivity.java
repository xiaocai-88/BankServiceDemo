package com.example.bankservicedemo;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class NormalUserActivity extends AppCompatActivity {

    private NormalUserConnection mNormalUserConnection; //设为成员变量，等会需要解绑服务的
    private String TAG="NormalUserActivity";
    private boolean isBind;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_user);
        dobindService();
    }

    //绑定服务
    private void dobindService() {
       // Log.d("NormalUserActivity","绑定服务,dobindService......");
        Intent intent=new Intent();  //此处已经不能通过显示意图来进行绑定了，因为已经声明了隐式意图，在bindservice中已经通过action来返回了一个实现类了
        intent.setAction("com.example.bankservicedemo.ACTION_NORMAL_USER");       //通过setaction来绑定
        intent.addCategory(Intent.CATEGORY_DEFAULT);  //若想接收一个隐式的activity，都应该包括该语句，不然会导致intent匹配失败
        intent.setPackage("com.example.bankservicedemo");

        //实例化，设为成员变量，方便service的绑定和解绑
        mNormalUserConnection = new NormalUserConnection();

        //根据bindservice中方法去构建intent、connection
        isBind = bindService(intent, mNormalUserConnection,BIND_AUTO_CREATE);
        // BIND_AUTO_CREATE指服务没有被创建的情况下被绑定，则service会自动创建
    }

    public class NormalUserConnection implements ServiceConnection{

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d(TAG, "onServiceConnected..." );
            //利用接口进行一个转换,作为参数传入,设为成员变量方便调用
            mNormalUserAction =NormalUserAction.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d(TAG,"onServiceDisconnected..."+name);
        }
    }
    private NormalUserAction mNormalUserAction;

    public void saveMoneyClick(View view){
        Log.d(TAG,"saveMoneyClick...");
        try {
            mNormalUserAction.saveMoney(200);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void getMoneyClick(View view){
        Log.d(TAG,"getMoneyClick...");
        try {
            float money=mNormalUserAction.getMoney();
            Log.d(TAG,"money is "+money);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }
//
//    public void loanMoneyClick(View view){
//        Log.d(TAG,"loanMoneyClick...");
//    }


    //一定要解绑服务，不然会导致context泄漏
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //保险起见，解绑的时候进行一个判断,如果已经绑定了且normalUserConnection中不为空就可以正常解绑
        if(isBind && (mNormalUserConnection!=null)){
            unbindService(mNormalUserConnection);
            Log.d(TAG,"unbind service......");
            mNormalUserConnection=null;    //置空，释放资源
            isBind=false;               //此时已经不支持绑定了
        }
    }
}
