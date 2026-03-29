package com.opos.exoplayer.core.upstream;

import android.os.Handler;
import android.support.v4.media.session.PlaybackStateCompat;
import com.opos.exoplayer.core.upstream.d;
import com.opos.exoplayer.core.util.t;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class j implements d, r<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f8379a;
    private final d.a b;
    private final t c;
    private final com.opos.exoplayer.core.util.e d;
    private int e;
    private long f;
    private long g;
    private long h;
    private long i;
    private long j;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f8380a;
        final /* synthetic */ long b;
        final /* synthetic */ long c;

        public a(int i, long j, long j2) {
            this.f8380a = i;
            this.b = j;
            this.c = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            j.this.b.a(this.f8380a, this.b, this.c);
        }
    }

    public j() {
        this(null, null);
    }

    @Override // com.opos.exoplayer.core.upstream.d
    public synchronized long a() {
        return this.j;
    }

    public j(Handler handler, d.a aVar) {
        this(handler, aVar, 2000);
    }

    public j(Handler handler, d.a aVar, int i) {
        this(handler, aVar, i, com.opos.exoplayer.core.util.e.f8390a);
    }

    private void a(int i, long j, long j2) {
        Handler handler = this.f8379a;
        if (handler == null || this.b == null) {
            return;
        }
        handler.post(new a(i, j, j2));
    }

    public j(Handler handler, d.a aVar, int i, com.opos.exoplayer.core.util.e eVar) {
        this.f8379a = handler;
        this.b = aVar;
        this.c = new t(i);
        this.d = eVar;
        this.j = -1L;
    }

    @Override // com.opos.exoplayer.core.upstream.r
    public synchronized void a(Object obj) {
        com.opos.exoplayer.core.util.a.b(this.e > 0);
        long jA = this.d.a();
        int i = (int) (jA - this.f);
        this.h += i;
        long j = this.i;
        long j2 = this.g;
        this.i = j + j2;
        if (i > 0) {
            this.c.a((int) Math.sqrt(j2), (8000 * j2) / r7);
            if (this.h >= 2000 || this.i >= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
                float fA = this.c.a(0.5f);
                this.j = Float.isNaN(fA) ? -1L : (long) fA;
            }
        }
        a(i, this.g, this.j);
        int i2 = this.e - 1;
        this.e = i2;
        if (i2 > 0) {
            this.f = jA;
        }
        this.g = 0L;
    }

    @Override // com.opos.exoplayer.core.upstream.r
    public synchronized void a(Object obj, int i) {
        this.g += (long) i;
    }

    @Override // com.opos.exoplayer.core.upstream.r
    public synchronized void a(Object obj, DataSpec dataSpec) {
        if (this.e == 0) {
            this.f = this.d.a();
        }
        this.e++;
    }
}
