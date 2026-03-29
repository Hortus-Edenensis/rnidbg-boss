package com.amap.api.col.p0002sl;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static float f3056a = 0.9f;
    public static String b = "";
    public static int c = 19;
    public static int d = 3;
    public static String g;
    public static String h;
    public static int l;
    public static volatile gd p;
    public static final int e = a.f3057a;
    public static final String[] f = {"com.amap.api.mapcore2d", "com.amap.api.maps2d"};
    public static int i = 1;
    public static int j = 256;
    public static int k = 21;
    static int m = 0;
    static int n = 0;
    static int o = 0;
    public static int q = 7;
    static boolean r = true;
    static boolean s = true;
    public static boolean t = false;

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f3057a = 1;
        public static final int b = 2;
        public static final int c = 3;
        public static final int d = 4;
        private static final /* synthetic */ int[] e = {1, 2, 3, 4};
    }

    public static void a(int i2) {
        c = i2;
    }

    public static void b(int i2) {
        d = i2;
    }

    public static String a() {
        return c == 18 ? "/appmaptile?z=%d&x=%d&y=%d&lang=%s&size=1&scale=1&style=8" : "/appmaptile?z=%d&x=%d&y=%d&lang=%s&size=1&scale=1&style=7";
    }

    public static boolean b() {
        return t;
    }

    public static void a(boolean z) {
        t = z;
    }
}
