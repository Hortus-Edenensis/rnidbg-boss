package com.amap.api.col.p0002sl;

import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class lw implements hg {
    @Override // com.amap.api.col.p0002sl.hg
    public final String a() {
        return "alsn20170807.db";
    }

    @Override // com.amap.api.col.p0002sl.hg
    public final void a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS c (_id integer primary key autoincrement, a2 varchar(100), a4 varchar(2000), a3 LONG );");
        } catch (Throwable th) {
            me.a(th, "SdCardDbCreator", "onCreate");
        }
    }
}
