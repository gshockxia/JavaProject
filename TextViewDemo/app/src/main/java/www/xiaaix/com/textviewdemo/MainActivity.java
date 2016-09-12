package www.xiaaix.com.textviewdemo;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText editText;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.button);
        editText=(EditText)findViewById(R.id.edit_text);
        progressBar=(ProgressBar)findViewById(R.id.progressbar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.button:
                        ProgressDialog progressDialog=new ProgressDialog(MainActivity.this);
                        progressDialog.setTitle("This is ProgressDialog");
                        progressDialog.setMessage("Loading...");
                        progressDialog.setCancelable(true);
                        progressDialog.show();
                        /*AlertDialog.Builder dialog=new AlertDialog.Builder(MainActivity.this);
                        dialog.setTitle("This is Dialog");
                        dialog.setMessage("Something important.");
                        dialog.setCancelable(false);
                        dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        dialog.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        dialog.show();*/
                        /*int progress=progressBar.getProgress();
                        progress=progress+10;
                        progressBar.setProgress(progress);*/
                        /*if(progressBar.getVisibility()==View.GONE){
                            progressBar.setVisibility(View.VISIBLE);
                        }else{
                            progressBar.setVisibility(View.GONE);
                        }*/
                        break;
                    default:
                        break;
                }
                /*String inputText= editText.getText().toString();
                Toast.makeText(MainActivity.this,inputText,Toast.LENGTH_LONG).show();*/
            }
        });
    }
}
