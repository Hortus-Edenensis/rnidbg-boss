package defpackage;

import android.os.Handler;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class iv6 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler f18270a;
    public final long b;
    public final long c;

    public iv6(Handler handler, long j, long j2) {
        this.f18270a = handler;
        this.b = j;
        this.c = j2;
    }

    public void a() {
        long jC = c();
        Handler handler = this.f18270a;
        if (jC > 0) {
            handler.postDelayed(this, c());
        } else {
            handler.post(this);
        }
    }

    public void b(long j) {
        if (j > 0) {
            this.f18270a.postDelayed(this, j);
        } else {
            this.f18270a.post(this);
        }
    }

    public long c() {
        return this.b;
    }

    public long d() {
        return this.c;
    }
}
