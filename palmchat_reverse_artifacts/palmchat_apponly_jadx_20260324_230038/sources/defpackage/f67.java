package defpackage;

import java.util.Random;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public final class f67 {
    public static long b = System.currentTimeMillis();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Random f17468a = new Random(b);

    public static int a(int i, int i2) {
        return i + f17468a.nextInt(i2 - i);
    }
}
