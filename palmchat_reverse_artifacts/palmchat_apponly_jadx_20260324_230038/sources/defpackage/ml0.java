package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public class ml0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ed0 f19261a;
    public boolean b;

    public ml0() {
        this(ed0.f17276a);
    }

    public synchronized void a() throws InterruptedException {
        while (!this.b) {
            wait();
        }
    }

    public synchronized void b() {
        boolean z = false;
        while (!this.b) {
            try {
                wait();
            } catch (InterruptedException unused) {
                z = true;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized boolean c() {
        boolean z;
        z = this.b;
        this.b = false;
        return z;
    }

    public synchronized boolean d() {
        return this.b;
    }

    public synchronized boolean e() {
        if (this.b) {
            return false;
        }
        this.b = true;
        notifyAll();
        return true;
    }

    public ml0(ed0 ed0Var) {
        this.f19261a = ed0Var;
    }
}
