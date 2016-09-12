package www.xiaaix.com.providertest;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;


/**
 * Created by Monster on 2016/9/6.
 */
public class MyProvider extends ContentProvider {

    public static final int TABLE1_DIR=0;

    public static final int TABLE1_ITEM=1;

    public static final int TABLE2_DIR=2;

    public static final int TABLE2_ITEM=3;

    public static UriMatcher uriMatcher;

    static {
        uriMatcher=new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI("com.example.app.provider","table1",TABLE1_DIR);
        uriMatcher.addURI("com.example.app.provider","table1/#",TABLE1_DIR);
        uriMatcher.addURI("com.example.app.provider","table2",TABLE1_DIR);
        uriMatcher.addURI("com.example.app.provider","table2/#",TABLE1_DIR);
    }





    @Override
    public boolean onCreate() {
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
       switch (uriMatcher.match(uri)){
           case TABLE1_DIR:
               break;
           case TABLE1_ITEM:
               break;
           case TABLE2_DIR:
               break;
           case TABLE2_ITEM:
               break;
           default:
               break;
       }
        return null;
    }


    @Override
    public String getType(Uri uri) {

        return null;

    }


    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
