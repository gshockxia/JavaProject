package www.xiaaix.com.acitvitylifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

/**
 * Created by Monster on 2016/6/27.
 */
public class NormalActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.normal_layout);
    }
}
