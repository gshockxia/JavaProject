package www.xiaaix.com.shareddemo;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etUserName,etUserPass;
    CheckBox chk;
    SharedPreferences pref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*SharedPreferences pref= PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        SharedPreferences pref=getSharedPreferences("myPref",MODE_PRIVATE);
        SharedPreferences.Editor editor=pref.edit();
        editor.putString("name","张三");
        editor.putInt("age",30);
        editor.putLong("time",System.currentTimeMillis());
        editor.putBoolean("default",true);
        editor.commit();
        editor.remove("default");
        editor.commit();
        System.out.println(pref.getString("name",""));
        System.out.println(pref.getInt("age",0));*/
        etUserName=(EditText)findViewById(R.id.etuserName);
        etUserPass=(EditText)findViewById(R.id.password);
        chk=(CheckBox)findViewById(R.id.chkSaveName);
        pref=getSharedPreferences("UesrInfo",MODE_PRIVATE);
        editor=pref.edit();
        pref.getString("userName","");
        String name=pref.getString("userName","");
        if(name==null){
            chk.setChecked(false);
        }else {
            chk.setChecked(true);
            etUserName.setText(name);

        }

    }

    public void doClick(View v){
        switch(v.getId()){
            case R.id.btnLogin:
                String name=etUserName.getText().toString().trim();
                String password=etUserName.getText().toString().trim();
                if("admin".equals(name)&&"123456".equals(password)){
                    if(chk.isChecked()){
                        editor.putString("userName",name);
                        editor.commit();
                    }else{
                        editor.remove("userName");
                        editor.commit();
                    }
                    Toast.makeText(MainActivity.this,"登录成功",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this,"禁止登录",Toast.LENGTH_LONG).show();
                }
        }
    }
}
