package com.amap.api.col.p0002sl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class hk extends SQLiteOpenHelper {
    private static boolean b = true;
    private static boolean c = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private hg f2866a;

    public hk(Context context, String str, hg hgVar) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        this.f2866a = hgVar;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        this.f2866a.a(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
