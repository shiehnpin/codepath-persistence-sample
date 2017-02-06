package com.enping.codepath_persistence_sample;

import java.util.List;

public interface PersistenceStorage {
    void addItem(String item);
    void removeItem(String item);
    List<String> getItems();
}
