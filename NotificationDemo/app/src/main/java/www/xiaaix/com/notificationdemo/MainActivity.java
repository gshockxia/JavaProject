package www.xiaaix.com.notificationdemo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    NotificationManager manager;
    int notification_ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        findViewById(R.id.btn_send).setOnClickListener(this);
        findViewById(R.id.btn_cancle).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_send:
                sendNotification();
                break;
            case R.id.btn_cancle:
                manager.cancel(notification_ID);
                break;
        }

    }
    private void sendNotification(){
        Intent intent=new Intent(this,MainActivity.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,intent,0);
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setTicker("Hello");//手机状态栏提示
        builder.setWhen(System.currentTimeMillis());
        builder.setContentTitle("通知栏通知");
        builder.setContentText("我来自NotificationDemo");
        builder.setContentIntent(pendingIntent);//点击后的意图
        //builder.setDefaults(NotificationCompat.DEFAULT_SOUND);
        //builder.setDefaults(Notification.DEFAULT_LIGHTS);
        //builder.setDefaults(Notification.DEFAULT_VIBRATE);
        builder.setDefaults(Notification.DEFAULT_ALL);
        Notification notification=builder.build();
        manager.notify(notification_ID,notification);

    }
}
