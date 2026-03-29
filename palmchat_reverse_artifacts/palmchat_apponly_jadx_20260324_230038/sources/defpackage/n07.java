package defpackage;

import android.os.SystemClock;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class n07 {
    public static long d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final tt6 f19406a;
    public boolean b = false;
    public final Runnable c;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            if (n07.this.b) {
                return;
            }
            n07.this.f19406a.s();
            long unused = n07.d = SystemClock.uptimeMillis();
            ih7.b().f(n07.this.c, 500L);
            x07.c(n07.d);
        }
    }

    public n07(tt6 tt6Var) {
        a aVar = new a();
        this.c = aVar;
        this.f19406a = tt6Var;
        ih7.b().f(aVar, 5000L);
    }

    public void b() {
        if (this.b) {
            return;
        }
        ih7.b().f(this.c, 5000L);
    }
}
