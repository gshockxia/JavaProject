package www.xiaaix.com.viewflipperdemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    private ViewFlipper viewFlipper;
    private int[] resId={R.mipmap.chopper,R.mipmap.law,R.mipmap.naruto,R.mipmap.rayleigh};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        viewFlipper=(ViewFlipper)findViewById(R.id.flipper);
        //动态导入的方式为ViewFlipper
        for(int i=0;i<resId.length;i++){
            viewFlipper.addView(getImageView(resId[i]));
        }
        //为ViewFlipper添加动画效果
        viewFlipper.setInAnimation(this,R.anim.left_in);
        viewFlipper.setInAnimation(this,R.anim.left_out);
        viewFlipper.setFlipInterval(3000);
        viewFlipper.startFlipping();
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
