package com.enping.codepath_persistence_sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemLongClickListener {

    private ListView lvItemList;
    private ArrayList<String> itemList;
    private ArrayAdapter<String> adapter;
    private EditText etItem;
    private PersistenceStorage persistenceStorage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        persistenceStorage = new SharedPrefStorageImpl(getBaseContext());
        persistenceStorage = new FileStorageImpl(getBaseContext());

        lvItemList = (ListView) findViewById(R.id.lvItemList);
        etItem = (EditText) findViewById(R.id.etItem);
        itemList = new ArrayList<>();
        itemList.addAll(persistenceStorage.getItems());

        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,itemList);
        lvItemList.setAdapter(adapter);
        lvItemList.setOnItemLongClickListener(this);

    }

    public void addItem(View view) {
        if(!TextUtils.isEmpty(etItem.getText())){
            String item = etItem.getText().toString();
            persistenceStorage.addItem(item);
            adapter.add(item);
            etItem.setText("");
        }
    }


    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        persistenceStorage.removeItem(itemList.get(position));
        adapter.remove(itemList.get(position));
        return true;
    }
}
