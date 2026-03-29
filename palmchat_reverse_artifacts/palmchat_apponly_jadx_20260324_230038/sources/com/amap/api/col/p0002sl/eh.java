package com.amap.api.col.p0002sl;

import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class eh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile eh f2723a;
    private HashMap<String, ei> b = new HashMap<>();

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f2724a = true;
        private long b = 86400;
        private int c = 10;
        private double d = 0.0d;

        public final boolean a() {
            return this.f2724a;
        }

        public final long b() {
            return this.b;
        }

        public final int c() {
            return this.c;
        }

        public final double d() {
            return this.d;
        }

        public final void a(boolean z) {
            this.f2724a = z;
        }

        public final void a(long j) {
            this.b = j;
        }

        public final void a(int i) {
            this.c = i;
        }

        public final void a(double d) {
            this.d = d;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f2725a;
        Object b;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && b.class == obj.getClass()) {
                b bVar = (b) obj;
                String str = this.f2725a;
                if (str == null) {
                    return bVar.f2725a == null && this.b == bVar.b;
                }
                if (str.equals(bVar.f2725a) && this.b == bVar.b) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            String str = this.f2725a;
            int iHashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            Object obj = this.b;
            return iHashCode + (obj != null ? obj.hashCode() : 0);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f2726a;
        boolean b;

        public c(Object obj, boolean z) {
            this.f2726a = obj;
            this.b = z;
        }
    }

    public static eh a() {
        if (f2723a == null) {
            synchronized (eh.class) {
                if (f2723a == null) {
                    f2723a = new eh();
                }
            }
        }
        return f2723a;
    }

    public final boolean b(b bVar) {
        if (bVar == null) {
            return false;
        }
        for (ei eiVar : this.b.values()) {
            if (eiVar != null && eiVar.b(bVar)) {
                return true;
            }
        }
        return false;
    }

    public final synchronized ei a(String str) {
        return this.b.get(str);
    }

    public final synchronized void a(String str, ei eiVar) {
        this.b.put(str, eiVar);
    }

    public final c a(b bVar) {
        c cVarA;
        if (bVar == null) {
            return null;
        }
        for (ei eiVar : this.b.values()) {
            if (eiVar != null && (cVarA = eiVar.a(bVar)) != null) {
                return cVarA;
            }
        }
        return null;
    }

    public final void a(b bVar, Object obj) {
        for (ei eiVar : this.b.values()) {
            if (eiVar != null) {
                eiVar.a(bVar, obj);
            }
        }
    }

    public final void a(a aVar) {
        if (aVar == null) {
            return;
        }
        for (ei eiVar : this.b.values()) {
            if (eiVar != null) {
                eiVar.a(aVar);
            }
        }
    }

    public final void a(String str, a aVar) {
        ei eiVar;
        if (str == null || aVar == null || (eiVar = this.b.get(str)) == null) {
            return;
        }
        eiVar.a(aVar);
    }
}
