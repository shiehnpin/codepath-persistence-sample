package com.enping.codepath_persistence_sample;

import java.util.List;

/**
 * Created by Chjeng-Lun SHIEH on 2016/12/14.
 */
public interface PersistenceStorage {
    void addItem(String item);
    void removeItem(String item);
    List<String> getItems();
}
