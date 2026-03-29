package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class q47 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f17 f20180a;

    public q47(f17 f17Var) {
        this.f20180a = f17Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f20180a.d();
        } catch (Exception e) {
            o87.c(e);
        }
    }
}
