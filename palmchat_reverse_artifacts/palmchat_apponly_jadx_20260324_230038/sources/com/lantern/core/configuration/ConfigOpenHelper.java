package com.lantern.core.configuration;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.lantern.core.business.ParamHelper;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class ConfigOpenHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "config.db";
    public static final String DB_TABLE = "config_data";
    private static final int DB_VERSION = 100;
    private static final String TAG = "com.lantern.core.configuration.ConfigOpenHelper";

    public ConfigOpenHelper(Context context) {
        super(context, DB_NAME, (SQLiteDatabase.CursorFactory) null, 100);
    }

    private void createConfigTable(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS config_data(_id INTEGER PRIMARY KEY AUTOINCREMENT,eventid TEXT, level INTEGER, availbletime LONG, eventlimit INTEGER); ");
        } catch (SQLException unused) {
            Log.e(TAG, "couldn't create config table in database");
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        Log.i("CX_EVENT", "ConfigOpenHelper onCreate!");
        createConfigTable(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        super.onDowngrade(sQLiteDatabase, i, i2);
        Log.i("CX_EVENT", "onDowngrade oldVersion:" + i + "; newVersion:" + i2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        Log.i("CX_EVENT", "onUpgrade oldVersion:" + i + "; newVersion:" + i2);
        StringBuilder sb = new StringBuilder();
        sb.append("onUpgrade advanceList size:");
        sb.append(ParamHelper.getAdvancedPresetEventList().size());
        Log.i("CX_EVENT", sb.toString());
    }
}
