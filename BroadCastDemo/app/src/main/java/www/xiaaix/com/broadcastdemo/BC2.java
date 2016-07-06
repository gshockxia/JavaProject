package www.xiaaix.com.broadcastdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Monster on 2016/5/18.
 */
public class BC2 extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        String s=intent.getStringExtra("msg");
        System.out.println("receiver2收到消息"+s);
        Bundle bundle=getResultExtras(true);
        String s2=bundle.getString("test");
        System.out.println("得到的数据结果是"+s2);

    }
}
