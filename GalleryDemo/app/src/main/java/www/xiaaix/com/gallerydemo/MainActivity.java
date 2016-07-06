package www.xiaaix.com.gallerydemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener,ViewSwitcher.ViewFactory{

    private Gallery gallery;

    private ImageSwitcher imageSwitcher;

    private ImageAdapter adapter;

    private int[] res={R.mipmap.item1,R.mipmap.item2,R.mipmap.item3,R.mipmap.item4,R.mipmap.item5,R.mipmap.item6,R.mipmap.item7,R.mipmap.item8,R.mipmap.item9,R.mipmap.item10,R.mipmap.item11,R.mipmap.item12};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        gallery=(Gallery)findViewById(R.id.gallery);
        adapter=new ImageAdapter(res,this);
        gallery.setAdapter(adapter);
        gallery.setOnItemSelectedListener(this);
        imageSwitcher=(ImageSwitcher)findViewById(R.id.imageswitch);
        imageSwitcher.setFactory(this);
        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_in));
        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_out));
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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //image.setBackgroundResource(res[position%res.length]);
        imageSwitcher.setBackgroundResource(res[position%res.length]);


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public View makeView() {
        ImageView image=new ImageView(this);
        image.setScaleType(ImageView.ScaleType.FIT_CENTER);
        return image;
    }
}
