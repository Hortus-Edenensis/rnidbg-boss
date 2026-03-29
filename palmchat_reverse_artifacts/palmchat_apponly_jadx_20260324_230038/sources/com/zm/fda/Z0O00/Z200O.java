package com.zm.fda.Z0O00;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import android.util.Log;
import com.wifi.ad.core.p001const.WifiNestConst;
import com.zm.fda.O52OZ.O2O5Z;
import com.zm.fda.Z0O00.Z0O00.OO22Z;
import com.zm.fda.Z200O.ZZ00Z;
import com.zm.fda.utils.EventLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class Z200O extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16671a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final int i;
    public final Z0225 j;

    public Z200O(Context context) {
        super(context, a(context), (SQLiteDatabase.CursorFactory) null, 3);
        this.f16671a = "fda_analytics_table";
        this.b = "fda_event_table";
        this.c = "KEY_BEAN_ID";
        this.d = "EVENT_ID";
        this.e = "EVENT_LEVEL";
        this.f = "EVENT_PUB";
        this.g = "EVENT_BODY";
        this.h = "EVENT_SOURCE";
        this.i = -1;
        this.j = new Z0225(context);
    }

    public static String a(Context context) {
        return com.zm.fda.O52OZ.ZZ00Z.b(context).replace(".", "_").replace(":", "_") + "_" + OO22Z.i;
    }

    public synchronized boolean b(String str) {
        boolean z;
        z = false;
        try {
            String str2 = "delete from fda_event_table where KEY_BEAN_ID in " + str;
            try {
                if (getWritableDatabase().compileStatement(str2).executeUpdateDelete() > 0) {
                    z = true;
                } else {
                    a("delete fail, sql:[" + str2 + "]");
                }
            } catch (SQLException e) {
                Log.i(OO22Z.h, e.toString());
                a(e.toString());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (Exception unused) {
            return false;
        }
        return z;
    }

    public boolean c(String str) {
        try {
            try {
                getWritableDatabase().delete("fda_event_table", "KEY_BEAN_ID = ?", new String[]{str});
                return true;
            } catch (SQLException e) {
                Log.i(OO22Z.h, e.toString());
                a(e.toString());
                return false;
            }
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        super.onDowngrade(sQLiteDatabase, i, i2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        EventLog.d("fob_fda", "onUpgrade");
        a(sQLiteDatabase, i);
    }

    private void a(SQLiteDatabase sQLiteDatabase, int i) {
        if (i == 1 || i == 2) {
            c(sQLiteDatabase);
            a(sQLiteDatabase);
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        if (EventLog.isDebugEnable()) {
            EventLog.d("fob_fda", "create table ");
        }
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS fda_event_table ( KEY_BEAN_ID INTEGER PRIMARY KEY,EVENT_ID TEXT NOT NULL,EVENT_LEVEL INTEGER,EVENT_BODY BLOB,EVENT_SOURCE TEXT,EVENT_PUB BLOB NOT NULL);");
        } catch (SQLException e) {
            Log.i(OO22Z.h, e.toString());
            a(e.toString());
        } catch (Exception e2) {
            Log.e(OO22Z.h, "db error", e2);
        }
    }

    public void c(SQLiteDatabase sQLiteDatabase) {
        if (EventLog.isDebugEnable()) {
            EventLog.d("fob_fda", "drop table ");
        }
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS fda_analytics_table");
        } catch (SQLException e) {
            Log.i(OO22Z.h, e.toString());
            a(e.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Deprecated
    public void b(SQLiteDatabase sQLiteDatabase) {
        try {
            EventLog.d("fob_fda", "db upgrade, deleteTable");
            sQLiteDatabase.execSQL("delete from fda_event_table");
        } catch (Throwable th) {
            Log.i(OO22Z.h, th.toString());
            a(th.toString());
        }
    }

    public long a(com.zm.fda.Z0O00.Z0O00.OO22Z oo22z) {
        if (oo22z == null || !oo22z.k()) {
            return -1L;
        }
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("KEY_BEAN_ID", Long.valueOf(oo22z.a()));
            contentValues.put("EVENT_ID", oo22z.d());
            contentValues.put("EVENT_LEVEL", Integer.valueOf(oo22z.g()));
            contentValues.put("EVENT_PUB", oo22z.c());
            contentValues.put("EVENT_BODY", oo22z.b());
            try {
                return writableDatabase.insert("fda_event_table", null, contentValues);
            } catch (Exception e) {
                Log.i("fob_fda", e.toString());
                a(e.toString());
                return -1L;
            }
        } catch (Exception unused) {
            return -1L;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00e9 A[PHI: r15
      0x00e9: PHI (r15v3 android.database.Cursor) = (r15v1 android.database.Cursor), (r15v4 android.database.Cursor) binds: [B:38:0x00e7, B:32:0x00d3] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<com.zm.fda.Z0O00.Z0O00.OO22Z> a(int i, int i2, boolean z) {
        List<com.zm.fda.Z0O00.Z0O00.OO22Z> listA;
        String str;
        String str2;
        ArrayList arrayList = new ArrayList();
        try {
            Cursor cursorQuery = null;
            try {
                try {
                    cursorQuery = getReadableDatabase().query(true, "fda_event_table", null, "EVENT_LEVEL = ? ", new String[]{String.valueOf(i)}, null, null, "KEY_BEAN_ID ASC ", i2 + "");
                    if (cursorQuery != null) {
                        int columnIndex = cursorQuery.getColumnIndex("KEY_BEAN_ID");
                        int columnIndex2 = cursorQuery.getColumnIndex("EVENT_ID");
                        int columnIndex3 = cursorQuery.getColumnIndex("EVENT_LEVEL");
                        int columnIndex4 = cursorQuery.getColumnIndex("EVENT_PUB");
                        int columnIndex5 = cursorQuery.getColumnIndex("EVENT_BODY");
                        System.currentTimeMillis();
                        while (cursorQuery.moveToNext()) {
                            System.currentTimeMillis();
                            byte[] blob = cursorQuery.getBlob(columnIndex5);
                            if (blob != null) {
                                try {
                                    str = new String(O2O5Z.a(blob), "UTF-8");
                                } catch (Exception e) {
                                    EventLog.e("fob_fda", e.getMessage());
                                    str = "";
                                }
                            } else {
                                str = "";
                            }
                            byte[] blob2 = cursorQuery.getBlob(columnIndex4);
                            if (blob2 != null) {
                                try {
                                    str2 = new String(O2O5Z.a(blob2), "UTF-8");
                                } catch (Exception e2) {
                                    EventLog.e("fob_fda", e2.getMessage());
                                    str2 = "";
                                }
                            } else {
                                str2 = "";
                            }
                            System.currentTimeMillis();
                            com.zm.fda.Z0O00.Z0O00.OO22Z oo22zA = new OO22Z.ZZ00Z().a(cursorQuery.getLong(columnIndex)).a(cursorQuery.getString(columnIndex2)).a(cursorQuery.getInt(columnIndex3)).c(str).d(str2).b(0).a();
                            if (oo22zA.k()) {
                                arrayList.add(oo22zA);
                            }
                        }
                    }
                } catch (Exception e3) {
                    Log.e(OO22Z.h, "adb error", e3);
                    a(e3.toString());
                    if (cursorQuery != null) {
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                if (arrayList.size() < i2 && z && (listA = this.j.a(i, i2 - arrayList.size())) != null) {
                    arrayList.addAll(listA);
                }
                return arrayList;
            } catch (Throwable th) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                throw th;
            }
        } catch (Exception unused) {
            return arrayList;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
    public void close() {
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0063 A[Catch: all -> 0x0071, DONT_GENERATE, PHI: r1
      0x0063: PHI (r1v4 java.lang.String) = (r1v0 java.lang.String), (r1v5 java.lang.String) binds: [B:14:0x004e, B:18:0x0061] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {, blocks: (B:3:0x0001, B:4:0x0005, B:19:0x0063, B:20:0x0066, B:22:0x006c, B:16:0x005d, B:17:0x0060, B:6:0x0010, B:8:0x001e, B:14:0x004e), top: B:30:0x0001, inners: #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a() {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            String str = "";
            Cursor cursorRawQuery = writableDatabase.rawQuery("select count(*) from fda_event_table", null);
            if (cursorRawQuery != null) {
                try {
                    try {
                        cursorRawQuery.moveToFirst();
                        long j = cursorRawQuery.getLong(0);
                        if (j > 100) {
                            str = "delete from fda_event_table where KEY_BEAN_ID in ( " + ("select KEY_BEAN_ID from fda_event_table order by KEY_BEAN_ID ASC limit " + (((int) j) / 2)) + " )";
                        }
                    } catch (Exception e) {
                        Log.i(OO22Z.h, e.toString());
                        a(e.toString());
                    }
                    if (cursorRawQuery != null) {
                    }
                } finally {
                    cursorRawQuery.close();
                }
            } else if (cursorRawQuery != null) {
            }
            if (!TextUtils.isEmpty(str)) {
                writableDatabase.execSQL(str);
            }
        } catch (Exception unused) {
        }
    }

    private void a(String str) {
        if (com.zm.fda.O022Z.b() && !TextUtils.isEmpty(str)) {
            HashMap map = new HashMap();
            map.put(WifiNestConst.OtherConst.KEY_MSG, str);
            com.zm.fda.O022Z.a().track(ZZ00Z.OO22Z.b, map);
        }
    }
}
