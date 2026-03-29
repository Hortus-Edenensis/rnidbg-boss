package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class jw5 {
    public static int a(int i, int i2) {
        return i & (~i2);
    }

    public static int b(int i, int i2) {
        return i | i2;
    }

    public static boolean c(int i, int i2) {
        return (i & i2) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public static int d(int i, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        ?? r1 = z;
        if (z2) {
            r1 = (z ? 1 : 0) | 2;
        }
        if (z3) {
            r1 = (r1 == true ? 1 : 0) | 4;
        }
        if (z4) {
            r1 = (r1 == true ? 1 : 0) | '\b';
        }
        return z5 ? r1 | 1024 : r1;
    }

    public static boolean e(int i) {
        return (i & 8) > 0;
    }

    public static boolean f(int i, int i2) {
        return (i & i2) > 0;
    }

    public static boolean g(int i) {
        return (i & 2) > 0;
    }

    public static boolean h(int i) {
        return (i & 128) <= 0;
    }

    public static boolean i(int i) {
        return (i & 1024) > 0;
    }

    public static boolean j(int i) {
        return (i & 1) > 0;
    }

    public static boolean k(int i) {
        return (i & 4) > 0;
    }
}
