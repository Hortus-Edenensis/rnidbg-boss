package com.bytedance.sdk.openadsdk.core.jk;

import android.content.ContentValues;
import android.content.Context;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.d;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b {
    private static final Object nr = new Object();
    private final String b;
    private final Context fx;
    private SQLiteDatabase u = null;

    /* JADX INFO: compiled from: SearchBox */
    public class u extends AbstractCursor {
        private u() {
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public String[] getColumnNames() {
            return new String[0];
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public int getCount() {
            return 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public double getDouble(int i) {
            return 0.0d;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public float getFloat(int i) {
            return 0.0f;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public int getInt(int i) {
            return 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public long getLong(int i) {
            return 0L;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public short getShort(int i) {
            return (short) 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public String getString(int i) {
            return null;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public boolean isNull(int i) {
            return true;
        }
    }

    public b(Context context, String str) {
        this.fx = context;
        this.b = str;
    }

    private boolean iz() {
        SQLiteDatabase sQLiteDatabase = this.u;
        return sQLiteDatabase != null && sQLiteDatabase.inTransaction();
    }

    public void b() {
        u();
        SQLiteDatabase sQLiteDatabase = this.u;
        if (sQLiteDatabase == null) {
            return;
        }
        sQLiteDatabase.setTransactionSuccessful();
    }

    public int delete(String str, String str2, String[] strArr) throws Exception {
        try {
            u();
            return this.u.delete(str, str2, strArr);
        } catch (Exception e) {
            if (iz()) {
                throw e;
            }
            return 0;
        }
    }

    public void fx() {
        u();
        SQLiteDatabase sQLiteDatabase = this.u;
        if (sQLiteDatabase == null) {
            return;
        }
        sQLiteDatabase.beginTransaction();
    }

    public long insert(String str, String str2, ContentValues contentValues) throws Exception {
        try {
            u();
            return this.u.insert(str, str2, contentValues);
        } catch (Exception e) {
            if (iz()) {
                throw e;
            }
            return -1L;
        }
    }

    public SQLiteDatabase nr() {
        return this.u;
    }

    public void pn() {
        u();
        SQLiteDatabase sQLiteDatabase = this.u;
        if (sQLiteDatabase == null) {
            return;
        }
        sQLiteDatabase.endTransaction();
    }

    public Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        try {
            u();
            return this.u.query(str, strArr, str2, strArr2, str3, str4, str5);
        } catch (Throwable th) {
            u uVar = new u();
            if (iz()) {
                throw th;
            }
            return uVar;
        }
    }

    public void u() {
        SQLiteOpenHelper uVar;
        try {
            SQLiteDatabase sQLiteDatabase = this.u;
            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                return;
            }
            synchronized (nr) {
                SQLiteDatabase sQLiteDatabase2 = this.u;
                if (sQLiteDatabase2 == null || !sQLiteDatabase2.isOpen()) {
                    if (TextUtils.equals(this.b, "ttopensdk.db")) {
                        uVar = new com.bytedance.sdk.openadsdk.core.jk.u.nr(this.fx, d.fx >= 7100 ? 13 : 12);
                    } else {
                        uVar = TextUtils.equals(this.b, "ttopensdk2.db") ? new com.bytedance.sdk.openadsdk.core.jk.u.u(this.fx) : null;
                    }
                    if (uVar != null) {
                        this.u = uVar.getWritableDatabase();
                    }
                }
            }
        } catch (Throwable th) {
            if (iz()) {
                throw th;
            }
        }
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) throws Exception {
        try {
            u();
            return this.u.update(str, contentValues, str2, strArr);
        } catch (Exception e) {
            if (iz()) {
                throw e;
            }
            return 0;
        }
    }

    public void u(String str) throws SQLException {
        try {
            u();
            this.u.execSQL(str);
        } catch (Throwable th) {
            if (iz()) {
                throw th;
            }
        }
    }
}
