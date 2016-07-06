package www.xiaaix.com.servicedemo;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Intent intent;
    Intent mybind;
    MyBindService service;
    ServiceConnection conn=new ServiceConnection(){

        @Override
        public void onServiceConnected(ComponentName name, IBinder binder) {
            service=((MyBindService.MyBinder)binder).getService();

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doClick(View v){
        switch (v.getId()){
            case R.id.start:
                intent= new Intent(MainActivity.this,MyStartService.class);
                startService(intent);
                break;
            case R.id.stop:
                stopService(intent);
                break;
            case R.id.play:
                service.play();
                break;
            case R.id.pause:
                service.Pause();
                break;
            case R.id.up:
                service.Previous();
                break;
            case R.id.next:
                service.next();
                break;
            case R.id.bind:
                 mybind=new Intent(MainActivity.this,MyBindService.class);
                bindService(mybind,conn,Service.BIND_AUTO_CREATE);
                break;
            case R.id.unbind:
                unbindService(conn);
                break;
        }

    }
}
