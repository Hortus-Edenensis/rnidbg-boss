package defpackage;

import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class ov2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f19882a = 1;

    public static long a() {
        long j = f19882a + 1;
        f19882a = j;
        if (j >= 2147483647L) {
            f19882a = 1L;
        }
        return f19882a;
    }

    public static byte[] b(long j, String str) {
        pv2 pv2Var = new pv2(20480);
        pv2Var.f(0);
        pv2Var.g(j);
        if (str != null && !TextUtils.isEmpty(str)) {
            pv2Var.e(rv2.G(str));
        }
        return pv2Var.c();
    }
}
