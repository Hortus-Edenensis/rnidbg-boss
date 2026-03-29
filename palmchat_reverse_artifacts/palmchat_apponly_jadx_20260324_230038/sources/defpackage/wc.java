package defpackage;

import android.os.Looper;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public final class wc {
    public static final wc b = new wc();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x25 f21671a;

    public wc() {
        x25 x25VarB = gz4.a().b().b();
        if (x25VarB != null) {
            this.f21671a = x25VarB;
        } else {
            this.f21671a = new p73(Looper.getMainLooper());
        }
    }

    public static x25 a() {
        return b.f21671a;
    }
}
