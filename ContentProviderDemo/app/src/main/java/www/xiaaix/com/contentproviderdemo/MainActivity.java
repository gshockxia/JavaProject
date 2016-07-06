package www.xiaaix.com.contentproviderdemo;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ContentResolver cr=getContentResolver();
        Cursor c=cr.query(ContactsContract.Contacts.CONTENT_URI,new String[]{ContactsContract.Contacts._ID,ContactsContract.Contacts.DISPLAY_NAME},null,null,null);
        if(c!=null){
            while (c.moveToNext()){
                c.getInt(c.getColumnIndex("_id"));
                Log.i("info","_id:+id");
                Log.i("info","name:"+c.getString(c.getColumnIndex("display+name")));

            }
        }
    }

}
