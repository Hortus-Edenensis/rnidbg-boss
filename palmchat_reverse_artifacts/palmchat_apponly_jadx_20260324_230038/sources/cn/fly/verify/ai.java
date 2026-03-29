package cn.fly.verify;

import android.text.TextUtils;
import cn.fly.verify.fq;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class ai {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ai f2064a;
    private List<String> b;
    private int c;
    private Integer d;
    private boolean f;
    private volatile long j;
    private String k;
    private String l;
    private Boolean m;
    private Integer n;
    private Integer o;
    private Integer p;
    private Integer q;
    private Integer r;
    private Integer s;
    private String t;
    private Integer u;
    private Integer v;
    private Integer w;
    private String e = "LphSZLqaUeFdyaQq";
    private final AtomicInteger g = new AtomicInteger(0);
    private volatile int h = -1;
    private volatile int i = -1;

    private ai() {
    }

    public static ai a() {
        if (f2064a == null) {
            synchronized (ai.class) {
                if (f2064a == null) {
                    f2064a = new ai();
                }
            }
        }
        return f2064a;
    }

    private boolean v() {
        String[] strArrS = s();
        if (strArrS != null) {
            for (String str : strArrS) {
                if (fq.d.k().equalsIgnoreCase(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public String b() {
        return this.l;
    }

    public String c() {
        return this.k;
    }

    public int d() {
        return this.h;
    }

    public int e() {
        int i = this.i;
        this.i = -1;
        return i;
    }

    public long f() {
        long j = this.j;
        this.j = 0L;
        return j;
    }

    public List<String> g() {
        if (this.b == null) {
            this.b = new ArrayList();
        }
        return this.b;
    }

    public int h() {
        return this.c;
    }

    public String i() {
        return this.e;
    }

    public void j(int i) {
        this.s = Integer.valueOf(i);
    }

    public Boolean k() {
        if (this.m == null) {
            this.m = Boolean.valueOf(aq.c());
        }
        return this.m;
    }

    public int l() {
        if (this.d == null) {
            this.d = Integer.valueOf(aq.l());
        }
        return this.d.intValue();
    }

    public int m() {
        if (this.n == null) {
            this.n = Integer.valueOf(aq.d());
        }
        if (this.n == null) {
            this.n = 1;
        }
        return this.n.intValue();
    }

    public int n() {
        if (this.o == null) {
            this.o = Integer.valueOf(aq.m());
        }
        if (this.o == null) {
            this.o = 1;
        }
        return this.o.intValue();
    }

    public int o() {
        if (this.p == null) {
            this.p = Integer.valueOf(aq.n());
        }
        if (this.p == null) {
            this.p = 1;
        }
        return this.p.intValue();
    }

    public int p() {
        if (v()) {
            return 0;
        }
        if (this.q == null) {
            this.q = Integer.valueOf(aq.o());
        }
        if (this.q == null) {
            this.q = 1;
        }
        return this.q.intValue();
    }

    public int q() {
        if (v()) {
            return 0;
        }
        if (this.r == null) {
            this.r = Integer.valueOf(aq.p());
        }
        if (this.r == null) {
            this.r = 1;
        }
        return this.r.intValue();
    }

    public int r() {
        if (v()) {
            return 0;
        }
        if (this.s == null) {
            this.s = Integer.valueOf(aq.q());
        }
        if (this.s == null) {
            this.s = 1;
        }
        return this.s.intValue();
    }

    public String[] s() {
        String[] strArrSplit;
        if (TextUtils.isEmpty(this.t)) {
            this.t = aq.r();
        }
        String str = this.t;
        if (str == null || (strArrSplit = str.split(",")) == null || strArrSplit.length <= 0) {
            return null;
        }
        return strArrSplit;
    }

    public int t() {
        if (this.u == null) {
            this.u = Integer.valueOf(aq.s());
        }
        if (this.u == null) {
            this.u = 0;
        }
        return this.u.intValue();
    }

    public int u() {
        if (this.w == null) {
            this.w = Integer.valueOf(aq.t());
        }
        return this.w.intValue();
    }

    public void a(int i) {
        this.h = i;
    }

    public void b(int i) {
        this.i = i;
    }

    public void c(int i) {
        this.c = i;
    }

    public void d(int i) {
        this.d = Integer.valueOf(i);
    }

    public void e(int i) {
        this.n = Integer.valueOf(i);
    }

    public void f(int i) {
        this.o = Integer.valueOf(i);
    }

    public void g(int i) {
        this.p = Integer.valueOf(i);
    }

    public void h(int i) {
        this.q = Integer.valueOf(i);
    }

    public void i(int i) {
        this.r = Integer.valueOf(i);
    }

    public boolean j() {
        return this.f;
    }

    public void k(int i) {
        this.u = Integer.valueOf(i);
    }

    public void l(int i) {
        this.v = Integer.valueOf(i);
    }

    public void m(int i) {
        this.w = Integer.valueOf(i);
    }

    public void a(long j) {
        this.j = j;
    }

    public void b(String str) {
        this.k = str;
    }

    public void c(String str) {
        this.e = str;
    }

    public void d(String str) {
        this.t = str;
    }

    public void a(Boolean bool) {
        this.m = bool;
    }

    public void a(String str) {
        this.l = str;
    }

    public void a(List<String> list) {
        this.b = list;
    }

    public void a(boolean z) {
        this.f = z;
    }
}
