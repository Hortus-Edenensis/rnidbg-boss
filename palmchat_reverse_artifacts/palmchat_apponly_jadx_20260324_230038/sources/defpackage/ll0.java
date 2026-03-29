package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class ll0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f19024a;

    public synchronized void a() throws InterruptedException {
        while (!this.f19024a) {
            wait();
        }
    }

    public synchronized void b() {
        this.f19024a = false;
    }

    public synchronized void c() {
        boolean z = this.f19024a;
        this.f19024a = true;
        if (!z) {
            notify();
        }
    }

    public synchronized void d(boolean z) {
        if (z) {
            c();
        } else {
            b();
        }
    }
}
