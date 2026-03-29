package com.amap.api.col.p0002sl;

import android.os.SystemClock;
import com.amap.api.col.p0002sl.jk;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class jl {
    private static volatile jl g;
    private static Object h = new Object();
    private long c;
    private kq d;
    private kq f = new kq();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private jk f2932a = new jk();
    private jm b = new jm();
    private jh e = new jh();

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public kq f2933a;
        public List<kr> b;
        public long c;
        public long d;
        public boolean e;
        public long f;
        public byte g;
        public String h;
        public List<kk> i;
        public boolean j;
    }

    private jl() {
    }

    public static jl a() {
        if (g == null) {
            synchronized (h) {
                if (g == null) {
                    g = new jl();
                }
            }
        }
        return g;
    }

    public final jn a(a aVar) {
        jn jnVar = null;
        if (aVar == null) {
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        kq kqVar = this.d;
        if (kqVar == null || aVar.f2933a.a(kqVar) >= 10.0d) {
            jk.a aVarA = this.f2932a.a(aVar.f2933a, aVar.j, aVar.g, aVar.h, aVar.i);
            List<kr> listA = this.b.a(aVar.f2933a, aVar.b, aVar.e, aVar.d, jCurrentTimeMillis);
            if (aVarA != null || listA != null) {
                ki.a(this.f, aVar.f2933a, aVar.f, jCurrentTimeMillis);
                jnVar = new jn(0, this.e.a(this.f, aVarA, aVar.c, listA));
            }
            this.d = aVar.f2933a;
            this.c = jElapsedRealtime;
        }
        return jnVar;
    }
}
