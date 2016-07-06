package www.xiaaix.com.gesturedetectordemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView img;
    GestureDetector gestureDetector;

    class myGestureListener extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if(e1.getX()-e2.getX()>50){
                Toast.makeText(MainActivity.this,"从右往左滑动！",Toast.LENGTH_SHORT).show();

            }else if(e2.getX()-e1.getX()>50){
                Toast.makeText(MainActivity.this,"从左往右滑动！",Toast.LENGTH_SHORT).show();

            }
            return super.onFling(e1, e2, velocityX, velocityY);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img=(ImageView)findViewById(R.id.img);
        gestureDetector=new GestureDetector(new myGestureListener());
        img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDetector.onTouchEvent(event);
                return true;
            }
        });
    }
}
