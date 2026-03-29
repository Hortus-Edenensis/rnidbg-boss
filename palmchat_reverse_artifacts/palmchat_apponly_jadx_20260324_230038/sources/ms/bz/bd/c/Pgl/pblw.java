package ms.bz.bd.c.Pgl;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public final class pblw {
    public static final pblw b = new pblw();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f19340a;

    public static pblw b() {
        return b;
    }

    public final Context a() {
        return this.f19340a;
    }

    public final void c(Context context) {
        this.f19340a = context != null ? context.getApplicationContext() : null;
    }
}
