package com.enping.codepath_persistence_sample;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by i_enpinghsieh on 2016/12/15.
 */
@Table(database = TodoListDatabase.class)
public class TodoItem extends BaseModel {

    @Column
    @PrimaryKey
    String item;

    public TodoItem() {
    }

    public TodoItem(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
