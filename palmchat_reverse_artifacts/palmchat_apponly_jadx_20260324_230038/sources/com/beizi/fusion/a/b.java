package com.beizi.fusion.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;
import com.beizi.fusion.model.EventItem;
import com.beizi.fusion.tool.aa;
import com.beizi.fusion.tool.s;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f4606a;
    private a b;

    private b(Context context) {
        this.b = a.a(context);
    }

    public static b a(Context context) {
        if (f4606a == null) {
            synchronized (b.class) {
                if (f4606a == null) {
                    f4606a = new b(context);
                }
            }
        }
        return f4606a;
    }

    private synchronized boolean b(String str) {
        boolean z = false;
        if (str == null) {
            return false;
        }
        Cursor cursorQuery = null;
        try {
            cursorQuery = this.b.getWritableDatabase().query("Sqlite_master", new String[]{"count('*') as c"}, "type=? and name =?", new String[]{"table", str.trim()}, null, null, null);
            if (cursorQuery.moveToNext()) {
                int i = cursorQuery.getInt(0);
                Log.e("DaoManager", "DaoManager count:" + i);
                if (i > 0) {
                    z = true;
                }
            }
        } catch (Exception unused) {
            if (cursorQuery != null) {
            }
            return z;
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
        cursorQuery.close();
        return z;
    }

    private synchronized void c(String str) {
        SQLiteDatabase writableDatabase = this.b.getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            try {
                String str2 = "create table " + str + "(id integer primary key autoincrement,event_code nvarchar,channel nvarchar,space_id nvarchar,timestamp nvarchar)";
                aa.a("DaoManager", "sql createTable tableName = " + str2);
                writableDatabase.execSQL(str2);
                writableDatabase.setTransactionSuccessful();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
        }
    }

    private synchronized void d(String str) {
        boolean zB = b(str);
        aa.a("DaoManager", "sql table is exist == " + zB);
        if (!zB) {
            c(str);
        }
    }

    private synchronized int e(String str) {
        int count;
        Cursor cursorQuery = this.b.getWritableDatabase().query(str, null, null, null, null, null, null);
        if (cursorQuery != null) {
            count = cursorQuery.getCount();
            cursorQuery.close();
        } else {
            count = 0;
        }
        return count;
    }

    private EventItem a(Cursor cursor) {
        EventItem eventItem = new EventItem();
        eventItem.setCode(cursor.getString(cursor.getColumnIndex("event_code")));
        eventItem.setChannel(cursor.getString(cursor.getColumnIndex("channel")));
        eventItem.setSpaceId(cursor.getString(cursor.getColumnIndex("space_id")));
        eventItem.setTimeStamp(cursor.getString(cursor.getColumnIndex("timestamp")));
        return eventItem;
    }

    private ContentValues a(EventItem eventItem) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("event_code", eventItem.getCode());
        contentValues.put("channel", eventItem.getChannel());
        contentValues.put("space_id", eventItem.getSpaceId());
        contentValues.put("timestamp", eventItem.getTimeStamp());
        return contentValues;
    }

    public synchronized void a(String str, EventItem eventItem) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String str2 = "T_" + str;
        d(str2);
        int iE = e(str2);
        long jInsert = this.b.getWritableDatabase().insert(str2, null, a(eventItem));
        StringBuilder sb = new StringBuilder();
        sb.append("insert before size == ");
        sb.append(iE);
        sb.append(", insert data success = ");
        sb.append(jInsert != -1);
        aa.a("DaoManager", sb.toString());
        a(str2, Math.max(86400000L, s.b(str) * 2));
    }

    public synchronized List<EventItem> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str2 = "T_" + str;
        d(str2);
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = this.b.getWritableDatabase().query(str2, null, null, null, null, null, null);
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            cursorQuery.moveToFirst();
            do {
                try {
                    arrayList.add(a(cursorQuery));
                } catch (Throwable th) {
                    cursorQuery.close();
                    throw th;
                }
            } while (cursorQuery.moveToNext());
            cursorQuery.close();
        }
        return arrayList;
    }

    public synchronized void a(String str, long j) {
        long jCurrentTimeMillis = System.currentTimeMillis() - j;
        int iE = e(str);
        if (iE > 0 && j > 0 && jCurrentTimeMillis > 0) {
            boolean z = true;
            int iDelete = this.b.getWritableDatabase().delete(str, "timestamp<=?", new String[]{String.valueOf(jCurrentTimeMillis)});
            StringBuilder sb = new StringBuilder();
            sb.append("start first delete data success = ");
            if (iDelete <= 0) {
                z = false;
            }
            sb.append(z);
            sb.append(", intervalTime = ");
            sb.append(j);
            aa.a("DaoManager", sb.toString());
        }
        if (iE >= 1000) {
            this.b.getWritableDatabase().execSQL("delete from " + str + " where rowid in(select rowid from " + str + " order by id limit 200)");
            aa.a("DaoManager", "start second delete data");
        }
    }
}
