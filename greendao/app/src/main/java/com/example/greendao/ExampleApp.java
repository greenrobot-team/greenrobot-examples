package com.example.greendao;

import com.example.greendao.model.DaoMaster;
import com.example.greendao.model.DaoSession;

import android.app.Application;
import android.content.Context;

public class ExampleApp extends Application {

    private static DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        getDaoSession(this);
    }

    public static DaoSession getDaoSession(Context context) {
        if (daoSession == null) {
            DaoMaster.DevOpenHelper openHelper = new DaoMaster.DevOpenHelper(
                    context.getApplicationContext(), "example.db");
            DaoMaster daoMaster = new DaoMaster(openHelper.getWritableDatabase());
            daoSession = daoMaster.newSession();
        }
        return daoSession;
    }

}
