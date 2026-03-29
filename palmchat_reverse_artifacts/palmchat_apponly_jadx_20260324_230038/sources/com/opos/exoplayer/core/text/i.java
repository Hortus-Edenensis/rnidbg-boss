package com.opos.exoplayer.core.text;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.opos.exoplayer.core.ExoPlaybackException;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.decoder.DecoderInputBuffer;
import com.opos.exoplayer.core.util.m;
import com.opos.exoplayer.core.util.y;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class i extends com.opos.exoplayer.core.a implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f8346a;
    private final h b;
    private final e c;
    private final com.opos.exoplayer.core.j d;
    private boolean e;
    private boolean f;
    private int g;
    private Format h;
    private c i;
    private f j;
    private g k;
    private g l;
    private int m;

    public i(h hVar, Looper looper) {
        this(hVar, looper, e.f8341a);
    }

    private void b(List<Cue> list) {
        this.b.a(list);
    }

    private void v() {
        this.j = null;
        this.m = -1;
        g gVar = this.k;
        if (gVar != null) {
            gVar.e();
            this.k = null;
        }
        g gVar2 = this.l;
        if (gVar2 != null) {
            gVar2.e();
            this.l = null;
        }
    }

    private void w() {
        v();
        this.i.d();
        this.i = null;
        this.g = 0;
    }

    private void x() {
        w();
        this.i = this.c.b(this.h);
    }

    private long y() {
        int i = this.m;
        if (i == -1 || i >= this.k.b()) {
            return Long.MAX_VALUE;
        }
        return this.k.a(this.m);
    }

    private void z() {
        a(Collections.emptyList());
    }

    @Override // com.opos.exoplayer.core.r
    public int a(Format format) {
        return this.c.a(format) ? com.opos.exoplayer.core.a.a((com.opos.exoplayer.core.drm.b<?>) null, format.i) ? 4 : 2 : m.c(format.f) ? 1 : 0;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 0) {
            throw new IllegalStateException();
        }
        b((List<Cue>) message.obj);
        return true;
    }

    @Override // com.opos.exoplayer.core.a
    public void p() {
        this.h = null;
        z();
        w();
    }

    @Override // com.opos.exoplayer.core.q
    public boolean t() {
        return true;
    }

    @Override // com.opos.exoplayer.core.q
    public boolean u() {
        return this.f;
    }

    public i(h hVar, Looper looper, e eVar) {
        super(3);
        this.b = (h) com.opos.exoplayer.core.util.a.a(hVar);
        this.f8346a = looper == null ? null : new Handler(looper, this);
        this.c = eVar;
        this.d = new com.opos.exoplayer.core.j();
    }

    @Override // com.opos.exoplayer.core.q
    public void a(long j, long j2) throws ExoPlaybackException {
        boolean z;
        if (this.f) {
            return;
        }
        if (this.l == null) {
            this.i.a(j);
            try {
                this.l = this.i.b();
            } catch (d e) {
                String strA = y.a(e);
                ExoPlaybackException exoPlaybackExceptionA = ExoPlaybackException.a(e, r());
                exoPlaybackExceptionA.a(strA);
                throw exoPlaybackExceptionA;
            }
        }
        if (a_() != 2) {
            return;
        }
        if (this.k != null) {
            long jY = y();
            z = false;
            while (jY <= j) {
                this.m++;
                jY = y();
                z = true;
            }
        } else {
            z = false;
        }
        g gVar = this.l;
        if (gVar != null) {
            if (gVar.c()) {
                if (!z && y() == Long.MAX_VALUE) {
                    if (this.g == 2) {
                        x();
                    } else {
                        v();
                        this.f = true;
                    }
                }
            } else if (((com.opos.exoplayer.core.decoder.e) this.l).f8135a <= j) {
                g gVar2 = this.k;
                if (gVar2 != null) {
                    gVar2.e();
                }
                g gVar3 = this.l;
                this.k = gVar3;
                this.l = null;
                this.m = gVar3.a(j);
                z = true;
            }
        }
        if (z) {
            a(this.k.b(j));
        }
        if (this.g == 2) {
            return;
        }
        while (!this.e) {
            try {
                if (this.j == null) {
                    f fVarA = this.i.a();
                    this.j = fVarA;
                    if (fVarA == null) {
                        return;
                    }
                }
                if (this.g == 1) {
                    this.j.a_(4);
                    this.i.a(this.j);
                    this.j = null;
                    this.g = 2;
                    return;
                }
                int iA = a(this.d, (DecoderInputBuffer) this.j, false);
                if (iA == -4) {
                    if (this.j.c()) {
                        this.e = true;
                    } else {
                        f fVar = this.j;
                        fVar.d = this.d.f8252a.w;
                        fVar.h();
                    }
                    this.i.a(this.j);
                    this.j = null;
                } else if (iA == -3) {
                    return;
                }
            } catch (d e2) {
                String strA2 = y.a(e2);
                ExoPlaybackException exoPlaybackExceptionA2 = ExoPlaybackException.a(e2, r());
                exoPlaybackExceptionA2.a(strA2);
                throw exoPlaybackExceptionA2;
            }
        }
    }

    @Override // com.opos.exoplayer.core.a
    public void a(long j, boolean z) {
        z();
        this.e = false;
        this.f = false;
        if (this.g != 0) {
            x();
        } else {
            v();
            this.i.c();
        }
    }

    private void a(List<Cue> list) {
        Handler handler = this.f8346a;
        if (handler != null) {
            handler.obtainMessage(0, list).sendToTarget();
        } else {
            b(list);
        }
    }

    @Override // com.opos.exoplayer.core.a
    public void a(Format[] formatArr, long j) {
        Format format = formatArr[0];
        this.h = format;
        if (this.i != null) {
            this.g = 1;
        } else {
            this.i = this.c.b(format);
        }
    }
}
