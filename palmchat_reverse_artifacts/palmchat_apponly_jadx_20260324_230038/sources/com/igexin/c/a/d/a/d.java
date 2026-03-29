package com.igexin.c.a.d.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public interface d {

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f7054a = 1;
        public static final int b = 2;
        public static final int c = 3;
        public static final int d = 4;
        public static final int e = 5;
        public static final int f = 6;
        private static final /* synthetic */ int[] g = {1, 2, 3, 4, 5, 6};

        private a(String str, int i) {
        }

        private static int[] a() {
            return (int[]) g.clone();
        }
    }

    void a();

    void b();

    void c();
}
