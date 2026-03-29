package com.amap.api.col.p0002sl;

import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.x;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
@hi(a = "a")
public final class gd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @hj(a = "a1", b = 6)
    private String f2823a;

    @hj(a = "a2", b = 6)
    private String b;

    @hj(a = "a6", b = 2)
    private int c;

    @hj(a = "a3", b = 6)
    private String d;

    @hj(a = "a4", b = 6)
    private String e;

    @hj(a = "a5", b = 6)
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String[] l;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f2824a;
        private String b;
        private String c;
        private String d;
        private boolean e = true;
        private String f = "standard";
        private String[] g = null;

        public a(String str, String str2, String str3) {
            this.f2824a = str2;
            this.b = str2;
            this.d = str3;
            this.c = str;
        }

        public final a a(boolean z) {
            this.e = z;
            return this;
        }

        public final a a(String[] strArr) {
            if (strArr != null) {
                this.g = (String[]) strArr.clone();
            }
            return this;
        }

        public final a a(String str) {
            this.b = str;
            return this;
        }

        public final gd a() throws fq {
            if (this.g != null) {
                return new gd(this, (byte) 0);
            }
            throw new fq("sdk packages is null");
        }
    }

    public /* synthetic */ gd(a aVar, byte b) {
        this(aVar);
    }

    public final void a(boolean z) {
        this.c = z ? 1 : 0;
    }

    public final String b() {
        return this.g;
    }

    public final String c() {
        if (TextUtils.isEmpty(this.h) && !TextUtils.isEmpty(this.b)) {
            this.h = ge.c(this.b);
        }
        return this.h;
    }

    public final String d() {
        if (TextUtils.isEmpty(this.i) && !TextUtils.isEmpty(this.d)) {
            this.i = ge.c(this.d);
        }
        return this.i;
    }

    public final String e() {
        if (TextUtils.isEmpty(this.k) && !TextUtils.isEmpty(this.f)) {
            this.k = ge.c(this.f);
        }
        if (TextUtils.isEmpty(this.k)) {
            this.k = "standard";
        }
        return this.k;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (gd.class != obj.getClass()) {
            return false;
        }
        try {
            if (this.j.equals(((gd) obj).j) && this.g.equals(((gd) obj).g)) {
                if (this.h.equals(((gd) obj).h)) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public final boolean f() {
        return this.c == 1;
    }

    public final String[] g() {
        String[] strArr = this.l;
        if ((strArr == null || strArr.length == 0) && !TextUtils.isEmpty(this.e)) {
            this.l = a(ge.c(this.e));
        }
        return (String[]) this.l.clone();
    }

    private gd() {
        this.c = 1;
        this.l = null;
    }

    public final String a() {
        if (TextUtils.isEmpty(this.j) && !TextUtils.isEmpty(this.f2823a)) {
            this.j = ge.c(this.f2823a);
        }
        return this.j;
    }

    private gd(a aVar) {
        this.c = 1;
        this.l = null;
        this.g = aVar.f2824a;
        this.h = aVar.b;
        this.j = aVar.c;
        this.i = aVar.d;
        this.c = aVar.e ? 1 : 0;
        this.k = aVar.f;
        this.l = aVar.g;
        this.b = ge.b(this.h);
        this.f2823a = ge.b(this.j);
        this.d = ge.b(this.i);
        this.e = ge.b(a(this.l));
        this.f = ge.b(this.k);
    }

    private static String[] a(String str) {
        try {
            return str.split(x.aQ);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static String a(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            for (String str : strArr) {
                sb.append(str);
                sb.append(x.aQ);
            }
            return sb.toString();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
