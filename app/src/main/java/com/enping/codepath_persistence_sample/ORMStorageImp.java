package com.enping.codepath_persistence_sample;

import android.util.Log;
import com.raizlabs.android.dbflow.sql.language.Select;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by i_enpinghsieh on 2016/12/15.
 */
public class ORMStorageImp implements PersistenceStorage {

    public ORMStorageImp() {

    }

    @Override
    public void addItem(String item) {
        new TodoItem(item).save();
        Log.d("Storage","Add: "+item);
    }

    @Override
    public void removeItem(String item) {
        new TodoItem(item).delete();
        Log.d("Storage","Remove: "+item);
    }

    @Override
    public List<String> getItems() {
        List<TodoItem> list = new Select().from(TodoItem.class).where().queryList();
        ArrayList<String> items = new ArrayList<>(list.size());
        for(TodoItem item :list){
            items.add(item.getItem());
        }

        Log.d("Storage","Get: "+items);
        return items;
    }
}
