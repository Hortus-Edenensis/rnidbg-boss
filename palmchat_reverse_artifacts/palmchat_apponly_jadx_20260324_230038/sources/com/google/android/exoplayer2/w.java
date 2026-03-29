package com.google.android.exoplayer2;

import android.os.Looper;
import androidx.annotation.Nullable;
import defpackage.ed0;
import defpackage.vh;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f6046a;
    public final a b;
    public final ed0 c;
    public final e0 d;
    public int e;

    @Nullable
    public Object f;
    public Looper g;
    public int h;
    public long i = -9223372036854775807L;
    public boolean j = true;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void b(w wVar);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void handleMessage(int i, @Nullable Object obj) throws ExoPlaybackException;
    }

    public w(a aVar, b bVar, e0 e0Var, int i, ed0 ed0Var, Looper looper) {
        this.b = aVar;
        this.f6046a = bVar;
        this.d = e0Var;
        this.g = looper;
        this.c = ed0Var;
        this.h = i;
    }

    public synchronized boolean a(long j) throws InterruptedException, TimeoutException {
        boolean z;
        vh.g(this.k);
        vh.g(this.g.getThread() != Thread.currentThread());
        long jElapsedRealtime = this.c.elapsedRealtime() + j;
        while (true) {
            z = this.m;
            if (z || j <= 0) {
                break;
            }
            this.c.onThreadBlocked();
            wait(j);
            j = jElapsedRealtime - this.c.elapsedRealtime();
        }
        if (!z) {
            throw new TimeoutException("Message delivery timed out.");
        }
        return this.l;
    }

    public boolean b() {
        return this.j;
    }

    public Looper c() {
        return this.g;
    }

    public int d() {
        return this.h;
    }

    @Nullable
    public Object e() {
        return this.f;
    }

    public long f() {
        return this.i;
    }

    public b g() {
        return this.f6046a;
    }

    public e0 h() {
        return this.d;
    }

    public int i() {
        return this.e;
    }

    public synchronized boolean j() {
        return this.n;
    }

    public synchronized void k(boolean z) {
        this.l = z | this.l;
        this.m = true;
        notifyAll();
    }

    public w l() {
        vh.g(!this.k);
        if (this.i == -9223372036854775807L) {
            vh.a(this.j);
        }
        this.k = true;
        this.b.b(this);
        return this;
    }

    public w m(@Nullable Object obj) {
        vh.g(!this.k);
        this.f = obj;
        return this;
    }

    public w n(int i) {
        vh.g(!this.k);
        this.e = i;
        return this;
    }
}
