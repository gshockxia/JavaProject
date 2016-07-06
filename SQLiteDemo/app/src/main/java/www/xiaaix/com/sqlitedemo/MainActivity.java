package www.xiaaix.com.sqlitedemo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.renderscript.Type;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SQLiteDatabase db =   openOrCreateDatabase("user.db", MODE_PRIVATE, null);
        db.execSQL("create table if not exists usertb (_id integer primary key autoincrement, name text not null , age integer not null , sex text not null )");
        db.execSQL("insert into usertb(name,sex,age) values('张三','女',18)");
        db.execSQL("insert into usertb(name,sex,age) values('李四','女',19)");
        db.execSQL("insert into usertb(name,sex,age) values('王五','男',20)");
        Cursor cs=db.rawQuery("select * from usertb",null);
        if(cs!=null){
            while (cs.moveToNext()){
                Log.i("info","_id:"+cs.getInt(cs.getColumnIndex("_id")));
                Log.i("info","name:"+cs.getString(cs.getColumnIndex("name")));
                Log.i("info","age:"+cs.getInt(cs.getColumnIndex("age")));
                Log.i("info","sex:"+cs.getString(cs.getColumnIndex("sex")));
                Log.i("info","!!!!!!!!!!!!!!!!!");

            }
            cs.close();
        }
        db.close();
    }
}
