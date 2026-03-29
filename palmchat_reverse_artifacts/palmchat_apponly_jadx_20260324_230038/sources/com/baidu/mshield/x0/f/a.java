package com.baidu.mshield.x0.f;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.baidu.mshield.x0.d.d;
import com.kuaishou.weapon.p0.t;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f4064a;
    public C0097a d;
    public SQLiteDatabase e;
    public String b = "msvolcano.db";
    public int c = 1;
    public String f = "msal";
    public String g = "CREATE TABLE IF NOT EXISTS " + this.f + "(a TEXT PRIMARY KEY ON CONFLICT ABORT," + t.l + " INTEGER,c TEXT)";

    public a(Context context) {
        try {
            context.getApplicationContext();
            C0097a c0097a = new C0097a(context.getApplicationContext());
            this.d = c0097a;
            this.e = c0097a.getWritableDatabase();
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public static synchronized a a(Context context) {
        if (f4064a == null) {
            f4064a = new a(context);
        }
        return f4064a;
    }

    public final boolean b(String str) {
        SQLiteDatabase sQLiteDatabase = this.e;
        boolean z = false;
        if (sQLiteDatabase == null) {
            return false;
        }
        Cursor cursorQuery = null;
        try {
            cursorQuery = sQLiteDatabase.query(this.f, null, "a=?", new String[]{str}, null, null, null);
            if (cursorQuery != null) {
                if (cursorQuery.getCount() > 0) {
                    z = true;
                }
            }
        } catch (Throwable th) {
            try {
                d.a(th);
            } finally {
                if (cursorQuery != null && !cursorQuery.isClosed()) {
                    cursorQuery.close();
                }
            }
        }
        if (cursorQuery != null && !cursorQuery.isClosed()) {
        }
        return z;
    }

    public int a(com.baidu.mshield.x0.d.a aVar) {
        int iInsert = 0;
        if (aVar != null && this.e != null) {
            try {
                String strB = d.b(aVar.f4053a);
                if (TextUtils.isEmpty(strB)) {
                    return 0;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("a", strB);
                contentValues.put(t.l, Integer.valueOf(aVar.b));
                contentValues.put("c", Long.valueOf(aVar.c));
                if (b(strB)) {
                    iInsert = this.e.update(this.f, contentValues, "a= ?", new String[]{strB});
                } else {
                    iInsert = (int) this.e.insert(this.f, null, contentValues);
                }
            } catch (Throwable th) {
                d.a(th);
            }
        }
        return iInsert;
    }

    public com.baidu.mshield.x0.d.a a(String str) {
        Cursor cursor;
        Throwable th;
        com.baidu.mshield.x0.d.a aVar;
        com.baidu.mshield.x0.d.a aVar2;
        Cursor cursorQuery;
        String strB;
        boolean zIsClosed;
        com.baidu.mshield.x0.d.a aVar3 = null;
        if (this.e == null) {
            return null;
        }
        try {
            strB = d.b(str);
        } catch (Throwable th2) {
            cursor = null;
            th = th2;
            aVar = null;
        }
        try {
            if (TextUtils.isEmpty(strB)) {
                return null;
            }
            cursorQuery = this.e.query(this.f, null, "a=?", new String[]{strB}, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() > 0) {
                        while (cursorQuery.moveToNext()) {
                            aVar2 = new com.baidu.mshield.x0.d.a();
                            try {
                                aVar2.f4053a = d.a(cursorQuery.getString(cursorQuery.getColumnIndex("a")));
                                aVar2.b = cursorQuery.getInt(cursorQuery.getColumnIndex(t.l));
                                aVar2.c = Long.parseLong(cursorQuery.getString(cursorQuery.getColumnIndex("c")));
                                aVar3 = aVar2;
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        }
                    }
                } catch (Throwable th4) {
                    cursor = cursorQuery;
                    aVar = aVar3;
                    th = th4;
                    Cursor cursor2 = cursor;
                    aVar2 = aVar;
                    cursorQuery = cursor2;
                }
            }
            if (cursorQuery == null) {
                return aVar3;
            }
            if (zIsClosed) {
                return aVar3;
            }
            return aVar3;
            d.a(th);
            if (cursorQuery == null || cursorQuery.isClosed()) {
                return aVar2;
            }
            aVar3 = aVar2;
            return aVar3;
        } finally {
            if (cursorQuery != null && !cursorQuery.isClosed()) {
                cursorQuery.close();
            }
        }
        Cursor cursor22 = cursor;
        aVar2 = aVar;
        cursorQuery = cursor22;
    }

    public List<com.baidu.mshield.x0.d.a> a() {
        Cursor cursorQuery = null;
        if (this.e == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            cursorQuery = this.e.query(this.f, null, null, null, null, null, "b DESC");
            if (cursorQuery != null && cursorQuery.getCount() > 0) {
                while (cursorQuery.moveToNext()) {
                    com.baidu.mshield.x0.d.a aVar = new com.baidu.mshield.x0.d.a();
                    aVar.f4053a = d.a(cursorQuery.getString(cursorQuery.getColumnIndex("a")));
                    aVar.b = cursorQuery.getInt(cursorQuery.getColumnIndex(t.l));
                    aVar.c = Long.parseLong(cursorQuery.getString(cursorQuery.getColumnIndex("c")));
                    arrayList.add(aVar);
                }
            }
        } catch (Throwable th) {
            try {
                d.a(th);
            } finally {
                if (cursorQuery != null && !cursorQuery.isClosed()) {
                    cursorQuery.close();
                }
            }
        }
        if (cursorQuery != null && !cursorQuery.isClosed()) {
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: com.baidu.mshield.x0.f.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C0097a extends SQLiteOpenHelper {
        public C0097a(Context context) {
            super(context, a.this.b, (SQLiteDatabase.CursorFactory) null, a.this.c);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL(a.this.g);
            } catch (Throwable th) {
                d.a(th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }
}
