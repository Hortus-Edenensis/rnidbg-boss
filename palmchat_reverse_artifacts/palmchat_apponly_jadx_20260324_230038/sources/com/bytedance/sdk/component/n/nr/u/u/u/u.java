package com.bytedance.sdk.component.n.nr.u.u.u;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.sdk.component.n.nr.u.u.nr.b;
import com.bytedance.sdk.component.n.nr.u.u.nr.x;
import com.bytedance.sdk.component.n.u.iz;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u extends SQLiteOpenHelper {
    private iz nr;
    final Context u;

    public u(Context context, iz izVar) {
        super(new com.bytedance.sdk.openadsdk.api.plugin.u(context), "ttadlog.db", (SQLiteDatabase.CursorFactory) null, 1);
        this.u = context;
        this.nr = izVar;
    }

    private ArrayList<String> fx(SQLiteDatabase sQLiteDatabase) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            Cursor cursorRawQuery = sQLiteDatabase.rawQuery("select name from sqlite_master where type='table' order by name", null);
            if (cursorRawQuery != null) {
                while (cursorRawQuery.moveToNext()) {
                    String string = cursorRawQuery.getString(0);
                    if (!string.equals("android_metadata") && !string.equals("sqlite_sequence")) {
                        arrayList.add(string);
                    }
                }
                cursorRawQuery.close();
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    private void nr(SQLiteDatabase sQLiteDatabase) {
        ArrayList<String> arrayListFx = fx(sQLiteDatabase);
        if (arrayListFx == null || arrayListFx.size() <= 0) {
            return;
        }
        Iterator<String> it = arrayListFx.iterator();
        while (it.hasNext()) {
            sQLiteDatabase.execSQL(String.format("DROP TABLE IF EXISTS %s ;", it.next()));
        }
    }

    private void u(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(com.bytedance.sdk.component.n.nr.u.u.nr.iz.b(this.nr.nr()));
        sQLiteDatabase.execSQL(b.nr(this.nr.u()));
        sQLiteDatabase.execSQL(x.b(this.nr.b()));
        sQLiteDatabase.execSQL(com.bytedance.sdk.component.n.nr.u.u.nr.u.nr(this.nr.pn()));
        sQLiteDatabase.execSQL(com.bytedance.sdk.component.n.nr.iz.iz.nr());
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            u(sQLiteDatabase);
        } catch (Throwable unused) {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            if (i <= i2) {
                u(sQLiteDatabase);
            } else {
                nr(sQLiteDatabase);
                u(sQLiteDatabase);
            }
        } catch (Throwable unused) {
        }
    }
}
