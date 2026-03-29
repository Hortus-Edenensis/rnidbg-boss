package com.bytedance.sdk.openadsdk.core.jk.u;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.k;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class fx extends SQLiteOpenHelper {
    private final String nr;
    protected final Context u;

    public fx(Context context, String str, int i) {
        super(new com.bytedance.sdk.openadsdk.api.plugin.u(context), str, (SQLiteDatabase.CursorFactory) null, i);
        this.nr = "CSJSQLiteOpenHelper";
        this.u = context;
    }

    private ArrayList<String> nr(SQLiteDatabase sQLiteDatabase) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            Cursor cursorRawQuery = sQLiteDatabase.rawQuery("select name from sqlite_master where type='table' order by name", null);
            if (cursorRawQuery != null) {
                while (cursorRawQuery.moveToNext()) {
                    String string = cursorRawQuery.getString(0);
                    if (!TextUtils.equals(string, "android_metadata") && !TextUtils.equals(string, "sqlite_sequence")) {
                        arrayList.add(string);
                    }
                }
                cursorRawQuery.close();
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            u(sQLiteDatabase, this.u);
        } catch (Throwable th) {
            k.nr("CSJSQLiteOpenHelper", th.getMessage());
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i > i2) {
            u(sQLiteDatabase);
            u(sQLiteDatabase, this.u);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i > i2) {
            try {
                u(sQLiteDatabase);
            } catch (Throwable th) {
                k.nr("CSJSQLiteOpenHelper", th.getMessage());
                return;
            }
        }
        u(sQLiteDatabase, this.u);
        u(sQLiteDatabase, i, i2);
    }

    public void u(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public void u(SQLiteDatabase sQLiteDatabase, Context context) {
    }

    public void u(SQLiteDatabase sQLiteDatabase) {
        ArrayList<String> arrayListNr = nr(sQLiteDatabase);
        if (arrayListNr == null || arrayListNr.size() <= 0) {
            return;
        }
        Iterator<String> it = arrayListNr.iterator();
        while (it.hasNext()) {
            sQLiteDatabase.execSQL(String.format("DROP TABLE IF EXISTS %s ;", it.next()));
        }
    }
}
