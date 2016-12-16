package com.enping.codepath_persistence_sample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Chjeng-Lun SHIEH on 2016/12/14.
 */
public class SQLiteStorageImpl extends SQLiteOpenHelper implements PersistenceStorage {

    private static final String TABLE_NAME = "todolist";
    private static final int DB_VERSION = 1;

    //Column 0
    private static final String KEY_ID = "id";

    //Column 1
    private static final String COLUMN_ITEM = "item";

    public SQLiteStorageImpl(Context context){
        this(context,TABLE_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE " + TABLE_NAME + " (" +
                    KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_ITEM + " TEXT NOT NULL) "
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    private SQLiteStorageImpl(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void addItem(String item) {
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_ITEM,item);
        getWritableDatabase().insert(TABLE_NAME, null, cv);
        Log.d("Storage","Add: "+item);
    }

    @Override
    public void removeItem(String item) {
        getWritableDatabase().delete(TABLE_NAME,COLUMN_ITEM+"=?",new String[]{item});
        Log.d("Storage","Remove: "+item);
    }

    @Override
    public List<String> getItems() {
        List<String> result = new ArrayList<>();
        Cursor cursor = getReadableDatabase().query(TABLE_NAME, null, null, null, null, null, null, null);

        while (cursor.moveToNext()) {
            result.add(cursor.getString(1));
        }

        cursor.close();
        Log.d("Storage","Get: "+result);
        return result;
    }
}
