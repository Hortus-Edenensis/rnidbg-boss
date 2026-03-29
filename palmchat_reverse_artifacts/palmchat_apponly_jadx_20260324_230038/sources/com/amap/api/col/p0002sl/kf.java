package com.amap.api.col.p0002sl;

import android.os.SystemClock;
import android.util.LongSparseArray;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class kf {
    private static volatile kf g;
    private static Object h = new Object();
    private Object e = new Object();
    private Object f = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LongSparseArray<a> f2939a = new LongSparseArray<>();
    private LongSparseArray<a> b = new LongSparseArray<>();
    private LongSparseArray<a> c = new LongSparseArray<>();
    private LongSparseArray<a> d = new LongSparseArray<>();

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f2940a;
        long b;
        boolean c;

        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    private kf() {
    }

    public static kf a() {
        if (g == null) {
            synchronized (h) {
                if (g == null) {
                    g = new kf();
                }
            }
        }
        return g;
    }

    public final void b(List<ke> list) {
        if (list.isEmpty()) {
            return;
        }
        synchronized (this.f) {
            a(list, this.c, this.d);
            LongSparseArray<a> longSparseArray = this.c;
            this.c = this.d;
            this.d = longSparseArray;
            longSparseArray.clear();
        }
    }

    public final void a(List<ke> list) {
        if (list.isEmpty()) {
            return;
        }
        synchronized (this.e) {
            a(list, this.f2939a, this.b);
            LongSparseArray<a> longSparseArray = this.f2939a;
            this.f2939a = this.b;
            this.b = longSparseArray;
            longSparseArray.clear();
        }
    }

    public final short b(long j) {
        return a(this.c, j);
    }

    private static long b() {
        return SystemClock.elapsedRealtime();
    }

    public final short a(long j) {
        return a(this.f2939a, j);
    }

    private static void a(List<ke> list, LongSparseArray<a> longSparseArray, LongSparseArray<a> longSparseArray2) {
        long jB = b();
        byte b = 0;
        if (longSparseArray.size() == 0) {
            for (ke keVar : list) {
                a aVar = new a(b);
                aVar.f2940a = keVar.b();
                aVar.b = jB;
                aVar.c = false;
                longSparseArray2.put(keVar.a(), aVar);
            }
            return;
        }
        for (ke keVar2 : list) {
            long jA = keVar2.a();
            a aVar2 = longSparseArray.get(jA);
            if (aVar2 == null) {
                aVar2 = new a(b);
                aVar2.f2940a = keVar2.b();
                aVar2.b = jB;
                aVar2.c = true;
            } else if (aVar2.f2940a != keVar2.b()) {
                aVar2.f2940a = keVar2.b();
                aVar2.b = jB;
                aVar2.c = true;
            }
            longSparseArray2.put(jA, aVar2);
        }
    }

    private static short a(LongSparseArray<a> longSparseArray, long j) {
        synchronized (longSparseArray) {
            a aVar = longSparseArray.get(j);
            if (aVar == null) {
                return (short) 0;
            }
            short sMax = (short) Math.max(1L, Math.min(32767L, (b() - aVar.b) / 1000));
            if (!aVar.c) {
                sMax = (short) (-sMax);
            }
            return sMax;
        }
    }
}
