package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public final class bg4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ag4 f1711a;
    public ag4 b;

    public synchronized void a(ag4 ag4Var) {
        try {
            if (ag4Var == null) {
                throw new NullPointerException("null cannot be enqueued");
            }
            ag4 ag4Var2 = this.b;
            if (ag4Var2 != null) {
                ag4Var2.c = ag4Var;
                this.b = ag4Var;
            } else {
                if (this.f1711a != null) {
                    throw new IllegalStateException("Head present, but no tail");
                }
                this.b = ag4Var;
                this.f1711a = ag4Var;
            }
            notifyAll();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized ag4 b() {
        ag4 ag4Var;
        ag4Var = this.f1711a;
        if (ag4Var != null) {
            ag4 ag4Var2 = ag4Var.c;
            this.f1711a = ag4Var2;
            if (ag4Var2 == null) {
                this.b = null;
            }
        }
        return ag4Var;
    }

    public synchronized ag4 c(int i) throws InterruptedException {
        if (this.f1711a == null) {
            wait(i);
        }
        return b();
    }
}
