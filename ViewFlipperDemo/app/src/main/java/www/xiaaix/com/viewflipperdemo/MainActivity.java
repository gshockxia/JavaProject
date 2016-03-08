package www.xiaaix.com.viewflipperdemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    private float startX;
    private ViewFlipper viewFlipper;
    private int[] resId={R.mipmap.chopper,R.mipmap.law,R.mipmap.naruto,R.mipmap.rayleigh};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewFlipper=(ViewFlipper)findViewById(R.id.flipper);
        //动态导入的方式为ViewFlipper
        for(int i=0;i<resId.length;i++){
            viewFlipper.addView(getImageView(resId[i]));
        }
        //为ViewFlipper添加动画效果
       // viewFlipper.setInAnimation(this,R.anim.left_in);
       // viewFlipper.setInAnimation(this,R.anim.left_out);
       // viewFlipper.setFlipInterval(3000);
       // viewFlipper.startFlipping();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                startX = event.getX();

                break;
            }
            case MotionEvent.ACTION_MOVE: {
                if (event.getX() - startX > 100) {
                    viewFlipper.setInAnimation(this, R.anim.left_in);
                    viewFlipper.setOutAnimation(this, R.anim.left_out);
                    viewFlipper.showPrevious();//显示前一页
                }
                if (startX - event.getX() > 100) {
                    viewFlipper.setInAnimation(this, R.anim.right_in);
                    viewFlipper.setOutAnimation(this, R.anim.right_out);
                    viewFlipper.showNext();//显示前一页

                }
                break;
            }
            case MotionEvent.ACTION_UP: {
                break;
            }
        }
        return super.onTouchEvent(event);
    }

    private ImageView getImageView(int resId){
        ImageView image=new ImageView(this);
        //image.setImageResource(resId);
        image.setBackgroundResource(resId);
        return image;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
