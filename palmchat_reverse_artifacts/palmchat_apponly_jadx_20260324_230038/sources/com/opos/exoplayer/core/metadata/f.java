package com.opos.exoplayer.core.metadata;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.opos.exoplayer.core.ExoPlaybackException;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.decoder.DecoderInputBuffer;
import com.opos.exoplayer.core.j;
import com.opos.exoplayer.core.util.y;
import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class f extends com.opos.exoplayer.core.a implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f8257a;
    private final e b;
    private final Handler c;
    private final j d;
    private final d e;
    private final Metadata[] f;
    private final long[] g;
    private int h;
    private int i;
    private a j;
    private boolean k;

    public f(e eVar, Looper looper) {
        this(eVar, looper, c.f8255a);
    }

    private void b(Metadata metadata) {
        this.b.a(metadata);
    }

    private void v() {
        Arrays.fill(this.f, (Object) null);
        this.h = 0;
        this.i = 0;
    }

    @Override // com.opos.exoplayer.core.r
    public int a(Format format) {
        if (this.f8257a.a(format)) {
            return com.opos.exoplayer.core.a.a((com.opos.exoplayer.core.drm.b<?>) null, format.i) ? 4 : 2;
        }
        return 0;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 0) {
            throw new IllegalStateException();
        }
        b((Metadata) message.obj);
        return true;
    }

    @Override // com.opos.exoplayer.core.a
    public void p() {
        v();
        this.j = null;
    }

    @Override // com.opos.exoplayer.core.q
    public boolean t() {
        return true;
    }

    @Override // com.opos.exoplayer.core.q
    public boolean u() {
        return this.k;
    }

    public f(e eVar, Looper looper, c cVar) {
        super(4);
        this.b = (e) com.opos.exoplayer.core.util.a.a(eVar);
        this.c = looper == null ? null : new Handler(looper, this);
        this.f8257a = (c) com.opos.exoplayer.core.util.a.a(cVar);
        this.d = new j();
        this.e = new d();
        this.f = new Metadata[5];
        this.g = new long[5];
    }

    @Override // com.opos.exoplayer.core.q
    public void a(long j, long j2) throws ExoPlaybackException {
        if (!this.k && this.i < 5) {
            this.e.a();
            if (a(this.d, (DecoderInputBuffer) this.e, false) == -4) {
                if (this.e.c()) {
                    this.k = true;
                } else if (!this.e.d_()) {
                    d dVar = this.e;
                    dVar.d = this.d.f8252a.w;
                    dVar.h();
                    try {
                        int i = (this.h + this.i) % 5;
                        this.f[i] = this.j.a(this.e);
                        this.g[i] = this.e.c;
                        this.i++;
                    } catch (b e) {
                        String strA = y.a(e);
                        ExoPlaybackException exoPlaybackExceptionA = ExoPlaybackException.a(e, r());
                        exoPlaybackExceptionA.a(strA);
                        throw exoPlaybackExceptionA;
                    }
                }
            }
        }
        if (this.i > 0) {
            long[] jArr = this.g;
            int i2 = this.h;
            if (jArr[i2] <= j) {
                a(this.f[i2]);
                Metadata[] metadataArr = this.f;
                int i3 = this.h;
                metadataArr[i3] = null;
                this.h = (i3 + 1) % 5;
                this.i--;
            }
        }
    }

    @Override // com.opos.exoplayer.core.a
    public void a(long j, boolean z) {
        v();
        this.k = false;
    }

    private void a(Metadata metadata) {
        Handler handler = this.c;
        if (handler != null) {
            handler.obtainMessage(0, metadata).sendToTarget();
        } else {
            b(metadata);
        }
    }

    @Override // com.opos.exoplayer.core.a
    public void a(Format[] formatArr, long j) {
        this.j = this.f8257a.b(formatArr[0]);
    }
}
