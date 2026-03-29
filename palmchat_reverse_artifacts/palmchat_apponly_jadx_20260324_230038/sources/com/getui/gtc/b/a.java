package com.getui.gtc.b;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.kuaishou.weapon.p0.t;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static C0331a f5686a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0081: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]) (LINE:130), block:B:37:0x0081 */
    public static String a(Context context) throws Throwable {
        Cursor cursorQuery;
        Cursor cursor;
        byte[] blob;
        Cursor cursor2 = null;
        if (!context.getDatabasePath("gtc.db").exists()) {
            return null;
        }
        C0331a c0331a = f5686a;
        SQLiteDatabase readableDatabase = c0331a;
        if (c0331a == null) {
            C0331a c0331a2 = new C0331a(context);
            f5686a = c0331a2;
            readableDatabase = c0331a2;
        }
        try {
            try {
                readableDatabase = f5686a.getReadableDatabase();
            } catch (Throwable th) {
                th = th;
                cursor2 = cursor;
            }
        } catch (Exception e) {
            e = e;
            readableDatabase = 0;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
            readableDatabase = 0;
        }
        try {
            cursorQuery = readableDatabase.query("i", new String[]{t.l}, "a=?", new String[]{"100"}, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToNext() && (blob = cursorQuery.getBlob(0)) != null) {
                        String str = new String(com.getui.gtc.i.a.b.a(blob, com.getui.gtc.i.a.a.a(context.getPackageName())));
                        cursorQuery.close();
                        readableDatabase.close();
                        return str;
                    }
                } catch (Exception e2) {
                    e = e2;
                    com.getui.gtc.i.c.a.b(e);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    if (readableDatabase != 0) {
                    }
                    return null;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Exception e3) {
            e = e3;
            cursorQuery = null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor2 != null) {
                cursor2.close();
            }
            if (readableDatabase != 0) {
                readableDatabase.close();
            }
            throw th;
        }
        readableDatabase.close();
        return null;
    }

    /* JADX INFO: renamed from: com.getui.gtc.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0331a extends SQLiteOpenHelper {
        public C0331a(Context context) {
            super(context, "gtc.db", (SQLiteDatabase.CursorFactory) null, 5);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }
}
