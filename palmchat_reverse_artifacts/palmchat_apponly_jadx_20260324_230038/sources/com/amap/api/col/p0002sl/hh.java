package com.amap.api.col.p0002sl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.be;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class hh {
    private static Map<Class<? extends hg>, hg> d = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private hk f2865a;
    private SQLiteDatabase b;
    private hg c;

    public hh(Context context, hg hgVar) {
        try {
            this.f2865a = new hk(context.getApplicationContext(), hgVar.a(), hgVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.c = hgVar;
    }

    public static synchronized hg a(Class<? extends hg> cls) throws IllegalAccessException, InstantiationException {
        if (d.get(cls) == null) {
            d.put(cls, cls.newInstance());
        }
        return d.get(cls);
    }

    private <T> void b(String str, Object obj) {
        a(str, obj);
    }

    private <T> void b(T t) {
        SQLiteDatabase sQLiteDatabase;
        synchronized (this.c) {
            SQLiteDatabase sQLiteDatabaseB = b();
            this.b = sQLiteDatabaseB;
            if (sQLiteDatabaseB == null) {
                return;
            }
            try {
                a(sQLiteDatabaseB, t);
                sQLiteDatabase = this.b;
            } catch (Throwable th) {
                try {
                    ha.a(th, "dbs", "itd");
                    SQLiteDatabase sQLiteDatabase2 = this.b;
                    if (sQLiteDatabase2 != null) {
                        sQLiteDatabase2.close();
                    }
                } catch (Throwable th2) {
                    SQLiteDatabase sQLiteDatabase3 = this.b;
                    if (sQLiteDatabase3 != null) {
                        sQLiteDatabase3.close();
                        this.b = null;
                    }
                    throw th2;
                }
            }
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
                this.b = null;
            }
        }
    }

    private <T> void a(String str, Object obj) {
        SQLiteDatabase sQLiteDatabase;
        synchronized (this.c) {
            if (obj == null) {
                return;
            }
            hi hiVarB = b((Class) obj.getClass());
            String strA = a(hiVarB);
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            ContentValues contentValuesA = a(obj, hiVarB);
            SQLiteDatabase sQLiteDatabaseB = b();
            this.b = sQLiteDatabaseB;
            if (sQLiteDatabaseB == null) {
                return;
            }
            try {
                sQLiteDatabaseB.update(strA, contentValuesA, str, null);
                sQLiteDatabase = this.b;
            } catch (Throwable th) {
                try {
                    ha.a(th, "dbs", "udd");
                    SQLiteDatabase sQLiteDatabase2 = this.b;
                    if (sQLiteDatabase2 != null) {
                        sQLiteDatabase2.close();
                    }
                } catch (Throwable th2) {
                    SQLiteDatabase sQLiteDatabase3 = this.b;
                    if (sQLiteDatabase3 != null) {
                        sQLiteDatabase3.close();
                        this.b = null;
                    }
                    throw th2;
                }
            }
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
                this.b = null;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:? A[Catch: all -> 0x00dc, SYNTHETIC, TryCatch #7 {, blocks: (B:4:0x0003, B:6:0x0014, B:7:0x001a, B:9:0x001e, B:28:0x005e, B:27:0x0057, B:21:0x0045, B:62:0x00b6, B:44:0x0089, B:37:0x0073, B:55:0x009f, B:76:0x00d9, B:75:0x00d2, B:69:0x00c0, B:77:0x00da, B:70:0x00c7, B:72:0x00cb, B:34:0x006e, B:18:0x0040, B:22:0x004c, B:24:0x0050, B:50:0x0091, B:52:0x009a, B:66:0x00bb), top: B:96:0x0003, inners: #1, #2, #4, #5, #6, #9, #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0050 A[Catch: all -> 0x0056, TRY_LEAVE, TryCatch #5 {all -> 0x0056, blocks: (B:22:0x004c, B:24:0x0050), top: B:92:0x004c, outer: #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00cb A[Catch: all -> 0x00d1, TRY_LEAVE, TryCatch #1 {all -> 0x00d1, blocks: (B:70:0x00c7, B:72:0x00cb), top: B:84:0x00c7, outer: #7 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private <T> List<T> b(String str, Class<T> cls) {
        Cursor cursorQuery;
        SQLiteDatabase sQLiteDatabase;
        String str2;
        String str3;
        SQLiteDatabase sQLiteDatabase2;
        synchronized (this.c) {
            ArrayList arrayList = new ArrayList();
            hi hiVarB = b((Class) cls);
            String strA = a(hiVarB);
            if (this.b == null) {
                this.b = a();
            }
            if (this.b == null || TextUtils.isEmpty(strA) || str == null) {
                return arrayList;
            }
            try {
                cursorQuery = this.b.query(strA, null, str, null, null, null, null);
                try {
                } catch (Throwable th) {
                    th = th;
                    try {
                        ha.a(th, "dbs", be.ao);
                        try {
                            SQLiteDatabase sQLiteDatabase3 = this.b;
                            if (sQLiteDatabase3 != null) {
                                sQLiteDatabase3.close();
                                this.b = null;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            str2 = "dbs";
                            str3 = be.ao;
                            ha.a(th, str2, str3);
                        }
                    } finally {
                        if (cursorQuery != null) {
                            try {
                                cursorQuery.close();
                            } catch (Throwable th3) {
                                ha.a(th3, "dbs", be.ao);
                            }
                            try {
                                sQLiteDatabase = this.b;
                                if (sQLiteDatabase == null) {
                                    sQLiteDatabase.close();
                                    this.b = null;
                                    throw th;
                                }
                                throw th;
                            } catch (Throwable th4) {
                                ha.a(th4, "dbs", be.ao);
                            }
                        }
                        sQLiteDatabase = this.b;
                        if (sQLiteDatabase == null) {
                        }
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                cursorQuery = null;
            }
            if (cursorQuery == null) {
                this.b.close();
                this.b = null;
                if (cursorQuery != null) {
                    try {
                        cursorQuery.close();
                    } catch (Throwable th6) {
                        ha.a(th6, "dbs", be.ao);
                    }
                    try {
                        sQLiteDatabase2 = this.b;
                        if (sQLiteDatabase2 != null) {
                            sQLiteDatabase2.close();
                            this.b = null;
                        }
                    } catch (Throwable th7) {
                        ha.a(th7, "dbs", be.ao);
                    }
                    return arrayList;
                }
                sQLiteDatabase2 = this.b;
                if (sQLiteDatabase2 != null) {
                }
                return arrayList;
            }
            while (cursorQuery.moveToNext()) {
                arrayList.add(a(cursorQuery, cls, hiVarB));
            }
            try {
                cursorQuery.close();
            } catch (Throwable th8) {
                ha.a(th8, "dbs", be.ao);
            }
            try {
                SQLiteDatabase sQLiteDatabase4 = this.b;
                if (sQLiteDatabase4 != null) {
                    sQLiteDatabase4.close();
                    this.b = null;
                }
            } catch (Throwable th9) {
                th = th9;
                str2 = "dbs";
                str3 = be.ao;
                ha.a(th, str2, str3);
            }
            return arrayList;
        }
    }

    public final void a(Object obj, String str) {
        synchronized (this.c) {
            List listA = a(str, (Class) obj.getClass());
            if (listA != null && listA.size() != 0) {
                b(str, obj);
            } else {
                a(obj);
            }
        }
    }

    private <T> void a(T t) {
        b(t);
    }

    private static <T> void a(SQLiteDatabase sQLiteDatabase, T t) {
        hi hiVarB = b((Class) t.getClass());
        String strA = a(hiVarB);
        if (TextUtils.isEmpty(strA) || sQLiteDatabase == null) {
            return;
        }
        sQLiteDatabase.insert(strA, null, a(t, hiVarB));
    }

    public final <T> List<T> a(String str, Class<T> cls) {
        return b(str, (Class) cls);
    }

    private static <T> T a(Cursor cursor, Class<T> cls, hi hiVar) throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        Field[] fieldArrA = a((Class<?>) cls, hiVar.b());
        Constructor<T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
        declaredConstructor.setAccessible(true);
        T tNewInstance = declaredConstructor.newInstance(new Object[0]);
        for (Field field : fieldArrA) {
            field.setAccessible(true);
            Annotation annotation = field.getAnnotation(hj.class);
            if (annotation != null) {
                hj hjVar = (hj) annotation;
                int iB = hjVar.b();
                int columnIndex = cursor.getColumnIndex(hjVar.a());
                switch (iB) {
                    case 1:
                        field.set(tNewInstance, Short.valueOf(cursor.getShort(columnIndex)));
                        break;
                    case 2:
                        field.set(tNewInstance, Integer.valueOf(cursor.getInt(columnIndex)));
                        break;
                    case 3:
                        field.set(tNewInstance, Float.valueOf(cursor.getFloat(columnIndex)));
                        break;
                    case 4:
                        field.set(tNewInstance, Double.valueOf(cursor.getDouble(columnIndex)));
                        break;
                    case 5:
                        field.set(tNewInstance, Long.valueOf(cursor.getLong(columnIndex)));
                        break;
                    case 6:
                        field.set(tNewInstance, cursor.getString(columnIndex));
                        break;
                    case 7:
                        field.set(tNewInstance, cursor.getBlob(columnIndex));
                        break;
                }
            }
        }
        return tNewInstance;
    }

    private SQLiteDatabase b() {
        try {
            SQLiteDatabase sQLiteDatabase = this.b;
            if (sQLiteDatabase == null || sQLiteDatabase.isReadOnly()) {
                SQLiteDatabase sQLiteDatabase2 = this.b;
                if (sQLiteDatabase2 != null) {
                    sQLiteDatabase2.close();
                }
                this.b = this.f2865a.getWritableDatabase();
            }
        } catch (Throwable th) {
            ha.a(th, "dbs", "gwd");
        }
        return this.b;
    }

    private static void a(Object obj, Field field, ContentValues contentValues) {
        Annotation annotation = field.getAnnotation(hj.class);
        if (annotation == null) {
        }
        hj hjVar = (hj) annotation;
        try {
            switch (hjVar.b()) {
                case 1:
                    contentValues.put(hjVar.a(), Short.valueOf(field.getShort(obj)));
                    break;
                case 2:
                    contentValues.put(hjVar.a(), Integer.valueOf(field.getInt(obj)));
                    break;
                case 3:
                    contentValues.put(hjVar.a(), Float.valueOf(field.getFloat(obj)));
                    break;
                case 4:
                    contentValues.put(hjVar.a(), Double.valueOf(field.getDouble(obj)));
                    break;
                case 5:
                    contentValues.put(hjVar.a(), Long.valueOf(field.getLong(obj)));
                    break;
                case 6:
                    contentValues.put(hjVar.a(), (String) field.get(obj));
                    break;
                case 7:
                    contentValues.put(hjVar.a(), (byte[]) field.get(obj));
                    break;
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static <T> hi b(Class<T> cls) {
        Annotation annotation = cls.getAnnotation(hi.class);
        if (annotation != null) {
            return (hi) annotation;
        }
        return null;
    }

    private static ContentValues a(Object obj, hi hiVar) {
        ContentValues contentValues = new ContentValues();
        for (Field field : a(obj.getClass(), hiVar.b())) {
            field.setAccessible(true);
            a(obj, field, contentValues);
        }
        return contentValues;
    }

    private static Field[] a(Class<?> cls, boolean z) {
        if (cls == null) {
            return null;
        }
        if (z) {
            return cls.getSuperclass().getDeclaredFields();
        }
        return cls.getDeclaredFields();
    }

    private SQLiteDatabase a() {
        try {
            if (this.b == null) {
                this.b = this.f2865a.getReadableDatabase();
            }
        } catch (Throwable th) {
            ha.a(th, "dbs", "grd");
        }
        return this.b;
    }

    private static <T> String a(hi hiVar) {
        if (hiVar == null) {
            return null;
        }
        return hiVar.a();
    }
}
