package www.xiaaix.com.filedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*File file=new File("/mnt/sdcard/test.txt");
        System.out.println("!!!!!!");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            Toast.makeText(MainActivity.this,"文件以及存在", Toast.LENGTH_LONG);
        }
        file.delete();*/
        File file=this.getFilesDir();

        Log.i("info",file.toString());
    }
}
