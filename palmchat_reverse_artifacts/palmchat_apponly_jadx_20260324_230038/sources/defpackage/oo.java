package defpackage;

import java.util.logging.Level;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public final class oo implements Runnable, wk4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bg4 f19799a = new bg4();
    public final an1 b;
    public volatile boolean c;

    public oo(an1 an1Var) {
        this.b = an1Var;
    }

    @Override // defpackage.wk4
    public void a(an5 an5Var, Object obj) {
        ag4 ag4VarA = ag4.a(an5Var, obj);
        synchronized (this) {
            this.f19799a.a(ag4VarA);
            if (!this.c) {
                this.c = true;
                this.b.d().execute(this);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        ag4 ag4VarC;
        while (true) {
            try {
                ag4VarC = this.f19799a.c(1000);
            } catch (InterruptedException e) {
                this.b.e().b(Level.WARNING, Thread.currentThread().getName() + " was interruppted", e);
                return;
            } finally {
                this.c = false;
            }
            if (ag4VarC == null) {
                synchronized (this) {
                    ag4VarC = this.f19799a.b();
                    if (ag4VarC == null) {
                        return;
                    }
                    this.c = false;
                }
            }
            this.b.g(ag4VarC);
        }
    }
}
