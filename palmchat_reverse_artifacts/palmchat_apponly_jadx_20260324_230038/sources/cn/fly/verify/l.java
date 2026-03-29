package cn.fly.verify;

import android.util.SparseArray;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class l {
    private static SparseArray<l> h;
    private static SparseArray<l> i;
    private static boolean j;
    private static volatile long k;
    private static Object l = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2403a;
    public String b;
    public String c;
    public boolean d;
    private int e;
    private Integer f;
    private String g;

    public l(int i2, String str, String str2, boolean z) {
        this.f2403a = i2;
        this.b = str;
        this.c = str2;
        this.d = z;
    }

    public static SparseArray<l> a() {
        SparseArray<l> sparseArray;
        synchronized (l) {
            if (System.currentTimeMillis() > k) {
                if (k > 0) {
                    f.a().b("[FlyVerify] ==>%s", "memory config expire");
                }
                h = null;
            }
            sparseArray = h;
        }
        return sparseArray;
    }

    public static boolean b() {
        boolean z;
        synchronized (l) {
            z = j;
        }
        return z;
    }

    public static SparseArray<l> c() {
        return i;
    }

    public int d() {
        return this.e;
    }

    public Integer e() {
        return this.f;
    }

    public String f() {
        return this.g;
    }

    public l(int i2, String str, String str2, boolean z, int i3, Integer num, String str3) {
        this.f2403a = i2;
        this.b = str;
        this.c = str2;
        this.d = z;
        this.e = i3;
        this.f = num;
        this.g = str3;
    }

    public static void a(SparseArray<l> sparseArray) {
        i = sparseArray;
    }

    public static void a(SparseArray<l> sparseArray, boolean z) {
        synchronized (l) {
            j = z;
            k = System.currentTimeMillis() + 600000;
            h = sparseArray;
        }
    }

    public void a(Integer num) {
        this.f = num;
    }

    public void a(String str) {
        this.g = str;
    }
}
