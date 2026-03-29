package com.bytedance.sdk.component.fx.nr;

import java.util.concurrent.TimeUnit;
import org.apache.http.HttpHeaders;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f5117a;
    private final boolean b;
    String fx;
    private final int iz;
    private final boolean jk;
    private final boolean k;
    private final int l;
    private final boolean mv;
    private final boolean n;
    private final boolean pn;
    private final boolean s;
    private final int t;
    private final int x;
    public static final b u = new u().u().fx();
    public static final b nr = new u().nr().u(Integer.MAX_VALUE, TimeUnit.SECONDS).fx();

    /* JADX INFO: compiled from: SearchBox */
    public static final class u {
        boolean iz;
        boolean n;
        boolean nr;
        boolean u;
        boolean x;
        int fx = -1;
        int b = -1;
        int pn = -1;

        public b fx() {
            return new b(this);
        }

        public u nr() {
            this.iz = true;
            return this;
        }

        public u u() {
            this.u = true;
            return this;
        }

        public u u(int i, TimeUnit timeUnit) {
            if (i < 0) {
                throw new IllegalArgumentException("maxStale < 0: ".concat(String.valueOf(i)));
            }
            long seconds = timeUnit.toSeconds(i);
            this.b = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
            return this;
        }
    }

    private b(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, boolean z8, String str) {
        this.b = z;
        this.pn = z2;
        this.iz = i;
        this.x = i2;
        this.n = z3;
        this.f5117a = z4;
        this.jk = z5;
        this.t = i3;
        this.l = i4;
        this.mv = z6;
        this.s = z7;
        this.k = z8;
        this.fx = str;
    }

    private String t() {
        StringBuilder sb = new StringBuilder();
        if (this.b) {
            sb.append("no-cache, ");
        }
        if (this.pn) {
            sb.append("no-store, ");
        }
        if (this.iz != -1) {
            sb.append("max-age=");
            sb.append(this.iz);
            sb.append(", ");
        }
        if (this.x != -1) {
            sb.append("s-maxage=");
            sb.append(this.x);
            sb.append(", ");
        }
        if (this.n) {
            sb.append("private, ");
        }
        if (this.f5117a) {
            sb.append("public, ");
        }
        if (this.jk) {
            sb.append("must-revalidate, ");
        }
        if (this.t != -1) {
            sb.append("max-stale=");
            sb.append(this.t);
            sb.append(", ");
        }
        if (this.l != -1) {
            sb.append("min-fresh=");
            sb.append(this.l);
            sb.append(", ");
        }
        if (this.mv) {
            sb.append("only-if-cached, ");
        }
        if (this.s) {
            sb.append("no-transform, ");
        }
        if (this.k) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    public boolean a() {
        return this.mv;
    }

    public boolean b() {
        return this.n;
    }

    public int fx() {
        return this.iz;
    }

    public boolean iz() {
        return this.jk;
    }

    public boolean jk() {
        return this.k;
    }

    public int n() {
        return this.l;
    }

    public boolean nr() {
        return this.pn;
    }

    public boolean pn() {
        return this.f5117a;
    }

    public String toString() {
        String str = this.fx;
        if (str != null) {
            return str;
        }
        String strT = t();
        this.fx = strT;
        return strT;
    }

    public boolean u() {
        return this.b;
    }

    public int x() {
        return this.t;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static b u(sx sxVar) {
        int i;
        int iU;
        String strTrim;
        sx sxVar2 = sxVar;
        int iU2 = sxVar.u();
        int i2 = 0;
        boolean z = true;
        String str = null;
        boolean z2 = false;
        boolean z3 = false;
        int iNr = -1;
        int iNr2 = -1;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        int iNr3 = -1;
        int iNr4 = -1;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        while (i2 < iU2) {
            String strU = sxVar2.u(i2);
            String strNr = sxVar2.nr(i2);
            if (strU.equalsIgnoreCase(HttpHeaders.CACHE_CONTROL)) {
                if (str == null) {
                    str = strNr;
                }
                for (i = 0; i < strNr.length(); i = iU) {
                    int iU3 = com.bytedance.sdk.component.fx.nr.u.fx.pn.u(strNr, i, "=,;");
                    String strTrim2 = strNr.substring(i, iU3).trim();
                    if (iU3 == strNr.length() || strNr.charAt(iU3) == ',' || strNr.charAt(iU3) == ';') {
                        iU = iU3 + 1;
                        strTrim = null;
                    } else {
                        int iU4 = com.bytedance.sdk.component.fx.nr.u.fx.pn.u(strNr, iU3 + 1);
                        if (iU4 >= strNr.length() || strNr.charAt(iU4) != '\"') {
                            iU = com.bytedance.sdk.component.fx.nr.u.fx.pn.u(strNr, iU4, ",;");
                            strTrim = strNr.substring(iU4, iU).trim();
                        } else {
                            int i3 = iU4 + 1;
                            int iU5 = com.bytedance.sdk.component.fx.nr.u.fx.pn.u(strNr, i3, "\"");
                            strTrim = strNr.substring(i3, iU5);
                            iU = iU5 + 1;
                        }
                    }
                    if ("no-cache".equalsIgnoreCase(strTrim2)) {
                        z2 = true;
                    } else if ("no-store".equalsIgnoreCase(strTrim2)) {
                        z3 = true;
                    } else if ("max-age".equalsIgnoreCase(strTrim2)) {
                        iNr = com.bytedance.sdk.component.fx.nr.u.fx.pn.nr(strTrim, -1);
                    } else if ("s-maxage".equalsIgnoreCase(strTrim2)) {
                        iNr2 = com.bytedance.sdk.component.fx.nr.u.fx.pn.nr(strTrim, -1);
                    } else if ("private".equalsIgnoreCase(strTrim2)) {
                        z4 = true;
                    } else if ("public".equalsIgnoreCase(strTrim2)) {
                        z5 = true;
                    } else if ("must-revalidate".equalsIgnoreCase(strTrim2)) {
                        z6 = true;
                    } else if ("max-stale".equalsIgnoreCase(strTrim2)) {
                        iNr3 = com.bytedance.sdk.component.fx.nr.u.fx.pn.nr(strTrim, Integer.MAX_VALUE);
                    } else if ("min-fresh".equalsIgnoreCase(strTrim2)) {
                        iNr4 = com.bytedance.sdk.component.fx.nr.u.fx.pn.nr(strTrim, -1);
                    } else if ("only-if-cached".equalsIgnoreCase(strTrim2)) {
                        z7 = true;
                    } else if ("no-transform".equalsIgnoreCase(strTrim2)) {
                        z8 = true;
                    } else if ("immutable".equalsIgnoreCase(strTrim2)) {
                        z9 = true;
                    }
                }
                i2++;
                sxVar2 = sxVar;
            } else if (!strU.equalsIgnoreCase(HttpHeaders.PRAGMA)) {
                i2++;
                sxVar2 = sxVar;
            }
            z = false;
            while (i < strNr.length()) {
            }
            i2++;
            sxVar2 = sxVar;
        }
        return new b(z2, z3, iNr, iNr2, z4, z5, z6, iNr3, iNr4, z7, z8, z9, !z ? null : str);
    }

    public b(u uVar) {
        this.b = uVar.u;
        this.pn = uVar.nr;
        this.iz = uVar.fx;
        this.x = -1;
        this.n = false;
        this.f5117a = false;
        this.jk = false;
        this.t = uVar.b;
        this.l = uVar.pn;
        this.mv = uVar.iz;
        this.s = uVar.x;
        this.k = uVar.n;
    }
}
