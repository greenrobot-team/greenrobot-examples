package com.example.entity_library;

import com.example.entity_library.model.DaoMaster;
import com.example.entity_library.model.DaoSession;

import org.greenrobot.greendao.database.Database;

import android.content.Context;

public class ModelManager {

    public ModelManager(Context context) {
        Database database = new DaoMaster.DevOpenHelper(context, "data.db").getWritableDb();
        DaoMaster daoMaster = new DaoMaster(database);
        DaoSession daoSession = daoMaster.newSession();
    }

}
