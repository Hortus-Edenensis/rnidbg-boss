package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.xiaomi.push.af;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class fz {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static af f481a = new af(true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile int f11589a = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static long f480a = System.currentTimeMillis();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Object f483a = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static List<a> f485a = Collections.synchronizedList(new ArrayList());

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static String f484a = "";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static com.xiaomi.push.providers.a f482a = null;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f11591a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public long f486a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public String f487a;
        public int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public long f488b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public String f489b;

        public a(String str, long j, int i, int i2, String str2, long j2) {
            this.f487a = str;
            this.f486a = j;
            this.f11591a = i;
            this.b = i2;
            this.f489b = str2;
            this.f488b = j2;
        }

        public boolean a(a aVar) {
            return TextUtils.equals(aVar.f487a, this.f487a) && TextUtils.equals(aVar.f489b, this.f489b) && aVar.f11591a == this.f11591a && aVar.b == this.b && Math.abs(aVar.f486a - this.f486a) <= 5000;
        }
    }

    private static int b(Context context) {
        av avVarM168a = au.m168a();
        if (avVarM168a == null) {
            return -1;
        }
        return avVarM168a.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, List<a> list) {
        try {
            synchronized (com.xiaomi.push.providers.a.f856a) {
                SQLiteDatabase writableDatabase = m468a(context).getWritableDatabase();
                writableDatabase.beginTransaction();
                try {
                    for (a aVar : list) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("package_name", aVar.f487a);
                        contentValues.put("message_ts", Long.valueOf(aVar.f486a));
                        contentValues.put("network_type", Integer.valueOf(aVar.f11591a));
                        contentValues.put("bytes", Long.valueOf(aVar.f488b));
                        contentValues.put("rcv", Integer.valueOf(aVar.b));
                        contentValues.put("imsi", aVar.f489b);
                        writableDatabase.insert(com.umeng.analytics.pro.f.F, null, contentValues);
                    }
                    writableDatabase.setTransactionSuccessful();
                } finally {
                    writableDatabase.endTransaction();
                }
            }
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a(th);
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m471a(Context context) {
        f11589a = b(context);
    }

    public static int a(Context context) {
        if (f11589a == -1) {
            f11589a = b(context);
        }
        return f11589a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static synchronized String m469a(Context context) {
        if (TextUtils.isEmpty(f484a)) {
            return "";
        }
        return f484a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static synchronized void m472a(String str) {
        if (!j.m656d() && !TextUtils.isEmpty(str)) {
            f484a = str;
        }
    }

    public static void a(Context context, String str, long j, boolean z, boolean z2, long j2) {
        a(context, str, a(a(context), j, z, j2, z2), z, j2);
    }

    private static void a(final Context context, String str, long j, boolean z, long j2) {
        int iA;
        boolean zIsEmpty;
        if (context == null || TextUtils.isEmpty(str) || !"com.xiaomi.xmsf".equals(context.getPackageName()) || "com.xiaomi.xmsf".equals(str) || -1 == (iA = a(context))) {
            return;
        }
        synchronized (f483a) {
            zIsEmpty = f485a.isEmpty();
            a(new a(str, j2, iA, z ? 1 : 0, iA == 0 ? m469a(context) : "", j));
        }
        if (zIsEmpty) {
            f481a.a(new af.b() { // from class: com.xiaomi.push.fz.1
                @Override // com.xiaomi.push.af.b
                public void b() {
                    ArrayList arrayList;
                    synchronized (fz.f483a) {
                        arrayList = new ArrayList(fz.f485a);
                        fz.f485a.clear();
                    }
                    fz.b(context, arrayList);
                }
            }, 5000L);
        }
    }

    private static long a(int i, long j, boolean z, long j2, boolean z2) {
        if (z && z2) {
            long j3 = f480a;
            f480a = j2;
            if (j2 - j3 > 30000 && j > 1024) {
                return j * 2;
            }
        }
        return (j * ((long) (i == 0 ? 13 : 11))) / 10;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static com.xiaomi.push.providers.a m468a(Context context) {
        com.xiaomi.push.providers.a aVar = f482a;
        if (aVar != null) {
            return aVar;
        }
        com.xiaomi.push.providers.a aVar2 = new com.xiaomi.push.providers.a(context);
        f482a = aVar2;
        return aVar2;
    }

    public static int a(String str) {
        try {
            return str.getBytes("UTF-8").length;
        } catch (UnsupportedEncodingException unused) {
            return str.getBytes().length;
        }
    }

    private static void a(a aVar) {
        for (a aVar2 : f485a) {
            if (aVar2.a(aVar)) {
                aVar2.f488b += aVar.f488b;
                return;
            }
        }
        f485a.add(aVar);
    }
}
