package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class yg4 {
    public static boolean a(int i, int i2) {
        return (i & i2) != 0;
    }

    public static int b(int i, boolean z, int i2) {
        return z ? i | i2 : i & (~i2);
    }
}
