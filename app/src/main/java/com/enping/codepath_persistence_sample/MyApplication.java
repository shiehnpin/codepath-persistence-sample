package com.enping.codepath_persistence_sample;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;

/**
 * Created by i_enpinghsieh on 2016/12/15.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        // This instantiates DBFlow
        FlowManager.init(new FlowConfig.Builder(this).build());

    }
}