package www.xiaaix.com.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Monster on 2016/4/27.
 */
public class MyBindService extends Service{
    @Override
    public void onCreate() {
        Log.i("info","BindService--onCreate");
        super.onCreate();
    }

    public class MyBinder extends Binder{
        public MyBindService getService(){
            return MyBindService.this;
        }
    }

    @Override
    public void unbindService(ServiceConnection conn) {
        Log.i("info","BindService--unbindService");
        super.unbindService(conn);
    }

    @Override
    public void onDestroy() {
        Log.i("info","BindService--onDestroy");
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i("info","BindService--onBind");
        return new MyBinder();
    }
    public void play(){
        Log.i("info","播放");
    }
    public void Pause(){
        Log.i("info","暂停");
    }
    public void Previous(){
        Log.i("info","上一首");
    }
    public void next(){
        Log.i("info","下一步");
    }
}
