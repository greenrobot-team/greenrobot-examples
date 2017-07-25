package com.example.greendao_library;

import com.example.greendao_library.model.DaoMaster;
import com.example.greendao_library.model.DaoSession;

import org.greenrobot.greendao.database.Database;

import android.content.Context;

public class ModelManager {

    public ModelManager(Context context) {
        Database database = new DaoMaster.DevOpenHelper(context, "data.db").getWritableDb();
        DaoMaster daoMaster = new DaoMaster(database);
        DaoSession daoSession = daoMaster.newSession();

        Database databaseLib = new com.example.entity_library.model.DaoMaster.DevOpenHelper(context,
                "dataLib.db").getWritableDb();
        com.example.entity_library.model.DaoMaster daoMasterLib
                = new com.example.entity_library.model.DaoMaster(databaseLib);
        com.example.entity_library.model.DaoSession daoSessionLib = daoMasterLib.newSession();
    }

}
