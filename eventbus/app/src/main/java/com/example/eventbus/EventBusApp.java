package com.example.eventbus;

import android.app.Application;

import org.greenrobot.eventbus.EventBus;

public class EventBusApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        EventBus.builder()
                // have a look at the index class to see which methods are picked up
                // if not in the index @Subscribe methods will be looked up at runtime (expensive)
                .addIndex(new MyEventBusIndex())
                .installDefaultEventBus();
    }
}
