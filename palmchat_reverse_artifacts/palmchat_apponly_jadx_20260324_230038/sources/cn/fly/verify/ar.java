package cn.fly.verify;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public abstract class ar implements Runnable {
    public abstract void a();

    public void a(Throwable th) {
    }

    public void b() {
        try {
            new Thread(this).start();
        } catch (Throwable unused) {
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            a();
        } catch (Throwable th) {
            a(th);
        }
    }
}
