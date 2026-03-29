package com.cmic.sso.sdk.b;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.telephony.SubscriptionManager;
import com.cmic.sso.sdk.e.c;
import com.cmic.sso.sdk.e.m;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f5488a;
    private static long b;
    private C0322a c = null;

    /* JADX INFO: renamed from: com.cmic.sso.sdk.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0322a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f5489a = -1;
        private int b = -1;

        public int a() {
            return this.b;
        }
    }

    private a() {
    }

    public static a a() {
        if (f5488a == null) {
            f5488a = new a();
        }
        return f5488a;
    }

    public C0322a b() {
        C0322a c0322a = this.c;
        return c0322a == null ? new C0322a() : c0322a;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0093 A[PHI: r2
      0x0093: PHI (r2v5 android.database.Cursor) = (r2v4 android.database.Cursor), (r2v6 android.database.Cursor) binds: [B:23:0x0091, B:18:0x0087] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(Context context) {
        c.b("UMCTelephonyManagement", "readSimInfoDbStart");
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = context.getContentResolver().query(Uri.parse("content://telephony/siminfo"), new String[]{"_id", "sim_id"}, "sim_id>=?", new String[]{"0"}, null);
                if (cursorQuery != null) {
                    while (cursorQuery.moveToNext()) {
                        int i = cursorQuery.getInt(cursorQuery.getColumnIndex("sim_id"));
                        int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex("_id"));
                        if (this.c.f5489a == -1 && this.c.b != -1 && this.c.b == i2) {
                            this.c.f5489a = i;
                            c.b("UMCTelephonyManagement", "通过读取sim db获取数据流量卡的卡槽值：" + i);
                        }
                        if (this.c.f5489a == i) {
                            this.c.b = i2;
                        }
                    }
                }
            } catch (Exception unused) {
                c.a("UMCTelephonyManagement", "readSimInfoDb error");
                if (cursorQuery != null) {
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            c.b("UMCTelephonyManagement", "readSimInfoDbEnd");
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    public void a(Context context, boolean z) {
        long jCurrentTimeMillis = System.currentTimeMillis() - b;
        if (jCurrentTimeMillis >= 5000 || jCurrentTimeMillis <= 0) {
            this.c = new C0322a();
            if (z) {
                a(context);
                if (m.e() && m.d()) {
                    c.b("UMCTelephonyManagement", "华为手机兼容性处理");
                    if (this.c.b == 0 || this.c.b == 1) {
                        if (this.c.f5489a == -1) {
                            C0322a c0322a = this.c;
                            c0322a.f5489a = c0322a.b;
                        }
                        this.c.b = -1;
                    }
                    if (this.c.f5489a != -1 || this.c.b != -1) {
                        b(context);
                    }
                }
                b = System.currentTimeMillis();
            }
        }
    }

    private void a(Context context) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 22) {
            SubscriptionManager subscriptionManagerFrom = SubscriptionManager.from(context.getApplicationContext());
            if (subscriptionManagerFrom != null) {
                try {
                    if (this.c.f5489a == -1 && i >= 24) {
                        this.c.b = SubscriptionManager.getDefaultDataSubscriptionId();
                        c.b("UMCTelephonyManagement", "android 7.0及以上手机getDefaultDataSubscriptionId适配成功: dataSubId = " + this.c.b);
                        return;
                    }
                } catch (Exception unused) {
                    c.a("UMCTelephonyManagement", "android 7.0及以上手机getDefaultDataSubscriptionId适配失败");
                }
                try {
                    Object objInvoke = subscriptionManagerFrom.getClass().getMethod("getDefaultDataSubId", new Class[0]).invoke(subscriptionManagerFrom, new Object[0]);
                    if ((objInvoke instanceof Integer) || (objInvoke instanceof Long)) {
                        this.c.b = ((Integer) objInvoke).intValue();
                        c.b("UMCTelephonyManagement", "android 7.0以下手机getDefaultDataSubId适配成功: dataSubId = " + this.c.b);
                        return;
                    }
                } catch (Exception unused2) {
                    c.a("UMCTelephonyManagement", "readDefaultDataSubId-->getDefaultDataSubId 反射出错");
                }
                try {
                    Object objInvoke2 = subscriptionManagerFrom.getClass().getMethod("getDefaultDataSubscriptionId", new Class[0]).invoke(subscriptionManagerFrom, new Object[0]);
                    if ((objInvoke2 instanceof Integer) || (objInvoke2 instanceof Long)) {
                        this.c.b = ((Integer) objInvoke2).intValue();
                        c.b("UMCTelephonyManagement", "反射getDefaultDataSubscriptionId适配成功: dataSubId = " + this.c.b);
                        return;
                    }
                    return;
                } catch (Exception unused3) {
                    c.a("UMCTelephonyManagement", "getDefaultDataSubscriptionId-->getDefaultDataSubscriptionId 反射出错");
                    return;
                }
            }
            return;
        }
        this.c.f5489a = -1;
    }
}
