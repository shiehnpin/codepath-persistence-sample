package com.enping.codepath_persistence_sample;

import android.content.Context;
import android.util.Log;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Chjeng-Lun SHIEH on 2016/12/14.
 */
public class FileStorageImpl implements PersistenceStorage {
    private final Context context;

    public FileStorageImpl(Context baseContext) {
        this.context = baseContext;
    }

    @Override
    public List<String> getItems() {
        File filesDir = context.getFilesDir();
        File todoFile = new File(filesDir,"todo.txt");
        ArrayList<String> items;
        try {
            items = new ArrayList<>(FileUtils.readLines(todoFile));
        } catch (IOException e) {
            items = new ArrayList<>();
        }

        Log.d("Storage","Get: "+items);
        return items;
    }

    @Override
    public void addItem(String item) {
        List<String> items = getItems();
        items.add(item);
        writeItems(items);
        Log.d("Storage","Add: "+item);
    }

    @Override
    public void removeItem(String item) {
        List<String> items = getItems();
        items.remove(item);
        writeItems(items);
        Log.d("Storage","Remove: "+item);
    }


    private void writeItems(List<String> items){
        File filesDir = context.getFilesDir();
        File todoFile = new File(filesDir,"todo.txt");
        try {
            FileUtils.writeLines(todoFile,items);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
