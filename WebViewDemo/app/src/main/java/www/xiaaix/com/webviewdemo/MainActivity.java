package www.xiaaix.com.webviewdemo;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String url="http://www.ithome.com";
    private WebView webView;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web);

        /*Uri uri=Uri.parse(url);
        Intent intent=new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);*/
        init();

    }

    private void init(){
        webView=(WebView)findViewById(R.id.webView);
        //webView.loadUrl("file:///android_asset/example.html");
        webView.loadUrl(url);

        webView.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
            //WebViewClient帮助WebView去处理一下页面控制和通知
        });
        //启用支持JavaScript
        WebSettings settings=webView.getSettings();
        settings.setJavaScriptEnabled(true);

        //WebView加载页面优先使用缓存加载
        settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                //newProgress 1-100之间的整数
                if(newProgress==100){
                    closeDialog();

                }
                else
                {
                    openDialog(newProgress);
                }
            }

            private void closeDialog(){
                if(dialog!=null&&dialog.isShowing())
                {
                    dialog.dismiss();
                    dialog=null;

                }

            }

            private void openDialog(int newProgress){
                if(dialog==null)
                {
                    dialog=new ProgressDialog(MainActivity.this);
                    dialog.setTitle("正在加载");
                    dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                    dialog.setProgress(newProgress);
                    dialog.show();
                }
                else
                {
                    dialog.setProgress(newProgress);
                }

            }
        });

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK)
        {
            Toast.makeText(this,webView.getUrl(),Toast.LENGTH_SHORT).show();
            if(webView.canGoBack()){
                webView.goBack();
                return true;
                //返回上一级界面
            }
            else
            {
                System.exit(0);
            }

        }
        return super.onKeyDown(keyCode, event);
    }
}
