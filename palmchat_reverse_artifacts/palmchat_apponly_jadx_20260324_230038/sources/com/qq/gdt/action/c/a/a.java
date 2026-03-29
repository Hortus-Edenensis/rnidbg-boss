package com.qq.gdt.action.c.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.oplus.tblplayer.Constants;
import com.qq.gdt.action.g.a.b;
import com.qq.gdt.action.j.d;
import com.qq.gdt.action.j.o;
import com.qq.gdt.action.j.u;
import com.qq.gdt.action.j.v;
import com.umeng.analytics.pro.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f10468a = {"create index index_group on events ( status,session_id,action_type ) "};
    private static volatile a b;
    private Context c;
    private C0836a d;
    private AtomicInteger e = new AtomicInteger();
    private SQLiteDatabase f;

    /* JADX INFO: renamed from: com.qq.gdt.action.c.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0836a extends SQLiteOpenHelper {
        public C0836a(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 2);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            o.a("Creating a new gdt_event DB", new Object[0]);
            sQLiteDatabase.execSQL("create table events ( id INTEGER primary key autoincrement,event_id INTEGER not null,unique_event_id CHAR(32) not null,event_time BIGINT not null,action_type TEXT,unique_action_id CHAR(32),action_log_id BIGINT not null,event_log_id BIGINT not null,action_time BIGINT,event_param TEXT not null,session_id CHAR(32) not null,status TINYINT not null ) ");
            for (String str : a.f10468a) {
                sQLiteDatabase.execSQL(str);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            o.a("Downgrade gdt_action DB， oldVersion: " + i + "，newVersion: " + i2, new Object[0]);
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS events");
            sQLiteDatabase.execSQL("create table events ( id INTEGER primary key autoincrement,event_id INTEGER not null,unique_event_id CHAR(32) not null,event_time BIGINT not null,action_type TEXT,unique_action_id CHAR(32),action_log_id BIGINT not null,event_log_id BIGINT not null,action_time BIGINT,event_param TEXT not null,session_id CHAR(32) not null,status TINYINT not null ) ");
            for (String str : a.f10468a) {
                sQLiteDatabase.execSQL(str);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            o.a("Upgrading gdt_event DB， oldVersion: " + i + "，newVersion: " + i2, new Object[0]);
            try {
                sQLiteDatabase.execSQL("alter table events add action_log_id default -1 ");
                sQLiteDatabase.execSQL("alter table events add event_log_id default -1 ");
            } catch (Exception e) {
                o.c(e.getMessage());
            }
        }
    }

    private a(Context context) {
        this.c = context.getApplicationContext();
        String str = "gdt_event_" + u.a(d.a(this.c)) + com.umeng.analytics.process.a.d;
        o.a("ActionDB full name is " + str, new Object[0]);
        this.d = new C0836a(this.c, str);
    }

    private synchronized SQLiteDatabase d() {
        if (this.e.incrementAndGet() == 1) {
            try {
                this.f = this.d.getWritableDatabase();
            } catch (Throwable th) {
                o.a("database open exception", th);
            }
        }
        return this.f;
    }

    private synchronized void e() {
        this.e.decrementAndGet();
    }

    private int f() {
        SQLiteDatabase sQLiteDatabaseD;
        try {
            sQLiteDatabaseD = d();
        } catch (Throwable unused) {
            sQLiteDatabaseD = null;
        }
        try {
            String[] strArr = {String.valueOf(System.currentTimeMillis() - com.igexin.push.f.b.d.b)};
            o.a("Will delete events with query:( status = 1 ) AND ( ( event_time < ? )), values:" + Arrays.toString(strArr), new Object[0]);
            return sQLiteDatabaseD.delete(f.ax, "( status = 1 ) AND ( ( event_time < ? ))", strArr);
        } catch (Throwable unused2) {
            try {
                o.c("Exception while delete events out of date");
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
            o.a("Will delete auto events with query:( status = 1 ) , values:", new Object[0]);
            return sQLiteDatabaseD.delete(f.ax, "( status = 1 ) ", null);
        } catch (Throwable unused2) {
            try {
                o.c("Exception while delete events outOfDate");
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
                cursorRawQuery = sQLiteDatabaseD.rawQuery("SELECT COUNT(*) FROM events", null);
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
                    o.b("Exception while count all events in db", th);
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

    public synchronized int a(List<com.qq.gdt.action.g.a.a> list, int i) {
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
                        strArr[i2] = String.valueOf(list.get(i2).a());
                        if (i2 == list.size() - 1) {
                            str = Constants.STRING_VALUE_UNSET;
                        } else {
                            sb.append(Constants.STRING_VALUE_UNSET);
                            str = ", ";
                        }
                        sb.append(str);
                    }
                    sb.append(" ) ");
                    iUpdate = sQLiteDatabaseD.update(f.ax, contentValues, sb.toString(), strArr);
                    a(sQLiteDatabaseD, (Cursor) null, false);
                } catch (Exception e) {
                    e = e;
                    o.b("Database update events status exception.", e);
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

    public void b() throws Throwable {
        o.a("Success cleaned " + f() + " out of date events.", new Object[0]);
        int iH = h();
        try {
            List<b> listA = a();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("total", iH);
            if (listA.size() > 0) {
                for (b bVar : listA) {
                    jSONObject.put(bVar.a(), bVar.b());
                }
            }
            com.qq.gdt.action.h.a.a(3501, jSONObject);
        } catch (Exception e) {
            o.c(e.getMessage());
        }
        o.a("Count all events in db: " + iH, new Object[0]);
        if (iH > 10000) {
            o.a("Success deep-clean " + g() + " out of date events.", new Object[0]);
        }
    }

    private ContentValues a(com.qq.gdt.action.g.a.a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("event_id", Long.valueOf(aVar.b()));
        contentValues.put("unique_event_id", aVar.d());
        contentValues.put("event_time", Long.valueOf(aVar.i()));
        contentValues.put("action_type", aVar.f());
        contentValues.put("unique_action_id", aVar.e());
        contentValues.put("action_log_id", Long.valueOf(aVar.j()));
        contentValues.put("event_log_id", Long.valueOf(aVar.k()));
        contentValues.put("action_time", Long.valueOf(aVar.g()));
        contentValues.put("event_param", aVar.h() == null ? "" : aVar.h().toString());
        contentValues.put("session_id", aVar.c());
        contentValues.put("status", (Integer) 0);
        return contentValues;
    }

    public static a a(Context context) {
        if (b == null) {
            synchronized (a.class) {
                if (b == null) {
                    b = new a(context);
                }
            }
        }
        return b;
    }

    public List<b> a() throws Throwable {
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
            cursorRawQuery = sQLiteDatabaseD.rawQuery("select status, count(*) from events group by status", null);
            if (cursorRawQuery != null) {
                while (cursorRawQuery.moveToNext()) {
                    arrayList.add(new b(cursorRawQuery.getInt(0), cursorRawQuery.getInt(1)));
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

    public List<com.qq.gdt.action.g.a.a> a(int i, long j, long j2) throws Throwable {
        SQLiteDatabase sQLiteDatabase;
        Cursor cursorRawQuery;
        SQLiteDatabase sQLiteDatabaseD;
        ArrayList arrayList = new ArrayList();
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
            cursorRawQuery = sQLiteDatabaseD.rawQuery("SELECT * FROM events WHERE status = " + i + " AND id > " + j2 + " ORDER BY id ASC LIMIT " + j, null);
            if (cursorRawQuery != null) {
                while (cursorRawQuery.moveToNext()) {
                    try {
                        long j3 = cursorRawQuery.getLong(cursorRawQuery.getColumnIndexOrThrow("id"));
                        long j4 = cursorRawQuery.getLong(cursorRawQuery.getColumnIndexOrThrow("event_id"));
                        String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("unique_event_id"));
                        long j5 = cursorRawQuery.getLong(cursorRawQuery.getColumnIndexOrThrow("event_time"));
                        String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("action_type"));
                        String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("unique_action_id"));
                        long j6 = cursorRawQuery.getLong(cursorRawQuery.getColumnIndexOrThrow("action_time"));
                        String string4 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("event_param"));
                        arrayList.add(new com.qq.gdt.action.g.a.a(j3, j4, string, j5, cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("session_id")), string2, string3, j6, v.a(string4) ? null : new JSONObject(string4), i, cursorRawQuery.getLong(cursorRawQuery.getColumnIndexOrThrow("action_log_id")), cursorRawQuery.getLong(cursorRawQuery.getColumnIndexOrThrow("event_log_id"))));
                    } catch (Exception e2) {
                        e = e2;
                        sQLiteDatabase = sQLiteDatabaseD;
                        try {
                            o.b("Find events by status exception", e);
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
            o.b("Find events by status exception", e);
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

    public boolean a(List<com.qq.gdt.action.g.a.a> list) throws Throwable {
        SQLiteDatabase sQLiteDatabaseD;
        boolean z;
        boolean z2 = false;
        try {
            sQLiteDatabaseD = d();
            try {
                try {
                    sQLiteDatabaseD.beginTransaction();
                    Iterator<com.qq.gdt.action.g.a.a> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = true;
                            break;
                        }
                        com.qq.gdt.action.g.a.a next = it.next();
                        long jInsert = sQLiteDatabaseD.insert(f.ax, null, a(next));
                        if (jInsert < 0) {
                            z = false;
                            break;
                        }
                        next.a(jInsert);
                    }
                    if (z) {
                        sQLiteDatabaseD.setTransactionSuccessful();
                    }
                    a(sQLiteDatabaseD, (Cursor) null, true);
                    z2 = z;
                } catch (Exception e) {
                    e = e;
                    o.b("Database add events exception.", e);
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
            Iterator<com.qq.gdt.action.g.a.a> it2 = list.iterator();
            while (it2.hasNext()) {
                it2.next().a(-1L);
            }
        }
        return z2;
    }
}
