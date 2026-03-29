package com.baidu.location.c;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.telephony.CellInfo;
import android.telephony.TelephonyManager;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class g {
    private static boolean d = false;
    private static e e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f3502a = true;
    private boolean b = true;
    private boolean c = false;

    /* JADX INFO: renamed from: com.baidu.location.c.g$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3503a;

        static {
            int[] iArr = new int[a.values().length];
            f3503a = iArr;
            try {
                iArr[a.ONLY_CELL_MODE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3503a[a.ONLY_WIFI_MODE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3503a[a.GET_ALL_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum a {
        ONLY_CELL_MODE,
        ONLY_WIFI_MODE,
        GET_ALL_DATA
    }

    public static e i() {
        return e;
    }

    public com.baidu.location.c.a a(com.baidu.location.c.a aVar, TelephonyManager telephonyManager) {
        return com.baidu.location.c.a.a.a().b(aVar, telephonyManager);
    }

    public HashSet<String> b(com.baidu.location.c.a aVar) {
        return com.baidu.location.c.a.a.a().c(aVar);
    }

    public long c() {
        return com.baidu.location.c.a.b.a().c();
    }

    public List<CellInfo> d() {
        return com.baidu.location.c.a.a.a().d();
    }

    public com.baidu.location.c.a e(int i) {
        if (this.c && this.f3502a) {
            return com.baidu.location.c.a.a.a().d(i);
        }
        return null;
    }

    public k f(int i) {
        if (this.c && this.b) {
            return com.baidu.location.c.a.b.a().a(i);
        }
        return null;
    }

    public WifiInfo g() {
        return com.baidu.location.c.a.b.a().f();
    }

    public k h() {
        return com.baidu.location.c.a.b.a().d();
    }

    public String a(int i, boolean z, k kVar, int i2) {
        return com.baidu.location.c.a.b.a().a(i, z, kVar, i2);
    }

    public void b() {
        if (this.f3502a) {
            com.baidu.location.c.a.a.a().b();
        }
        if (this.b) {
            com.baidu.location.c.a.b.a().b();
        }
        this.c = false;
    }

    public String c(com.baidu.location.c.a aVar) {
        return com.baidu.location.c.a.a.a().b(aVar);
    }

    public void d(int i) {
        com.baidu.location.c.a.a.a().b(Math.max(i, 29));
    }

    public boolean e() {
        return com.baidu.location.c.a.a.a().c();
    }

    public String f() {
        return com.baidu.location.c.a.b.a().e();
    }

    public String a(WifiInfo wifiInfo, String str) {
        return com.baidu.location.c.a.b.a().a(wifiInfo, str);
    }

    public void b(int i) {
        com.baidu.location.c.a.a.a().c(i);
    }

    public void c(int i) {
        if (i >= 0) {
            com.baidu.location.c.a.b.a().a(i);
        }
    }

    public String a(com.baidu.location.c.a aVar) {
        return com.baidu.location.c.a.a.a().a(aVar);
    }

    public void b(boolean z) {
        com.baidu.location.c.a.a.a().b(z);
    }

    public String a(k kVar, int i, String str, boolean z, int i2) {
        return com.baidu.location.c.a.b.a().a(kVar, i, str, z, i2);
    }

    public void a(int i) {
        if (i >= 0) {
            com.baidu.location.c.a.a.a().a(i);
        }
    }

    public void a(Context context, List<String> list) {
        if (this.f3502a) {
            com.baidu.location.c.a.a.a().a(context);
        }
        if (this.b) {
            com.baidu.location.c.a.b.a().a(context, list);
        }
        this.c = true;
    }

    public void a(e eVar) {
        e = eVar;
    }

    public void a(a aVar) {
        int i = AnonymousClass1.f3503a[aVar.ordinal()];
        if (i == 1) {
            this.f3502a = true;
            this.b = false;
            return;
        }
        if (i == 2) {
            this.f3502a = false;
        } else {
            if (i != 3) {
                throw new IllegalArgumentException("Illegal this mode : " + aVar);
            }
            this.f3502a = true;
        }
        this.b = true;
    }

    public void a(boolean z) {
        com.baidu.location.c.a.a.a().a(z);
    }

    public static boolean a() {
        return d;
    }

    public boolean a(com.baidu.location.c.a aVar, com.baidu.location.c.a aVar2) {
        return com.baidu.location.c.a.a.a().a(aVar, aVar2);
    }
}
