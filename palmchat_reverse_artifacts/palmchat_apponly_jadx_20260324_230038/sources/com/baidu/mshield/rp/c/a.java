package com.baidu.mshield.rp.c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Base64;
import com.amap.api.col.p0002sl.hb;
import com.baidu.mshield.ac.F;
import com.kuaishou.weapon.p0.t;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f4032a;
    public C0094a b;
    public SQLiteDatabase c;
    public Context d;

    public a(Context context) {
        this.d = context;
        this.b = new C0094a(this, context);
        com.baidu.mshield.sharedpreferences.a.a(context);
        d();
    }

    public static synchronized a a(Context context) {
        if (f4032a == null) {
            f4032a = new a(context);
        }
        return f4032a;
    }

    public boolean b(String str) {
        boolean z = true;
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = this.c.query("c", null, "b=?", new String[]{str}, null, null, null);
                if (cursorQuery != null) {
                    if (cursorQuery.getCount() > 0) {
                        z = false;
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Throwable th) {
                try {
                    com.baidu.mshield.utility.a.a(th);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                } catch (Throwable th2) {
                    if (cursorQuery != null) {
                        try {
                            cursorQuery.close();
                        } catch (Throwable th3) {
                            com.baidu.mshield.utility.a.a(th3);
                        }
                    }
                    throw th2;
                }
            }
        } catch (Throwable th4) {
            com.baidu.mshield.utility.a.a(th4);
        }
        return z;
    }

    public List<com.baidu.mshield.rp.d.a> c() {
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = this.c.query(t.k, null, "i=5", null, null, null, "d desc", "100");
                if (cursorQuery != null) {
                    while (cursorQuery.moveToNext()) {
                        com.baidu.mshield.rp.d.a aVar = new com.baidu.mshield.rp.d.a();
                        aVar.f4033a = cursorQuery.getInt(cursorQuery.getColumnIndex("a"));
                        aVar.b = cursorQuery.getString(cursorQuery.getColumnIndex(t.l));
                        aVar.c = cursorQuery.getInt(cursorQuery.getColumnIndex("c"));
                        aVar.e = cursorQuery.getLong(cursorQuery.getColumnIndex("d"));
                        aVar.f = cursorQuery.getInt(cursorQuery.getColumnIndex("g"));
                        aVar.g = cursorQuery.getInt(cursorQuery.getColumnIndex("e"));
                        aVar.h = cursorQuery.getInt(cursorQuery.getColumnIndex("f"));
                        aVar.i = cursorQuery.getInt(cursorQuery.getColumnIndex("i"));
                        aVar.j = cursorQuery.getString(cursorQuery.getColumnIndex(hb.j));
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("h"));
                        try {
                            string = new String(F.getInstance().ad(Base64.decode(string, 0), "xVOTuxgN3lkRN2v4".getBytes("utf-8")));
                        } catch (Exception e) {
                            com.baidu.mshield.utility.a.a(e);
                        }
                        aVar.d = string;
                        arrayList.add(aVar);
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Throwable th) {
                com.baidu.mshield.utility.a.a(th);
            }
        } catch (Throwable th2) {
            try {
                com.baidu.mshield.utility.a.a(th2);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Throwable th3) {
                if (cursorQuery != null) {
                    try {
                        cursorQuery.close();
                    } catch (Throwable th4) {
                        com.baidu.mshield.utility.a.a(th4);
                    }
                }
                throw th3;
            }
        }
        return arrayList;
    }

    public final void d() {
        try {
            this.c = this.b.getWritableDatabase();
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
    }

    public long a(com.baidu.mshield.rp.d.a aVar) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(t.l, aVar.b);
            contentValues.put("c", Integer.valueOf(aVar.c));
            contentValues.put("d", Long.valueOf(aVar.e));
            contentValues.put("e", Integer.valueOf(aVar.g));
            contentValues.put("g", Integer.valueOf(aVar.f));
            contentValues.put("f", Integer.valueOf(aVar.h));
            contentValues.put("i", Integer.valueOf(aVar.i));
            contentValues.put(hb.j, aVar.j);
            String strEncodeToString = aVar.d;
            try {
                strEncodeToString = Base64.encodeToString(F.getInstance().ae(strEncodeToString.getBytes(), "xVOTuxgN3lkRN2v4".getBytes("utf-8")), 0);
            } catch (Exception e) {
                com.baidu.mshield.utility.a.a(e);
            }
            contentValues.put("h", strEncodeToString);
            try {
                return this.c.insert(t.k, null, contentValues);
            } catch (Throwable th) {
                com.baidu.mshield.utility.a.a(th);
                return -1L;
            }
        } catch (Throwable th2) {
            com.baidu.mshield.utility.a.a(th2);
            return -1L;
        }
    }

    public List<com.baidu.mshield.rp.d.a> b(int i) {
        String str;
        Cursor cursor;
        Cursor cursorQuery;
        ArrayList arrayList = new ArrayList();
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            com.baidu.mshield.sharedpreferences.a aVarA = com.baidu.mshield.sharedpreferences.a.a(this.d);
            int iF = aVarA.F() * 3600000;
            if (i == 2) {
                str = "(d <= (" + jCurrentTimeMillis + "-e*3600000) or e=0 )";
            } else {
                str = "(d <= (" + jCurrentTimeMillis + "-e*3600000) or e=0 ) and (g!=2 or d<=" + (jCurrentTimeMillis - ((long) iF)) + ")";
            }
            String str2 = str;
            try {
                try {
                    if (i == 2) {
                        cursorQuery = this.c.query(t.k, null, str2, null, null, null, "d desc", Integer.toString(100));
                    } else {
                        cursorQuery = this.c.query(t.k, null, str2, null, null, null, "d desc", Integer.toString(aVarA.h()));
                    }
                    cursor = cursorQuery;
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            try {
                                com.baidu.mshield.rp.d.a aVar = new com.baidu.mshield.rp.d.a();
                                aVar.f4033a = cursor.getInt(cursor.getColumnIndex("a"));
                                aVar.b = cursor.getString(cursor.getColumnIndex(t.l));
                                aVar.c = cursor.getInt(cursor.getColumnIndex("c"));
                                aVar.e = cursor.getLong(cursor.getColumnIndex("d"));
                                aVar.f = cursor.getInt(cursor.getColumnIndex("g"));
                                aVar.g = cursor.getInt(cursor.getColumnIndex("e"));
                                aVar.h = cursor.getInt(cursor.getColumnIndex("f"));
                                aVar.i = cursor.getInt(cursor.getColumnIndex("i"));
                                aVar.j = cursor.getString(cursor.getColumnIndex(hb.j));
                                String string = cursor.getString(cursor.getColumnIndex("h"));
                                try {
                                    string = new String(F.getInstance().ad(Base64.decode(string, 0), "xVOTuxgN3lkRN2v4".getBytes("utf-8")));
                                } catch (Exception e) {
                                    com.baidu.mshield.utility.a.a(e);
                                }
                                aVar.d = string;
                                arrayList.add(aVar);
                            } catch (Throwable th) {
                                th = th;
                                try {
                                    com.baidu.mshield.utility.a.a(th);
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    return arrayList;
                                } finally {
                                    return arrayList;
                                }
                            }
                        }
                    }
                } catch (Throwable th2) {
                    com.baidu.mshield.utility.a.a(th2);
                }
            } catch (Throwable th3) {
                th = th3;
                cursor = null;
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th4) {
            com.baidu.mshield.utility.a.a(th4);
        }
        return arrayList;
    }

    public long a(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(t.l, str);
        try {
            return this.c.insert("c", null, contentValues);
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
            return -1L;
        }
    }

    public int a(int i) {
        try {
            return this.c.delete(t.k, "a=?", new String[]{i + ""});
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
            return -1;
        }
    }

    public int a(List<Integer> list) {
        int iA = -1;
        try {
            this.c.beginTransaction();
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                iA = a(it.next().intValue());
                if (iA <= 0) {
                    com.baidu.mshield.rp.f.a.f4036a = System.currentTimeMillis();
                }
            }
            this.c.setTransactionSuccessful();
            try {
                this.c.endTransaction();
            } catch (Throwable th) {
                com.baidu.mshield.utility.a.a(th);
                com.baidu.mshield.rp.f.a.f4036a = System.currentTimeMillis();
            }
        } catch (Throwable th2) {
            try {
                com.baidu.mshield.utility.a.a(th2);
                com.baidu.mshield.rp.f.a.f4036a = System.currentTimeMillis();
            } finally {
                try {
                    this.c.endTransaction();
                } catch (Throwable th3) {
                    com.baidu.mshield.utility.a.a(th3);
                    com.baidu.mshield.rp.f.a.f4036a = System.currentTimeMillis();
                }
            }
        }
        return iA;
    }

    public List<com.baidu.mshield.rp.d.a> a(boolean z, int i) {
        String str;
        Cursor cursor;
        Cursor cursorQuery;
        ArrayList arrayList = new ArrayList();
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (z) {
                str = "(d < (" + jCurrentTimeMillis + "-f*3600000) and f!= 0)";
            } else {
                str = "d<=" + (jCurrentTimeMillis - 259200000);
            }
            String str2 = str;
            try {
                try {
                    if (i == 2) {
                        cursorQuery = this.c.query(t.k, null, str2, null, null, null, "d desc", "100");
                    } else {
                        int iH = com.baidu.mshield.sharedpreferences.a.a(this.d).h();
                        com.baidu.mshield.b.c.a.b("sj-trigger report 3g limit" + Integer.toString(iH));
                        cursorQuery = this.c.query(t.k, null, str2, null, null, null, "d desc", Integer.toString(iH));
                    }
                    cursor = cursorQuery;
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            try {
                                com.baidu.mshield.rp.d.a aVar = new com.baidu.mshield.rp.d.a();
                                aVar.f4033a = cursor.getInt(cursor.getColumnIndex("a"));
                                aVar.b = cursor.getString(cursor.getColumnIndex(t.l));
                                aVar.c = cursor.getInt(cursor.getColumnIndex("c"));
                                aVar.e = cursor.getLong(cursor.getColumnIndex("d"));
                                aVar.f = cursor.getInt(cursor.getColumnIndex("g"));
                                aVar.g = cursor.getInt(cursor.getColumnIndex("e"));
                                aVar.h = cursor.getInt(cursor.getColumnIndex("f"));
                                aVar.i = cursor.getInt(cursor.getColumnIndex("i"));
                                aVar.j = cursor.getString(cursor.getColumnIndex(hb.j));
                                String string = cursor.getString(cursor.getColumnIndex("h"));
                                try {
                                    string = new String(F.getInstance().ad(Base64.decode(string, 0), "xVOTuxgN3lkRN2v4".getBytes("utf-8")));
                                } catch (Exception e) {
                                    com.baidu.mshield.utility.a.a(e);
                                }
                                aVar.d = string;
                                arrayList.add(aVar);
                            } catch (Throwable th) {
                                th = th;
                                try {
                                    com.baidu.mshield.utility.a.a(th);
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    return arrayList;
                                } finally {
                                    return arrayList;
                                }
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = null;
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th3) {
                com.baidu.mshield.utility.a.a(th3);
            }
        } catch (Throwable th4) {
            com.baidu.mshield.utility.a.a(th4);
        }
        return arrayList;
    }

    public int b() {
        Cursor cursorQuery = null;
        int count = 0;
        try {
            try {
                cursorQuery = this.c.query(t.k, null, null, null, null, null, null, null);
                if (cursorQuery != null) {
                    count = cursorQuery.getCount();
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Throwable th) {
                com.baidu.mshield.utility.a.a(th);
            }
        } catch (Throwable th2) {
            try {
                com.baidu.mshield.utility.a.a(th2);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Throwable th3) {
                if (cursorQuery != null) {
                    try {
                        cursorQuery.close();
                    } catch (Throwable th4) {
                        com.baidu.mshield.utility.a.a(th4);
                    }
                }
                throw th3;
            }
        }
        return count;
    }

    public int a() {
        com.baidu.mshield.sharedpreferences.a aVarA = com.baidu.mshield.sharedpreferences.a.a(this.d);
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            return this.c.delete(t.k, "(d <= ? or (d < (" + jCurrentTimeMillis + "-f*3600000) and f!= 0)) and " + t.l + " != '1001001'and i != 5 ", new String[]{String.valueOf(jCurrentTimeMillis - ((long) (aVarA.I() * BaseConstants.Time.DAY)))});
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
            return -1;
        }
    }

    /* JADX INFO: renamed from: com.baidu.mshield.rp.c.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C0094a extends SQLiteOpenHelper {
        public C0094a(a aVar, Context context) {
            super(context, "msre.db", (SQLiteDatabase.CursorFactory) null, 1);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("create table if not exists r(a integer primary key autoincrement, b text, c integer, e integer,f integer,h text, g integer, i integer, j text, d long);");
            sQLiteDatabase.execSQL("create table if not exists c(a integer primary key autoincrement, b text); ");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }
}
