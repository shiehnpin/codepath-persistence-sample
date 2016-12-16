package com.enping.codepath_persistence_sample;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by i_enpinghsieh on 2016/12/15.
 */
@Database(name = TodoListDatabase.NAME, version = TodoListDatabase.VERSION)
public class TodoListDatabase {

    public static final String NAME = "TodoORM";

    public static final int VERSION = 1;

}
