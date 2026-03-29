package com.amap.api.col.p0002sl;

import android.text.TextUtils;
import com.amap.api.col.p0002sl.hx;
import com.huawei.hms.framework.common.ContainerUtils;
import com.oplus.tblplayer.Constants;
import java.net.Proxy;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class id {
    private String d;
    private boolean e;
    private boolean f;
    hx.a o;
    int l = 20000;
    int m = 20000;
    Proxy n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f2898a = false;
    private int b = 20000;
    private boolean c = true;
    private a g = a.NORMAL;
    private b h = b.FIRST_NONDEGRADE;

    /* JADX INFO: compiled from: SearchBox */
    public enum a {
        NORMAL(0),
        INTERRUPT_IO(1),
        NEVER(2),
        FIX(3),
        SINGLE(4);

        private int f;

        a(int i) {
            this.f = i;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum b {
        FIRST_NONDEGRADE(0),
        NEVER_GRADE(1),
        DEGRADE_BYERROR(2),
        DEGRADE_ONLY(3),
        FIX_NONDEGRADE(4),
        FIX_DEGRADE_BYERROR(5),
        FIX_DEGRADE_ONLY(6);

        private int h;

        b(int i2) {
            this.h = i2;
        }

        public final int a() {
            return this.h;
        }

        public final boolean b() {
            int i2 = this.h;
            return i2 == FIRST_NONDEGRADE.h || i2 == NEVER_GRADE.h || i2 == FIX_NONDEGRADE.h;
        }

        public final boolean c() {
            int i2 = this.h;
            return i2 == DEGRADE_BYERROR.h || i2 == DEGRADE_ONLY.h || i2 == FIX_DEGRADE_BYERROR.h || i2 == FIX_DEGRADE_ONLY.h;
        }

        public final boolean d() {
            int i2 = this.h;
            return i2 == DEGRADE_BYERROR.h || i2 == FIX_DEGRADE_BYERROR.h;
        }

        public final boolean e() {
            return this.h == NEVER_GRADE.h;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum c {
        HTTP(0),
        HTTPS(1);

        private int c;

        c(int i) {
            this.c = i;
        }
    }

    private String a(String str) {
        byte[] bArrH = h();
        if (bArrH == null || bArrH.length == 0) {
            return str;
        }
        Map<String, String> mapE = e();
        HashMap<String, String> map = hx.e;
        if (map != null) {
            if (mapE != null) {
                mapE.putAll(map);
            } else {
                mapE = map;
            }
        }
        if (mapE == null) {
            return str;
        }
        String strA = ia.a(mapE);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(Constants.STRING_VALUE_UNSET);
        stringBuffer.append(strA);
        return stringBuffer.toString();
    }

    public final boolean A() {
        return this.e;
    }

    public final String B() {
        String strC;
        try {
            strC = c();
            try {
                if (TextUtils.isEmpty(strC)) {
                    strC = this.f2898a ? b(((hy) this).l()) : a(d());
                }
            } catch (Throwable th) {
                th = th;
                ha.a(th, "ht", "pnfr");
            }
        } catch (Throwable th2) {
            th = th2;
            strC = "";
        }
        return strC;
    }

    public final void b(int i) {
        this.m = i;
    }

    public String b_() {
        return f();
    }

    public String c() {
        return "";
    }

    public boolean c_() {
        return this.c;
    }

    public abstract Map<String, String> d();

    public final void d(String str) {
        this.d = str;
    }

    public abstract Map<String, String> e();

    public abstract String f();

    public byte[] h() {
        return null;
    }

    public String j() {
        return "";
    }

    public final String n() {
        return a(f());
    }

    public final String o() {
        return a(b_());
    }

    public final int p() {
        return this.l;
    }

    public final Proxy q() {
        return this.n;
    }

    public final a r() {
        return this.g;
    }

    public final boolean s() {
        return this.f2898a;
    }

    public final void t() {
        this.f2898a = true;
    }

    public final boolean u() {
        return this.f;
    }

    public final hx.a v() {
        return this.o;
    }

    public final b w() {
        return this.h;
    }

    public final int x() {
        return this.b;
    }

    public final void y() {
        this.c = false;
    }

    public final String z() {
        return this.d;
    }

    private static String b(String str) {
        String str2;
        String strTrim = "";
        try {
            if (!TextUtils.isEmpty(str)) {
                String[] strArrSplit = str.split(ContainerUtils.FIELD_DELIMITER);
                if (strArrSplit.length > 1) {
                    int length = strArrSplit.length;
                    int i = 0;
                    String str3 = "";
                    while (true) {
                        if (i >= length) {
                            str2 = "";
                            break;
                        }
                        str2 = strArrSplit[i];
                        if (str2.contains("sdkversion")) {
                            str3 = str2;
                        }
                        if (str2.contains("product")) {
                            break;
                        }
                        i++;
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        String[] strArrSplit2 = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                        if (strArrSplit2.length > 1) {
                            strTrim = strArrSplit2[1].trim();
                            if (!TextUtils.isEmpty(str3) && TextUtils.isEmpty(go.a(strTrim))) {
                                String[] strArrSplit3 = str3.split(ContainerUtils.KEY_VALUE_DELIMITER);
                                if (strArrSplit3.length > 1) {
                                    go.a(strTrim, strArrSplit3[1].trim());
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            ha.a(th, "ht", "pnfp");
        }
        return strTrim;
    }

    public final void c(int i) {
        this.b = i;
    }

    public final void a(int i) {
        this.l = i;
    }

    public final void a(Proxy proxy) {
        this.n = proxy;
    }

    public final void a(a aVar) {
        this.g = aVar;
    }

    public final void a(c cVar) {
        this.f = cVar == c.HTTPS;
    }

    public final void a(b bVar) {
        this.h = bVar;
    }

    public final void a(boolean z) {
        this.e = z;
    }

    private static String a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        try {
            if (map.containsKey("platinfo")) {
                return b(map.get("platinfo"));
            }
            return null;
        } catch (Throwable th) {
            ha.a(th, "ht", "pnfh");
            return null;
        }
    }
}
