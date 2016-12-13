package com.enping.codepath_persistence_sample;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chjeng-Lun SHIEH on 2016/12/14.
 */
public class SharedPrefStorageImpl implements PersistenceStorage {

    public SharedPrefStorageImpl(Context baseContext) {

    }

    @Override
    public void addItem(String item) {
        Log.d("Storage","Add: "+item);
    }

    @Override
    public void removeItem(String item) {
        Log.d("Storage","Remove: "+item);

    }

    @Override
    public List<String> getItems() {

        Log.d("Storage","Get ");
        return new ArrayList<>();
    }
}
