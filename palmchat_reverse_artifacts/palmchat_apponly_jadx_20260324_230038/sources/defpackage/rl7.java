package defpackage;

import android.os.Handler;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class rl7 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler f20505a;
    public final long b;
    public final long c;

    public rl7(Handler handler, long j, long j2) {
        this.f20505a = handler;
        this.b = j;
        this.c = j2;
    }

    public long a() {
        return this.c;
    }

    public long b() {
        return this.b;
    }

    public void c() {
        if (b() > 0) {
            this.f20505a.postDelayed(this, b());
        } else {
            this.f20505a.post(this);
        }
    }

    public void d(long j) {
        if (j > 0) {
            this.f20505a.postDelayed(this, j);
        } else {
            this.f20505a.post(this);
        }
    }
}
