package com.enping.codepath_persistence_sample;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SharedPrefStorageImpl implements PersistenceStorage {

    private final Context context;

    public SharedPrefStorageImpl(Context context) {
        this.context = context;
    }

    @Override
    public List<String> getItems() {
        Set<String> items = context
                .getSharedPreferences("todoList", Context.MODE_PRIVATE)
                .getStringSet("items", new HashSet<String>());
        Log.d("Storage","Get: "+items);
        return new ArrayList<>(items);
    }

    @Override
    public void addItem(String item) {
        List<String> items = getItems();
        items.add(item);
        context.getSharedPreferences("todoList",Context.MODE_PRIVATE)
                .edit()
                .putStringSet("items",new HashSet<>(items))
                .apply();
        Log.d("Storage","Add: "+item);
    }

    @Override
    public void removeItem(String item) {
        List<String> items = getItems();
        items.remove(item);
        context.getSharedPreferences("todoList",Context.MODE_PRIVATE)
                .edit()
                .putStringSet("items",new HashSet<>(items))
                .apply();
        Log.d("Storage","Remove: "+item);
    }
}
