package www.xiaaix.com.scrollviewdemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textView=(TextView)findViewById(R.id.content);
        textView.setText(getResources().getString(R.string.content));
        scrollView=(ScrollView)findViewById(R.id.scrollView);
        scrollView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_MOVE:
                    {
                        if(scrollView.getScaleY()<=0)
                        {
                            Log.i("Main","滑动到顶部");
                        }

                        if(scrollView.getChildAt(0).getMeasuredHeight()<=scrollView.getHeight()+scrollView.getScaleY())
                        {
                            Log.i("Main","滑动到底部");
                            Log.i("Main","scrollView.getChildAt(0).getMeasuredHeight()="+scrollView.getChildAt(0).getMeasuredHeight()+"scrollView.getHeight()="+scrollView.getHeight()+"scrollView.getScaleY()="+scrollView.getScaleY());
                        }
                        break;
                    }

                }
                return false;
            }
        });

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
