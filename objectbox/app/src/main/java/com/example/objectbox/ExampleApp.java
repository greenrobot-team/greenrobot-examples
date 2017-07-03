package com.example.objectbox;

import android.app.Application;
import android.content.Context;

import com.example.objectbox.entities.MyObjectBox;

import io.objectbox.BoxStore;


public class ExampleApp extends Application {

    private static BoxStore boxStore;

    @Override
    public void onCreate() {
        super.onCreate();

        getBoxStore(this);
    }

    public static BoxStore getBoxStore(Context context) {
        if (boxStore == null) {
            boxStore = MyObjectBox.builder()
                    .androidContext(context.getApplicationContext())
                    .build();
        }
        return boxStore;
    }
}
