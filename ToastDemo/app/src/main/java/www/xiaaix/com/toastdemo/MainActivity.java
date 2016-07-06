package www.xiaaix.com.toastdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initEvent();
    }

    private void initEvent(){
        findViewById(R.id.toast_btn4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast4();
            }
        });

    }

    private void showToast1(){
        Toast toast=Toast.makeText(this,R.string.app_name,Toast.LENGTH_SHORT);
        toast.show();
    }

    private void showToast2(){
        Toast toast=Toast.makeText(this,"改变位置的Toast",Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
    }

    private void showToast3(){
        Toast toast=Toast.makeText(this,"带有图片Toast",Toast.LENGTH_SHORT);
        LinearLayout toast_layout=(LinearLayout)toast.getView();
        ImageView iv=new ImageView(this);
        iv.setImageResource(R.mipmap.ic_launcher);
        toast_layout.addView(iv,0);
        toast.show();
    }

    private void showToast4(){
        LayoutInflater inflater= LayoutInflater.from(this);
        View toast_view=inflater.inflate(R.layout.toast_layout,null);
        Toast toast=new Toast(this);
        toast.setView(toast_view);
        toast.show();
    }

}
