package com.opos.exoplayer.core;

import android.os.Handler;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f8278a;
    private final a b;
    private final w c;
    private int d;
    private Object e;
    private Handler f;
    private int g;
    private long h = -9223372036854775807L;
    private boolean i = true;
    private boolean j;
    private boolean k;
    private boolean l;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(o oVar);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void a(int i, Object obj);
    }

    public o(a aVar, b bVar, w wVar, int i, Handler handler) {
        this.b = aVar;
        this.f8278a = bVar;
        this.c = wVar;
        this.f = handler;
        this.g = i;
    }

    public o a(int i) {
        com.opos.exoplayer.core.util.a.b(!this.j);
        this.d = i;
        return this;
    }

    public b b() {
        return this.f8278a;
    }

    public int c() {
        return this.d;
    }

    public Object d() {
        return this.e;
    }

    public Handler e() {
        return this.f;
    }

    public long f() {
        return this.h;
    }

    public int g() {
        return this.g;
    }

    public boolean h() {
        return this.i;
    }

    public o i() {
        com.opos.exoplayer.core.util.a.b(!this.j);
        if (this.h == -9223372036854775807L) {
            com.opos.exoplayer.core.util.a.a(this.i);
        }
        this.j = true;
        this.b.a(this);
        return this;
    }

    public synchronized boolean j() {
        com.opos.exoplayer.core.util.a.b(this.j);
        com.opos.exoplayer.core.util.a.b(this.f.getLooper().getThread() != Thread.currentThread());
        while (!this.l) {
            wait();
        }
        return this.k;
    }

    public o a(@Nullable Object obj) {
        com.opos.exoplayer.core.util.a.b(!this.j);
        this.e = obj;
        return this;
    }

    public w a() {
        return this.c;
    }

    public synchronized void a(boolean z) {
        this.k = z | this.k;
        this.l = true;
        notifyAll();
    }
}
