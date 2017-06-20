package com.example.greendao;

import android.app.Application;
import android.content.Context;

import com.example.greendao.model.DaoMaster;
import com.example.greendao.model.DaoSession;
import com.example.greendao.model.NoteDao;

import org.greenrobot.greendao.database.Database;

public class ExampleApp extends Application {

    private static DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        getDaoSession(this);
    }

    public static DaoSession getDaoSession(Context context) {
        if (daoSession == null) {
            ExampleOpenHelper openHelper = new ExampleOpenHelper(context.getApplicationContext(),
                    "example.db");
            DaoMaster daoMaster = new DaoMaster(openHelper.getWritableDatabase());
            daoSession = daoMaster.newSession();
        }
        return daoSession;
    }

    public static class ExampleOpenHelper extends DaoMaster.OpenHelper {

        public ExampleOpenHelper(Context context, String name) {
            super(context, name);
        }

        @Override
        public void onCreate(Database db) {
            super.onCreate(db);

            // INSERT INTO NOTE (_id, DATE, TEXT) VALUES(1, 0, 'Example Note')
            db.execSQL("INSERT INTO " + NoteDao.TABLENAME + " (" +
                    NoteDao.Properties.Id.columnName + ", " +
                    NoteDao.Properties.Date.columnName + ", " +
                    NoteDao.Properties.Text.columnName +
                    ") VALUES(1, 0, 'Example Note')");
        }
    }

}
