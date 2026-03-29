package com.qq.gdt.action.c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.media3.transformer.ExportException;
import com.igexin.assist.sdk.AssistPushConsts;
import com.oplus.tblplayer.Constants;
import com.qq.gdt.action.j.d;
import com.qq.gdt.action.j.o;
import com.qq.gdt.action.j.u;
import com.qq.gdt.action.j.v;
import com.qq.gdt.action.j.w;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f10469a = {"create index index_group on actions ( status,session_id,action_type ) ", "create index index_status_time on actions ( status,revised_action_time ) ", "create index index_time on actions ( revised_action_time ) "};
    private static volatile b b;
    private Context c;
    private a d;
    private final File e;
    private AtomicInteger f = new AtomicInteger();
    private SQLiteDatabase g;

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends SQLiteOpenHelper {
        public a(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 2);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            o.a("Creating a new gdt_action DB", new Object[0]);
            sQLiteDatabase.execSQL("create table actions ( id INTEGER primary key autoincrement,session_id CHAR(32) not null,unique_id CHAR(32) not null,action_log_id BIGINT not null,action_type TEXT not null,action_time BIGINT not null,action_param TEXT not null,revised_action_time BIGINT not null,status TINYINT not null ) ");
            for (String str : b.f10469a) {
                sQLiteDatabase.execSQL(str);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            o.a("Downgrade gdt_action DB， oldVersion: " + i + "，newVersion: " + i2, new Object[0]);
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS actions");
            sQLiteDatabase.execSQL("create table actions ( id INTEGER primary key autoincrement,session_id CHAR(32) not null,unique_id CHAR(32) not null,action_log_id BIGINT not null,action_type TEXT not null,action_time BIGINT not null,action_param TEXT not null,revised_action_time BIGINT not null,status TINYINT not null ) ");
            for (String str : b.f10469a) {
                sQLiteDatabase.execSQL(str);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            o.a("Upgrading gdt_action DB， oldVersion: " + i + "，newVersion: " + i2, new Object[0]);
            try {
                sQLiteDatabase.execSQL("alter table actions add action_log_id default -1 ");
            } catch (Exception e) {
                o.c(e.getMessage());
            }
        }
    }

    private b(Context context) {
        this.c = context.getApplicationContext();
        String str = "gdt_action_" + u.a(d.a(this.c)) + com.umeng.analytics.process.a.d;
        o.a("ActionDB full name is " + str, new Object[0]);
        this.d = new a(this.c, str);
        this.e = this.c.getDatabasePath(str);
    }

    private synchronized SQLiteDatabase d() {
        if (this.f.incrementAndGet() == 1) {
            try {
                this.g = this.d.getWritableDatabase();
            } catch (Throwable th) {
                o.a("database open exception", th);
            }
        }
        return this.g;
    }

    private synchronized void e() {
        SQLiteDatabase sQLiteDatabase;
        if (this.f.decrementAndGet() == 0 && (sQLiteDatabase = this.g) != null) {
            try {
                sQLiteDatabase.close();
            } catch (Throwable th) {
                o.a("database close exception", th);
            }
        }
    }

    private int f() {
        SQLiteDatabase sQLiteDatabaseD;
        try {
            sQLiteDatabaseD = d();
        } catch (Throwable unused) {
            sQLiteDatabaseD = null;
        }
        try {
            String[] strArr = {String.valueOf(System.currentTimeMillis() - 1296000000), String.valueOf(w.b() - 54000000)};
            o.a("Will delete actions with query:( status = 1 ) AND ( ( action_time < ? ) OR ( revised_action_time > 0 AND revised_action_time < ? )), values:" + Arrays.toString(strArr), new Object[0]);
            return sQLiteDatabaseD.delete(AssistPushConsts.MSG_TYPE_ACTIONS, "( status = 1 ) AND ( ( action_time < ? ) OR ( revised_action_time > 0 AND revised_action_time < ? ))", strArr);
        } catch (Throwable unused2) {
            try {
                o.c("Exception while delete actions out of date");
                return 0;
            } finally {
                a(sQLiteDatabaseD, (Cursor) null, false);
            }
        }
    }

    private int g() {
        SQLiteDatabase sQLiteDatabaseD;
        try {
            sQLiteDatabaseD = d();
        } catch (Throwable unused) {
            sQLiteDatabaseD = null;
        }
        try {
            o.a("Will delete auto actions with query:( status = 1 ) AND (action_type in ('TICKET', 'PAGE_VIEW')), values:", new Object[0]);
            return sQLiteDatabaseD.delete(AssistPushConsts.MSG_TYPE_ACTIONS, "( status = 1 ) AND (action_type in ('TICKET', 'PAGE_VIEW'))", null);
        } catch (Throwable unused2) {
            try {
                o.c("Exception while delete actions outOfDate");
                return 0;
            } finally {
                a(sQLiteDatabaseD, (Cursor) null, false);
            }
        }
    }

    private int h() {
        Cursor cursor;
        SQLiteDatabase sQLiteDatabase = null;
        Cursor cursorRawQuery = null;
        try {
            SQLiteDatabase sQLiteDatabaseD = d();
            try {
                cursorRawQuery = sQLiteDatabaseD.rawQuery("SELECT COUNT(*) FROM actions", null);
                if (cursorRawQuery == null || !cursorRawQuery.moveToFirst()) {
                    a(sQLiteDatabaseD, cursorRawQuery, false);
                    return -1;
                }
                int i = cursorRawQuery.getInt(0);
                a(sQLiteDatabaseD, cursorRawQuery, false);
                return i;
            } catch (Throwable th) {
                th = th;
                cursor = cursorRawQuery;
                sQLiteDatabase = sQLiteDatabaseD;
                try {
                    o.b("Exception while count all actions in db", th);
                    return -1;
                } finally {
                    a(sQLiteDatabase, cursor, false);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    public int a(int i) throws Throwable {
        Cursor cursor;
        int i2 = -1;
        SQLiteDatabase sQLiteDatabase = null;
        cursorRawQuery = null;
        Cursor cursorRawQuery = null;
        sQLiteDatabase = null;
        try {
            SQLiteDatabase sQLiteDatabaseD = d();
            try {
                cursorRawQuery = sQLiteDatabaseD.rawQuery("SELECT COUNT(*) FROM actions WHERE status = " + i, null);
                if (cursorRawQuery != null) {
                    cursorRawQuery.moveToFirst();
                    i2 = cursorRawQuery.getInt(0);
                }
                a(sQLiteDatabaseD, cursorRawQuery, false);
            } catch (Exception e) {
                e = e;
                cursor = cursorRawQuery;
                sQLiteDatabase = sQLiteDatabaseD;
                try {
                    o.b("Count failed action exception", e);
                    a(sQLiteDatabase, cursor, false);
                } catch (Throwable th) {
                    th = th;
                    a(sQLiteDatabase, cursor, false);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                cursor = cursorRawQuery;
                sQLiteDatabase = sQLiteDatabaseD;
                a(sQLiteDatabase, cursor, false);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
        return i2;
    }

    public void b() throws Throwable {
        o.a("Success cleaned " + f() + " out of date actions.", new Object[0]);
        int iH = h();
        try {
            List<c> listA = a();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("total", iH);
            if (listA.size() > 0) {
                for (c cVar : listA) {
                    jSONObject.put(cVar.a(), cVar.b());
                }
            }
            com.qq.gdt.action.h.a.a(3500, jSONObject);
        } catch (Exception e) {
            o.c(e.getMessage());
        }
        o.a("Count all actions in db: " + iH, new Object[0]);
        if (iH > 10000) {
            o.a("Success deep-clean " + g() + " out of date actions.", new Object[0]);
        }
    }

    public synchronized int a(List<com.qq.gdt.action.c.a> list, int i) {
        SQLiteDatabase sQLiteDatabaseD;
        int iUpdate;
        String str;
        try {
            try {
                sQLiteDatabaseD = d();
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("status", Integer.valueOf(i));
                    String[] strArr = new String[list.size()];
                    StringBuilder sb = new StringBuilder();
                    sb.append("id");
                    sb.append(" IN ");
                    sb.append(" ( ");
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        strArr[i2] = String.valueOf(list.get(i2).f());
                        if (i2 == list.size() - 1) {
                            str = Constants.STRING_VALUE_UNSET;
                        } else {
                            sb.append(Constants.STRING_VALUE_UNSET);
                            str = ", ";
                        }
                        sb.append(str);
                    }
                    sb.append(" ) ");
                    iUpdate = sQLiteDatabaseD.update(AssistPushConsts.MSG_TYPE_ACTIONS, contentValues, sb.toString(), strArr);
                    a(sQLiteDatabaseD, (Cursor) null, false);
                } catch (Exception e) {
                    e = e;
                    o.b("Database update actions status exception.", e);
                    a(sQLiteDatabaseD, (Cursor) null, false);
                    iUpdate = -3;
                }
            } catch (Throwable th) {
                th = th;
                a((SQLiteDatabase) null, (Cursor) null, false);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            sQLiteDatabaseD = null;
        } catch (Throwable th2) {
            th = th2;
            a((SQLiteDatabase) null, (Cursor) null, false);
            throw th;
        }
        return iUpdate;
    }

    private ContentValues a(com.qq.gdt.action.c.a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("session_id", aVar.g());
        contentValues.put("unique_id", aVar.a());
        contentValues.put("action_log_id", Long.valueOf(aVar.b()));
        contentValues.put("action_type", aVar.c());
        contentValues.put("action_time", Long.valueOf(aVar.d()));
        contentValues.put("action_param", aVar.e() == null ? "" : aVar.e().toString());
        contentValues.put("revised_action_time", Long.valueOf(aVar.h()));
        contentValues.put("status", (Integer) 0);
        return contentValues;
    }

    public static b a(Context context) {
        if (b == null) {
            synchronized (b.class) {
                if (b == null) {
                    b = new b(context);
                }
            }
        }
        return b;
    }

    public List<c> a() throws Throwable {
        Cursor cursor;
        SQLiteDatabase sQLiteDatabaseD;
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase sQLiteDatabase = null;
        cursorRawQuery = null;
        Cursor cursorRawQuery = null;
        sQLiteDatabase = null;
        try {
            sQLiteDatabaseD = d();
        } catch (Exception e) {
            e = e;
            cursor = null;
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        try {
            cursorRawQuery = sQLiteDatabaseD.rawQuery("select status, count(*) from actions group by status", null);
            if (cursorRawQuery != null) {
                while (cursorRawQuery.moveToNext()) {
                    arrayList.add(new c(cursorRawQuery.getInt(0), cursorRawQuery.getInt(1)));
                }
            }
            a(sQLiteDatabaseD, cursorRawQuery, false);
        } catch (Exception e2) {
            e = e2;
            cursor = cursorRawQuery;
            sQLiteDatabase = sQLiteDatabaseD;
            try {
                o.b("countGroupByStatus failed action exception", e);
                a(sQLiteDatabase, cursor, false);
            } catch (Throwable th2) {
                th = th2;
                a(sQLiteDatabase, cursor, false);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            cursor = cursorRawQuery;
            sQLiteDatabase = sQLiteDatabaseD;
            a(sQLiteDatabase, cursor, false);
            throw th;
        }
        return arrayList;
    }

    public List<com.qq.gdt.action.c.a> a(int i, long j, long j2) throws Throwable {
        SQLiteDatabase sQLiteDatabase;
        Cursor cursorRawQuery;
        SQLiteDatabase sQLiteDatabaseD;
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = null;
        try {
            sQLiteDatabaseD = d();
        } catch (Exception e) {
            e = e;
            sQLiteDatabase = null;
        } catch (Throwable th) {
            th = th;
            sQLiteDatabase = null;
        }
        try {
            cursorRawQuery = sQLiteDatabaseD.rawQuery("SELECT * FROM actions WHERE status = " + i + " AND id > " + j2 + " ORDER BY id ASC LIMIT " + j, null);
            if (cursorRawQuery != null) {
                while (cursorRawQuery.moveToNext()) {
                    try {
                        long j3 = cursorRawQuery.getLong(cursorRawQuery.getColumnIndexOrThrow("id"));
                        String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("session_id"));
                        String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("unique_id"));
                        long j4 = cursorRawQuery.getLong(cursorRawQuery.getColumnIndexOrThrow("action_log_id"));
                        String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("action_type"));
                        long j5 = cursorRawQuery.getLong(cursorRawQuery.getColumnIndexOrThrow("action_time"));
                        long j6 = cursorRawQuery.getLong(cursorRawQuery.getColumnIndexOrThrow("revised_action_time"));
                        String string4 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("action_param"));
                        if (!v.a(string4)) {
                            jSONObject = new JSONObject(string4);
                        }
                        arrayList.add(new com.qq.gdt.action.c.a(j3, string, string2, string3, j5, j6, jSONObject, i, j4));
                        jSONObject = null;
                    } catch (Exception e2) {
                        e = e2;
                        sQLiteDatabase = sQLiteDatabaseD;
                        try {
                            o.b("Find actions by status exception", e);
                            a(sQLiteDatabase, cursorRawQuery, false);
                        } catch (Throwable th2) {
                            th = th2;
                            a(sQLiteDatabase, cursorRawQuery, false);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        sQLiteDatabase = sQLiteDatabaseD;
                        a(sQLiteDatabase, cursorRawQuery, false);
                        throw th;
                    }
                }
            }
            a(sQLiteDatabaseD, cursorRawQuery, false);
        } catch (Exception e3) {
            e = e3;
            sQLiteDatabase = sQLiteDatabaseD;
            cursorRawQuery = null;
            o.b("Find actions by status exception", e);
            a(sQLiteDatabase, cursorRawQuery, false);
            return arrayList;
        } catch (Throwable th4) {
            th = th4;
            sQLiteDatabase = sQLiteDatabaseD;
            cursorRawQuery = null;
            a(sQLiteDatabase, cursorRawQuery, false);
            throw th;
        }
        return arrayList;
    }

    private void a(SQLiteDatabase sQLiteDatabase, Cursor cursor, boolean z) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Throwable th) {
                o.a("Cursor close exception", th);
            }
        }
        if (sQLiteDatabase != null) {
            if (z) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Throwable th2) {
                    o.a("Database close exception", th2);
                    return;
                }
            }
            e();
        }
    }

    public boolean a(List<com.qq.gdt.action.c.a> list) throws Throwable {
        SQLiteDatabase sQLiteDatabaseD;
        boolean z;
        boolean z2 = false;
        try {
            sQLiteDatabaseD = d();
            try {
                try {
                    sQLiteDatabaseD.beginTransaction();
                    Iterator<com.qq.gdt.action.c.a> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = true;
                            break;
                        }
                        com.qq.gdt.action.c.a next = it.next();
                        com.qq.gdt.action.h.a.a(6001, next);
                        ContentValues contentValuesA = a(next);
                        com.qq.gdt.action.h.a.a(6002, next);
                        long jInsert = sQLiteDatabaseD.insert(AssistPushConsts.MSG_TYPE_ACTIONS, null, contentValuesA);
                        if (jInsert < 0) {
                            com.qq.gdt.action.h.a.a(6004, next);
                            z = false;
                            break;
                        }
                        next.a(jInsert);
                        com.qq.gdt.action.h.a.a(6003, next);
                    }
                    if (z) {
                        sQLiteDatabaseD.setTransactionSuccessful();
                    }
                    a(sQLiteDatabaseD, (Cursor) null, true);
                    z2 = z;
                } catch (Exception e) {
                    e = e;
                    o.b("Database add actions exception.", e);
                    Iterator<com.qq.gdt.action.c.a> it2 = list.iterator();
                    while (it2.hasNext()) {
                        com.qq.gdt.action.h.a.a(6005, it2.next());
                    }
                    a(sQLiteDatabaseD, (Cursor) null, true);
                }
            } catch (Throwable th) {
                th = th;
                a(sQLiteDatabaseD, (Cursor) null, true);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            sQLiteDatabaseD = null;
        } catch (Throwable th2) {
            th = th2;
            sQLiteDatabaseD = null;
            a(sQLiteDatabaseD, (Cursor) null, true);
            throw th;
        }
        if (!z2) {
            Iterator<com.qq.gdt.action.c.a> it3 = list.iterator();
            while (it3.hasNext()) {
                it3.next().a(-1L);
            }
        }
        Iterator<com.qq.gdt.action.c.a> it4 = list.iterator();
        while (it4.hasNext()) {
            com.qq.gdt.action.h.a.a(z2 ? 7001 : ExportException.ERROR_CODE_MUXING_TIMEOUT, it4.next());
        }
        return z2;
    }
}
