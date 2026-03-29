package defpackage;

import android.content.Context;
import ms.bz.bd.c.Pgl.p0;
import ms.bz.bd.c.Pgl.q0;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class sh4 {
    public static synchronized rh4 a(String str) {
        p0 p0VarB;
        p0VarB = q0.b(str);
        return p0VarB != null ? new rh4(p0VarB) : null;
    }

    public static synchronized boolean b(Context context, qh4 qh4Var) {
        return q0.e(context, qh4Var.b());
    }

    public static synchronized void c(String str) {
        q0.d(str);
    }
}
