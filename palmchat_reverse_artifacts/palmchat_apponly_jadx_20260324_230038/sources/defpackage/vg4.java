package defpackage;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public abstract class vg4 {
    public static final String c = y82.class.getSimpleName();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f21437a;
    public ol2 b;

    public vg4(Context context, ol2 ol2Var) {
        this.f21437a = context;
        this.b = ol2Var;
    }

    public abstract void a();

    public Context b() {
        return this.f21437a;
    }

    public abstract void c(boolean z, int i);

    public abstract void d();

    public abstract void e();

    public abstract void f(boolean z, int i);
}
